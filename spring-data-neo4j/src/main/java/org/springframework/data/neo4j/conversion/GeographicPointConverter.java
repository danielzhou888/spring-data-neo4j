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
