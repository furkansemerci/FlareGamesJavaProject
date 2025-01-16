package MainAndSys;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import ChildAndParentClasses.Order;
import ChildAndParentClasses.Product;

public class FlareSys {
	
	
	private static ArrayList<Product> stock = new ArrayList<Product>(); //Stores the items information
	private static LinkedHashSet<Order> orders = new LinkedHashSet<Order>(); //Stores the order information
	
	
	public static int doesProductExist(Product p) {
		for(int i = 0; i<stock.size();i++) {
			if(stock.get(i).getName().equalsIgnoreCase(p.getName().trim()))
				return i;
		}
		return -1;
	}
	
	public static void addStock(Product p) {
			int index = doesProductExist(p);
			if(index == -1)
				stock.add(p);
			else {
				stock.get(index).incrementQuantity(p.getQuantity());
			}
	}
	
	public static void addOrder(Order o) {
			orders.add(o);
			
	}
	
	public static boolean removeProduct(int id) {
		for(int i= 0 ;i < stock.size();i++) {
			if(stock.get(i).getId() == id) {
				
				stock.remove(i);
				return true;
			}
			
		}
		return false;
	}
	
	public static Product findProductByID(int id) {
		for(Product p: stock) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	
	public static double calculateTotalPrice() { //calculates total price
		
		
		double total = 0.0;
		for(Order o: orders) {
			o.getProduct().tax(); //add the tax
			total += o.getProduct().getPrice() + o.getShippingFee();
		}
		
		return total;
	}
	
	public static String displayStock() {
		String output = "";
		
		for(Product p : stock) {
			output += p.toString();
		}
		
		return output;
	}
	
	public static String displayOrder() {
		String output = "";
		
		for(Order o : orders) {
			output += o.toString();
		}
		
		return output;
	}
	

	public static ArrayList<Product> getStock() {
		return stock;
	}

	public static LinkedHashSet<Order> getOrders() {
		return orders;
	}
	
	public static String[] getStockAsArray(int type) {
		
		ArrayList<String> temp = new ArrayList<>(); //a temporary array to store the items of a single type
		
		
		if(type==0) //if console
		{
			for(int i=0; i<stock.size(); i++)
				if(stock.get(i).getId()<300 && stock.get(i).getId()>99)
					{
						temp.add(stock.get(i).getId() + " - " + stock.get(i).getName() + " Stock: " + stock.get(i).getQuantity() + "\n");
						
					}
					 
		}else if(type==1) { //if game
			for(int i=0; i<stock.size(); i++)
				if(stock.get(i).getId()<500 && stock.get(i).getId()>299)
				{
					temp.add(stock.get(i).getId() + " - " + stock.get(i).getName() + " Stock: " + stock.get(i).getQuantity() + "\n");
					
				}
		}else if(type==2){ //if accessory
			for(int i=0; i<stock.size(); i++)
				if(stock.get(i).getId()<1000 && stock.get(i).getId()>499)
				{
					temp.add(stock.get(i).getId() + " - " + stock.get(i).getName() + " Stock: " + stock.get(i).getQuantity() + "\n");
					
				}
		}
		
		String[] arr = new String[temp.size()]; 
		
		for (int i = 0; i < temp.size(); i++) { //gets the content of the temporary array list to return
			arr[i] = temp.get(i);				//as a String array to fill Combo Box
		}
		
		return arr;
		
	}
	
}
