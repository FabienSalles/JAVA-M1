/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td2.exo1;

/**
 *
 * @author fasalles
 */
public class RMIFactory {
    public static Job createJob(int type)
    {
        Job j = null;
        switch(type)
        {
            case 1 :
                j = new Job1();
            break;
                
            case 2 :
                j = new Job2();
            break;
        }
        return j;
    }
}
