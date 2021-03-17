import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku2 {
  private final static int COL_LENGTH = 9;
  private final static int ROW_LENGTH = 9;

  public static boolean isValidSudoku(char[][] board) {
    boolean isValidSudoku = true;

    Map<Integer, List<Character>> columnValues = new HashMap<>();
    Map<Integer, List<Character>> rowValues = new HashMap<>();
    Map<Integer, List<Character>> squareValues = new HashMap<>();

    for (int i = 0; i < COL_LENGTH && isValidSudoku; i++) {
      for (int j = 0; j < ROW_LENGTH && isValidSudoku; j++) {
        if (board[i][j] != '.') {
          if (columnValues.get(j) != null) {
            if (columnValues.get(j).contains(board[i][j])) {
              isValidSudoku = false;
              break;
            }
          } else {
            columnValues.put(j, new ArrayList<>());
          }
          columnValues.get(j).add(board[i][j]);

          if (rowValues.get(i) != null) {
            if (rowValues.get(i).contains(board[i][j])) {
              isValidSudoku = false;
              break;
            }
          } else {
            rowValues.put(i, new ArrayList<>());
          }
          rowValues.get(i).add(board[i][j]);

          int squareIndex = i / 3 * 3 + j / 3;
          if (squareValues.get(squareIndex) != null) {
            if (squareValues.get(squareIndex).contains(board[i][j])) {
              isValidSudoku = false;
              break;
            }
          } else {
            squareValues.put(squareIndex, new ArrayList<>());
          }
          squareValues.get(squareIndex).add(board[i][j]);
        }
      }
    }

    return isValidSudoku;
  }
}
