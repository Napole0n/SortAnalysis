/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author murilo.goedert
 */
public class SortAnalyser {

    private List<Sorter> sorters = new ArrayList<>();
    int[] data;
   
    public SortAnalyser(List<Sorter> sorterList) {
        this.sorters = sorterList;
    }

    public List<Sorter> getSorters() {
        return sorters;
    }

    public void setSorters(List<Sorter> sorters) {
        this.sorters = sorters;
    }
    
    

    public SortAnalyser() {
    }

    public void addSorter(Sorter s) {
        this.sorters.add(s);
    }

    private void fillData(int size, int range) {

        data = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = r.nextInt(range);
        }

    }

    public List<String> analize(int vetorSize, int randomRange) {

        List<String> reports = new ArrayList<>();
        

        sorters.stream().map((s) -> {
            fillData(vetorSize, randomRange);
            s.sort(data);
            return s;
        }).forEachOrdered((s) -> {
            reports.add(s.toString());
        });
        return reports;
    }
    
    

}
