/*
 * Cerberus  Copyright (C) 2013  vertigo17
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This file is part of Cerberus.
 *
 * Cerberus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cerberus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cerberus.dto;

import java.util.HashMap;
import java.util.List;
import org.cerberus.crud.entity.Application;
import org.cerberus.crud.entity.TestCase;

/**
 *
 * @author memiks
 */
public class TestCaseWithExecution extends TestCase {

    private long statusExecutionID;
    private String environment;
    private String country;
    private String browser;
    private String start;
    private String end;
    private String controlStatus;
    private String controlMessage;
    private Application applicationObject;

    public TestCaseWithExecution() {
        super();
    }

    public TestCaseWithExecution(TestCase testCase) {

        super();

        this.setTest(testCase.getTest());
        this.setTestCase(testCase.getTestCase());
        this.setOrigine(testCase.getOrigine());
        this.setRefOrigine(testCase.getRefOrigine());
        this.setUsrCreated(testCase.getUsrCreated());
        this.setImplementer(testCase.getImplementer());
        this.setUsrModif(testCase.getUsrModif());
        this.setProject(testCase.getProject());
        this.setTicket(testCase.getTicket());
        this.setFunction(testCase.getFunction());
        this.setApplication(testCase.getApplication());
        this.setActiveQA(testCase.getActiveQA());
        this.setActiveUAT(testCase.getActiveUAT());
        this.setActivePROD(testCase.getActivePROD());
        this.setPriority(testCase.getPriority());
        this.setGroup(testCase.getGroup());
        this.setStatus(testCase.getStatus());
        this.setDescription(testCase.getDescription());
        this.setBehaviorOrValueExpected(testCase.getBehaviorOrValueExpected());
        this.setHowTo(testCase.getHowTo());
        this.setTcActive(testCase.getTcActive());
        this.setFromBuild(testCase.getFromBuild());
        this.setFromRev(testCase.getFromRev());
        this.setToBuild(testCase.getToBuild());
        this.setToRev(testCase.getToRev());
        this.setLastExecutionStatus(testCase.getLastExecutionStatus());
        this.setBugID(testCase.getBugID());
        this.setTargetBuild(testCase.getTargetBuild());
        this.setTargetRev(testCase.getTargetRev());
        this.setComment(testCase.getComment());
        this.setDateCreated(testCase.getDateCreated());

        this.statusExecutionID = 0L;
        this.start = "";
        this.end = "";
        this.controlStatus = "NE";
        this.controlMessage = "Not Executed";
    }

    public long getStatusExecutionID() {
        return statusExecutionID;
    }

    public void setStatusExecutionID(long statusExecutionID) {
        this.statusExecutionID = statusExecutionID;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public String getControlMessage() {
        return controlMessage;
    }

    public void setControlMessage(String controlMessage) {
        this.controlMessage = controlMessage;
    }

    public Application getApplicationObject() {
        return applicationObject;
    }

    public void setApplicationObject(Application applicationObject) {
        this.applicationObject = applicationObject;
    }

    public static final HashMap<String, TestCaseWithExecution> generateEmptyResultOfExecutions(List<TestCase> listOfTestCases, String[] environments, String[] countries, String[] browsers) {
        HashMap<String, TestCaseWithExecution> result = new HashMap<String, TestCaseWithExecution>();
        String key;
        TestCaseWithExecution testCaseWithExecution;
        for (String browser : browsers) {
            for (String country : countries) {
                for (String environment : environments) {
                    for (TestCase testCase : listOfTestCases) {
                        key = browser + "_" + country + "_" + environment + "_"
                                + testCase.getTest() + "_" + testCase.getTestCase();
                        if (!result.containsKey(key)) {
                            testCaseWithExecution = new TestCaseWithExecution(testCase);
                            testCaseWithExecution.setBrowser(browser);
                            testCaseWithExecution.setCountry(country);
                            testCaseWithExecution.setEnvironment(environment);

                            result.put(key, testCaseWithExecution);
                        }
                    }
                }
            }
        }

        return result;
    }
}
