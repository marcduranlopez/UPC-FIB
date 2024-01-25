package main.presentation.classes;

import main.domain.classes.Exceptions.DificultatNoExisteix;
import main.presentation.controllers.CtrlCrearPartida;
import main.presentation.controllers.CtrlMainMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.util.Objects;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class VistaCrearPartida extends JFrame {

	/**
	 * Instància de CtrlCrearPartida
	 */
	private static CtrlCrearPartida cCrearPartida;

	/**
	 * Finestra de la vista
	 */
	private final javax.swing.JFrame parent;

	/**
	 * boolean fals
	 */
	private final boolean False = false;

	/**
	 * Rol seleccionat
	 */
	private String Rol;

	/**
	 * Dificultat de la partida
	 */
	private Integer Dificultat;

	/**
	 * Algorime de la partida
	 */
	private Integer Algorithm;


	/**
	 * Botó per seleccionar CodeBreaker
	 */
	private JRadioButton radioButton_CB;

	/**
	 * Botó per seleccionar CodeMaker
	 */
	private JRadioButton radioButton_CM;

	/**
	 * Botó per seleccionar dificultat fàcil
	 */
	private JRadioButton radioButton_Easy;

	/**
	 * Botó per seleccionar dificultat mitjana
	 */
	private JRadioButton radioButton_Medium;

	/**
	 * Botó per seleccionar dificultat dificil
	 */
	private JRadioButton radioButton_Hard;

	/**
	 * Botó per seleccionar jugar amb l'algorisme FiveGuess
	 */
	private JRadioButton radioButton_FG;

	/**
	 * Botó per seleccionar jugar amb l'algorisme Genetic
	 */
	private JRadioButton radioButton_G;

	/**
	 * Text per mostrar per pantalla
	 */
	private JLabel missatge;


	/** @brief Creadora amb valors
	 *
	 * @param parent representa la finestra de la vista
	 * @param cmainmenu  representa una instància de CtrlMainMenu
	 */
	public VistaCrearPartida(javax.swing.JFrame parent, CtrlMainMenu cmainmenu) {
		cCrearPartida = new CtrlCrearPartida(cmainmenu.getCD());
		this.parent = parent;
		InitVistaCrearPartida();
	}

	/**
	 * @brief Funció que inicialitza la vista vistaCrearPartida
	 * <p>
	 * Crea el panell de contingut de la vista, els botons i els textos mostrats per pantalla
	 */
	public void InitVistaCrearPartida() {
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
		
		JLabel textRol = new JLabel("Role:");
		textRol.setFont(new Font("Myanmar Text", Font.BOLD, 11));
		textRol.setBounds(22, 100, 35, 15);
		contentPane.add(textRol);
		
		JButton buttonPlay = new JButton("");
		buttonPlay.setBounds(65, 388, 45, 45);
		contentPane.add(buttonPlay);
		buttonPlay.setBackground(new Color(242, 222, 193));
		buttonPlay.setIcon(arrow);
		buttonPlay.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonPlay.addActionListener(this::botoPlayPerformed);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(this::returnMainMenu);

		btnReturn.setBackground(new Color(242, 222, 193));
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReturn.setBounds(31, 479, 117, 25);
		contentPane.add(btnReturn);
		
		radioButton_CM = new JRadioButton("CodeMaker");
		radioButton_CM.addActionListener(e -> {

			radioButton_CB.setSelected(False);
			Rol = "CodeMaker";
		});
		radioButton_CM.setBackground(new Color(242, 222, 193));
		radioButton_CM.setBounds(22, 114, 141, 23);
		contentPane.add(radioButton_CM);
		
		radioButton_CB = new JRadioButton("CodeBreaker");
		radioButton_CB.addActionListener(e -> {

			radioButton_CM.setSelected(False);
			Rol = "CodeBreaker";
		});
		radioButton_CB.setBackground(new Color(242, 222, 193));
		radioButton_CB.setBounds(22, 140, 141, 23);
		contentPane.add(radioButton_CB);
		
		JLabel textDificultat = new JLabel("Dififculty:");
		textDificultat.setFont(new Font("Myanmar Text", Font.BOLD, 11));
		textDificultat.setBounds(22, 184, 76, 15);
		contentPane.add(textDificultat);

		radioButton_Easy = new JRadioButton("Easy");
		radioButton_Easy.addActionListener(e -> {

			radioButton_Medium.setSelected(False);
			radioButton_Hard.setSelected(False);
			Dificultat = 1;
		});
		radioButton_Easy.setBackground(new Color(242, 222, 193));
		radioButton_Easy.setBounds(22, 196, 141, 23);
		contentPane.add(radioButton_Easy);
		
		radioButton_Medium = new JRadioButton("Medium");
		radioButton_Medium.addActionListener(e -> {

			radioButton_Easy.setSelected(False);
			radioButton_Hard.setSelected(False);
			Dificultat = 2;
		});
		radioButton_Medium.setBackground(new Color(242, 222, 193));
		radioButton_Medium.setBounds(22, 222, 141, 23);
		contentPane.add(radioButton_Medium);
		
		radioButton_Hard = new JRadioButton("Hard");
		radioButton_Hard.addActionListener(e -> {

			radioButton_Easy.setSelected(False);
			radioButton_Medium.setSelected(False);
			Dificultat = 3;
		});
		radioButton_Hard.setBackground(new Color(242, 222, 193));
		radioButton_Hard.setBounds(22, 248, 141, 23);
		contentPane.add(radioButton_Hard);
		
		JLabel textAlgorithm = new JLabel("Algorithm:");
		textAlgorithm.setFont(new Font("Myanmar Text", Font.BOLD, 11));
		textAlgorithm.setBounds(22, 292, 76, 15);
		contentPane.add(textAlgorithm);
		
		radioButton_FG = new JRadioButton("FiveGuess");
		radioButton_FG.addActionListener(e -> {

			radioButton_G.setSelected(False);
			Algorithm = 1;
		});
		radioButton_FG.setBackground(new Color(242, 222, 193));
		radioButton_FG.setBounds(22, 304, 141, 23);
		contentPane.add(radioButton_FG);
		
		radioButton_G = new JRadioButton("Genetic");
		radioButton_G.addActionListener(e -> {

			radioButton_FG.setSelected(False);
			Algorithm = 2;
		});
		radioButton_G.setBackground(new Color(242, 222, 193));
		radioButton_G.setBounds(22, 330, 141, 23);
		contentPane.add(radioButton_G);
		
		missatge = new JLabel("");
		missatge.setHorizontalAlignment(SwingConstants.CENTER);
		missatge.setFont(new Font("Dialog", Font.BOLD, 14));
		missatge.setForeground(Color.RED);
		missatge.setBounds(18, 445, 150, 15);
		contentPane.add(missatge);
		
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


	/**
	 * @brief Funció que executa l'inici de la partida quan es polsa el botó play
	 * <p> Abans ens comprova que la selecció és correcte
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void botoPlayPerformed(java.awt.event.ActionEvent evt) {
		try {
			if(comprovaSeleccioCorrecte()) {
			cCrearPartida.crearNovaPartida(Dificultat, Rol, Algorithm);
			//cCrearPartida.mostraInfo();
			VistaPlay vistaPlay = new VistaPlay(this, cCrearPartida);
			vistaPlay.setVisible(true);
			this.setVisible(false);
			} else {
				missatge.setText("incorrect selection");
			}
		} catch(DificultatNoExisteix ignored) {
			
		}
	}


	/**
	 * @brief Funció que comprova que els botons per iniciar la partida han estat seleccionats correctament
	 */
	private boolean comprovaSeleccioCorrecte() {
		
		return (radioButton_CB.isSelected() || radioButton_CM.isSelected()) && (radioButton_Easy.isSelected() 
				|| radioButton_Medium.isSelected() || radioButton_Hard.isSelected()) 
				&& (radioButton_FG.isSelected() || radioButton_G.isSelected());
	}


	/** @brief Funció que retorna al menú principal quan es polsa el botó return
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void returnMainMenu(java.awt.event.ActionEvent evt) {
			
			parent.setVisible(true);
			dispose();
	}


	/** @brief Funció que guarda la seqüència que haurà d'endevinar l'algorisme quan jugues de CodeMaker
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void guardarSeqCodeMaker(java.awt.event.ActionEvent evt) {
		
	}
}
