package vistas;
import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {

    public PanelComprador(){
        this.setBackground(new Color(135, 206, 250));
        this.setLayout(null);

        this.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        this.paintComponents(g);
    }
}
