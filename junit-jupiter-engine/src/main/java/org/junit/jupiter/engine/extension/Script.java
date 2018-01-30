/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.engine.extension;

import static org.junit.jupiter.engine.Constants.Script.Reason.ANNOTATION_PLACEHOLDER;
import static org.junit.jupiter.engine.Constants.Script.Reason.RESULT_PLACEHOLDER;
import static org.junit.jupiter.engine.Constants.Script.Reason.SOURCE_PLACEHOLDER;

import java.lang.annotation.Annotation;
import java.util.Objects;

class Script {

	private final Class<? extends Annotation> type;
	private final String description;
	private final String engine;
	private final String source;
	private final String reason;
	private final int hashCode;

	Script(Annotation annotation, String engine, String source, String reason) {
		this(annotation.annotationType(), annotation.toString(), engine, source, reason);
	}

	Script(Class<? extends Annotation> type, String description, String engine, String source, String reason) {
		this.type = type;
		this.description = description;
		this.engine = engine;
		this.source = source;
		this.reason = reason;
		this.hashCode = computeHashCode();
	}

	/**
	 * Property {@link #reason} is not included on purpose.
	 */
	private int computeHashCode() {
		return Objects.hash(type.getTypeName(), engine, source);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		return hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	public int getHashCode() {
		return hashCode;
	}

	public String getDescription() {
		return description;
	}

	public String getEngine() {
		return engine;
	}

	public String getReason() {
		return reason;
	}

	public String getSource() {
		return source;
	}

	public Class<? extends Annotation> getAnnotationType() {
		return type;
	}

	public String toReasonString(String result) {
		return reason.replace(ANNOTATION_PLACEHOLDER, getDescription()) //
				.replace(SOURCE_PLACEHOLDER, getSource()) //
				.replace(RESULT_PLACEHOLDER, result);
	}

}
