package ServoConRemote;


/**
* ServoConRemote/IDiagnosticsOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:21 PM MSK
*/

public interface IDiagnosticsOperations 
{

  //finds screen by name
  ServoConRemote.IDiagScreen GetScreen (String name) throws ServoConRemote.NotFound;

  //adds new screen, if exists returns reference to existing screen
  ServoConRemote.IDiagScreen CreateScreen (String name);
} // interface IDiagnosticsOperations