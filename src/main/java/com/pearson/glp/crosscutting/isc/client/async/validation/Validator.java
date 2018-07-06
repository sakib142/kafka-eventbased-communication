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
package com.pearson.glp.crosscutting.isc.client.async.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pearson.glp.crosscutting.isc.client.async.exception.AsyncException;

/**
 * The Validator class.
 * 
 * @author jeevansingh.dhami
 *
 */
@Component
public class Validator {
    /**
     * Validator instantiate.
     */
    public Validator() {
        super();
    }

    /**
     * Object of Logger class.
     */
    public static final Logger LOGGER =
            LoggerFactory.getLogger(Validator.class);
    
    /**
     * The allowed character in topic.
     */
    private static final String ALLOWED_PATTERN = "^[a-zA-Z0-9_-]*$";

    /**
     * The method used to validate event name.
     * 
     * @param eventName
     *            name of event
     * @return string event name
     * @throws AsyncException
     *             manual exception
     */
    public String validate(String eventName) throws AsyncException {
        LOGGER.debug("In validate()");
        String validatedEventName = eventName;
        validatedEventName =
                this.formatStringHavingWhiteSpace(validatedEventName);
        if (this.hasNoSpecialCharacters(validatedEventName)) {
            return validatedEventName;
        } else {
            throw new AsyncException(
                    "Event name contains special characters. Only "
                            + ALLOWED_PATTERN + " is allowed");
        }

    }
    
    /**
     * The method remove the whitespace from string.
     * 
     * @param eventName name of event
     * @return the string 
     * @throws AsyncException manual exception
     */
    private String formatStringHavingWhiteSpace(String eventName)
            throws AsyncException {
        LOGGER.debug("In formatStringHavingWhiteSpace()");

        if (eventName == null
                || eventName.trim().isEmpty()) {
            throw new AsyncException("Event name cannot be null or blank");
        }
        return eventName.replaceAll("^\\s+", "").replaceAll("\\s+$", "")
                .replaceAll("\\s+", "_");
    }

    /**
     * The method check special characters in string.
     * 
     * @param eventName name of event
     * @return boolean value
     */
    private boolean hasNoSpecialCharacters(String eventName) {
        LOGGER.debug("In hasNoSpecialCharacters()");

        String validatedEventName = eventName;

        Pattern pattern = Pattern.compile(ALLOWED_PATTERN);
        Matcher matcher = pattern.matcher(validatedEventName);

        return matcher.matches();

    }

}
