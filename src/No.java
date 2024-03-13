/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LSA
 */
public class No {

    int chave;
    No prox;
    No ant;
    ListaSLC subList;

    
    public No() {
    }

    public No(int chave, No prox, No ant) {
        this.chave = chave;
        this.prox = prox;
        this.ant = ant;
    }

    public No(No prox) {
        this.prox = prox;
    }

    public No(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }
 
    public ListaSLC getSubList() {
        return subList;
    }

    public void setSubList(ListaSLC subList) {
        this.subList = subList;
    }

}
