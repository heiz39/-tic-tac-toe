import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        initBoard(board);

        Scanner input = new Scanner(System.in);
        char current = 'X';
        boolean isRunning=true;
        while (isRunning) {
            int row = readInt(input, "Enter the # of rows(1-3): ")-1;
            int column = readInt(input, "Enter the # of columns(1-3): ")-1;
        if (makeMove(board,row,column,current)==false) {
            System.out.println("Wrong move!");
            continue;
        }else {
            printBoard(board);
        }
            if (isWin(board,current)==true) {
                System.out.println("Winner is "+ current);
                isRunning=false;
            }else if (isDraw(board)){
                System.out.println("Draw!");
                isRunning=false;
            }
            current = current == 'X' ? 'O' : 'X';

        }
        input.close();

    }
    static void initBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }
    static void printBoard(char[][] board){
        String line="---+---+---";
        System.out.println(line);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(" " + board[i][j] + " ");
                if (j<board[i].length-1){
                    System.out.print("|");}
            }
            System.out.println();
                System.out.println(line);
            }

        }
    static boolean makeMove(char[][] board, int row, int col, char player){
         if(row<0||row>=board.length||col<0||col>=board[0].length){
             return false;
         }
         if(board[row][col]!=' '){
             return false;
         }
        board[row][col] = player;
         return true;
    }
    static boolean isWin(char[][] board, char player){
        for(int i=0;i<board.length;i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            }
        for (int j=0;j<board.length;j++){
                if (board[0][j]==player&& board[1][j] == player && board[2][j] == player){
                    return true;
                }
            }
        if (board[0][0]==player&& board[1][1] == player && board[2][2] == player){
            return true;
        }
        if (board[0][2]==player&& board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
    static boolean isDraw(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
            if(board[i][j]==' '){
                return false;
            }
            }
        }
        return true;
    }
    static int readInt(Scanner input, String prompt){
        while(true){
            System.out.print(prompt);
            if(input.hasNextInt()){
                return input.nextInt();
            }
            System.out.println("Wrong input!");
            input.next();
        }
    }
    }
