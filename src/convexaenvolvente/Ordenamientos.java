/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexaenvolvente;

import java.util.Random;

/**
 *
 * @author Yue
 */
public class Ordenamientos<Item>{

    public void insertionSort(Comparable a[]){
        Item item;
        int i;
        for (int j = 1; j < a.length; j++) {
            item =(Item) a[j];
            i=j-1;
            while(i>=0 && a[i].compareTo(item)>=0){
                a[i+1]=a[i];
                i--;
            }
            a[i+1]=(Comparable) item;
        }
    }
    
    public void insertionSortInverso(Comparable a[]){
        int i;
        Item item;
        for (int j = 1; j < a.length; j++) {
            item= (Item) a[j];
            i=j-1;
            while(i>=0 && a[i].compareTo(item)<0){
                a[i+1]=a[i];
                i--;
            }
            a[i+1]=(Comparable) item;
        }
    }
    
    public void selectionSort(Comparable array[]){
        Item item,tmp;
        int i;
        for (int j = 0; j < array.length; j++) {
            i=j;
            for (int k = j+1; k < array.length; k++) {
                if(array[i].compareTo(array[k])>0){
                    i=k;
                }
            }
            if(i!=j){
                tmp=(Item)array[i];
                array[i]=array[j];
                array[j]=(Comparable) tmp;
            }
        }
    }
    
    public void selectionSortInvertido(Comparable array[]){
        Item item,tmp;
        int i;
        for (int j = 0; j < array.length; j++) {
            i=j;
            for (int k = j+1; k < array.length; k++) {
                if(array[i].compareTo(array[k])>0){
                    i=k;
                }
            }
            if(i!=j){
                tmp=(Item)array[i];
                array[i]=array[j];
                array[j]=(Comparable) tmp;
            }
        }
    }
    
    public void bubbleSort(Comparable array[]){
        Comparable tmp;
        for (int i = 2; i < array.length; i++) {
            for (int j = 0; j <= array.length-i; j++) {
                if(array[j].compareTo(array[j+1])>0){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=(Comparable)tmp;
                }
            }
        }
    }
    
    public void shellSort(Comparable[] array){
        int gap=5;
        Comparable tmp;
        while(gap>0){
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j>=gap && array[j].compareTo(array[j-gap])<0; j-=gap) {
                    tmp=array[j];
                    array[j]=array[j-gap];
                    array[j-gap]=   tmp;
                }
            }
            gap/=2;
        }
    }
    
     public void bubbleSortInvertido(Comparable array[]){
        Item tmp;
        for (int i = 2; i < array.length; i++) {
            for (int j = 0; j <= array.length-i; j++) {
                if(array[j].compareTo(array[j+1])<0){
                    tmp=(Item) array[j];
                    array[j]=array[j+1];
                    array[j+1]=(Comparable)tmp;
                }
            }
        }
    }
     
    public Comparable[] quickSort(Comparable[] array, int inf, int sup){ //No Terminado
        int i,j,p;
        i=inf;
        j=sup;
        if(inf>=sup)
            return array;
        while(i!=j){
            
        }
        return array;
    }
    
    public Item[] shufllingSort(Item[] array){
        Random rnd=new Random();
        Item tmp;
        int r;
        for (int i = 0; i < array.length; i++) {
            r=rnd.nextInt(i+1);
            tmp= array[r];
            array[r]=array[i];
            array[i]=tmp;
        }
        return array;
    }
    
    public void mergeSort(Comparable[] A){
        Comparable[] aux= new Comparable[A.length];  //Generas un arreglo Auxiliar.
        sort(A,aux,0,A.length-1); //Al terminar la recursión de Sort muere Aux, mientras sigue siendo el mismo.
    }
    public void sort(Comparable []A, Comparable []aux, int low, int hi){
        if(hi<=low)
            return; //Termina la recursión
        int mid= low +(hi-low)/2; //Sort no los acomoda como dice su nombre. Sort los Separa.
        sort(A,aux, low, mid);
        sort(A, aux, mid+1, hi);
        merge(A, aux, low, mid, hi);
    }
    
    public void merge(Comparable []A, Comparable []aux, int low, int mid, int hi){
        for(int k=low; k<=hi;k++)
            aux[k]=A[k];
        int i=low;
        int j=mid+1;
        for(int k=low; k<=hi; k++){
            if(i>mid)
                A[k]=aux[j++];
            else  if(j>hi)
                A[k]=aux[i++];
            else if(aux[i].compareTo(aux[j])<0)
              A[k]=aux[i++];
            else
              A[k]=aux[j++];
        }
    }
    
    public static void main(String[] args) {
        Ordenamientos ss=new Ordenamientos<Integer>();
        Integer[] in={5,1,2,10,2,4,3,3};
        ss.mergeSort(in);
        for (Integer in1 : in) {
            System.out.println(in1);
        }
    }
}
