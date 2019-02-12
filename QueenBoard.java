public class QueenBoard{
  int[][] board;
  int length;
  public QueenBoard(int size){
    board = new int[size][size];
    length = size;
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
        if(board[i][r] > 0 ){
          b = b + "_ ";
        }else{
          b = b + "Q ";
        }
      }
      b = b + "\n";
    }
    return b;
  }

  public boolean addQueen(int r,int c){
    if(board[r][c] < 0 || board[r][c] >= 1){
      return false;
    }else{
      board[r][c] = -1;
      for(int i = 0; i < board.length; i++){
        board[r][i] = board[r][i] + 1;
      }
      for(int j = 0; j < board.length; j++){
        board[j][c] = board[j][c] + 1;
      }
      int xcor = r;
      int ycor = c;
      while (xcor < length && ycor < length ){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] + 1;
        }
        xcor++;
        ycor++;
      }
       xcor = r;
       ycor = c;
      while (xcor >= 0 && ycor < length ){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] + 1;
        }
        xcor--;
        ycor++;
      }
       xcor = r;
       ycor = c;
      while (xcor >= 0 && ycor >= 0){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] + 1;
        }
        xcor--;
        ycor--;
      }
      xcor = r;
      ycor = c;
      while (xcor < length && ycor >= 0){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] + 1;
        }
        xcor++;
        ycor--;
      }

    }
    return true;
  }

  public boolean removeQueen(int r,int c){
    if(board[r][c] != -1){
      return false;
    }
      board[r][c] = 0;
      for(int i = 0; i < board.length; i++){
        board[r][i] = board[r][i] - 1;
      }
      for(int j = 0; j < board.length; j++){
        board[j][c] = board[j][c] - 1;
      }
      int xcor = r;
      int ycor = c;
      while (xcor < length && ycor < length ){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] - 1;
        }
        xcor++;
        ycor++;
      }
       xcor = r;
       ycor = c;
      while (xcor >= 0 && ycor < length ){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] - 1;
        }
        xcor--;
        ycor++;
      }
       xcor = r;
       ycor = c;
      while (xcor >= 0 && ycor >= 0){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] - 1;
        }
        xcor--;
        ycor--;
      }
       xcor = r;
       ycor = c;
      while (xcor < length && ycor >= 0){
        if(board[xcor][ycor] != -1){
          board[xcor][ycor] = board[xcor][ycor] - 1;
        }
        xcor++;
        ycor--;
      }

    return true;
  }
  public boolean solve(){
    if (length == 0) return false;
    for (int x = 0; x < length; x++){
      for (int y = 0; y < length; y++){
        if (board[x][y] != 0) throw new IllegalStateException();
      }
    }
    return solveH(0);
  }

  public boolean solveH(int col){
    if(col >= board.length){
      return true;
    }
    for (int i = 0; i < board.length; i++) {
        if (addQueen(i, col)) {
                if (solveH(col + 1)) {
                  return true;
                }else{
                  removeQueen(i, col);
                }
        }
    }
    return false;
  }

  public int countSolution(){
    for (int x = 0; x < length; x++){
      for (int y = 0; y < length; y++){
        if (board[x][y] != 0) throw new IllegalStateException();
      }
    }
    return countH(0);
  }

  public int countH(int col){
    int ans = 0;
    if(col >= length){
      return 1;
    }
    for (int i = 0; i < length; i++) {
        if (addQueen(col, i)) {
                ans += countH(col + 1);
                }else{
                  removeQueen(col, i);
                }
    }
    return ans;
  }

  public static void main(String[] args) {
  	QueenBoard q = new QueenBoard(8);
  	boolean b = q.solve();
  	System.out.println(q);
  	System.out.println(b);


  }




}
