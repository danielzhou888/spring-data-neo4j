package org.springframework.data.neo4j.nativetypes;

import static org.springframework.data.neo4j.nativetypes.SpatialPersistenceContextConfiguration.*;

import org.assertj.core.api.Assertions;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.testutil.MultiDriverTestClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.geo.Point;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {SpatialPersistenceContextConfiguration.class, SpatialConversionTests.Poef.class})
@RunWith(SpringRunner.class)
public class SpatialConversionTests  {

	@Autowired
	private Configuration configuration;

	@Autowired
	private SpatialDomainRepository repository;


	@Test
	@Ignore
	public void stuffShouldWork() {

		final Point neo4j = new Point(12.994823, 55.612191);

		SpatialDomain domainObject = new SpatialDomain();
		domainObject.setSdnPoint(neo4j);
		domainObject = repository.save(domainObject);

		SpatialDomain reloadedDomainObject = repository.findById(domainObject.getId()).get();

		Assertions.assertThat(reloadedDomainObject.getSdnPoint()).isEqualTo(neo4j);
	}

	@org.springframework.context.annotation.Configuration
	static class Poef {
		@Bean
		public ConversionService conversionService2() {
			return DefaultConversionService.getSharedInstance();
		}
	}
}
