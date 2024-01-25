package main.domain.drivers;

import main.domain.controllers.*;
import main.domain.classes.*;
import main.domain.classes.Exceptions.ContrasenyaIncorrecte;
import main.domain.classes.Exceptions.DificultatNoExisteix;
import main.domain.classes.Exceptions.UsuariJaExisteix;

import java.io.FileNotFoundException;
import java.util.*;
 
public class driverDomain {
    private static final Scanner reader = new Scanner(System.in);
    private static CtrlDomain CD;
    
    public driverDomain(){}

    public static void main(String[] args) {
        CD = new CtrlDomain();
        boolean usuariActual = false;

        System.out.println("Opciones: \n 1. Crear Perfil \n 2. Cargar Perfil \n 3. Consultar Ranking \n 4. Consultar Perfils \n 5. Crear Partida \n 6. Cargar Partida \n 7. Consultar stats \n 8. Tancar sessio \n 9. Salir");
        int value = readOption();
        while (value != 9) {
            switch (value) {
                case 1: //Crear Perfil
                    String usuari1 = "";
                    String pswd1 = "";

                    System.out.println("Introdueix nom usuari: ");
                    while(usuari1.equals("")) {
                        usuari1 = reader.nextLine();
                    } 

                    System.out.println("Introdueix nom password: ");
                    while(pswd1.equals("")) {
                        pswd1 = reader.nextLine();
                    } 
                    
                    try {
                    CD.registrarUsuari(usuari1, pswd1);
                    System.out.println("Usuari registrat: " + usuari1);
                        try {
                        CD.carregarUsuari(usuari1, pswd1);
                        System.out.println("Benvingut, " + usuari1 + "!");
                        } catch (FileNotFoundException e) {
                            System.out.println("Usuari no existeix al sistema");
                        } catch (ContrasenyaIncorrecte e) {
                            System.out.println("Contrasenya incorrecte");
                        } 
                        usuariActual = true;

                    } catch (UsuariJaExisteix e) {
                        System.out.println("Usuari ja existeix al sistema");
                    } catch (ContrasenyaIncorrecte e) {
                        System.out.println("Contrasenya incorrecte");
                    }
                    
                    break;

                case 2: //Cargar Perfil
                    String usuari2 = "";
                    String pswd2 = "";
                    
                    if (usuariActual) System.out.println("Tanca la sessio actual.");
                    else {
                        System.out.println("Introdueix nom usuari: ");
                        while(usuari2.equals("")) {
                            usuari2 = reader.nextLine();
                        } 

                        System.out.println("Introdueix nom password: ");
                        while(pswd2.equals("")) {
                            pswd2 = reader.nextLine();
                        } 

                        try {
                        CD.carregarUsuari(usuari2, pswd2);
                        usuariActual = true;
                        System.out.println("Benvingut, " + usuari2 + "!");
                        } catch (FileNotFoundException e) {
                            System.out.println("Usuari no existeix al sistema");
                        } catch (ContrasenyaIncorrecte e) {
                            System.out.println("Contrasenya incorrecte");
                        } 
                    }

                    break;

                case 3: //Consultar Ranking
                	CD.actualitzaRanking();
                	
                    System.out.println("Introdueix ranking a consultar: ");
                    System.out.println("1. CodeMaker 2. CodeBreaker");
                    int rol = reader.nextInt();
                    
                    if (rol != 1 && rol != 2) System.out.println("Rol inexistent");
                    else {
                        System.out.println("N. Usuari Puntuacio");
                        if (rol == 1) {
                            String[][] Ranquing =  CD.consultarRanking("CodeMaker");
                            for( String[] rows : Ranquing) {        
                                System.out.println(rows[0] + "  "  + rows[1] + "   " + rows[2]); 
                            }
                        } else {
                            String[][] Ranquing =  CD.consultarRanking("CodeBreaker");
                            for( String[] rows : Ranquing) {        
                                System.out.println(rows[0] + "  "  + rows[1] + "   " + rows[2]); 
                            }
                        }
                    }

                    break;

                case 4: //Consultar Perfils
                    ArrayList<Usuari> llistaUsuaris = CD.getLlistaUsuaris(); 
                    if (llistaUsuaris.size() == 0) System.out.println("Cap usuari registrat.");
                    else {
                        System.out.println("Usuaris:");
                        for (Usuari usuaris : llistaUsuaris) {
                            String nom = usuaris.getNom();
                            System.out.println("- " + nom);
                        }
                    }

                    break;

                case 5: //Crear Partida
                    if(usuariActual) {
                        int dif = 0;
                        while (dif != 1 && dif != 2 && dif != 3) {
                            System.out.println("Introdueix dificultat: ");
                            System.out.println("1. Facil: Tauler 4 espais");
                            System.out.println("2. Mig: Tauler 5 espais");
                            System.out.println("3. Dificil: Tauler 6 espais");
                            dif = reader.nextInt();
                        }

                        int rolUsuari = 0;
                        while (rolUsuari != 1 && rolUsuari != 2) {
                            System.out.println("Introdueix rol: ");
                            System.out.println("1. CodeMaker 2. CodeBreaker");
                            rolUsuari = reader.nextInt();
                        }

                        int algorisme = 0;
                        while (algorisme != 1 && algorisme != 2) {
                            System.out.println("Introdueix algorisme a utilitzar: ");
                            System.out.println("1. FiveGuess 2. Genetic");
                            algorisme = reader.nextInt();
                        }
                       
                        if (rolUsuari == 1) {
                            try {
                            CD.creaNovaPartida(dif, "CodeMaker", algorisme);
                            } catch (DificultatNoExisteix e) {
                                System.out.println("Dificultat introduida no existeix");
                            }
                            jugarPartida();
                        } else {
                            try {
                            CD.creaNovaPartida(dif, "CodeBreaker", algorisme);
                            } catch (DificultatNoExisteix e) {
                                System.out.println("Dificultat introduida no existeix");
                            }
                            
                            jugarPartida();
                        }
                    } else {
                        System.out.println("Sessio no iniciada.");
                    }

                    break;

                case 6: //Cargar partida 
                    if(usuariActual) {
                        List<Partida> LlistaPartides = CD.getPartidesGuardades();
                        if (LlistaPartides.size() == 0) System.out.println("No hi ha partides guardades.");
                        else {
                            System.out.println("Selecciona el num de la partida: ");

                            for (Partida P : LlistaPartides) {
                                System.out.println("- " + P.getIdPartida());
                            }
                            
                            int id = reader.nextInt();
                            if (id >= LlistaPartides.size() || id < 0) {
                                System.out.println("La partida no existeix");
                                break;
                            }
                            CD.continuaPartida(id);
                            continuarPartida();
                        }
                    } else { 
                        System.out.println("Sessio no iniciada.");
                    }

                    break;
                
                case 7: //Consultar stats
                    if(usuariActual) {
                        System.out.println("Puntuacio com a CodeMaker: " + CD.getPuntuacioCM());
                        System.out.println("Puntuacio com a CodeBreaker: " + CD.getPuntuacioCB());
                        System.out.println("Total partides acabades: " + CD.getPartidesAcabades());
                        System.out.println("Total partides iniciades: " + CD.getPartidesIniciades());
                        System.out.println("Total ajudes demanades: " + CD.getAjuts());
                    } else {
                        System.out.println("Sessio no iniciada.");
                    }

                    break;
                
                case 8: //Tancar sessio
                    if(usuariActual) {
                        usuariActual = false;
                        CD.tancarSesioUsuari();
                        System.out.println("Sessio tancada.");
                    } else {
                        System.out.println("Sessio no iniciada.");
                    }
                    
                    break;
                
                default:
                    System.out.println("Opcio incorrecte.");
            }
            System.out.println();
            System.out.println("Opciones: \n 1. Crear Perfil \n 2. Cargar Perfil \n 3. Consultar Ranking \n 4. Consultar Perfils \n 5. Crear Partida \n 6. Cargar Partida \n 7. Consultar stats \n 8. Tancar sessio \n 9. Sortir");
            value = readOption();
        }
        System.out.println("Aplicacio tancada.");

        System.exit(0);
    }

