package Model;

public class CellsModel {

    // Position der Zellen
    private final int xPos;
    private final int yPos;

    // Eigenschaften der Zelle (Mine, Flagge, offen)
    private final boolean isMine;
    private boolean isFlag;
    private boolean isOpen;

    // Zellenkonstruktor
    public CellsModel(int x, int y, boolean isMine, BoardModel board){
        this.isMine = isMine;
        this.isFlag = false;
        this.isOpen = false;

        this.xPos = x;
        this.yPos = y;
    }

    public boolean isMine() {
        return isMine;
    }

}
