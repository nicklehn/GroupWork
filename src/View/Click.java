package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener{

    Move m;
    boolean active;

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(" clicked");
        this.active = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.active = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public boolean getActive(){
        return active;
    }
    public void setActive(boolean value){
        this.active = value;
    }

}

