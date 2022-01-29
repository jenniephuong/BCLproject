import java.time.LocalTime;    

public class foodItem {
	String itemCode;
	String itemName;
	String description;
	int stockLevel;
	double price;
	LocalTime timePrompt;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	 public void setStockLevel(int newStockLevel) {
		this.stockLevel = newStockLevel;
	 }
	 
	 public int getStockLevel() {
		 return this.stockLevel;
	 }
	 
	 public String getItemName() {
		 return this.itemName;
	 }
	 
	 public String getDescription() {
		 return this.description;
	 }
	 
	 public double getPrice() {
		 return this.price;
	 }
	 
	 ///////////////////////
	 public void markInStock() {
		 
	 }
	 
	 public void markOutOfStock() {
		 
	 }
	 /////////////////////////
	 
	 public LocalTime getTimePrompt() {
		 return this.timePrompt;
	 }
	 
	 public void setTimePrompt() {
		 LocalTime currentTime = java.time.LocalTime.now(); 
		 LocalTime newTime = currentTime.plusMinutes(3);
		 this.timePrompt = newTime;
	
	 }
 
}