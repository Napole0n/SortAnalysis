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
public class SelectionSort implements Sorter {

    private int comparationCount;
    private int loopCount;
    private long executionTime;
    private int changesCount;

    @Override
    public int getLoopsCount() {
        return loopCount;
    }

    @Override
    public int getComparationsCount() {
        return comparationCount;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    @Override
    public int[] sort(int[] vetor) {

        long tempoInicial = System.currentTimeMillis();
        int menor, aux, cont_troca = 0, cont_loop = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            menor = i;
            aux = vetor[i];
            cont_loop++;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < aux) {
                    menor = j;
                    aux = vetor[j];
                    cont_troca++;
                }
                cont_loop++;
            }
            vetor[menor] = vetor[i];
            vetor[i] = aux;
            cont_loop++;

        }

        long tempoFinal = System.currentTimeMillis();
        this.executionTime = tempoFinal - tempoInicial;
        this.loopCount = cont_loop;
        this.comparationCount = cont_troca;

        return vetor;

    }

    @Override
    public String toString() {
        return "SelectionSort{" + "loopCount=" + loopCount + ", comparationCount=" + comparationCount + ", executionTime=" + executionTime + '}';
    }

    @Override
    public long getChangesCount() {
        return this.changesCount;
    }

}
