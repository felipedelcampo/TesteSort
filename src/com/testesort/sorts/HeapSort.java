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
 * Implementação de HeapSort baseada diretamente no pseudo código do "Algoritmo Teoria e Prática"
 * 
 */
public class HeapSort {

    private HeapSort() {
        throw new AssertionError();
    }

    private static Integer right(Integer i){
        return 2*i+2;
    }

    private static Integer left(Integer i){
        return 2*i+1;
    }

    private static <E extends Comparable<? super E>> void maxHeapfy(List<E> heap, Integer i, Integer o) {

        Integer filhoEsquerdo = left(i);
        Integer filhoDireito = right(i);
        Integer maior;

        maior = ((filhoEsquerdo < o) && (heap.get(filhoEsquerdo).compareTo(heap.get(i)) > 0))? filhoEsquerdo : i;
        maior = ((filhoDireito < o) && (heap.get(filhoDireito).compareTo(heap.get(maior)) > 0))? filhoDireito : maior;

        if(maior != i) {
            E temp = heap.get(maior);
            heap.set(maior, heap.get(i));
            heap.set(i, temp);
            maxHeapfy(heap, maior, o);
        }
    }

    public static <E extends Comparable<? super E>> void buildMaxHeap(List<E> arranjo) {

        Integer total = (int)Math.floor(arranjo.size()/2);

        for(Integer i=total; i >= 0; i--) {
            maxHeapfy(arranjo, i, arranjo.size());
        }
    }

    public static <E extends Comparable<? super E>> void sort(List<E> arranjo){

        buildMaxHeap(arranjo);

        for(Integer i=arranjo.size(); i > 0; i--) {
            E tmp = arranjo.get(0);
            arranjo.set(0, arranjo.get(i-1));
            arranjo.set(i-1, tmp);
            maxHeapfy(arranjo, 0, i-1);
        }

    }
}

