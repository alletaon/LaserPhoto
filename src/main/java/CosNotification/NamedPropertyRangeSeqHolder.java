package CosNotification;


/**
* CosNotification/NamedPropertyRangeSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotification.idl
* Wednesday, April 19, 2017 6:31:51 PM MSK
*/

public final class NamedPropertyRangeSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public CosNotification.NamedPropertyRange value[] = null;

  public NamedPropertyRangeSeqHolder ()
  {
  }

  public NamedPropertyRangeSeqHolder (CosNotification.NamedPropertyRange[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosNotification.NamedPropertyRangeSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosNotification.NamedPropertyRangeSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosNotification.NamedPropertyRangeSeqHelper.type ();
  }

}
