package Van_Deli_MVC_Package;

/*
 * Model_Van_Deli.java
 * This Model class is a skeleton/representation of the results 
 * received after the execution of queries and retrieving 
 * the data from the database.
 *
 */
public class Model_Van_Deli {
	
	protected String customer_id;
	protected String order_date;
	protected String product_name;
	protected int price;
	protected String member;
	protected int ranking;
	protected int purchase_count;
	
	public Model_Van_Deli() {}
	
	public Model_Van_Deli(String product_name, int purchase_count) {
		this.product_name = product_name;
		this.purchase_count = purchase_count;
	}
	
	public Model_Van_Deli(String customer_id, String order_date, String product_name, int price, String member, int ranking) {
		this.customer_id = customer_id;
		this.order_date = order_date;
		this.product_name = product_name;
		this.price = price;
		this.member = member;
		this.ranking = ranking;
	}
	
}
