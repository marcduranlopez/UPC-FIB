package main.presentation.classes;

import main.presentation.controllers.CtrlLogin;

import main.presentation.controllers.CtrlPlay;
import main.presentation.controllers.CtrlMainMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.presentation.controllers.CtrlSignUp;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class VistaMainMenu extends javax.swing.JFrame {

	/**
	 * Instància de CtrlMainMenu
	 */
	private final CtrlMainMenu cmainmenu;

	/**
	 * Finestra de la vista
	 */
	private final javax.swing.JFrame parent;


	/** @brief Creadora amb valors
	 *
	 * @param parent representa la finestra de la vista
	 * @param clogin  representa una instància de CtrlLogin
	 */
	public VistaMainMenu(javax.swing.JFrame parent, CtrlLogin clogin) {
		cmainmenu = new CtrlMainMenu(clogin.getCD());
		this.parent = parent;
		InitVistaMainMenu();
	}


	/** @brief Creadora amb valors
	 *
	 * @param parent representa la finestra de la vista
	 * @param csignup  representa una instància de CtrlSignUp
	 */
	public VistaMainMenu(javax.swing.JFrame parent, CtrlSignUp csignup) {
		cmainmenu = new CtrlMainMenu(csignup.getCD());
		this.parent = parent;
		InitVistaMainMenu();
	}


	/** @brief Creadora amb valors
	 *
	 * @param parent representa la finestra de la vista
	 * @param cPlay  representa una instància de CtrlPlay
	 */
	public VistaMainMenu(javax.swing.JFrame parent, CtrlPlay cPlay) {
		cmainmenu = new CtrlMainMenu(cPlay.getCD());
		this.parent = parent;
		InitVistaMainMenu();
	}

	/**
	 * @brief Funció que inicialitza la vista vistaMainMenu
	 * <p>
	 * Crea el panell de contingut de la vista, els botons i els textos mostrats per pantalla
	 */
	public void InitVistaMainMenu() {
		setResizable(false);
		setTitle("Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 566);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 222, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("bg_m.jpg"));
		Image getBg = bg.getImage();
		Image modBg = getBg.getScaledInstance(400, 600, java.awt.Image.SCALE_SMOOTH);
		bg = new ImageIcon(modBg);

		ImageIcon bg2 = new ImageIcon(getClass().getClassLoader().getResource("bg_w.jpg"));
		Image getBg2 = bg2.getImage();
		Image modBg2 = getBg2.getScaledInstance(225, 600, java.awt.Image.SCALE_SMOOTH);
		bg2 = new ImageIcon(modBg2);
				
		JButton buttonPlay = new JButton("Play");
		buttonPlay.addActionListener(this::btnPlayActionPerformed);
		buttonPlay.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonPlay.setBackground(new Color(242, 222, 193));
		buttonPlay.setBounds(33, 122, 117, 25);
		contentPane.add(buttonPlay);
		
		JButton buttonLoadGame = new JButton("Load Game");
		buttonLoadGame.addActionListener(this::btnLoadGameActionPerformed);
		buttonLoadGame.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonLoadGame.setBackground(new Color(242, 222, 193));
		buttonLoadGame.setBounds(33, 173, 117, 25);
		contentPane.add(buttonLoadGame);
		
		JButton buttonRankings = new JButton("Rankings");
		buttonRankings.addActionListener(this::btnRankingsActionPerformed);
		buttonRankings.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonRankings.setBackground(new Color(242, 222, 193));
		buttonRankings.setBounds(33, 224, 117, 25);
		contentPane.add(buttonRankings);
		
		JButton buttonStats = new JButton("Stats");
		buttonStats.addActionListener(this::btnStatsActionPerformed);
		buttonStats.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonStats.setBackground(new Color(242, 222, 193));
		buttonStats.setBounds(33, 275, 117, 25);
		contentPane.add(buttonStats);
		
		JButton buttonLogOut = new JButton("Log Out");
		buttonLogOut.addActionListener(this::btnLogOutActionPerformed);
		buttonLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonLogOut.setBackground(new Color(242, 222, 193));
		buttonLogOut.setBounds(33, 326, 117, 25);
		contentPane.add(buttonLogOut);
		
		JButton buttonExit = new JButton("Exit");
		buttonExit.addActionListener(this::exit);
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonExit.setBackground(new Color(242, 222, 193));
		buttonExit.setBounds(33, 467, 117, 25);
		contentPane.add(buttonExit);
		
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
		
		JLabel bgImg = new JLabel("");
		bgImg.setIcon(bg);
		bgImg.setBounds(187, 0, 371, 529);
		contentPane.add(bgImg);
		
		JLabel b2Img = new JLabel("");
		b2Img.setBackground(new Color(164, 104, 23));
		b2Img.setIcon(bg2);
		b2Img.setBounds(0, 0, 225, 529);
		contentPane.add(b2Img);
	}


	/** @brief Funció que tanca la sessió de l'usuari actual quan es polsa el botó Log Out
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {
		
		VistaLogin login = new VistaLogin(cmainmenu.getCD());
		login.setVisible(true);
		dispose();
	}


	/** @brief Funció que mostra els stats de l'usuari carregat quan es polsa el botó Stats
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {
		
		VistaStats stats = new VistaStats(this, cmainmenu.getCD());
		stats.setVisible(true);
		dispose();
	}


	/** @brief Funció que mostra el Ranking amb els records del sistema quan es polsa el botó Ranking
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void btnRankingsActionPerformed(java.awt.event.ActionEvent evt) {
		
		VistaRankings ranks = new VistaRankings(this, cmainmenu.getCD());
		ranks.setVisible(true);
		dispose();
	}


	/** @brief Funció que mostra les partides guardades de l'usuari quan es polsa el botó Load Game
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void btnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {
		
		VistaLoadGame loadgame = new VistaLoadGame(this, cmainmenu.getCD());
		loadgame.setVisible(true);
		dispose();
	}


	/** @brief Funció que mostra el menú de crear partida quan es polsa el botó play
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {
		
		VistaCrearPartida crearpartida = new VistaCrearPartida(this, cmainmenu);
		crearpartida.setVisible(true);
		dispose();
	}


	/** @brief Funció que surt de l'aplicació quan es polsa el botó exit
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void exit(java.awt.event.ActionEvent evt) {
		
		System.exit(0);
	}
}
