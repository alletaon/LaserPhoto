package CosNotification;

/**
* CosNotification/PropertyHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotification.idl
* Wednesday, April 19, 2017 6:31:51 PM MSK
*/

public final class PropertyHolder implements org.omg.CORBA.portable.Streamable
{
  public CosNotification.Property value = null;

  public PropertyHolder ()
  {
  }

  public PropertyHolder (CosNotification.Property initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosNotification.PropertyHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosNotification.PropertyHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosNotification.PropertyHelper.type ();
  }

}
