package CosNotifyComm;


/**
* CosNotifyComm/StructuredPullSupplierOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CosNotifyComm.idl
* Wednesday, April 19, 2017 6:32:07 PM MSK
*/


// StructuredPullConsumer
public interface StructuredPullSupplierOperations  extends CosNotifyComm.NotifySubscribeOperations
{
  CosNotification.StructuredEvent pull_structured_event () throws CosEventComm.Disconnected;
  CosNotification.StructuredEvent try_pull_structured_event (org.omg.CORBA.BooleanHolder has_event) throws CosEventComm.Disconnected;
  void disconnect_structured_pull_supplier ();
} // interface StructuredPullSupplierOperations
