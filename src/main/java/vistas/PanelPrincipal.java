package vistas;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal () {
        com = new PanelComprador();
        exp = new PanelExpendedor ();
        this.setLayout(new GridLayout(1, 2));
        this.add(com);
        this.add(exp);
        this.setBackground(Color.white);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        exp.paint(g);
        com.paint(g);
    }
}