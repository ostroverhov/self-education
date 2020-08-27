package framework.utils

import java.util.concurrent.ThreadLocalRandom

class RandomElements {
    static def getRandom(def sizeCatalog) {
        ThreadLocalRandom random = ThreadLocalRandom.current()
        random.nextInt(1, sizeCatalog)
    }
}
