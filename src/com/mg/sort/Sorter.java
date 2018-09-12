/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.sort;

import java.util.List;

/**
 *
 * @author murilo.goedert
 */
public interface Sorter {

    public int[] sort(int[] vetor);

    public int getComparationsCount();

    public int getLoopsCount();

    public long getExecutionTime();

}
