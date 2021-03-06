/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.main;

import com.mg.chart.ChartMaker;
import com.mg.sort.BubbleSort;
import com.mg.sort.InsertionSort;
import com.mg.sort.MergeSort;
import com.mg.sort.QuickSort;
import com.mg.sort.SelectionSort;
import com.mg.sort.SortAnalyser;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;

/**
 *
 * @author murilo.goedert
 */
public class Testes {

    public static void main(String[] args) {

        SortAnalyser an = new SortAnalyser();
        BubbleSort sort = new BubbleSort();
        SelectionSort ss = new SelectionSort();
        InsertionSort ds = new InsertionSort();
        QuickSort qsort = new QuickSort();
        MergeSort mgSort = new MergeSort();
        an.addSorter(sort);
        an.addSorter(ss);
        an.addSorter(ds);
        an.addSorter(qsort);
       // an.addSorter(mgSort);
        an.analize(10000, 10000);

        ExampleChart<CategoryChart> exampleChart = new ChartMaker(an);
        CategoryChart chart = exampleChart.getChart();
        new SwingWrapper<>(chart).displayChart();

    }

}
