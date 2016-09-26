package net.rentalhost.games.craft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import net.rentalhost.games.craft.Camera.DefaultCamera;
import net.rentalhost.games.craft.GameWorld.Region;
import net.rentalhost.games.craft.GameWorld.Universe;
import net.rentalhost.games.craft.Positioning.Point2D;

public class GameEngine extends ApplicationAdapter {
    public static ModelBuilder modelBuilder = new ModelBuilder();

    private static ModelBatch modelBatch;
    private static Universe   currentUniverse;
    private static Region     testRegion;

    private CameraInputController camController;
    private DefaultCamera         defaultCamera;

    @Override
    public void create() {
        modelBatch = new ModelBatch();

        Environment environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        defaultCamera = new DefaultCamera();

        currentUniverse = Universe.get("My Universe");
        testRegion = currentUniverse.getDimension("earth").getRegion(Point2D.get(0L, 0L));

        camController = new CameraInputController(defaultCamera);
        Gdx.input.setInputProcessor(camController);
    }

    @Override
    public void render() {
        //  Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        camController.update();

        modelBatch.begin(defaultCamera);
        testRegion.render(modelBatch);
        modelBatch.end();

        Gdx.graphics.setTitle(String.valueOf(Gdx.graphics.getFramesPerSecond()));
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
    }
}
