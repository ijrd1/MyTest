package graffiti2019.binarySearch.matrix;

import org.junit.jupiter.api.Test;

import static graffiti2019.binarySearch.matrix.Solution.findKthSmallest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionSpec {

  @Test
  void test_find_2nd_2x2() {
    int[][] matrix = {{1, 4}, {2, 5}};
    int expected = 2;
    assertEquals(expected, findKthSmallest(matrix, 2));
  }

  @Test
  void test_find_1st_1x1() {
    int[][] matrix = {{-5}};
    int expected = -5;
    assertEquals(expected, findKthSmallest(matrix, 1));
  }

  @Test
  void test_find_5th_3x3() {
    int[][] matrix = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
    int expected = 7;
    assertEquals(expected, findKthSmallest(matrix, 5));
  }

  @Test
  void test_find_8th_3x3() {
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    int expected = 13;
    assertEquals(expected, findKthSmallest(matrix, 8));
  }


}
