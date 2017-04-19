package ServoConRemote;


/**
* ServoConRemote/IHMIHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

abstract public class IHMIHelper
{
  private static String  _id = "IDL:ServoConRemote/IHMI:1.0";

  public static void insert (org.omg.CORBA.Any a, ServoConRemote.IHMI that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ServoConRemote.IHMI extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ServoConRemote.IHMIHelper.id (), "IHMI");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ServoConRemote.IHMI read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IHMIStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ServoConRemote.IHMI value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ServoConRemote.IHMI narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ServoConRemote.IHMI)
      return (ServoConRemote.IHMI)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ServoConRemote._IHMIStub stub = new ServoConRemote._IHMIStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ServoConRemote.IHMI unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ServoConRemote.IHMI)
      return (ServoConRemote.IHMI)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ServoConRemote._IHMIStub stub = new ServoConRemote._IHMIStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
