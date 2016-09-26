package net.rentalhost.games.craft.GameWorld;

import net.rentalhost.games.craft.Positioning.Point2D;

import java.util.HashMap;
import java.util.Random;

public class Dimension {
    /** The Universe of this Dimension. */
    public Universe universe;

    /** The DimensionID. */
    private String id;
    private Random generator;

    /** The Regions of this Dimension. */
    private HashMap<Point2D, Region> regions;

    /** Instantiate a new Dimension. */
    Dimension(Universe paramUniverse, String paramId) {
        universe = paramUniverse;
        id = paramId;
        generator = new Random(universe.generator.nextLong() + paramId.hashCode());
        regions = new HashMap<>();
    }

    /** Initialize a Region by Point on this Dimension. */
    private void initializeRegion(Point2D paramPoint) {
        if (!regions.containsKey(paramPoint)) {
            regions.put(paramPoint, new Region(this, paramPoint));
        }
    }

    /** Returns a Region by Point on this Dimension. */
    public Region getRegion(Point2D paramPoint) {
        initializeRegion(paramPoint);

        return regions.get(paramPoint);
    }
}
