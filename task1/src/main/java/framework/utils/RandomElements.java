package framework.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomElements {
    public static int getRandom(int sizeCatalog) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(1, sizeCatalog);
    }
}
