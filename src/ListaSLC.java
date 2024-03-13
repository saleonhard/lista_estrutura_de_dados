/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LSA
 */

//LISTA SIMPLISMENTE LIGADA CIRCULAR

public class ListaSLC {

    NoSLC prim;
    int cont;

    
    
    public ListaSLC() {
        prim = null;
        cont = 0;
    }

    public void add(NoSLC x) {
//        NoSLC novo = new NoSLC();
//        NoSLC aux = new NoSLC();
//        novo.prx = x;
//        if (prim == null) {
//            prim = novo;
//            prim.prx = prim;
//        } else {
//            aux = prim;
//            while (aux.prx != prim) {
//                aux = aux.prx;
//            }
//            aux.prx = novo;
//            novo.prx = prim;
//            
//        }
        
        if (prim == null) {
            x.setPrx(x);
            prim = x;
        } else {
            x.setPrx(prim.getPrx());
            prim.setPrx(x);
        }
        cont++;
    }
    
    public int size() {
        return cont;
    }
     
    public NoSLC getCursor() {
        return prim;
    }
     
    public void advance() {
        prim = prim.getPrx();
    }
}
