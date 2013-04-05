/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td2.exo1;

/**
 *
 * @author fasalles
 */
public class Job2 implements Job{
    private String name;
    
    public Job2(String name)
    {
        this.name = name;
    }

    public Job2()
    {
    }

    @Override
    public String toString() {
        return "Job2{" + "name=" + name + '}';
    } 
}
