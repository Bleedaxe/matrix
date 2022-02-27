package bg.uni.plovdiv.tpp.matrix.util;

import java.util.Random;
import java.util.stream.IntStream;

public final class Utils {

  public static final String NEW_LINE = System.getProperty("line.separator");

  private static final Random RANDOM = new Random();

  private Utils() {
  }

  public static double[][] generateRandomMatrixData(int size) {
    return IntStream.range(0, size)
        .parallel()
        .mapToObj(row -> IntStream.range(0, size)
            .mapToDouble(col -> RANDOM.nextDouble() * 10)
            .toArray())
        .toArray(double[][]::new);
  }
}
