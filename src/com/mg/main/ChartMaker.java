/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.main;

import com.mg.sort.SortAnalyser;
import com.mg.sort.Sorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.LegendPosition;

/**
 *
 * @author murilo.goedert
 */
public class ChartMaker implements ExampleChart<CategoryChart> {

    List<Integer> xData;
    List<Integer> yData;
    SortAnalyser analyser;
    CHART_PARAMETER param;

    public ChartMaker(SortAnalyser an, CHART_PARAMETER param) {
        this.analyser = an;
        this.param = param;
    }

    public ChartMaker() {
    }

    @Override
    public CategoryChart getChart() {

        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setPlotGridLinesVisible(false);
        chart.setXAxisTitle("Teste");
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < analyser.getSorters().size(); i++) {
            list.clear();
            Sorter s = analyser.getSorters().get(i);

            if (null == param) {
                list.add(s.getLoopsCount());
            } else {
                switch (param) {
                    case COMPARATION_COUNT:
                        list.add(s.getComparationsCount());
                        break;
                    case EXECUTION_TIME:
                        list.add((int) s.getExecutionTime());
                        break;
                    case LOOP_COUNT:
                        list.add(s.getLoopsCount());
                    default:
                        list.add(s.getLoopsCount());
                        break;
                }
            }

           

            chart.addSeries(s.getClass().getTypeName(),Arrays.asList(1,2,3,4,5),list2);
        }

        return chart;

    }

    public enum CHART_PARAMETER {
        LOOP_COUNT,
        COMPARATION_COUNT,
        EXECUTION_TIME,
    }

}
