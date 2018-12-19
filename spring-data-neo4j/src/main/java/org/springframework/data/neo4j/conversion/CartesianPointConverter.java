package org.springframework.data.neo4j.conversion;

import java.util.Optional;

import org.neo4j.ogm.typeconversion.AttributeConverter;
import org.neo4j.ogm.types.spatial.CartesianPoint2d;
import org.springframework.data.geo.Point;

public class CartesianPointConverter implements AttributeConverter<Point, CartesianPoint2d> {

	@Override
	public CartesianPoint2d toGraphProperty(Point value) {

		return Optional.ofNullable(value)
				.map(p -> new CartesianPoint2d(value.getY(), value.getX()))
				.orElse(null);
	}

	@Override
	public Point toEntityAttribute(CartesianPoint2d value) {

		return Optional.ofNullable(value)
				.map(p -> new Point(value.getX(), value.getY()))
				.orElse(null);
	}
}
