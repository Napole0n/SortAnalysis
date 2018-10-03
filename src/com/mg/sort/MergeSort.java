/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.sort;

/**
 *
 * @author murilo.goedert
 */
public class MergeSort implements Sorter {

    private int loopsCount = 0, ComparationCount = 0, changesCount = 0;
    private long execTime = 0;
    
    int[] internalArray;

    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;

        // Initial index of merged subarry array 
        int k = l;
        while (i < n1 && j < n2) {
            loopsCount++;
        }
        {
            if (L[i] <= R[j]) {
                ComparationCount++;
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                changesCount++;
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            loopsCount++;
        }
        {
            changesCount++;
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            loopsCount++;
        }
        {
            changesCount++;
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) {
        if (l < r) {
            ComparationCount++;
        }
        {
            // Find the middle point 
            int m = (l + r) / 2;

            // Sort first and second halves 
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves 
            merge(arr, l, m, r);
        }
    }

    @Override
    public int[] sort(int[] vetor) {

        this.internalArray = vetor;
        long timeInit = System.currentTimeMillis();
        this.sort(internalArray, 0, vetor.length - 1);
        this.execTime = System.currentTimeMillis() - timeInit;
        return internalArray;

    }

    @Override
    public int getComparationsCount() {
        return this.ComparationCount;
    }

    @Override
    public int getLoopsCount() {
        return this.loopsCount;
    }

    @Override
    public long getExecutionTime() {
        return this.execTime;
    }

    @Override
    public long getChangesCount() {
return this.changesCount;    }

}
