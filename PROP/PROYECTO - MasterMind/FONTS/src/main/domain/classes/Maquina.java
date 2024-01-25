package main.domain.classes;

import java.util.*;


public interface Maquina {

    // Given the solution code, the solve operation uses one of the proposed algorithms 
    //(either five guess or the genetic one) to create the list of codes that will lead 
    //to the solution. If the algorithm is unable to find the solution in less than maxSteps 
    //steps, the returned list will contain a list composed of maxSteps codes.

    List<List<Integer>> solve(List<Integer> solution);

    List<String> getPegsResult();

    List<List<Integer>> getCodsResult();

    String checkCode(List<Integer> codiActual, List<Integer> CodiResoldre);
}