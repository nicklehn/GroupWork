package View;

import javax.swing.*;
import java.awt.*;

public class PlayField {

    JFrame jf;
    JPanelName jpn;
    Container contentPane;


    public static int width = 800, height = 730;

    public void create() {
        jf = new JFrame("Minesweeper");
        jf.setSize(width, height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);

        jpn = new JPanelName(); //aus der Klasse JPanel
        jf.setContentPane(jpn); // damit wird der Hintergrund erstellt


        Move move = new Move(); // das ist für die Bewegung der Maus zuständig
        jf.addMouseMotionListener(move);

        Click click = new Click();  // das ist für das klicken der Maus zuständig
        jf.addMouseListener(click);

        jf.requestFocus();
        jf.setVisible(true);
    }
}
