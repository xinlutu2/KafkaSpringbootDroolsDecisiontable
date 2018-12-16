package com.sample.SLdroolsspringboot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import util.KnowledgeSessionHelper;

@Service
public class SLService {
	
	private final KieContainer kieContainer;
	static final Logger logger = LoggerFactory.getLogger(SLService.class);
	
	@Value("${processing.time.file}")
	private String processingTimeFileName;
	
	@Value("${output.file}")
	private String outputFileName;
	
	
	@Autowired
	public PostingEventWithAmountSign pstngEventWithSign;
	
	@Autowired
	public SLJournalEntry jrnlEntry;
	
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
	
	Calendar calendar = Calendar.getInstance();
	
	@KafkaListener(topics = "${spring.kafka.subscription.topic}")
	public void consume(@Payload SLPostingEvent message) {
		long inputTime = System.nanoTime();
		logger.debug("inputtime:"+inputTime);
		System.out.println("received data"+message);
		logger.info("Received data: "+message);
		pstngEventWithSign.copyDatatoNewOject(message);
		pstngEventWithSign.setAmtSignCd(message.getAcctngEventAmt());
		
		//Upon consuming the message, derive the amount sign code and populate the new object with respective values
		//Create a KieSession in order to fire drools rules
		KieSession kStatefulSession = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallBack(kieContainer, "ksession-rules");
		kStatefulSession.insert(pstngEventWithSign);
		logger.info("Posting Rule With Sign"+pstngEventWithSign);
		//Option 1: when SLJournalEntry fields are defined a static and output createOutput method is used to create o/p record 
		//(non-static fields) for serialization 
		kStatefulSession.setGlobal("slje", jrnlEntry);
		kStatefulSession.fireAllRules();
		logger.info("Output after firing rules:"+jrnlEntry);
		
		//Write output to a file. This functionality is temporary and being used for Demo purposes only
		try {
			writeToOutputFile(jrnlEntry);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//Once the rules are evaluated, send it to the new Kafka topic
		sendMsgToNewTopic(inputTime, jrnlEntry);
	  }
	
	public void sendMsgToNewTopic(long inputTime, SLJournalEntry jrnlEntry) {
		msgSender.sendToKafka(jrnlEntry);
		long finalTime = System.nanoTime();
		logger.info("inputtime:"+inputTime+"finaltime:"+finalTime);
		logger.info("Time to process and send back to kafka is:"+((finalTime-inputTime)/1000)+"microsecs");
		try {
			this.writeToOutputFile("Time to process and send back to kafka is "+((finalTime-inputTime)/1000000)+" millisecs");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToOutputFile(SLJournalEntry output) throws IOException{
		FileWriter fileWriter = new FileWriter(outputFileName, true);
		fileWriter.write(output.toString());
		fileWriter.write(System.lineSeparator());
		fileWriter.close();		
	}
	
	public void writeToOutputFile(String data) throws IOException{
		FileWriter fileWriter = new FileWriter(processingTimeFileName, true);
		fileWriter.write(data);
		fileWriter.write(System.lineSeparator());
		fileWriter.close();
		
	}
}
