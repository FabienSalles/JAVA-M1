/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import car2.corba.job.Job;
import car2.corba.job.JobProcessPOA;

/**
 *
 * @author fsalles
 */
public class JobProcessImpl extends JobProcessPOA {
    
    private double type;
    private String msg;
    
    public JobProcessImpl(Job job)
    {
        this.type = job.paie;
        this.msg = job.poste;
    }
    
    @Override
    public void run() {
        System.out.println(this.type+" "+this.msg);
    }
    
}
