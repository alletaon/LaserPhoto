package ServoConRemote.IUserParameterPackage;


/**
* ServoConRemote/IUserParameterPackage/LimitTypeHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/

abstract public class LimitTypeHelper
{
  private static String  _id = "IDL:ServoConRemote/IUserParameter/LimitType:1.0";

  public static void insert (org.omg.CORBA.Any a, ServoConRemote.IUserParameterPackage._s_Limits that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ServoConRemote.IUserParameterPackage._s_Limits extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ServoConRemote.IUserParameterPackage._s_LimitsHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ServoConRemote.IUserParameterPackage.LimitTypeHelper.id (), "LimitType", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ServoConRemote.IUserParameterPackage._s_Limits read (org.omg.CORBA.portable.InputStream istream)
  {
    ServoConRemote.IUserParameterPackage._s_Limits value = null;
    value = ServoConRemote.IUserParameterPackage._s_LimitsHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ServoConRemote.IUserParameterPackage._s_Limits value)
  {
    ServoConRemote.IUserParameterPackage._s_LimitsHelper.write (ostream, value);
  }

}
