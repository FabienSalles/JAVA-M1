/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td2.exo1;

/**
 *
 * @author fasalles
 */
public class Job1 implements Job{
    private String name;
    
    public Job1(String name)
    {
        this.name = name;
    }

    public Job1()
    {
    }

    @Override
    public String toString() {
        return "Job1{" + "name=" + name + '}';
    } 
}
