package net.rentalhost.games.craft.Camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class DefaultCamera extends PerspectiveCamera {
    /** Default settings for camera. */
    public DefaultCamera() {
        super(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        position.set(10f, 10f, 10f);
        lookAt(0, 0, 0);
        near = 1f;
        far = 300f;
        update();
    }
}
