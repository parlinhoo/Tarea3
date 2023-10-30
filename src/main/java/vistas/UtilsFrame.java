package vistas;

// Libreria que creé que tiene varias funciones útiles para trabajar con las posiciones y tamaños variables de ventana

import java.awt.*;

public class UtilsFrame {
    public static void posicionPorcentual(Container frame, double posX, double posY) {
        Container parent = frame.getParent();
        frame.setLocation((int) (parent.getWidth() * posX), (int) (parent.getHeight() * posY));
    }
    public static void tamanoPorcentual(Container frame, double sizeX, double sizeY) {
        Container parent = frame.getParent();
        frame.setSize((int) (parent.getWidth() * sizeX), (int) (parent.getHeight() * sizeY));
    }

    public static void boundsPorcentual(Container frame, double posX, double posY, double sizeX, double sizeY) {
        UtilsFrame.posicionPorcentual(frame, posX, posY);
        UtilsFrame.tamanoPorcentual(frame, sizeX, sizeY);
    }
}
