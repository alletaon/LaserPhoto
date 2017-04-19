package ServoConRemote;


/**
* ServoConRemote/MotionInfoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

abstract public class MotionInfoHelper
{
  private static String  _id = "IDL:ServoConRemote/MotionInfo:1.0";

  public static void insert (org.omg.CORBA.Any a, ServoConRemote._s_MotionInfo that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ServoConRemote._s_MotionInfo extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ServoConRemote._s_MotionInfoHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ServoConRemote.MotionInfoHelper.id (), "MotionInfo", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ServoConRemote._s_MotionInfo read (org.omg.CORBA.portable.InputStream istream)
  {
    ServoConRemote._s_MotionInfo value = null;
    value = ServoConRemote._s_MotionInfoHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ServoConRemote._s_MotionInfo value)
  {
    ServoConRemote._s_MotionInfoHelper.write (ostream, value);
  }

}
