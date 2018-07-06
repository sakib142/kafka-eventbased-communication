/*
 * PEARSON PROPRIETARY AND CONFIDENTIAL INFORMATION SUBJECT TO NDA 
 * Copyright (c) 2017 Pearson Education, Inc.
 * All Rights Reserved. 
 * 
 * NOTICE: All information contained herein is, and remains the property of 
 * Pearson Education, Inc. The intellectual and technical concepts contained 
 * herein are proprietary to Pearson Education, Inc. and may be covered by U.S. 
 * and Foreign Patents, patent applications, and are protected by trade secret 
 * or copyright law. Dissemination of this information, reproduction of this  
 * material, and copying or distribution of this software is strictly forbidden
 * unless prior written permission is obtained from Pearson Education, Inc.
 */
package com.pearson.glp.crosscutting.isc.client.async.dao;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pearson.glp.crosscutting.isc.client.async.cache.TopicCache;
import com.pearson.glp.crosscutting.isc.client.async.config.ZookeeperConfiguration;
import com.pearson.glp.crosscutting.isc.client.async.exception.AsyncException;
import com.pearson.glp.crosscutting.isc.client.async.validation.Validator;

/**
 * The IscTopicProvider class.
 * 
 *<p>This class responsible for validate or managing topics. 
 * 
 * @author jeevansingh.dhami
 *
 */
@Component
public class IscTopicProvider {

	/**
	 * ZookeeperConfiguration instantiate. 
	 */
    public IscTopicProvider() {
        super();
    }

    /**
     * Object of Logger class.
     */
    public static final Logger LOGGER =
            LoggerFactory.getLogger(IscTopicProvider.class);

    /**
     * Instance of ZookeeperConfiguration class.
     */
    @Autowired
    private ZookeeperConfiguration zookeeperConfiguration;

    /**
     * Instance of TopicCache class.
     */
    @Autowired
    private TopicCache topicCache;

    /**
     * Instance of Validator class.
     */
    @Autowired
    private Validator validator;

    private String defaultTopicName = "deadletter";

    /**
     * The method used to get topic name.
     * 
     * @param eventName
     *            name of event
     * @return string name of topic
     * @throws AsyncException
     *             manual exception
     */
    public String getTopicFromEventName(String eventName)
            throws AsyncException {
        String topicName;
        topicName = this.validator.validate(eventName);
        topicName = this.deriveTopicFromEventName(topicName);
        return topicName;

    }

    /**
     * The method used register topic.
     * 
     * @param eventName
     *            name of event
     * @throws AsyncException
     *             manual exception
     */
    public void registerTopic(String eventName) throws AsyncException {

        String topicName = this.getTopicFromEventName(eventName);
        this.topicCache.getRegisterMap().putIfAbsent(eventName, topicName);

        if (this.zookeeperConfiguration.isTopicExist(topicName)) {
            throw new AsyncException("Event name already registered");
        } else {
            this.zookeeperConfiguration.createTopic(topicName);
        }

    }
    
    /**
     * The method used to register topic.
     * 
     * @param eventNameSet
     *            set of event name
     * @throws AsyncException
     *             manual exception
     */
    public void registerTopic(Set<String> eventNameSet) throws AsyncException {
        String topicName;
        for (String eventName : eventNameSet) {
            topicName = this.getTopicFromEventName(eventName);

            this.topicCache.getRegisterMap().putIfAbsent(eventName, topicName);
            if (!this.zookeeperConfiguration.isTopicExist(topicName)) {
                this.zookeeperConfiguration.createTopic(topicName);
            }
        }

    }

    private String deriveTopicFromEventName(String validatedEventName) {

        String topicName = validatedEventName.concat("_Topic");
        return topicName;
    }

    /**
     * The method used to get topic name.
     * 
     * @param eventName
     *            name of event
     * @return string topic name
     * @throws AsyncException
     *             manual exception
     */
    public String getTopicNameFromCache(String eventName)
            throws AsyncException {
    	Map<String,String> registerMap  =this.topicCache.getRegisterMap();
        String validatedEventName = this.validator.validate(eventName);
        if (registerMap.containsKey(validatedEventName)) {
            return registerMap.get(validatedEventName);
        } else {
            return this.defaultTopicName;
        }
    }

    
}
