package CosNotifyComm;

/**
* CosNotifyComm/NotifyPublishHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotifyComm.idl
* Wednesday, April 19, 2017 6:32:07 PM MSK
*/

public final class NotifyPublishHolder implements org.omg.CORBA.portable.Streamable
{
  public CosNotifyComm.NotifyPublish value = null;

  public NotifyPublishHolder ()
  {
  }

  public NotifyPublishHolder (CosNotifyComm.NotifyPublish initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosNotifyComm.NotifyPublishHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosNotifyComm.NotifyPublishHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosNotifyComm.NotifyPublishHelper.type ();
  }

}
