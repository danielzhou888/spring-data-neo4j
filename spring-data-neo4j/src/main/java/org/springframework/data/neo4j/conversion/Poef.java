package org.springframework.data.neo4j.conversion;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.types.spatial.AbstractPoint;
import org.neo4j.ogm.types.spatial.CartesianPoint2d;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.GenericConverter;
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
