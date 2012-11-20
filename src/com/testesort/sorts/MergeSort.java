/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testesort.sorts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author felipe
 * 
 * Implemetação do Merge-Sorte baseada no pseudo código do livro, com uso de subLists
 * 
 */
public class MergeSort {

    private MergeSort() {
        throw new AssertionError();
    }

    public static <E extends Comparable<? super E>> List<E> sort(List<E> arranjo) {
        if (arranjo.size() <= 1) {
            return arranjo;
        }

        int meio = arranjo.size() / 2;
        // Cria referência a subLists
        List<E> left = arranjo.subList(0, meio);
        List<E> right = arranjo.subList(meio, arranjo.size());

        right = sort(right);
        left = sort(left);
        //Manda referências de subLists no lugar dos índices
        List<E> result = merge(left, right);

        return result;
    }

    private static <E extends Comparable<? super E>> List<E> merge(List<E> subArranjoEsquerdo, List<E> subArranjoDireito) {
        
        List<E> result = new ArrayList<>();
        Iterator<E> it1 = subArranjoEsquerdo.iterator();
        Iterator<E> it2 = subArranjoDireito.iterator();

        E x = it1.next();
        E y = it2.next();
        while (true) {
            
            if (x.compareTo(y) <= 0) {
                result.add(x);
                if (it1.hasNext()) {
                    x = it1.next();
                } else {
                    result.add(y);
                    while (it2.hasNext()) {
                        result.add(it2.next());
                    }
                    break;
                }
            } else {
                result.add(y);
                if (it2.hasNext()) {
                    y = it2.next();
                } else {
                    result.add(x);
                    while (it1.hasNext()) {
                        result.add(it1.next());
                    }
                    break;
                }
            }
        }
        return result;
    }
}
