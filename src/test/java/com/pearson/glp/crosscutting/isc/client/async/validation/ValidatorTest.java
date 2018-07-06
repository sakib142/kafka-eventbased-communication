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

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pearson.glp.crosscutting.isc.client.async.exception.AsyncException;

/**
 * The ValidatorTest class.
 * 
 *<p>The class validate the event name.
 * 
 * @author jeevansingh.dhami
 *
 */
public class ValidatorTest {
	 /**
     * ValidatorTest instantiate.
     */
    public ValidatorTest() {
        super();
    }
    /**
     * The instance variable eventName.
     */
    private String eventName = "hello test";

    /**
     * The inject mock object of Validator.
     */
    @InjectMocks
    private Validator validator;

    /**
     * Setup and mocking required the object.
     */
    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);

    }

    /**
     * The method test event name not null.
     * 
     * @throws AsyncException manual exception
     */
    @Test(expectedExceptions = AsyncException.class)
    public void testValidateEventNameNotNull() throws AsyncException {
        this.eventName = null;
        String result = this.validator.validate(this.eventName);

        Assert.assertNotNull(result, "Event name cannot be null or blank");

    }

    /**
     * The method test event name having no space.
     * 
     *<p>The validate method remove the space from string.
     * 
     * @throws AsyncException manual exception
     */
    @Test
    public void testValidateEventNameHavingSpace() throws AsyncException {
        this.eventName = "hello test";
        String result = this.validator.validate(this.eventName);

        Assert.assertEquals(result, "hello_test");

    }

    /**
     * The method test event name having no special character.
     * 
     *<p>The validate method remove the special character from string.
     * 
     * @throws AsyncException manual exception
     */
    @Test(expectedExceptions = AsyncException.class)
    public void testValidateEventNameHavingSpecialCharacterWithException()
            throws AsyncException {
        this.eventName = "            hello test  @#$^&**^%     ";

        String result = this.validator.validate(this.eventName);

        Assert.assertEquals(result,
                "Event name contains special characters. Only ^[a-zA-Z0-9_-]*$"
                        + " is allowed");

    }

}
