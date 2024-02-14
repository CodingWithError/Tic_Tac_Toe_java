package TicTacToeJava;
import java.util.*;

public class Tic_Tac_Toe {
  public static void main(String[] args) {
    int n=3;
    char [][] Board=new char[n][n];
    Scanner cs=new Scanner(System.in);
    System.out.print("Enter the Player 1 name:- ");
    String player1=cs.nextLine();
    System.out.print("Enter the Player 2 name:- ");
    String player2=cs.nextLine();
    
  //turn 
  boolean turn=true;

  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      Board[i][j]='-';
    }
  }
  
  
  int countofMoves=0;
  while(true){
    DisplayBoard(Board);
    char sym;
    while(true){
      if(turn){
        System.out.println(player1+", please make your move: ");
      }
      else{
        System.out.println(player2+", please make your move: ");
      }

      
      if(turn){
        sym='X';
      }
      else{
        sym='O';
      }
  
      System.out.println("Please enter the row: ");
      int r=cs.nextInt();
      System.out.println("Please enter the column: ");
      int c=cs.nextInt();
  
      if(r<0 || r>=n || c<0 || c>=n){
        System.out.println("Invalid move, please try again");
      }
      else if(Board[r][c]!='-'){
        System.out.println("This cell is occipied !!");
      }
      else{
        Board[r][c]=sym;
        countofMoves++;
        break;
      }
    }
    if(checkWinner(Board, sym)){
      System.out.println(player1+" wins");
      break;
    }
    else if(countofMoves==n*n){
      System.out.println("It's a draw");
      break;
    }
    turn=!turn;
  }
  DisplayBoard(Board);
}

  public static void DisplayBoard(char[][] board){
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board.length;j++){
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
  }

  static boolean checkWinner(char[][] board , char sym){
    for(int i=0;i<board.length;i++){
      if(board[i][0]==sym && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
        return true;
      }
      else if(board[0][i]==sym && board[0][i]==board[1][i] && board[1][i]==board[2][i]){
        return true;
      }
      else if(board[0][0]==sym && board[0][0]==board[1][1] && board[1][1]==board[2][2]){
        return true;
      }
      else if(board[0][2]==sym && board[0][2]==board[1][1] && board[1][1]==board[2][0]){
        return true;
      }
    }
    return false;
  }

}
