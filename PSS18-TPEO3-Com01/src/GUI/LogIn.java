package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Assets.Configs;
import Assets.Paths;

public class LogIn{
	JTextField user;
	JPasswordField pwd; 
	JLabel lUser, lPwd; 
	JButton bOk, bStart;
	JPanel contentPane;
	Map<String, String> users; 

	public LogIn(JButton bStart) {
		this.bStart = bStart; 
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
		bOk.setBounds(10, 140, 160, 25);
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

	private void readFile() {
		try {
			BufferedReader in = new BufferedReader (new FileReader (Paths.USERS.getPath()));
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

	private void showErrorMessage() {
		JOptionPane.showMessageDialog(null, "Denied accesss:\n"
				+ "Please enter your username and/or password correctly",  
				"Denied access", JOptionPane.ERROR_MESSAGE);
	}

	private class oyenteLogIn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			char pass[] = pwd.getPassword();
			String password = new String(pass);
			if(users.containsValue(user.getText())){
				if (users.get(password)!=null && users.get(password).equals(user.getText())){
					contentPane.setVisible(false);
					bStart.setVisible(true);
				}
				else 
					showErrorMessage(); 
			}
			else 
				showErrorMessage(); 
		}
	}
}

