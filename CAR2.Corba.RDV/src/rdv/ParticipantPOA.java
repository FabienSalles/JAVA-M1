package rdv;


/**
* rdv/ParticipantPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from rdv.idl
* mardi 11 juin 2013 13 h 21 CEST
*/

public abstract class ParticipantPOA extends org.omg.PortableServer.Servant
 implements rdv.ParticipantOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("rdvTermine", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // rdv/Participant/rdvTermine
       {
         String nom = in.read_string ();
         this.rdvTermine (nom);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:rdv/Participant:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Participant _this() 
  {
    return ParticipantHelper.narrow(
    super._this_object());
  }

  public Participant _this(org.omg.CORBA.ORB orb) 
  {
    return ParticipantHelper.narrow(
    super._this_object(orb));
  }


} // class ParticipantPOA