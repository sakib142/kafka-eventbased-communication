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
package com.pearson.glp.crosscutting.isc.client.async.model;

/**
 * The EventMessage class.
 * 
 * @author jeevansingh.dhami
 *
 */
public class EventMessage {
    /**
     * EventMessage instantiate.
     */
    public EventMessage() {
        super();
    }

    /**
     * The instance variable id.
     */
    private String id;

    /**
     * The instance variable timestamp.
     */
    private String timestamp;

    /**
     * The instance variable eventName.
     */
    private String eventName;

    /**
     * The instance variable payload.
     */
    private String payload;

    /**
     * Get id.
     * 
     * @return string id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set id.
     * 
     * @param id
     *            value of id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get timestamp.
     * 
     * @return string time
     */
    public String getTimestamp() {
        return this.timestamp;
    }

    /**
     * Set time.
     * 
     * @param timestamp
     *            value in time
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Get event name.
     * 
     * @return string get event name
     */
    public String getEventName() {
        return this.eventName;
    }

    /**
     * Set event name.
     * 
     * @param eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Get payload.
     * 
     * @return string payload value
     */
    public String getPayload() {
        return this.payload;
    }

    /**
     * Set payload.
     * 
     * @param payload
     *            value of payload
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

}
