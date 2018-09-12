/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.sort;


import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author murilo.goedert
 */
public class PairMap {

    private Map<String, int[][]> map = new HashMap<String, int[][]>();

    private void put(String ClassName, int[][] data) {
        this.map.put(ClassName, data);
    }
    
    private void getAll(){
    
    }

}
