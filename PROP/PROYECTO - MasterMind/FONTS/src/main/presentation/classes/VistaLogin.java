package main.presentation.classes;

import main.presentation.controllers.CtrlLogin;
import main.domain.classes.Exceptions.*;
import main.domain.controllers.CtrlDomain;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;


public class VistaLogin extends javax.swing.JFrame {

	/**
	 * Instància de CtrlLogin
	 */
	private static CtrlLogin clogin;

	/**
	 * Camp de text per introduir el nom d'usuari
	 */
	private JTextField user;

	/**
	 * Camp de text per introduir la contrasenya
	 */
	private JPasswordField pswd;

	/**
	 * Text per mostrar per pantalla
	 */
	private JLabel missatge;


	/** @brief Creadora amb valors. Inicialitza la vista
	 *
	 * @param clogin  representa una instància de CtrlLogin
	 */
	public VistaLogin(CtrlLogin clogin) {
		VistaLogin.clogin = clogin;
		InitVistaLogin();
	}


	/**
	 * @brief Creadora per defecte. Inicialitza la vista
	 */
	public VistaLogin() {
		InitVistaLogin();
	}


	/** @brief Creadora amb valors. Inicialitza la vista
	 *
	 * @param cd  representa una instància de CtrlDomain
	 */
	public VistaLogin(CtrlDomain cd) {
		
		clogin.setCD(cd);
		
		InitVistaLogin();
	}


