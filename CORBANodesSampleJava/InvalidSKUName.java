
/**
* InvalidSKUName.java .
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from StockControlInterface.idl
* Tuesday, 16 February 2010 00:39:54 o'clock GMT
* 
* Sample program for use with IBM Integration Bus
* � Copyright International Business Machines Corporation 2010 
* Licensed Materials - Property of IBM
*/

public final class InvalidSKUName extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity
{

  public InvalidSKUName ()
  {
    super(InvalidSKUNameHelper.id());
  } // ctor

  public InvalidSKUName (String $reason)
  {
    super(InvalidSKUNameHelper.id() + "  " + $reason);
  } // ctor

} // class InvalidSKUName
