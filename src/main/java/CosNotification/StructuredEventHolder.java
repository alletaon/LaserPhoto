package CosNotification;

/**
* CosNotification/StructuredEventHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotification.idl
* Wednesday, April 19, 2017 6:31:51 PM MSK
*/

public final class StructuredEventHolder implements org.omg.CORBA.portable.Streamable
{
  public CosNotification.StructuredEvent value = null;

  public StructuredEventHolder ()
  {
  }

  public StructuredEventHolder (CosNotification.StructuredEvent initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosNotification.StructuredEventHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosNotification.StructuredEventHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosNotification.StructuredEventHelper.type ();
  }

}
