package ServoConRemote;


/**
* ServoConRemote/NotFound.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/

public final class NotFound extends org.omg.CORBA.UserException
{

  public NotFound ()
  {
    super(NotFoundHelper.id());
  } // ctor


  public NotFound (String $reason)
  {
    super(NotFoundHelper.id() + "  " + $reason);
  } // ctor

} // class NotFound
