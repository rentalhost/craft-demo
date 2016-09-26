package net.rentalhost.games.craft.GameWorld;

import net.rentalhost.games.craft.ThirdParties.OpenSimplexNoise;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Universe {
    /** Universe version. */
    final private Byte version = 0;

    /** Universe PerlinNoise generator. */
    OpenSimplexNoise noisy;

    /** Universe base generator. */
    Random generator;

    /** Universe name and seed. */
    private String name;
    private Long   seed;

    /** Universe UUID. */
    private UUID uuid;

    /** Stores all Universe's dimensions. */
    private HashMap<String, Dimension> dimensions;

    /** Prepares a new Universe. */
    private Universe(String paramName, Long paramSeed) {
        name = paramName;
        seed = paramSeed;
        generator = new Random(seed);
        uuid = UUID.randomUUID();
        dimensions = new HashMap<>();
        noisy = new OpenSimplexNoise(seed);

        initializeDimension("earth");
    }

    /** Generate a new Universe by name. */
    public static Universe get(String paramName) {
        return new Universe(paramName, new Random().nextLong());
    }

    /** Initialize and return a Dimension by ID. */
    private void initializeDimension(String paramId) {
        if (!dimensions.containsKey(paramId)) {
            dimensions.put(paramId, new Dimension(this, paramId));
        }
    }

    /** Generate and return a Dimension on this Universe. */
    public Dimension getDimension(String paramId) {
        initializeDimension(paramId);

        return dimensions.get(paramId);
    }
}
