package CosNotification;


/**
* CosNotification/EventTypeSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotification.idl
* Wednesday, April 19, 2017 6:31:51 PM MSK
*/

public final class EventTypeSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public CosNotification.EventType value[] = null;

  public EventTypeSeqHolder ()
  {
  }

  public EventTypeSeqHolder (CosNotification.EventType[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosNotification.EventTypeSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosNotification.EventTypeSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosNotification.EventTypeSeqHelper.type ();
  }

}
