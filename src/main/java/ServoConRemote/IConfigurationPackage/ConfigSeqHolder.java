package ServoConRemote.IConfigurationPackage;


/**
* ServoConRemote/IConfigurationPackage/ConfigSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class ConfigSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public ConfigSeqHolder ()
  {
  }

  public ConfigSeqHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.IConfigurationPackage.ConfigSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.IConfigurationPackage.ConfigSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.IConfigurationPackage.ConfigSeqHelper.type ();
  }

}
