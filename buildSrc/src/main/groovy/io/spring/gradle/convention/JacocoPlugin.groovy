/*
 * Copyright 2022-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.spring.gradle.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin

/**
 * Applies the Jacoco Gradle {@link Plugin} to the target Gradle {@link Project}
 * and configures {@literal check} Gradle Task to depend on the {@literal jacocoTestReport} Gradle Task.
 *
 * @author Rob Winch
 * @author John Blum
 * @see org.gradle.api.Plugin
 * @see org.gradle.api.Project
 */
class JacocoPlugin implements Plugin<Project> {

	private static final String JACOCO_VERSION = '0.8.7';

	@Override
	void apply(Project project) {

		project.plugins.withType(JavaPlugin) {

			project.getPluginManager().apply("jacoco")
			project.tasks.check.dependsOn project.tasks.jacocoTestReport

			project.jacoco {
				toolVersion = JACOCO_VERSION
			}
		}
	}
}
