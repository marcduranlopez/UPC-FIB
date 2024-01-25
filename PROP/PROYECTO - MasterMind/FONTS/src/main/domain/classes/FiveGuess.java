package main.domain.classes;

import java.util.*;

public class FiveGuess implements Maquina {

    /**
     * Representa la mida en dificultat facil
     */
	static final Integer TAMANY_DIFICULTAT_FACIL = 4;

    /**
     * Representa la mida en dificultat mitjana
     */
    static final Integer TAMANY_DIFICULTAT_MITJA = 5;

    /**
     * Representa la mida en dificultat dificil
     */
    static final Integer TAMANY_DIFICULTAT_DIFICIL = 6;

    /**
     * Representa la quantitat maxima de torns
     */
    static final Integer MAX_TORNS = 10;

    /**
     * Representa la mida i dificultat del codi
     */
    static Integer mida;

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
     * Conté tots els candidats restants per escollir
     */
    static List<List<Integer>> candidates = new ArrayList<>();

    /**
     * Conté les combinacions a comparar amb els candidats
     */
    static List<List<Integer>> nextGuesses = new ArrayList<>();

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
        mida = codi.size();
        int repetits = 0;
        int turn = 1;
        
        boolean[] visited = new boolean[colors.length];
        Arrays.fill(visited, false);

        combinations.clear();
        candidates.clear();
        backtrackingCombinations(0, new Integer[mida], visited, repetits);
        
        code = codi;
        List<Integer> current = randomMove();

        boolean won = false;
        String pegs;
        if (mida.equals(TAMANY_DIFICULTAT_FACIL)) pegs = "BBBB";
        else if (mida.equals(TAMANY_DIFICULTAT_MITJA)) pegs = "BBBBB";
        else if (mida.equals(TAMANY_DIFICULTAT_DIFICIL)) pegs = "BBBBBB";

        while(!won && turn <= MAX_TORNS) {
            if (candidates.size() == 1) {
                current = candidates.get(0);
            }

            removeCode(current);
            
            pegs = checkCode(current, code);
            pegsResult.add(pegs);

            if ((pegs.equals("BBBB") && mida.equals(TAMANY_DIFICULTAT_FACIL)) || (pegs.equals("BBBBB") && mida.equals(TAMANY_DIFICULTAT_MITJA)) ||
            (pegs.equals("BBBBBB") && mida.equals(TAMANY_DIFICULTAT_DIFICIL))) won = true;

            guessesResult.add(current);

            pruneCandidates(current, pegs);
            
            nextGuesses = findMinMax();
            
            current = newGuess();

            ++turn;
        }
        
        pegsAux = pegsResult;
        guessesAux = guessesResult;
        return guessesResult;
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
            candidates.add(help);
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

    /** @brief Eliminació d'una combinació utilitzada
     *
     * @param c combinació a eliminar
     */
    public static void removeCode(List<Integer> c) {
        Iterator<List<Integer>> it = candidates.iterator();
        while (it.hasNext()) {
            List<Integer> aux = it.next();
            if (c.equals(aux)) it.remove();
        }

        Iterator<List<Integer>> it2 = combinations.iterator();
        while (it2.hasNext()) {
            List<Integer> aux = it2.next();
            if (c.equals(aux)) it2.remove();
        }
    }

    /** @brief Eliminació dels candidats amb pegs diferent de l'últim guess
     *
     * @param current últim guess utilitzat
     * @param pegs pegs resultants decurrent
     */
    public void pruneCandidates(List<Integer> current, String pegs) {
        Iterator<List<Integer>> it = candidates.iterator();
        int index;

        while (it.hasNext()) {
            index = new ArrayList<>(candidates).indexOf(it.next());
            List<Integer> code = candidates.get(index);
            String response = checkCode(current, code);
            if (!response.equals(pegs)) {
                it.remove();
            }
        }

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
        mida = code.size();
        StringBuilder result = new StringBuilder();
        boolean[] vis1 = new boolean[mida];
        boolean[] vis2 = new boolean[mida];
        Arrays.fill(vis1, false);
        Arrays.fill(vis2, false);
        int aux = 0;

        //Black
        for (int i = 0; i < mida; ++i) {
            if (current.get(i).equals(code.get(i))) {
                result.append("B");
                vis1[i] = true;
                vis2[i] = true;
                ++aux;
            }
        }

        //White
        for (int i = 0; i < mida; ++i) {
            boolean trobat = false; 
            if (!vis1[i]) {
                for (int j = 0; j < mida; ++j) {
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

        for (int i = 0; i < mida-aux; ++i) {
            result.append("_");
        }
        return result.toString();
    }

    /** @brief Obtenció dels millors possibles guesses
     *
     * @return nextG
     */
    public List<List<Integer>> findMinMax() {
        Map<String, Integer> scoreCount = new HashMap<>();
        Map<List<Integer>, Integer> score = new HashMap<>();
        List<List<Integer>> nextG = new ArrayList<>();
        int maxScore, minScore;

        for (int i = 0; combinations.size() < 1; ++i) {
            for (int j = 0; j < candidates.size(); ++j) {
                String iForPegs = checkCode(combinations.get(i), candidates.get(j));
                if (scoreCount.containsKey(iForPegs)) {
                    scoreCount.put(iForPegs, scoreCount.get(iForPegs) + 1);
                } else {
                    scoreCount.put(iForPegs, 1); 
                }
            }

            maxScore = getMaxScore(scoreCount); 
            score.put(combinations.get(i), maxScore);
            scoreCount.clear();
        }

        minScore = getMinScore(score);

        for (List<Integer> key : score.keySet()) {
            Integer value = score.get(key);
            if (value < minScore) nextG.add(key);
        }

        return nextG;
    }

    /** @brief Obtenció de la màxima puntuació
     *
     * @param scoreCount llistat de puntuacions
     * 
     * @return max
     */
    public static int getMaxScore(Map<String, Integer> scoreCount) {
        int max = 0;
        for (String key : scoreCount.keySet()) {
            Integer value = scoreCount.get(key);
            if (value > max) max = value;
        }

        return max;
    }

    /** @brief Obtenció de la mínima puntuació
     *
     * @param score cap de tots els màxims scores
     * 
     * @return min
     */
    public static int getMinScore(Map<List<Integer>, Integer> score) {
        int min = Integer.MAX_VALUE;
        for (List<Integer> key : score.keySet()) {
            Integer value = score.get(key);
            if (value < min) min = value;
        }

        return min;
    }

    /** @brief Obtenció d'una combinació resultant del minmax
     *
     * @return aux
     */
    public static List<Integer> newGuess() {
        List<Integer> aux = randomMove();

        for (int i = 0; i < nextGuesses.size(); ++i) {
            for (int j = 0; j < candidates.size(); ++j) {
                if (nextGuesses.get(i).equals(candidates.get(j))) {
                    aux = nextGuesses.get(i);
                    break;
                }
            }
        }

        for (int i = 0; i < nextGuesses.size(); ++i) {
            for (int j = 0; j < combinations.size(); ++j) {
                if (nextGuesses.get(i).equals(combinations.get(j))) {
                    aux = nextGuesses.get(i);
                    break;
                }
            }
        }

        return aux;
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