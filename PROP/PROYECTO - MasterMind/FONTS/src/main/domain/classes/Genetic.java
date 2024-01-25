package main.domain.classes;

import java.util.*;

public class Genetic implements Maquina {

    /**
     * Representa la mida i dificultat del codi
     */
	static Integer CODE_LENGTH = 4;

    /**
     * Representa la quantitat de colors que hi ha
     */
    static final Integer N_COLORS = 6;

    /**
     * Representa la mida de la poblacio
     */
    static final Integer POPULATION_SIZE = 200;

    /**
     * Representa el ratio de mutació
     */
    static final double MUTATION_RATE = 0.7;

    /**
     * Representa la quantitat maxima de torns
     */
    static final Integer MAX_TORNS = 10;

    /**
     * Codi per comparar els guesses
     */
    static List<Integer> code;

    /**
     * Colors utilitzats a la generació de combinacions
     */
	static Integer[] colors = {0, 1, 2, 3, 4, 5};

    /**
     * Conté totes les possibles combinacions de colors
     */
    static List<List<Integer>> combinations = new ArrayList<>();

    /**
     * Conté la pobalcio actual en cada torn
     */
	static List<List<Integer>> population = new ArrayList<>();

    /**
     * Conté les combinacions utilitzades per endevinar el codi
     */
    public static List<List<Integer>> guessesAux = new ArrayList<>();

    /**
     * Conté els pegs resultants de les combinacions guessesResult
     */
    public static List<String> pegsAux = new ArrayList<>();

    /** @brief Funció que controla el procès d'endivinar el codi
     *  
     * @param codi codi a adivinar
     * 
     * @return partida resultant 
     */
    @Override
	public List<List<Integer>> solve(List<Integer> codi) {
		List<List<Integer>> guessesResult = new ArrayList<>();
        List<String> pegsResult = new ArrayList<>();
        CODE_LENGTH = codi.size();
        int repetits = 0;
        int turn = 1;
        
        boolean[] visited = new boolean[colors.length];
        Arrays.fill(visited, false);

        combinations.clear();
        population.clear();
        backtrackingCombinations(0, new Integer[CODE_LENGTH], visited, repetits);

        //Poblacio
		for (int i = 0; i < POPULATION_SIZE; ++i) population.add(randomMove());

        code = codi;
        List<Integer> current;

        boolean won = false;
        String pegs;

        while(!won && turn <= MAX_TORNS) {
            // EVALUATE
            List<Integer> puntuacio = new ArrayList<>(POPULATION_SIZE);
            for (int i = 0; i < POPULATION_SIZE; ++i) {
                puntuacio.add(evaluatePopulation(population.get(i), code)); // avaluar puntuacio
            }

            current = getBestPuntuacio(population);
            
            // CHECK SOLUTION
            pegs = checkCode(current, code);
            pegsResult.add(pegs);

            // ADD SELECTION
            guessesResult.add(current);

            if (trobaPuntuacioMaxima(puntuacio, CODE_LENGTH * 10)) {
                won = true;
            }

            // PARENTS
            List<List<Integer>> parents = new ArrayList<>(2);
            for (int i = 0; i < 2; ++i) {
                int x = (int)(Math.random() * POPULATION_SIZE);
                int y = (int)(Math.random() * POPULATION_SIZE);

                if (x > y) parents.add(population.get(x));
                else parents.add(population.get(y));
            }

            // MUTATION
            List<List<Integer>> newGeneration = new ArrayList<>();
            for (int i = 0; i < POPULATION_SIZE; ++i) {
                List<Integer> child;
                child = getChild(parents);
                child = mutateChild(child);
                newGeneration.add(child);
            }
            
            // REPLACE
            population = newGeneration;
            
            ++turn;
        }
        pegsAux = pegsResult;
        guessesAux = guessesResult;

        return guessesResult;
	}

    /** @brief Funció que obté la maxima puntuacio de la població
     *  
     * @param population poblacio actual del torn
     * 
     * @return maxima puntuacio de tota la poblacio 
     */
    public static List<Integer> getBestPuntuacio(List<List<Integer>> population) {
        int maxPunts = 0;
        int auxIndex = 0;
        for (int i = 0; i < population.size(); ++i) {
            Integer avaluacio = evaluatePopulation(population.get(i), code);
            if (avaluacio > maxPunts) {
                maxPunts = avaluacio;
                auxIndex = i;
            }
        }

        return population.get(auxIndex);
    }

    /** @brief Funció que obté un fill a partir de dos pares
     *  
     * @param parents els dos codis del pares
     * 
     * @return un nou fill generat entre els pares 
     */
    public static List<Integer> getChild(List<List<Integer>> parents) {
        int mergeValue = (int)(Math.random() * CODE_LENGTH);
        List<Integer> newChild = new ArrayList<>();
        
        for (int i = 0; i < CODE_LENGTH; ++i) {
            if (i < mergeValue) newChild.add(parents.get(0).get(i));
            else newChild.add(parents.get(1).get(i));
        }

        return newChild;
    }

