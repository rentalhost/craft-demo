package net.rentalhost.games.craft.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.rentalhost.games.craft.GameEngine;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "Craft";
        config.width = 1280;
        config.height = 720;

        new LwjglApplication(new GameEngine(), config);
    }
}
