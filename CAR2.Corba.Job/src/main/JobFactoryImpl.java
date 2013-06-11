/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import car2.corba.job.Job;
import car2.corba.job.JobFact.JobFactoryPOA;
import car2.corba.job.JobProcess;
import car2.corba.job.JobProcessHelper;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.Context;
import org.omg.CORBA.ContextList;
import org.omg.CORBA.DomainManager;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.NVList;
import org.omg.CORBA.NamedValue;
import org.omg.CORBA.Object;
import org.omg.CORBA.Policy;
import org.omg.CORBA.Request;
import org.omg.CORBA.SetOverrideType;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author fsalles
 */
public class JobFactoryImpl extends JobFactoryPOA{
    private Set<JobProcessImpl> jobs;
    private POA poa;
    
    public JobFactoryImpl(POA poa)
    {
        this.jobs = new LinkedHashSet();
        this.poa = poa;
    }

    @Override
    public JobProcess createJob(Job jobData)
    {
        JobProcessImpl job = new JobProcessImpl(jobData);
        this.jobs.add(job);
        org.omg.CORBA.Object ref = null;
        try {
            ref = this.poa.servant_to_reference(job);
        } catch (ServantNotActive ex) {
            Logger.getLogger(JobFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WrongPolicy ex) {
            Logger.getLogger(JobFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return (JobProcess) JobProcessHelper.narrow(ref);
        
    } 
}
