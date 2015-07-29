/** 
* Sample program for use with IBM Integration Bus
* © Copyright International Business Machines Corporation 2010 
* Licensed Materials - Property of IBM
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.omg.CORBA.IntHolder;


public class StockControlSystem extends StockControlManagementSystemPOA {

    private int SKU_RANGE_MIN;
    private int SKU_RANGE_MAX;
	private HashMap<Integer, StockItem> m_SKUs;


	public StockControlSystem( int minRange, int maxRange ) {
		System.out.println("StockControlSystem ctor: min range= "+minRange+" max range= "+maxRange);
		SKU_RANGE_MIN = minRange;
		SKU_RANGE_MAX = maxRange;
		m_SKUs = new HashMap<Integer, StockItem>();
	}

	public void addStock(int sku, int number, IntHolder quantity)
			throws InvalidSKU {
		System.out.println("addStock: sku="+sku+" change qty="+number);

	    StockItem SI = getSKUitem( sku );
	    if ( SI == null )
	    {
	        System.out.println("SKU not found");	        
	        throw new InvalidSKU();
	    }

	    
	    System.out.println("SKU qty was: " + SI.getQty());
	    SI.setQty(SI.getQty() + number);
	    System.out.println("SKU qty now: " + SI.getQty());

	    // Set the quantity to return
	    quantity.value = SI.getQty();
	    return;

	}

	public void createNewStockItem(String name, IntHolder sku)
			throws InvalidSKU, SKUNameAlreadyExist {
	    System.out.println("createNewStockItem: Item name= "+name+" provided sku number= " +sku.value );

	    // Test to see if we already have a sku item with this name already
	    int existingSKU = getSKUitemFromName( name );
	    if( existingSKU >= SKU_RANGE_MIN )
	    {
	        throw new SKUNameAlreadyExist( existingSKU );
	    }

	    int skuNum = 0;
	    // Are we using there number or creating a sku number
	    if ( sku.value > 0 )
	    {   // Test to see if we have a sku with this
	        if ( getSKUitem(sku.value) != null)
	        {   // this number already in use
		        throw new InvalidSKU();
	        }

	        skuNum = sku.value;
	    }
	    else
	    {   // make up an sku number
	        skuNum = createSKUnumber();
	    }

	    // Create the object to store the item
	    StockItem SKUItem = new StockItem();
	    SKUItem.setSku(skuNum);
	    SKUItem.setName(name);
	    SKUItem.setQty(0);
	    SKUItem.setPrice(-1.0f);
	    SKUItem.setReplacementSKU(-1);


	    // insert the new item into the map
	    m_SKUs.put(skuNum, SKUItem);

	    // Don't forget to set the returning sku value
	    sku.value = skuNum;
	    return;

	}

	public void deleteStockItem(int sku) throws InvalidSKU {
	    System.out.println("deleteStockItem: sku= " + sku );

	    // removing from map
	    System.out.println("Removing sku number from map");
	    if (m_SKUs.remove(sku) == null )
	    {
	        System.out.println("SKU not found");

	        throw new InvalidSKU();
	    }

	}

	public double getPrice(int sku) throws InvalidSKU {
	    System.out.println("getPrice: sku= " + sku );

	    StockItem SI = getSKUitem( sku );
	    if ( SI == null )
	    {
	        System.out.println("SKU not found");

	        throw new InvalidSKU();
	    }

	    System.out.println("SKU price is: " + SI.getPrice() );
	    return SI.getPrice();
	}

	public int getSKU(String name) throws InvalidSKUName {
	    System.out.println("getSKU: Request SKU for item: " + name );

	    int sku = getSKUitemFromName( name );
	    if( sku < SKU_RANGE_MIN )
	    {
	        throw new InvalidSKUName();
	    }

	    System.out.println("SKU = " + sku );
	    return sku;
	}

	public String getSKUName(int sku) throws InvalidSKU {
	    System.out.println("getSKUName: sku= " + sku );

	    StockItem SI = getSKUitem( sku );
	    if ( SI == null )
	    {
	        System.out.println("SKU not found");

	        throw new InvalidSKU();
	    }

	    return SI.getName();
	}

	public int getStockLevel(int sku) throws InvalidSKU {
	    System.out.println("getStockLevel: sku= " + sku );

	    StockItem SI = getSKUitem( sku );
	    if ( SI == null )
	    {
	        System.out.println("SKU not found");

	        throw new InvalidSKU();
	    }

	    System.out.println("SKU qty is: " + SI.getQty() );
	    return SI.getQty();
	}

	public void reduceStock(int sku, int number, IntHolder quantity)
			throws InvalidSKU, InvalidQTY {
    System.out.println("reduceStock: sku= " + sku + " change qty= " + number);

    StockItem SI = getSKUitem( sku );
    if ( SI == null )
    {
        System.out.println("SKU not found");

        throw new InvalidSKU();
    }

    if ( (SI.getQty() - number) < 0 )
    {
        System.out.println("SKU qty would be negatvie: " + (SI.getQty() - number));

        throw new InvalidQTY(SI.getQty(), number);
    }
    
    System.out.println("SKU qty was: " + SI.getQty() );
    SI.setQty(SI.getQty() - number);
    System.out.println("SKU qty now: " + SI.getQty() );

    // Set the quantity to return
    quantity.value = SI.getQty();
    return;

	}

	public void setPrice(int sku, double price) throws InvalidSKU {
	    System.out.println("setPrice: sku= " + sku + " price= " + price );

	    StockItem SI = getSKUitem( sku );
	    if ( SI == null )
	    {
	        System.out.println("SKU not found");

	        throw new InvalidSKU();
	    }

	    System.out.println("Setting SKU price to: " + price );
	    SI.setPrice(price);

	}
	
	private int createSKUnumber() {
	    System.out.println("createSKUnumber");

	    int skuNum = -1;
	    
	    do
	    {
	    	skuNum = (int) (Math.random() * (SKU_RANGE_MAX - SKU_RANGE_MIN + 1) ) + SKU_RANGE_MIN;
	        System.out.println("skuNum= " + skuNum );
	    } // Make sure we haven't used this number before
	    while ( m_SKUs.get( skuNum ) != null );

	    return skuNum;
	}

	private int getSKUitemFromName( String name ) {
	    System.out.println("getSKUitemFromName: Name = " + name );
	    int skuNum = SKU_RANGE_MIN - 1;

	    Set set = m_SKUs.entrySet();

	    Iterator it_SKUs = set.iterator();

	    while(it_SKUs.hasNext()){
	       Map.Entry me = (Map.Entry)it_SKUs.next();
	       System.out.println(me.getKey() + " : " + me.getValue() );
	       StockItem SI = (StockItem)me.getValue(); 
	       if(SI.getName().equals(name)) {
	          // Found it
	          skuNum = SI.getSku();
	          System.out.println("Found it: skuNum= " + skuNum );
	          break;	    	  
	      }
	    }

	    return skuNum;
	}

	private StockItem getSKUitem( int sku ) {
	   System.out.println("getSKUitem: sku = " + sku );

	    return (StockItem)m_SKUs.get(sku);
	}
}

