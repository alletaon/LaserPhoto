package CosNotification;

/**
* CosNotification/AdminPropertiesAdminHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotification.idl
* Wednesday, April 19, 2017 6:31:51 PM MSK
*/


// RejectNewEvents takes on a value of type Boolean
public final class AdminPropertiesAdminHolder implements org.omg.CORBA.portable.Streamable
{
  public CosNotification.AdminPropertiesAdmin value = null;

  public AdminPropertiesAdminHolder ()
  {
  }

  public AdminPropertiesAdminHolder (CosNotification.AdminPropertiesAdmin initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CosNotification.AdminPropertiesAdminHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CosNotification.AdminPropertiesAdminHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CosNotification.AdminPropertiesAdminHelper.type ();
  }

}