    /** @brief Funció que muta un fill
     *  
     * @param child codi del fill a mutar
     * 
     * @return un nou fill generat per la mutació
     */
    public static List<Integer> mutateChild(List<Integer> child) {
        List<Integer> mutatedChild = new ArrayList<>();

        for (int i = 0; i < CODE_LENGTH; ++i) {
            if (Math.random() < MUTATION_RATE) mutatedChild.add((int)(Math.random() * N_COLORS));
            else mutatedChild.add(child.get(i));
        }

        return mutatedChild;
    }

    /** @brief Funció que obté la puntuacio d'un codi concret
     *  
     * @param code codi a avaluar
     * @param secretCode codi a adivinar
     * 
     * @return puntuació del codi 
     */
    public static Integer evaluatePopulation(List<Integer> code, List<Integer> secretCode) {
        int correctPosition = 0;
        int correctColor = 0;

        for (int i = 0; i < CODE_LENGTH; ++i) {
            if (code.get(i).equals(secretCode.get(i))) {
                correctPosition++;
            } else {
                for (int j = 0; j < CODE_LENGTH; ++j) {
                    if (code.get(i).equals(secretCode.get(j))) {
                        correctColor++;
                        break;
                    }
                }
            }
        }

        return (correctPosition * 10) + correctColor;
    }

    /** @brief Funció que troba la maxima puntuacio de tota la poblacio
     *  
     * @param puntuacio llista de puntuacions
     * @param puntsMaxims maxima puntuacio
     * 
     * @return puntuació del codi 
     */
    public static boolean trobaPuntuacioMaxima(List<Integer> puntuacio, int puntsMaxims) {
        for (int i = 0; i < puntuacio.size(); i++) {
            if (puntuacio.get(i) == puntsMaxims) {
                return true;
            }
        }
        return false;
    }

    /** @brief Obtenció dels pegs resultant per l'últim guess
     *
     * @param current últim guess utilitzat
     * @param code codi correcte per comparar l'últim guess
     * 
     * @return result
     */
    @Override
    public String checkCode(List<Integer> current, List<Integer> code) { 
        CODE_LENGTH = code.size();
        StringBuilder result = new StringBuilder();
        boolean[] vis1 = new boolean[CODE_LENGTH];
        boolean[] vis2 = new boolean[CODE_LENGTH];
        Arrays.fill(vis1, false);
        Arrays.fill(vis2, false);
        int aux = 0;

        //Black
        for (int i = 0; i < CODE_LENGTH; ++i) {
            if (current.get(i).equals(code.get(i))) {
                result.append("B");
                vis1[i] = true;
                vis2[i] = true;
                ++aux;
            }
        }

        //White
        for (int i = 0; i < CODE_LENGTH; ++i) {
            boolean trobat = false; 
            if (!vis1[i]) {
                for (int j = 0; j < CODE_LENGTH; ++j) {
                    if (!vis2[j] && !trobat) {
                        if (current.get(i).equals(code.get(j))) {
                            result.append("W");
                            vis1[i] = true;
                            vis2[j] = true;
                            trobat = true;
                            ++aux;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < CODE_LENGTH-aux; ++i) {
            result.append("_");
        }
        return result.toString();
    }

    /** @brief Afegir la combinació resultant de la iteració x
     *
     * @param combination llistat de combinacions
     */
	public static List<Integer> addCombinations(Integer[] combination) {
        List<Integer> help = new ArrayList<>();
        for (int h = 0; h < combination.length; ++h) {
            help.add(combination[h]);
        }

        return help;
    }

    /** @brief Generació de les combinacions
     *
     * @param i iterador del backtracking
     * @param combination llistat de combinacions
     * @param visited array de visitats del backtracking
     * @param repetits indica si hi ha repetits o no a la combinació
     */
	public static void backtrackingElse(int i, Integer[] combination, boolean[] visited, int repetits) {
        if (repetits == 1) {
            for (int j = 0; j < colors.length; ++j) {
                if (!visited[j]) {
                    combination[i] = colors[j];
                    visited[j] = true;
                    backtrackingCombinations(i + 1, combination, visited, repetits);
                    combination[i] = -1;
                    visited[j] = false;
                }
            }
        } else {
            for (int j = 0; j < colors.length; ++j) {
                combination[i] = colors[j];
                backtrackingCombinations(i + 1, combination, visited, repetits);
                combination[i] = -1;
            }
        }
    }

    /** @brief Generació de les combinacions
     *
     * @param i iterador del backtracking
     * @param combination llistat de combinacions
     * @param visited array de visitats del backtracking
     * @param repetits indica si hi ha repetits o no a la combinació
     */
    public static void backtrackingCombinations(int i, Integer[] combination, boolean[] visited, int repetits) {
        if (i == combination.length) {
            List<Integer> help = addCombinations(combination);
            combinations.add(help);
        } else {
            backtrackingElse(i, combination, visited, repetits);
        }
    }

    /** @brief Generació d'un moviment aleatori
     *
     * @return combinació random
     */
	public static List<Integer> randomMove() {
        int i = (int)(Math.random() * combinations.size());
        return combinations.get(i);
    }

	/** @brief Getter del pegsResult
     *
     * @return pegsResult
     */
    @Override
    public List<String> getPegsResult() {
        return pegsAux;
    }

    /** @brief Getter del codis resultants
     *
     * @return guessesAux
     */
    @Override
    public List<List<Integer>> getCodsResult() {
        return guessesAux;
    }	
}

/*
- explicar l'acces a llista que és constant*/