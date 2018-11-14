package GUI;

import GameObjects.Player;
import javax.swing.*;
import java.awt.*;

public class Etiqueta {

    private JLabel label;
    private int contador;

    public Etiqueta(){
        contador = 0;
        label = new JLabel();
        label.setText("Score: "+contador);
        label.setForeground(Color.white);
        label.setFont(new Font("",Font.PLAIN,20));
    }

    public Etiqueta(int n){
        contador = n;
        label = new JLabel();
        label.setText("Vida: "+contador);
        label.setForeground(Color.white);
        label.setFont(new Font("",Font.PLAIN,20));
    }

    public JLabel getJLabel(){
        return label;
    }

    public int getContador(){
        return contador;
    }
    public void setContador(int n){
        contador = n;
    }


}
