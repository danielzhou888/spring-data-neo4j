/*
 * Copyright 2011-2019 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.neo4j.repositories.support;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.testutil.MultiDriverTestClass;
import org.springframework.aop.framework.Advised;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.support.Neo4jRepositoryFactory;
import org.springframework.data.neo4j.repository.support.SimpleNeo4jRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Unit tests for {@code GraphRepositoryFactory}.
 *
 * @author Vince Bickers
 * @author Luanne Misquitta
 * @author Mark Angrish
 */
@RunWith(MockitoJUnitRunner.class)
public class GraphRepositoryFactoryIT extends MultiDriverTestClass {

	Neo4jRepositoryFactory factory;

	@Mock org.neo4j.ogm.session.Session session;

	@Before
	public void setUp() {

		factory = new Neo4jRepositoryFactory(session) {

		};
	}

	/**
	 * Assert that the instance created for the standard configuration is a valid {@code UserRepository}.
	 *
	 * @throws Exception
	 */
	@Test
	public void setsUpBasicInstanceCorrectly() throws Exception {
		assertNotNull(factory.getRepository(ObjectRepository.class));
	}

	@Test
	public void allowsCallingOfObjectMethods() {

		ObjectRepository repository = factory.getRepository(ObjectRepository.class);

		repository.hashCode();
		repository.toString();
		repository.equals(repository);
	}

	@Test
	public void usesConfiguredRepositoryBaseClass() {
		factory.setRepositoryBaseClass(CustomNeo4jRepository.class);
		ObjectRepository repository = factory.getRepository(ObjectRepository.class);
		assertEquals(CustomNeo4jRepository.class, ((Advised) repository).getTargetClass());
	}

	private interface ObjectRepository extends Neo4jRepository<Object, Long> {

		@Override
		@Transactional
		Object findOne(Long id);
	}

	static class CustomNeo4jRepository<T, ID extends Serializable> extends SimpleNeo4jRepository<T, ID> {

		public CustomNeo4jRepository(Class<T> clazz, Session session) {
			super(clazz, session);
		}
	}
}