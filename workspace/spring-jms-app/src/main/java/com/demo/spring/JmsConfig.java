package com.demo.spring;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
		cf.setBrokerURL("tcp://localhost:61616");
		return cf;
	}

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory cf) {
		JmsTemplate jt = new JmsTemplate();
		//jt.setDefaultDestinationName("testQueue");
		jt.setPubSubDomain(true);
		jt.setConnectionFactory(cf);
		return jt;
	}
}
