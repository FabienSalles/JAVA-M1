package calculatrice;


/**
* calculatrice/divZero.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculatrice.idl
* vendredi 7 juin 2013 15 h 07 CEST
*/

public final class divZero extends org.omg.CORBA.UserException
{
  public String diviseur = null;

  public divZero ()
  {
    super(divZeroHelper.id());
  } // ctor

  public divZero (String _diviseur)
  {
    super(divZeroHelper.id());
    diviseur = _diviseur;
  } // ctor


  public divZero (String $reason, String _diviseur)
  {
    super(divZeroHelper.id() + "  " + $reason);
    diviseur = _diviseur;
  } // ctor

} // class divZero
