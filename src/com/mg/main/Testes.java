/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.main;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.area.AreaChart01;

/**
 *
 * @author murilo.goedert
 */
public class Testes {

    public static void main(String[] args) {
        ExampleChart<XYChart> exampleChart = new ChartMaker();
        XYChart chart = exampleChart.getChart();
        new SwingWrapper<XYChart>(chart).displayChart();
    }

}
