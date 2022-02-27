package bg.uni.plovdiv.tpp.matrix;

import bg.uni.plovdiv.tpp.matrix.data.Matrix;
import bg.uni.plovdiv.tpp.matrix.data.MatrixMultiplyProcess;
import bg.uni.plovdiv.tpp.matrix.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    int size = getSizeFromArgs(args);

    if (size > 0) {
      Matrix a = createMatrixWithRandomValues(size);
      Matrix b = createMatrixWithRandomValues(size);
      multiplyMatrices(a, b);
    } else {
      test();
    }
  }

  private static int getSizeFromArgs(String[] args) {
    if (args.length > 0) {
      try {
        return Integer.parseInt(args[0]);
      } catch (Exception e) {
        log.error("Invalid command line argument. Please enter a number.");
      }
    }

    return -1;
  }

  private static Matrix createMatrixWithRandomValues(int size) {
    return new Matrix(size, Utils.generateRandomMatrixData(size));
  }

  private static void test() {
    int size = 3;

    Matrix a = new Matrix(size, new double[][]{
        {14.0, 9.0, 3.0},
        {2.0, 11.0, 15.0},
        {0.0, 12.0, 17.0}
    });
    Matrix b = new Matrix(size, new double[][]{
        {12.0, 25.0, 5.0},
        {9.0, 10.0, 0.0},
        {8.0, 5.0, 1.0}
    });

    multiplyMatrices(a, b);
  }

  private static void multiplyMatrices(Matrix a, Matrix b) {
    MatrixMultiplyProcess matrixMultiply = MatrixMultiplyProcess.multiplyMatrices(a, b);
    String result = matrixMultiply.toString();
    log.info(result);
  }
}
