package ServoConRemote.ICNCPackage;


/**
* ServoConRemote/ICNCPackage/GCodesStateHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class GCodesStateHolder implements org.omg.CORBA.portable.Streamable
{
  public int value[] = null;

  public GCodesStateHolder ()
  {
  }

  public GCodesStateHolder (int[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.ICNCPackage.GCodesStateHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.ICNCPackage.GCodesStateHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.ICNCPackage.GCodesStateHelper.type ();
  }

}
