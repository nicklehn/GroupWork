package View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

    public class Move implements MouseMotionListener {

        public int mx;
        public int my;

        public int getMx() {
            return mx;
        }

        public int getMy() {
            return my;
        }

        public void setMy(int my) {
            this.my = my;
        }

        public void setMx(int mx) {
            this.mx = mx;
        }


        public Move(){

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        public void updateKoordinaten(int x, int y){
            this.mx = x;
            this.my = y;
        }

        @Override
        public void mouseMoved(MouseEvent e) { // da wird die Position der Maus bestimmt
            this.mx = e.getX();
            setMx(e.getX());
            this.my = e.getY();
            setMy(e.getY());
        }
    }
