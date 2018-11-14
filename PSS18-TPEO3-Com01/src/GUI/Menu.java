package GUI;

import Assets.Configs;
import Assets.Paths;
import GameMaster.Level;
import Main.MetodoMain;
import Map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Menu {
    protected static Menu instance;
    protected JButton bInicio;
    protected JFrame frame;
    protected Container gameContainer,UIcontainer;
    protected Level l;

    //Atributos para el menpu de la versión 1.1
    protected JMenuBar menuBar;
    protected JMenu menu;
    protected JMenuItem menuItemReset, menuItemExit;   
    
    public static Menu getInstance(){
        if (instance==null)
            instance = new Menu();
        return instance;
    }

    private Menu(){

        frame = new JFrame();
        Container c = frame.getContentPane();
        Icon ic = new ImageIcon(Paths.MENUIMAGE);
        frame.setContentPane(new JLabel(ic));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setBounds(0,0, Configs.getConfigs().getCanvasWidth(),Configs.getConfigs().getCanvasHeight());
        c.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setSize(Configs.getConfigs().getWindowsSize());


        Dimension d= Configs.getConfigs().getWindowsSize();
        frame.setSize(new Dimension(d.width,d.height+20));
        frame.setResizable(false);




        bInicio = new JButton(new ImageIcon(Paths.STARTBUTTON));
        bInicio.setVisible(true);
        bInicio.setBounds(300,300,264,149);
        frame.getContentPane().add(bInicio);
        bInicio.addActionListener(new oyenteInicio());
        frame.repaint();
        
    	//Creación del menu de la versión 1.1
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuItemReset = new JMenuItem("Reset");
		menu.add(menuItemReset);
		menu.addSeparator();
		menuItemExit = new JMenuItem("Exit");
		menu.add(menuItemExit);
		menuBar.add(menu);
		menuBar.setVisible(false);
		frame.setJMenuBar(menuBar);
		
		//Oyente Reset
		menuItemReset.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	        	l.restart();
	        }
		});
		
		//Oyente Exit
		menuItemExit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	                System.exit(0);
	        }
		});
    }

    public void update(){
        frame.repaint();
    }

    public void showFrame(){
        frame.setVisible(true);
    }

    public void addPanels(Container gameContainer,Container UIcontainer){
        this.gameContainer = gameContainer;
        this.UIcontainer = UIcontainer;
        frame.getContentPane().add(gameContainer);
        frame.getContentPane().add(UIcontainer);
        frame.requestFocus();
    }

    public JFrame getFrame(){
        return frame;
    }


    public void newLevel(){

        l = new Level();
        l.start();
    }

    public void perder(){
        JOptionPane.showMessageDialog(null,"Mission Failed!","You have been defeated!",JOptionPane.INFORMATION_MESSAGE);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      //TODO: poner una imagen de partida perdida. Despues habría que volver al menu
    }



    private class oyenteInicio implements ActionListener{
        public void actionPerformed(ActionEvent e){
            bInicio.setVisible(false);
            menuBar.setVisible(true);
            newLevel();
        }
    }



}
