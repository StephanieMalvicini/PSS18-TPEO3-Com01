package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Assets.Configs;
import Assets.Paths;

public class LogIn{
	// Versión 2.0
	protected JTextField user;
	protected JPasswordField pwd; 
	protected JLabel lUser, lPwd; 
	protected JButton bOk;
	protected JPanel contentPane;
	protected Map<String, String> users; 
	protected String admin,userName; 
	protected Menu menu; 

	// Versión 3.0
	protected JFrame frameComments;
	protected Container containerComments;

	public LogIn(Menu menu) {
		this.menu = menu; 
		users = new HashMap<String, String>(); 
		readFile(); 

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(null);		
		int x = Configs.getConfigs().getWindowsSize().width/2 - 80; 
		int y = Configs.getConfigs().getWindowsSize().height/2 - 150; 
		contentPane.setBounds(x, y, 180, 200);

		lUser = new JLabel("User: "); 
		lUser.setBounds(10, 10, 160, 25);

		user = new JTextField();
		user.setBounds(10, 40, 160, 25);

		lPwd = new JLabel("Password: "); 
		lPwd.setBounds(10, 70, 160, 25);

		pwd = new JPasswordField();
		pwd.setBounds(10, 100, 160, 25);

		bOk = new JButton("OK");
		bOk.setBounds(10, 150, 160, 25);
		bOk.addActionListener(new oyenteLogIn());

		contentPane.add(lUser); 
		contentPane.add(user);
		contentPane.add(lPwd); 
		contentPane.add(pwd);
		contentPane.add(bOk);
	}

	public JPanel getLogInPanel() {
		return contentPane; 
	}
	
	public String getUserName(){
		return userName; 
	}
	
	public void hideComments() {
		frameComments.setVisible(false);
	}

	private void readFile() {
		try {
			BufferedReader in = new BufferedReader (new FileReader (Paths.USERS.getPath()));
			admin=in.readLine(); 
			String str; 
			while ((str=in.readLine())!=null){
				String[] usersAux = str.split("-");
				users.put(usersAux[1], usersAux[0]); 
			}
			in.close(); 
		}
		catch (IOException err){
			JOptionPane.showMessageDialog(null, "Oops:\n"
					+ "It has been an error loading the files.",  
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class oyenteLogIn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			char pass[] = pwd.getPassword();
			String password = new String(pass);
			if(users.containsValue(user.getText())){
				if (users.get(password)!=null && users.get(password).equals(user.getText())){
					contentPane.setVisible(false);
					menu.loggedIn(); 
					userName = user.getText(); 
					if(userName.equals(admin)) {
						showComments(); 
					}
					user.setText("");
					pwd.setText("");
				}
				else 
					showErrorMessage(); 
			}
			else 
				showErrorMessage(); 
		}
	}
	
	private void showErrorMessage() {
		JOptionPane.showMessageDialog(null, "Denied accesss:\n"
				+ "Please enter your username and/or password correctly",  
				"Denied access", JOptionPane.ERROR_MESSAGE);
	}
	
	private void showComments(){
		frameComments = new JFrame("Comments");
		frameComments.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frameComments.setLayout(null);
		frameComments.setSize(500,400);
		frameComments.setVisible(false);
		try {
			String path = "src/Assets/comments.txt"; 
			BufferedReader in = new BufferedReader(new FileReader (path));
			String str=in.readLine(); 

			if(str!=null){
				String[] comments = str.split("-");	        	
				JPanel comentarios = new JPanel();
				comentarios.setLayout(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				Border eBorder = BorderFactory.createEtchedBorder();
				comentarios.setBorder(BorderFactory.createTitledBorder(eBorder, "Users' comments"));
				gbc.fill = GridBagConstraints.BOTH;
				gbc.anchor = GridBagConstraints.NORTHWEST;
				JTextArea label; String[] comentario; 
				for(int i=0; i<comments.length; i++) {
					gbc.gridy = i; 
					comentario = comments[i].split(":"); 
					label = new JTextArea();
					label.setText(comentario[0]+"::\n"+comentario[1]);
					label.setEditable(false);
					label.setLineWrap(true);
					label.setSize(new Dimension(450,60));
					comentarios.add(label, gbc); 
				}
				JScrollPane scrollableList = new JScrollPane(comentarios);

				containerComments = frameComments.getContentPane();
				containerComments.setLayout(new BorderLayout());
				containerComments.add(scrollableList); 
				containerComments.setVisible(true);

				frameComments.setVisible(true);
			}
			in.close(); 
		}
		catch (FileNotFoundException err){}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Oops:\n"
					+ "It has been an error loading the comments.",  
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

