package nsh.codility;

public class TestUtils {

  static int[] reverseArray(int[] A) {
    for (int i = 0; i < A.length >> 1; i++) {
      int r = A.length - 1 - i;
      int t = A[i];
      A[i] = A[r];
      A[r] = t;
    }
    return A;
  }
}
