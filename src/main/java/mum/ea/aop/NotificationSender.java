package mum.ea.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mum.ea.domain.Event;
import mum.ea.jms.Sender;

@Aspect
@Component
public class NotificationSender {

	@Autowired
	private Sender sender;

	@After("execution(* mum.ea.service.EventService.updateEvent(mum.ea.domain.Event)) && args(event)")
	public void pushEmailToQueue(JoinPoint jp, Event event) {

		System.out.println("**************************");
		System.out.println(event.getName() + "Mail sending Queue");
		System.out.println("************************************");

		sender.send(event);
	}

	@Before("execution(* mum.ea.service.EventService.*(..))")
	public void logResource(JoinPoint joinPoint) {
		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
		System.out.println();
		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName() + "    **********");
	}

}
