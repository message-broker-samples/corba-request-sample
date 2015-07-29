
/**
* _StockControlManagementSystemStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from StockControlInterface.idl
* Tuesday, 16 February 2010 00:39:54 o'clock GMT
* 
* Sample program for use with IBM Integration Bus
* � Copyright International Business Machines Corporation 2010 
* Licensed Materials - Property of IBM
*/

public class _StockControlManagementSystemStub extends org.omg.CORBA_2_3.portable.ObjectImpl implements StockControlManagementSystem
{
  // Constructors
  // NOTE:  If the default constructor is used, the
  //        object is useless until _set_delegate (...)
  //        is called.
  public _StockControlManagementSystemStub ()
  {
    super ();
  }

  public _StockControlManagementSystemStub (org.omg.CORBA.portable.Delegate delegate)
  {
    super ();
    _set_delegate (delegate);
  }

  public int getSKU (String name) throws InvalidSKUName
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("getSKU",true);
          _out.write_string (name);
          _in = _invoke (_out);
          int __result = _in.read_long ();
          return __result;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUNameHelper.id() ) )
            throw InvalidSKUNameHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "getSKU",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
          int __result = ((StockControlManagementSystemOperations)_so.servant).getSKU( name );
          return __result;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // getSKU

  public String getSKUName (int sku) throws InvalidSKU
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("getSKUName",true);
          _out.write_long (sku);
          _in = _invoke (_out);
          String __result = _in.read_string ();
          return __result;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "getSKUName",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
          String __result = ((StockControlManagementSystemOperations)_so.servant).getSKUName( sku );
          return __result;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // getSKUName

  public void addStock (int sku, int number, org.omg.CORBA.IntHolder quantity) throws InvalidSKU
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("addStock",true);
          _out.write_long (sku);
          _out.write_long (number);
          _in = _invoke (_out);
          quantity.value = _in.read_long ();
          return;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "addStock",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
         org.omg.CORBA.IntHolder _quantity = new org.omg.CORBA.IntHolder();
          ((StockControlManagementSystemOperations)_so.servant).addStock( sku,number,_quantity );
         quantity.value = _quantity.value;
          return;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // addStock

  public void reduceStock (int sku, int number, org.omg.CORBA.IntHolder quantity) throws InvalidSKU, InvalidQTY
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("reduceStock",true);
          _out.write_long (sku);
          _out.write_long (number);
          _in = _invoke (_out);
          quantity.value = _in.read_long ();
          return;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else if ( _id.equals ( InvalidQTYHelper.id() ) )
            throw InvalidQTYHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "reduceStock",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
         org.omg.CORBA.IntHolder _quantity = new org.omg.CORBA.IntHolder();
          ((StockControlManagementSystemOperations)_so.servant).reduceStock( sku,number,_quantity );
         quantity.value = _quantity.value;
          return;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // reduceStock

  public int getStockLevel (int sku) throws InvalidSKU
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("getStockLevel",true);
          _out.write_long (sku);
          _in = _invoke (_out);
          int __result = _in.read_long ();
          return __result;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "getStockLevel",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
          int __result = ((StockControlManagementSystemOperations)_so.servant).getStockLevel( sku );
          return __result;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // getStockLevel

  public double getPrice (int sku) throws InvalidSKU
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("getPrice",true);
          _out.write_long (sku);
          _in = _invoke (_out);
          double __result = _in.read_double ();
          return __result;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "getPrice",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
          double __result = ((StockControlManagementSystemOperations)_so.servant).getPrice( sku );
          return __result;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // getPrice

  public void setPrice (int sku, double price) throws InvalidSKU
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("setPrice",true);
          _out.write_long (sku);
          _out.write_double (price);
          _in = _invoke (_out);
          return;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "setPrice",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
          ((StockControlManagementSystemOperations)_so.servant).setPrice( sku,price );
          return;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // setPrice

  public void createNewStockItem (String name, org.omg.CORBA.IntHolder sku) throws InvalidSKU, SKUNameAlreadyExist
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("createNewStockItem",true);
          _out.write_string (name);
          _out.write_long (sku.value);
          _in = _invoke (_out);
          sku.value = _in.read_long ();
          return;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else if ( _id.equals ( SKUNameAlreadyExistHelper.id() ) )
            throw SKUNameAlreadyExistHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "createNewStockItem",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
          ((StockControlManagementSystemOperations)_so.servant).createNewStockItem( name,sku );
          return;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // createNewStockItem

  public void deleteStockItem (int sku) throws InvalidSKU
  {
    while(true) {
      if ( !this._is_local() ) {
        org.omg.CORBA.portable.InputStream _in = null;
        try {
          org.omg.CORBA.portable.OutputStream _out = _request ("deleteStockItem",true);
          _out.write_long (sku);
          _in = _invoke (_out);
          return;
        } catch (org.omg.CORBA.portable.ApplicationException _ex) {
          _in = _ex.getInputStream ();
          String _id = _ex.getId ();
           if ( _id.equals ( InvalidSKUHelper.id() ) )
            throw InvalidSKUHelper.read( _in );
           else throw new org.omg.CORBA.UNKNOWN( "Unexpected User Exception: " + _id );
        } catch (org.omg.CORBA.portable.RemarshalException _rm) {
          continue;
        } catch (org.omg.CORBA.portable.UnknownException _ue) {
          Throwable _oe = _ue.originalEx;
          if (_oe instanceof Error)
              throw (Error)_oe;
          else if (_oe instanceof RuntimeException)
              throw (RuntimeException)_oe;
          else
              throw _ue;
        } finally { _releaseReply (_in); }
      }
      else {
        org.omg.CORBA.portable.ServantObject _so =
          _servant_preinvoke( "deleteStockItem",_opsClass );
        if ( _so == null ) { 
          continue;
        }
        try {
          ((StockControlManagementSystemOperations)_so.servant).deleteStockItem( sku );
          return;
        } finally { _servant_postinvoke( _so ); }
      }
    }
  } // deleteStockItem

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:StockControlManagementSystem:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  final public static java.lang.Class _opsClass =
    StockControlManagementSystemOperations.class;

  private void readObject (java.io.ObjectInputStream s)
  {
     try 
     {
       String str = s.readUTF ();
       org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init ((String[])null, null).string_to_object (str);
       org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
       _set_delegate (delegate);
     } catch (java.io.IOException e) {}
  }

  private void writeObject (java.io.ObjectOutputStream s)
  {
     try 
     {
       String str = org.omg.CORBA.ORB.init ((String[])null, null).object_to_string (this);
       s.writeUTF (str);
     } catch (java.io.IOException e) {}
  }
} // class _StockControlManagementSystemStub
