package net.rentalhost.games.craft.GameWorld;

import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import net.rentalhost.games.craft.Positioning.Point3D;

abstract public class Block {
    /** Block Point on the Chunk. */
    Point3D point;

    /** Block ModelInstance. */
    private ModelInstance modelInstance;

    /** Chunk Region. */
    private Chunk chunk;

    /** Instantiate a Region by Point on a Dimension. */
    protected Block(Chunk paramChunk, Point3D paramPoint) {
        chunk = paramChunk;
        point = paramPoint;

        modelInstance = getInstance();
        modelInstance.transform.translate(point.x, point.y, point.z);
    }

    /** Return the ModelInstance for this Block. */
    protected abstract ModelInstance getInstance();

    /** Render this Block on ModelBatch instance. */
    void render(ModelBatch paramModelBatch) {
        paramModelBatch.render(modelInstance);
    }
}
