package GUI;

import GameObjects.Player;
import Map.Map;

import javax.swing.*;

public class ScoreManager implements IUpdatable
{
    private Etiqueta score;
    private Etiqueta vidaJugador;

    private static
    ScoreManager instance = null;

    public static ScoreManager getInstance(){
        if (instance==null)
            instance = new ScoreManager();
        return instance;

    }

    private ScoreManager(){
        score = new Etiqueta();
        vidaJugador = new Etiqueta(Player.getInstance().getHealth());
    }

    public void modificarScore(int n){
        score.setContador(score.getContador() + n);
        score.getJLabel().setText("Score :"+ score.getContador());
    }
    public void modificarVida(int n){
        vidaJugador.setContador(n);
        vidaJugador.getJLabel().setText(("Vida :"+vidaJugador.getContador()));
    }

    public JLabel getScore(){
        return score.getJLabel();
    }

    public JLabel getVidaJugador(){
        return vidaJugador.getJLabel();
    }

    @Override
    public void update(Map map) {
        modificarVida(Player.getInstance().getHealth());
    }

    @Override
    public void destroyMe(Map map) {

    }
}
