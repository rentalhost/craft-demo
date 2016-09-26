package net.rentalhost.games.craft.GameEntity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import net.rentalhost.games.craft.GameEngine;
import net.rentalhost.games.craft.GameWorld.Block;
import net.rentalhost.games.craft.GameWorld.Chunk;
import net.rentalhost.games.craft.Positioning.Point3D;

public class ThreeFacedBlock extends Block {
    private static Model box;

    /** Instantiate a Region by Point on a Dimension. */
    public ThreeFacedBlock(Chunk paramChunk, Point3D paramPoint) {
        super(paramChunk, paramPoint);
    }

    @Override
    protected ModelInstance getInstance() {
        if (box == null) {
            Texture materialTexture = new Texture(Gdx.files.internal("textures/blocks/grass.png"));

            Material materialSide   = new Material(TextureAttribute.createDiffuse(new TextureRegion(materialTexture, 0, 16, 16, 16)));
            Material materialTop    = new Material(TextureAttribute.createDiffuse(new TextureRegion(materialTexture, 0, 0, 16, 16)));
            Material materialBottom = new Material(TextureAttribute.createDiffuse(new TextureRegion(materialTexture, 16, 0, 16, 16)));

            int attributes = VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates;

            ModelBuilder modelBuilder = GameEngine.modelBuilder;
            modelBuilder.begin();

            modelBuilder.part("FaceT", GL20.GL_TRIANGLES, attributes, materialTop).rect(0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0);
            modelBuilder.part("FaceS1", GL20.GL_TRIANGLES, attributes, materialSide).rect(0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0);
            modelBuilder.part("FaceS2", GL20.GL_TRIANGLES, attributes, materialSide).rect(1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0);
            modelBuilder.part("FaceS3", GL20.GL_TRIANGLES, attributes, materialSide).rect(1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0);
            modelBuilder.part("FaceS4", GL20.GL_TRIANGLES, attributes, materialSide).rect(0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0);
            modelBuilder.part("FaceB", GL20.GL_TRIANGLES, attributes, materialBottom).rect(0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0);

            box = modelBuilder.end();
        }

        return new ModelInstance(box);
    }
}
