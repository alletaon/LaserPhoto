package CosNotification;

/**
* CosNotification/NamedPropertyRangeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotification.idl
* Wednesday, April 19, 2017 6:31:51 PM MSK
*/

public final class NamedPropertyRangeHolder implements org.omg.CORBA.portable.Streamable
{
  public CosNotification.NamedPropertyRange value = null;

  public NamedPropertyRangeHolder ()
  {
  }

  public NamedPropertyRangeHolder (CosNotification.NamedPropertyRange initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosNotification.NamedPropertyRangeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosNotification.NamedPropertyRangeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosNotification.NamedPropertyRangeHelper.type ();
  }

}
