/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LSA
 */
public class Pilha {

    String[] pilha;
    int topo;

    public Pilha(int tamanho) {

        this.pilha = new String[tamanho];
        this.topo = -1;
    }

    public boolean pilhaVazia() {

        if (this.topo == -1) {
            return true;
        }
        return false;
    }
    
     public boolean pilhaCheia() {

        if (this.topo == pilha.length) {
            return true;
        }
        return false;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public void push(String elemento) {

        if (this.topo < this.pilha.length - 1) {
            this.pilha[++topo] = elemento;
        }
    }

    public String pop() {

        if (pilhaVazia()) {
            return null;
        }
        return this.pilha[this.topo--];
    }
    public String top() {
        
        if (this.pilhaVazia()) {
            return null;
        }
        return this.pilha[this.topo];
    }

}
