package ServoConRemote.IUserParameterPackage;

/**
* ServoConRemote/IUserParameterPackage/InvalidValueHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/

public final class InvalidValueHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.IUserParameterPackage.InvalidValue value = null;

  public InvalidValueHolder ()
  {
  }

  public InvalidValueHolder (ServoConRemote.IUserParameterPackage.InvalidValue initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.IUserParameterPackage.InvalidValueHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.IUserParameterPackage.InvalidValueHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.IUserParameterPackage.InvalidValueHelper.type ();
  }

}
