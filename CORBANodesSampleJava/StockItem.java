/** 
* Sample program for use with IBM WebSphere Message Broker
* © Copyright International Business Machines Corporation 2010 
* Licensed Materials - Property of IBM
*/
public class StockItem {
	
    int sku;
    String name;
    double price;
    int qty;
    int replacementSKU;

	public StockItem() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReplacementSKU() {
		return replacementSKU;
	}

	public void setReplacementSKU(int replacementSKU) {
		this.replacementSKU = replacementSKU;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

}
