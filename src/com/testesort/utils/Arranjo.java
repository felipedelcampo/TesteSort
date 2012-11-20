/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testesort.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author felipe
 * 
 * Classe utilitária para criação do arranjo randômico
 * 
 */
public class Arranjo {

    private Arranjo(){
        throw new AssertionError();
    }

    public static List<Integer> geraArranjo(long tamanho){
        Random random = new Random();
        List<Integer> temp = new ArrayList<>();
        for(long i=0; i<tamanho; i++){
            temp.add(random.nextInt(1000));
        }
        return temp;
    }
    
    public static List<Integer> preparaPiorMerge(List<Integer> arranjo) {
        Collections.sort(arranjo);
        Collections.reverse(arranjo);
        List<Integer> retorno = new ArrayList<>();
        for(Integer i=0; i<arranjo.size(); i++) {
            if(i%2 == 0){
                retorno.add(arranjo.get(i));
            }
        }
        for(Integer i=0; i<arranjo.size(); i++) {
            if(i%2 != 0) {
                retorno.add(arranjo.get(i));
            }
        }
        return retorno;
    }
}
