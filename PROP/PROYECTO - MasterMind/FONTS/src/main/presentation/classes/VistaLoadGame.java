package main.presentation.classes;

import main.domain.classes.Partida;
import main.presentation.controllers.CtrlLoadGame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.domain.controllers.CtrlDomain;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.AbstractListModel;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import java.util.List;

public class VistaLoadGame extends JFrame {

	/**
	 * Panell de contingut
	 */
	private JPanel contentPane;

	/**
	 * Finestra de la vista
	 */
	private final javax.swing.JFrame parent;

	/**
	 * Instància de CtrlLoadGame
	 */
	private static CtrlLoadGame cLoadGame;

	/**
	 * Llista de partides
	 */
	List<Partida> listGames;

	/**
	 * Botó per seleccionar continue game
	 */
	private JButton buttonContinue;

	/**
	 * Llista en què l'usuari pot seleccionar
	 */
	private JList list;
	
	/**
	 * Text per mostrar per pantalla
	 */
	private JLabel missatge;


	/**
	 * Valors emprats per representar cada partida guardada a la llista
	 */
	String[] valors;

	/**
	 * Representa la mida en dificultat fàcil
	 */
	static final Integer DIFICULTY_EASY = 1;

	/**
	 * Representa la mida en dificultat mitjana
	 */
	static final Integer DIFICULTY_MEDIUM = 2;

	/**
	 * Representa la mida en dificultat dificil
	 */
	static final Integer DIFICULTY_HARD = 3;


	/** @brief Creadora amb valors
	 *
	 * @param parent representa la finestra de la vista
	 * @param cd  representa una instància de CtrlDomain
	 */
	public VistaLoadGame(javax.swing.JFrame parent, CtrlDomain cd) {
		cLoadGame = new CtrlLoadGame(cd);
		this.parent = parent;
		InitVistaLoadGame();
	}


