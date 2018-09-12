/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.sort;

/**
 *
 * @author murilo.goedert
 */
public class BubbleSort implements Sorter {

    private int loopCount = 0;
    private int comparationCount = 0;
    private long executionTime = 0;

    @Override
    public int[] sort(int[] vetor) {
        long begin = System.currentTimeMillis();

        for (int i = vetor.length; i >= 1; i--) {
            loopCount++;
            for (int j = 1; j < i; j++) {
                loopCount++;
                comparationCount++;
                if (vetor[j - 1] > vetor[j]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }
        executionTime = System.currentTimeMillis() - begin;
        return vetor;

    }

    @Override
    public int getComparationsCount() {
        return comparationCount;
    }

    @Override
    public int getLoopsCount() {
        return loopCount;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return "BubbleSort{" + "loopCount=" + loopCount + ", comparationCount=" + comparationCount + ", executionTime=" + executionTime + '}';
    }

}
