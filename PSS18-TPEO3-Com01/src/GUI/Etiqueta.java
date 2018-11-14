package GUI;

import javax.swing.*;
import java.awt.*;

public class Etiqueta {

    private JLabel label;
    private float contador;

    public Etiqueta(){
        contador = 0;
        label = new JLabel();
        label.setText("Score: "+contador);
        label.setForeground(Color.white);
        label.setFont(new Font("",Font.PLAIN,10));
    }

    public Etiqueta(float n){
        contador = n;
        label = new JLabel();
        label.setText("Vida: "+contador);
        label.setForeground(Color.white);
        label.setFont(new Font("",Font.PLAIN,10));
    }

    public JLabel getJLabel(){
        return label;
    }

    public float getContador(){
        return contador;
    }

    public void setContador(float n){
        contador = n;
    }


}
