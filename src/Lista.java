/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LSA
 */

//LISTA DUPLAMENTE LIGADA NÃO-CIRCULAR 
public class Lista {

    No cabeca;

    public Lista() {
        cabeca = null;
    }

    void removerLista(Lista L, No x) {
        if (x.ant != null) {
            x.ant.prox = x.prox;

        } else {
            L.cabeca = x.prox;
        }
    }

    void addLista(Lista L, No x) {
        x.prox = L.cabeca;
        if (L.cabeca != null) {
            L.cabeca.ant = x;

        }
        L.cabeca = x;
        x.ant = null;
    }

    No buscar(Lista L, int chave) {
        No x = L.cabeca;
        while (x != null && x.chave != chave) {

            x = x.prox;
        }
        return x;
    }
    
    void printLista( Lista L){
      No x = L.cabeca;
      while(x != null){
      System.out.print(x.chave +" ");
      x = x.prox;
      }
     System.out.println();
    }
    
   
     void printSubList(Lista L) {
        No x = L.cabeca;
        NoSLC e = new NoSLC();

       
        while (x != null) {
            e = x.subList.prim;
            for (int i = 0; i < x.getSubList().cont; i++) {
                System.out.print(e.chave + " ");
                e = e.prx;
            }

            System.out.println();

            x = x.prox;
            
        }

    }
    
   
}
