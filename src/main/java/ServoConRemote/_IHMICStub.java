package ServoConRemote;


/**
* ServoConRemote/_IHMICStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/


//front panel HW interface
public class _IHMICStub extends org.omg.CORBA.portable.ObjectImpl implements ServoConRemote.IHMIC
{

  public void Print (String data)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Print", true);
                $out.write_string (data);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                Print (data        );
            } finally {
                _releaseReply ($in);
            }
  } // Print

  public void Clear ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Clear", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                Clear (        );
            } finally {
                _releaseReply ($in);
            }
  } // Clear

  public void SetLed (int led, int state)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("SetLed", true);
                $out.write_long (led);
                $out.write_long (state);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                SetLed (led, state        );
            } finally {
                _releaseReply ($in);
            }
  } // SetLed

  public void SetAutorepeat (ServoConRemote.IHMICPackage.AutorepeatSettings sett)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("SetAutorepeat", true);
                ServoConRemote.IHMICPackage.AutorepeatSettingsHelper.write ($out, sett);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                SetAutorepeat (sett        );
            } finally {
                _releaseReply ($in);
            }
  } // SetAutorepeat

  public ServoConRemote.IHMICPackage.AutorepeatSettings GetAutorepeat ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetAutorepeat", true);
                $in = _invoke ($out);
                ServoConRemote.IHMICPackage.AutorepeatSettings $result = ServoConRemote.IHMICPackage.AutorepeatSettingsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return GetAutorepeat (        );
            } finally {
                _releaseReply ($in);
            }
  } // GetAutorepeat

  public ServoConRemote.LongProcess Update () throws ServoConRemote.Impossible
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Update", true);
                $in = _invoke ($out);
                ServoConRemote.LongProcess $result = ServoConRemote.LongProcessHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/Impossible:1.0"))
                    throw ServoConRemote.ImpossibleHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Update (        );
            } finally {
                _releaseReply ($in);
            }
  } // Update

  public ServoConRemote.IHMICPackage.DeviceDescriptor GetDeviceDescriptor ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetDeviceDescriptor", true);
                $in = _invoke ($out);
                ServoConRemote.IHMICPackage.DeviceDescriptor $result = ServoConRemote.IHMICPackage.DeviceDescriptorHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return GetDeviceDescriptor (        );
            } finally {
                _releaseReply ($in);
            }
  } // GetDeviceDescriptor

  public void SetDeviceDescriptor (ServoConRemote.IHMICPackage.DeviceDescriptor data)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("SetDeviceDescriptor", true);
                ServoConRemote.IHMICPackage.DeviceDescriptorHelper.write ($out, data);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                SetDeviceDescriptor (data        );
            } finally {
                _releaseReply ($in);
            }
  } // SetDeviceDescriptor

  public String GetVersion ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetVersion", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return GetVersion (        );
            } finally {
                _releaseReply ($in);
            }
  } // GetVersion

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ServoConRemote/IHMIC:1.0"};

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
} // class _IHMICStub
