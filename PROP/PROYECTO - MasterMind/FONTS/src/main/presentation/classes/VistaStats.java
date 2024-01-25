package main.presentation.classes;

import main.domain.controllers.*;
import main.presentation.controllers.CtrlStats;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;

public class VistaStats extends JFrame {

	/**
	 * Finestra de la vista
	 */
	private final javax.swing.JFrame parent;

	/**
	 * Instància de CtrlStats
	 */
	private static CtrlStats cstats;


	/** @brief Creadora amb valors
	 *
	 * @param parent representa la finestra de la vista
	 * @param cd  representa una instància de CtrlDomain
	 */
	public VistaStats(javax.swing.JFrame parent, CtrlDomain cd) {
		
		cstats = new CtrlStats(cd);
		this.parent = parent;
		iniVistaStats();
	}


	/**
	 * @brief Funció que inicialitza la vista vistaRankings
	 * <p>
	 * Crea el panell de contingut de la vista, els botons i els textos mostrats per pantalla
	 */
	private void iniVistaStats(){
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
		
		
		JLabel wonText = new JLabel("Started Games");
		wonText.setHorizontalAlignment(SwingConstants.CENTER);
		wonText.setForeground(new Color(242, 222, 193));
		wonText.setBounds(21, 148, 142, 15);
		contentPane.add(wonText);

		JLabel startedGames = new JLabel(cstats.getStarted().toString());
		startedGames.setFont(new Font("Tahoma", Font.BOLD, 14));
		startedGames.setHorizontalAlignment(SwingConstants.CENTER);
		startedGames.setForeground(new Color(242, 222, 193));
		startedGames.setBounds(21, 169, 142, 15);
		contentPane.add(startedGames);
		
		JLabel playedText = new JLabel("Ended Games");
		playedText.setHorizontalAlignment(SwingConstants.CENTER);
		playedText.setForeground(new Color(242, 222, 193));
		playedText.setBounds(21, 202, 142, 15);
		contentPane.add(playedText);

		JLabel endedGames = new JLabel(cstats.getPartidesAcabades().toString());
		endedGames.setFont(new Font("Tahoma", Font.BOLD, 14));
		endedGames.setHorizontalAlignment(SwingConstants.CENTER);
		endedGames.setForeground(new Color(242, 222, 193));
		endedGames.setBounds(21, 223, 142, 15);
		contentPane.add(endedGames);
		
		JLabel cmPText = new JLabel("CodeMaker Points");
		cmPText.setHorizontalAlignment(SwingConstants.CENTER);
		cmPText.setForeground(new Color(242, 222, 193));
		cmPText.setBounds(21, 256, 142, 15);
		contentPane.add(cmPText);

		JLabel CMPoints = new JLabel(cstats.getPuntsCM().toString());
		CMPoints.setFont(new Font("Tahoma", Font.BOLD, 14));
		CMPoints.setHorizontalAlignment(SwingConstants.CENTER);
		CMPoints.setForeground(new Color(242, 222, 193));
		CMPoints.setBounds(21, 277, 142, 15);
		contentPane.add(CMPoints);
		
		JLabel cbPText = new JLabel("CodeBreaker Points");
		cbPText.setHorizontalAlignment(SwingConstants.CENTER);
		cbPText.setForeground(new Color(242, 222, 193));
		cbPText.setBounds(21, 310, 142, 15);
		contentPane.add(cbPText);

		JLabel CBPoints = new JLabel(cstats.getPuntsCB().toString());
		CBPoints.setFont(new Font("Tahoma", Font.BOLD, 14));
		CBPoints.setHorizontalAlignment(SwingConstants.CENTER);
		CBPoints.setForeground(new Color(242, 222, 193));
		CBPoints.setBounds(21, 331, 142, 15);
		contentPane.add(CBPoints);

		JLabel ajutsText = new JLabel("Helps Used");
		ajutsText.setHorizontalAlignment(SwingConstants.CENTER);
		ajutsText.setForeground(new Color(242, 222, 193));
		ajutsText.setBounds(21, 364, 142, 15);
		contentPane.add(ajutsText);
		
		JLabel ajuts = new JLabel(cstats.getAjuts().toString());
		ajuts.setHorizontalAlignment(SwingConstants.CENTER);
		ajuts.setForeground(new Color(242, 222, 193));
		ajuts.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajuts.setBounds(21, 385, 142, 15);
		contentPane.add(ajuts);
		
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
		
		JButton buttonExit = new JButton("Return");
		buttonExit.addActionListener(this::returnMainMenu);
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonExit.setBackground(new Color(242, 222, 193));
		buttonExit.setBounds(33, 467, 117, 25);
		contentPane.add(buttonExit);
		
		JPanel statsMenu = new JPanel();
		statsMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		statsMenu.setBackground(new Color(0, 128, 0));
		statsMenu.setBounds(13, 129, 158, 290);
		contentPane.add(statsMenu);
		
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


	/** @brief Funció que retorna al menú principal quan es polsa el botó return
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void returnMainMenu(java.awt.event.ActionEvent evt) {
		
		parent.setVisible(true);
		dispose();
	}
}
