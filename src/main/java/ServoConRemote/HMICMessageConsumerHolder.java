package ServoConRemote;

/**
* ServoConRemote/HMICMessageConsumerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/


//not needed - remove
public final class HMICMessageConsumerHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.HMICMessageConsumer value = null;

  public HMICMessageConsumerHolder ()
  {
  }

  public HMICMessageConsumerHolder (ServoConRemote.HMICMessageConsumer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.HMICMessageConsumerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.HMICMessageConsumerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.HMICMessageConsumerHelper.type ();
  }

}
