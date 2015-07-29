/** 
* Sample program for use with IBM Integration Bus
* © Copyright International Business Machines Corporation 2010 
* Licensed Materials - Property of IBM
*/

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class SCSServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try{
	        // create and initialize the ORB
	        ORB orb = ORB.init(args, null);

	        // get reference to rootpoa & activate the POAManager
	        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	        rootpoa.the_POAManager().activate();

	        // sku number ranges
	        int minRange = 0;
	        int maxRange = 1000;

	        // create servant and register it with the ORB
	        StockControlSystem SCS = new StockControlSystem( minRange, maxRange );

	        // get object reference from the servant
	        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(SCS);
	        StockControlManagementSystem href = StockControlManagementSystemHelper.narrow(ref);
	  	  
	        // get the root naming context
	        org.omg.CORBA.Object objRef =
	            orb.resolve_initial_references("NameService");
	        // Use NamingContextExt which is part of the Interoperable
	        // Naming Service (INS) specification.
	        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

	        // Set up path
	        NameComponent comp1 = new NameComponent("Sample", "WMB_Corba_Nodes");
	        NameComponent path1[] = { comp1 };
	        
	        NamingContext ncRef2 = ncRef.bind_new_context(path1);
	        
	        NameComponent comp2 = new NameComponent("CNSCMS", "Object");
	        NameComponent path2[] = { comp2 };

	        // bind the Object Reference in Naming
	        ncRef2.rebind(path2, href);

	        System.out.println("SCSServer ready and waiting ...");

	        // wait for invocations from clients
	        orb.run();
	    } catch (Exception e) {
	          System.err.println("ERROR: " + e);
	          e.printStackTrace(System.out);
	    }
	  	  
	    System.out.println("SCSServer Exiting ...");
	  	
	}

}

