package main.presentation.classes;

import main.domain.controllers.*;
import main.presentation.controllers.CtrlRankings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;

import javax.swing.JTable;

public class VistaRankings extends JFrame {

	/**
	 * Finestra de la vista
	 */
	private final javax.swing.JFrame parent;

	/**
	 * Instància de CtrlRankings
	 */
	private static CtrlRankings crankings;

	/**
	 * Taula de continguts dels records
	 */
	private JTable table;

	/**
	 * Botó per seleccionar ranking CodeMaker
	 */
	private JButton buttonCm;

	/**
	 * Botó per seleccionar ranking CodeBreaker
	 */
	private JButton buttonCb;

	/**
	 * Panell de continguts amb barra deslizable vertical per navegar pels records
	 */
	private JScrollPane scrollPane;


	/** @brief Creadora amb valors
	 *
	 * @param parent representa la finestra de la vista
	 * @param cd  representa una instància de CtrlDomain
	 */
	public VistaRankings(javax.swing.JFrame parent, CtrlDomain cd) {
		crankings = new CtrlRankings(cd);
		this.parent = parent;
		InitVistaRankings();
	}


	/**
	 * @brief Funció que inicialitza la vista vistaRankings
	 * <p>
	 * Crea el panell de contingut de la vista, el panell deslizable, els botons i els textos mostrats per pantalla
	 */
	public void InitVistaRankings() {
		setResizable(false);
		setTitle("Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 566);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 222, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon bg2 = new ImageIcon(getClass().getClassLoader().getResource("bg_w.jpg"));
		Image getBg2 = bg2.getImage();
		Image modBg2 = getBg2.getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH);
		bg2 = new ImageIcon(modBg2);
		
		JLabel titleR = new JLabel("R");
		titleR.setForeground(new Color(255, 0, 0));
		titleR.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 45));
		titleR.setBounds(63, 35, 46, 63);
		contentPane.add(titleR);
		
		JLabel titleA = new JLabel("A");
		titleA.setForeground(new Color(0, 215, 11));
		titleA.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 45));
		titleA.setBounds(94, 35, 46, 63);
		contentPane.add(titleA);
		
		JLabel titleN = new JLabel("N");
		titleN.setForeground(new Color(0, 0, 255));
		titleN.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 45));
		titleN.setBounds(125, 35, 46, 63);
		contentPane.add(titleN);
		
		JLabel titleK = new JLabel("K");
		titleK.setForeground(new Color(255, 255, 0));
		titleK.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 45));
		titleK.setBounds(158, 35, 46, 63);
		contentPane.add(titleK);
		
		JLabel titleI = new JLabel("I");
		titleI.setForeground(new Color(255, 255, 255));
		titleI.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 45));
		titleI.setBounds(191, 35, 46, 63);
		contentPane.add(titleI);
		
		JLabel titleN2 = new JLabel("N");
		titleN2.setForeground(new Color(0, 0, 0));
		titleN2.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 45));
		titleN2.setBounds(206, 35, 46, 63);
		contentPane.add(titleN2);
		
		JLabel titleG = new JLabel("G");
		titleG.setForeground(new Color(255, 0, 0));
		titleG.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 45));
		titleG.setBounds(241, 35, 46, 63);
		contentPane.add(titleG);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 119, 0));
		scrollPane.setBounds(64, 138, 419, 312);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		buttonCm = new JButton("CodeMaker");
		buttonCm.addActionListener(this::btnActionPerformedCM);
		buttonCm.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonCm.setBackground(new Color(0, 128, 0));
		buttonCm.setForeground(new Color(242, 222, 193));
		buttonCm.setBorderPainted(false);
		buttonCm.setBounds(64, 106, 208, 33);
		contentPane.add(buttonCm);

		buttonCb = new JButton("CodeBreaker");
		buttonCb.addActionListener(this::btnActionPerformedCB);
		buttonCb.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonCb.setBackground(new Color(0, 91, 0));
		buttonCb.setForeground(new Color(242, 222, 193));
		buttonCb.setBorderPainted(false);
		buttonCb.setBounds(272, 106, 211, 33);
		contentPane.add(buttonCb);
		
		JButton buttonExit = new JButton("Return");
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonExit.setBackground(new Color(242, 222, 193));
		buttonExit.setBounds(63, 475, 117, 25);
		contentPane.add(buttonExit);
		buttonExit.addActionListener(this::botoReturnActionPerformed);
		
		initTable();
		
		JLabel b2Img = new JLabel("");
		b2Img.setBackground(new Color(164, 104, 23));
		b2Img.setIcon(bg2);
		b2Img.setBounds(0, 0, 600, 600);
		contentPane.add(b2Img);
	}


	/** @brief Funció que retorna al menú principal quan es polsa el botó return
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void botoReturnActionPerformed(java.awt.event.ActionEvent evt) {
		parent.setVisible(true);
		dispose();
	}


	/** @brief Funció que mostra el Ranking CodeMaker amb els records del sistema amb aquest rol quan es polsa el botó CodeMaker
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	public void btnActionPerformedCM(java.awt.event.ActionEvent evt) {
		String[] titles = {"Position", "Name", "Points"};
		String[][] t = crankings.getRanking("CodeMaker");
		showTable(t, titles);
        
		buttonCb.setBackground(new Color(0, 85, 0));
		buttonCm.setBackground(new Color(0, 128, 0));
	}


	/**
	 * @brief Funció que inicialitza la taula de continguts amb les columnes corresponents
	 */
	public void initTable() {
		String[] titles = {"Position", "Name", "Points"};
		String[][] t = crankings.getRanking("CodeMaker");
		showTable(t, titles);
        
		buttonCb.setBackground(new Color(0, 85, 0));
		buttonCm.setBackground(new Color(0, 128, 0));
	}


	/** @brief Funció que mostra el Ranking CodeBreaker amb els records del sistema amb aquest rol quan es polsa el botó CodeBreaker
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	public void btnActionPerformedCB(java.awt.event.ActionEvent evt) {
		String[] titles = {"Position", "Name", "Points"};
		String[][] t = crankings.getRanking("CodeBreaker");
		showTable(t, titles);
        
		buttonCb.setBackground(new Color(0, 128, 0));
		buttonCm.setBackground(new Color(0, 85, 0));
	}


	/**
	 * @brief Funció que crea la taula de continguts i la mostra per pantalla a la vista
	 */
	public void showTable(String[][] t, String[] titles) {

        table = new JTable(t, titles);
        
        table.setBackground(new Color(0,128,0));
        table.setForeground(new Color(242, 222, 193));
        
        table.setMaximumSize(new Dimension(419, 312));
        table.setMinimumSize(new Dimension(419, 312));
        table.setPreferredSize(new Dimension(419, 312));
        
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(500);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.setFont(new Font("Verdana", Font.BOLD, 20));
        scrollPane.setViewportView(table);
    }
}