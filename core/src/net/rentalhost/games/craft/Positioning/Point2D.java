package net.rentalhost.games.craft.Positioning;

import java.util.HashMap;

public class Point2D {
    /** Stores all Point2D's references. */
    static private HashMap<Long, HashMap<Long, Point2D>> pointsCache = new HashMap<>();

    /** Point positioning. */
    public Long x;
    public Long y;

    /** Create a new Point2D. */
    Point2D(Long paramX, Long paramY) {
        x = paramX;
        y = paramY;
    }

    /** Generate and return an unique modelInstance of a Point2D. */
    static public Point2D get(Long paramX, Long paramY) {
        if (!pointsCache.containsKey(paramX)) {
            pointsCache.put(paramX, new HashMap<>());
        }

        HashMap<Long, Point2D> hashX = pointsCache.get(paramX);

        if (!hashX.containsKey(paramY)) {
            hashX.put(paramY, new Point2D(paramX, paramY));
        }

        return hashX.get(paramY);
    }
}
