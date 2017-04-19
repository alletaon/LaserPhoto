package ServoConRemote.LongProcessPackage;


/**
* ServoConRemote/LongProcessPackage/Status.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServoConRemote_v2.idl
* Wednesday, April 19, 2017 6:32:20 PM MSK
*/


//unknown means completed but status could not be retrieved
public class Status implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 4;
  private static ServoConRemote.LongProcessPackage.Status[] __array = new ServoConRemote.LongProcessPackage.Status [__size];

  public static final int _InProgress = 0;
  public static final ServoConRemote.LongProcessPackage.Status InProgress = new ServoConRemote.LongProcessPackage.Status(_InProgress);
  public static final int _Done = 1;
  public static final ServoConRemote.LongProcessPackage.Status Done = new ServoConRemote.LongProcessPackage.Status(_Done);
  public static final int _Error = 2;
  public static final ServoConRemote.LongProcessPackage.Status Error = new ServoConRemote.LongProcessPackage.Status(_Error);
  public static final int _Unknown = 3;
  public static final ServoConRemote.LongProcessPackage.Status Unknown = new ServoConRemote.LongProcessPackage.Status(_Unknown);

  public int value ()
  {
    return __value;
  }

  public static ServoConRemote.LongProcessPackage.Status from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected Status (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class Status
