package bg.uni.plovdiv.tpp.matrix.data;

import static bg.uni.plovdiv.tpp.matrix.util.Utils.NEW_LINE;

public class MatrixMultiplyProcess {

  private final String matrixToString;
  private final long executionTime;

  private MatrixMultiplyProcess(String matrixToString, long executionTime) {
    this.matrixToString = matrixToString;
    this.executionTime = executionTime;
  }

  @Override
  public String toString() {
    return NEW_LINE +
        matrixToString +
        NEW_LINE +
        String.format("Job executed for %d millis", executionTime);
  }

  public static MatrixMultiplyProcess multiplyMatrices(Matrix a, Matrix b) {
    long startTimeMillis = System.currentTimeMillis();

    Matrix c = a.multiply(b);
    String cToString = c.toString();

    long executionTimeMillis = System.currentTimeMillis() - startTimeMillis;

    return new MatrixMultiplyProcess(cToString, executionTimeMillis);
  }
}
