import java.util.ArrayList;
import java.util.List;

public class ValidSudoku1 {
  private final static int COL_LENGTH = 9;
  private final static int ROW_LENGTH = 9;

  public static boolean isValidSudoku(char[][] board) {
    return isValidColumns(board) && isValidRows(board) && isValidSquares(board);
  }

  private static boolean isValidColumns(char[][] board) {
    boolean isValidColumns = true;

    for (int j = 0; j < COL_LENGTH && isValidColumns; j++) {
      List<Character> columnValues = new ArrayList<>();
      for (int i = 0; i < ROW_LENGTH && isValidColumns; i++) {
        if (board[i][j] != '.') {
          if (columnValues.contains(board[i][j])) {
            isValidColumns = false;
          } else {
            columnValues.add(board[i][j]);
          }
        }
      }
    }

    return isValidColumns;
  }

  private static boolean isValidRows(char[][] board) {
    boolean isValidRows = true;

    for (int i = 0; i < ROW_LENGTH && isValidRows; i++) {
      List<Character> rowValues = new ArrayList<>();
      for (int j = 0; j < COL_LENGTH && isValidRows; j++) {
        if (board[i][j] != '.') {
          if (rowValues.contains(board[i][j])) {
            isValidRows = false;
          } else {
            rowValues.add(board[i][j]);
          }
        }
      }
    }

    return isValidRows;
  }

  private static boolean isValidSquare(int startingRowIndex, int startingColumnIndex, char[][] board) {
    boolean isValidSquare = true;

    List<Character> squareValues = new ArrayList<>();
    for (int i = startingRowIndex; i < startingRowIndex + 3 && isValidSquare; i++) {
      for (int j = startingColumnIndex; j < startingColumnIndex + 3 && isValidSquare; j++) {
        if (board[i][j] != '.') {
          if (squareValues.contains(board[i][j])) {
            isValidSquare = false;
          } else {
            squareValues.add(board[i][j]);
          }
        }
      }
    }

    return isValidSquare;
  }

  private static boolean isValidSquares(char[][] board) {
    boolean isValidSquares = true;

    for (int i = 0; i < ROW_LENGTH && isValidSquares; i = i + 3) {
      for (int j = 0; j < COL_LENGTH && isValidSquares; j = j + 3) {
        isValidSquares = isValidSquare(i, j, board);
      }
    }

    return isValidSquares;
  }
}
