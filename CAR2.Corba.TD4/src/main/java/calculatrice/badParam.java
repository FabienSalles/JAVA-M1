package calculatrice;


/**
* calculatrice/badParam.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculatrice.idl
* vendredi 7 juin 2013 15 h 07 CEST
*/

public final class badParam extends org.omg.CORBA.UserException
{
  public String p = null;

  public badParam ()
  {
    super(badParamHelper.id());
  } // ctor

  public badParam (String _p)
  {
    super(badParamHelper.id());
    p = _p;
  } // ctor


  public badParam (String $reason, String _p)
  {
    super(badParamHelper.id() + "  " + $reason);
    p = _p;
  } // ctor

} // class badParam
