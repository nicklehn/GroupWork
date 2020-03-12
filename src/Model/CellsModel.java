package Model;

/**
 * Klasse für Zellen
 */
public class CellsModel {

    private static String cellsValue;
    private BoardModel gameBoard;

    /**
     * Position der Zellen
     */
    private static int xPos;
    private static int yPos;

    /**
     * Zustand der Zellen (Mine,Flagge,offen)
     */
    private static boolean isMine;
    private static boolean isFlag;
    private static boolean isOpen;

    /**
     * Konstruktor
     * @param x
     * @param y
     */
    public CellsModel(int x, int y){

        this.xPos = x;
        this.yPos = y;

        this.isMine = false;
        this.isFlag = false;
        this.isOpen = false;

       // this.gameBoard = board;

        if(isMine){
            cellsValue = "x";
        } else if (isFlag) {
            cellsValue = "f";
        } else if (isOpen) {
            cellsValue = "o";
        }

    }


    public boolean checkMine () {
        return isMine;
    }

    public void setMine() {
        this.isMine = true;
    }

    public void setCellsValue(String st){
        this.cellsValue = st;
    }

    public static String getCellsValue() {
        return cellsValue;
    }

    public static int getXPos() {
        return xPos;
    }

    public static void setXPos(int xPos) {
        CellsModel.xPos = xPos;
    }

    public static int getYPos() {
        return yPos;
    }

    public static void setYPos(int yPos) {
        CellsModel.yPos = yPos;
    }


    public static boolean checkFlag() {
        return isFlag;
    }

    public static void setFlag(boolean isFlag) {
        CellsModel.isFlag = isFlag;
    }

    public static boolean checkOpen() {
        return isOpen;
    }

    public static void setOpen(boolean isOpen) {
        CellsModel.isOpen = isOpen;
    }
}
