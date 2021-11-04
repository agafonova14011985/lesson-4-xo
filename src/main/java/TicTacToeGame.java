import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    private static char DOT_X = 'X';
    private static char DOT_O = 'O';
    private static char DOT_EMPTY = '.';
    private static final Scanner scaner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;

    public static void main(String[] args) {

        initField(3,3);
        printFielend();
        while (true) {
            humanTurn();
        printFielend();
        if (checkWin(DOT_X)){
            System.out.println("Выиграл человек1!!!"); break; }
        if (checkDraw()) break;
        aiTurn();
        printFielend();
        if (checkWin(DOT_O)){
            System.out.println("Выиграл комп!!!"); break; }
            if (checkDraw()) break;}
    }

    private static void aiTurn(){
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);}
        while (!isCellEmpty(y, x));
        field[y][x] = DOT_O;
    }

    private static void humanTurn(){
        int x;
        int y;
        do {
        System.out.print("Пожалйста введите координаты x и y");
        x = scaner.nextInt() - 1;
        y = scaner.nextInt() - 1;}
        while (!isCellValid(y, x) || !isCellEmpty(y, x));
        field[y][x] = DOT_X;
    }

    private static boolean checkWin(char dot){
        //проверка совпадений по горизонтали
        if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
        if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
        if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;
        // проверка совпадений по вертикали
        if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
        if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
        if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;
        //проверка диагоналей
        if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
        if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;
        return false;
    }

    private static boolean checkDraw(){
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
            if (isCellEmpty(y,x)) return false;}
        }
        System.out.println("It's DRAW!!");
        return true; }

    private static boolean isCellEmpty(int y, int x){
        return field[y][x] == DOT_EMPTY; }

    private static boolean isCellValid(int y, int x){
        return x >= 0 && y >= 0 && x <= fieldSizeX && y <= fieldSizeY;
    }

    private static void initField(int sizeX, int sizeY){
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                field[y][x] = DOT_EMPTY;
            }}
    }

    private static void printFielend(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++){
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1); }

        // if (i % 2 == 0) {sout("-"); то же самое что и предыдущая сттрока
        // } else { sout(i / 2 + 1);}

        //for (int y = 0; y < fieldSizeY; y++){ это упрощенное написание printFielend
            //for (int x = 0; x < fieldSizeX; x++){
                //System.out.print(field[y][x] + " "); }
            //System.out.println();}
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++){
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++){
                System.out.print(field[i][j] + "|"); }
            System.out.println(); }
        for (int i = 0; i < fieldSizeX * 2 + 1; i++){
            System.out.print("-");}
        System.out.println();
    }
}

