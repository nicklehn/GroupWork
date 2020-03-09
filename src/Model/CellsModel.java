package Model;

import java.util.ArrayList;

public class CellsModel {

    // Position der Zellen
    private final int xPos;
    private final int yPos;

    // Eigenschaften der Zelle (Mine, Flagge, offen)
    private final boolean isMine;
    private boolean isFlag;
    private boolean isOpen;

    // Zellen in Umgebung
    private BoardModel gameBoard;
    private ArrayList<CellsModel> nextCells;

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    // Zellenkonstruktor
    public CellsModel(int x, int y, boolean isMine, BoardModel board){
        this.isMine = isMine;
        this.isFlag = false;
        this.isOpen = false;

        this.gameBoard = board;
        nextCells = new ArrayList<>();

        this.xPos = x;
        this.yPos = y;
    }

    // Minenabfrage
    public boolean isMine() {
        return isMine;
    }



}
