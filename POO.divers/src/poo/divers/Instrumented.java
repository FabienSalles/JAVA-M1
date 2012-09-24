/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.divers;

import java.util.Set;

/**
 *
 * @author fasalles
 */
public class Instrumented extends ForwardingSet<E>{
    private int addCount = 0;
    
    public Instrumented(Set <E> s)
    {
        super(s);
    }
    
    
}
