package CosNotification;


/**
* CosNotification/QoSAdminOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotification.idl
* Wednesday, April 19, 2017 6:31:51 PM MSK
*/


// MaxEventsPerConsumer takes on a value of type long
public interface QoSAdminOperations 
{
  CosNotification.Property[] get_qos ();
  void set_qos (CosNotification.Property[] qos) throws CosNotification.UnsupportedQoS;
  void validate_qos (CosNotification.Property[] required_qos, CosNotification.NamedPropertyRangeSeqHolder available_qos) throws CosNotification.UnsupportedQoS;
} // interface QoSAdminOperations
