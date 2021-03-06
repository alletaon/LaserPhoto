package ServoConRemote;


/**
* ServoConRemote/_ISpindleStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public class _ISpindleStub extends org.omg.CORBA.portable.ObjectImpl implements ServoConRemote.ISpindle
{


  //not implemented yet
  public void TurnOn () throws ServoConRemote.CNCError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("TurnOn", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/CNCError:1.0"))
                    throw ServoConRemote.CNCErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                TurnOn (        );
            } finally {
                _releaseReply ($in);
            }
  } // TurnOn

  public void TurnOff () throws ServoConRemote.CNCError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("TurnOff", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/CNCError:1.0"))
                    throw ServoConRemote.CNCErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                TurnOff (        );
            } finally {
                _releaseReply ($in);
            }
  } // TurnOff

  public ServoConRemote.IUserParameter SpeedCommand ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_SpeedCommand", true);
                $in = _invoke ($out);
                ServoConRemote.IUserParameter $result = ServoConRemote.IUserParameterHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return SpeedCommand (        );
            } finally {
                _releaseReply ($in);
            }
  } // SpeedCommand

  public ServoConRemote.IUserParameter SpeedFeedback ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_SpeedFeedback", true);
                $in = _invoke ($out);
                ServoConRemote.IUserParameter $result = ServoConRemote.IUserParameterHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return SpeedFeedback (        );
            } finally {
                _releaseReply ($in);
            }
  } // SpeedFeedback

  public ServoConRemote.IUserParameter Scale ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Scale", true);
                $in = _invoke ($out);
                ServoConRemote.IUserParameter $result = ServoConRemote.IUserParameterHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Scale (        );
            } finally {
                _releaseReply ($in);
            }
  } // Scale

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ServoConRemote/ISpindle:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ISpindleStub
