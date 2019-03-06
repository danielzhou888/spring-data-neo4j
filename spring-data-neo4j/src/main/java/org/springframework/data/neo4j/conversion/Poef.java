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

import org.neo4j.ogm.types.spatial.AbstractPoint;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.data.geo.Point;

public class Poef implements ConverterFactory<Point, AbstractPoint> {

	public Poef() {
		System.out.println("getting a new poef");
	}

	@Override
	public <T extends AbstractPoint> Converter<Point, T> getConverter(Class<T> targetType) {
		System.out.println("Please give me some " + targetType);
		return null;
	}



	/*
	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertibleTypes = new HashSet<>();
		convertibleTypes.add(new ConvertiblePair(Point.class, CartesianPoint2d.class));
		convertibleTypes.add(new ConvertiblePair(CartesianPoint2d.class, Point.class));

		return convertibleTypes;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		System.out.println("working on " + source);
		return null;
	}
	*/
}
