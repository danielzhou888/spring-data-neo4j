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
package org.springframework.data.neo4j.conversion;

import java.util.Optional;

import org.neo4j.ogm.typeconversion.AttributeConverter;
import org.neo4j.ogm.types.spatial.GeographicPoint2d;
import org.springframework.data.geo.Point;

class GeographicPointConverter implements AttributeConverter<Point, GeographicPoint2d> {

	@Override
	public GeographicPoint2d toGraphProperty(Point value) {

		return Optional.ofNullable(value)
				.map(p -> new GeographicPoint2d(value.getY(), value.getX()))
				.orElse(null);
	}

	@Override
	public Point toEntityAttribute(GeographicPoint2d value) {

		return Optional.ofNullable(value)
				.map(p -> new Point(value.getLatitude(), value.getLongitude()))
				.orElse(null);
	}
}
