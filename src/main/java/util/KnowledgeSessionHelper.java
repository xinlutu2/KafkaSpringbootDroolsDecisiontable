package util;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.SLdroolsspringboot.SLService;

public class KnowledgeSessionHelper {
	
	static final Logger logger = LoggerFactory.getLogger(SLService.class);
	
	public static KieContainer createRuleBase() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.getKieClasspathContainer();
		return kc;
	}
	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kc, String sessionName) {
		StatelessKieSession kStatelessSession = kc.newStatelessKieSession(sessionName);
		return kStatelessSession;
	}
	public static KieSession getStatefulKnowledgeSession(KieContainer kc, String sessionName) {
		KieSession kStatefullSession = kc.newKieSession(sessionName);
		return kStatefullSession;
	}
	public static KieSession getStatefulKnowledgeSessionWithCallBack(KieContainer kc, String sessionName) {
		KieSession statefullSession = getStatefulKnowledgeSession(kc, sessionName);
		statefullSession.addEventListener(new RuleRuntimeEventListener() {			
			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {
				// TODO Auto-generated method stub
				logger.info("Object was updated \n" + event.getObject().toString());
			}
			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				// TODO Auto-generated method stub
				logger.info("Object inserted \n" + event.getObject().toString());
				
			}
			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				// TODO Auto-generated method stub
				logger.info("Object retracted \n"+event.getOldObject().toString());
			}
		});
		statefullSession.addEventListener(new AgendaEventListener() {
			@Override
			public void matchCreated(MatchCreatedEvent event) {
				// TODO Auto-generated method stub
				logger.info("The rule "+ event.getMatch().getRule().getName()+ " can be fired in agenda");
			}
			
			@Override
			public void matchCancelled(MatchCancelledEvent event) {
				// TODO Auto-generated method stub
				logger.info("The rule "+ event.getMatch().getRule().getName()+ " can no longer be in agenda");
			}
			
			@Override
			public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeMatchFired(BeforeMatchFiredEvent event) {
				// TODO Auto-generated method stub
				logger.info("The rule "+ event.getMatch().getRule().getName()+ " will be fired");
			}
			
			@Override
			public void agendaGroupPushed(AgendaGroupPushedEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterMatchFired(AfterMatchFiredEvent event) {
				// TODO Auto-generated method stub
				logger.info("The rule "+ event.getMatch().getRule().getName()+ " has been fired");
				//logger.debug("The rule "+ event.getMatch().getRule().getName()+ " has been fired");
			}
		});
		return statefullSession;
	}
}
