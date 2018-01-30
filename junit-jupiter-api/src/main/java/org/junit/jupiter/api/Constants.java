/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.api;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;
import static org.apiguardian.api.API.Status.STABLE;

import org.apiguardian.api.API;

/**
 * Shared constants.
 *
 * @since 5.1
 */
@API(status = STABLE, since = "5.1")
public class Constants {

	/**
	 * Script-related constants used by {@link DisabledIf} and {@link EnabledIf}.
	 *
	 * <p>Also declares names used for script {@link javax.script.Bindings bindings}.
	 */
	@API(status = EXPERIMENTAL, since = "5.1")
	public interface Script {

		String DEFAULT_ENGINE_NAME = "Nashorn";

		/**
		 * Names used for script {@link javax.script.Bindings bindings}.
		 */
		interface Bind {

			/**
			 * Set of all tags assigned to the current extension context.
			 *
			 * <p>Value type: {@code Set<String>}
			 *
			 * @see org.junit.jupiter.api.extension.ExtensionContext#getTags()
			 */
			String JUNIT_TAGS = "junitTags";

			/**
			 * Unique ID associated with the current extension context.
			 *
			 * <p>Value type: {@code String}
			 *
			 * @see org.junit.jupiter.api.extension.ExtensionContext#getUniqueId()
			 */
			String JUNIT_UNIQUE_ID = "junitUniqueId";

			/**
			 * Display name of the test or container.
			 *
			 * <p>Value type: {@code String}
			 *
			 * @see org.junit.jupiter.api.extension.ExtensionContext#getDisplayName()
			 */
			String JUNIT_DISPLAY_NAME = "junitDisplayName";

			/**
			 * Accessor for JUnit Platform configuration parameters.
			 *
			 * <p>Usage: {@code junitConfigurationParameter.get(key) -> String}
			 *
			 * @see org.junit.jupiter.api.extension.ExtensionContext#getConfigurationParameter(String)
			 */
			String JUNIT_CONFIGURATION_PARAMETER = "junitConfigurationParameter";

			/**
			 * Accessor for JVM system properties.
			 *
			 * <p>Usage: {@code systemProperty.get(key) -> String}
			 *
			 * @see System#getProperty(String)
			 */
			String SYSTEM_PROPERTY = "systemProperty";

			/**
			 * Accessor for operating system environment variables.
			 *
			 * <p>Usage: {@code systemEnvironment.get(key) -> String}
			 *
			 * @see System#getenv(String)
			 */
			String SYSTEM_ENVIRONMENT = "systemEnvironment";

		}

		/**
		 * Placeholders usable in reason format string.
		 */
		interface Reason {

			String DEFAULT_PATTERN = "Script `{source}` evaluated to: {result}";

			String ANNOTATION_PLACEHOLDER = "{annotation}";
			String RESULT_PLACEHOLDER = "{result}";
			String SOURCE_PLACEHOLDER = "{source}";
		}
	}

	private Constants() {
		/* no-op */
	}
}
