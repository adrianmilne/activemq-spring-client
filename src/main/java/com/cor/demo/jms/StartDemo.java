package com.cor.demo.jms;

import java.io.Serializable;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cor.demo.jms.dispatcher.MessageDispatcher;

/**
 * Just a very simple template demo that will send a single Object Message to the JMS Broker and
 * Queue name defined in application.properties file. This is just for simple throwaway testing
 * purposes - designed as a starting point to develop on a case by case basis.
 */
public class StartDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Load spring config
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" });
        BeanFactory factory = (BeanFactory) appContext;

        // Send Message
        MessageDispatcher dispatcher = (MessageDispatcher) factory.getBean("messageDispatcher");
        dispatcher.sendMessageObject(getTestMessage());
    }

    /**
     * Generates the test message - overwrite with your own message.
     * @return The object message to be sent to the JMS Queue
     */
    private static Serializable getTestMessage() {

        return "MY TEST MESSAGE";
    }
}
