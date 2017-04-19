package ServoConRemote;


/**
* ServoConRemote/_IOffsetsStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public class _IOffsetsStub extends org.omg.CORBA.portable.ObjectImpl implements ServoConRemote.IOffsets
{


  //get current offset index
  public int Current ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Current", true);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Current (        );
            } finally {
                _releaseReply ($in);
            }
  } // Current


  //set offset index (equivalent to ExecuteCommand("G<54-59.3>"))
  public void Select (int num) throws ServoConRemote.NotFound, ServoConRemote.CNCError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Select", true);
                $out.write_long (num);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/NotFound:1.0"))
                    throw ServoConRemote.NotFoundHelper.read ($in);
                else if (_id.equals ("IDL:ServoConRemote/CNCError:1.0"))
                    throw ServoConRemote.CNCErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                Select (num        );
            } finally {
                _releaseReply ($in);
            }
  } // Select


  //offsets->Set(offsets->Current(), p);
  public ServoConRemote.Position Get (int index) throws ServoConRemote.NotFound
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Get", true);
                $out.write_long (index);
                $in = _invoke ($out);
                ServoConRemote.Position $result = ServoConRemote.PositionHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/NotFound:1.0"))
                    throw ServoConRemote.NotFoundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Get (index        );
            } finally {
                _releaseReply ($in);
            }
  } // Get

  public void Set (int index, ServoConRemote.Position disp) throws ServoConRemote.NotFound, ServoConRemote.CNCError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Set", true);
                $out.write_long (index);
                ServoConRemote.PositionHelper.write ($out, disp);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/NotFound:1.0"))
                    throw ServoConRemote.NotFoundHelper.read ($in);
                else if (_id.equals ("IDL:ServoConRemote/CNCError:1.0"))
                    throw ServoConRemote.CNCErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                Set (index, disp        );
            } finally {
                _releaseReply ($in);
            }
  } // Set

  public void SetG28 (ServoConRemote.Position disp) throws ServoConRemote.CNCError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("SetG28", true);
                ServoConRemote.PositionHelper.write ($out, disp);
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
                SetG28 (disp        );
            } finally {
                _releaseReply ($in);
            }
  } // SetG28

  public void SetG30 (ServoConRemote.Position disp) throws ServoConRemote.CNCError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("SetG30", true);
                ServoConRemote.PositionHelper.write ($out, disp);
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
                SetG30 (disp        );
            } finally {
                _releaseReply ($in);
            }
  } // SetG30

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ServoConRemote/IOffsets:1.0"};

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
} // class _IOffsetsStub
