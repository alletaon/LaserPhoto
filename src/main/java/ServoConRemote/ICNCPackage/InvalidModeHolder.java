package ServoConRemote.ICNCPackage;

/**
* ServoConRemote/ICNCPackage/InvalidModeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/


//not used yet - will be removed (use Impossible!)
public final class InvalidModeHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.ICNCPackage.InvalidMode value = null;

  public InvalidModeHolder ()
  {
  }

  public InvalidModeHolder (ServoConRemote.ICNCPackage.InvalidMode initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.ICNCPackage.InvalidModeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.ICNCPackage.InvalidModeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.ICNCPackage.InvalidModeHelper.type ();
  }

}
