package ServoConRemote.IToolsPackage;


/**
* ServoConRemote/IToolsPackage/ToolsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

abstract public class ToolsHelper
{
  private static String  _id = "IDL:ServoConRemote/ITools/Tools:1.0";

  public static void insert (org.omg.CORBA.Any a, ServoConRemote.IToolsPackage._s_tool[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ServoConRemote.IToolsPackage._s_tool[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ServoConRemote.IToolsPackage._s_toolHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ServoConRemote.IToolsPackage.ToolHelper.id (), "Tool", __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ServoConRemote.IToolsPackage.ToolsHelper.id (), "Tools", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ServoConRemote.IToolsPackage._s_tool[] read (org.omg.CORBA.portable.InputStream istream)
  {
    ServoConRemote.IToolsPackage._s_tool value[] = null;
    int _len0 = istream.read_long ();
    value = new ServoConRemote.IToolsPackage._s_tool[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = ServoConRemote.IToolsPackage.ToolHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ServoConRemote.IToolsPackage._s_tool[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      ServoConRemote.IToolsPackage.ToolHelper.write (ostream, value[_i0]);
  }

}
