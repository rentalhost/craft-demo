package net.rentalhost.games.craft.GameWorld;

import com.badlogic.gdx.graphics.g3d.ModelBatch;
import net.rentalhost.games.craft.GameEntity.SolidBlock;
import net.rentalhost.games.craft.GameEntity.ThreeFacedBlock;
import net.rentalhost.games.craft.Positioning.Point3D;

import java.util.HashMap;

public class Chunk {
    /** Chunk Region. */
    private Region region;

    /** Chunk Point on the Region. */
    private Point3D point;

    /** The Block's on this Chunk. */
    private HashMap<Point3D, Block> blocks;

    /** Instantiate a Region by Point on a Dimension. */
    Chunk(Region paramRegion, Point3D paramPoint) {
        region = paramRegion;
        point = paramPoint;
        blocks = new HashMap<>();

        generateBlocks();
    }

    /** Generate all blocks for this Chunk. */
    private void generateBlocks() {
        for (Long blockX = 0L; blockX < 8L; blockX++) {
            for (Long blockZ = 0L; blockZ < 8L; blockZ++) {
                double noiseX = ( point.x * 8f + blockX ) / 32f;
                double noiseZ = ( point.z * 8f + blockZ ) / 32f;

                Long perlinValue = (long) Math.floor(2 * region.dimension.universe.noisy.eval(noiseX, noiseZ));
                setBlock(new SolidBlock(this, Point3D.get(point.x * 8 + blockX, -2L, point.z * 8 + blockZ)));

                //   setBlock(new ThreeFacedBlock(this, Point3D.get(point.x * 8 + blockX, perlinValue, point.z * 8 + blockZ)));
                setBlock(new ThreeFacedBlock(this, Point3D.get(point.x * 8 + blockX, 2 - perlinValue, point.z * 8 + blockZ)));

                for (long y = perlinValue - 1; y > 0; y--) {
                    setBlock(new SolidBlock(this, Point3D.get(point.x * 8 + blockX, y, point.z * 8 + blockZ)));
                }
            }
        }
    }

    /** Replace Block on Point3D on Chunk. */
    private void setBlock(Block paramBlock) {
        blocks.put(paramBlock.point, paramBlock);
    }

    /** Render this Chunk on ModelBatch instance. */
    void render(ModelBatch paramModelBatch) {
        for (Block block : blocks.values()) {
            block.render(paramModelBatch);
        }
    }
}
