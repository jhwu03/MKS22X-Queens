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
  public String toString() {
     String ans = "";
     for (int row = 0; row < board.length; row ++) {
       for (int col = 0; col < board[row].length; col ++) {
         if (board[row][col] == -1) {
           ans += "Q ";
         } else {
           ans += "_ ";
         }
       }
       ans += "\n";
     }
     return ans;
   }

     public boolean addQueen(int r,int c){
   if(board[r][c] < 0 || board[r][c] >= 1){
     return false;
   }else{

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
     board[r][c] = -1;
   }
   return true;
 }

  public boolean removeQueen(int r,int c){
    if(board[r][c] != -1){
      return false;
    }

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
    board[r][c] = 0;
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
    if(col >= board.length){
      return 1;
    }
    for (int i = 0; i < board.length; i++) {
        if (addQueen(i, col)) {
                ans += countH(col + 1);
                }
                  removeQueen(i, col);
                }
    return ans;
  }

  public static void main(String[] args) {
    QueenBoard board = new QueenBoard(Integer.parseInt(args[0]));
    //System.out.println(board.solve());
    //System.out.println(board);
    System.out.println(board.countSolution());
    System.out.println(board);
  }




}
