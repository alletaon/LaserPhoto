package ServoConRemote.IScopeChannelPackage;


/**
* ServoConRemote/IScopeChannelPackage/DataHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

abstract public class DataHelper
{
  private static String  _id = "IDL:ServoConRemote/IScopeChannel/Data:1.0";

  public static void insert (org.omg.CORBA.Any a, ServoConRemote.IScopeChannelPackage._s_data that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ServoConRemote.IScopeChannelPackage._s_data extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ServoConRemote.IScopeChannelPackage._s_dataHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ServoConRemote.IScopeChannelPackage.DataHelper.id (), "Data", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ServoConRemote.IScopeChannelPackage._s_data read (org.omg.CORBA.portable.InputStream istream)
  {
    ServoConRemote.IScopeChannelPackage._s_data value = null;
    value = ServoConRemote.IScopeChannelPackage._s_dataHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ServoConRemote.IScopeChannelPackage._s_data value)
  {
    ServoConRemote.IScopeChannelPackage._s_dataHelper.write (ostream, value);
  }

}