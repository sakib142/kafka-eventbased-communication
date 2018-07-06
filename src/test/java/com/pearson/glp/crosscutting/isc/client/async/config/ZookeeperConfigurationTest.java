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
package com.pearson.glp.crosscutting.isc.client.async.config;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The ZookeeperConfigurationTest class.
 * 
 * @author jeevansingh.dhami
 *
 */
public class ZookeeperConfigurationTest {
    
    
	/**
     * ZookeeperConfigurationTest instantiate.
     */
    public ZookeeperConfigurationTest() {
        super();
    }
    /**
     * The reference variable of ZookeeperConfiguration. 
     */
    private ZookeeperConfiguration configuration;

    /**
     * Setup and mocking required the object.
     */
    @BeforeClass
    public void setUp() {
        this.configuration = new ZookeeperConfiguration();
    }

    /**
     * The method test the configuration.
     */
    @Test
    private void testZookeeperConfiguration() {
        Assert.assertNotNull(this.configuration);
    }
}
