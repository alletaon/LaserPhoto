package ServoConRemote;


/**
* ServoConRemote/_s_ArcMotion.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public final class _s_ArcMotion implements org.omg.CORBA.portable.IDLEntity
{
  public ServoConRemote.Position End = null;
  public ServoConRemote.Position Center = null;
  public ServoConRemote.MotionPlane Plane = null;

  public _s_ArcMotion ()
  {
  } // ctor

  public _s_ArcMotion (ServoConRemote.Position _End, ServoConRemote.Position _Center, ServoConRemote.MotionPlane _Plane)
  {
    End = _End;
    Center = _Center;
    Plane = _Plane;
  } // ctor

} // class _s_ArcMotion
