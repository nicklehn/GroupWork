package View;

import javax.swing.*;

public class PlayField {

        JFrame jf;


        public static int width = 800, height = 600;

        public void create() {
                jf = new JFrame("Minesweeper");
                jf.setSize(width, height);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setLocationRelativeTo(null);
                jf.setLayout(null);
                jf.setResizable(false);


                jf.requestFocus();
                jf.setVisible(true);

        }
}
