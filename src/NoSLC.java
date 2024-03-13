/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LSA
 */

//
public class NoSLC {
   NoSLC prx;
   Double chave;

   
   public NoSLC() {
        
    }
   
    public NoSLC(Double chave) {
        this.chave = chave;
    }
   
    public NoSLC getPrx() {
        return prx;
    }

    public void setPrx(NoSLC prx) {
        this.prx = prx;
    }

    public Double getChave() {
        return chave;
    }

    public void setChave(Double chave) {
        this.chave = chave;
    }
   
}
