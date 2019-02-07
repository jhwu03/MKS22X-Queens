public class QueenBoard{
  int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _

  *_ _ _ Q

  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String b = "";
    for(int i = 0; i < board.length; i++){
      for(int r = 0; r < board.length;r++){
        if(board[i][r] == 0 ){
          b = b + "_ ";
        }
      }
      b = b + "\n";
    }
    return b;
  }



}
