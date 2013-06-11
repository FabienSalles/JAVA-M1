/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.td0.HelloApp;

import HelloApp.HelloPOA;

/**
 *
 * @author fsalles
 */
class HelloImpl extends HelloPOA
{

    @Override
    public String sayHello() {
        return "\nHello world !!\n";
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
