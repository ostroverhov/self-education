package project.utils;

public class RandomNumber {

    public static int randomInRange(int bound) {
        return new java.util.Random().nextInt(bound);
    }
}
