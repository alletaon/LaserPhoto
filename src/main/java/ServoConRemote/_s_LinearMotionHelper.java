package ServoConRemote;


/**
* ServoConRemote/_s_LinearMotionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

abstract public class _s_LinearMotionHelper
{
  private static String  _id = "IDL:ServoConRemote/s_LinearMotion:1.0";

  public static void insert (org.omg.CORBA.Any a, ServoConRemote._s_LinearMotion that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ServoConRemote._s_LinearMotion extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = ServoConRemote.PositionHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "End",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (ServoConRemote._s_LinearMotionHelper.id (), "s_LinearMotion", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ServoConRemote._s_LinearMotion read (org.omg.CORBA.portable.InputStream istream)
  {
    ServoConRemote._s_LinearMotion value = new ServoConRemote._s_LinearMotion ();
    value.End = ServoConRemote.PositionHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ServoConRemote._s_LinearMotion value)
  {
    ServoConRemote.PositionHelper.write (ostream, value.End);
  }

}
