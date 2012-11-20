/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testesort;

import com.testesort.sorts.HeapSort;
import com.testesort.sorts.MergeSort;
import com.testesort.sorts.QuickSort;
import com.testesort.utils.Arranjo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author felipe
 * 
 * Clasee que cria os teste e salva em um HashMap com a chave sendo o nome da label na tela
 * 
 */
public class Testes {
    
    public HashMap<String, String> testaSort(Long tamanhoEntrada){
        
        Long inicio, fim;
        
        HashMap<String, String> resultados = new HashMap<>();
        
        //Cria uma cópia ordenada para comparação e validação do resultado
        List<Integer> arranjo = new ArrayList<>(Arranjo.geraArranjo(tamanhoEntrada));
        List<Integer> testeout = new ArrayList<>(arranjo);
        List<Integer> temp;
        
        inicio = System.currentTimeMillis();
        Collections.sort(testeout);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("cSRandom", fim.toString());
        
        //Testa QuickSort caso Random
        temp = new ArrayList<>(arranjo);
        inicio = System.currentTimeMillis();
        QuickSort.sort(temp);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("qSRandom",temp.equals(testeout)? fim.toString() : "-1"); //Verifica o resultado, se estiver errado manda -1
        
        //Testa QuiCkSort Melhor caso
        temp = new ArrayList<>(testeout);
        inicio = System.currentTimeMillis();
        QuickSort.melhorSort(temp);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("qSMelhor", temp.equals(testeout)? fim.toString() : "-1"); //Verifica o resultado, se estiver errado manda -1
        
        //Testa QuiCkSort Pior caso
        temp = new ArrayList<>(testeout);
        inicio = System.currentTimeMillis();
        QuickSort.sort(temp);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("qSPior", temp.equals(testeout)? fim.toString() : "-1"); //Verifica o resultado, se estiver errado manda -1
        
        //Testa HeapSort caso Random
        temp = new ArrayList<>(arranjo);
        inicio = System.currentTimeMillis();
        HeapSort.sort(temp);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("hSRandom", temp.equals(testeout)? fim.toString() : "-1"); //Verifica o resultado, se estiver errado manda -1
        
        //Testa HeapSort Melhor caso
        temp = new ArrayList<>(arranjo);
        HeapSort.buildMaxHeap(temp);
        inicio = System.currentTimeMillis();
        HeapSort.sort(temp);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("hSMelhor", temp.equals(testeout)? fim.toString() : "-1"); //Verifica o resultado, se estiver errado manda -1
        
        //Merge-Sort caso Random
        temp = new ArrayList<>(arranjo);
        inicio = System.currentTimeMillis();
        temp = MergeSort.sort(temp);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("mSRandom", temp.equals(testeout)? fim.toString() : "-1"); //Verifica o resultado, se estiver errado manda -1
        
        //Merge-Sort Melhor caso
        temp = new ArrayList<>(testeout);
        inicio = System.currentTimeMillis();
        temp = MergeSort.sort(temp);
        fim = (System.currentTimeMillis() - inicio);
        resultados.put("mSMelhor", temp.equals(testeout)? fim.toString() : "-1"); //Verifica o resultado, se estiver errado manda -1
                
        return resultados;
    }
    
    
}
