package net.rentalhost.games.craft.Positioning;

import java.util.HashMap;

public class Point3D {
    /** Stores all Point3D's references. */
    static private HashMap<Long, HashMap<Long, HashMap<Long, Point3D>>> pointsCache = new HashMap<>();

    /** Point positioning. */
    public Long x;
    public Long y;
    public Long z;

    /** Create a new Point3D. */
    private Point3D(Long paramX, Long paramY, Long paramZ) {
        x = paramX;
        y = paramY;
        z = paramZ;
    }

    /** Generate and return an unique modelInstance of a Point3D. */
    static public Point3D get(Long paramX, Long paramY, Long paramZ) {
        if (!pointsCache.containsKey(paramX)) {
            pointsCache.put(paramX, new HashMap<>());
        }

        HashMap<Long, HashMap<Long, Point3D>> hashX = pointsCache.get(paramX);

        if (!hashX.containsKey(paramY)) {
            hashX.put(paramY, new HashMap<>());
        }

        HashMap<Long, Point3D> hashY = hashX.get(paramY);

        if (!hashY.containsKey(paramZ)) {
            hashY.put(paramZ, new Point3D(paramX, paramY, paramZ));
        }

        return hashY.get(paramZ);
    }
}
