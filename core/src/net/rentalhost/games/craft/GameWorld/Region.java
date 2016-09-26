package net.rentalhost.games.craft.GameWorld;

import com.badlogic.gdx.graphics.g3d.ModelBatch;
import net.rentalhost.games.craft.Positioning.Point2D;
import net.rentalhost.games.craft.Positioning.Point3D;

import java.util.HashMap;
import java.util.Random;

public class Region {
    /** Region Dimension. */
    Dimension dimension;

    /** Region Point on the map. */
    private Point2D point;
    private Random  generator;

    /** The Chunks of this Region. */
    private HashMap<Point3D, Chunk> chunks;

    /** Instantiate a Region by Point on a Dimension. */
    Region(Dimension paramDimension, Point2D paramPoint) {
        dimension = paramDimension;
        point = paramPoint;
        generator = new Random();
        chunks = new HashMap<>();

        for (long x = -2L; x < 2L; x++) {
            for (long z = -2L; z < 2L; z++) {
                initializeChunk(Point3D.get(x, 0L, z));
            }
        }
    }

    /** Initialize a Chunk by Point on this Region. */
    private void initializeChunk(Point3D paramPoint) {
        if (!chunks.containsKey(paramPoint)) {
            chunks.put(paramPoint, new Chunk(this, paramPoint));
        }
    }

    /** Returns a Region by Point on this Dimension. */
    public Chunk getChunk(Point3D paramPoint) {
        initializeChunk(paramPoint);

        return chunks.get(paramPoint);
    }

    /** Render this Region on ModelBatch instance. */
    public void render(ModelBatch paramModelBatch) {
        for (Chunk chunk : chunks.values()) {
            chunk.render(paramModelBatch);
        }
    }
}
