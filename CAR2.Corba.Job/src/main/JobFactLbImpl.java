/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import car2.corba.job.Job;
import car2.corba.job.JobFact.JobFactory;
import car2.corba.job.JobFactoryLB.FactoryLBPOA;
import car2.corba.job.JobProcess;
import java.util.ArrayList;
import java.util.List;
import org.omg.PortableServer.POA;

/**
 *
 * @author fsalles
 */
public class JobFactLbImpl extends FactoryLBPOA
{
    private List <JobFactory> list;
    private POA poa;
    
    public JobFactLbImpl(POA poa)
    {
        this.list = new ArrayList();
        this.poa = poa;
    }

    @Override
    public JobProcess createJob(Job jd) {
        return (JobProcess) this.list.get(this.list.size()-1).createJob(jd);
    }

    @Override
    public void register(JobFactory jf) {
        this.list.add(jf);
    }

    @Override
    public void unregister(JobFactory jf) {
        this.list.remove(jf);
    }
    
}
