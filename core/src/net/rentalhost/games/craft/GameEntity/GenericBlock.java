package net.rentalhost.games.craft.GameEntity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import net.rentalhost.games.craft.GameEngine;
import net.rentalhost.games.craft.GameWorld.Block;
import net.rentalhost.games.craft.GameWorld.Chunk;
import net.rentalhost.games.craft.Positioning.Point3D;

public class GenericBlock extends Block {
    /** Instantiate a Region by Point on a Dimension. */
    public GenericBlock(Chunk paramChunk, Point3D paramPoint) {
        super(paramChunk, paramPoint);
    }

    /** Return the ModelInstance for this Block. */
    protected ModelInstance getInstance() {
        Texture  texture         = new Texture("textures/blocks/generic.png");
        Material genericMaterial = new Material(TextureAttribute.createDiffuse(texture));
        int      attributes      = VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates;
        Model    box             = GameEngine.modelBuilder.createBox(1L, 1L, 1L, genericMaterial, attributes);

        return new ModelInstance(box);
    }
}
