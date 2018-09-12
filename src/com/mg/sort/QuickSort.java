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
public class QuickSort implements Sorter {

    int loops = 0, trocas = 0;
    long time = 0;

    @Override
    public int getLoopsCount() {
        return loops;
    }

    @Override
    public int getComparationsCount() {
        return trocas;
    }

    @Override
    public long getExecutionTime() {
        return this.time;
    }

    public int[] sort(int[] vetor, int inicio, int fim) {

        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            sort(vetor, inicio, posicaoPivo - 1);
            sort(vetor, posicaoPivo + 1, fim);
            loops++;
        }

        return vetor;
    }

    private int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                trocas++;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    @Override
    public int[] sort(int[] vec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
