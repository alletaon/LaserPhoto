package ServoConRemote.IScopePackage;


/**
* ServoConRemote/IScopePackage/NotGatherable.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class NotGatherable extends org.omg.CORBA.UserException
{

  public NotGatherable ()
  {
    super(NotGatherableHelper.id());
  } // ctor


  public NotGatherable (String $reason)
  {
    super(NotGatherableHelper.id() + "  " + $reason);
  } // ctor

} // class NotGatherable