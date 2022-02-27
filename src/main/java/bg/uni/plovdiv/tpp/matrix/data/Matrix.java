package bg.uni.plovdiv.tpp.matrix.data;

import static bg.uni.plovdiv.tpp.matrix.util.Utils.NEW_LINE;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matrix {

  private final int size;
  private final double[][] data;

  public Matrix(int size, double[][] data) {
    this.size = size;
    this.data = data;
  }

  public double getAt(int row, int col) {
    return data[row][col];
  }

  public Matrix multiply(Matrix matrix) {
    double[][] result = Arrays.stream(data)
        .parallel()
        .map(row -> IntStream.range(0, size)
            .mapToDouble(i -> IntStream.range(0, size)
                .mapToDouble(j -> row[j] * matrix.getAt(j, i))
                .sum())
            .toArray())
        .toArray(double[][]::new);

    return new Matrix(size, result);
  }

  @Override
  public String toString() {
    return Arrays.stream(data)
        .parallel()
        .map(row -> Arrays.stream(row)
            .mapToObj(num -> String.format("%f", num))
            .collect(Collectors.joining(" ")))
        .collect(Collectors.joining(NEW_LINE));
  }
}
