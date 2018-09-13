/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.main;

import com.mg.sort.BubbleSort;
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
        an.addSorter(sort);
         an.addSorter(ss);
        an.analize(1000,1000);
        
        ExampleChart<CategoryChart> exampleChart = new ChartMaker(an, ChartMaker.CHART_PARAMETER.EXECUTION_TIME);
        CategoryChart chart = exampleChart.getChart();
        new SwingWrapper<>(chart).displayChart();
        
    }
    
}
