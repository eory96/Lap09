package edu.handong.csee.java.lab09;//package name
/**
 * this class make getter and setter 
 * it make SlaesRepoter class can use SalesAssociate array 
 * @author samsung
 *
 */
public class SalesAssociate {//class name is SalesAssociate
	
	private String name;//this is for receiving name
	private double sales;//this is for receiving sales
	
	/**
	 * this method is set name and sales->constructor
	 */
	public void SalesAssociate() {//this method no has return value
		this.name = null;//this class name is initialization to null
		this.sales = 0;//this class variable sales initialization to 0
	}
	
	/**
	 * this method is get name from SalesReporter class
	 */
	public void setName(String name) {//this method have parameter and type is String
		this.name = name;//this class variable name initialize to name that from SalesReporter class
	}
	
	/**
	 * this method is get sales performance from SalesReporter class
	 * @param sales
	 */
	public void setSales(double sales) {//this method have parameter and type is double
		this.sales = sales;//this class variable sales initialize to sales that from SalesReporter class
	}
	
	/**
	 * this method is return name to SalesReporter
	 * @return
	 */
	public String getName() {//this method doensn't have parameter. use for calling name
		return this.name;//return value is name that declare in this class
	}
	/**
	 * this method is return sales to SalesReporter
	 * @return
	 */
	public double getSales() {//this method use for calling sales that store name of other class variable
		return this.sales;//return value is sales that declare in this class
	}
}