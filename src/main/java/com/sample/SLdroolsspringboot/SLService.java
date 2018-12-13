package com.sample.SLdroolsspringboot;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import util.KnowledgeSessionHelper;
import util.OutputFormat;

@Service
public class SLService {
	
	private final KieContainer kieContainer;
	
	@Autowired 
	public SLPostingEvent pstngEvent;
	
	@Autowired
	public PostingEventWithAmountSign pstngEventWithSign;
	
	@Autowired
	public SLJournalEntry jrnlEntry;
	
	@Autowired
	public OutputFormat output;
	
	@Autowired
	private MessageSender msgSender;
	
	@Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }
	
	@Autowired
	public SLService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
		
	@KafkaListener(topics = "${spring.kafka.subscription.topic}")
	public void consume(@Payload SLPostingEvent message) {
		System.out.println("received data"+message);
		
		//Upon consuming the message, derive the amount sign code and populate the new object with respective values
		pstngEventWithSign = pstngEventWithSign.createPstngEvntWithSign(message);
		pstngEventWithSign.setAmtSignCd(pstngEventWithSign.populateAmtSignCd(message.getAcctngEventAmt()));
		System.out.println("new object details:"+pstngEventWithSign.toString());
		
		/*double acctngEventAmt = message.getAcctngEventAmt();
		double newAcctngAmt = message.isValuePositive(acctngEventAmt);
		message.setAcctngEventAmt(newAcctngAmt);
		System.out.println("Input message after updating the Accounting event amount: "+message.toString());*/
		
		//Create a KieSession in order to fire drools rules
		KieSession kStatefulSession = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallBack(kieContainer, "ksession-rules");
		kStatefulSession.insert(pstngEventWithSign);
		//Option 1: when SLJournalEntry fields are defined a static and output createOutput method is used to create o/p record 
		//(non-static fields) for serialization 
		kStatefulSession.insert(jrnlEntry);
		kStatefulSession.fireAllRules();
		System.out.println("Output after firing rules:"+jrnlEntry);
		
		//Once the rules are evaluated, create output record and send it to the new Kafka topic
		output.createOutput(jrnlEntry);
		System.out.println("Output format: "+output.toString());
		sendMsgToNewTopic(output);
	  }
	
	public void sendMsgToNewTopic(OutputFormat outputFromDrools) {
		msgSender.sendToKafka(outputFromDrools);
	}
}
