/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testesort.sorts;

import java.util.List;

/**
 *
 * @author felipe
 *
 * Implementação de QuickSort baseada na implementação de "C the Complete
 * Reference"
 *
 */
public class QuickSort {

    private QuickSort() {
        throw new AssertionError();
    }

    public static <E extends Comparable<? super E>> void sort(List<E> arranjo) {
        quickSort(arranjo, 0, arranjo.size() - 1);
    }

    private static <E extends Comparable<? super E>> void quickSort(List<E> arranjo, Integer inicio, Integer fim) {

        // Escolhido o pivo conforme pseudo códig do Cormen
        E pivo = arranjo.get(fim);

        Integer esquerda = inicio;
        Integer direita = fim;

        while (esquerda <= direita) {

            while ((arranjo.get(esquerda).compareTo(pivo) < 0) && (esquerda < fim)) {
                esquerda++;
            }

            while ((arranjo.get(direita).compareTo(pivo) > 0) && (direita > inicio)) {
                direita--;
            }

            if (esquerda <= direita) {
                E tmp = arranjo.get(direita);
                arranjo.set(direita, arranjo.get(esquerda));
                arranjo.set(esquerda, tmp);
                esquerda++;
                direita--;
            }
        }
        if (inicio < direita) {
            quickSort(arranjo, inicio, direita);
        }
        if (esquerda < fim) {
            quickSort(arranjo, esquerda, fim);
        }

    }
    
    //Segunda implementação para simular melhor caso
    public static <E extends Comparable<? super E>> void melhorSort(List<E> arranjo) {
        quickSort2(arranjo, 0, arranjo.size() - 1);
    }
    
    private static <E extends Comparable<? super E>> void quickSort2(List<E> arranjo, Integer inicio, Integer fim) {

        // Escolhido o pivo para cair no melehor caso quando arranjo estiver ordenado
        E pivo = arranjo.get((inicio + fim) / 2);

        Integer esquerda = inicio;
        Integer direita = fim;

        while (esquerda <= direita) {

            while ((arranjo.get(esquerda).compareTo(pivo) < 0) && (esquerda < fim)) {
                esquerda++;
            }

            while ((arranjo.get(direita).compareTo(pivo) > 0) && (direita > inicio)) {
                direita--;
            }

            if (esquerda <= direita) {
                E tmp = arranjo.get(direita);
                arranjo.set(direita, arranjo.get(esquerda));
                arranjo.set(esquerda, tmp);
                esquerda++;
                direita--;
            }
        }
        if (inicio < direita) {
            quickSort2(arranjo, inicio, direita);
        }
        if (esquerda < fim) {
            quickSort2(arranjo, esquerda, fim);
        }

    }
}
