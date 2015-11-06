/*
 * Copyright 2015 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.launcher.listeners;

import java.util.function.Consumer;

import lombok.Data;

import org.junit.gen5.engine.TestDescriptor;
import org.junit.gen5.engine.TestEngine;
import org.junit.gen5.launcher.TestPlan;
import org.junit.gen5.launcher.TestPlanExecutionListener;

@Data
public class LoggingListener implements TestPlanExecutionListener {

	private Consumer<String> logger = (aString -> System.out.println(aString));

	private void log(String logString, Object... args) {
		logger.accept("> " + String.format(logString, args));
	}

	@Override
	public void testPlanExecutionStarted(TestPlan testPlan) {
		log("testPlanExecutionStarted: %s", testPlan);
	}

	@Override
	public void testPlanExecutionPaused(TestPlan testPlan) {
		log("testPlanExecutionPaused: %s", testPlan);
	}

	@Override
	public void testPlanExecutionRestarted(TestPlan testPlan) {
		log("testPlanExecutionRestarted: %s", testPlan);
	}

	@Override
	public void testPlanExecutionStopped(TestPlan testPlan) {
		log("testPlanExecutionStopped: %s", testPlan);
	}

	@Override
	public void testPlanExecutionFinished(TestPlan testPlan) {
		log("testPlanExecutionFinished: %s", testPlan);
	}

	@Override
	public void testPlanExecutionStartedOnEngine(TestPlan testPlan, TestEngine testEngine) {
		log("testPlanExecutionStartedOnEngine: %s %s", testPlan, testEngine);
	}

	@Override
	public void testPlanExecutionFinishedOnEngine(TestPlan testPlan, TestEngine testEngine) {
		log("testPlanExecutionFinishedOnEngine: %s %s", testPlan, testEngine);
	}

	@Override
	public void dynamicTestFound(TestDescriptor testDescriptor) {
		log("dynamicTestFound: %s - %s", testDescriptor.getDisplayName(), testDescriptor.getUniqueId());
	}

	@Override
	public void testStarted(TestDescriptor testDescriptor) {
		log("testStarted: %s - %s", testDescriptor.getDisplayName(), testDescriptor.getUniqueId());
	}

	@Override
	public void testSkipped(TestDescriptor testDescriptor, Throwable t) {
		log("testSkipped: %s - %s - %s", testDescriptor.getDisplayName(), testDescriptor.getUniqueId(), t.getMessage());
	}

	@Override
	public void testAborted(TestDescriptor testDescriptor, Throwable t) {
		log("testAborted: %s - %s - %s", testDescriptor.getDisplayName(), testDescriptor.getUniqueId(), t.getMessage());
	}

	@Override
	public void testFailed(TestDescriptor testDescriptor, Throwable t) {
		log("testFailed: %s - %s - %s", testDescriptor.getDisplayName(), testDescriptor.getUniqueId(), t.getMessage());
	}

	@Override
	public void testSucceeded(TestDescriptor testDescriptor) {
		log("testSucceeded: %s - %s", testDescriptor.getDisplayName(), testDescriptor.getUniqueId());
	}
}
