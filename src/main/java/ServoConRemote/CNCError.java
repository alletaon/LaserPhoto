package ServoConRemote;


/**
* ServoConRemote/CNCError.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/

public final class CNCError extends org.omg.CORBA.UserException
{
  public String Message = null;

  public CNCError ()
  {
    super(CNCErrorHelper.id());
  } // ctor

  public CNCError (String _Message)
  {
    super(CNCErrorHelper.id());
    Message = _Message;
  } // ctor


  public CNCError (String $reason, String _Message)
  {
    super(CNCErrorHelper.id() + "  " + $reason);
    Message = _Message;
  } // ctor

} // class CNCError
