package ServoConRemote;

/**
* ServoConRemote/IConfigurationHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class IConfigurationHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.IConfiguration value = null;

  public IConfigurationHolder ()
  {
  }

  public IConfigurationHolder (ServoConRemote.IConfiguration initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.IConfigurationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.IConfigurationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.IConfigurationHelper.type ();
  }

}