    public static Integer readOption() {
        int n;
        n = reader.nextInt();
        return n;
    }

    public static void jugarPartida() {
        Partida partidaActual = CD.getPartidaActual();

        int rondes = 0;
        boolean resolt = false;

        if(partidaActual.getRol().equals("CodeMaker")) { // usuari com a codeMaker
            Integer dif = CD.getDificultatPartida();

            System.out.println("0. Vermell | 2. Blau | 4. Negre");
            System.out.println("1. Verd    | 3. Groc | 5. Blanc");
            List<Integer> codi = new ArrayList<>();

            boolean seqvalida = false;
            while (!seqvalida) {
                codi = new ArrayList<>();
                if(dif == 1) {
                    System.out.println("(Exemple: 1 1 2 5)");
                    System.out.println("Introdeix codi de 4 colors a resoldre: ");  

                    for(int i = 0; i < 4; ++i) {
                        Integer color = reader.nextInt();
                        codi.add(color);
                    }    
                } else if(dif == 2) {
                    System.out.println("(Exemple: 4 1 1 2 5)");
                    System.out.println("Introdeix codi de 5 colors a resoldre: "); 

                    for(int i = 0; i < 5; ++i) {
                        Integer color = reader.nextInt();
                        codi.add(color);
                    } 
                } else {
                    System.out.println("(Exemple: 0 4 3 1 1 5)");
                    System.out.println("Introdeix codi de 6 colors a resoldre: "); 

                    for(int i = 0; i < 6; ++i) {
                        Integer color = reader.nextInt();
                        codi.add(color);
                    } 
                }

                seqvalida = CD.checkValida(codi);
            }
            
            CD.asignaCodiCodeMaker(codi);
		    
            List<List<Integer>> como = CD.SequenciaMaq();

            List<String> Pegs = CD.getPegsMaq();

            System.out.println("'B' color en posicio correcte");
            System.out.println("'W' existeix color ");
            System.out.println("'_' no existeix color");
            if(dif == 1) System.out.println("(Exemple: BBW_)");
            else if(dif == 2) System.out.println("(Exemple: BWW__)");
            else System.out.println("(Exemple: WW____)");
            System.out.println();

            List<Integer> coAux;

            boolean acab = false;
            
            while(rondes < 10) {
                CD.setRondaPartida(rondes);
                
                coAux = como.get(rondes); // <- java.lang
                CD.taulerSetCodiActual(coAux);
                mostrarCodi(coAux);

                String correccio = Pegs.get(rondes);
                correccioUsuari(correccio);

                if (dif == 1 && correccio.equals("BBBB")) resolt = true;
                else if(dif == 2 && correccio.equals("BBBBB")) resolt = true;
                else if(dif == 3 && correccio.equals("BBBBBB")) resolt = true;

                if(resolt) {
                    CD.acabarPartida(partidaActual.getRol());
                    acab = true;
                    break;
                }
                
                if (rondes < 9) {
                    System.out.println("Vols guardar la partida? 1. Si  2. No ");
                    int guardar = reader.nextInt();
                    if(guardar == 1) {
                        ++rondes;
                        CD.guardarPartida();
                        acab = true;
                        System.out.println("Partida guardada.");
                        break;
                    }
                }
                
                ++rondes;  
            }
            if (!acab) {
                CD.acabarPartida(partidaActual.getRol());
            }

	    } else if (partidaActual.getRol().equals("CodeBreaker")) { 
            List<String> Pegs = new ArrayList<>();

            Integer diff = CD.getDificultatPartida();
            int nBoles;
            if(diff == 1) nBoles = 4;
            else if(diff == 2) nBoles = 5;
            else nBoles = 6;

            if(diff == 1) System.out.println("(Exemple: 1 1 2 5)");
            else if(diff == 2) System.out.println("(Exemple: 4 1 1 2 5)");
            else System.out.println("(Exemple: 0 4 3 1 1 5)");
            
            boolean acab = false;

            while(rondes < 10) {
                CD.setRondaPartida(rondes);

                System.out.println("0. Vermell | 2. Blau | 4. Negre");
                System.out.println("1. Verd    | 3. Groc | 5. Blanc");
                if (rondes == 0) System.out.println("Help: L'ajuda proporciona un numero del codi a resoldre.");
                
                System.out.println("Vols una ajuda? 1. Si  2. No ");
                int ajuda = reader.nextInt();
                if(ajuda == 1) {
                    CD.ajutUsuari();
                }

                List<Integer> codi = new ArrayList<>();

                boolean seqvalida2 = false;
                while(!seqvalida2) {
                    codi = new ArrayList<>();
                    System.out.println("Introdueix codi: ");
                    for(int i = 0; i < nBoles; ++i) {
                        Integer color = reader.nextInt();
                        codi.add(color);
                    }
                    seqvalida2 = CD.checkValida(codi);
                }
                CD.taulerSetCodiActual(codi);

                String Peg = CD.checkCode();
                Pegs.add(Peg);

                System.out.println("Tauler: ");
                List<List<Integer>> board = CD.getBoardPartida();
                for (int i = 0; i < board.size(); ++i) {
                    System.out.print(i + ". ");
                    for (int j = 0; j < board.get(i).size(); ++j) {
                        System.out.print(board.get(i).get(j));
                    }
                    System.out.println(" " + Pegs.get(i));
                }
                System.out.println();

                if(diff == 1 && Peg.equals("BBBB")) resolt = true;
                else if(diff == 2 && Peg.equals("BBBBB")) resolt = true;
                else if(diff == 3 && Peg.equals("BBBBBB")) resolt = true;

                if(resolt) {
                    acab = true;
                    CD.acabarPartida(partidaActual.getRol());
                    break;
                }
                
                if (rondes < 9) {
                    System.out.println("Vols guardar la partida? 1. Si  2. No ");
                    int guardar = reader.nextInt();
                    if(guardar == 1) {
                        ++rondes;
                        acab = true;
                        CD.guardarPartida();
                        break;
                    }
                }

                ++rondes;
            }
            if (!acab) {
                System.out.println("Has perdut...");
                System.out.println("Puntuacio: 0");
            }
        }
    }

