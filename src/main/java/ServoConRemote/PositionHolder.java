package ServoConRemote;

/**
* ServoConRemote/PositionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class PositionHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.Position value = null;

  public PositionHolder ()
  {
  }

  public PositionHolder (ServoConRemote.Position initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.PositionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.PositionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.PositionHelper.type ();
  }

}
