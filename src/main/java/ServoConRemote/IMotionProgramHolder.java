package ServoConRemote;

/**
* ServoConRemote/IMotionProgramHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/


//operations on motion program
public final class IMotionProgramHolder implements org.omg.CORBA.portable.Streamable
{
  public ServoConRemote.IMotionProgram value = null;

  public IMotionProgramHolder ()
  {
  }

  public IMotionProgramHolder (ServoConRemote.IMotionProgram initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ServoConRemote.IMotionProgramHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ServoConRemote.IMotionProgramHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ServoConRemote.IMotionProgramHelper.type ();
  }

}
