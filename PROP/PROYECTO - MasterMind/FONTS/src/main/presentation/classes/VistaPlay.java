package main.presentation.classes;

import main.presentation.controllers.CtrlPlay;
import main.presentation.controllers.CtrlCrearPartida;
import main.presentation.controllers.CtrlLoadGame;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.border.BevelBorder;
import javax.swing.SpringLayout;

import javax.swing.Timer;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VistaPlay extends JFrame {

	/**
     * JPanel que conté tot el disseny de la vistaPlay
     */
	public JPanel contentPane;

	/**
     * Color que representa el color seleccionat
     */
	public Color colorActual = new Color(128, 128, 128);
	
	/**
     * Valor en RGB que representa el negre
     */
	static final Color black = new Color(0, 0, 0);

	/**
     * Valor de convertir a Integer el color negre
     */
	static final Integer blackRGB = black.getRGB();

	/**
     * Valor en RGB que representa el vermell
     */
	static final Color vermell = new Color(255, 0, 0);

	/**
     * Valor de convertir a Integer el color vermell
     */
	static final Integer vermellRGB = vermell.getRGB();

	/**
     * Valor en RGB que representa el blau
     */
	static final Color blau = new Color(0, 0, 255);

	/**
     * Valor de convertir a Integer el color blau
     */
	static final Integer blauRGB = blau.getRGB();

	/**
     * Valor en RGB que representa el verd
     */
	static final Color verd = new Color(0, 215, 11);

	/**
     * Valor de convertir a Integer el color verd
     */
	static final Integer verdRGB = verd.getRGB();

	/**
     * Valor en RGB que representa el groc
     */
	static final Color groc = new Color(255, 255, 0);

	/**
     * Valor de convertir a Integer el color groc
     */
	static final Integer grocRGB = groc.getRGB();

	/**
     * Valor en RGB que representa el blanc
     */
	static final Color blanc = new Color(255, 255, 255);

	/**
     * Valor de convertir a Integer el color blanc
     */
	static final Integer blancRGB = blanc.getRGB();

	/**
     * Valor en RGB que representa el gris
     */
	static final Color gris = new Color(128, 128, 128);

	/**
     * Valor de convertir a Integer el color gris
     */
	static final Integer grisRGB = gris.getRGB();

	/**
     * Valor en RGB que representa el crema
     */
	static final Color crema = new Color(242, 222, 193);

	/**
     * Valor en RGB que representa el color de fons
     */
	static final Color bg = new Color(0, 128, 0);

	/**
     * Valor de convertir a Integer el color de fons
     */
	static final Integer bgRGB = bg.getRGB();
	
	/**
     * Representa la difficultat de la partida
     */
	public Integer difficulty = 0;

	/**
     * Representa la mida dels botons de colors
     */
	static final Integer COLORS_SIZE = 30;

	/**
     * Representa la mida dels botons dels pegs
     */
	static final Integer PEGS_SIZE = 12;

	/**
     * Primera posicióX dels botons en dificultat facil
     */
	static final Integer X_POSITION_4_1 = 58;

	/**
     * Segona posicióX dels botons en dificultat facil
     */
	static final Integer X_POSITION_4_2 = 114;

	/**
     * Tercera posicióX dels botons en dificultat facil
     */
	static final Integer X_POSITION_4_3 = 170;

	/**
     * Quarta posicióX dels botons en dificultat facil
     */
	static final Integer X_POSITION_4_4 = 228;

	/**
     * Primera posicióX dels botons en dificultat mitjana
     */
	static final Integer X_POSITION_5_1 = 38;

	/**
     * Segona posicióX dels botons en dificultat mitjana
     */
	static final Integer X_POSITION_5_2 = 89;

	/**
     * Tercer posicióX dels botons en dificultat mitjana
     */
	static final Integer X_POSITION_5_3 = 142;

	/**
     * Quarta posicióX dels botons en dificultat mitjana
     */
	static final Integer X_POSITION_5_4 = 195;

	/**
     * Cinquena posicióX dels botons en dificultat mitjana
     */
	static final Integer X_POSITION_5_5 = 250;

	/**
     * Primera posicióX dels botons en dificultat dificil
     */
	static final Integer X_POSITION_6_1 = 29;

	/**
     * Segona posicióX dels botons en dificultat dificil
     */
	static final Integer X_POSITION_6_2 = 73;

	/**
     * Tercera posicióX dels botons en dificultat dificil
     */
	static final Integer X_POSITION_6_3 = 118;

	/**
     * Quarta posicióX dels botons en dificultat dificil
     */
	static final Integer X_POSITION_6_4 = 163;

	/**
     * Cinquena posicióX dels botons en dificultat dificil
     */
	static final Integer X_POSITION_6_5 = 209;

	/**
     * Sisena posicióX dels botons en dificultat dificil
     */
	static final Integer X_POSITION_6_6 = 255;

	/**
     * PosicióY dels botons del codiSecret
     */
	static final Integer Y_POSITION_RESULT = 16;

	/**
     * PosicióY dels botons del de main colors
     */
	static final Integer Y_POSITION_COLORS = 472;

	/**
     * PosicióY dels botons de la primera ronda
     */
	static final Integer Y_POSITION_1 = 403;

	/**
     * PosicióY dels botons de la segona ronda
     */
	static final Integer Y_POSITION_2 = 367;

	/**
     * PosicióY dels botons de la tercera ronda
     */
	static final Integer Y_POSITION_3 = 331;

	/**
     * PosicióY dels botons de la quarta ronda
     */
	static final Integer Y_POSITION_4 = 295;

	/**
     * PosicióY dels botons de la cinquena ronda
     */
	static final Integer Y_POSITION_5 = 259;

	/**
     * PosicióY dels botons de la sisena ronda
     */
	static final Integer Y_POSITION_6 = 223;

	/**
     * PosicióY dels botons de la setena ronda
     */
	static final Integer Y_POSITION_7 = 187;

	/**
     * PosicióY dels botons de la vuitena ronda
     */
	static final Integer Y_POSITION_8 = 151;

	/**
     * PosicióY dels botons de la novena ronda
     */
	static final Integer Y_POSITION_9 = 115;

	/**
     * PosicióY dels botons de la decena ronda
     */
	static final Integer Y_POSITION_10 = 79;

	/**
     * Primera posicióX dels botons de pegs en dificultat facil
     */
	static final Integer X_PEGS_4_1 = 341;

	/**
     * Segona posicióX dels botons de pegs en dificultat facil
     */
	static final Integer X_PEGS_4_2 = 365;

	/**
     * Tercera posicióX dels botons de pegs en dificultat facil
     */
	static final Integer X_PEGS_4_3 = 388;

	/**
     * Quarta posicióX dels botons de pegs en dificultat facil
     */
	static final Integer X_PEGS_4_4 = 413;

	/**
     * Primera posicióX dels botons de pegs en dificultat mitjana
     */
	static final Integer X_PEGS_5_1 = 338;

	/**
     * Segona posicióX dels botons de pegs en dificultat mitjana
     */
	static final Integer X_PEGS_5_2 = 357;

	/**
     * Tercera posicióX dels botons de pegs en dificultat mitjana
     */
	static final Integer X_PEGS_5_3 = 376;

	/**
     * Quarta posicióX dels botons de pegs en dificultat mitjana
     */
	static final Integer X_PEGS_5_4 = 394;

	/**
     * Cinquena posicióX dels botons de pegs en dificultat mitjana
     */
	static final Integer X_PEGS_5_5 = 412;
	
	/**
     * Primera posicióX dels botons de pegs en dificultat dificil
     */
	static final Integer X_PEGS_6_1 = 330;

	/**
     * Segona posicióX dels botons de pegs en dificultat dificil
     */
	static final Integer X_PEGS_6_2 = 349;

	/**
     * Tercera posicióX dels botons de pegs en dificultat dificil
     */
	static final Integer X_PEGS_6_3 = 368;

	/**
     * Quarta posicióX dels botons de pegs en dificultat dificil
     */
	static final Integer X_PEGS_6_4 = 386;

	/**
     * Cinquena posicióX dels botons de pegs en dificultat dificil
     */
	static final Integer X_PEGS_6_5 = 404;

	/**
     * Sisena posicióX dels botons de pegs en dificultat dificil
     */
	static final Integer X_PEGS_6_6 = 422;

	/**
     * PosicióY dels botons de pegs de la primera ronda
     */
	static final Integer Y_PEGS_1 = 416;

	/**
     * PosicióY dels botons de pegs de la segona ronda
     */
	static final Integer Y_PEGS_2 = 380;

	/**
     * PosicióY dels botons de pegs de la tercera ronda
     */
	static final Integer Y_PEGS_3 = 344;

	/**
     * PosicióY dels botons de pegs de la quarta ronda
     */
	static final Integer Y_PEGS_4 = 307;

	/**
     * PosicióY dels botons de pegs de la cinquena ronda
     */
	static final Integer Y_PEGS_5 = 269;

	/**
     * PosicióY dels botons de pegs de la sisena ronda
     */
	static final Integer Y_PEGS_6 = 234;

	/**
     * PosicióY dels botons de pegs de la setena ronda
     */
	static final Integer Y_PEGS_7 = 197;

	/**
     * PosicióY dels botons de pegs de la vuitena ronda
     */
	static final Integer Y_PEGS_8 = 160;

	/**
     * PosicióY dels botons de pegs de la novena ronda
     */
	static final Integer Y_PEGS_9 = 123;

	/**
     * PosicióY dels botons de pegs de la decena ronda
     */
	static final Integer Y_PEGS_10 = 86;

	/**
     * Representa el color de fons dels botons dels colors
     */
	static final Integer defaultRGB1 = -16744448;

	/**
     * Representa el color de fons dels botons dels pegs
     */
	static final Integer defaultRGB2 = -8355712;
	
	/**
     * Representes els tres valors del timer, hores, minuts, segons
     */
	private Integer h, m, s;
	
	/**
     * Representa el temps de la partida
     */
	private Timer t;

	/**
     * Label on s'escriu el valor del temps en hores
     */
	private JLabel timeHour;

	/**
     * Label on s'escriu els : entre hores i minuts
     */
	private JLabel JlabelTime1;

	/**
     * Label on s'escriu el valor del temps en miunts
     */
	private JLabel timeMinute;

	/**
     * Label on s'escriu els : entre minuts i segons
     */
	private JLabel JLabelTime2;

	/**
     * Label on s'escriu el valor del temps en segons
     */
	private JLabel timeSecond;
	
	/**
     * Representa el button de confirmar pegs o convinacio
     */
	private JButton checkButton;

	/**
     * Representa el button per demanar ajuda
     */
	private JButton buttonHelp;

	/**
     * Representa el button per començar partida en codeMaker
     */
	private JButton buttonStart;

	/**
     * Representa el button per fer exit de la partida
     */
	private JButton buttonClose;

	/**
     * Representa el primer color del codi secret
     */
	private RoundButton resultColor1;

	/**
     * Representa el segon color del codi secret
     */
	private RoundButton resultColor2;

	/**
     * Representa el tercer color del codi secret
     */
	private RoundButton resultColor3;

	/**
     * Representa el quart color del codi secret
     */
	private RoundButton resultColor4;

	/**
     * Representa el cinque color del codi secret
     */
	private RoundButton resultColor5;

	/**
     * Representa el sise color del codi secret
     */
	private RoundButton resultColor6;

	/**
     * Representa el button de color vermell
     */
	private RoundButton buttonMainColors1;
	
	/**
     * Representa el button de color verd
     */
	private RoundButton buttonMainColors2;

	/**
     * Representa el button de color blau
     */
	private RoundButton buttonMainColors3;

	/**
     * Representa el button de color groc
     */
	private RoundButton buttonMainColors4;

	/**
     * Representa el button de color blanc
     */
	private RoundButton buttonMainColors5;

	/**
     * Representa el button de color negre
     */
	private RoundButton buttonMainColors6;

	/**
     * Representa el button que apareix a l'utilizar ajuda com a codebreaker
     */
	private RoundButton buttonMainHighlight;

	/**
     * Representa el primer button de color de la ronda 1
     */
	private RoundButton buttonRound1_1;

	/**
     * Representa el segon button de color de la ronda 1
     */
	private RoundButton buttonRound1_2;

	/**
     * Representa el tercer button de color de la ronda 1
     */
	private RoundButton buttonRound1_3;

	/**
     * Representa el quart button de color de la ronda 1
     */
	private RoundButton buttonRound1_4;

	/**
     * Representa el cinque button de color de la ronda 1
     */
	private RoundButton buttonRound1_5;

	/**
     * Representa el sise button de color de la ronda 1
     */
	private RoundButton buttonRound1_6;

	/**
     * Representa el primer button de color de la ronda 2
     */
	private RoundButton buttonRound2_1;

	/**
     * Representa el segon button de color de la ronda 2
     */
	private RoundButton buttonRound2_2;

	/**
     * Representa el tercer button de color de la ronda 2
     */
	private RoundButton buttonRound2_3;

	/**
     * Representa el quart button de color de la ronda 2
     */
	private RoundButton buttonRound2_4;

	/**
     * Representa el cinque button de color de la ronda 2
     */
	private RoundButton buttonRound2_5;

	/**
     * Representa el sise button de color de la ronda 2
     */
	private RoundButton buttonRound2_6;

	/**
     * Representa el primer button de color de la ronda 3
     */
	private RoundButton buttonRound3_1;

	/**
     * Representa el segon button de color de la ronda 3
     */
	private RoundButton buttonRound3_2;

	/**
     * Representa el tercer button de color de la ronda 3
     */
	private RoundButton buttonRound3_3;

	/**
     * Representa el quart button de color de la ronda 3
     */
	private RoundButton buttonRound3_4;

	/**
     * Representa el cinque button de color de la ronda 3
     */
	private RoundButton buttonRound3_5;

	/**
     * Representa el sise button de color de la ronda 3
     */
	private RoundButton buttonRound3_6;

	/**
     * Representa el primer button de color de la ronda 4
     */
	private RoundButton buttonRound4_1;

	/**
     * Representa el segon button de color de la ronda 4
     */
	private RoundButton buttonRound4_2;

	/**
     * Representa el tercer button de color de la ronda 4
     */
	private RoundButton buttonRound4_3;

	/**
     * Representa el quart button de color de la ronda 4
     */
	private RoundButton buttonRound4_4;

	/**
     * Representa el cinque button de color de la ronda 4
     */
	private RoundButton buttonRound4_5;

	/**
     * Representa el sise button de color de la ronda 4
     */
	private RoundButton buttonRound4_6;

	/**
     * Representa el primer button de color de la ronda 5
     */
	private RoundButton buttonRound5_1;

	/**
     * Representa el segon button de color de la ronda 5
     */
	private RoundButton buttonRound5_2;

	/**
     * Representa el tercer button de color de la ronda 5
     */
	private RoundButton buttonRound5_3;

	/**
     * Representa el quart button de color de la ronda 5
     */
	private RoundButton buttonRound5_4;

	/**
     * Representa el cinque button de color de la ronda 5
     */
	private RoundButton buttonRound5_5;

	/**
     * Representa el sise button de color de la ronda 5
     */
	private RoundButton buttonRound5_6;

	/**
     * Representa el primer button de color de la ronda 6
     */
	private RoundButton buttonRound6_1;

	/**
     * Representa el segon button de color de la ronda 6
     */
	private RoundButton buttonRound6_2;

	/**
     * Representa el tercer button de color de la ronda 6
     */
	private RoundButton buttonRound6_3;

	/**
     * Representa el quart button de color de la ronda 6
     */
	private RoundButton buttonRound6_4;

	/**
     * Representa el cinque button de color de la ronda 6
     */
	private RoundButton buttonRound6_5;
	
	/**
     * Representa el sise button de color de la ronda 6
     */
	private RoundButton buttonRound6_6;
	
	/**
     * Representa el primer button de color de la ronda 7
     */
	private RoundButton buttonRound7_1;

	/**
     * Representa el segon button de color de la ronda 7
     */
	private RoundButton buttonRound7_2;

	/**
     * Representa el tercer button de color de la ronda 7
     */
	private RoundButton buttonRound7_3;

	/**
     * Representa el quart button de color de la ronda 7
     */
	private RoundButton buttonRound7_4;

	/**
     * Representa el cinque button de color de la ronda 7
     */
	private RoundButton buttonRound7_5;

	/**
     * Representa el sise button de color de la ronda 7
     */
	private RoundButton buttonRound7_6;

	/**
     * Representa el primer button de color de la ronda 8
     */
	private RoundButton buttonRound8_1;

	/**
     * Representa el segon button de color de la ronda 8
     */
	private RoundButton buttonRound8_2;

	/**
     * Representa el tercer button de color de la ronda 8
     */
	private RoundButton buttonRound8_3;

	/**
     * Representa el quart button de color de la ronda 8
     */
	private RoundButton buttonRound8_4;

	/**
     * Representa el cinque button de color de la ronda 8
     */
	private RoundButton buttonRound8_5;

	/**
     * Representa el sise button de color de la ronda 8
     */
	private RoundButton buttonRound8_6;

	/**
     * Representa el primer button de color de la ronda 9
     */
	private RoundButton buttonRound9_1;

	/**
     * Representa el segon button de color de la ronda 9
     */
	private RoundButton buttonRound9_2;

	/**
     * Representa el tercer button de color de la ronda 9
     */
	private RoundButton buttonRound9_3;

	/**
     * Representa el quart button de color de la ronda 9
     */
	private RoundButton buttonRound9_4;

	/**
     * Representa el cinque button de color de la ronda 9
     */
	private RoundButton buttonRound9_5;

	/**
     * Representa el sise button de color de la ronda 9
     */
	private RoundButton buttonRound9_6;

	/**
     * Representa el primer button de color de la ronda 10
     */
	private RoundButton buttonRound10_1;

	/**
     * Representa el segon button de color de la ronda 10
     */
	private RoundButton buttonRound10_2;

	/**
     * Representa el tercer button de color de la ronda 10
     */
	private RoundButton buttonRound10_3;

	/**
     * Representa el quart button de color de la ronda 10
     */
	private RoundButton buttonRound10_4;

	/**
     * Representa el cinque button de color de la ronda 10
     */
	private RoundButton buttonRound10_5;

	/**
     * Representa el sise button de color de la ronda 10
     */
	private RoundButton buttonRound10_6;

	/**
     * Representa el primer button de peg de la ronda 1
     */
	private RoundButton buttonPegs1_1;

	/**
     * Representa el segon button de peg de la ronda 1
     */
	private RoundButton buttonPegs1_2;

	/**
     * Representa el tercer button de peg de la ronda 1
     */
	private RoundButton buttonPegs1_3;

	/**
     * Representa el quart button de peg de la ronda 1
     */
	private RoundButton buttonPegs1_4;

	/**
     * Representa el cinque button de peg de la ronda 1
     */
	private RoundButton buttonPegs1_5;

	/**
     * Representa el sise button de peg de la ronda 1
     */
	private RoundButton buttonPegs1_6;

	/**
     * Representa el primer button de peg de la ronda 2
     */
	private RoundButton buttonPegs2_1;

	/**
     * Representa el segon button de peg de la ronda 2
     */
	private RoundButton buttonPegs2_2;

	/**
     * Representa el tercer button de peg de la ronda 2
     */
	private RoundButton buttonPegs2_3;

	/**
     * Representa el quart button de peg de la ronda 2
     */
	private RoundButton buttonPegs2_4;
	
	/**
     * Representa el cinque button de peg de la ronda 2
     */
	private RoundButton buttonPegs2_5;

	/**
     * Representa el sise button de peg de la ronda 2
     */
	private RoundButton buttonPegs2_6;

	/**
     * Representa el primer button de peg de la ronda 3
     */
	private RoundButton buttonPegs3_1;

	/**
     * Representa el segon button de peg de la ronda 3
     */
	private RoundButton buttonPegs3_2;

	/**
     * Representa el tercer button de peg de la ronda 3
     */
	private RoundButton buttonPegs3_3;

	/**
     * Representa el quart button de peg de la ronda 3
     */
	private RoundButton buttonPegs3_4;

	/**
     * Representa el cinque button de peg de la ronda 3
     */
	private RoundButton buttonPegs3_5;

	/**
     * Representa el sise button de peg de la ronda 3
     */
	private RoundButton buttonPegs3_6;
	
	/**
     * Representa el primer button de peg de la ronda 4
     */
	private RoundButton buttonPegs4_1;

	/**
     * Representa el segon button de peg de la ronda 4
     */
	private RoundButton buttonPegs4_2;

	/**
     * Representa el tercer button de peg de la ronda 4
     */
	private RoundButton buttonPegs4_3;

	/**
     * Representa el quart button de peg de la ronda 4
     */
	private RoundButton buttonPegs4_4;

	/**
     * Representa el cinque button de peg de la ronda 4
     */
	private RoundButton buttonPegs4_5;

	/**
     * Representa el sise button de peg de la ronda 4
     */
	private RoundButton buttonPegs4_6;

	/**
     * Representa el primer button de peg de la ronda 5
     */
	private RoundButton buttonPegs5_1;

	/**
     * Representa el segon button de peg de la ronda 5
     */
	private RoundButton buttonPegs5_2;

	/**
     * Representa el tercer button de peg de la ronda 5
     */
	private RoundButton buttonPegs5_3;
	
	/**
     * Representa el quart button de peg de la ronda 5
     */
	private RoundButton buttonPegs5_4;

	/**
     * Representa el cinque button de peg de la ronda 5
     */
	private RoundButton buttonPegs5_5;
	
	/**
     * Representa el sise button de peg de la ronda 5
     */
	private RoundButton buttonPegs5_6;

	/**
     * Representa el primer button de peg de la ronda 6
     */
	private RoundButton buttonPegs6_1;

	/**
     * Representa el segon button de peg de la ronda 6
     */
	private RoundButton buttonPegs6_2;

	/**
     * Representa el tercer button de peg de la ronda 6
     */
	private RoundButton buttonPegs6_3;

	/**
     * Representa el quart button de peg de la ronda 6
     */
	private RoundButton buttonPegs6_4;

	/**
     * Representa el cinque button de peg de la ronda 6
     */
	private RoundButton buttonPegs6_5;

	/**
     * Representa el sise button de peg de la ronda 6
     */
	private RoundButton buttonPegs6_6;

	/**
     * Representa el primer button de peg de la ronda 7
     */
	private RoundButton buttonPegs7_1;

	/**
     * Representa el segon button de peg de la ronda 7
     */
	private RoundButton buttonPegs7_2;

	/**
     * Representa el tercer button de peg de la ronda 7
     */
	private RoundButton buttonPegs7_3;

	/**
     * Representa el quart button de peg de la ronda 7
     */
	private RoundButton buttonPegs7_4;

	/**
     * Representa el cinque button de peg de la ronda 7
     */
	private RoundButton buttonPegs7_5;

	/**
     * Representa el sise button de peg de la ronda 7
     */
	private RoundButton buttonPegs7_6;

	/**
     * Representa el primer button de peg de la ronda 8
     */
	private RoundButton buttonPegs8_1;

	/**
     * Representa el segon button de peg de la ronda 8
     */
	private RoundButton buttonPegs8_2;

	/**
     * Representa el tercer button de peg de la ronda 8
     */
	private RoundButton buttonPegs8_3;

	/**
     * Representa el quart button de peg de la ronda 8
     */
	private RoundButton buttonPegs8_4;

	/**
     * Representa el cinque button de peg de la ronda 8
     */
	private RoundButton buttonPegs8_5;

	/**
     * Representa el sise button de peg de la ronda 8
     */
	private RoundButton buttonPegs8_6;

	/**
     * Representa el primer button de peg de la ronda 9
     */
	private RoundButton buttonPegs9_1;

	/**
     * Representa el segon button de peg de la ronda 9
     */
	private RoundButton buttonPegs9_2;

	/**
     * Representa el tercer button de peg de la ronda 9
     */
	private RoundButton buttonPegs9_3;

	/**
     * Representa el quart button de peg de la ronda 9
     */
	private RoundButton buttonPegs9_4;

	/**
     * Representa el cinque button de peg de la ronda 9
     */
	private RoundButton buttonPegs9_5;

	/**
     * Representa el sise button de peg de la ronda 9
     */
	private RoundButton buttonPegs9_6;

	/**
     * Representa el primer button de peg de la ronda 10
     */
	private RoundButton buttonPegs10_1;

	/**
     * Representa el segon button de peg de la ronda 10
     */
	private RoundButton buttonPegs10_2;

	/**
     * Representa el tercer button de peg de la ronda 10
     */
	private RoundButton buttonPegs10_3;

	/**
     * Representa el quart button de peg de la ronda 10
     */
	private RoundButton buttonPegs10_4;

	/**
     * Representa el cinque button de peg de la ronda 10
     */
	private RoundButton buttonPegs10_5;

	/**
     * Representa el sise button de peg de la ronda 10
     */
	private RoundButton buttonPegs10_6;

	/**
     * Label per mostrar els diferents missatges d'error
     */
	private JLabel message;

	/**
     * Label per mostrar la puntuacio al final del game
     */
	private JLabel messagePunts;

	/**
     * Objecte Menu que conte els botons de save, close, i exit
     */
	private JMenuItem mntmNewMenuItem;

	/**
     * Objecte parent utilitzat per accedir al pare de VistaPlay
     */
	private final javax.swing.JFrame parent;

	/**
     * Controlador Play per comunicar amb el ctrlDomain
     */
	private static CtrlPlay cPlay;

	/**
     * Llista de codis del tauler
     */
	public List<List<Integer>> como;

	/**
     * Llista de pegs resultants als codis de como
     */
    public List<String> Pegs;
	

	/** @brief Constructora accedida desde VistaCrearPartida
     *  
     * @param parent vistaCrearPartida
	 * @param cCrearPartida controlador de crearPartida
     */
	public VistaPlay(javax.swing.JFrame parent, CtrlCrearPartida cCrearPartida) {
		cPlay = new CtrlPlay(cCrearPartida.getCD());
		this.parent = parent;
		InitVistaPlay(0);
	}
	
	/** @brief Constructora accedida desde VistaLoadGame
     *  
     * @param parent vistaLoadGame
	 * @param cLoadGame controlador de loadGame
	 * @param idPartida id de la partida continuada
     */
	public VistaPlay(javax.swing.JFrame parent, CtrlLoadGame cLoadGame, Integer idPartida) {
		cPlay = new CtrlPlay(cLoadGame.getCD());
		cPlay.getCD().continuaPartida(idPartida);
		this.parent = parent;
		InitVistaPlay(1);
		t.start();
	}
	
	/** @brief Iniciacio de la partida, es crea tota la vista segons el parametre
     *  
     * @param createLoad identifica si estem carregant o creant la partida
     */
	public void InitVistaPlay(Integer createLoad) {
		
		setResizable(false);
		setTitle("Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 587);

		difficulty = cPlay.getDificultat();

		// ContentPaneSettings
		contentPaneSettings();
		
		// ExtraButtons
		createExtraButtons();
		
		// ResultColors
		createResultColors();
		
		// MainColors
		createMainColors();

		// TimeMenu
		createTimeMenu();

		// RoundButtons
		createRoundButtons();
		
		// PegsButtons
		createPegsButtons();

		if (createLoad == 0) {
			jugarPartida();
			initTemps();
			if (cPlay.getRol().equals("CodeBreaker")) t.start();
		} else {
			continuarPartida();
			initTemps();
		}
	}

	/** @brief Funció que crea el menuBar amb els botons save, close i exit 
     */
	public void contentPaneSettings() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		mntmNewMenuItem = new JMenuItem("Save game");
		mntmNewMenuItem.addActionListener(e -> {
			if (cPlay.getRonda() > 0) {
				guardarPartidaActionPerformed(e);
				returnVistaMM();
			} else {
				message.setText("play a turn before saving");
			}
		});
		menuFile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(this::exit);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Close");
		mntmNewMenuItem_2.addActionListener(e -> {

			cPlay.acabarClosePartida();
			returnVistaMM();
		});
		menuFile.add(mntmNewMenuItem_2);
		menuFile.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 180, 111));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);	
	}

	/** @brief Funcio que crea els botons de check, help, start i exit i els missatges d'errors i puntuacio i implementa les funcionalitats de cada button 
     */
	public void createExtraButtons() {
		message = new JLabel("");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setFont(new Font("Dialog", Font.BOLD, 12));
		message.setForeground(Color.RED);
		message.setBounds(347, 450, 150, 19);
		contentPane.add(message);

		messagePunts = new JLabel("");
		messagePunts.setHorizontalAlignment(SwingConstants.CENTER);
		messagePunts.setFont(new Font("Dialog", Font.BOLD, 13));
		messagePunts.setForeground(verd);
		messagePunts.setBounds(347, 461, 150, 19);
		contentPane.add(messagePunts);

		checkButton = new JButton("Check");
		checkButton.addActionListener(e -> {
			if (cPlay.getRol().equals("CodeMaker")) {
				if (wrongPegs()) {
					message.setText("wrong pegs");
				} else {
					moureCheckbutton();
					message.setText("");
					if(!resoltCM() && cPlay.getRonda() < 9) {
						cPlay.actualitzaRonda();
						cPlay.actualitzaTauler(como.get(cPlay.getRonda()));
						actualitzaButtonPegs();
						mostraColors(como);
					} else {
						checkButton.hide();
						buttonHelp.hide();
						buttonClose.setEnabled(true);
						buttonClose.show();
						endTime();
						message.setText("Game Over");
						message.setFont(new Font("Dialog", Font.BOLD, 15));
						message.setBounds(347, 442, 150, 19);
						message.setForeground(verd);

						messagePunts.setText("Puntuacio: " + cPlay.getPuntsCM());
						cPlay.actualitzaRanking();
					}
				}

			} else if (cPlay.getRol().equals("CodeBreaker")) {
				if (wrongRoundColors()) {
					message.setText("wrong colors");
				} else {
					moureCheckbutton();
					message.setText("");
					if (!resoltCB() && cPlay.getRonda() < 9) {
						cPlay.actualitzaRonda();
						actualitzaButtonRounds();
						buttonHelp.setEnabled(true);
						buttonMainHighlight.hide();
					} else {
						showResult();
						checkButton.hide();
						buttonHelp.hide();
						buttonClose.setEnabled(true);
						buttonClose.show();
						endTime();
						message.setText("Game Over");
						message.setFont(new Font("Dialog", Font.BOLD, 15));
						message.setBounds(347, 442, 150, 19);
						message.setForeground(verd);

						messagePunts.setText("Puntuacio: " + cPlay.getPuntsCB());
						cPlay.actualitzaRanking();
					}
				}
			}
		});
		checkButton.setEnabled(false);
		checkButton.setBounds(444, Y_PEGS_1, 78, 23);
		contentPane.add(checkButton);
		
		buttonHelp = new JButton("Help");
		buttonHelp.addActionListener(e -> {

			if(cPlay.getRol().equals("CodeMaker")) {

				mostraPegs(Pegs);
			} else if(cPlay.getRol().equals("CodeBreaker")) {

				buttonHelp.setEnabled(false);
				mostraAjuda();
			}
		});
		buttonHelp.setEnabled(false);
		buttonHelp.setBounds(337, 485, 175, 23);
		buttonHelp.hide();
		contentPane.add(buttonHelp);

		buttonClose = new JButton("Exit");
		buttonClose.addActionListener(e -> returnVistaMM());
		buttonClose.setEnabled(false);
		buttonClose.setBounds(337, 485, 175, 23);
		buttonClose.hide();
		contentPane.add(buttonClose);
		
		buttonStart = new JButton("Start");
		buttonStart.addActionListener(e -> {
			if (wrongSelection()) {
				message.setText("wrong selection");
			} else {
				t.start();

				resultColor1.setEnabled(false);
				resultColor2.setEnabled(false);
				resultColor3.setEnabled(false);
				resultColor4.setEnabled(false);
				if (difficulty == 2) resultColor5.setEnabled(false);
				else if (difficulty == 3) {
					resultColor5.setEnabled(false);
					resultColor6.setEnabled(false);
				}

				buttonMainColors1.setEnabled(false);
				buttonMainColors2.setEnabled(false);
				buttonMainColors3.setEnabled(false);
				buttonMainColors4.setEnabled(false);
				buttonMainColors5.setEnabled(false);
				buttonMainColors6.setEnabled(false);

				message.setText("");

				buttonStart.setEnabled(false);
				buttonStart.hide();
				buttonHelp.show();

				checkButton.setEnabled(true);

				buttonPegs1_1.setEnabled(true);
				buttonPegs1_2.setEnabled(true);
				buttonPegs1_3.setEnabled(true);
				buttonPegs1_4.setEnabled(true);
				if (difficulty == 2) buttonPegs1_5.setEnabled(true);
				else if (difficulty == 3) {
					buttonPegs1_5.setEnabled(true);
					buttonPegs1_6.setEnabled(true);
				}

				asignaCodiCodeMaker();

				como = cPlay.getSeqSolve();
				Pegs = cPlay.getPegsMaq();

				cPlay.actualitzaTauler(como.get(cPlay.getRonda()));

				mostraColors(como);

				buttonHelp.setEnabled(true);
			}
		});
		buttonStart.setEnabled(false);
		buttonStart.setBounds(337, 485, 175, 23);
		contentPane.add(buttonStart);
	}
	
	/** @brief Funcio que mostra els pegs graficament segons la ronda de la partida
     *  
	 * @param Pegs llista que conté els pegs a mostrar
     */
	private void mostraPegs(List<String> Pegs) {
		

		Integer ronda = cPlay.getRonda();
		
		if(ronda == 0) {
			
			if ((String.valueOf(Pegs.get(0).charAt(0))).equals("B")) buttonPegs1_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(0).charAt(0))).equals("W")) buttonPegs1_1.setBackground(gris);
			else buttonPegs1_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(0).charAt(1))).equals("B")) buttonPegs1_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(0).charAt(1))).equals("W")) buttonPegs1_2.setBackground(gris);
			else buttonPegs1_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(0).charAt(2))).equals("B")) buttonPegs1_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(0).charAt(2))).equals("W")) buttonPegs1_3.setBackground(gris);
			else buttonPegs1_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(0).charAt(3))).equals("B")) buttonPegs1_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(0).charAt(3))).equals("W")) buttonPegs1_4.setBackground(gris);
			else buttonPegs1_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(0).charAt(4))).equals("B")) buttonPegs1_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(0).charAt(4))).equals("W")) buttonPegs1_5.setBackground(gris);
				else buttonPegs1_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(0).charAt(4))).equals("B")) buttonPegs1_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(0).charAt(4))).equals("W")) buttonPegs1_5.setBackground(gris);
				else buttonPegs1_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(0).charAt(5))).equals("B")) buttonPegs1_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(0).charAt(5))).equals("W")) buttonPegs1_6.setBackground(gris);
				else buttonPegs1_6.setBackground(crema);
			}

		} else if(ronda == 1) {
			
			if ((String.valueOf(Pegs.get(1).charAt(0))).equals("B")) buttonPegs2_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(1).charAt(0))).equals("W")) buttonPegs2_1.setBackground(gris);
			else buttonPegs2_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(1).charAt(1))).equals("B")) buttonPegs2_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(1).charAt(1))).equals("W")) buttonPegs2_2.setBackground(gris);
			else buttonPegs2_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(1).charAt(2))).equals("B")) buttonPegs2_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(1).charAt(2))).equals("W")) buttonPegs2_3.setBackground(gris);
			else buttonPegs2_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(1).charAt(3))).equals("B")) buttonPegs2_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(1).charAt(3))).equals("W")) buttonPegs2_4.setBackground(gris);
			else buttonPegs2_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(1).charAt(4))).equals("B")) buttonPegs2_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(1).charAt(4))).equals("W")) buttonPegs2_5.setBackground(gris);
				else buttonPegs2_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(1).charAt(4))).equals("B")) buttonPegs2_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(1).charAt(4))).equals("W")) buttonPegs2_5.setBackground(gris);
				else buttonPegs2_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(1).charAt(5))).equals("B")) buttonPegs2_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(1).charAt(5))).equals("W")) buttonPegs2_6.setBackground(gris);
				else buttonPegs2_6.setBackground(crema);
			}

		} else if(ronda == 2) {
			
			if ((String.valueOf(Pegs.get(2).charAt(0))).equals("B")) buttonPegs3_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(2).charAt(0))).equals("W")) buttonPegs3_1.setBackground(gris);
			else buttonPegs3_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(2).charAt(1))).equals("B")) buttonPegs3_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(2).charAt(1))).equals("W")) buttonPegs3_2.setBackground(gris);
			else buttonPegs3_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(2).charAt(2))).equals("B")) buttonPegs3_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(2).charAt(2))).equals("W")) buttonPegs3_3.setBackground(gris);
			else buttonPegs3_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(2).charAt(3))).equals("B")) buttonPegs3_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(2).charAt(3))).equals("W")) buttonPegs3_4.setBackground(gris);
			else buttonPegs3_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(2).charAt(4))).equals("B")) buttonPegs3_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(2).charAt(4))).equals("W")) buttonPegs3_5.setBackground(gris);
				else buttonPegs3_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(2).charAt(4))).equals("B")) buttonPegs3_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(2).charAt(4))).equals("W")) buttonPegs3_5.setBackground(gris);
				else buttonPegs3_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(2).charAt(5))).equals("B")) buttonPegs3_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(2).charAt(5))).equals("W")) buttonPegs3_6.setBackground(gris);
				else buttonPegs3_6.setBackground(crema);
			}

		} else if(ronda == 3) {
			
			if ((String.valueOf(Pegs.get(3).charAt(0))).equals("B")) buttonPegs4_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(3).charAt(0))).equals("W")) buttonPegs4_1.setBackground(gris);
			else buttonPegs4_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(3).charAt(1))).equals("B")) buttonPegs4_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(3).charAt(1))).equals("W")) buttonPegs4_2.setBackground(gris);
			else buttonPegs4_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(3).charAt(2))).equals("B")) buttonPegs4_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(3).charAt(2))).equals("W")) buttonPegs4_3.setBackground(gris);
			else buttonPegs4_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(3).charAt(3))).equals("B")) buttonPegs4_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(3).charAt(3))).equals("W")) buttonPegs4_4.setBackground(gris);
			else buttonPegs4_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(3).charAt(4))).equals("B")) buttonPegs4_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(3).charAt(4))).equals("W")) buttonPegs4_5.setBackground(gris);
				else buttonPegs4_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(3).charAt(4))).equals("B")) buttonPegs4_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(3).charAt(4))).equals("W")) buttonPegs4_5.setBackground(gris);
				else buttonPegs4_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(3).charAt(5))).equals("B")) buttonPegs4_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(3).charAt(5))).equals("W")) buttonPegs4_6.setBackground(gris);
				else buttonPegs4_6.setBackground(crema);
			}

		} else if(ronda == 4) {
			
			if ((String.valueOf(Pegs.get(4).charAt(0))).equals("B")) buttonPegs5_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(4).charAt(0))).equals("W")) buttonPegs5_1.setBackground(gris);
			else buttonPegs5_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(4).charAt(1))).equals("B")) buttonPegs5_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(4).charAt(1))).equals("W")) buttonPegs5_2.setBackground(gris);
			else buttonPegs5_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(4).charAt(2))).equals("B")) buttonPegs5_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(4).charAt(2))).equals("W")) buttonPegs5_3.setBackground(gris);
			else buttonPegs5_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(4).charAt(3))).equals("B")) buttonPegs5_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(4).charAt(3))).equals("W")) buttonPegs5_4.setBackground(gris);
			else buttonPegs5_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(4).charAt(4))).equals("B")) buttonPegs5_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(4).charAt(4))).equals("W")) buttonPegs5_5.setBackground(gris);
				else buttonPegs5_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(4).charAt(4))).equals("B")) buttonPegs5_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(4).charAt(4))).equals("W")) buttonPegs5_5.setBackground(gris);
				else buttonPegs5_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(4).charAt(5))).equals("B")) buttonPegs5_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(4).charAt(5))).equals("W")) buttonPegs5_6.setBackground(gris);
				else buttonPegs5_6.setBackground(crema);
			}

		} else if(ronda == 5) {
			
			if ((String.valueOf(Pegs.get(5).charAt(0))).equals("B")) buttonPegs6_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(5).charAt(0))).equals("W")) buttonPegs6_1.setBackground(gris);
			else buttonPegs6_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(5).charAt(1))).equals("B")) buttonPegs6_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(5).charAt(1))).equals("W")) buttonPegs6_2.setBackground(gris);
			else buttonPegs6_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(5).charAt(2))).equals("B")) buttonPegs6_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(5).charAt(2))).equals("W")) buttonPegs6_3.setBackground(gris);
			else buttonPegs6_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(5).charAt(3))).equals("B")) buttonPegs6_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(5).charAt(3))).equals("W")) buttonPegs6_4.setBackground(gris);
			else buttonPegs6_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(5).charAt(4))).equals("B")) buttonPegs6_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(5).charAt(4))).equals("W")) buttonPegs6_5.setBackground(gris);
				else buttonPegs6_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(5).charAt(4))).equals("B")) buttonPegs6_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(5).charAt(4))).equals("W")) buttonPegs6_5.setBackground(gris);
				else buttonPegs6_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(5).charAt(5))).equals("B")) buttonPegs6_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(5).charAt(5))).equals("W")) buttonPegs6_6.setBackground(gris);
				else buttonPegs6_6.setBackground(crema);
			}

		} else if(ronda == 6) {
			
			if ((String.valueOf(Pegs.get(6).charAt(0))).equals("B")) buttonPegs7_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(6).charAt(0))).equals("W")) buttonPegs7_1.setBackground(gris);
			else buttonPegs7_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(6).charAt(1))).equals("B")) buttonPegs7_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(6).charAt(1))).equals("W")) buttonPegs7_2.setBackground(gris);
			else buttonPegs7_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(6).charAt(2))).equals("B")) buttonPegs7_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(6).charAt(2))).equals("W")) buttonPegs7_3.setBackground(gris);
			else buttonPegs7_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(6).charAt(3))).equals("B")) buttonPegs7_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(6).charAt(3))).equals("W")) buttonPegs7_4.setBackground(gris);
			else buttonPegs7_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(6).charAt(4))).equals("B")) buttonPegs7_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(6).charAt(4))).equals("W")) buttonPegs7_5.setBackground(gris);
				else buttonPegs7_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(6).charAt(4))).equals("B")) buttonPegs7_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(6).charAt(4))).equals("W")) buttonPegs7_5.setBackground(gris);
				else buttonPegs7_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(6).charAt(5))).equals("B")) buttonPegs7_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(6).charAt(5))).equals("W")) buttonPegs7_6.setBackground(gris);
				else buttonPegs7_6.setBackground(crema);
			}
		}


		else if(ronda == 7) {
			
			if ((String.valueOf(Pegs.get(7).charAt(0))).equals("B")) buttonPegs8_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(7).charAt(0))).equals("W")) buttonPegs8_1.setBackground(gris);
			else buttonPegs8_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(7).charAt(1))).equals("B")) buttonPegs8_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(7).charAt(1))).equals("W")) buttonPegs8_2.setBackground(gris);
			else buttonPegs8_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(7).charAt(2))).equals("B")) buttonPegs8_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(7).charAt(2))).equals("W")) buttonPegs8_3.setBackground(gris);
			else buttonPegs8_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(7).charAt(3))).equals("B")) buttonPegs8_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(7).charAt(3))).equals("W")) buttonPegs8_4.setBackground(gris);
			else buttonPegs8_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(7).charAt(4))).equals("B")) buttonPegs8_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(7).charAt(4))).equals("W")) buttonPegs8_5.setBackground(gris);
				else buttonPegs8_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(7).charAt(4))).equals("B")) buttonPegs8_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(7).charAt(4))).equals("W")) buttonPegs8_5.setBackground(gris);
				else buttonPegs8_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(7).charAt(5))).equals("B")) buttonPegs8_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(7).charAt(5))).equals("W")) buttonPegs8_6.setBackground(gris);
				else buttonPegs8_6.setBackground(crema);
			}
		}


		else if(ronda == 8) {
			
			if ((String.valueOf(Pegs.get(8).charAt(0))).equals("B")) buttonPegs9_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(8).charAt(0))).equals("W")) buttonPegs9_1.setBackground(gris);
			else buttonPegs9_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(8).charAt(1))).equals("B")) buttonPegs9_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(8).charAt(1))).equals("W")) buttonPegs9_2.setBackground(gris);
			else buttonPegs9_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(8).charAt(2))).equals("B")) buttonPegs9_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(8).charAt(2))).equals("W")) buttonPegs9_3.setBackground(gris);
			else buttonPegs9_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(8).charAt(3))).equals("B")) buttonPegs9_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(8).charAt(3))).equals("W")) buttonPegs9_4.setBackground(gris);
			else buttonPegs9_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(8).charAt(4))).equals("B")) buttonPegs9_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(8).charAt(4))).equals("W")) buttonPegs9_5.setBackground(gris);
				else buttonPegs9_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(8).charAt(4))).equals("B")) buttonPegs9_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(8).charAt(4))).equals("W")) buttonPegs9_5.setBackground(gris);
				else buttonPegs9_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(8).charAt(5))).equals("B")) buttonPegs9_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(8).charAt(5))).equals("W")) buttonPegs9_6.setBackground(gris);
				else buttonPegs9_6.setBackground(crema);
			}
		}

		else if(ronda == 9) {
			
			if ((String.valueOf(Pegs.get(9).charAt(0))).equals("B")) buttonPegs10_1.setBackground(black);
			else if ((String.valueOf(Pegs.get(9).charAt(0))).equals("W")) buttonPegs10_1.setBackground(gris);
			else buttonPegs10_1.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(9).charAt(1))).equals("B")) buttonPegs10_2.setBackground(black);
			else if ((String.valueOf(Pegs.get(9).charAt(1))).equals("W")) buttonPegs10_2.setBackground(gris);
			else buttonPegs10_2.setBackground(crema);	
			
			if ((String.valueOf(Pegs.get(9).charAt(2))).equals("B")) buttonPegs10_3.setBackground(black);
			else if ((String.valueOf(Pegs.get(9).charAt(2))).equals("W")) buttonPegs10_3.setBackground(gris);
			else buttonPegs10_3.setBackground(crema);
			
			if ((String.valueOf(Pegs.get(9).charAt(3))).equals("B")) buttonPegs10_4.setBackground(black);
			else if ((String.valueOf(Pegs.get(9).charAt(3))).equals("W")) buttonPegs10_4.setBackground(gris);
			else buttonPegs10_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Pegs.get(9).charAt(4))).equals("B")) buttonPegs10_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(9).charAt(4))).equals("W")) buttonPegs10_5.setBackground(gris);
				else buttonPegs10_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Pegs.get(9).charAt(4))).equals("B")) buttonPegs10_5.setBackground(black);
				else if ((String.valueOf(Pegs.get(9).charAt(4))).equals("W")) buttonPegs10_5.setBackground(gris);
				else buttonPegs10_5.setBackground(crema);
				
				if ((String.valueOf(Pegs.get(9).charAt(5))).equals("B")) buttonPegs10_6.setBackground(black);
				else if ((String.valueOf(Pegs.get(9).charAt(5))).equals("W")) buttonPegs10_6.setBackground(gris);
				else buttonPegs10_6.setBackground(crema);
			}
		}
	}

	/** @brief Funcio que motra el buttonMainHighlight a sota d'un dels colors existents al codiSecret 
     */
	private void mostraAjuda() {
		Integer ajut = cPlay.ajutUsuari();

		if (ajut != -1) {
			if (ajut == 0) {
				buttonMainHighlight.show();
				buttonMainHighlight.setBounds(26, 469, 36, 36);
			} else if (ajut == 1) {
				buttonMainHighlight.show();
				buttonMainHighlight.setBounds(70, 469, 36, 36);
			} else if (ajut == 2) {
				buttonMainHighlight.show();
				buttonMainHighlight.setBounds(115, 469, 36, 36);
			} else if (ajut == 3) {
				buttonMainHighlight.show();
				buttonMainHighlight.setBounds(160, 469, 36, 36);
			} else if (ajut == 4) {
				buttonMainHighlight.show();
				buttonMainHighlight.setBounds(252, 469, 36, 36);
			} else if (ajut == 5) {
				buttonMainHighlight.show();
				buttonMainHighlight.setBounds(206, 469, 36, 36);
			}
		} else {
			message.setText("all colors reveled");
		}
	}

	/** @brief Funcio que mostra els pegs graficament el codiSecret als buttons result 
     */
	private void showResult() {
		List<Integer> codiRes = cPlay.getCodiResoldre();
		
		if (codiRes.get(0) == 0) resultColor1.setBackground(vermell);
		else if (codiRes.get(0) == 1) resultColor1.setBackground(verd);
		else if (codiRes.get(0) == 2) resultColor1.setBackground(blau);
		else if (codiRes.get(0) == 3) resultColor1.setBackground(groc);
		else if (codiRes.get(0) == 4) resultColor1.setBackground(black);
		else if (codiRes.get(0) == 5) resultColor1.setBackground(blanc);

		if (codiRes.get(1) == 0) resultColor2.setBackground(vermell);
		else if (codiRes.get(1) == 1) resultColor2.setBackground(verd);
		else if (codiRes.get(1) == 2) resultColor2.setBackground(blau);
		else if (codiRes.get(1) == 3) resultColor2.setBackground(groc);
		else if (codiRes.get(1) == 4) resultColor2.setBackground(black);
		else if (codiRes.get(1) == 5) resultColor2.setBackground(blanc);

		if (codiRes.get(2) == 0) resultColor3.setBackground(vermell);
		else if (codiRes.get(2) == 1) resultColor3.setBackground(verd);
		else if (codiRes.get(2) == 2) resultColor3.setBackground(blau);
		else if (codiRes.get(2) == 3) resultColor3.setBackground(groc);
		else if (codiRes.get(2) == 4) resultColor3.setBackground(black);
		else if (codiRes.get(2) == 5) resultColor3.setBackground(blanc);

		if (codiRes.get(3) == 0) resultColor4.setBackground(vermell);
		else if (codiRes.get(3) == 1) resultColor4.setBackground(verd);
		else if (codiRes.get(3) == 2) resultColor4.setBackground(blau);
		else if (codiRes.get(3) == 3) resultColor4.setBackground(groc);
		else if (codiRes.get(3) == 4) resultColor4.setBackground(black);
		else if (codiRes.get(3) == 5) resultColor4.setBackground(blanc);

		if (difficulty == 2) {
			if (codiRes.get(4) == 0) resultColor5.setBackground(vermell);
			else if (codiRes.get(4) == 1) resultColor5.setBackground(verd);
			else if (codiRes.get(4) == 2) resultColor5.setBackground(blau);
			else if (codiRes.get(4) == 3) resultColor5.setBackground(groc);
			else if (codiRes.get(4) == 4) resultColor5.setBackground(black);
			else if (codiRes.get(4) == 5) resultColor5.setBackground(blanc);
		}

		if (difficulty == 3) {
			if (codiRes.get(5) == 0) resultColor6.setBackground(vermell);
			else if (codiRes.get(5) == 1) resultColor6.setBackground(verd);
			else if (codiRes.get(5) == 2) resultColor6.setBackground(blau);
			else if (codiRes.get(5) == 3) resultColor6.setBackground(groc);
			else if (codiRes.get(5) == 4) resultColor6.setBackground(black);
			else if (codiRes.get(5) == 5) resultColor6.setBackground(blanc);
		}
	}
	
	/** @brief Funcio que comprova en cas codeMaker si s'ha resolt el codi
     *  
	 * @return cert si s'ha resolt, fals si no
     */
	private boolean resoltCM() {
		
		if(difficulty == 1) return Pegs.get(cPlay.getRonda()).equals("BBBB");
		else if(difficulty == 2) return Pegs.get(cPlay.getRonda()).equals("BBBBB");
		else return Pegs.get(cPlay.getRonda()).equals("BBBBBB");
	}

	/** @brief Funcio que comprova en cas codeBreaker si s'ha resolt el codi
     *  
	 * @return cert si s'ha resolt, fals si no
     */
	private boolean resoltCB() {
		List<Integer> code = getCodiButtons();

		cPlay.actualitzaTauler(code);
		String Peg = cPlay.checkCode();

		mostraPegsActuals(Peg);

		if(difficulty == 1) return Peg.equals("BBBB");
		else if(difficulty == 2) return Peg.equals("BBBBB");
		else return Peg.equals("BBBBBB");
	}

	/** @brief Funcio que mostra graficament els pegs de la ronda actual
     *  
	 * @param Peg pegs a mostrar en els buttons
     */
	private void mostraPegsActuals(String Peg) {
	
		Integer ronda = cPlay.getRonda();

		if (ronda == 0) {
			
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs1_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs1_1.setBackground(gris);
			else buttonPegs1_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs1_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs1_2.setBackground(gris);
			else buttonPegs1_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs1_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs1_3.setBackground(gris);
			else buttonPegs1_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs1_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs1_4.setBackground(gris);
			else buttonPegs1_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs1_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs1_5.setBackground(gris);
				else buttonPegs1_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs1_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs1_5.setBackground(gris);
				else buttonPegs1_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs1_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs1_6.setBackground(gris);
				else buttonPegs1_6.setBackground(crema);
			}

		} else if (ronda == 1) {
			
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs2_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs2_1.setBackground(gris);
			else buttonPegs2_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs2_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs2_2.setBackground(gris);
			else buttonPegs2_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs2_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs2_3.setBackground(gris);
			else buttonPegs2_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs2_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs2_4.setBackground(gris);
			else buttonPegs2_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs2_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs2_5.setBackground(gris);
				else buttonPegs2_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs2_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs2_5.setBackground(gris);
				else buttonPegs2_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs2_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs2_6.setBackground(gris);
				else buttonPegs2_6.setBackground(crema);
			}

		} else if (ronda == 2) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs3_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs3_1.setBackground(gris);
			else buttonPegs3_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs3_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs3_2.setBackground(gris);
			else buttonPegs3_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs3_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs3_3.setBackground(gris);
			else buttonPegs3_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs3_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs3_4.setBackground(gris);
			else buttonPegs3_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs3_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs3_5.setBackground(gris);
				else buttonPegs3_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs3_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs3_5.setBackground(gris);
				else buttonPegs3_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs3_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs3_6.setBackground(gris);
				else buttonPegs3_6.setBackground(crema);
			}

		} else if (ronda == 3) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs4_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs4_1.setBackground(gris);
			else buttonPegs4_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs4_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs4_2.setBackground(gris);
			else buttonPegs4_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs4_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs4_3.setBackground(gris);
			else buttonPegs4_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs4_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs4_4.setBackground(gris);
			else buttonPegs4_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs4_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs4_5.setBackground(gris);
				else buttonPegs4_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs4_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs4_5.setBackground(gris);
				else buttonPegs4_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs4_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs4_6.setBackground(gris);
				else buttonPegs4_6.setBackground(crema);
			}

		} else if (ronda == 4) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs5_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs5_1.setBackground(gris);
			else buttonPegs5_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs5_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs5_2.setBackground(gris);
			else buttonPegs5_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs5_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs5_3.setBackground(gris);
			else buttonPegs5_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs5_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs5_4.setBackground(gris);
			else buttonPegs5_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs5_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs5_5.setBackground(gris);
				else buttonPegs5_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs5_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs5_5.setBackground(gris);
				else buttonPegs5_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs5_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs5_6.setBackground(gris);
				else buttonPegs5_6.setBackground(crema);
			}

		} else if (ronda == 5) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs6_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs6_1.setBackground(gris);
			else buttonPegs6_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs6_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs6_2.setBackground(gris);
			else buttonPegs6_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs6_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs6_3.setBackground(gris);
			else buttonPegs6_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs6_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs6_4.setBackground(gris);
			else buttonPegs6_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs6_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs6_5.setBackground(gris);
				else buttonPegs6_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs6_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs6_5.setBackground(gris);
				else buttonPegs6_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs6_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs6_6.setBackground(gris);
				else buttonPegs6_6.setBackground(crema);
			}

		} else if (ronda == 6) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs7_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs7_1.setBackground(gris);
			else buttonPegs7_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs7_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs7_2.setBackground(gris);
			else buttonPegs7_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs7_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs7_3.setBackground(gris);
			else buttonPegs7_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs7_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs7_4.setBackground(gris);
			else buttonPegs7_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs7_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs7_5.setBackground(gris);
				else buttonPegs7_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs7_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs7_5.setBackground(gris);
				else buttonPegs7_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs7_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs7_6.setBackground(gris);
				else buttonPegs7_6.setBackground(crema);
			}

		} else if (ronda == 7) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs8_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs8_1.setBackground(gris);
			else buttonPegs8_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs8_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs8_2.setBackground(gris);
			else buttonPegs8_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs8_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs8_3.setBackground(gris);
			else buttonPegs8_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs8_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs8_4.setBackground(gris);
			else buttonPegs8_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs8_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs8_5.setBackground(gris);
				else buttonPegs8_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs8_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs8_5.setBackground(gris);
				else buttonPegs8_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs8_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs8_6.setBackground(gris);
				else buttonPegs8_6.setBackground(crema);
			}

		} else if (ronda == 8) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs9_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs9_1.setBackground(gris);
			else buttonPegs9_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs9_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs9_2.setBackground(gris);
			else buttonPegs9_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs9_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs9_3.setBackground(gris);
			else buttonPegs9_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs9_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs9_4.setBackground(gris);
			else buttonPegs9_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs9_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs9_5.setBackground(gris);
				else buttonPegs9_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs9_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs9_5.setBackground(gris);
				else buttonPegs9_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs9_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs9_6.setBackground(gris);
				else buttonPegs9_6.setBackground(crema);
			}

		} else if (ronda == 9) {
			if ((String.valueOf(Peg.charAt(0))).equals("B")) buttonPegs10_1.setBackground(black);
			else if ((String.valueOf(Peg.charAt(0))).equals("W")) buttonPegs10_1.setBackground(gris);
			else buttonPegs10_1.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(1))).equals("B")) buttonPegs10_2.setBackground(black);
			else if ((String.valueOf(Peg.charAt(1))).equals("W")) buttonPegs10_2.setBackground(gris);
			else buttonPegs10_2.setBackground(crema);	
			
			if ((String.valueOf(Peg.charAt(2))).equals("B")) buttonPegs10_3.setBackground(black);
			else if ((String.valueOf(Peg.charAt(2))).equals("W")) buttonPegs10_3.setBackground(gris);
			else buttonPegs10_3.setBackground(crema);
			
			if ((String.valueOf(Peg.charAt(3))).equals("B")) buttonPegs10_4.setBackground(black);
			else if ((String.valueOf(Peg.charAt(3))).equals("W")) buttonPegs10_4.setBackground(gris);
			else buttonPegs10_4.setBackground(crema);

			if (difficulty == 2) {

				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs10_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs10_5.setBackground(gris);
				else buttonPegs10_5.setBackground(crema);
			} else if (difficulty == 3) {
				
				if ((String.valueOf(Peg.charAt(4))).equals("B")) buttonPegs10_5.setBackground(black);
				else if ((String.valueOf(Peg.charAt(4))).equals("W")) buttonPegs10_5.setBackground(gris);
				else buttonPegs10_5.setBackground(crema);
				
				if ((String.valueOf(Peg.charAt(5))).equals("B")) buttonPegs10_6.setBackground(black);
				else if ((String.valueOf(Peg.charAt(5))).equals("W")) buttonPegs10_6.setBackground(gris);
				else buttonPegs10_6.setBackground(crema);
			}
		}
	}

	/** @brief Funcio que converteix els colors introduits en els botons a una llista de numeros de colors segons la ronda
     *  
	 * @return llista del codi introduit
     */
	private List<Integer> getCodiButtons() {
		List<Integer> code = new ArrayList<>();

		Integer ronda = cPlay.getRonda();

		if (ronda == 0) {
			if (buttonRound1_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound1_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound1_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound1_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound1_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound1_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound1_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound1_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound1_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound1_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound1_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound1_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound1_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound1_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound1_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound1_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound1_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound1_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound1_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound1_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound1_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound1_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound1_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound1_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound1_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound1_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound1_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound1_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound1_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound1_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound1_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound1_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound1_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound1_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound1_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound1_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound1_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound1_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound1_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound1_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound1_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound1_6.getBackground().getRGB() == blancRGB) code.add(5);
			}

		} else if (ronda == 1) {
			if (buttonRound2_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound2_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound2_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound2_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound2_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound2_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound2_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound2_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound2_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound2_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound2_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound2_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound2_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound2_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound2_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound2_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound2_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound2_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound2_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound2_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound2_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound2_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound2_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound2_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound2_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound2_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound2_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound2_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound2_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound2_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound2_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound2_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound2_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound2_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound2_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound2_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound2_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound2_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound2_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound2_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound2_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound2_6.getBackground().getRGB() == blancRGB) code.add(5);
			}

		} else if (ronda == 2) {
			if (buttonRound3_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound3_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound3_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound3_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound3_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound3_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound3_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound3_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound3_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound3_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound3_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound3_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound3_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound3_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound3_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound3_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound3_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound3_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound3_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound3_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound3_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound3_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound3_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound3_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound3_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound3_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound3_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound3_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound3_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound3_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound3_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound3_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound3_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound3_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound3_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound3_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound3_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound3_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound3_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound3_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound3_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound3_6.getBackground().getRGB() == blancRGB) code.add(5);
			}

		} else if (ronda == 3) {
			if (buttonRound4_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound4_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound4_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound4_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound4_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound4_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound4_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound4_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound4_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound4_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound4_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound4_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound4_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound4_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound4_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound4_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound4_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound4_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound4_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound4_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound4_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound4_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound4_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound4_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound4_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound4_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound4_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound4_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound4_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound4_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound4_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound4_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound4_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound4_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound4_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound4_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound4_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound4_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound4_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound4_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound4_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound4_6.getBackground().getRGB() == blancRGB) code.add(5);
			}
 
		} else if (ronda == 4) {
			if (buttonRound5_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound5_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound5_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound5_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound5_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound5_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound5_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound5_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound5_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound5_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound5_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound5_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound5_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound5_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound5_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound5_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound5_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound5_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound5_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound5_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound5_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound5_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound5_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound5_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound5_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound5_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound5_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound5_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound5_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound5_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound5_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound5_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound5_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound5_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound5_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound5_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound5_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound5_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound5_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound5_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound5_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound5_6.getBackground().getRGB() == blancRGB) code.add(5);
			}

		} else if (ronda == 5) {
			if (buttonRound6_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound6_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound6_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound6_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound6_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound6_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound6_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound6_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound6_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound6_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound6_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound6_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound6_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound6_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound6_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound6_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound6_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound6_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound6_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound6_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound6_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound6_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound6_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound6_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound6_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound6_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound6_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound6_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound6_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound6_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound6_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound6_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound6_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound6_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound6_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound6_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound6_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound6_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound6_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound6_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound6_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound6_6.getBackground().getRGB() == blancRGB) code.add(5);
			}

		} else if (ronda == 6) {
			if (buttonRound7_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound7_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound7_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound7_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound7_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound7_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound7_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound7_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound7_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound7_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound7_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound7_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound7_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound7_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound7_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound7_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound7_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound7_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound7_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound7_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound7_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound7_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound7_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound7_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound7_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound7_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound7_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound7_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound7_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound7_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound7_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound7_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound7_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound7_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound7_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound7_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound7_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound7_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound7_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound7_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound7_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound7_6.getBackground().getRGB() == blancRGB) code.add(5);
			}

		} else if (ronda == 7) {
			if (buttonRound8_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound8_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound8_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound8_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound8_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound8_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound8_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound8_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound8_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound8_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound8_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound8_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound8_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound8_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound8_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound8_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound8_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound8_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound8_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound8_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound8_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound8_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound8_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound8_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound8_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound8_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound8_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound8_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound8_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound8_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound8_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound8_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound8_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound8_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound8_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound8_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound8_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound8_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound8_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound8_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound8_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound8_6.getBackground().getRGB() == blancRGB) code.add(5);
			}
 
		} else if (ronda == 8) {
			if (buttonRound9_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound9_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound9_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound9_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound9_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound9_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound9_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound9_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound9_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound9_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound9_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound9_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound9_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound9_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound9_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound9_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound9_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound9_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound9_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound9_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound9_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound9_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound9_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound9_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound9_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound9_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound9_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound9_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound9_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound9_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound9_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound9_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound9_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound9_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound9_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound9_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound9_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound9_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound9_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound9_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound9_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound9_6.getBackground().getRGB() == blancRGB) code.add(5);
			}
 
		} else if (ronda == 9) {
			if (buttonRound10_1.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound10_1.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound10_1.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound10_1.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound10_1.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound10_1.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound10_2.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound10_2.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound10_2.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound10_2.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound10_2.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound10_2.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound10_3.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound10_3.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound10_3.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound10_3.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound10_3.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound10_3.getBackground().getRGB() == blancRGB) code.add(5);

			if (buttonRound10_4.getBackground().getRGB() == vermellRGB) code.add(0);
			else if (buttonRound10_4.getBackground().getRGB() == verdRGB) code.add(1);
			else if (buttonRound10_4.getBackground().getRGB() == blauRGB) code.add(2);
			else if (buttonRound10_4.getBackground().getRGB() == grocRGB) code.add(3);
			else if (buttonRound10_4.getBackground().getRGB() == blackRGB) code.add(4);
			else if (buttonRound10_4.getBackground().getRGB() == blancRGB) code.add(5);
			
			if (difficulty == 2) {
				if (buttonRound10_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound10_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound10_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound10_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound10_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound10_5.getBackground().getRGB() == blancRGB) code.add(5);
			}
			else if (difficulty == 3) {
				if (buttonRound10_5.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound10_5.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound10_5.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound10_5.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound10_5.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound10_5.getBackground().getRGB() == blancRGB) code.add(5);

				if (buttonRound10_6.getBackground().getRGB() == vermellRGB) code.add(0);
				else if (buttonRound10_6.getBackground().getRGB() == verdRGB) code.add(1);
				else if (buttonRound10_6.getBackground().getRGB() == blauRGB) code.add(2);
				else if (buttonRound10_6.getBackground().getRGB() == grocRGB) code.add(3);
				else if (buttonRound10_6.getBackground().getRGB() == blackRGB) code.add(4);
				else if (buttonRound10_6.getBackground().getRGB() == blancRGB) code.add(5);
			}
		}

		return code;
	}
	
	/** @brief Funcio que actualitza el checkButton segons la ronda de la partida
     */
	private void moureCheckbutton() {
		if(cPlay.getRonda() == 0) {
			
			checkButton.setBounds(444, Y_PEGS_2, 78, 23);
		} else if(cPlay.getRonda() == 1) {
			
			checkButton.setBounds(444, Y_PEGS_3, 78, 23);
		} else if (cPlay.getRonda() == 2) {
			
			checkButton.setBounds(444, Y_PEGS_4, 78, 23);
		} else if (cPlay.getRonda() == 3) {
			
			checkButton.setBounds(444, Y_PEGS_5, 78, 23);
			
		} else if (cPlay.getRonda() == 4) {
			
			checkButton.setBounds(444, Y_PEGS_6, 78, 23);
			
		} else if (cPlay.getRonda() == 4) {
			
			checkButton.setBounds(444, Y_PEGS_6, 78, 23);
			
		} else if (cPlay.getRonda() == 5) {
			
			checkButton.setBounds(444, Y_PEGS_7, 78, 23);
			
		} else if (cPlay.getRonda() == 6) {
			
			checkButton.setBounds(444, Y_PEGS_8, 78, 23);
			
		} else if (cPlay.getRonda() == 7) {
			
			checkButton.setBounds(444, Y_PEGS_9, 78, 23);
			
		} else if (cPlay.getRonda() == 8) {
			
			checkButton.setBounds(444, Y_PEGS_10, 78, 23);
		}
	}
	
	/** @brief Funcio que actualitza els buttons de pegs segons la ronda de la partida
     */
	private void actualitzaButtonPegs() {
		
		Integer ronda = cPlay.getRonda();


		if (ronda == 1) {
			
			buttonPegs1_1.setEnabled(false);
			buttonPegs1_2.setEnabled(false);
			buttonPegs1_3.setEnabled(false);
			buttonPegs1_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs1_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs1_5.setEnabled(false);
				buttonPegs1_6.setEnabled(false);
			}
			
			buttonPegs2_1.setEnabled(true);
			buttonPegs2_2.setEnabled(true);
			buttonPegs2_3.setEnabled(true);
			buttonPegs2_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs2_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs2_5.setEnabled(true);
				buttonPegs2_6.setEnabled(true);
			}
		} else if(ronda == 2) {
			
			buttonPegs2_1.setEnabled(false);
			buttonPegs2_2.setEnabled(false);
			buttonPegs2_3.setEnabled(false);
			buttonPegs2_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs2_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs2_5.setEnabled(false);
				buttonPegs2_6.setEnabled(false);
			}
			
			buttonPegs3_1.setEnabled(true);
			buttonPegs3_2.setEnabled(true);
			buttonPegs3_3.setEnabled(true);
			buttonPegs3_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs3_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs3_5.setEnabled(true);
				buttonPegs3_6.setEnabled(true);
			}
			
		} else if(ronda == 3) {
			
			buttonPegs3_1.setEnabled(false);
			buttonPegs3_2.setEnabled(false);
			buttonPegs3_3.setEnabled(false);
			buttonPegs3_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs3_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs3_5.setEnabled(false);
				buttonPegs3_6.setEnabled(false);
			}
			
			buttonPegs4_1.setEnabled(true);
			buttonPegs4_2.setEnabled(true);
			buttonPegs4_3.setEnabled(true);
			buttonPegs4_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs4_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs4_5.setEnabled(true);
				buttonPegs4_6.setEnabled(true);
			}
			
		} else if(ronda == 4) {
			
			buttonPegs4_1.setEnabled(false);
			buttonPegs4_2.setEnabled(false);
			buttonPegs4_3.setEnabled(false);
			buttonPegs4_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs4_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs4_5.setEnabled(false);
				buttonPegs4_6.setEnabled(false);
			}
			
			buttonPegs5_1.setEnabled(true);
			buttonPegs5_2.setEnabled(true);
			buttonPegs5_3.setEnabled(true);
			buttonPegs5_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs5_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs5_5.setEnabled(true);
				buttonPegs5_6.setEnabled(true);
			}
			
		} else if(ronda == 5) {
			
			buttonPegs5_1.setEnabled(false);
			buttonPegs5_2.setEnabled(false);
			buttonPegs5_3.setEnabled(false);
			buttonPegs5_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs5_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs5_5.setEnabled(false);
				buttonPegs5_6.setEnabled(false);
			}
			
			buttonPegs6_1.setEnabled(true);
			buttonPegs6_2.setEnabled(true);
			buttonPegs6_3.setEnabled(true);
			buttonPegs6_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs6_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs6_5.setEnabled(true);
				buttonPegs6_6.setEnabled(true);
			}
			
		} else if(ronda == 6) {
		
			buttonPegs6_1.setEnabled(false);
			buttonPegs6_2.setEnabled(false);
			buttonPegs6_3.setEnabled(false);
			buttonPegs6_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs6_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs6_5.setEnabled(false);
				buttonPegs6_6.setEnabled(false);
			}
			
			buttonPegs7_1.setEnabled(true);
			buttonPegs7_2.setEnabled(true);
			buttonPegs7_3.setEnabled(true);
			buttonPegs7_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs7_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs7_5.setEnabled(true);
				buttonPegs7_6.setEnabled(true);
			}
			
		} else if(ronda == 7) {
			
			buttonPegs7_1.setEnabled(false);
			buttonPegs7_2.setEnabled(false);
			buttonPegs7_3.setEnabled(false);
			buttonPegs7_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs7_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs7_5.setEnabled(false);
				buttonPegs7_6.setEnabled(false);
			}
			
			buttonPegs8_1.setEnabled(true);
			buttonPegs8_2.setEnabled(true);
			buttonPegs8_3.setEnabled(true);
			buttonPegs8_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs8_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs8_5.setEnabled(true);
				buttonPegs8_6.setEnabled(true);
			}
			
		} else if (ronda == 8) {
			
			buttonPegs8_1.setEnabled(false);
			buttonPegs8_2.setEnabled(false);
			buttonPegs8_3.setEnabled(false);
			buttonPegs8_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs8_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs8_5.setEnabled(false);
				buttonPegs8_6.setEnabled(false);
			}
			
			buttonPegs9_1.setEnabled(true);
			buttonPegs9_2.setEnabled(true);
			buttonPegs9_3.setEnabled(true);
			buttonPegs9_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs9_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs9_5.setEnabled(true);
				buttonPegs9_6.setEnabled(true);
			}
			
		} else if(ronda == 9){
			
			buttonPegs9_1.setEnabled(false);
			buttonPegs9_2.setEnabled(false);
			buttonPegs9_3.setEnabled(false);
			buttonPegs9_4.setEnabled(false);
			
			if(difficulty == 2) buttonPegs9_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonPegs9_5.setEnabled(false);
				buttonPegs9_6.setEnabled(false);
			}

			buttonPegs10_1.setEnabled(true);
			buttonPegs10_2.setEnabled(true);
			buttonPegs10_3.setEnabled(true);
			buttonPegs10_4.setEnabled(true);
			
			if(difficulty == 2) buttonPegs10_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonPegs10_5.setEnabled(true);
				buttonPegs10_6.setEnabled(true);
			}
		} 
	}

	/** @brief Funcio que actualitza els buttons de colors segons la ronda de la partida
     */
	private void actualitzaButtonRounds() {
		Integer ronda = cPlay.getRonda();
		
		if (ronda == 1) {
			buttonRound1_1.setEnabled(false);
			buttonRound1_2.setEnabled(false);
			buttonRound1_3.setEnabled(false);
			buttonRound1_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound1_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound1_5.setEnabled(false);
				buttonRound1_6.setEnabled(false);
			}
			
			buttonRound2_1.setEnabled(true);
			buttonRound2_2.setEnabled(true);
			buttonRound2_3.setEnabled(true);
			buttonRound2_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound2_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound2_5.setEnabled(true);
				buttonRound2_6.setEnabled(true);
			}
		} else if(ronda == 2) {
			buttonRound2_1.setEnabled(false);
			buttonRound2_2.setEnabled(false);
			buttonRound2_3.setEnabled(false);
			buttonRound2_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound2_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound2_5.setEnabled(false);
				buttonRound2_6.setEnabled(false);
			}
			
			buttonRound3_1.setEnabled(true);
			buttonRound3_2.setEnabled(true);
			buttonRound3_3.setEnabled(true);
			buttonRound3_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound3_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound3_5.setEnabled(true);
				buttonRound3_6.setEnabled(true);
			}
			
		} else if(ronda == 3) {
			buttonRound3_1.setEnabled(false);
			buttonRound3_2.setEnabled(false);
			buttonRound3_3.setEnabled(false);
			buttonRound3_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound3_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound3_5.setEnabled(false);
				buttonRound3_6.setEnabled(false);
			}
			
			buttonRound4_1.setEnabled(true);
			buttonRound4_2.setEnabled(true);
			buttonRound4_3.setEnabled(true);
			buttonRound4_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound4_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound4_5.setEnabled(true);
				buttonRound4_6.setEnabled(true);
			}
			
		} else if(ronda == 4) {
			buttonRound4_1.setEnabled(false);
			buttonRound4_2.setEnabled(false);
			buttonRound4_3.setEnabled(false);
			buttonRound4_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound4_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound4_5.setEnabled(false);
				buttonRound4_6.setEnabled(false);
			}
			
			buttonRound5_1.setEnabled(true);
			buttonRound5_2.setEnabled(true);
			buttonRound5_3.setEnabled(true);
			buttonRound5_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound5_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound5_5.setEnabled(true);
				buttonRound5_6.setEnabled(true);
			}
			
		} else if(ronda == 5) {
			buttonRound5_1.setEnabled(false);
			buttonRound5_2.setEnabled(false);
			buttonRound5_3.setEnabled(false);
			buttonRound5_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound5_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound5_5.setEnabled(false);
				buttonRound5_6.setEnabled(false);
			}
			
			buttonRound6_1.setEnabled(true);
			buttonRound6_2.setEnabled(true);
			buttonRound6_3.setEnabled(true);
			buttonRound6_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound6_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound6_5.setEnabled(true);
				buttonRound6_6.setEnabled(true);
			}
			
		} else if(ronda == 6) {
			buttonRound6_1.setEnabled(false);
			buttonRound6_2.setEnabled(false);
			buttonRound6_3.setEnabled(false);
			buttonRound6_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound6_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound6_5.setEnabled(false);
				buttonRound6_6.setEnabled(false);
			}
			
			buttonRound7_1.setEnabled(true);
			buttonRound7_2.setEnabled(true);
			buttonRound7_3.setEnabled(true);
			buttonRound7_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound7_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound7_5.setEnabled(true);
				buttonRound7_6.setEnabled(true);
			}
			
		} else if(ronda == 7) {
			buttonRound7_1.setEnabled(false);
			buttonRound7_2.setEnabled(false);
			buttonRound7_3.setEnabled(false);
			buttonRound7_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound7_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound7_5.setEnabled(false);
				buttonRound7_6.setEnabled(false);
			}
			
			buttonRound8_1.setEnabled(true);
			buttonRound8_2.setEnabled(true);
			buttonRound8_3.setEnabled(true);
			buttonRound8_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound8_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound8_5.setEnabled(true);
				buttonRound8_6.setEnabled(true);
			}
			
		} else if (ronda == 8) {
			buttonRound8_1.setEnabled(false);
			buttonRound8_2.setEnabled(false);
			buttonRound8_3.setEnabled(false);
			buttonRound8_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound8_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound8_5.setEnabled(false);
				buttonRound8_6.setEnabled(false);
			}
			
			buttonRound9_1.setEnabled(true);
			buttonRound9_2.setEnabled(true);
			buttonRound9_3.setEnabled(true);
			buttonRound9_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound9_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound9_5.setEnabled(true);
				buttonRound9_6.setEnabled(true);
			}
			
		} else if(ronda == 9){
			buttonRound9_1.setEnabled(false);
			buttonRound9_2.setEnabled(false);
			buttonRound9_3.setEnabled(false);
			buttonRound9_4.setEnabled(false);
			
			if(difficulty == 2) buttonRound9_5.setEnabled(false);
			else if(difficulty == 3) {
				buttonRound9_5.setEnabled(false);
				buttonRound9_6.setEnabled(false);
			}

			buttonRound10_1.setEnabled(true);
			buttonRound10_2.setEnabled(true);
			buttonRound10_3.setEnabled(true);
			buttonRound10_4.setEnabled(true);
			
			if(difficulty == 2) buttonRound10_5.setEnabled(true);
			else if(difficulty == 3) {
				buttonRound10_5.setEnabled(true);
				buttonRound10_6.setEnabled(true);
			}
		}
	}
	
	/** @brief Funcio que mostra els colors del tauler al carregar la partida
     *  
	 * @param como llista de codis a posar als buttons de colors
     */
	private void mostraColors(List<List<Integer>> como) {
		
		Integer ronda = cPlay.getRonda();
		
		if(ronda == 0) {
			
			if (como.get(0).get(0) == 0) buttonRound1_1.setBackground(vermell);
			else if (como.get(0).get(0) == 1) buttonRound1_1.setBackground(verd);
			else if (como.get(0).get(0) == 2) buttonRound1_1.setBackground(blau);
			else if (como.get(0).get(0) == 3) buttonRound1_1.setBackground(groc);
			else if (como.get(0).get(0) == 4) buttonRound1_1.setBackground(black);
			else if (como.get(0).get(0) == 5) buttonRound1_1.setBackground(blanc);
			
			if (como.get(0).get(1) == 0) buttonRound1_2.setBackground(vermell);
			else if (como.get(0).get(1) == 1) buttonRound1_2.setBackground(verd);
			else if (como.get(0).get(1) == 2) buttonRound1_2.setBackground(blau);
			else if (como.get(0).get(1) == 3) buttonRound1_2.setBackground(groc);
			else if (como.get(0).get(1) == 4) buttonRound1_2.setBackground(black);
			else if (como.get(0).get(1) == 5) buttonRound1_2.setBackground(blanc);
			
			if (como.get(0).get(2) == 0) buttonRound1_3.setBackground(vermell);
			else if (como.get(0).get(2) == 1) buttonRound1_3.setBackground(verd);
			else if (como.get(0).get(2) == 2) buttonRound1_3.setBackground(blau);
			else if (como.get(0).get(2) == 3) buttonRound1_3.setBackground(groc);
			else if (como.get(0).get(2) == 4) buttonRound1_3.setBackground(black);
			else if (como.get(0).get(2) == 5) buttonRound1_3.setBackground(blanc);
			
			if (como.get(0).get(3) == 0) buttonRound1_4.setBackground(vermell);
			else if (como.get(0).get(3) == 1) buttonRound1_4.setBackground(verd);
			else if (como.get(0).get(3) == 2) buttonRound1_4.setBackground(blau);
			else if (como.get(0).get(3) == 3) buttonRound1_4.setBackground(groc);
			else if (como.get(0).get(3) == 4) buttonRound1_4.setBackground(black);
			else if (como.get(0).get(3) == 5) buttonRound1_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(0).get(4) == 0) buttonRound1_5.setBackground(vermell);
				else if (como.get(0).get(4) == 1) buttonRound1_5.setBackground(verd);
				else if (como.get(0).get(4) == 2) buttonRound1_5.setBackground(blau);
				else if (como.get(0).get(4) == 3) buttonRound1_5.setBackground(groc);
				else if (como.get(0).get(4) == 4) buttonRound1_5.setBackground(black);
				else if (como.get(0).get(4) == 5) buttonRound1_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(0).get(4) == 0) buttonRound1_5.setBackground(vermell);
				else if (como.get(0).get(4) == 1) buttonRound1_5.setBackground(verd);
				else if (como.get(0).get(4) == 2) buttonRound1_5.setBackground(blau);
				else if (como.get(0).get(4) == 3) buttonRound1_5.setBackground(groc);
				else if (como.get(0).get(4) == 4) buttonRound1_5.setBackground(black);
				else if (como.get(0).get(4) == 5) buttonRound1_5.setBackground(blanc);

				if (como.get(0).get(5) == 0) buttonRound1_6.setBackground(vermell);
				else if (como.get(0).get(5) == 1) buttonRound1_6.setBackground(verd);
				else if (como.get(0).get(5) == 2) buttonRound1_6.setBackground(blau);
				else if (como.get(0).get(5) == 3) buttonRound1_6.setBackground(groc);
				else if (como.get(0).get(5) == 4) buttonRound1_6.setBackground(black);
				else if (como.get(0).get(5) == 5) buttonRound1_6.setBackground(blanc);

			}
			
		} else if (ronda == 1) {
			
			if (como.get(1).get(0) == 0) buttonRound2_1.setBackground(vermell);
			else if (como.get(1).get(0) == 1) buttonRound2_1.setBackground(verd);
			else if (como.get(1).get(0) == 2) buttonRound2_1.setBackground(blau);
			else if (como.get(1).get(0) == 3) buttonRound2_1.setBackground(groc);
			else if (como.get(1).get(0) == 4) buttonRound2_1.setBackground(black);
			else if (como.get(1).get(0) == 5) buttonRound2_1.setBackground(blanc);
			
			if (como.get(1).get(1) == 0) buttonRound2_2.setBackground(vermell);
			else if (como.get(1).get(1) == 1) buttonRound2_2.setBackground(verd);
			else if (como.get(1).get(1) == 2) buttonRound2_2.setBackground(blau);
			else if (como.get(1).get(1) == 3) buttonRound2_2.setBackground(groc);
			else if (como.get(1).get(1) == 4) buttonRound2_2.setBackground(black);
			else if (como.get(1).get(1) == 5) buttonRound2_2.setBackground(blanc);
			
			if (como.get(1).get(2) == 0) buttonRound2_3.setBackground(vermell);
			else if (como.get(1).get(2) == 1) buttonRound2_3.setBackground(verd);
			else if (como.get(1).get(2) == 2) buttonRound2_3.setBackground(blau);
			else if (como.get(1).get(2) == 3) buttonRound2_3.setBackground(groc);
			else if (como.get(1).get(2) == 4) buttonRound2_3.setBackground(black);
			else if (como.get(1).get(2) == 5) buttonRound2_3.setBackground(blanc);
			
			if (como.get(1).get(3) == 0) buttonRound2_4.setBackground(vermell);
			else if (como.get(1).get(3) == 1) buttonRound2_4.setBackground(verd);
			else if (como.get(1).get(3) == 2) buttonRound2_4.setBackground(blau);
			else if (como.get(1).get(3) == 3) buttonRound2_4.setBackground(groc);
			else if (como.get(1).get(3) == 4) buttonRound2_4.setBackground(black);
			else if (como.get(1).get(3) == 5) buttonRound2_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(1).get(4) == 0) buttonRound2_5.setBackground(vermell);
				else if (como.get(1).get(4) == 1) buttonRound2_5.setBackground(verd);
				else if (como.get(1).get(4) == 2) buttonRound2_5.setBackground(blau);
				else if (como.get(1).get(4) == 3) buttonRound2_5.setBackground(groc);
				else if (como.get(1).get(4) == 4) buttonRound2_5.setBackground(black);
				else if (como.get(1).get(4) == 5) buttonRound2_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(1).get(4) == 0) buttonRound2_5.setBackground(vermell);
				else if (como.get(1).get(4) == 1) buttonRound2_5.setBackground(verd);
				else if (como.get(1).get(4) == 2) buttonRound2_5.setBackground(blau);
				else if (como.get(1).get(4) == 3) buttonRound2_5.setBackground(groc);
				else if (como.get(1).get(4) == 4) buttonRound2_5.setBackground(black);
				else if (como.get(1).get(4) == 5) buttonRound2_5.setBackground(blanc);

				if (como.get(1).get(5) == 0) buttonRound2_6.setBackground(vermell);
				else if (como.get(1).get(5) == 1) buttonRound2_6.setBackground(verd);
				else if (como.get(1).get(5) == 2) buttonRound2_6.setBackground(blau);
				else if (como.get(1).get(5) == 3) buttonRound2_6.setBackground(groc);
				else if (como.get(1).get(5) == 4) buttonRound2_6.setBackground(black);
				else if (como.get(1).get(5) == 5) buttonRound2_6.setBackground(blanc);

			}
		
		} else if(ronda == 2) {
			
			if (como.get(2).get(0) == 0) buttonRound3_1.setBackground(vermell);
			else if (como.get(2).get(0) == 1) buttonRound3_1.setBackground(verd);
			else if (como.get(2).get(0) == 2) buttonRound3_1.setBackground(blau);
			else if (como.get(2).get(0) == 3) buttonRound3_1.setBackground(groc);
			else if (como.get(2).get(0) == 4) buttonRound3_1.setBackground(black);
			else if (como.get(2).get(0) == 5) buttonRound3_1.setBackground(blanc);
			
			if (como.get(2).get(1) == 0) buttonRound3_2.setBackground(vermell);
			else if (como.get(2).get(1) == 1) buttonRound3_2.setBackground(verd);
			else if (como.get(2).get(1) == 2) buttonRound3_2.setBackground(blau);
			else if (como.get(2).get(1) == 3) buttonRound3_2.setBackground(groc);
			else if (como.get(2).get(1) == 4) buttonRound3_2.setBackground(black);
			else if (como.get(2).get(1) == 5) buttonRound3_2.setBackground(blanc);
			
			if (como.get(2).get(2) == 0) buttonRound3_3.setBackground(vermell);
			else if (como.get(2).get(2) == 1) buttonRound3_3.setBackground(verd);
			else if (como.get(2).get(2) == 2) buttonRound3_3.setBackground(blau);
			else if (como.get(2).get(2) == 3) buttonRound3_3.setBackground(groc);
			else if (como.get(2).get(2) == 4) buttonRound3_3.setBackground(black);
			else if (como.get(2).get(2) == 5) buttonRound3_3.setBackground(blanc);
			
			if (como.get(2).get(3) == 0) buttonRound3_4.setBackground(vermell);
			else if (como.get(2).get(3) == 1) buttonRound3_4.setBackground(verd);
			else if (como.get(2).get(3) == 2) buttonRound3_4.setBackground(blau);
			else if (como.get(2).get(3) == 3) buttonRound3_4.setBackground(groc);
			else if (como.get(2).get(3) == 4) buttonRound3_4.setBackground(black);
			else if (como.get(2).get(3) == 5) buttonRound3_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(2).get(4) == 0) buttonRound3_5.setBackground(vermell);
				else if (como.get(2).get(4) == 1) buttonRound3_5.setBackground(verd);
				else if (como.get(2).get(4) == 2) buttonRound3_5.setBackground(blau);
				else if (como.get(2).get(4) == 3) buttonRound3_5.setBackground(groc);
				else if (como.get(2).get(4) == 4) buttonRound3_5.setBackground(black);
				else if (como.get(2).get(4) == 5) buttonRound3_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(2).get(4) == 0) buttonRound3_5.setBackground(vermell);
				else if (como.get(2).get(4) == 1) buttonRound3_5.setBackground(verd);
				else if (como.get(2).get(4) == 2) buttonRound3_5.setBackground(blau);
				else if (como.get(2).get(4) == 3) buttonRound3_5.setBackground(groc);
				else if (como.get(2).get(4) == 4) buttonRound3_5.setBackground(black);
				else if (como.get(2).get(4) == 5) buttonRound3_5.setBackground(blanc);

				if (como.get(2).get(5) == 0) buttonRound3_6.setBackground(vermell);
				else if (como.get(2).get(5) == 1) buttonRound3_6.setBackground(verd);
				else if (como.get(2).get(5) == 2) buttonRound3_6.setBackground(blau);
				else if (como.get(2).get(5) == 3) buttonRound3_6.setBackground(groc);
				else if (como.get(2).get(5) == 4) buttonRound3_6.setBackground(black);
				else if (como.get(2).get(5) == 5) buttonRound3_6.setBackground(blanc);

			}
			
		} else if(ronda == 3) {
			
			if (como.get(3).get(0) == 0) buttonRound4_1.setBackground(vermell);
			else if (como.get(3).get(0) == 1) buttonRound4_1.setBackground(verd);
			else if (como.get(3).get(0) == 2) buttonRound4_1.setBackground(blau);
			else if (como.get(3).get(0) == 3) buttonRound4_1.setBackground(groc);
			else if (como.get(3).get(0) == 4) buttonRound4_1.setBackground(black);
			else if (como.get(3).get(0) == 5) buttonRound4_1.setBackground(blanc);
			
			if (como.get(3).get(1) == 0) buttonRound4_2.setBackground(vermell);
			else if (como.get(3).get(1) == 1) buttonRound4_2.setBackground(verd);
			else if (como.get(3).get(1) == 2) buttonRound4_2.setBackground(blau);
			else if (como.get(3).get(1) == 3) buttonRound4_2.setBackground(groc);
			else if (como.get(3).get(1) == 4) buttonRound4_2.setBackground(black);
			else if (como.get(3).get(1) == 5) buttonRound4_2.setBackground(blanc);
			
			if (como.get(3).get(2) == 0) buttonRound4_3.setBackground(vermell);
			else if (como.get(3).get(2) == 1) buttonRound4_3.setBackground(verd);
			else if (como.get(3).get(2) == 2) buttonRound4_3.setBackground(blau);
			else if (como.get(3).get(2) == 3) buttonRound4_3.setBackground(groc);
			else if (como.get(3).get(2) == 4) buttonRound4_3.setBackground(black);
			else if (como.get(3).get(2) == 5) buttonRound4_3.setBackground(blanc);
			
			if (como.get(3).get(3) == 0) buttonRound4_4.setBackground(vermell);
			else if (como.get(3).get(3) == 1) buttonRound4_4.setBackground(verd);
			else if (como.get(3).get(3) == 2) buttonRound4_4.setBackground(blau);
			else if (como.get(3).get(3) == 3) buttonRound4_4.setBackground(groc);
			else if (como.get(3).get(3) == 4) buttonRound4_4.setBackground(black);
			else if (como.get(3).get(3) == 5) buttonRound4_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(3).get(4) == 0) buttonRound4_5.setBackground(vermell);
				else if (como.get(3).get(4) == 1) buttonRound4_5.setBackground(verd);
				else if (como.get(3).get(4) == 2) buttonRound4_5.setBackground(blau);
				else if (como.get(3).get(4) == 3) buttonRound4_5.setBackground(groc);
				else if (como.get(3).get(4) == 4) buttonRound4_5.setBackground(black);
				else if (como.get(3).get(4) == 5) buttonRound4_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(3).get(4) == 0) buttonRound4_5.setBackground(vermell);
				else if (como.get(3).get(4) == 1) buttonRound4_5.setBackground(verd);
				else if (como.get(3).get(4) == 2) buttonRound4_5.setBackground(blau);
				else if (como.get(3).get(4) == 3) buttonRound4_5.setBackground(groc);
				else if (como.get(3).get(4) == 4) buttonRound4_5.setBackground(black);
				else if (como.get(3).get(4) == 5) buttonRound4_5.setBackground(blanc);

				if (como.get(3).get(5) == 0) buttonRound4_6.setBackground(vermell);
				else if (como.get(3).get(5) == 1) buttonRound4_6.setBackground(verd);
				else if (como.get(3).get(5) == 2) buttonRound4_6.setBackground(blau);
				else if (como.get(3).get(5) == 3) buttonRound4_6.setBackground(groc);
				else if (como.get(3).get(5) == 4) buttonRound4_6.setBackground(black);
				else if (como.get(3).get(5) == 5) buttonRound4_6.setBackground(blanc);

			}
			
		} else if(ronda == 4) {
			
			if (como.get(4).get(0) == 0) buttonRound5_1.setBackground(vermell);
			else if (como.get(4).get(0) == 1) buttonRound5_1.setBackground(verd);
			else if (como.get(4).get(0) == 2) buttonRound5_1.setBackground(blau);
			else if (como.get(4).get(0) == 3) buttonRound5_1.setBackground(groc);
			else if (como.get(4).get(0) == 4) buttonRound5_1.setBackground(black);
			else if (como.get(4).get(0) == 5) buttonRound5_1.setBackground(blanc);
			
			if (como.get(4).get(1) == 0) buttonRound5_2.setBackground(vermell);
			else if (como.get(4).get(1) == 1) buttonRound5_2.setBackground(verd);
			else if (como.get(4).get(1) == 2) buttonRound5_2.setBackground(blau);
			else if (como.get(4).get(1) == 3) buttonRound5_2.setBackground(groc);
			else if (como.get(4).get(1) == 4) buttonRound5_2.setBackground(black);
			else if (como.get(4).get(1) == 5) buttonRound5_2.setBackground(blanc);
			
			if (como.get(4).get(2) == 0) buttonRound5_3.setBackground(vermell);
			else if (como.get(4).get(2) == 1) buttonRound5_3.setBackground(verd);
			else if (como.get(4).get(2) == 2) buttonRound5_3.setBackground(blau);
			else if (como.get(4).get(2) == 3) buttonRound5_3.setBackground(groc);
			else if (como.get(4).get(2) == 4) buttonRound5_3.setBackground(black);
			else if (como.get(4).get(2) == 5) buttonRound5_3.setBackground(blanc);
			
			if (como.get(4).get(3) == 0) buttonRound5_4.setBackground(vermell);
			else if (como.get(4).get(3) == 1) buttonRound5_4.setBackground(verd);
			else if (como.get(4).get(3) == 2) buttonRound5_4.setBackground(blau);
			else if (como.get(4).get(3) == 3) buttonRound5_4.setBackground(groc);
			else if (como.get(4).get(3) == 4) buttonRound5_4.setBackground(black);
			else if (como.get(4).get(3) == 5) buttonRound5_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(4).get(4) == 0) buttonRound5_5.setBackground(vermell);
				else if (como.get(4).get(4) == 1) buttonRound5_5.setBackground(verd);
				else if (como.get(4).get(4) == 2) buttonRound5_5.setBackground(blau);
				else if (como.get(4).get(4) == 3) buttonRound5_5.setBackground(groc);
				else if (como.get(4).get(4) == 4) buttonRound5_5.setBackground(black);
				else if (como.get(4).get(4) == 5) buttonRound5_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(4).get(4) == 0) buttonRound5_5.setBackground(vermell);
				else if (como.get(4).get(4) == 1) buttonRound5_5.setBackground(verd);
				else if (como.get(4).get(4) == 2) buttonRound5_5.setBackground(blau);
				else if (como.get(4).get(4) == 3) buttonRound5_5.setBackground(groc);
				else if (como.get(4).get(4) == 4) buttonRound5_5.setBackground(black);
				else if (como.get(4).get(4) == 5) buttonRound5_5.setBackground(blanc);

				if (como.get(4).get(5) == 0) buttonRound5_6.setBackground(vermell);
				else if (como.get(4).get(5) == 1) buttonRound5_6.setBackground(verd);
				else if (como.get(4).get(5) == 2) buttonRound5_6.setBackground(blau);
				else if (como.get(4).get(5) == 3) buttonRound5_6.setBackground(groc);
				else if (como.get(4).get(5) == 4) buttonRound5_6.setBackground(black);
				else if (como.get(4).get(5) == 5) buttonRound5_6.setBackground(blanc);

			}

		} else if(ronda == 5) {
			
			if (como.get(5).get(0) == 0) buttonRound6_1.setBackground(vermell);
			else if (como.get(5).get(0) == 1) buttonRound6_1.setBackground(verd);
			else if (como.get(5).get(0) == 2) buttonRound6_1.setBackground(blau);
			else if (como.get(5).get(0) == 3) buttonRound6_1.setBackground(groc);
			else if (como.get(5).get(0) == 4) buttonRound6_1.setBackground(black);
			else if (como.get(5).get(0) == 5) buttonRound6_1.setBackground(blanc);
			
			if (como.get(5).get(1) == 0) buttonRound6_2.setBackground(vermell);
			else if (como.get(5).get(1) == 1) buttonRound6_2.setBackground(verd);
			else if (como.get(5).get(1) == 2) buttonRound6_2.setBackground(blau);
			else if (como.get(5).get(1) == 3) buttonRound6_2.setBackground(groc);
			else if (como.get(5).get(1) == 4) buttonRound6_2.setBackground(black);
			else if (como.get(5).get(1) == 5) buttonRound6_2.setBackground(blanc);
			
			if (como.get(5).get(2) == 0) buttonRound6_3.setBackground(vermell);
			else if (como.get(5).get(2) == 1) buttonRound6_3.setBackground(verd);
			else if (como.get(5).get(2) == 2) buttonRound6_3.setBackground(blau);
			else if (como.get(5).get(2) == 3) buttonRound6_3.setBackground(groc);
			else if (como.get(5).get(2) == 4) buttonRound6_3.setBackground(black);
			else if (como.get(5).get(2) == 5) buttonRound6_3.setBackground(blanc);
			
			if (como.get(5).get(3) == 0) buttonRound6_4.setBackground(vermell);
			else if (como.get(5).get(3) == 1) buttonRound6_4.setBackground(verd);
			else if (como.get(5).get(3) == 2) buttonRound6_4.setBackground(blau);
			else if (como.get(5).get(3) == 3) buttonRound6_4.setBackground(groc);
			else if (como.get(5).get(3) == 4) buttonRound6_4.setBackground(black);
			else if (como.get(5).get(3) == 5) buttonRound6_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(5).get(4) == 0) buttonRound6_5.setBackground(vermell);
				else if (como.get(5).get(4) == 1) buttonRound6_5.setBackground(verd);
				else if (como.get(5).get(4) == 2) buttonRound6_5.setBackground(blau);
				else if (como.get(5).get(4) == 3) buttonRound6_5.setBackground(groc);
				else if (como.get(5).get(4) == 4) buttonRound6_5.setBackground(black);
				else if (como.get(5).get(4) == 5) buttonRound6_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(5).get(4) == 0) buttonRound6_5.setBackground(vermell);
				else if (como.get(5).get(4) == 1) buttonRound6_5.setBackground(verd);
				else if (como.get(5).get(4) == 2) buttonRound6_5.setBackground(blau);
				else if (como.get(5).get(4) == 3) buttonRound6_5.setBackground(groc);
				else if (como.get(5).get(4) == 4) buttonRound6_5.setBackground(black);
				else if (como.get(5).get(4) == 5) buttonRound6_5.setBackground(blanc);

				if (como.get(5).get(5) == 0) buttonRound6_6.setBackground(vermell);
				else if (como.get(5).get(5) == 1) buttonRound6_6.setBackground(verd);
				else if (como.get(5).get(5) == 2) buttonRound6_6.setBackground(blau);
				else if (como.get(5).get(5) == 3) buttonRound6_6.setBackground(groc);
				else if (como.get(5).get(5) == 4) buttonRound6_6.setBackground(black);
				else if (como.get(5).get(5) == 5) buttonRound6_6.setBackground(blanc);

			}
			
			
		} else if(ronda == 6) {
			
			if (como.get(6).get(0) == 0) buttonRound7_1.setBackground(vermell);
			else if (como.get(6).get(0) == 1) buttonRound7_1.setBackground(verd);
			else if (como.get(6).get(0) == 2) buttonRound7_1.setBackground(blau);
			else if (como.get(6).get(0) == 3) buttonRound7_1.setBackground(groc);
			else if (como.get(6).get(0) == 4) buttonRound7_1.setBackground(black);
			else if (como.get(6).get(0) == 5) buttonRound7_1.setBackground(blanc);
			
			if (como.get(6).get(1) == 0) buttonRound7_2.setBackground(vermell);
			else if (como.get(6).get(1) == 1) buttonRound7_2.setBackground(verd);
			else if (como.get(6).get(1) == 2) buttonRound7_2.setBackground(blau);
			else if (como.get(6).get(1) == 3) buttonRound7_2.setBackground(groc);
			else if (como.get(6).get(1) == 4) buttonRound7_2.setBackground(black);
			else if (como.get(6).get(1) == 5) buttonRound7_2.setBackground(blanc);
			
			if (como.get(6).get(2) == 0) buttonRound7_3.setBackground(vermell);
			else if (como.get(6).get(2) == 1) buttonRound7_3.setBackground(verd);
			else if (como.get(6).get(2) == 2) buttonRound7_3.setBackground(blau);
			else if (como.get(6).get(2) == 3) buttonRound7_3.setBackground(groc);
			else if (como.get(6).get(2) == 4) buttonRound7_3.setBackground(black);
			else if (como.get(6).get(2) == 5) buttonRound7_3.setBackground(blanc);
			
			if (como.get(6).get(3) == 0) buttonRound7_4.setBackground(vermell);
			else if (como.get(6).get(3) == 1) buttonRound7_4.setBackground(verd);
			else if (como.get(6).get(3) == 2) buttonRound7_4.setBackground(blau);
			else if (como.get(6).get(3) == 3) buttonRound7_4.setBackground(groc);
			else if (como.get(6).get(3) == 4) buttonRound7_4.setBackground(black);
			else if (como.get(6).get(3) == 5) buttonRound7_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(6).get(4) == 0) buttonRound7_5.setBackground(vermell);
				else if (como.get(6).get(4) == 1) buttonRound7_5.setBackground(verd);
				else if (como.get(6).get(4) == 2) buttonRound7_5.setBackground(blau);
				else if (como.get(6).get(4) == 3) buttonRound7_5.setBackground(groc);
				else if (como.get(6).get(4) == 4) buttonRound7_5.setBackground(black);
				else if (como.get(6).get(4) == 5) buttonRound7_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(6).get(4) == 0) buttonRound7_5.setBackground(vermell);
				else if (como.get(6).get(4) == 1) buttonRound7_5.setBackground(verd);
				else if (como.get(6).get(4) == 2) buttonRound7_5.setBackground(blau);
				else if (como.get(6).get(4) == 3) buttonRound7_5.setBackground(groc);
				else if (como.get(6).get(4) == 4) buttonRound7_5.setBackground(black);
				else if (como.get(6).get(4) == 5) buttonRound7_5.setBackground(blanc);

				if (como.get(6).get(5) == 0) buttonRound7_6.setBackground(vermell);
				else if (como.get(6).get(5) == 1) buttonRound7_6.setBackground(verd);
				else if (como.get(6).get(5) == 2) buttonRound7_6.setBackground(blau);
				else if (como.get(6).get(5) == 3) buttonRound7_6.setBackground(groc);
				else if (como.get(6).get(5) == 4) buttonRound7_6.setBackground(black);
				else if (como.get(6).get(5) == 5) buttonRound7_6.setBackground(blanc);

			}
			
		} else if(ronda == 7) {
			
			if (como.get(7).get(0) == 0) buttonRound8_1.setBackground(vermell);
			else if (como.get(7).get(0) == 1) buttonRound8_1.setBackground(verd);
			else if (como.get(7).get(0) == 2) buttonRound8_1.setBackground(blau);
			else if (como.get(7).get(0) == 3) buttonRound8_1.setBackground(groc);
			else if (como.get(7).get(0) == 4) buttonRound8_1.setBackground(black);
			else if (como.get(7).get(0) == 5) buttonRound8_1.setBackground(blanc);
			
			if (como.get(7).get(1) == 0) buttonRound8_2.setBackground(vermell);
			else if (como.get(7).get(1) == 1) buttonRound8_2.setBackground(verd);
			else if (como.get(7).get(1) == 2) buttonRound8_2.setBackground(blau);
			else if (como.get(7).get(1) == 3) buttonRound8_2.setBackground(groc);
			else if (como.get(7).get(1) == 4) buttonRound8_2.setBackground(black);
			else if (como.get(7).get(1) == 5) buttonRound8_2.setBackground(blanc);
			
			if (como.get(7).get(2) == 0) buttonRound8_3.setBackground(vermell);
			else if (como.get(7).get(2) == 1) buttonRound8_3.setBackground(verd);
			else if (como.get(7).get(2) == 2) buttonRound8_3.setBackground(blau);
			else if (como.get(7).get(2) == 3) buttonRound8_3.setBackground(groc);
			else if (como.get(7).get(2) == 4) buttonRound8_3.setBackground(black);
			else if (como.get(7).get(2) == 5) buttonRound8_3.setBackground(blanc);
			
			if (como.get(7).get(3) == 0) buttonRound8_4.setBackground(vermell);
			else if (como.get(7).get(3) == 1) buttonRound8_4.setBackground(verd);
			else if (como.get(7).get(3) == 2) buttonRound8_4.setBackground(blau);
			else if (como.get(7).get(3) == 3) buttonRound8_4.setBackground(groc);
			else if (como.get(7).get(3) == 4) buttonRound8_4.setBackground(black);
			else if (como.get(7).get(3) == 5) buttonRound8_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(7).get(4) == 0) buttonRound8_5.setBackground(vermell);
				else if (como.get(7).get(4) == 1) buttonRound8_5.setBackground(verd);
				else if (como.get(7).get(4) == 2) buttonRound8_5.setBackground(blau);
				else if (como.get(7).get(4) == 3) buttonRound8_5.setBackground(groc);
				else if (como.get(7).get(4) == 4) buttonRound8_5.setBackground(black);
				else if (como.get(7).get(4) == 5) buttonRound8_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(7).get(4) == 0) buttonRound8_5.setBackground(vermell);
				else if (como.get(7).get(4) == 1) buttonRound8_5.setBackground(verd);
				else if (como.get(7).get(4) == 2) buttonRound8_5.setBackground(blau);
				else if (como.get(7).get(4) == 3) buttonRound8_5.setBackground(groc);
				else if (como.get(7).get(4) == 4) buttonRound8_5.setBackground(black);
				else if (como.get(7).get(4) == 5) buttonRound8_5.setBackground(blanc);

				if (como.get(7).get(5) == 0) buttonRound8_6.setBackground(vermell);
				else if (como.get(7).get(5) == 1) buttonRound8_6.setBackground(verd);
				else if (como.get(7).get(5) == 2) buttonRound8_6.setBackground(blau);
				else if (como.get(7).get(5) == 3) buttonRound8_6.setBackground(groc);
				else if (como.get(7).get(5) == 4) buttonRound8_6.setBackground(black);
				else if (como.get(7).get(5) == 5) buttonRound8_6.setBackground(blanc);

			}
			
		} else if (ronda == 8) {
			
			if (como.get(8).get(0) == 0) buttonRound9_1.setBackground(vermell);
			else if (como.get(8).get(0) == 1) buttonRound9_1.setBackground(verd);
			else if (como.get(8).get(0) == 2) buttonRound9_1.setBackground(blau);
			else if (como.get(8).get(0) == 3) buttonRound9_1.setBackground(groc);
			else if (como.get(8).get(0) == 4) buttonRound9_1.setBackground(black);
			else if (como.get(8).get(0) == 5) buttonRound9_1.setBackground(blanc);
			
			if (como.get(8).get(1) == 0) buttonRound9_2.setBackground(vermell);
			else if (como.get(8).get(1) == 1) buttonRound9_2.setBackground(verd);
			else if (como.get(8).get(1) == 2) buttonRound9_2.setBackground(blau);
			else if (como.get(8).get(1) == 3) buttonRound9_2.setBackground(groc);
			else if (como.get(8).get(1) == 4) buttonRound9_2.setBackground(black);
			else if (como.get(8).get(1) == 5) buttonRound9_2.setBackground(blanc);
			
			if (como.get(8).get(2) == 0) buttonRound9_3.setBackground(vermell);
			else if (como.get(8).get(2) == 1) buttonRound9_3.setBackground(verd);
			else if (como.get(8).get(2) == 2) buttonRound9_3.setBackground(blau);
			else if (como.get(8).get(2) == 3) buttonRound9_3.setBackground(groc);
			else if (como.get(8).get(2) == 4) buttonRound9_3.setBackground(black);
			else if (como.get(8).get(2) == 5) buttonRound9_3.setBackground(blanc);
			
			if (como.get(8).get(3) == 0) buttonRound9_4.setBackground(vermell);
			else if (como.get(8).get(3) == 1) buttonRound9_4.setBackground(verd);
			else if (como.get(8).get(3) == 2) buttonRound9_4.setBackground(blau);
			else if (como.get(8).get(3) == 3) buttonRound9_4.setBackground(groc);
			else if (como.get(8).get(3) == 4) buttonRound9_4.setBackground(black);
			else if (como.get(8).get(3) == 5) buttonRound9_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(8).get(4) == 0) buttonRound9_5.setBackground(vermell);
				else if (como.get(8).get(4) == 1) buttonRound9_5.setBackground(verd);
				else if (como.get(8).get(4) == 2) buttonRound9_5.setBackground(blau);
				else if (como.get(8).get(4) == 3) buttonRound9_5.setBackground(groc);
				else if (como.get(8).get(4) == 4) buttonRound9_5.setBackground(black);
				else if (como.get(8).get(4) == 5) buttonRound9_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(8).get(4) == 0) buttonRound9_5.setBackground(vermell);
				else if (como.get(8).get(4) == 1) buttonRound9_5.setBackground(verd);
				else if (como.get(8).get(4) == 2) buttonRound9_5.setBackground(blau);
				else if (como.get(8).get(4) == 3) buttonRound9_5.setBackground(groc);
				else if (como.get(8).get(4) == 4) buttonRound9_5.setBackground(black);
				else if (como.get(8).get(4) == 5) buttonRound9_5.setBackground(blanc);

				if (como.get(8).get(5) == 0) buttonRound9_6.setBackground(vermell);
				else if (como.get(8).get(5) == 1) buttonRound9_6.setBackground(verd);
				else if (como.get(8).get(5) == 2) buttonRound9_6.setBackground(blau);
				else if (como.get(8).get(5) == 3) buttonRound9_6.setBackground(groc);
				else if (como.get(8).get(5) == 4) buttonRound9_6.setBackground(black);
				else if (como.get(8).get(5) == 5) buttonRound9_6.setBackground(blanc);
			}
			
		} else {
			
			if (como.get(9).get(0) == 0) buttonRound10_1.setBackground(vermell);
			else if (como.get(9).get(0) == 1) buttonRound10_1.setBackground(verd);
			else if (como.get(9).get(0) == 2) buttonRound10_1.setBackground(blau);
			else if (como.get(9).get(0) == 3) buttonRound10_1.setBackground(groc);
			else if (como.get(9).get(0) == 4) buttonRound10_1.setBackground(black);
			else if (como.get(9).get(0) == 5) buttonRound10_1.setBackground(blanc);
			
			if (como.get(9).get(1) == 0) buttonRound10_2.setBackground(vermell);
			else if (como.get(9).get(1) == 1) buttonRound10_2.setBackground(verd);
			else if (como.get(9).get(1) == 2) buttonRound10_2.setBackground(blau);
			else if (como.get(9).get(1) == 3) buttonRound10_2.setBackground(groc);
			else if (como.get(9).get(1) == 4) buttonRound10_2.setBackground(black);
			else if (como.get(9).get(1) == 5) buttonRound10_2.setBackground(blanc);
			
			if (como.get(9).get(2) == 0) buttonRound10_3.setBackground(vermell);
			else if (como.get(9).get(2) == 1) buttonRound10_3.setBackground(verd);
			else if (como.get(9).get(2) == 2) buttonRound10_3.setBackground(blau);
			else if (como.get(9).get(2) == 3) buttonRound10_3.setBackground(groc);
			else if (como.get(9).get(2) == 4) buttonRound10_3.setBackground(black);
			else if (como.get(9).get(2) == 5) buttonRound10_3.setBackground(blanc);
			
			if (como.get(9).get(3) == 0) buttonRound10_4.setBackground(vermell);
			else if (como.get(9).get(3) == 1) buttonRound10_4.setBackground(verd);
			else if (como.get(9).get(3) == 2) buttonRound10_4.setBackground(blau);
			else if (como.get(9).get(3) == 3) buttonRound10_4.setBackground(groc);
			else if (como.get(9).get(3) == 4) buttonRound10_4.setBackground(black);
			else if (como.get(9).get(3) == 5) buttonRound10_4.setBackground(blanc);

			if (difficulty == 2) {
				if (como.get(9).get(4) == 0) buttonRound10_5.setBackground(vermell);
				else if (como.get(9).get(4) == 1) buttonRound10_5.setBackground(verd);
				else if (como.get(9).get(4) == 2) buttonRound10_5.setBackground(blau);
				else if (como.get(9).get(4) == 3) buttonRound10_5.setBackground(groc);
				else if (como.get(9).get(4) == 4) buttonRound10_5.setBackground(black);
				else if (como.get(9).get(4) == 5) buttonRound10_5.setBackground(blanc);
			} else if (difficulty == 3) {
				if (como.get(9).get(4) == 0) buttonRound10_5.setBackground(vermell);
				else if (como.get(9).get(4) == 1) buttonRound10_5.setBackground(verd);
				else if (como.get(9).get(4) == 2) buttonRound10_5.setBackground(blau);
				else if (como.get(9).get(4) == 3) buttonRound10_5.setBackground(groc);
				else if (como.get(9).get(4) == 4) buttonRound10_5.setBackground(black);
				else if (como.get(9).get(4) == 5) buttonRound10_5.setBackground(blanc);

				if (como.get(9).get(5) == 0) buttonRound10_6.setBackground(vermell);
				else if (como.get(9).get(5) == 1) buttonRound10_6.setBackground(verd);
				else if (como.get(9).get(5) == 2) buttonRound10_6.setBackground(blau);
				else if (como.get(9).get(5) == 3) buttonRound10_6.setBackground(groc);
				else if (como.get(9).get(5) == 4) buttonRound10_6.setBackground(black);
				else if (como.get(9).get(5) == 5) buttonRound10_6.setBackground(blanc);
			}
		}
	}

	/** @brief Funcio que comprova al fer check si els colors introduits son correctes
	 * 
	 * @return cert si son correctes, fals si no
     */
	public boolean wrongRoundColors() {
		Integer ronda = cPlay.getRonda();

		if (ronda == 0) {
			
			if (buttonRound1_1.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound1_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound1_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound1_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound1_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound1_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound1_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 1) {
			
			if (buttonRound2_1.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound2_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound2_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound2_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound2_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound2_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound2_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 2) {
			
			if (buttonRound3_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound3_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound3_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound3_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound3_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound3_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound3_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 3) {
			
			if (buttonRound4_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound4_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound4_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound4_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound4_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound4_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound4_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 4) {
			
			if (buttonRound5_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound5_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound5_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound5_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound5_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound5_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound5_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 5) {
			
			if (buttonRound6_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound6_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound6_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound6_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound6_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound6_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound6_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 6) {
			
			if (buttonRound7_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound7_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound7_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound7_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound7_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound7_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound7_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 7) {
			
			if (buttonRound8_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound8_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound8_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound8_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound8_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound8_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound8_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 8) {
			
			if (buttonRound9_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound9_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound9_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound9_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound9_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound9_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound9_6.getBackground().getRGB() == bgRGB;
			}

		} else if (ronda == 9) {
			
			if (buttonRound10_1.getBackground().getRGB() == bgRGB) return true;
		 	if (buttonRound10_2.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound10_3.getBackground().getRGB() == bgRGB) return true;
			if (buttonRound10_4.getBackground().getRGB() == bgRGB) return true;
			
			if (difficulty == 2) {
				return buttonRound10_5.getBackground().getRGB() == bgRGB;
				
			} else if (difficulty == 3) {

				if (buttonRound10_5.getBackground().getRGB() == bgRGB) return true;
				return buttonRound10_6.getBackground().getRGB() == bgRGB;
			}

		}

		return false;
	}

	/** @brief Funcio que comprova al fer check si els pegs introduits són correctes
	 * 
	 * @return cert si son correctes, fals si no
     */
	public boolean wrongPegs() {
		
		Integer ronda = cPlay.getRonda();
		
		String pegsUsuari = "";
		
		if(ronda == 0) {
			
			if (buttonPegs1_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs1_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs1_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs1_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs1_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs1_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs1_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs1_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs1_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs1_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs1_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs1_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs1_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs1_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
			
		} else if (ronda == 1) {
			
			if (buttonPegs2_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs2_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs2_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs2_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs2_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs2_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs2_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs2_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs2_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs2_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs2_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs2_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs2_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs2_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
		
		} else if(ronda == 2) {
			
			if (buttonPegs3_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs3_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs3_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs3_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs3_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs3_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs3_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs3_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs3_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs3_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs3_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs3_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs3_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs3_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
		
		} else if(ronda == 3) {
			
			if (buttonPegs4_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs4_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs4_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs4_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs4_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs4_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs4_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs4_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs4_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs4_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs4_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs4_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs4_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs4_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
			
		} else if(ronda == 4) {
			
			if (buttonPegs5_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs5_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs5_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs5_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs5_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs5_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs5_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs5_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs5_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs5_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs5_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs5_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs5_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs5_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}

		} else if(ronda == 5) {
			
			if (buttonPegs6_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs6_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs6_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs6_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs6_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs6_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs6_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs6_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs6_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs6_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs6_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs6_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs6_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs6_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
			
		} else if(ronda == 6) {
		
			if (buttonPegs7_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs7_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs7_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs7_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs7_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs7_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs7_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs7_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs7_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs7_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs7_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs7_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs7_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs7_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
			
		} else if(ronda == 7) {
			
			if (buttonPegs8_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs8_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs8_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs8_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs8_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs8_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs8_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs8_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs8_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs8_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs8_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs8_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs8_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs8_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
			
		} else if (ronda == 8) {
			
			if (buttonPegs9_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs9_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs9_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs9_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs9_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs9_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs9_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs9_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs9_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs9_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs9_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs9_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs9_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs9_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}
			
		} else if (ronda == 9) {
			
			if (buttonPegs10_1.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs10_1.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari = "_";
			
			if (buttonPegs10_2.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs1_2.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs10_3.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs10_3.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if (buttonPegs10_4.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
			else if(buttonPegs10_4.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
			else pegsUsuari += "_";
			
			if(difficulty == 2) {
				if (buttonPegs10_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs10_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			} else if(difficulty == 3) {
				if (buttonPegs10_5.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs10_5.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
				if (buttonPegs10_6.getBackground().getRGB() == blackRGB) pegsUsuari += "B";
				else if(buttonPegs10_6.getBackground().getRGB() == grisRGB) pegsUsuari += "W";
				else pegsUsuari += "_";
				
			}			
		}

		return !pegsUsuari.equals(Pegs.get(ronda));
	}
	
	/** @brief Funcio que actualitza el codiSecret al començat la partida com a codeMaker
     */
	public void asignaCodiCodeMaker() {
		List<Integer> codi = new ArrayList<>();

		if (resultColor1.getBackground().getRGB() == vermellRGB) codi.add(0);
		else if (resultColor1.getBackground().getRGB() == verdRGB) codi.add(1);
		else if (resultColor1.getBackground().getRGB() == blauRGB) codi.add(2);
		else if (resultColor1.getBackground().getRGB() == grocRGB) codi.add(3);
		else if (resultColor1.getBackground().getRGB() == blackRGB) codi.add(4);
		else if (resultColor1.getBackground().getRGB() == blancRGB) codi.add(5);

		if (resultColor2.getBackground().getRGB() == vermellRGB) codi.add(0);
		else if (resultColor2.getBackground().getRGB() == verdRGB) codi.add(1);
		else if (resultColor2.getBackground().getRGB() == blauRGB) codi.add(2);
		else if (resultColor2.getBackground().getRGB() == grocRGB) codi.add(3);
		else if (resultColor2.getBackground().getRGB() == blackRGB) codi.add(4);
		else if (resultColor2.getBackground().getRGB() == blancRGB) codi.add(5);

		if (resultColor3.getBackground().getRGB() == vermellRGB) codi.add(0);
		else if (resultColor3.getBackground().getRGB() == verdRGB) codi.add(1);
		else if (resultColor3.getBackground().getRGB() == blauRGB) codi.add(2);
		else if (resultColor3.getBackground().getRGB() == grocRGB) codi.add(3);
		else if (resultColor3.getBackground().getRGB() == blackRGB) codi.add(4);
		else if (resultColor3.getBackground().getRGB() == blancRGB) codi.add(5);

		if (resultColor4.getBackground().getRGB() == vermellRGB) codi.add(0);
		else if (resultColor4.getBackground().getRGB() == verdRGB) codi.add(1);
		else if (resultColor4.getBackground().getRGB() == blauRGB) codi.add(2);
		else if (resultColor4.getBackground().getRGB() == grocRGB) codi.add(3);
		else if (resultColor4.getBackground().getRGB() == blackRGB) codi.add(4);
		else if (resultColor4.getBackground().getRGB() == blancRGB) codi.add(5);
		
		if (difficulty == 2) {
			if (resultColor5.getBackground().getRGB() == vermellRGB) codi.add(0);
			else if (resultColor5.getBackground().getRGB() == verdRGB) codi.add(1);
			else if (resultColor5.getBackground().getRGB() == blauRGB) codi.add(2);
			else if (resultColor5.getBackground().getRGB() == grocRGB) codi.add(3);
			else if (resultColor5.getBackground().getRGB() == blackRGB) codi.add(4);
			else if (resultColor5.getBackground().getRGB() == blancRGB) codi.add(5);
		}
		else if (difficulty == 3) {
			if (resultColor5.getBackground().getRGB() == vermellRGB) codi.add(0);
			else if (resultColor5.getBackground().getRGB() == verdRGB) codi.add(1);
			else if (resultColor5.getBackground().getRGB() == blauRGB) codi.add(2);
			else if (resultColor5.getBackground().getRGB() == grocRGB) codi.add(3);
			else if (resultColor5.getBackground().getRGB() == blackRGB) codi.add(4);
			else if (resultColor5.getBackground().getRGB() == blancRGB) codi.add(5);

			if (resultColor6.getBackground().getRGB() == vermellRGB) codi.add(0);
			else if (resultColor6.getBackground().getRGB() == verdRGB) codi.add(1);
			else if (resultColor6.getBackground().getRGB() == blauRGB) codi.add(2);
			else if (resultColor6.getBackground().getRGB() == grocRGB) codi.add(3);
			else if (resultColor6.getBackground().getRGB() == blackRGB) codi.add(4);
			else if (resultColor6.getBackground().getRGB() == blancRGB) codi.add(5);
		}

		cPlay.asignaCodiCodeMaker(codi);
	}

	/** @brief Funcio que comprova al fer start si el codiSecret introduit és correcte
	 * 
	 * @return cert si és correcte, fals si no
     */
	public boolean wrongSelection() {
		if (difficulty == 1) {
			if (resultColor1.getBackground().getRGB() == defaultRGB1 || resultColor1.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor2.getBackground().getRGB() == defaultRGB1 || resultColor2.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor3.getBackground().getRGB() == defaultRGB1 || resultColor3.getBackground().getRGB() == defaultRGB2) return true;
			return resultColor4.getBackground().getRGB() == defaultRGB1 || resultColor4.getBackground().getRGB() == defaultRGB2;
		}
		else if (difficulty == 2) {
			if (resultColor1.getBackground().getRGB() == defaultRGB1 || resultColor1.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor2.getBackground().getRGB() == defaultRGB1 || resultColor2.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor3.getBackground().getRGB() == defaultRGB1 || resultColor3.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor4.getBackground().getRGB() == defaultRGB1 || resultColor4.getBackground().getRGB() == defaultRGB2) return true;
			return resultColor5.getBackground().getRGB() == defaultRGB1 || resultColor5.getBackground().getRGB() == defaultRGB2;
		}
		else if (difficulty == 3) {
			if (resultColor1.getBackground().getRGB() == defaultRGB1 || resultColor1.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor2.getBackground().getRGB() == defaultRGB1 || resultColor2.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor3.getBackground().getRGB() == defaultRGB1 || resultColor3.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor4.getBackground().getRGB() == defaultRGB1 || resultColor4.getBackground().getRGB() == defaultRGB2) return true;
			if (resultColor5.getBackground().getRGB() == defaultRGB1 || resultColor5.getBackground().getRGB() == defaultRGB2) return true;
			return resultColor6.getBackground().getRGB() == defaultRGB1 || resultColor6.getBackground().getRGB() == defaultRGB2;
		}

		return false;
	}
	
	/** @brief Funcio que crea els buttons de result
     */
	public void createResultColors() {
		resultColor1 = new RoundButton("");
		resultColor1.addActionListener(e -> resultColor1.setBackground(colorActual));
		resultColor1.setEnabled(false);
		resultColor1.setBackground(new Color(128, 128, 128));
		resultColor2 = new RoundButton("");
		resultColor2.addActionListener(e -> resultColor2.setBackground(colorActual));
		resultColor2.setEnabled(false);
		resultColor2.setBackground(new Color(128, 128, 128));
		resultColor3 = new RoundButton("");
		resultColor3.addActionListener(e -> resultColor3.setBackground(colorActual));
		resultColor3.setEnabled(false);
		resultColor3.setBackground(new Color(128, 128, 128));
		resultColor4 = new RoundButton("");
		resultColor4.addActionListener(e -> resultColor4.setBackground(colorActual));
		resultColor4.setEnabled(false);
		resultColor4.setBackground(new Color(128, 128, 128));

		if (difficulty.equals(1)) {
			resultColor1.setBounds(X_POSITION_4_1, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor2.setBounds(X_POSITION_4_2, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor3.setBounds(X_POSITION_4_3, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor4.setBounds(X_POSITION_4_4, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);	
		} else if (difficulty.equals(2)) {
			resultColor5 = new RoundButton("");
			resultColor5.addActionListener(e -> resultColor5.setBackground(colorActual));
			resultColor5.setEnabled(false);
			resultColor5.setBackground(new Color(128, 128, 128));

			resultColor1.setBounds(X_POSITION_5_1, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor2.setBounds(X_POSITION_5_2, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor3.setBounds(X_POSITION_5_3, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor4.setBounds(X_POSITION_5_4, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);
			resultColor5.setBounds(X_POSITION_5_5, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);	
			contentPane.add(resultColor5);
		} else if (difficulty.equals(3)) {
			resultColor5 = new RoundButton("");
			resultColor5.addActionListener(e -> resultColor5.setBackground(colorActual));
			resultColor5.setEnabled(false);
			resultColor5.setBackground(new Color(128, 128, 128));
			resultColor6 = new RoundButton("");
			resultColor6.addActionListener(e -> resultColor6.setBackground(colorActual));
			resultColor6.setEnabled(false);
			resultColor6.setBackground(new Color(128, 128, 128));

			resultColor1.setBounds(X_POSITION_6_1, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor2.setBounds(X_POSITION_6_2, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor3.setBounds(X_POSITION_6_3, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);		
			resultColor4.setBounds(X_POSITION_6_4, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);
			resultColor5.setBounds(X_POSITION_6_5, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);	
			resultColor6.setBounds(X_POSITION_6_6, Y_POSITION_RESULT, COLORS_SIZE, COLORS_SIZE);	
			contentPane.add(resultColor5);
			contentPane.add(resultColor6);
		}

		contentPane.add(resultColor1);
		contentPane.add(resultColor2);
		contentPane.add(resultColor3);
		contentPane.add(resultColor4);

		JPanel resultMenu = new JPanel();
		resultMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		resultMenu.setBackground(new Color(0, 128, 0));
		resultMenu.setBounds(9, 9, 301, 43);
		contentPane.add(resultMenu);
	}

	/** @brief Funcio que crea el menu del timer
     */
	public void createTimeMenu() {		
		JLabel textTime = new JLabel("Time: ");
		textTime.setBounds(349, 12, 214, 43);
		textTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textTime);
		
		timeHour = new JLabel("00");
		timeHour.setBounds(420, 12, 214, 43);
		timeHour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(timeHour);
		
		JlabelTime1 = new JLabel(":");
		JlabelTime1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JlabelTime1.setBounds(440, 12, 214, 43);
		contentPane.add(JlabelTime1);
		
		timeMinute = new JLabel("00");
		timeMinute.setFont(new Font("Tahoma", Font.PLAIN, 18));
		timeMinute.setBounds(446, 12, 284, 43);
		contentPane.add(timeMinute);
		
		JLabelTime2 = new JLabel(":");
		JLabelTime2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JLabelTime2.setBounds(466, 12, 214, 43);
		contentPane.add(JLabelTime2);
		
		timeSecond = new JLabel("00");
		timeSecond.setFont(new Font("Tahoma", Font.PLAIN, 18));
		timeSecond.setBounds(472, 12, 214, 43);
		contentPane.add(timeSecond);

		JPanel timeMenu = new JPanel();
		timeMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		timeMenu.setBackground(new Color(242, 222, 193));
		timeMenu.setBounds(317, 9, 214, 43);
		contentPane.add(timeMenu);
	}
	
	/** @brief Funcio que inicialitza el timer
     */
	public void initTemps() {
        String temps = cPlay.getTempsPartida();
        String aux = "" + temps.charAt(0) + temps.charAt(1);
        h = Integer.valueOf(aux);
        aux = "" + temps.charAt(3) + temps.charAt(4);
        m = Integer.valueOf(aux);
        aux = "" + temps.charAt(6) + temps.charAt(7);
        s = Integer.valueOf(aux);
        
        timeHour.setText(h<10? "0"+ h :String.valueOf(h));
        timeMinute.setText(m<10? "0"+ m :String.valueOf(m));
        timeSecond.setText(s<10? "0"+ s :String.valueOf(s));
        
        t = new Timer(1000, e -> {
			if(s<59){
				s++;
				String sec= (s<10?"0":"")+s;
				timeSecond.setText(""+sec);

			}
			else {
				s=0;
				timeSecond.setText("00");
				if(m<59){
					m++;
					String min= (m<10?"0":"")+m;
					timeMinute.setText(""+min);
				}
				else {
					m=0;
					timeMinute.setText("00");
					h++;
					String hr= (h<10?"0":"")+h;
					timeHour.setText(""+hr);
				}
			}
		});
    }

	/** @brief Funcio que crea els buttons de colors principals
     */
	public void createMainColors() {
		buttonMainColors1 = new RoundButton("");
		buttonMainColors1.addActionListener(e -> colorActual = new Color(255, 0, 0));
		buttonMainColors1.setEnabled(true);
		buttonMainColors1.setBackground(new Color(255, 0, 0));
		buttonMainColors1.setBounds(X_POSITION_6_1, Y_POSITION_COLORS, COLORS_SIZE, COLORS_SIZE);
		contentPane.add(buttonMainColors1);

		buttonMainColors2 = new RoundButton("");
		buttonMainColors2.addActionListener(e -> colorActual = new Color(0, 215, 11));
		buttonMainColors2.setEnabled(true);
		buttonMainColors2.setBackground(new Color(0, 215, 11));
		buttonMainColors2.setBounds(X_POSITION_6_2, Y_POSITION_COLORS, COLORS_SIZE, COLORS_SIZE);
		contentPane.add(buttonMainColors2);
		
		buttonMainColors3 = new RoundButton("");
		buttonMainColors3.addActionListener(e -> colorActual = new Color(0, 0, 255));
		buttonMainColors3.setEnabled(true);
		buttonMainColors3.setBackground(new Color(0, 0, 255));
		buttonMainColors3.setBounds(X_POSITION_6_3, Y_POSITION_COLORS, COLORS_SIZE, COLORS_SIZE);
		contentPane.add(buttonMainColors3);
		
		buttonMainColors4 = new RoundButton("");
		buttonMainColors4.addActionListener(e -> colorActual = new Color(255, 255, 0));
		buttonMainColors4.setEnabled(true);
		buttonMainColors4.setBackground(new Color(255, 255, 0));
		buttonMainColors4.setBounds(X_POSITION_6_4, Y_POSITION_COLORS, COLORS_SIZE, COLORS_SIZE);
		contentPane.add(buttonMainColors4);
		
		buttonMainColors5 = new RoundButton("");
		buttonMainColors5.addActionListener(e -> colorActual = new Color(255, 255, 255));
		buttonMainColors5.setEnabled(true);
		buttonMainColors5.setBackground(new Color(255, 255, 255));
		buttonMainColors5.setBounds(X_POSITION_6_5, Y_POSITION_COLORS, COLORS_SIZE, COLORS_SIZE);
		contentPane.add(buttonMainColors5);
		
		buttonMainColors6 = new RoundButton("");
		buttonMainColors6.addActionListener(e -> colorActual = new Color(0, 0, 0));
		buttonMainColors6.setEnabled(true);
		buttonMainColors6.setBackground(new Color(0, 0, 0));
		buttonMainColors6.setBounds(X_POSITION_6_6, Y_POSITION_COLORS, COLORS_SIZE, COLORS_SIZE);
		contentPane.add(buttonMainColors6);

		buttonMainHighlight = new RoundButton("");
		buttonMainHighlight.setEnabled(false);
		buttonMainHighlight.setBackground(new Color(225, 174, 0));
		buttonMainHighlight.setBounds(26, 469, 36, 36);
		buttonMainHighlight.hide();
		contentPane.add(buttonMainHighlight);
		
		JPanel mainColorsMenu = new JPanel();
		mainColorsMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mainColorsMenu.setBackground(new Color(0, 128, 0));
		mainColorsMenu.setBounds(9, 456, 301, 62);
		contentPane.add(mainColorsMenu);
	}

	/** @brief Funcio que crea els buttons de colors de cada ronda depenent de la difficulty de la partida
     */
	public void createRoundButtons() {
		buttonRound1_1 = new RoundButton("");
		buttonRound1_1.addActionListener(e -> buttonRound1_1.setBackground(colorActual));
		buttonRound1_1.setEnabled(false);
		buttonRound1_1.setBackground(new Color(0, 128, 0));
		buttonRound1_2 = new RoundButton("");
		buttonRound1_2.addActionListener(e -> buttonRound1_2.setBackground(colorActual));
		buttonRound1_2.setEnabled(false);
		buttonRound1_2.setBackground(new Color(0, 128, 0));
		buttonRound1_3 = new RoundButton("");
		buttonRound1_3.addActionListener(e -> buttonRound1_3.setBackground(colorActual));
		buttonRound1_3.setEnabled(false);
		buttonRound1_3.setBackground(new Color(0, 128, 0));
		buttonRound1_4 = new RoundButton("");
		buttonRound1_4.addActionListener(e -> buttonRound1_4.setBackground(colorActual));
		buttonRound1_4.setEnabled(false);
		buttonRound1_4.setBackground(new Color(0, 128, 0));
		buttonRound2_1 = new RoundButton("");
		buttonRound2_1.addActionListener(e -> buttonRound2_1.setBackground(colorActual));
		buttonRound2_1.setEnabled(false);
		buttonRound2_1.setBackground(new Color(0, 128, 0));
		buttonRound2_2 = new RoundButton("");
		buttonRound2_2.addActionListener(e -> buttonRound2_2.setBackground(colorActual));
		buttonRound2_2.setEnabled(false);
		buttonRound2_2.setBackground(new Color(0, 128, 0));
		buttonRound2_3 = new RoundButton("");
		buttonRound2_3.addActionListener(e -> buttonRound2_3.setBackground(colorActual));
		buttonRound2_3.setEnabled(false);
		buttonRound2_3.setBackground(new Color(0, 128, 0));
		buttonRound2_4 = new RoundButton("");
		buttonRound2_4.addActionListener(e -> buttonRound2_4.setBackground(colorActual));
		buttonRound2_4.setEnabled(false);
		buttonRound2_4.setBackground(new Color(0, 128, 0));
		buttonRound3_1 = new RoundButton("");
		buttonRound3_1.addActionListener(e -> buttonRound3_1.setBackground(colorActual));
		buttonRound3_1.setEnabled(false);
		buttonRound3_1.setBackground(new Color(0, 128, 0));
		buttonRound3_2 = new RoundButton("");
		buttonRound3_2.addActionListener(e -> buttonRound3_2.setBackground(colorActual));
		buttonRound3_2.setEnabled(false);
		buttonRound3_2.setBackground(new Color(0, 128, 0));
		buttonRound3_3 = new RoundButton("");
		buttonRound3_3.addActionListener(e -> buttonRound3_3.setBackground(colorActual));
		buttonRound3_3.setEnabled(false);
		buttonRound3_3.setBackground(new Color(0, 128, 0));
		buttonRound3_4 = new RoundButton("");
		buttonRound3_4.addActionListener(e -> buttonRound3_4.setBackground(colorActual));
		buttonRound3_4.setEnabled(false);
		buttonRound3_4.setBackground(new Color(0, 128, 0));
		buttonRound4_1 = new RoundButton("");
		buttonRound4_1.addActionListener(e -> buttonRound4_1.setBackground(colorActual));
		buttonRound4_1.setEnabled(false);
		buttonRound4_1.setBackground(new Color(0, 128, 0));
		buttonRound4_2 = new RoundButton("");
		buttonRound4_2.addActionListener(e -> buttonRound4_2.setBackground(colorActual));
		buttonRound4_2.setEnabled(false);
		buttonRound4_2.setBackground(new Color(0, 128, 0));
		buttonRound4_3 = new RoundButton("");
		buttonRound4_3.addActionListener(e -> buttonRound4_3.setBackground(colorActual));
		buttonRound4_3.setEnabled(false);
		buttonRound4_3.setBackground(new Color(0, 128, 0));
		buttonRound4_4 = new RoundButton("");
		buttonRound4_4.addActionListener(e -> buttonRound4_4.setBackground(colorActual));
		buttonRound4_4.setEnabled(false);
		buttonRound4_4.setBackground(new Color(0, 128, 0));
		buttonRound5_1 = new RoundButton("");
		buttonRound5_1.addActionListener(e -> buttonRound5_1.setBackground(colorActual));
		buttonRound5_1.setEnabled(false);
		buttonRound5_1.setBackground(new Color(0, 128, 0));
		buttonRound5_2 = new RoundButton("");
		buttonRound5_2.addActionListener(e -> buttonRound5_2.setBackground(colorActual));
		buttonRound5_2.setEnabled(false);
		buttonRound5_2.setBackground(new Color(0, 128, 0));
		buttonRound5_3 = new RoundButton("");
		buttonRound5_3.addActionListener(e -> buttonRound5_3.setBackground(colorActual));
		buttonRound5_3.setEnabled(false);
		buttonRound5_3.setBackground(new Color(0, 128, 0));
		buttonRound5_4 = new RoundButton("");
		buttonRound5_4.addActionListener(e -> buttonRound5_4.setBackground(colorActual));
		buttonRound5_4.setEnabled(false);
		buttonRound5_4.setBackground(new Color(0, 128, 0));
		buttonRound6_1 = new RoundButton("");
		buttonRound6_1.addActionListener(e -> buttonRound6_1.setBackground(colorActual));
		buttonRound6_1.setEnabled(false);
		buttonRound6_1.setBackground(new Color(0, 128, 0));
		buttonRound6_2 = new RoundButton("");
		buttonRound6_2.addActionListener(e -> buttonRound6_2.setBackground(colorActual));
		buttonRound6_2.setEnabled(false);
		buttonRound6_2.setBackground(new Color(0, 128, 0));
		buttonRound6_3 = new RoundButton("");
		buttonRound6_3.addActionListener(e -> buttonRound6_3.setBackground(colorActual));
		buttonRound6_3.setEnabled(false);
		buttonRound6_3.setBackground(new Color(0, 128, 0));
		buttonRound6_4 = new RoundButton("");
		buttonRound6_4.addActionListener(e -> buttonRound6_4.setBackground(colorActual));
		buttonRound6_4.setEnabled(false);
		buttonRound6_4.setBackground(new Color(0, 128, 0));
		buttonRound7_1 = new RoundButton("");
		buttonRound7_1.addActionListener(e -> buttonRound7_1.setBackground(colorActual));
		buttonRound7_1.setEnabled(false);
		buttonRound7_1.setBackground(new Color(0, 128, 0));
		buttonRound7_2 = new RoundButton("");
		buttonRound7_2.addActionListener(e -> buttonRound7_2.setBackground(colorActual));
		buttonRound7_2.setEnabled(false);
		buttonRound7_2.setBackground(new Color(0, 128, 0));
		buttonRound7_3 = new RoundButton("");
		buttonRound7_3.addActionListener(e -> buttonRound7_3.setBackground(colorActual));
		buttonRound7_3.setEnabled(false);
		buttonRound7_3.setBackground(new Color(0, 128, 0));
		buttonRound7_4 = new RoundButton("");
		buttonRound7_4.addActionListener(e -> buttonRound7_4.setBackground(colorActual));
		buttonRound7_4.setEnabled(false);
		buttonRound7_4.setBackground(new Color(0, 128, 0));
		buttonRound8_1 = new RoundButton("");
		buttonRound8_1.addActionListener(e -> buttonRound8_1.setBackground(colorActual));
		buttonRound8_1.setEnabled(false);
		buttonRound8_1.setBackground(new Color(0, 128, 0));
		buttonRound8_2 = new RoundButton("");
		buttonRound8_2.addActionListener(e -> buttonRound8_2.setBackground(colorActual));
		buttonRound8_2.setEnabled(false);
		buttonRound8_2.setBackground(new Color(0, 128, 0));
		buttonRound8_3 = new RoundButton("");
		buttonRound8_3.addActionListener(e -> buttonRound8_3.setBackground(colorActual));
		buttonRound8_3.setEnabled(false);
		buttonRound8_3.setBackground(new Color(0, 128, 0));
		buttonRound8_4 = new RoundButton("");
		buttonRound8_4.addActionListener(e -> buttonRound8_4.setBackground(colorActual));
		buttonRound8_4.setEnabled(false);
		buttonRound8_4.setBackground(new Color(0, 128, 0));
		buttonRound9_1 = new RoundButton("");
		buttonRound9_1.addActionListener(e -> buttonRound9_1.setBackground(colorActual));
		buttonRound9_1.setEnabled(false);
		buttonRound9_1.setBackground(new Color(0, 128, 0));
		buttonRound9_2 = new RoundButton("");
		buttonRound9_2.addActionListener(e -> buttonRound9_2.setBackground(colorActual));
		buttonRound9_2.setEnabled(false);
		buttonRound9_2.setBackground(new Color(0, 128, 0));
		buttonRound9_3 = new RoundButton("");
		buttonRound9_3.addActionListener(e -> buttonRound9_3.setBackground(colorActual));
		buttonRound9_3.setEnabled(false);
		buttonRound9_3.setBackground(new Color(0, 128, 0));
		buttonRound9_4 = new RoundButton("");
		buttonRound9_4.addActionListener(e -> buttonRound9_4.setBackground(colorActual));
		buttonRound9_4.setEnabled(false);
		buttonRound9_4.setBackground(new Color(0, 128, 0));
		buttonRound10_1 = new RoundButton("");
		buttonRound10_1.addActionListener(e -> buttonRound10_1.setBackground(colorActual));
		buttonRound10_1.setEnabled(false);
		buttonRound10_1.setBackground(new Color(0, 128, 0));
		buttonRound10_2 = new RoundButton("");
		buttonRound10_2.addActionListener(e -> buttonRound10_2.setBackground(colorActual));
		buttonRound10_2.setEnabled(false);
		buttonRound10_2.setBackground(new Color(0, 128, 0));
		buttonRound10_3 = new RoundButton("");
		buttonRound10_3.addActionListener(e -> buttonRound10_3.setBackground(colorActual));
		buttonRound10_3.setEnabled(false);
		buttonRound10_3.setBackground(new Color(0, 128, 0));
		buttonRound10_4 = new RoundButton("");
		buttonRound10_4.addActionListener(e -> buttonRound10_4.setBackground(colorActual));
		buttonRound10_4.setEnabled(false);
		buttonRound10_4.setBackground(new Color(0, 128, 0));
		

		if (difficulty.equals(1)) {
			buttonRound1_1.setBounds(X_POSITION_4_1, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_2.setBounds(X_POSITION_4_2, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_3.setBounds(X_POSITION_4_3, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_4.setBounds(X_POSITION_4_4, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);

			buttonRound2_1.setBounds(X_POSITION_4_1, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_2.setBounds(X_POSITION_4_2, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_3.setBounds(X_POSITION_4_3, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_4.setBounds(X_POSITION_4_4, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);

			buttonRound3_1.setBounds(X_POSITION_4_1, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_2.setBounds(X_POSITION_4_2, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_3.setBounds(X_POSITION_4_3, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_4.setBounds(X_POSITION_4_4, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);

			buttonRound4_1.setBounds(X_POSITION_4_1, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_2.setBounds(X_POSITION_4_2, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_3.setBounds(X_POSITION_4_3, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_4.setBounds(X_POSITION_4_4, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);

			buttonRound5_1.setBounds(X_POSITION_4_1, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_2.setBounds(X_POSITION_4_2, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_3.setBounds(X_POSITION_4_3, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_4.setBounds(X_POSITION_4_4, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);

			buttonRound6_1.setBounds(X_POSITION_4_1, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_2.setBounds(X_POSITION_4_2, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_3.setBounds(X_POSITION_4_3, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_4.setBounds(X_POSITION_4_4, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);

			buttonRound7_1.setBounds(X_POSITION_4_1, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_2.setBounds(X_POSITION_4_2, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_3.setBounds(X_POSITION_4_3, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_4.setBounds(X_POSITION_4_4, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);

			buttonRound8_1.setBounds(X_POSITION_4_1, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_2.setBounds(X_POSITION_4_2, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_3.setBounds(X_POSITION_4_3, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_4.setBounds(X_POSITION_4_4, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);

			buttonRound9_1.setBounds(X_POSITION_4_1, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_2.setBounds(X_POSITION_4_2, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_3.setBounds(X_POSITION_4_3, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_4.setBounds(X_POSITION_4_4, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);

			buttonRound10_1.setBounds(X_POSITION_4_1, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_2.setBounds(X_POSITION_4_2, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_3.setBounds(X_POSITION_4_3, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_4.setBounds(X_POSITION_4_4, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
		} else if (difficulty.equals(2)) {
			buttonRound1_5 = new RoundButton("");
			buttonRound1_5.addActionListener(e -> buttonRound1_5.setBackground(colorActual));
			buttonRound1_5.setEnabled(false);
			buttonRound1_5.setBackground(new Color(0, 128, 0));
			buttonRound2_5 = new RoundButton("");
			buttonRound2_5.addActionListener(e -> buttonRound2_5.setBackground(colorActual));
			buttonRound2_5.setEnabled(false);
			buttonRound2_5.setBackground(new Color(0, 128, 0));
			buttonRound3_5 = new RoundButton("");
			buttonRound3_5.addActionListener(e -> buttonRound3_5.setBackground(colorActual));
			buttonRound3_5.setEnabled(false);
			buttonRound3_5.setBackground(new Color(0, 128, 0));
			buttonRound4_5 = new RoundButton("");
			buttonRound4_5.addActionListener(e -> buttonRound4_5.setBackground(colorActual));
			buttonRound4_5.setEnabled(false);
			buttonRound4_5.setBackground(new Color(0, 128, 0));
			buttonRound5_5 = new RoundButton("");
			buttonRound5_5.addActionListener(e -> buttonRound5_5.setBackground(colorActual));
			buttonRound5_5.setEnabled(false);
			buttonRound5_5.setBackground(new Color(0, 128, 0));
			buttonRound6_5 = new RoundButton("");
			buttonRound6_5.addActionListener(e -> buttonRound6_5.setBackground(colorActual));
			buttonRound6_5.setEnabled(false);
			buttonRound6_5.setBackground(new Color(0, 128, 0));
			buttonRound7_5 = new RoundButton("");
			buttonRound7_5.addActionListener(e -> buttonRound7_5.setBackground(colorActual));
			buttonRound7_5.setEnabled(false);
			buttonRound7_5.setBackground(new Color(0, 128, 0));
			buttonRound8_5 = new RoundButton("");
			buttonRound8_5.addActionListener(e -> buttonRound8_5.setBackground(colorActual));
			buttonRound8_5.setEnabled(false);
			buttonRound8_5.setBackground(new Color(0, 128, 0));
			buttonRound9_5 = new RoundButton("");
			buttonRound9_5.addActionListener(e -> buttonRound9_5.setBackground(colorActual));
			buttonRound9_5.setEnabled(false);
			buttonRound9_5.setBackground(new Color(0, 128, 0));
			buttonRound10_5 = new RoundButton("");
			buttonRound10_5.addActionListener(e -> buttonRound10_5.setBackground(colorActual));
			buttonRound10_5.setEnabled(false);
			buttonRound10_5.setBackground(new Color(0, 128, 0));

			buttonRound1_1.setBounds(X_POSITION_5_1, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_2.setBounds(X_POSITION_5_2, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_3.setBounds(X_POSITION_5_3, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_4.setBounds(X_POSITION_5_4, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_5.setBounds(X_POSITION_5_5, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_1.setBounds(X_POSITION_5_1, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_2.setBounds(X_POSITION_5_2, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_3.setBounds(X_POSITION_5_3, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_4.setBounds(X_POSITION_5_4, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_5.setBounds(X_POSITION_5_5, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_1.setBounds(X_POSITION_5_1, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_2.setBounds(X_POSITION_5_2, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_3.setBounds(X_POSITION_5_3, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_4.setBounds(X_POSITION_5_4, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_5.setBounds(X_POSITION_5_5, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_1.setBounds(X_POSITION_5_1, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_2.setBounds(X_POSITION_5_2, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_3.setBounds(X_POSITION_5_3, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_4.setBounds(X_POSITION_5_4, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_5.setBounds(X_POSITION_5_5, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_1.setBounds(X_POSITION_5_1, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_2.setBounds(X_POSITION_5_2, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_3.setBounds(X_POSITION_5_3, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_4.setBounds(X_POSITION_5_4, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_5.setBounds(X_POSITION_5_5, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_1.setBounds(X_POSITION_5_1, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_2.setBounds(X_POSITION_5_2, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_3.setBounds(X_POSITION_5_3, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_4.setBounds(X_POSITION_5_4, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_5.setBounds(X_POSITION_5_5, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_1.setBounds(X_POSITION_5_1, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_2.setBounds(X_POSITION_5_2, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_3.setBounds(X_POSITION_5_3, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_4.setBounds(X_POSITION_5_4, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_5.setBounds(X_POSITION_5_5, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_1.setBounds(X_POSITION_5_1, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_2.setBounds(X_POSITION_5_2, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_3.setBounds(X_POSITION_5_3, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_4.setBounds(X_POSITION_5_4, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_5.setBounds(X_POSITION_5_5, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_1.setBounds(X_POSITION_5_1, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_2.setBounds(X_POSITION_5_2, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_3.setBounds(X_POSITION_5_3, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_4.setBounds(X_POSITION_5_4, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_5.setBounds(X_POSITION_5_5, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_1.setBounds(X_POSITION_5_1, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_2.setBounds(X_POSITION_5_2, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_3.setBounds(X_POSITION_5_3, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_4.setBounds(X_POSITION_5_4, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_5.setBounds(X_POSITION_5_5, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);

			contentPane.add(buttonRound1_5);
			contentPane.add(buttonRound2_5);
			contentPane.add(buttonRound3_5);
			contentPane.add(buttonRound4_5);
			contentPane.add(buttonRound5_5);
			contentPane.add(buttonRound6_5);
			contentPane.add(buttonRound7_5);
			contentPane.add(buttonRound8_5);
			contentPane.add(buttonRound9_5);
			contentPane.add(buttonRound10_5);

		} else if (difficulty.equals(3)) {
			buttonRound1_5 = new RoundButton("");
			buttonRound1_5.addActionListener(e -> buttonRound1_5.setBackground(colorActual));
			buttonRound1_5.setEnabled(false);
			buttonRound1_5.setBackground(new Color(0, 128, 0));
			buttonRound2_5 = new RoundButton("");
			buttonRound2_5.addActionListener(e -> buttonRound2_5.setBackground(colorActual));
			buttonRound2_5.setEnabled(false);
			buttonRound2_5.setBackground(new Color(0, 128, 0));
			buttonRound3_5 = new RoundButton("");
			buttonRound3_5.addActionListener(e -> buttonRound3_5.setBackground(colorActual));
			buttonRound3_5.setEnabled(false);
			buttonRound3_5.setBackground(new Color(0, 128, 0));
			buttonRound4_5 = new RoundButton("");
			buttonRound4_5.addActionListener(e -> buttonRound4_5.setBackground(colorActual));
			buttonRound4_5.setEnabled(false);
			buttonRound4_5.setBackground(new Color(0, 128, 0));
			buttonRound5_5 = new RoundButton("");
			buttonRound5_5.addActionListener(e -> buttonRound5_5.setBackground(colorActual));
			buttonRound5_5.setEnabled(false);
			buttonRound5_5.setBackground(new Color(0, 128, 0));
			buttonRound6_5 = new RoundButton("");
			buttonRound6_5.addActionListener(e -> buttonRound6_5.setBackground(colorActual));
			buttonRound6_5.setEnabled(false);
			buttonRound6_5.setBackground(new Color(0, 128, 0));
			buttonRound7_5 = new RoundButton("");
			buttonRound7_5.addActionListener(e -> buttonRound7_5.setBackground(colorActual));
			buttonRound7_5.setEnabled(false);
			buttonRound7_5.setBackground(new Color(0, 128, 0));
			buttonRound8_5 = new RoundButton("");
			buttonRound8_5.addActionListener(e -> buttonRound8_5.setBackground(colorActual));
			buttonRound8_5.setEnabled(false);
			buttonRound8_5.setBackground(new Color(0, 128, 0));
			buttonRound9_5 = new RoundButton("");
			buttonRound9_5.addActionListener(e -> buttonRound9_5.setBackground(colorActual));
			buttonRound9_5.setEnabled(false);
			buttonRound9_5.setBackground(new Color(0, 128, 0));
			buttonRound10_5 = new RoundButton("");
			buttonRound10_5.addActionListener(e -> buttonRound10_5.setBackground(colorActual));
			buttonRound10_5.setEnabled(false);
			buttonRound10_5.setBackground(new Color(0, 128, 0));

			buttonRound1_6 = new RoundButton("");
			buttonRound1_6.addActionListener(e -> buttonRound1_6.setBackground(colorActual));
			buttonRound1_6.setEnabled(false);
			buttonRound1_6.setBackground(new Color(0, 128, 0));
			buttonRound2_6 = new RoundButton("");
			buttonRound2_6.addActionListener(e -> buttonRound2_6.setBackground(colorActual));
			buttonRound2_6.setEnabled(false);
			buttonRound2_6.setBackground(new Color(0, 128, 0));
			buttonRound3_6 = new RoundButton("");
			buttonRound3_6.addActionListener(e -> buttonRound3_6.setBackground(colorActual));
			buttonRound3_6.setEnabled(false);
			buttonRound3_6.setBackground(new Color(0, 128, 0));
			buttonRound4_6 = new RoundButton("");
			buttonRound4_6.addActionListener(e -> buttonRound4_6.setBackground(colorActual));
			buttonRound4_6.setEnabled(false);
			buttonRound4_6.setBackground(new Color(0, 128, 0));
			buttonRound5_6 = new RoundButton("");
			buttonRound5_6.addActionListener(e -> buttonRound5_6.setBackground(colorActual));
			buttonRound5_6.setEnabled(false);
			buttonRound5_6.setBackground(new Color(0, 128, 0));
			buttonRound6_6 = new RoundButton("");
			buttonRound6_6.addActionListener(e -> buttonRound6_6.setBackground(colorActual));
			buttonRound6_6.setEnabled(false);
			buttonRound6_6.setBackground(new Color(0, 128, 0));
			buttonRound7_6 = new RoundButton("");
			buttonRound7_6.addActionListener(e -> buttonRound7_6.setBackground(colorActual));
			buttonRound7_6.setEnabled(false);
			buttonRound7_6.setBackground(new Color(0, 128, 0));
			buttonRound8_6 = new RoundButton("");
			buttonRound8_6.addActionListener(e -> buttonRound8_6.setBackground(colorActual));
			buttonRound8_6.setEnabled(false);
			buttonRound8_6.setBackground(new Color(0, 128, 0));
			buttonRound9_6 = new RoundButton("");
			buttonRound9_6.addActionListener(e -> buttonRound9_6.setBackground(colorActual));
			buttonRound9_6.setEnabled(false);
			buttonRound9_6.setBackground(new Color(0, 128, 0));
			buttonRound10_6 = new RoundButton("");
			buttonRound10_6.addActionListener(e -> buttonRound10_6.setBackground(colorActual));
			buttonRound10_6.setEnabled(false);
			buttonRound10_6.setBackground(new Color(0, 128, 0));

			buttonRound1_1.setBounds(X_POSITION_6_1, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_2.setBounds(X_POSITION_6_2, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_3.setBounds(X_POSITION_6_3, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_4.setBounds(X_POSITION_6_4, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_5.setBounds(X_POSITION_6_5, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);
			buttonRound1_6.setBounds(X_POSITION_6_6, Y_POSITION_1, COLORS_SIZE, COLORS_SIZE);

			buttonRound2_1.setBounds(X_POSITION_6_1, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_2.setBounds(X_POSITION_6_2, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_3.setBounds(X_POSITION_6_3, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_4.setBounds(X_POSITION_6_4, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_5.setBounds(X_POSITION_6_5, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);
			buttonRound2_6.setBounds(X_POSITION_6_6, Y_POSITION_2, COLORS_SIZE, COLORS_SIZE);

			buttonRound3_1.setBounds(X_POSITION_6_1, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_2.setBounds(X_POSITION_6_2, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_3.setBounds(X_POSITION_6_3, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_4.setBounds(X_POSITION_6_4, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_5.setBounds(X_POSITION_6_5, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);
			buttonRound3_6.setBounds(X_POSITION_6_6, Y_POSITION_3, COLORS_SIZE, COLORS_SIZE);

			buttonRound4_1.setBounds(X_POSITION_6_1, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_2.setBounds(X_POSITION_6_2, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_3.setBounds(X_POSITION_6_3, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_4.setBounds(X_POSITION_6_4, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_5.setBounds(X_POSITION_6_5, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);
			buttonRound4_6.setBounds(X_POSITION_6_6, Y_POSITION_4, COLORS_SIZE, COLORS_SIZE);

			buttonRound5_1.setBounds(X_POSITION_6_1, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_2.setBounds(X_POSITION_6_2, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_3.setBounds(X_POSITION_6_3, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_4.setBounds(X_POSITION_6_4, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_5.setBounds(X_POSITION_6_5, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);
			buttonRound5_6.setBounds(X_POSITION_6_6, Y_POSITION_5, COLORS_SIZE, COLORS_SIZE);

			buttonRound6_1.setBounds(X_POSITION_6_1, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_2.setBounds(X_POSITION_6_2, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_3.setBounds(X_POSITION_6_3, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_4.setBounds(X_POSITION_6_4, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_5.setBounds(X_POSITION_6_5, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);
			buttonRound6_6.setBounds(X_POSITION_6_6, Y_POSITION_6, COLORS_SIZE, COLORS_SIZE);

			buttonRound7_1.setBounds(X_POSITION_6_1, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_2.setBounds(X_POSITION_6_2, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_3.setBounds(X_POSITION_6_3, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_4.setBounds(X_POSITION_6_4, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_5.setBounds(X_POSITION_6_5, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);
			buttonRound7_6.setBounds(X_POSITION_6_6, Y_POSITION_7, COLORS_SIZE, COLORS_SIZE);

			buttonRound8_1.setBounds(X_POSITION_6_1, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_2.setBounds(X_POSITION_6_2, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_3.setBounds(X_POSITION_6_3, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_4.setBounds(X_POSITION_6_4, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_5.setBounds(X_POSITION_6_5, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);
			buttonRound8_6.setBounds(X_POSITION_6_6, Y_POSITION_8, COLORS_SIZE, COLORS_SIZE);

			buttonRound9_1.setBounds(X_POSITION_6_1, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_2.setBounds(X_POSITION_6_2, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_3.setBounds(X_POSITION_6_3, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_4.setBounds(X_POSITION_6_4, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_5.setBounds(X_POSITION_6_5, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);
			buttonRound9_6.setBounds(X_POSITION_6_6, Y_POSITION_9, COLORS_SIZE, COLORS_SIZE);

			buttonRound10_1.setBounds(X_POSITION_6_1, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_2.setBounds(X_POSITION_6_2, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_3.setBounds(X_POSITION_6_3, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_4.setBounds(X_POSITION_6_4, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_5.setBounds(X_POSITION_6_5, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);
			buttonRound10_6.setBounds(X_POSITION_6_6, Y_POSITION_10, COLORS_SIZE, COLORS_SIZE);

			contentPane.add(buttonRound1_5);
			contentPane.add(buttonRound2_5);
			contentPane.add(buttonRound3_5);
			contentPane.add(buttonRound4_5);
			contentPane.add(buttonRound5_5);
			contentPane.add(buttonRound6_5);
			contentPane.add(buttonRound7_5);
			contentPane.add(buttonRound8_5);
			contentPane.add(buttonRound9_5);
			contentPane.add(buttonRound10_5);

			contentPane.add(buttonRound1_6);
			contentPane.add(buttonRound2_6);
			contentPane.add(buttonRound3_6);
			contentPane.add(buttonRound4_6);
			contentPane.add(buttonRound5_6);
			contentPane.add(buttonRound6_6);
			contentPane.add(buttonRound7_6);
			contentPane.add(buttonRound8_6);
			contentPane.add(buttonRound9_6);
			contentPane.add(buttonRound10_6);

		}

		contentPane.add(buttonRound1_1);
		contentPane.add(buttonRound1_2);
		contentPane.add(buttonRound1_3);
		contentPane.add(buttonRound1_4);

		contentPane.add(buttonRound2_1);
		contentPane.add(buttonRound2_2);
		contentPane.add(buttonRound2_3);
		contentPane.add(buttonRound2_4);

		contentPane.add(buttonRound3_1);
		contentPane.add(buttonRound3_2);
		contentPane.add(buttonRound3_3);
		contentPane.add(buttonRound3_4);

		contentPane.add(buttonRound4_1);
		contentPane.add(buttonRound4_2);
		contentPane.add(buttonRound4_3);
		contentPane.add(buttonRound4_4);

		contentPane.add(buttonRound5_1);
		contentPane.add(buttonRound5_2);
		contentPane.add(buttonRound5_3);
		contentPane.add(buttonRound5_4);

		contentPane.add(buttonRound6_1);
		contentPane.add(buttonRound6_2);
		contentPane.add(buttonRound6_3);
		contentPane.add(buttonRound6_4);

		contentPane.add(buttonRound7_1);
		contentPane.add(buttonRound7_2);
		contentPane.add(buttonRound7_3);
		contentPane.add(buttonRound7_4);

		contentPane.add(buttonRound8_1);
		contentPane.add(buttonRound8_2);
		contentPane.add(buttonRound8_3);
		contentPane.add(buttonRound8_4);

		contentPane.add(buttonRound9_1);
		contentPane.add(buttonRound9_2);
		contentPane.add(buttonRound9_3);
		contentPane.add(buttonRound9_4);

		contentPane.add(buttonRound10_1);
		contentPane.add(buttonRound10_2);
		contentPane.add(buttonRound10_3);
		contentPane.add(buttonRound10_4);


		JPanel gameMenu = new JPanel();
		gameMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		gameMenu.setBackground(new Color(0, 128, 0));
		gameMenu.setBounds(9, 63, 301, 385);
		contentPane.add(gameMenu);
		SpringLayout sl_gameMenu = new SpringLayout();
		gameMenu.setLayout(sl_gameMenu);
	}

	/** @brief Funcio que crea els buttons de pegs de cada ronda depenent de la difficulty de la partida
     */
	public void createPegsButtons() {
		buttonPegs1_1 = new RoundButton("");
		buttonPegs1_1.addActionListener(e -> {
			if (buttonPegs1_1.getBackground().getRGB() == -860479) buttonPegs1_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs1_1.getBackground().getRGB() == -16777216) buttonPegs1_1.setBackground(new Color(128, 128, 128));
			else buttonPegs1_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs1_1.setEnabled(false);
		buttonPegs1_1.setBackground(new Color(242, 222, 193));
		buttonPegs1_2 = new RoundButton("");
		buttonPegs1_2.addActionListener(e -> {
			if (buttonPegs1_2.getBackground().getRGB() == -860479) buttonPegs1_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs1_2.getBackground().getRGB() == -16777216) buttonPegs1_2.setBackground(new Color(128, 128, 128));
			else buttonPegs1_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs1_2.setEnabled(false);
		buttonPegs1_2.setBackground(new Color(242, 222, 193));	
		buttonPegs1_3 = new RoundButton("");
		buttonPegs1_3.addActionListener(e -> {
			if (buttonPegs1_3.getBackground().getRGB() == -860479) buttonPegs1_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs1_3.getBackground().getRGB() == -16777216) buttonPegs1_3.setBackground(new Color(128, 128, 128));
			else buttonPegs1_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs1_3.setEnabled(false);
		buttonPegs1_3.setBackground(new Color(242, 222, 193));		
		buttonPegs1_4 = new RoundButton("");
		buttonPegs1_4.addActionListener(e -> {
			if (buttonPegs1_4.getBackground().getRGB() == -860479) buttonPegs1_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs1_4.getBackground().getRGB() == -16777216) buttonPegs1_4.setBackground(new Color(128, 128, 128));
			else buttonPegs1_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs1_4.setEnabled(false);
		buttonPegs1_4.setBackground(new Color(242, 222, 193));
		buttonPegs2_1 = new RoundButton("");
		buttonPegs2_1.addActionListener(e -> {
			if (buttonPegs2_1.getBackground().getRGB() == -860479) buttonPegs2_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs2_1.getBackground().getRGB() == -16777216) buttonPegs2_1.setBackground(new Color(128, 128, 128));
			else buttonPegs2_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs2_1.setEnabled(false);
		buttonPegs2_1.setBackground(new Color(242, 222, 193));	
		buttonPegs2_2 = new RoundButton("");
		buttonPegs2_2.addActionListener(e -> {
			if (buttonPegs2_2.getBackground().getRGB() == -860479) buttonPegs2_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs2_2.getBackground().getRGB() == -16777216) buttonPegs2_2.setBackground(new Color(128, 128, 128));
			else buttonPegs2_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs2_2.setEnabled(false);
		buttonPegs2_2.setBackground(new Color(242, 222, 193));
		buttonPegs2_3 = new RoundButton("");
		buttonPegs2_3.addActionListener(e -> {
			if (buttonPegs2_3.getBackground().getRGB() == -860479) buttonPegs2_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs2_3.getBackground().getRGB() == -16777216) buttonPegs2_3.setBackground(new Color(128, 128, 128));
			else buttonPegs2_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs2_3.setEnabled(false);
		buttonPegs2_3.setBackground(new Color(242, 222, 193));
		buttonPegs2_4 = new RoundButton("");
		buttonPegs2_4.addActionListener(e -> {
			if (buttonPegs2_4.getBackground().getRGB() == -860479) buttonPegs2_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs2_4.getBackground().getRGB() == -16777216) buttonPegs2_4.setBackground(new Color(128, 128, 128));
			else buttonPegs2_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs2_4.setEnabled(false);
		buttonPegs2_4.setBackground(new Color(242, 222, 193));
		buttonPegs3_1 = new RoundButton("");
		buttonPegs3_1.addActionListener(e -> {
			if (buttonPegs3_1.getBackground().getRGB() == -860479) buttonPegs3_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs3_1.getBackground().getRGB() == -16777216) buttonPegs3_1.setBackground(new Color(128, 128, 128));
			else buttonPegs3_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs3_1.setEnabled(false);
		buttonPegs3_1.setBackground(new Color(242, 222, 193));	
		buttonPegs3_2 = new RoundButton("");
		buttonPegs3_2.addActionListener(e -> {
			if (buttonPegs3_2.getBackground().getRGB() == -860479) buttonPegs3_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs3_2.getBackground().getRGB() == -16777216) buttonPegs3_2.setBackground(new Color(128, 128, 128));
			else buttonPegs3_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs3_2.setEnabled(false);
		buttonPegs3_2.setBackground(new Color(242, 222, 193));
		buttonPegs3_3 = new RoundButton("");
		buttonPegs3_3.addActionListener(e -> {
			if (buttonPegs3_3.getBackground().getRGB() == -860479) buttonPegs3_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs3_3.getBackground().getRGB() == -16777216) buttonPegs3_3.setBackground(new Color(128, 128, 128));
			else buttonPegs3_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs3_3.setEnabled(false);
		buttonPegs3_3.setBackground(new Color(242, 222, 193));
		buttonPegs3_4 = new RoundButton("");
		buttonPegs3_4.addActionListener(e -> {
			if (buttonPegs3_4.getBackground().getRGB() == -860479) buttonPegs3_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs3_4.getBackground().getRGB() == -16777216) buttonPegs3_4.setBackground(new Color(128, 128, 128));
			else buttonPegs3_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs3_4.setEnabled(false);
		buttonPegs3_4.setBackground(new Color(242, 222, 193));
		buttonPegs4_1 = new RoundButton("");
		buttonPegs4_1.addActionListener(e -> {
			if (buttonPegs4_1.getBackground().getRGB() == -860479) buttonPegs4_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs4_1.getBackground().getRGB() == -16777216) buttonPegs4_1.setBackground(new Color(128, 128, 128));
			else buttonPegs4_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs4_1.setEnabled(false);
		buttonPegs4_1.setBackground(new Color(242, 222, 193));	
		buttonPegs4_2 = new RoundButton("");
		buttonPegs4_2.addActionListener(e -> {
			if (buttonPegs4_2.getBackground().getRGB() == -860479) buttonPegs4_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs4_2.getBackground().getRGB() == -16777216) buttonPegs4_2.setBackground(new Color(128, 128, 128));
			else buttonPegs4_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs4_2.setEnabled(false);
		buttonPegs4_2.setBackground(new Color(242, 222, 193));
		buttonPegs4_3 = new RoundButton("");
		buttonPegs4_3.addActionListener(e -> {
			if (buttonPegs4_3.getBackground().getRGB() == -860479) buttonPegs4_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs4_3.getBackground().getRGB() == -16777216) buttonPegs4_3.setBackground(new Color(128, 128, 128));
			else buttonPegs4_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs4_3.setEnabled(false);
		buttonPegs4_3.setBackground(new Color(242, 222, 193));
		buttonPegs4_4 = new RoundButton("");
		buttonPegs4_4.addActionListener(e -> {
			if (buttonPegs4_4.getBackground().getRGB() == -860479) buttonPegs4_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs4_4.getBackground().getRGB() == -16777216) buttonPegs4_4.setBackground(new Color(128, 128, 128));
			else buttonPegs4_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs4_4.setEnabled(false);
		buttonPegs4_4.setBackground(new Color(242, 222, 193));	
		buttonPegs5_1 = new RoundButton("");
		buttonPegs5_1.addActionListener(e -> {
			if (buttonPegs5_1.getBackground().getRGB() == -860479) buttonPegs5_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs5_1.getBackground().getRGB() == -16777216) buttonPegs5_1.setBackground(new Color(128, 128, 128));
			else buttonPegs5_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs5_1.setEnabled(false);
		buttonPegs5_1.setBackground(new Color(242, 222, 193));	
		buttonPegs5_2 = new RoundButton("");
		buttonPegs5_2.addActionListener(e -> {
			if (buttonPegs5_2.getBackground().getRGB() == -860479) buttonPegs5_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs5_2.getBackground().getRGB() == -16777216) buttonPegs5_2.setBackground(new Color(128, 128, 128));
			else buttonPegs5_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs5_2.setEnabled(false);
		buttonPegs5_2.setBackground(new Color(242, 222, 193));
		buttonPegs5_3 = new RoundButton("");
		buttonPegs5_3.addActionListener(e -> {
			if (buttonPegs5_3.getBackground().getRGB() == -860479) buttonPegs5_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs5_3.getBackground().getRGB() == -16777216) buttonPegs5_3.setBackground(new Color(128, 128, 128));
			else buttonPegs5_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs5_3.setEnabled(false);
		buttonPegs5_3.setBackground(new Color(242, 222, 193));
		buttonPegs5_4 = new RoundButton("");
		buttonPegs5_4.addActionListener(e -> {
			if (buttonPegs5_4.getBackground().getRGB() == -860479) buttonPegs5_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs5_4.getBackground().getRGB() == -16777216) buttonPegs5_4.setBackground(new Color(128, 128, 128));
			else buttonPegs5_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs5_4.setEnabled(false);
		buttonPegs5_4.setBackground(new Color(242, 222, 193));
		buttonPegs6_1 = new RoundButton("");
		buttonPegs6_1.addActionListener(e -> {
			if (buttonPegs6_1.getBackground().getRGB() == -860479) buttonPegs6_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs6_1.getBackground().getRGB() == -16777216) buttonPegs6_1.setBackground(new Color(128, 128, 128));
			else buttonPegs6_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs6_1.setEnabled(false);
		buttonPegs6_1.setBackground(new Color(242, 222, 193));	
		buttonPegs6_2 = new RoundButton("");
		buttonPegs6_2.addActionListener(e -> {
			if (buttonPegs6_2.getBackground().getRGB() == -860479) buttonPegs6_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs6_2.getBackground().getRGB() == -16777216) buttonPegs6_2.setBackground(new Color(128, 128, 128));
			else buttonPegs6_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs6_2.setEnabled(false);
		buttonPegs6_2.setBackground(new Color(242, 222, 193));
		buttonPegs6_3 = new RoundButton("");
		buttonPegs6_3.addActionListener(e -> {
			if (buttonPegs6_3.getBackground().getRGB() == -860479) buttonPegs6_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs6_3.getBackground().getRGB() == -16777216) buttonPegs6_3.setBackground(new Color(128, 128, 128));
			else buttonPegs6_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs6_3.setEnabled(false);
		buttonPegs6_3.setBackground(new Color(242, 222, 193));
		buttonPegs6_4 = new RoundButton("");
		buttonPegs6_4.addActionListener(e -> {
			if (buttonPegs6_4.getBackground().getRGB() == -860479) buttonPegs6_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs6_4.getBackground().getRGB() == -16777216) buttonPegs6_4.setBackground(new Color(128, 128, 128));
			else buttonPegs6_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs6_4.setEnabled(false);
		buttonPegs6_4.setBackground(new Color(242, 222, 193));
		buttonPegs7_1 = new RoundButton("");
		buttonPegs7_1.addActionListener(e -> {
			if (buttonPegs7_1.getBackground().getRGB() == -860479) buttonPegs7_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs7_1.getBackground().getRGB() == -16777216) buttonPegs7_1.setBackground(new Color(128, 128, 128));
			else buttonPegs7_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs7_1.setEnabled(false);
		buttonPegs7_1.setBackground(new Color(242, 222, 193));	
		buttonPegs7_2 = new RoundButton("");
		buttonPegs7_2.addActionListener(e -> {
			if (buttonPegs7_2.getBackground().getRGB() == -860479) buttonPegs7_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs7_2.getBackground().getRGB() == -16777216) buttonPegs7_2.setBackground(new Color(128, 128, 128));
			else buttonPegs7_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs7_2.setEnabled(false);
		buttonPegs7_2.setBackground(new Color(242, 222, 193));
		buttonPegs7_3 = new RoundButton("");
		buttonPegs7_3.addActionListener(e -> {
			if (buttonPegs7_3.getBackground().getRGB() == -860479) buttonPegs7_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs7_3.getBackground().getRGB() == -16777216) buttonPegs7_3.setBackground(new Color(128, 128, 128));
			else buttonPegs7_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs7_3.setEnabled(false);
		buttonPegs7_3.setBackground(new Color(242, 222, 193));
		buttonPegs7_4 = new RoundButton("");
		buttonPegs7_4.addActionListener(e -> {
			if (buttonPegs7_4.getBackground().getRGB() == -860479) buttonPegs7_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs7_4.getBackground().getRGB() == -16777216) buttonPegs7_4.setBackground(new Color(128, 128, 128));
			else buttonPegs7_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs7_4.setEnabled(false);
		buttonPegs7_4.setBackground(new Color(242, 222, 193));
		buttonPegs8_1 = new RoundButton("");
		buttonPegs8_1.addActionListener(e -> {
			if (buttonPegs8_1.getBackground().getRGB() == -860479) buttonPegs8_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs8_1.getBackground().getRGB() == -16777216) buttonPegs8_1.setBackground(new Color(128, 128, 128));
			else buttonPegs8_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs8_1.setEnabled(false);
		buttonPegs8_1.setBackground(new Color(242, 222, 193));	
		buttonPegs8_2 = new RoundButton("");
		buttonPegs8_2.addActionListener(e -> {
			if (buttonPegs8_2.getBackground().getRGB() == -860479) buttonPegs8_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs8_2.getBackground().getRGB() == -16777216) buttonPegs8_2.setBackground(new Color(128, 128, 128));
			else buttonPegs8_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs8_2.setEnabled(false);
		buttonPegs8_2.setBackground(new Color(242, 222, 193));
		buttonPegs8_3 = new RoundButton("");
		buttonPegs8_3.addActionListener(e -> {
			if (buttonPegs8_3.getBackground().getRGB() == -860479) buttonPegs8_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs8_3.getBackground().getRGB() == -16777216) buttonPegs8_3.setBackground(new Color(128, 128, 128));
			else buttonPegs8_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs8_3.setEnabled(false);
		buttonPegs8_3.setBackground(new Color(242, 222, 193));
		buttonPegs8_4 = new RoundButton("");
		buttonPegs8_4.addActionListener(e -> {
			if (buttonPegs8_4.getBackground().getRGB() == -860479) buttonPegs8_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs8_4.getBackground().getRGB() == -16777216) buttonPegs8_4.setBackground(new Color(128, 128, 128));
			else buttonPegs8_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs8_4.setEnabled(false);
		buttonPegs8_4.setBackground(new Color(242, 222, 193));
		buttonPegs9_1 = new RoundButton("");
		buttonPegs9_1.addActionListener(e -> {
			if (buttonPegs9_1.getBackground().getRGB() == -860479) buttonPegs9_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs9_1.getBackground().getRGB() == -16777216) buttonPegs9_1.setBackground(new Color(128, 128, 128));
			else buttonPegs9_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs9_1.setEnabled(false);
		buttonPegs9_1.setBackground(new Color(242, 222, 193));	
		buttonPegs9_2 = new RoundButton("");
		buttonPegs9_2.addActionListener(e -> {
			if (buttonPegs9_2.getBackground().getRGB() == -860479) buttonPegs9_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs9_2.getBackground().getRGB() == -16777216) buttonPegs9_2.setBackground(new Color(128, 128, 128));
			else buttonPegs9_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs9_2.setEnabled(false);
		buttonPegs9_2.setBackground(new Color(242, 222, 193));
		buttonPegs9_3 = new RoundButton("");
		buttonPegs9_3.addActionListener(e -> {
			if (buttonPegs9_3.getBackground().getRGB() == -860479) buttonPegs9_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs9_3.getBackground().getRGB() == -16777216) buttonPegs9_3.setBackground(new Color(128, 128, 128));
			else buttonPegs9_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs9_3.setEnabled(false);
		buttonPegs9_3.setBackground(new Color(242, 222, 193));
		buttonPegs9_4 = new RoundButton("");
		buttonPegs9_4.addActionListener(e -> {
			if (buttonPegs9_4.getBackground().getRGB() == -860479) buttonPegs9_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs9_4.getBackground().getRGB() == -16777216) buttonPegs9_4.setBackground(new Color(128, 128, 128));
			else buttonPegs9_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs9_4.setEnabled(false);
		buttonPegs9_4.setBackground(new Color(242, 222, 193));
		buttonPegs10_1 = new RoundButton("");
		buttonPegs10_1.addActionListener(e -> {
			if (buttonPegs10_1.getBackground().getRGB() == -860479) buttonPegs10_1.setBackground(new Color(0, 0, 0));
			else if (buttonPegs10_1.getBackground().getRGB() == -16777216) buttonPegs10_1.setBackground(new Color(128, 128, 128));
			else buttonPegs10_1.setBackground(new Color(242, 222, 193));
		});
		buttonPegs10_1.setEnabled(false);
		buttonPegs10_1.setBackground(new Color(242, 222, 193));	
		buttonPegs10_2 = new RoundButton("");
		buttonPegs10_2.addActionListener(e -> {
			if (buttonPegs10_2.getBackground().getRGB() == -860479) buttonPegs10_2.setBackground(new Color(0, 0, 0));
			else if (buttonPegs10_2.getBackground().getRGB() == -16777216) buttonPegs10_2.setBackground(new Color(128, 128, 128));
			else buttonPegs10_2.setBackground(new Color(242, 222, 193));
		});
		buttonPegs10_2.setEnabled(false);
		buttonPegs10_2.setBackground(new Color(242, 222, 193));
		buttonPegs10_3 = new RoundButton("");
		buttonPegs10_3.addActionListener(e -> {
			if (buttonPegs10_3.getBackground().getRGB() == -860479) buttonPegs10_3.setBackground(new Color(0, 0, 0));
			else if (buttonPegs10_3.getBackground().getRGB() == -16777216) buttonPegs10_3.setBackground(new Color(128, 128, 128));
			else buttonPegs10_3.setBackground(new Color(242, 222, 193));
		});
		buttonPegs10_3.setEnabled(false);
		buttonPegs10_3.setBackground(new Color(242, 222, 193));
		buttonPegs10_4 = new RoundButton("");
		buttonPegs10_4.addActionListener(e -> {
			if (buttonPegs10_4.getBackground().getRGB() == -860479) buttonPegs10_4.setBackground(new Color(0, 0, 0));
			else if (buttonPegs10_4.getBackground().getRGB() == -16777216) buttonPegs10_4.setBackground(new Color(128, 128, 128));
			else buttonPegs10_4.setBackground(new Color(242, 222, 193));
		});
		buttonPegs10_4.setEnabled(false);
		buttonPegs10_4.setBackground(new Color(242, 222, 193));


		if (difficulty.equals(1)) {	
			buttonPegs1_1.setBounds(X_PEGS_4_1, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_2.setBounds(X_PEGS_4_2, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_3.setBounds(X_PEGS_4_3, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_4.setBounds(X_PEGS_4_4, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);

			buttonPegs2_1.setBounds(X_PEGS_4_1, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_2.setBounds(X_PEGS_4_2, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_3.setBounds(X_PEGS_4_3, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_4.setBounds(X_PEGS_4_4, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);

			buttonPegs3_1.setBounds(X_PEGS_4_1, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_2.setBounds(X_PEGS_4_2, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_3.setBounds(X_PEGS_4_3, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_4.setBounds(X_PEGS_4_4, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);

			buttonPegs4_1.setBounds(X_PEGS_4_1, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_2.setBounds(X_PEGS_4_2, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_3.setBounds(X_PEGS_4_3, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_4.setBounds(X_PEGS_4_4, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);

			buttonPegs5_1.setBounds(X_PEGS_4_1, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_2.setBounds(X_PEGS_4_2, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_3.setBounds(X_PEGS_4_3, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_4.setBounds(X_PEGS_4_4, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);

			buttonPegs6_1.setBounds(X_PEGS_4_1, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_2.setBounds(X_PEGS_4_2, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_3.setBounds(X_PEGS_4_3, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_4.setBounds(X_PEGS_4_4, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);

			buttonPegs7_1.setBounds(X_PEGS_4_1, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_2.setBounds(X_PEGS_4_2, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_3.setBounds(X_PEGS_4_3, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_4.setBounds(X_PEGS_4_4, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);

			buttonPegs8_1.setBounds(X_PEGS_4_1, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_2.setBounds(X_PEGS_4_2, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_3.setBounds(X_PEGS_4_3, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_4.setBounds(X_PEGS_4_4, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);

			buttonPegs9_1.setBounds(X_PEGS_4_1, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_2.setBounds(X_PEGS_4_2, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_3.setBounds(X_PEGS_4_3, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_4.setBounds(X_PEGS_4_4, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);

			buttonPegs10_1.setBounds(X_PEGS_4_1, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_2.setBounds(X_PEGS_4_2, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_3.setBounds(X_PEGS_4_3, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_4.setBounds(X_PEGS_4_4, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
		} else if (difficulty.equals(2)) {
		    buttonPegs1_5 = new RoundButton("");
			buttonPegs1_5.addActionListener(e -> {
				if (buttonPegs1_5.getBackground().getRGB() == -860479) buttonPegs1_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs1_5.getBackground().getRGB() == -16777216) buttonPegs1_5.setBackground(new Color(128, 128, 128));
				else buttonPegs1_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs1_5.setEnabled(false);
			buttonPegs1_5.setBackground(new Color(242, 222, 193));
			buttonPegs2_5 = new RoundButton("");
			buttonPegs2_5.addActionListener(e -> {
				if (buttonPegs2_5.getBackground().getRGB() == -860479) buttonPegs2_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs2_5.getBackground().getRGB() == -16777216) buttonPegs2_5.setBackground(new Color(128, 128, 128));
				else buttonPegs2_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs2_5.setEnabled(false);
			buttonPegs2_5.setBackground(new Color(242, 222, 193));
			buttonPegs3_5 = new RoundButton("");
			buttonPegs3_5.addActionListener(e -> {
				if (buttonPegs3_5.getBackground().getRGB() == -860479) buttonPegs3_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs3_5.getBackground().getRGB() == -16777216) buttonPegs3_5.setBackground(new Color(128, 128, 128));
				else buttonPegs3_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs3_5.setEnabled(false);
			buttonPegs3_5.setBackground(new Color(242, 222, 193));
			buttonPegs4_5 = new RoundButton("");
			buttonPegs4_5.addActionListener(e -> {
				if (buttonPegs4_5.getBackground().getRGB() == -860479) buttonPegs4_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs4_5.getBackground().getRGB() == -16777216) buttonPegs4_5.setBackground(new Color(128, 128, 128));
				else buttonPegs4_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs4_5.setEnabled(false);
			buttonPegs4_5.setBackground(new Color(242, 222, 193));
			buttonPegs5_5 = new RoundButton("");
			buttonPegs5_5.addActionListener(e -> {
				if (buttonPegs5_5.getBackground().getRGB() == -860479) buttonPegs5_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs5_5.getBackground().getRGB() == -16777216) buttonPegs5_5.setBackground(new Color(128, 128, 128));
				else buttonPegs5_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs5_5.setEnabled(false);
			buttonPegs5_5.setBackground(new Color(242, 222, 193));
			buttonPegs6_5 = new RoundButton("");
			buttonPegs6_5.addActionListener(e -> {
				if (buttonPegs6_5.getBackground().getRGB() == -860479) buttonPegs6_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs6_5.getBackground().getRGB() == -16777216) buttonPegs6_5.setBackground(new Color(128, 128, 128));
				else buttonPegs6_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs6_5.setEnabled(false);
			buttonPegs6_5.setBackground(new Color(242, 222, 193));
			buttonPegs7_5 = new RoundButton("");
			buttonPegs7_5.addActionListener(e -> {
				if (buttonPegs7_5.getBackground().getRGB() == -860479) buttonPegs7_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs7_5.getBackground().getRGB() == -16777216) buttonPegs7_5.setBackground(new Color(128, 128, 128));
				else buttonPegs7_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs7_5.setEnabled(false);
			buttonPegs7_5.setBackground(new Color(242, 222, 193));
			buttonPegs8_5 = new RoundButton("");
			buttonPegs8_5.addActionListener(e -> {
					if (buttonPegs8_5.getBackground().getRGB() == -860479) buttonPegs8_5.setBackground(new Color(0, 0, 0));
					else if (buttonPegs8_5.getBackground().getRGB() == -16777216) buttonPegs8_5.setBackground(new Color(128, 128, 128));
					else buttonPegs8_5.setBackground(new Color(242, 222, 193));
				});
			buttonPegs8_5.setEnabled(false);
			buttonPegs8_5.setBackground(new Color(242, 222, 193));
			buttonPegs9_5 = new RoundButton("");
			buttonPegs9_5.addActionListener(e -> {
					if (buttonPegs9_5.getBackground().getRGB() == -860479) buttonPegs9_5.setBackground(new Color(0, 0, 0));
					else if (buttonPegs9_5.getBackground().getRGB() == -16777216) buttonPegs9_5.setBackground(new Color(128, 128, 128));
					else buttonPegs9_5.setBackground(new Color(242, 222, 193));
				});
			buttonPegs9_5.setEnabled(false);
			buttonPegs9_5.setBackground(new Color(242, 222, 193));
			buttonPegs10_5 = new RoundButton("");
			buttonPegs10_5.addActionListener(e -> {
					if (buttonPegs10_5.getBackground().getRGB() == -860479) buttonPegs10_5.setBackground(new Color(0, 0, 0));
					else if (buttonPegs10_5.getBackground().getRGB() == -16777216) buttonPegs10_5.setBackground(new Color(128, 128, 128));
					else buttonPegs10_5.setBackground(new Color(242, 222, 193));
				});
			buttonPegs10_5.setEnabled(false);
			buttonPegs10_5.setBackground(new Color(242, 222, 193));

			buttonPegs1_1.setBounds(X_PEGS_5_1, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_2.setBounds(X_PEGS_5_2, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_3.setBounds(X_PEGS_5_3, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_4.setBounds(X_PEGS_5_4, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_5.setBounds(X_PEGS_5_5, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_1.setBounds(X_PEGS_5_1, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_2.setBounds(X_PEGS_5_2, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_3.setBounds(X_PEGS_5_3, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_4.setBounds(X_PEGS_5_4, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_5.setBounds(X_PEGS_5_5, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_1.setBounds(X_PEGS_5_1, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_2.setBounds(X_PEGS_5_2, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_3.setBounds(X_PEGS_5_3, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_4.setBounds(X_PEGS_5_4, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_5.setBounds(X_PEGS_5_5, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_1.setBounds(X_PEGS_5_1, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_2.setBounds(X_PEGS_5_2, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_3.setBounds(X_PEGS_5_3, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_4.setBounds(X_PEGS_5_4, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_5.setBounds(X_PEGS_5_5, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_1.setBounds(X_PEGS_5_1, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_2.setBounds(X_PEGS_5_2, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_3.setBounds(X_PEGS_5_3, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_4.setBounds(X_PEGS_5_4, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_5.setBounds(X_PEGS_5_5, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_1.setBounds(X_PEGS_5_1, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_2.setBounds(X_PEGS_5_2, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_3.setBounds(X_PEGS_5_3, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_4.setBounds(X_PEGS_5_4, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_5.setBounds(X_PEGS_5_5, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_1.setBounds(X_PEGS_5_1, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_2.setBounds(X_PEGS_5_2, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_3.setBounds(X_PEGS_5_3, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_4.setBounds(X_PEGS_5_4, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_5.setBounds(X_PEGS_5_5, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_1.setBounds(X_PEGS_5_1, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_2.setBounds(X_PEGS_5_2, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_3.setBounds(X_PEGS_5_3, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_4.setBounds(X_PEGS_5_4, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_5.setBounds(X_PEGS_5_5, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_1.setBounds(X_PEGS_5_1, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_2.setBounds(X_PEGS_5_2, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_3.setBounds(X_PEGS_5_3, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_4.setBounds(X_PEGS_5_4, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_5.setBounds(X_PEGS_5_5, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_1.setBounds(X_PEGS_5_1, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_2.setBounds(X_PEGS_5_2, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_3.setBounds(X_PEGS_5_3, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_4.setBounds(X_PEGS_5_4, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_5.setBounds(X_PEGS_5_5, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);

			contentPane.add(buttonPegs1_5);
			contentPane.add(buttonPegs2_5);
			contentPane.add(buttonPegs3_5);
			contentPane.add(buttonPegs4_5);
			contentPane.add(buttonPegs5_5);
			contentPane.add(buttonPegs6_5);
			contentPane.add(buttonPegs7_5);
			contentPane.add(buttonPegs8_5);
			contentPane.add(buttonPegs9_5);
			contentPane.add(buttonPegs10_5);
		} else if (difficulty.equals(3)) {
			buttonPegs1_5 = new RoundButton("");
			buttonPegs1_5.addActionListener(e -> {
				if (buttonPegs1_5.getBackground().getRGB() == -860479) buttonPegs1_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs1_5.getBackground().getRGB() == -16777216) buttonPegs1_5.setBackground(new Color(128, 128, 128));
				else buttonPegs1_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs1_5.setEnabled(false);
			buttonPegs1_5.setBackground(new Color(242, 222, 193));
			buttonPegs2_5 = new RoundButton("");
			buttonPegs2_5.addActionListener(e -> {
				if (buttonPegs2_5.getBackground().getRGB() == -860479) buttonPegs2_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs2_5.getBackground().getRGB() == -16777216) buttonPegs2_5.setBackground(new Color(128, 128, 128));
				else buttonPegs2_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs2_5.setEnabled(false);
			buttonPegs2_5.setBackground(new Color(242, 222, 193));
			buttonPegs3_5 = new RoundButton("");
			buttonPegs3_5.addActionListener(e -> {
				if (buttonPegs3_5.getBackground().getRGB() == -860479) buttonPegs3_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs3_5.getBackground().getRGB() == -16777216) buttonPegs3_5.setBackground(new Color(128, 128, 128));
				else buttonPegs3_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs3_5.setEnabled(false);
			buttonPegs3_5.setBackground(new Color(242, 222, 193));
			buttonPegs4_5 = new RoundButton("");
			buttonPegs4_5.addActionListener(e -> {
				if (buttonPegs4_5.getBackground().getRGB() == -860479) buttonPegs4_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs4_5.getBackground().getRGB() == -16777216) buttonPegs4_5.setBackground(new Color(128, 128, 128));
				else buttonPegs4_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs4_5.setEnabled(false);
			buttonPegs4_5.setBackground(new Color(242, 222, 193));
			buttonPegs5_5 = new RoundButton("");
			buttonPegs5_5.addActionListener(e -> {
				if (buttonPegs5_5.getBackground().getRGB() == -860479) buttonPegs5_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs5_5.getBackground().getRGB() == -16777216) buttonPegs5_5.setBackground(new Color(128, 128, 128));
				else buttonPegs5_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs5_5.setEnabled(false);
			buttonPegs5_5.setBackground(new Color(242, 222, 193));
			buttonPegs6_5 = new RoundButton("");
			buttonPegs6_5.addActionListener(e -> {
				if (buttonPegs6_5.getBackground().getRGB() == -860479) buttonPegs6_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs6_5.getBackground().getRGB() == -16777216) buttonPegs6_5.setBackground(new Color(128, 128, 128));
				else buttonPegs6_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs6_5.setEnabled(false);
			buttonPegs6_5.setBackground(new Color(242, 222, 193));
			buttonPegs7_5 = new RoundButton("");
			buttonPegs7_5.addActionListener(e -> {
				if (buttonPegs7_5.getBackground().getRGB() == -860479) buttonPegs7_5.setBackground(new Color(0, 0, 0));
				else if (buttonPegs7_5.getBackground().getRGB() == -16777216) buttonPegs7_5.setBackground(new Color(128, 128, 128));
				else buttonPegs7_5.setBackground(new Color(242, 222, 193));
			});
			buttonPegs7_5.setEnabled(false);
			buttonPegs7_5.setBackground(new Color(242, 222, 193));
			buttonPegs8_5 = new RoundButton("");
			buttonPegs8_5.addActionListener(e -> {
					if (buttonPegs8_5.getBackground().getRGB() == -860479) buttonPegs8_5.setBackground(new Color(0, 0, 0));
					else if (buttonPegs8_5.getBackground().getRGB() == -16777216) buttonPegs8_5.setBackground(new Color(128, 128, 128));
					else buttonPegs8_5.setBackground(new Color(242, 222, 193));
				});
			buttonPegs8_5.setEnabled(false);
			buttonPegs8_5.setBackground(new Color(242, 222, 193));
			buttonPegs9_5 = new RoundButton("");
			buttonPegs9_5.addActionListener(e -> {
					if (buttonPegs9_5.getBackground().getRGB() == -860479) buttonPegs9_5.setBackground(new Color(0, 0, 0));
					else if (buttonPegs9_5.getBackground().getRGB() == -16777216) buttonPegs9_5.setBackground(new Color(128, 128, 128));
					else buttonPegs9_5.setBackground(new Color(242, 222, 193));
				});
			buttonPegs9_5.setEnabled(false);
			buttonPegs9_5.setBackground(new Color(242, 222, 193));
			buttonPegs10_5 = new RoundButton("");
			buttonPegs10_5.addActionListener(e -> {
					if (buttonPegs10_5.getBackground().getRGB() == -860479) buttonPegs10_5.setBackground(new Color(0, 0, 0));
					else if (buttonPegs10_5.getBackground().getRGB() == -16777216) buttonPegs10_5.setBackground(new Color(128, 128, 128));
					else buttonPegs10_5.setBackground(new Color(242, 222, 193));
				});
			buttonPegs10_5.setEnabled(false);
			buttonPegs10_5.setBackground(new Color(242, 222, 193));
			buttonPegs1_6 = new RoundButton("");
			buttonPegs1_6.addActionListener(e -> {
					if (buttonPegs1_6.getBackground().getRGB() == -860479) buttonPegs1_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs1_6.getBackground().getRGB() == -16777216) buttonPegs1_6.setBackground(new Color(128, 128, 128));
					else buttonPegs1_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs1_6.setEnabled(false);
			buttonPegs1_6.setBackground(new Color(242, 222, 193));
			buttonPegs2_6 = new RoundButton("");
			buttonPegs2_6.addActionListener(e -> {
					if (buttonPegs2_6.getBackground().getRGB() == -860479) buttonPegs2_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs2_6.getBackground().getRGB() == -16777216) buttonPegs2_6.setBackground(new Color(128, 128, 128));
					else buttonPegs2_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs2_6.setEnabled(false);
			buttonPegs2_6.setBackground(new Color(242, 222, 193));
			buttonPegs3_6 = new RoundButton("");
			buttonPegs3_6.addActionListener(e -> {
					if (buttonPegs3_6.getBackground().getRGB() == -860479) buttonPegs3_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs3_6.getBackground().getRGB() == -16777216) buttonPegs3_6.setBackground(new Color(128, 128, 128));
					else buttonPegs3_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs3_6.setEnabled(false);
			buttonPegs3_6.setBackground(new Color(242, 222, 193));
			buttonPegs4_6 = new RoundButton("");
			buttonPegs4_6.addActionListener(e -> {
					if (buttonPegs4_6.getBackground().getRGB() == -860479) buttonPegs4_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs4_6.getBackground().getRGB() == -16777216) buttonPegs4_6.setBackground(new Color(128, 128, 128));
					else buttonPegs4_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs4_6.setEnabled(false);
			buttonPegs4_6.setBackground(new Color(242, 222, 193));
			buttonPegs5_6 = new RoundButton("");
			buttonPegs5_6.addActionListener(e -> {
					if (buttonPegs5_6.getBackground().getRGB() == -860479) buttonPegs5_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs5_6.getBackground().getRGB() == -16777216) buttonPegs5_6.setBackground(new Color(128, 128, 128));
					else buttonPegs5_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs5_6.setEnabled(false);
			buttonPegs5_6.setBackground(new Color(242, 222, 193));
			buttonPegs6_6 = new RoundButton("");
			buttonPegs6_6.addActionListener(e -> {
					if (buttonPegs6_6.getBackground().getRGB() == -860479) buttonPegs6_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs6_6.getBackground().getRGB() == -16777216) buttonPegs6_6.setBackground(new Color(128, 128, 128));
					else buttonPegs6_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs6_6.setEnabled(false);
			buttonPegs6_6.setBackground(new Color(242, 222, 193));
			buttonPegs7_6 = new RoundButton("");
			buttonPegs7_6.addActionListener(e -> {
					if (buttonPegs7_6.getBackground().getRGB() == -860479) buttonPegs7_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs7_6.getBackground().getRGB() == -16777216) buttonPegs7_6.setBackground(new Color(128, 128, 128));
					else buttonPegs7_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs7_6.setEnabled(false);
			buttonPegs7_6.setBackground(new Color(242, 222, 193));
			buttonPegs8_6 = new RoundButton("");
			buttonPegs8_6.addActionListener(e -> {
					if (buttonPegs8_6.getBackground().getRGB() == -860479) buttonPegs8_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs8_6.getBackground().getRGB() == -16777216) buttonPegs8_6.setBackground(new Color(128, 128, 128));
					else buttonPegs8_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs8_6.setEnabled(false);
			buttonPegs8_6.setBackground(new Color(242, 222, 193));
			buttonPegs9_6 = new RoundButton("");
			buttonPegs9_6.addActionListener(e -> {
					if (buttonPegs9_6.getBackground().getRGB() == -860479) buttonPegs9_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs9_6.getBackground().getRGB() == -16777216) buttonPegs9_6.setBackground(new Color(128, 128, 128));
					else buttonPegs9_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs9_6.setEnabled(false);
			buttonPegs9_6.setBackground(new Color(242, 222, 193));
			buttonPegs10_6 = new RoundButton("");
			buttonPegs10_6.addActionListener(e -> {
					if (buttonPegs10_6.getBackground().getRGB() == -860479) buttonPegs10_6.setBackground(new Color(0, 0, 0));
					else if (buttonPegs10_6.getBackground().getRGB() == -16777216) buttonPegs10_6.setBackground(new Color(128, 128, 128));
					else buttonPegs10_6.setBackground(new Color(242, 222, 193));
				});
			buttonPegs10_6.setEnabled(false);
			buttonPegs10_6.setBackground(new Color(242, 222, 193));

			buttonPegs1_1.setBounds(X_PEGS_6_1, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_2.setBounds(X_PEGS_6_2, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_3.setBounds(X_PEGS_6_3, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_4.setBounds(X_PEGS_6_4, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_5.setBounds(X_PEGS_6_5, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);
			buttonPegs1_6.setBounds(X_PEGS_6_6, Y_PEGS_1, PEGS_SIZE, PEGS_SIZE);

			buttonPegs2_1.setBounds(X_PEGS_6_1, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_2.setBounds(X_PEGS_6_2, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_3.setBounds(X_PEGS_6_3, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_4.setBounds(X_PEGS_6_4, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_5.setBounds(X_PEGS_6_5, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);
			buttonPegs2_6.setBounds(X_PEGS_6_6, Y_PEGS_2, PEGS_SIZE, PEGS_SIZE);

			buttonPegs3_1.setBounds(X_PEGS_6_1, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_2.setBounds(X_PEGS_6_2, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_3.setBounds(X_PEGS_6_3, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_4.setBounds(X_PEGS_6_4, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_5.setBounds(X_PEGS_6_5, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);
			buttonPegs3_6.setBounds(X_PEGS_6_6, Y_PEGS_3, PEGS_SIZE, PEGS_SIZE);

			buttonPegs4_1.setBounds(X_PEGS_6_1, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_2.setBounds(X_PEGS_6_2, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_3.setBounds(X_PEGS_6_3, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_4.setBounds(X_PEGS_6_4, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_5.setBounds(X_PEGS_6_5, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);
			buttonPegs4_6.setBounds(X_PEGS_6_6, Y_PEGS_4, PEGS_SIZE, PEGS_SIZE);

			buttonPegs5_1.setBounds(X_PEGS_6_1, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_2.setBounds(X_PEGS_6_2, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_3.setBounds(X_PEGS_6_3, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_4.setBounds(X_PEGS_6_4, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_5.setBounds(X_PEGS_6_5, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);
			buttonPegs5_6.setBounds(X_PEGS_6_6, Y_PEGS_5, PEGS_SIZE, PEGS_SIZE);

			buttonPegs6_1.setBounds(X_PEGS_6_1, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_2.setBounds(X_PEGS_6_2, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_3.setBounds(X_PEGS_6_3, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_4.setBounds(X_PEGS_6_4, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_5.setBounds(X_PEGS_6_5, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);
			buttonPegs6_6.setBounds(X_PEGS_6_6, Y_PEGS_6, PEGS_SIZE, PEGS_SIZE);

			buttonPegs7_1.setBounds(X_PEGS_6_1, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_2.setBounds(X_PEGS_6_2, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_3.setBounds(X_PEGS_6_3, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_4.setBounds(X_PEGS_6_4, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_5.setBounds(X_PEGS_6_5, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);
			buttonPegs7_6.setBounds(X_PEGS_6_6, Y_PEGS_7, PEGS_SIZE, PEGS_SIZE);

			buttonPegs8_1.setBounds(X_PEGS_6_1, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_2.setBounds(X_PEGS_6_2, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_3.setBounds(X_PEGS_6_3, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_4.setBounds(X_PEGS_6_4, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_5.setBounds(X_PEGS_6_5, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);
			buttonPegs8_6.setBounds(X_PEGS_6_6, Y_PEGS_8, PEGS_SIZE, PEGS_SIZE);

			buttonPegs9_1.setBounds(X_PEGS_6_1, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_2.setBounds(X_PEGS_6_2, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_3.setBounds(X_PEGS_6_3, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_4.setBounds(X_PEGS_6_4, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_5.setBounds(X_PEGS_6_5, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);
			buttonPegs9_6.setBounds(X_PEGS_6_6, Y_PEGS_9, PEGS_SIZE, PEGS_SIZE);

			buttonPegs10_1.setBounds(X_PEGS_6_1, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_2.setBounds(X_PEGS_6_2, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_3.setBounds(X_PEGS_6_3, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_4.setBounds(X_PEGS_6_4, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_5.setBounds(X_PEGS_6_5, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);
			buttonPegs10_6.setBounds(X_PEGS_6_6, Y_PEGS_10, PEGS_SIZE, PEGS_SIZE);


			contentPane.add(buttonPegs1_5);
			contentPane.add(buttonPegs2_5);
			contentPane.add(buttonPegs3_5);
			contentPane.add(buttonPegs4_5);
			contentPane.add(buttonPegs5_5);
			contentPane.add(buttonPegs6_5);
			contentPane.add(buttonPegs7_5);
			contentPane.add(buttonPegs8_5);
			contentPane.add(buttonPegs9_5);
			contentPane.add(buttonPegs10_5);

			contentPane.add(buttonPegs1_6);
			contentPane.add(buttonPegs2_6);
			contentPane.add(buttonPegs3_6);
			contentPane.add(buttonPegs4_6);
			contentPane.add(buttonPegs5_6);
			contentPane.add(buttonPegs6_6);
			contentPane.add(buttonPegs7_6);
			contentPane.add(buttonPegs8_6);
			contentPane.add(buttonPegs9_6);
			contentPane.add(buttonPegs10_6);
		}

		contentPane.add(buttonPegs1_1);
		contentPane.add(buttonPegs1_2);
		contentPane.add(buttonPegs1_3);
		contentPane.add(buttonPegs1_4);

		contentPane.add(buttonPegs2_1);
		contentPane.add(buttonPegs2_2);
		contentPane.add(buttonPegs2_3);
		contentPane.add(buttonPegs2_4);

		contentPane.add(buttonPegs3_1);
		contentPane.add(buttonPegs3_2);
		contentPane.add(buttonPegs3_3);
		contentPane.add(buttonPegs3_4);

		contentPane.add(buttonPegs4_1);
		contentPane.add(buttonPegs4_2);
		contentPane.add(buttonPegs4_3);
		contentPane.add(buttonPegs4_4);

		contentPane.add(buttonPegs5_1);
		contentPane.add(buttonPegs5_2);
		contentPane.add(buttonPegs5_3);
		contentPane.add(buttonPegs5_4);

		contentPane.add(buttonPegs6_1);
		contentPane.add(buttonPegs6_2);
		contentPane.add(buttonPegs6_3);
		contentPane.add(buttonPegs6_4);

		contentPane.add(buttonPegs7_1);
		contentPane.add(buttonPegs7_2);
		contentPane.add(buttonPegs7_3);
		contentPane.add(buttonPegs7_4);

		contentPane.add(buttonPegs8_1);
		contentPane.add(buttonPegs8_2);
		contentPane.add(buttonPegs8_3);
		contentPane.add(buttonPegs8_4);

		contentPane.add(buttonPegs9_1);
		contentPane.add(buttonPegs9_2);
		contentPane.add(buttonPegs9_3);
		contentPane.add(buttonPegs9_4);

		contentPane.add(buttonPegs10_1);
		contentPane.add(buttonPegs10_2);
		contentPane.add(buttonPegs10_3);
		contentPane.add(buttonPegs10_4);


		JPanel pegsMenu = new JPanel();
		pegsMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pegsMenu.setBackground(new Color(242, 222, 193));
		pegsMenu.setBounds(317, 62, 214, 456);
		contentPane.add(pegsMenu);
	}

	/** @brief Funcio que inicialitza els buttons corresponents al crear partida segons sigui codeMaker o codeBreaker
     */
	public void jugarPartida() {
		if (cPlay.getRol().equals("CodeMaker")) {
			colorActual = new Color(128, 128, 128);
			resultColor1.setEnabled(true);
			resultColor2.setEnabled(true);
			resultColor3.setEnabled(true);
			resultColor4.setEnabled(true);
			if (difficulty == 2) resultColor5.setEnabled(true);
			else if (difficulty == 3) {
				resultColor5.setEnabled(true);
				resultColor6.setEnabled(true);
			}
			buttonStart.setEnabled(true);

		} else if (cPlay.getRol().equals("CodeBreaker")) {
			colorActual = new Color(0, 128, 0);
			buttonMainColors1.setEnabled(true);
			buttonMainColors2.setEnabled(true);
			buttonMainColors3.setEnabled(true);
			buttonMainColors4.setEnabled(true);
			buttonMainColors5.setEnabled(true);
			buttonMainColors6.setEnabled(true);

			buttonStart.hide();
			buttonHelp.show();
			buttonHelp.setEnabled(true);
			checkButton.setEnabled(true);

			message.setText("");

			buttonRound1_1.setEnabled(true);
			buttonRound1_2.setEnabled(true);
			buttonRound1_3.setEnabled(true);
			buttonRound1_4.setEnabled(true);
			if (difficulty == 2) buttonRound1_5.setEnabled(true);
			else if (difficulty == 3) {
				buttonRound1_5.setEnabled(true);
				buttonRound1_6.setEnabled(true);
			}
		}
	} 

	/** @brief Funcio que inicialitza els buttons corresponents al carregar partida segons sigui codeMaker o codeBreaker
     */
	public void continuarPartida() {
		if (cPlay.getRol().equals("CodeMaker")) {
			buttonStart.hide();
			buttonHelp.show();
			buttonHelp.setEnabled(true);
			checkButton.setEnabled(true);

			message.setText("");

			showResult();

			carregarColorsPegsCM();
			actualitzaButtonPegs();

			buttonMainHighlight.hide();

		} else if (cPlay.getRol().equals("CodeBreaker")) {	
			colorActual = new Color(0, 128, 0);
			buttonMainColors1.setEnabled(true);
			buttonMainColors2.setEnabled(true);
			buttonMainColors3.setEnabled(true);
			buttonMainColors4.setEnabled(true);
			buttonMainColors5.setEnabled(true);
			buttonMainColors6.setEnabled(true);

			buttonStart.hide();
			buttonHelp.show();
			buttonHelp.setEnabled(true);
			checkButton.setEnabled(true);

			message.setText("");

			carregarColorsPegsCB();
			actualitzaButtonRounds();

			buttonMainHighlight.hide();
		}
	}

	/** @brief Funcio que carrega graficament els colors i pegs al tauler al fer load game en codeMaker
     */
	private void carregarColorsPegsCM() {
		List<List<Integer>> cols = cPlay.getCodsPartidaMaq();
		como = cols;
		List<String> pegs = cPlay.getPegsPartidaMaq();
		Pegs = pegs;
		Integer round = cPlay.getRonda();
		cPlay.resetRonda(0);

		for (int i = 0; i < round+1; ++i) {
			mostraColors(cols);
			mostraPegs(pegs);
			cPlay.actualitzaRonda();
		}

		cPlay.resetRonda(round-1);
		moureCheckbutton();
		cPlay.resetRonda(round);
	}

	/** @brief Funció que càrrega graficament els colors i pegs al tauler al fer load game en codeBreaker
     */
	private void carregarColorsPegsCB() {
		List<List<Integer>> cols = cPlay.getCodsPartida();
		List<String> pegs = cPlay.getPegsPartida();
		Integer round = cPlay.getRonda();
		cPlay.resetRonda(0);

		for (int i = 0; i < round; ++i) {
			mostraColors(cols);
			mostraPegs(pegs);
			moureCheckbutton();
			cPlay.actualitzaRonda();
		}
	}
	
	/** @brief Funcio que implementa la funcionalitat del menu file
	 * 
	 * @param component objecte del menu que interactua amb l'usuari
	 * @param popup menu que es troba a la part superior de la pantalla
     */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	/** @brief Funcio que implementa la funcionalitat de sortir del masterMind
	 * 
	 * @param evt es presiona el button exit
     */
	private void exit(java.awt.event.ActionEvent evt) {
		
		System.exit(0);
	}
	
	/** @brief Funcio que finalitza el timer, guarda el temps de la partida i finalitza el game
     */
	private void endTime() {
		t.stop();
		String time = timeHour.getText()+":"+timeMinute.getText()+":"+timeSecond.getText();
		cPlay.setTempsPartida(time);
		timeHour.setForeground(Color.red);
		timeMinute.setForeground(Color.red);
		timeSecond.setForeground(Color.red);
		JlabelTime1.setForeground(Color.red);
		JLabelTime2.setForeground(Color.red);
		mntmNewMenuItem.setEnabled(false);

		String rol = cPlay.getRol();
		cPlay.acabarPartida(rol);
    }
	
	/** @brief Funcio que implementa la funcionalitat de guardarPartida al pressionar el buttonSave
	 * 
	 * @param evt es presiona el button saveGame
     */
	private void guardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {
		String time = timeHour.getText()+":"+timeMinute.getText()+":"+timeSecond.getText();
		cPlay.setTempsPartida(time);
		cPlay.guardarPartida();
	}
	
	/** @brief Funcio que retorna a la vista MainMenu al fer close o save de la partida
     */
	private void returnVistaMM() {
		VistaMainMenu vistaMenu = new VistaMainMenu(this, cPlay);
		vistaMenu.setVisible(true);
		this.setVisible(false);
	}
}