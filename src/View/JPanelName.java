package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JPanelName extends JPanel implements ActionListener {
    int spacing = 1; // sind die Spalten zwischen die ganzen Kästchen
    Timer tm;
    Move m;
    Click c;
    boolean[][] buttons; // Attribut für sie Buttons

    public JPanelName() {

        buttons = new boolean[16][12];  // Methode für die Buttons
        for(boolean[] b : buttons){
            for(boolean bool : b){
                bool = false;
            }
        }
        this.setBackground(Color.DARK_GRAY); // Farbe für den Hintergrund
        this.m = new Move();
        this.c = new Click();
        this.tm = new Timer(6, this);
        tm.start();
        addMouseMotionListener(m);
        addMouseListener(c);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, 800, 730);
        System.out.println(this.m.getMx());
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 12; j++) {
                if (m.getMx() >= spacing + i * 49 && m.getMx() < spacing + i * 49 + 49 - 2 * spacing && m.getMy() >= spacing + j * 49 + 71 + 26 && m.getMy() < j * 49 + 100 + 49 - 2 * spacing) {
                    g.setColor(Color.RED);
                    if(c.getActive()){
                        c.setActive(false);
                        buttons[i][j] = true;
                    }
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                if(buttons[i][j]){
                    g.setColor(Color.WHITE);
                }
                g.fillRect(spacing + i * 49, spacing + j * 49 + 100, 49 - 2 * spacing, 49 - 2 * spacing);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}