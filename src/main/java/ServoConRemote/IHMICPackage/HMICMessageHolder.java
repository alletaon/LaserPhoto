package ServoConRemote.IHMICPackage;

/**
* ServoConRemote/IHMICPackage/HMICMessageHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class HMICMessageHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.IHMICPackage.HMICMessage value = null;

  public HMICMessageHolder ()
  {
  }

  public HMICMessageHolder (ServoConRemote.IHMICPackage.HMICMessage initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.IHMICPackage.HMICMessageHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.IHMICPackage.HMICMessageHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.IHMICPackage.HMICMessageHelper.type ();
  }

}
