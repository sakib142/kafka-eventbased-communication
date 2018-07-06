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

import static org.junit.Assert.assertNotNull;

import org.mockito.InjectMocks;
import org.testng.annotations.Test;

/**
 * The IscPropertiesLoaderTest class.
 * 
 * @author jeevansingh.dhami
 *
 */
public class IscPropertiesLoaderTest {

    
    /**
     * IscPropertiesLoaderTest instantiate.
     */
    public IscPropertiesLoaderTest() {
        super();
    }

    /**
     * Inject mock object of IscPropertiesLoader.
     */
    @InjectMocks
    private IscPropertiesLoader conf;

    /**
     * The method test property object null or not.
     */
    @Test
    private void propertySourcesPlaceholderConfigurerTest() {
        assertNotNull("IscPropertiesLoader object cannt null.",
                this.conf.propertySourcesPlaceholderConfigurer());

    }

}
