/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexaenvolvente;

import java.util.EmptyStackException;

/**
 *
 * @author Yue
 */
public class StackListaLigadaGeneralizado<Item>{
    private Nodo head;
    private int i;
    
    private class Nodo{
        Item item;
        Nodo next;
    }

    public StackListaLigadaGeneralizado(StackListaLigadaGeneralizado s) { //Constructor copia
        this.head=s.head;
    }
    
    public StackListaLigadaGeneralizado(){
        head=null;
        i=0;
    }
    
    public void push(Item item){
        Nodo oldNodo=head;
        head=new Nodo();
        head.item=item;
        head.next=oldNodo;
        i++;
    }
    
    public Item pop() throws EmptyStackException{
        if(head==null)
            throw new EmptyStackException();
        Item item=head.item;
        head=head.next;
        i--;
        return item;
    }
    
    public Item top() throws EmptyStackException{
        if(head==null)
            throw new EmptyStackException();
        return head.item;
    }
    
    public void showLista(){
        Nodo tmp=head;
        System.out.print("[");
        while(tmp!=null){
            System.out.print(tmp.item+", ");
            tmp=tmp.next;
        }
        System.out.print("]");
    }
    
    public int getTamano(){
        return i;
    }
}
