package ServoConRemote;


/**
* ServoConRemote/_IUserParameterStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/

public class _IUserParameterStub extends org.omg.CORBA.portable.ObjectImpl implements ServoConRemote.IUserParameter
{


  //text name
  public String Name ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Name", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Name (        );
            } finally {
                _releaseReply ($in);
            }
  } // Name

  public String Hint ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Hint", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Hint (        );
            } finally {
                _releaseReply ($in);
            }
  } // Hint

  public ServoConRemote.IUserParameterPackage._s_Limits Limits ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Limits", true);
                $in = _invoke ($out);
                ServoConRemote.IUserParameterPackage._s_Limits $result = ServoConRemote.IUserParameterPackage.LimitTypeHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Limits (        );
            } finally {
                _releaseReply ($in);
            }
  } // Limits


  //returns up to 8 digits after point
  public String GetTextValue ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetTextValue", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return GetTextValue (        );
            } finally {
                _releaseReply ($in);
            }
  } // GetTextValue

  public org.omg.CORBA.Any GetValue ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetValue", true);
                $in = _invoke ($out);
                org.omg.CORBA.Any $result = $in.read_any ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return GetValue (        );
            } finally {
                _releaseReply ($in);
            }
  } // GetValue


  //get all possible values
  public String[] GetValuesList () throws ServoConRemote.IUserParameterPackage.NotListType
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetValuesList", true);
                $in = _invoke ($out);
                String $result[] = ServoConRemote.IUserParameterPackage.ValueListSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/IUserParameter/NotListType:1.0"))
                    throw ServoConRemote.IUserParameterPackage.NotListTypeHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return GetValuesList (        );
            } finally {
                _releaseReply ($in);
            }
  } // GetValuesList


  //should recognize text and correct value type for parameter
  public void SetValue (org.omg.CORBA.Any val) throws ServoConRemote.IUserParameterPackage.IsReadOnly, ServoConRemote.IUserParameterPackage.InvalidValue, ServoConRemote.Impossible
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("SetValue", true);
                $out.write_any (val);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:ServoConRemote/IUserParameter/IsReadOnly:1.0"))
                    throw ServoConRemote.IUserParameterPackage.IsReadOnlyHelper.read ($in);
                else if (_id.equals ("IDL:ServoConRemote/IUserParameter/InvalidValue:1.0"))
                    throw ServoConRemote.IUserParameterPackage.InvalidValueHelper.read ($in);
                else if (_id.equals ("IDL:ServoConRemote/Impossible:1.0"))
                    throw ServoConRemote.ImpossibleHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                SetValue (val        );
            } finally {
                _releaseReply ($in);
            }
  } // SetValue


  //not implemented yet
  public void StartWatch ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("StartWatch", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                StartWatch (        );
            } finally {
                _releaseReply ($in);
            }
  } // StartWatch


  //stop updating notification channel, mb destroy the channel
  public void StopWatch ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("StopWatch", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                StopWatch (        );
            } finally {
                _releaseReply ($in);
            }
  } // StopWatch

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ServoConRemote/IUserParameter:1.0"};

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
} // class _IUserParameterStub
