package com.github.galcyurio.eventbus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EnableEventBus;
import org.vaadin.spring.events.support.ApplicationContextEventBroker;

/**
 * @author galcyurio
 */
@Configuration
@EnableEventBus
public class EventBusConfig {

    @Bean
    ApplicationContextEventBroker applicationContextEventBroker(EventBus.ApplicationEventBus eventBus) {
        return new ApplicationContextEventBroker(eventBus);
    }
}
