package ServoConRemote;

/**
* ServoConRemote/CNCMessageConsumerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/


//not needed - remove
public final class CNCMessageConsumerHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.CNCMessageConsumer value = null;

  public CNCMessageConsumerHolder ()
  {
  }

  public CNCMessageConsumerHolder (ServoConRemote.CNCMessageConsumer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.CNCMessageConsumerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.CNCMessageConsumerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.CNCMessageConsumerHelper.type ();
  }

}
