package ServoConRemote;

/**
* ServoConRemote/SyntaxErrorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/

public final class SyntaxErrorHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.SyntaxError value = null;

  public SyntaxErrorHolder ()
  {
  }

  public SyntaxErrorHolder (ServoConRemote.SyntaxError initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.SyntaxErrorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.SyntaxErrorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.SyntaxErrorHelper.type ();
  }

}
