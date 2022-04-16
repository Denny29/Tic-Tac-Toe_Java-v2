import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        char[][] gameBoard= {{' ','|',' ','|',' '},
                 	{'-','+','-','+','-'},
                	{' ','|',' ','|',' '},
                 	{'-','+','-','+','-'},
                	{' ','|',' ','|',' '}};
        char player = 'X';

        char cont = 'y';
        while(cont == 'y' || cont == 'Y'){
            printGameBoard(gameBoard);
            System.out.println(player + "'s turn. \nEnter your placement (1-9)");   
            int pos = scan.nextInt();
            boolean flag = play(gameBoard, player, pos);

            if(isGameOver(gameBoard, player)){
                printGameBoard(gameBoard);
                System.out.println("Play again? (y / n)");
                cont = scan.next().charAt(0);
                if(cont == 'y' || cont == 'Y')
                    gameBoard = new char[][]{{' ','|',' ','|',' '},
                 	{'-','+','-','+','-'},
                	{' ','|',' ','|',' '},
                 	{'-','+','-','+','-'},
                	{' ','|',' ','|',' '}};
            }
            //Changes player at the very end
            if(flag){
                switch(player){
                    case 'X':
                        player = 'Y';
                        break;
                    case 'Y':
                        player = 'X';
                        break;
                    default: break; 
                }
            }
        }
    }

    //Checks if the game is over
    public static boolean isGameOver(char[][] gameBoard, char player){
        boolean out = false;
        //Horizontal win
        for(int i = 0; i < gameBoard.length; i+=2){
            if(gameBoard[i][0] != ' ' && (gameBoard[i][0] == gameBoard[i][2]) && (gameBoard[i][2] == gameBoard[i][4])){
                out = true;
                System.out.println("Nice horizontal win " + player);
                break;
            }
        }
        //Vertical win
        if(!out){
            for(int i = 0; i < gameBoard.length; i+=2){
                if(gameBoard[0][i] != ' ' && (gameBoard[0][i] == gameBoard[2][i]) && (gameBoard[2][i] == gameBoard[4][i])){
                    out = true;
                    System.out.println("Nice vertical win " + player);
                    break;
                }
            }
        }
        //Diagonal win
        if(!out){
           if(gameBoard[0][0] != ' ' && (gameBoard[0][0] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][4])){
               out = true;
               System.out.println("Nice diagonal win " + player);
            }
            else if(gameBoard[0][4] != ' ' && (gameBoard[0][4] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][0])){
                out = true;
                System.out.println("Nice diagonal win " + player);
             }
        }
        return out;
    }

    //Checks if space is taken, if not updates gameBoard and player
    public static void checkSpace(char[][] gameBoard, char player, int row, int column){
        if(gameBoard[row][column] == ' '){
            gameBoard[row][column] = player; 
            // System.out.println(player + " in func 2");
        }
        else
            System.out.println("That space is taken.");
    }
        
    //Changes pos into actual coordinates for gameBoard
    public static boolean play(char[][] gameBoard, char player, int pos){
        boolean out = true;
        switch(pos){
            case 1: 
                checkSpace(gameBoard, player, 0, 0);
                break;
            case 2:
                checkSpace(gameBoard, player, 0, 2);
                break;
            case 3:
                checkSpace(gameBoard, player, 0, 4);
                break;
            case 4: 
                checkSpace(gameBoard, player, 2, 0);
                break;
            case 5:
                checkSpace(gameBoard, player, 2, 2);
                break;
            case 6:
                checkSpace(gameBoard, player, 2, 4);
                break;
            case 7: 
                checkSpace(gameBoard, player, 4, 0);
                break;
            case 8:
                checkSpace(gameBoard, player, 4, 2);
                break;
            case 9:
                checkSpace(gameBoard, player, 4, 4);
                break;
            default: 
                System.out.println("Please enter a number between 1 and 9");
                out = false;
        }
        return out;
    }

    //Prints gameboard
    public static void printGameBoard(char[][] gameBoard){
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
