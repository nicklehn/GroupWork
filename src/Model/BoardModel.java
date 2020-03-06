package Model;

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

}
