package pakij;

import java.util.Random;

public class RNG {

    private static Random rng = new Random();

    public static boolean chanceTime(int threshold, int limit){
        return (rng.nextInt(limit) >= threshold);
    }

    public static double randRange(double min, double max){
        return (min + ((max - min) * rng.nextDouble()));
    }

    public static int randRange(int min, int max){
        return (min + rng.nextInt(max - min));
    }

}
