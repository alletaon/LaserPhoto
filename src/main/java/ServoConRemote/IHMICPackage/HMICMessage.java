package ServoConRemote.IHMICPackage;


/**
* ServoConRemote/IHMICPackage/HMICMessage.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class HMICMessage implements org.omg.CORBA.portable.IDLEntity
{
  public int key = (int)0;
  public int pressed = (int)0;

  public HMICMessage ()
  {
  } // ctor

  public HMICMessage (int _key, int _pressed)
  {
    key = _key;
    pressed = _pressed;
  } // ctor

} // class HMICMessage
