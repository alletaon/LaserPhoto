package ServoConRemote;

/**
* ServoConRemote/IDiagScreenHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/


//plcs should use these interfaces to let user adjust parameters
public final class IDiagScreenHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.IDiagScreen value = null;

  public IDiagScreenHolder ()
  {
  }

  public IDiagScreenHolder (ServoConRemote.IDiagScreen initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.IDiagScreenHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.IDiagScreenHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.IDiagScreenHelper.type ();
  }

}
