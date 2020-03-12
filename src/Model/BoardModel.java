package Model;

import java.util.Random;

/**
 * Klasse für Spielfeld
 */
public class BoardModel {

    private static int cellsHeight;
    private static int cellsWidth;

    private static int mineCount;
    private static int flagCount;

    private static CellsModel[][] cellsBoard;

    /**
     * Konstruktor
     * @param height
     * @param width
     */
    public BoardModel(int height, int width) {
        this.cellsHeight = height;
        this.cellsWidth = width;
        cellsBoard = new CellsModel[cellsHeight][cellsWidth];
    }

    /**
     * Minen auf Spielfeld setzen
     */
    public void setMines(){
        Random rn = new Random();
        for (int i = 0; i < mineCount ; i++) {
            int j, k;
            j = rn.nextInt(cellsWidth);
            k = rn.nextInt(cellsHeight);
            if (cellsBoard[j][k].checkMine() == false) {
                cellsBoard[j][k].setMine();
                cellsBoard[j][k].setCellsValue("x");
            }
        }
    }

    /**
     * Abfrage der Nachbarzellen
     * @param currCell
     * @return
     * @throws Exception
     */
    public int checkCellsAround(CellsModel currCell) throws Exception{

        int mineCounter = 0;

        for (int i = currCell.getXPos() - 1; i < currCell.getXPos() + 1; i++) {
            for (int j = currCell.getYPos() - 1; j < currCell.getYPos() + 1; j++) {

                try {

                    if (cellsBoard[j][i].checkMine()){
                        mineCounter++;
                    } else {
                        continue;
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }

            }
        }

        return mineCounter;
    }

    /**
     * Flagge auf Spielfeld setzen
     * @param currCell
     */
    public void setFlag (CellsModel currCell) {
        if (currCell.checkFlag() == false && flagCount < mineCount ) {
            currCell.setFlag(true);
            flagCount++;
        } else if (currCell.checkFlag()){
            currCell.setFlag(false);
            flagCount--;
        }

        // win check

    }

    /**
     * Zelle anzeigen
     * @param currCell
     * @throws Exception
     */
        public void openCells (CellsModel currCell) throws Exception {
        if(currCell.checkOpen() || currCell.checkFlag()){
            return;
        }

        if (currCell.checkMine()){
            showBoard();
            // game over
        }

        if (currCell.checkOpen() == false) {
            currCell.setOpen(true);
            checkCellsAround(currCell);
        }

        // win check

    }

    /**
     * Minen auf Spielfeld anzeigen
     */
    public void showBoard() {
        for (int i = 0; i < cellsHeight; i++) {
            for (int j = 0; j <  cellsWidth; j++) {
                if (cellsBoard[j][i].checkMine() && cellsBoard[j][i].checkFlag() == false){
                    cellsBoard[j][i].setCellsValue(cellsBoard[j][i].getCellsValue());
                }
            }
        }
    }


}
