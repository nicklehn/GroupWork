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

    // Wert für Bombenabfrage
    private String value;

    // Zellen in Umgebung
    private BoardModel gameBoard;
    private ArrayList<CellsModel> cellsAround;

    // Zellenkonstruktor
    public CellsModel(int x, int y, boolean isMine, BoardModel board){
        this.isMine = isMine;
        this.isFlag = false;
        this.isOpen = false;

        this.gameBoard = board;
        cellsAround= new ArrayList<>();

        this.xPos = x;
        this.yPos = y;

        if (this.isMine) {
            value = "X";
        }
    }

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

    // Minenabfrage
    public boolean isMine() {
        return isMine;
    }

    // Zellenabfrage
    public ArrayList<CellsModel> getCellsAround() {

        if (cellsAround.isEmpty() || cellsAround.contains(null)) {
            setCellsAround();
        }

        return cellsAround;

    }

    // Zellen setzen
    public void setCellsAround() {
        for (int i = xPos - 1; i <= xPos + 1; i++) {
            for (int j = yPos - 1; j <= yPos + 1; j++) {

                if (i == xPos && j == xPos) {

                } else {
                    if (i >= gameBoard.getLength() || j >= gameBoard.getWidth() || i < 0 || j < 0) {
                        continue;
                    } else {
                        cellsAround.add(gameBoard.getCellAt(i, j));
                    }
                }
            }
        }
    }

    public void setValue() {

        if (isMine) {
            return;
        }

        if(value == null) {

            int minesAround = 0;

            for (CellsModel cell : getCellsAround()) {
                if (cell.isMine()) {
                    minesAround++;
                }
            }

            value = Integer.toString(minesAround);
        }
    }



}
