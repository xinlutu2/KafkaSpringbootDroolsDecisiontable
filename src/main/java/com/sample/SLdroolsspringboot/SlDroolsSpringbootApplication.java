package com.sample.SLdroolsspringboot;

import javax.annotation.PostConstruct;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={"com.sample.SLdroolsspringboot","util"})
public class SlDroolsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlDroolsSpringbootApplication.class, args);
	}
	
	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}
	
	/*@Autowired
	private MessageSender msgSender;
	
	@PostConstruct
	public void run() throws Exception {
		SLPostingEvent event = new SLPostingEvent();
		event.setTrnType("LOAN_RGLR_PMT");
		event.setAcctngEventType("PRNCPL_PMT");
		event.setAcctngTrtmtID(1);
		event.setInsuredInd("Y");
		event.setAcctngEventAmt(100);
		//msgSender.sendToKafka("Hi!! I Am the producer in Spring Boot Application");
		msgSender.sendToKafka(event);
	}*/
}