	/**
	 * @brief Funció que inicialitza la vista VistaLogin
	 * <p>
	 * Crea el panell de contingut de la vista,  els camps de texts, els botons i els textos mostrats per pantalla
	 */
	private void InitVistaLogin() {
		setResizable(false);
		setTitle("Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 566);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 222, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon arrow = new ImageIcon(getClass().getClassLoader().getResource("arrow.png"));
		Image getarrow = arrow.getImage();
		Image modarrow = getarrow.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		arrow = new ImageIcon(modarrow);
		
		ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("bg_m.jpg"));
		Image getBg = bg.getImage();
		Image modBg = getBg.getScaledInstance(400, 600, java.awt.Image.SCALE_SMOOTH);
		bg = new ImageIcon(modBg);

		ImageIcon bg2 = new ImageIcon(getClass().getClassLoader().getResource("bg_w.jpg"));
		Image getBg2 = bg2.getImage();
		Image modBg2 = getBg2.getScaledInstance(225, 600, java.awt.Image.SCALE_SMOOTH);
		bg2 = new ImageIcon(modBg2);
		
		user = new JTextField();
		user.setBackground(new Color(242, 222, 193));
		user.setBounds(33, 148, 114, 42);
		contentPane.add(user);
		user.setColumns(10);
		user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userKeyPressed(evt);
            }
        });
		
		pswd = new JPasswordField();
		pswd.setBackground(new Color(242, 222, 193));
		pswd.setBounds(33, 213, 114, 42);
		contentPane.add(pswd);
        pswd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswdKeyPressed(evt);
            }
        });

		JButton buttonSignUp = new JButton("Create Account");
		buttonSignUp.addActionListener(this::botoSignUpActionPerformed);
		buttonSignUp.setForeground(new Color(0, 0, 0));
		buttonSignUp.setBackground(new Color(242, 222, 193));
		buttonSignUp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		buttonSignUp.setBounds(33, 486, 114, 15);
		contentPane.add(buttonSignUp);
		
		JLabel bgImg = new JLabel("");
		bgImg.setIcon(bg);
		bgImg.setBounds(187, 0, 371, 529);
		contentPane.add(bgImg);
		
		JLabel textSignIn = new JLabel("Log in");
		textSignIn.setForeground(new Color(0, 0, 0));
		textSignIn.setFont(new Font("Myanmar Text", Font.BOLD, 14));
		textSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		textSignIn.setBounds(52, 100, 58, 25);
		contentPane.add(textSignIn);
		
		JLabel textUsername = new JLabel("Username");
		textUsername.setForeground(new Color(0, 0, 0));
		textUsername.setFont(new Font("Myanmar Text", Font.BOLD, 11));
		textUsername.setBounds(33, 136, 64, 14);
		contentPane.add(textUsername);
		
		JLabel textPassword = new JLabel("Password");
		textPassword.setForeground(new Color(0, 0, 0));
		textPassword.setFont(new Font("Myanmar Text", Font.BOLD, 11));
		textPassword.setBounds(33, 201, 64, 14);
		contentPane.add(textPassword);

		JButton buttonLogIn = new JButton("");
		buttonLogIn.setBounds(65, 333, 45, 45);
		contentPane.add(buttonLogIn);
		buttonLogIn.setBackground(new Color(242, 222, 193));
		buttonLogIn.setIcon(arrow);
		buttonLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonLogIn.addActionListener(this::botoLogInActionPerformed);
		
		JLabel titleM1 = new JLabel("M");
		titleM1.setForeground(new Color(255, 0, 0));
		titleM1.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleM1.setBounds(18, 28, 27, 31);
		contentPane.add(titleM1);
		
		JLabel titleA = new JLabel("A");
		titleA.setForeground(new Color(0, 215, 11));
		titleA.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleA.setBounds(37, 28, 27, 31);
		contentPane.add(titleA);
		
		JLabel titleS = new JLabel("S");
		titleS.setForeground(new Color(0, 0, 255));
		titleS.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleS.setBounds(54, 28, 27, 31);
		contentPane.add(titleS);
		
		JLabel titleT = new JLabel("T");
		titleT.setForeground(new Color(255, 255, 0));
		titleT.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleT.setBounds(71, 28, 27, 31);
		contentPane.add(titleT);
		
		JLabel titleE = new JLabel("E");
		titleE.setForeground(new Color(255, 255, 255));
		titleE.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleE.setBounds(90, 28, 27, 31);
		contentPane.add(titleE);
		
		JLabel titleR = new JLabel("R");
		titleR.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleR.setBounds(108, 28, 27, 31);
		contentPane.add(titleR);
		
		JLabel titleM2 = new JLabel("M");
		titleM2.setForeground(new Color(255, 0, 0));
		titleM2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleM2.setBounds(75, 51, 27, 31);
		contentPane.add(titleM2);
		
		JLabel titleI = new JLabel("I");
		titleI.setForeground(new Color(0, 215, 11));
		titleI.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleI.setBounds(97, 51, 27, 31);
		contentPane.add(titleI);
		
		JLabel titleN = new JLabel("N");
		titleN.setForeground(new Color(0, 0, 255));
		titleN.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleN.setBounds(117, 51, 27, 31);
		contentPane.add(titleN);
		
		JLabel titleD = new JLabel("D");
		titleD.setForeground(new Color(255, 255, 0));
		titleD.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleD.setBounds(136, 51, 27, 31);
		contentPane.add(titleD);
		
		missatge = new JLabel("");
		missatge.setHorizontalAlignment(SwingConstants.CENTER);
		missatge.setFont(new Font("Dialog", Font.BOLD, 14));
		missatge.setForeground(Color.RED);
		missatge.setBounds(-26, 270, 225, 15);
		contentPane.add(missatge);
		
		JLabel b2Img = new JLabel("");
		b2Img.setBackground(new Color(164, 104, 23));
		b2Img.setIcon(bg2);
		b2Img.setBounds(0, 0, 225, 529);
		contentPane.add(b2Img);
		
		
	}


	/** @brief Funció que inicia la sessió de l'usuari actual quan es polsa el botó Log In
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void botoLogInActionPerformed(java.awt.event.ActionEvent evt) {
		
		String u = user.getText();
		String psw = new String(pswd.getPassword());

			if (u.isBlank()) {
				user.setText("");
				pswd.setText("");
				missatge.setText("User Incorrect");
			}
			else if (!(clogin.existeixUsuari(u))) {
				user.setText("");
				pswd.setText("");
				missatge.setText("User not exists");
			}
			else {
				try {
					clogin.login(u, psw);
					user.setText("");
					pswd.setText("");
					VistaMainMenu vistaMenu = new VistaMainMenu(this, clogin);
					vistaMenu.setVisible(true);
					this.setVisible(false);
					
				} catch(FileNotFoundException usuarijaexisteix) {
					missatge.setText("User already exists");
				}
				 catch(ContrasenyaIncorrecte contrasenyaincorrecte) {
				missatge.setText("Password incorrect");
				pswd.setText("");
				}
			}
    }


	/** @brief Funció que mostra el menu de registre d'usuari quan es polsa el botó Sign Up
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void botoSignUpActionPerformed(java.awt.event.ActionEvent evt) {
		missatge.setText("");
		VistaSignUp vistaSignUp = new VistaSignUp(this, clogin);
		vistaSignUp.setVisible(true);
		this.setVisible(false);
	}


	/** @brief Funció que es llença quan l'usuari mou el ratoli pel panell de continguts
	 *
	 * @param evt representa el event MouseEvent de la llibreria de java awt
	 */
	private void userMouseClicked(MouseEvent evt) {
		user.setEditable(true);
	}


	/** @brief Funció que es llença quan l'usuari prem una tecla del teclat
	 *
	 * @param evt representa el event KeyEvent de la llibreria de java awt
	 */
	private void userKeyPressed(java.awt.event.KeyEvent evt) {
		char c = evt.getKeyChar();
		user.setEditable(c != ' ');
	}


	/** @brief Funció que es llença quan l'usuari prem una tecla del teclat en el camp de text de la contrasenya
	 *
	 * @param evt representa el event KeyEvent de la llibreria de java awt
	 */
	private void pswdKeyPressed(java.awt.event.KeyEvent evt) {
		char c = evt.getKeyChar();
		pswd.setEditable(c != ' ');
	}

}
