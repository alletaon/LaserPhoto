package ServoConRemote.IToolsPackage;

/**
* ServoConRemote/IToolsPackage/_s_toolHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class _s_toolHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.IToolsPackage._s_tool value = null;

  public _s_toolHolder ()
  {
  }

  public _s_toolHolder (ServoConRemote.IToolsPackage._s_tool initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.IToolsPackage._s_toolHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.IToolsPackage._s_toolHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.IToolsPackage._s_toolHelper.type ();
  }

}
