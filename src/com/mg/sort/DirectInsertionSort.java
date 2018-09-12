/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.sort;

/**
 *
 * @author alunos
 */
public class DirectInsertionSort implements Sorter {

    private int comparationCount = 0;
    private int loopCount = 0;
    private long executionTime = 0;

    @Override
    public int getLoopsCount() {
        return this.loopCount;
    }

    @Override
    public int getComparationsCount() {
        return this.comparationCount;
    }

    @Override
    public long getExecutionTime() {
        return this.executionTime;
    }

    @Override
    public int[] sort(int[] vetor) {
        long init = System.currentTimeMillis();

        for (int i = 1; i < vetor.length; i++) {
            loopCount++;

            int aux = vetor[i];
            int j = i;

            while ((j > 0) && (vetor[j - 1] > aux)) {
                vetor[j] = vetor[j - 1];
                comparationCount++;
                loopCount++;
                j -= 1;
                
            }
            vetor[j] = aux;
        }
        this.executionTime = System.currentTimeMillis() - init;
        return vetor;
    }
    
    @Override
    public String toString() {
        return "DirectInsertionSort{" + "loopCount=" + loopCount + ", comparationCount=" + comparationCount + ", executionTime=" + executionTime + '}';
    }

}
