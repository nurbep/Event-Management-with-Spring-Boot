package mum.ea.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import mum.ea.domain.Event;

@Component
public class Sender  implements MessageSender{

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String destination, Object message) {
		LOGGER.info("sending message='{}' to destination='{}'", message, destination);
		jmsTemplate.convertAndSend(destination, (Serializable) message);
	}

	@Value("${jsa.activemq.queue.producer}")
	String queue;

	public void send(Object event) {
		/*jmsTemplate.convertAndSend(queue, (Serializable) event, new MessagePostProcessor() {
			public Message postProcessMessage(Message message) throws JMSException {
				//message.setObjectProperty("event", (Serializable) event);
				return message;
			}
		});*/
		// System.out.println("$$$$$$$$$$$$$$");
		
		  jmsTemplate.setDefaultDestinationName(queue);
		  jmsTemplate.send(session -> session.createObjectMessage((Serializable) event));
		 
	}
}
