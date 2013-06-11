/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.td1.HelloApp;

import HelloApp.HelloPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author fsalles
 */
class HelloImpl extends HelloPOA
{

   private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
    
  // implement sayHello() method
  public String sayHello() {
    return "\nHello world !!\n";
  }
    
  // implement shutdown() method
  public void shutdown() {
    orb.shutdown(false);
  }
    
}