	/**
	 * @brief Funció que inicialitza la vista vistaCrearPartida
	 * <p>
	 * Crea el panell de contingut de la vista, els botons i els textos mostrats per pantalla
	 */
	public void InitVistaLoadGame() {
		setResizable(false);
		setTitle("Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 222, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon bg2 = new ImageIcon(getClass().getClassLoader().getResource("bg_w.jpg"));
		Image getBg2 = bg2.getImage();
		Image modBg2 = getBg2.getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH);
		bg2 = new ImageIcon(modBg2);
		
		JLabel titleM1 = new JLabel("M");
		titleM1.setForeground(new Color(255, 0, 0));
		titleM1.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleM1.setBounds(38, 28, 27, 31);
		contentPane.add(titleM1);
		
		JLabel titleA = new JLabel("A");
		titleA.setForeground(new Color(0, 215, 11));
		titleA.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleA.setBounds(57, 28, 27, 31);
		contentPane.add(titleA);
		
		JLabel titleS = new JLabel("S");
		titleS.setForeground(new Color(0, 0, 255));
		titleS.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleS.setBounds(74, 28, 27, 31);
		contentPane.add(titleS);
		
		JLabel titleT = new JLabel("T");
		titleT.setForeground(new Color(255, 255, 0));
		titleT.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleT.setBounds(91, 28, 27, 31);
		contentPane.add(titleT);
		
		JLabel titleE = new JLabel("E");
		titleE.setForeground(new Color(255, 255, 255));
		titleE.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleE.setBounds(110, 28, 27, 31);
		contentPane.add(titleE);
		
		JLabel titleR = new JLabel("R");
		titleR.setFont(new Font("Monospaced", Font.BOLD, 27));
		titleR.setBounds(128, 28, 27, 31);
		contentPane.add(titleR);
		
		JLabel titleM2 = new JLabel("M");
		titleM2.setForeground(new Color(255, 0, 0));
		titleM2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleM2.setBounds(95, 51, 27, 31);
		contentPane.add(titleM2);
		
		JLabel titleI = new JLabel("I");
		titleI.setForeground(new Color(0, 215, 11));
		titleI.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleI.setBounds(117, 51, 27, 31);
		contentPane.add(titleI);
		
		JLabel titleN = new JLabel("N");
		titleN.setForeground(new Color(0, 0, 255));
		titleN.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleN.setBounds(137, 51, 27, 31);
		contentPane.add(titleN);
		
		JLabel titleD = new JLabel("D");
		titleD.setForeground(new Color(255, 255, 0));
		titleD.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 31));
		titleD.setBounds(156, 51, 27, 31);
		contentPane.add(titleD);
		
		missatge = new JLabel("");
		missatge.setHorizontalAlignment(SwingConstants.CENTER);
		missatge.setFont(new Font("Dialog", Font.BOLD, 12));
		missatge.setForeground(Color.RED);
		missatge.setBounds(350, 445, 150, 19);
		contentPane.add(missatge);
		
		JLabel lblSeleccio = new JLabel("Select a game to play:");
		lblSeleccio.setForeground(new Color(242, 222, 193));
		lblSeleccio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeleccio.setBounds(41, 131, 460, 24);
		contentPane.add(lblSeleccio);

		JButton buttonReturn = new JButton("Return");
		buttonReturn.addActionListener(this::botoReturnActionPerformed);
		buttonReturn.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonReturn.setBackground(new Color(242, 222, 193));
		buttonReturn.setBounds(37, 469, 117, 25);
		contentPane.add(buttonReturn);
		
		buttonContinue = new JButton("Continue game");
		buttonContinue.addActionListener(this::botoContinueGameActionPerformed);
		buttonContinue.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonContinue.setBackground(new Color(242, 222, 193));
		buttonContinue.setBounds(352, 469, 149, 25);
		contentPane.add(buttonContinue);
		
		JPanel menuSelectGame = new JPanel();
		menuSelectGame.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		menuSelectGame.setBackground(new Color(0, 128, 0));
		menuSelectGame.setBounds(37, 131, 464, 24);
		contentPane.add(menuSelectGame);
		
		loadGames();
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 12));
		list.setForeground(new Color(242, 222, 193));
		list.setBackground(new Color(0, 128, 0));
		list.setModel(new AbstractListModel() {
			final String[] values = valors;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(37, 155, 463, 284);
		contentPane.add(list);
		
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


	/** @brief Funció que continua la partida seleccionada quan es polsa el botó continue game
	 *
	 * @param evt representa el event actionPerformed de la llibreria de java awt
	 */
	private void botoContinueGameActionPerformed(java.awt.event.ActionEvent evt) {
		if(list.getSelectedIndex() != -1) {

			VistaPlay vistaPlay = new VistaPlay(this, cLoadGame, listGames.get(list.getSelectedIndex()).getIdPartida());
			vistaPlay.setVisible(true);
			this.setVisible(false);
		} else {
			missatge.setText("incorrect selection");
		}
	}


	/** @brief Funció que càrrega totes les partides guardades de l'usuari i les mostra per pantalla. Les partides són representades per l'identificador, el rol i la dificultat
	 */
	private void loadGames() {       
		listGames = cLoadGame.getSavedGames();
		
		if (listGames.size() == 0) {
            buttonContinue.setEnabled(false);
            JLabel noGames = new JLabel("No games saved");
            noGames.setBounds(44, 160, 150, 20);
            noGames.setForeground(new Color(255, 0, 0));
            noGames.setFont(new Font("Tahoma", Font.BOLD, 14));
    		contentPane.add(noGames);
        }
		
		valors = new String[listGames.size()];

		for (int i = 0; i < listGames.size(); i++) {
			Integer id = listGames.get(i).getIdPartida();
            String rol = listGames.get(i).getRol();
            Integer dif = listGames.get(i).getDificultat();
            String dificultat = "";
            
            if (dif.equals(DIFICULTY_EASY)) dificultat = "Easy";
            else if (dif.equals(DIFICULTY_MEDIUM)) dificultat = "Medium";
            else if (dif.equals(DIFICULTY_HARD)) dificultat = "Hard";
            
            int difAux = 0;
            if (dif.equals(DIFICULTY_EASY) || dif.equals(DIFICULTY_HARD)) difAux = 4;
            
            int aux = 0;
            if (rol.equals("CodeBreaker")) aux = 1;
            
            valors[i] = "    " + id + " ".repeat(43-aux) + rol + " ".repeat(25+difAux) + dificultat;
		}
    }
}
