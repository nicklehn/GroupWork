package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class Controller extends MouseAdapter implements ActionListener {


    private BoardModel model;
    Timer tm;
    CellsModel[][] eins = BoardModel.getCellsBoard();


    @Override
    public void mouseClicked(MouseEvent e) {

        switch (e.getButton()) {

            case MouseEvent.BUTTON1:
                    if (!BoardModel.getCellsBoard().checkFlag()) {
                        eins[e.getX()][e.getY()].setOpen();



                    }

                break;
            case MouseEvent.BUTTON3:
                BoardModel.setFlag(); //einzelne Zelle muss angesprochen werde
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}