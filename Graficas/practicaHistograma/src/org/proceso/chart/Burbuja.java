/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proceso.chart;

/**
 *
 * @author Ruben
 */
public class Burbuja {
   
    private int [] conjunto;
    private int [] conjunto2={3,5,1,2,7,4,8,0,9,6};
    
    public Burbuja(int[] conjunto){
        this.conjunto=conjunto2;
    }   
    public void Ordenar (){
        int aux=0;
        for(int i=0;i<this.conjunto2.length; i++){
            for(int j=1;j<this.conjunto2.length;j++){
                if (conjunto2[j-1]>conjunto2[j]){
                    aux=conjunto2[j];
                    conjunto2[j]=conjunto2[j-1];
                    conjunto2[j-1]=aux;
                    
                }
            }
                
        }
    }
    public int [] getConjunto(){
        return this.conjunto2;
    }
    
    
}
