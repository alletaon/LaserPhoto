package ServoConRemote;


/**
* ServoConRemote/IOffsetsOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public interface IOffsetsOperations 
{

  //get current offset index
  int Current ();

  //set offset index (equivalent to ExecuteCommand("G<54-59.3>"))
  void Select (int num) throws ServoConRemote.NotFound, ServoConRemote.CNCError;

  //offsets->Set(offsets->Current(), p);
  ServoConRemote.Position Get (int index) throws ServoConRemote.NotFound;
  void Set (int index, ServoConRemote.Position disp) throws ServoConRemote.NotFound, ServoConRemote.CNCError;
  void SetG28 (ServoConRemote.Position disp) throws ServoConRemote.CNCError;
  void SetG30 (ServoConRemote.Position disp) throws ServoConRemote.CNCError;
} // interface IOffsetsOperations
