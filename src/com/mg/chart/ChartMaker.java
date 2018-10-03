/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.chart;

import com.mg.sort.SortAnalyser;
import com.mg.sort.Sorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.Theme;

/**
 *
 * @author murilo.goedert
 */
public class ChartMaker implements ExampleChart<CategoryChart> {

    List<Integer> xData;
    List<Integer> yData;
    SortAnalyser analyser;

    public ChartMaker(SortAnalyser an) {
        this.analyser = an;

    }

    public ChartMaker() {
    }

    @Override
    public CategoryChart getChart() {

        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Desempenho de Algoritmos").xAxisTitle("Score").yAxisTitle("Number").build();

        chart.getStyler().setLegendPosition(LegendPosition.OutsideE);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setPlotGridLinesVisible(false);
        chart.getStyler().setDefaultSeriesRenderStyle(CategorySeries.CategorySeriesRenderStyle.Bar).setAvailableSpaceFill(0.9d).setLegendLayout(Styler.LegendLayout.Vertical);
        chart.setYAxisTitle("Contagem ( x 1000 )");
        chart.setXAxisTitle("");

        List<String> listStr;
        List<Integer> listInt;

        for (int i = 0; i < analyser.getSorters().size(); i++) {

            listStr = new ArrayList<>();
            listInt = new ArrayList<>();

            Sorter s = analyser.getSorters().get(i);

            listStr.add("LoopCount");
            listStr.add("ComparationCount");
            listStr.add("ChangesCount");
            listStr.add("ExecutionTime (ms)");

            if ((s.getLoopsCount() / 1000) < 0) {
                listInt.add((s.getLoopsCount() / 1000) * (-1));
            } else {
                listInt.add(s.getLoopsCount() / 1000);
            }

            if ((s.getComparationsCount() / 1000) < 0) {
                listInt.add((s.getComparationsCount() / 1000) * (-1));
            } else {
                listInt.add(s.getComparationsCount() / 1000);
            }

            if ((s.getChangesCount()/ 1000) < 0) {
                listInt.add(((int)s.getChangesCount()/ 1000) * (-1));
            } else {
                listInt.add((int)s.getChangesCount() / 1000);
            }
            listInt.add((int) s.getExecutionTime());

            System.out.println(Arrays.toString(listInt.toArray()));
            System.out.println(Arrays.toString(listStr.toArray()));

            chart.addSeries(s.getClass().getCanonicalName(), listStr, listInt);
        }

        chart.getStyler().setPlotGridHorizontalLinesVisible(true);

        return chart;

    }

}
