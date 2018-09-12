/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.main;

import com.mg.sort.SortAnalyser;
import com.mg.sort.Sorter;
import java.util.List;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.ChartTheme;

/**
 *
 * @author murilo.goedert
 */
public class ChartMaker implements ExampleChart<XYChart> {

    List<Integer> xData;
    List<Integer> yData;
    SortAnalyser analyser;

    public ChartMaker(SortAnalyser an) {
        this.analyser = an;
    }
    
    public ChartMaker(){}

    @Override
    public XYChart getChart() {

        XYChart chart = new XYChartBuilder().width(800).height(600).theme(ChartTheme.Matlab).title("Matlab Theme").xAxisTitle("X").yAxisTitle("Y").build();

        chart.getStyler().setPlotGridLinesVisible(false);
        chart.getStyler().setXAxisTickMarkSpacingHint(100);
        
        for(Sorter s : analyser.getSorters()){
           chart.addSeries(s.getClass().getSimpleName(), new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
        }

        return chart;

   }

}