    public static void continuarPartida() {
        Partida partidaActual = CD.getPartidaActual();

        Integer round;
        boolean resolt = false;

        if(partidaActual.getRol().equals("CodeMaker")) {
            System.out.print("El teu codi era: ");
            mostrarCodi(CD.getCodiResoldre());
            System.out.println();

            Integer dif = CD.getDificultatPartida();
            JugadorIA playerIA = CD.getJugadorIA();

            List<List<Integer>> como2 = playerIA.getCodsMaq();
            List<String> pegAux = playerIA.getPegsMaq();

            System.out.println("'B' color en posicio correcte");
            System.out.println("'W' existeix color ");
            System.out.println("'_' no existeix color");
            if(dif == 1) System.out.println("(Exemple: BBW_)");
            else if(dif == 2) System.out.println("(Exemple: BWW__)");
            else System.out.println("(Exemple: WW____)");
            System.out.println();

            List<Integer> coAux2;

            round = CD.getRondaPartida();

            System.out.println("Codis utilitzats:");
            for (int i = 0; i < round+1; ++i) {
                for (int j = 0; j < como2.get(i).size(); ++j) {
                    System.out.print(como2.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("-------");
            System.out.println();

            ++round;

            boolean acab = false;

            while(round < 10) {
                CD.setRondaPartida(round);

                coAux2 = como2.get(round);
                CD.taulerSetCodiActual(coAux2);
                mostrarCodi(coAux2);  
                
                String correccio = pegAux.get(round);
                correccioUsuari(correccio);
                
                if (dif == 1 && correccio.equals("BBBB")) resolt = true;
                else if(dif == 2 && correccio.equals("BBBBB")) resolt = true;
                else if(dif == 3 && correccio.equals("BBBBBB")) resolt = true;

                if(resolt) {
                    acab = true;
                    CD.acabarPartida(partidaActual.getRol());
                    break;
                }

                if (round < 9) {
                    System.out.println("Vols guardar la partida? 1. Si  2. No ");
                    int guardar = reader.nextInt();
                    if(guardar == 1) {
                        ++round;
                        acab = true;
                        CD.guardarPartida();
                        break;
                    }
                }
                
                ++round; 
            }
            if (!acab) {
                CD.acabarPartida(partidaActual.getRol());
            }

	    } else {
            Integer diff = CD.getDificultatPartida();
            int nBoles;
            if(diff == 1) nBoles = 4;
            else if(diff == 2) nBoles = 5;
            else nBoles = 6;

            List<String> pegs2 = CD.getPegsPartida();
            List<List<Integer>> boardAct = CD.getBoardPartida();

            for (int i = 0; i < boardAct.size(); ++i) {
                for (int j = 0; j < boardAct.get(i).size(); ++j) {
                    System.out.print(boardAct.get(i).get(j));
                }
                System.out.println(" " + pegs2.get(i));
            }
            System.out.println();

            System.out.println("Tauler: ");
            for (int i = 0; i < boardAct.size(); ++i) {
                System.out.print(i + ". ");
                for (int j = 0; j < boardAct.get(i).size(); ++j) {
                    System.out.print(boardAct.get(i).get(j));
                }
                System.out.println(" " + pegs2.get(i));
            }
            System.out.println();

            round = CD.getRondaPartida()+1;
            
            boolean acab = false;

            while(round < 10) {
                CD.setRondaPartida(round);

                System.out.println("0. Vermell | 2. Blau | 4. Negre");
                System.out.println("1. Verd    | 3. Groc | 5. Blanc");
                if (round == 0) System.out.println("Help: L'ajuda proporciona un numero del codi a resoldre.");
                List<Integer> codi = new ArrayList<>();

                System.out.println("Vols una ajuda? 1. Si  2. No ");
                int ajuda = reader.nextInt();
                if(ajuda == 1) {
                    CD.ajutUsuari();
                }

                boolean seqvalida3 = false;
                while(!seqvalida3) {
                    codi = new ArrayList<>();
                    System.out.println("Introdueix codi: ");
                    for(int i = 0; i < nBoles; ++i) {
                        Integer color = reader.nextInt();
                        codi.add(color);
                    }
                    seqvalida3 = CD.checkValida(codi);
                }
               
                CD.taulerSetCodiActual(codi);
                
                String peg2 = CD.checkCode();
                pegs2.add(peg2);

                List<List<Integer>> board = CD.getBoardPartida();
                System.out.println("Tauler: ");
                for (int i = 0; i < board.size(); ++i) {
                    System.out.print(i + ". ");
                    for (int j = 0; j < board.get(i).size(); ++j) {
                        System.out.print(board.get(i).get(j));
                    }
                    System.out.println(" " + pegs2.get(i));
                }
                System.out.println();

                if(diff == 1 && peg2.equals("BBBB")) resolt = true;
                else if(diff == 2 && peg2.equals("BBBBB")) resolt = true;
                else if(diff == 3 && peg2.equals("BBBBBB")) resolt = true;
                
                if(resolt) {
                    acab = true;
                    CD.acabarPartida(partidaActual.getRol());
                    break;
                }
                
                if (round < 9) {
                    System.out.println("Vols guardar la partida? 1. Si  2. No ");
                    int guardar = reader.nextInt();
                    if(guardar == 1) {
                        ++round;
                        acab = true;
                        CD.guardarPartida();
                        break;
                    }
                }  
                
                ++round;         
            }
            if (!acab) {
                System.out.println("Has perdut...");
                System.out.println("Puntuacio: 0");
            }
        }
    }

    public static void mostrarCodi(List<Integer> codiActual) {
        for (Integer integer : codiActual) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void correccioUsuari(String correccio) {
        String correccioUs = "";
        System.out.println("Introdueix correcio: ");
        while(correccioUs.equals("")) {
            correccioUs = reader.nextLine();
        }
        
        while(!correccioUs.equals(correccio)) {
            System.out.println(correccioUs + " (Pegs correctes: '" + correccio + "')");
            System.out.println("Correccio incorrecte, introdueix correcio:");
            correccioUs = reader.nextLine();
        }
        System.out.println("Correccio correcte");  
    }
}