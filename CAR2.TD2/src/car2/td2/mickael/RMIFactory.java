package car2.td2.mickael;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirolo
 */
public class RMIFactory
{
    
    
    public static JobItf createJob(int type)
    {
        JobItf j = null;
        switch(type)
        {
            case 1 :
                j = new Job1();
            break;
                
            case 2 :
                j = new Job1();
            break;
        }
        return j;
    }
}
