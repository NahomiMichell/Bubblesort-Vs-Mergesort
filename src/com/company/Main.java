package com.company;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        int[] arreglo = new int[7500000];
       // long in = System.System,currentTimeMillis();
        Random R = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = R.nextInt();
        }
        //long fi = System.currentTimeMillis() ;
        //System.out.println("el tiempo de ejecucuion del for es:"+ ((fi-in)/1000.0)+"segundos");

        long go = System.currentTimeMillis();
        bubbleSort(arreglo);
        long time = System.currentTimeMillis();
        System.out.println("El tiempo de ejecucuión del bubble sort es: "+ (( time - go ) / 1000.0)+"segundos");


        long inicio = System.currentTimeMillis();
        mergeSort(arreglo);
        long fin = System.currentTimeMillis();
        System.out.println("El tiempo de ejecución del merger sort es: " + (( fin - inicio) / 1000.0)+"segundos");

    }


    public static int[] bubbleSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]< arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public  static int[] mergeSort(int[] arr){

        if(arr.length <= 1){
            return arr;
        }

        int medio = arr.length /2;
        int[] inferior = new int[medio];
        int[] superior = new int[arr.length - medio];

        for (int i = 0; i < medio; i++) {
            inferior[i] = arr[i];
        }

        for (int i = 0; i < superior.length ; i++) {
            superior[i] = arr[i + inferior.length];
        }
        return  merge(mergeSort(inferior), mergeSort(superior));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0, j = 0, k = 0;

        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }
        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }

        return retval;
    }

}
