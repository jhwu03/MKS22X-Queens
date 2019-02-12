public class QueenBoard{
  int[][] board;
  int length;
  public QueenBoard(int size){
    board = new int[size][size]; //initiates board with n*n board
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
         if (board[row][col] == -1) { // if current index is -1 it means it is a queen
           ans += "Q ";
         } else {
           ans += "_ "; // else print undersocre for the board
         }
       }
       ans += "\n";
     }
     return ans;
   }

     public boolean addQueen(int r,int c){
   if(board[r][c] < 0 || board[r][c] >= 1){ // if the coordinate is negative or greater than 0 then you can add queen
     return false;
   }else{

     for(int i = 0; i < board.length; i++){ //vertically fill up limits
       board[r][i] = board[r][i] + 1;
     }
     for(int j = 0; j < board.length; j++){ //horizontal fill up limits
       board[j][c] = board[j][c] + 1;
     }
     //fill up limits of diagonals
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
    if(board[r][c] != -1){ // if coordinate is not -1 then it is not a queen
      return false;
    }

      for(int i = 0; i < board.length; i++){ //vertically filling limits
        board[r][i] = board[r][i] - 1;
      }
      for(int j = 0; j < board.length; j++){//horizontally filling limits
        board[j][c] = board[j][c] - 1;
      }
      // filling limits of diagonals
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
        if (board[x][y] != 0) throw new IllegalStateException(); //throw exception is board is not all 0
      }
    }
    return solveH(0); //helper function
  }

  public boolean solveH(int col){
    if(col >= board.length){
      return true;
    }
    for (int i = 0; i < board.length; i++) {
        if (addQueen(i, col)) {
                if (solveH(col + 1)) { //recursive call
                  return true;
                }
                  removeQueen(i, col);
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
    return countH(0);//helper function
  }

  public int countH(int col){
    int ans = 0;
    if(col >= board.length){
      return 1;
    }
    for (int i = 0; i < board.length; i++) {
        if (addQueen(i, col)) {
                ans += countH(col + 1); //recursive call
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
