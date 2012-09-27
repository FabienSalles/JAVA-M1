/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exo1;

/**
 *
 * @author souheib
 */
public class errors extends Exception{
    String msg;
    
    errors(String msg){
        this.msg=msg;
    }
    
    @Override
    public String toString(){
        return msg;
    }
}
