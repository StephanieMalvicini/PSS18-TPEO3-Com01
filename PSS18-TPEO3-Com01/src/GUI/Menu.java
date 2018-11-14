package GUI;

import Assets.Configs;
import Assets.Paths;
import GameMaster.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Menu {
    protected static Menu instance;
    protected JButton bInicio;
    protected JFrame frame;
    protected Container gameContainer,UIcontainer;
    protected Level l;

    //Atributos para el menu de la versi�n 1.1
    protected JMenuBar menuBar;
    protected JMenu menu;
    protected JMenuItem menuItemRestart, menuItemExit, menuItemComment;   
    
    //Atributos para el menu de la version 1.2
    protected JFrame frameComment;
    protected Container containerComment;
    protected JButton bComment;
    protected JTextArea textAreaComment;
    
    //Atributos para el menu de la versión 2.0
    protected LogIn logIn; 
    
    //Atributos para el menu de la versión 3.0
    protected JMenuItem menuItemLogOut; 
    protected boolean wasLogged = false; 

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
        bInicio.setVisible(false);
        bInicio.setBounds(300,300,264,149);
        frame.getContentPane().add(bInicio);
        bInicio.addActionListener(new oyenteInicio());
        
        logIn = new LogIn(this); 
        JPanel logInPanel = logIn.getLogInPanel(); 
        logInPanel.setVisible(true);
        frame.getContentPane().add(logInPanel);

        frame.repaint();

        //Creación del menu de la versión 1.1
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuItemRestart = new JMenuItem("Restart");
        menu.add(menuItemRestart);
        menu.addSeparator();
        menuItemComment = new JMenuItem("Comment");
        menu.add(menuItemComment);
        menu.addSeparator();
        menuItemLogOut = new JMenuItem("Log out"); 
        menu.add(menuItemLogOut); 
        menu.addSeparator(); 
        menuItemExit = new JMenuItem("Exit");
        menu.add(menuItemExit);
        menuBar.add(menu);
        menuBar.setVisible(false);
        frame.setJMenuBar(menuBar);

        //Oyente Reset
        menuItemRestart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		l.restart();
        	}
        });

        //Oyente Comment
        menuItemComment.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		frameComment = new JFrame("Add a comment");
        		frameComment.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        		frameComment.setLayout(null);
        		frameComment.setSize(500,400);
        		containerComment = frameComment.getContentPane();
        		containerComment.setLayout(null);

        		bComment = new JButton("Comment");
        		bComment.setBounds(200,330,100,20);
        		containerComment.add(bComment);
        		textAreaComment = new JTextArea();
        		textAreaComment.setBounds(5,5,475,320);
        		containerComment.add(textAreaComment);

        		frameComment.setVisible(true);

        		bComment.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent ev) {
        				frameComment.setVisible(false);
        				String comment = textAreaComment.getText();
        				try {
        					String path = "src/Assets/comments.txt"; 
        					File archivo= new File(path);
        					FileWriter fw = new FileWriter(archivo.getAbsolutePath(),true);
        					fw.write(logIn.getUserName()+":"+comment+"-");
        					fw.close();
        				}
        				catch(IOException e) {

        				}

        			}
        		});

        	}
        });

        //Oyente Exit
        menuItemExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		System.exit(0);
        	}
        });

        //Oyente Log Out
        menuItemLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		wasLogged=true;  
        		//Window.GetWindow().hide();
        		l.esperar();
        		menuBar.setVisible(false);
        		logInPanel.setVisible(true);
        		update(); 
        	}
        });
    }

    public void update(){
        frame.repaint();
    }

    public void showFrame(){
        frame.setVisible(true);
    }
    
    public void loggedIn() {
    	if(wasLogged) {
    		menuBar.setVisible(true);
    		logIn.hideComments();
    		Window.GetWindow().Show(); 
    		Window.GetWindow().addListener(MyListener.Instance());
    		frame.requestFocus();
    		l.resumir();
    	}
    	else {
    		bInicio.setVisible(true);
    	}
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
      //TODO: poner una imagen de partida perdida. Despues habr�a que volver al menu
    }



    private class oyenteInicio implements ActionListener{
        public void actionPerformed(ActionEvent e){
            bInicio.setVisible(false);
            menuBar.setVisible(true);
            logIn.hideComments();
            newLevel();
            update();
        }
    }



}
