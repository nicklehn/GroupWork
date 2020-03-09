package Model;

import java.util.Random;

public class BoardModel {

    // Anzahl der Minen
    private final int numberOfMines;

    // Spielfeld mit Zellen
    private final CellsModel[][] board;

    // Spielfeld Konstruktor
    public BoardModel(int length, int width, int numberOfMines){

        this.numberOfMines = numberOfMines;
        board = new CellsModel[length][width];

    }


    // Minen random setzen
    private void setMines() {

        int currentNumberOfMines = 0;

        // Objekt für zufällige Zahl
        Random random = new Random();

        while (currentNumberOfMines < numberOfMines) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length ; j++) {

                    double probability;
                    probability = random.nextDouble();

                    // Spielfeld leer
                    if (board[i][j]==null){
                        if (probability > 0.99999 && currentNumberOfMines < numberOfMines) {
                            board[i][j] = new CellsModel(i, j, false, this);
                            currentNumberOfMines++;
                        } else {
                            board[i][j] = new CellsModel(i, j , false, this);
                        }
                    // Mine im Spielfeld
                    } else if (board[i][j].isMine()){

                    // Restliches Spielfeld
                    } else if (probability > 0.99999 && currentNumberOfMines < numberOfMines){
                        board[i][j] = new CellsModel(i, j, true, this);
                        currentNumberOfMines++;
                    }
                }
            }
        }
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public int getWidth() {
        return board[0].length;
    }

    public int getLength() {
        return board.length;
    }

    public CellsModel getCellAt(int row, int column) throws IndexOutOfBoundsException {
        return board[row][column];
    }

}
