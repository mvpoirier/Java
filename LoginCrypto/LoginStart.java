import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * Java Simplified Encryption Library (jasypt-1.9.3)
 * http://www.jasypt.org/
 * https://github.com/jasypt/jasypt
 * 
 * https://stackoverflow.com/questions/4962559/import-libraries-in-eclipse
 * https://stackoverflow.com/questions/29226813/simple-encryption-in-java-no-key-password
 * http://www.jasypt.org/easy-usage.html
 */
import org.jasypt.util.text.BasicTextEncryptor;

public class LoginStart extends JFrame {

	private JPanel contentPane;
	private BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

	public LoginStart(JFrame manager) {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		setAlwaysOnTop(true);
		
		String myEncryptionPassword = "eggs";
		textEncryptor.setPassword(myEncryptionPassword);
		
		String myEncryptedText = textEncryptor.encrypt("Login Start");
		String plainText = textEncryptor.decrypt(myEncryptedText);
		
		setTitle(myEncryptedText + " " + plainText);
		
		/*
		 * Close LoginStart, Open LoginManager
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//textEncryptor.setPassword(myEncryptionPassword);
				
				String myEncryptedText2 = textEncryptor.encrypt("Login Closed!");
				String plainText2 = textEncryptor.decrypt(myEncryptedText2);
				
				manager.setTitle(myEncryptedText2 + " " + plainText2);
				
				//manager.setTitle("Login Closed!");
				manager.setVisible(true);
				setVisible(false);
			}
		});
	}
}
