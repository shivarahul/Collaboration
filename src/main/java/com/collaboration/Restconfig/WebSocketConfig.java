package com.collaboration.Restconfig;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	
	private StompEndpointRegistry registry;

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) 
	{
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}
	
	public void registerStompEndpoints(StompEndpointRegistry arg0) {
	
		registry.addEndpoint("/chat").withSockJS();
	}

}
