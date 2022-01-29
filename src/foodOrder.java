import java.time.LocalTime;
import java.util.ArrayList;

public class foodOrder {
	String ticketNumber;
	String passengerName;
	ArrayList<Integer> quantity;
	ArrayList<Boolean> itemsSelected;
	double totalCost;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} /////////////////////////////////////////////////////////
	

	public void setPassengerName(String newName) {
		this.passengerName = newName;
	}
	
	public String getPassengerName() {
		return this.passengerName;
	}

	public void setTicketNumber(String newTicketNumber) {
		this.ticketNumber = newTicketNumber;
	}
	
	public String getTicketNumber() {
		return this.ticketNumber;
	}

	public void setQuantity(ArrayList<Integer> newQuantity) {
		this.quantity = newQuantity;
	}
	
	public ArrayList<Integer> getQuantity() {
		return this.quantity;
	}
	
	public void setItemsSelected(ArrayList<Boolean> newItemsSelected) {
		this.itemsSelected = newItemsSelected;
	}
	
	public ArrayList<Boolean> getItemsSelected() {
		return this.itemsSelected;
	}
	
	public void setTotalCost(double total) {
		this.totalCost = total;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	//////// from the bottom up 
	//////////////////////////
	
	////////////////// select items
	////////////////// confirm order
	
	//////////// validate quantity
	public boolean validateQuantity(ArrayList<String> quantity) {
		boolean valid = true;
		try {
			for (int i = 0; i<12; i++) {
				int value = Integer.parseInt(quantity.get(i));
				if (value > 100 || value < 0) {
					valid = false;
				}
			}
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;
	}
	
	///////////// convert quantity to int
	public ArrayList<Integer> convertQuantityToInt(ArrayList<String> quantity) {
		ArrayList<Integer> intQuantity = new ArrayList<Integer>();
		for (int i = 0; i<12; i++) {
			intQuantity.add(Integer.parseInt(quantity.get(i)));
		}
		return intQuantity;
	}
	
	//////////// validate details
	public String validateDetails(String ticketNumber, String passengerName) {
		String errorString = "";
		
		boolean validTicket = validateTicketNumber(ticketNumber);
		boolean validName = validatePassengerName(passengerName);
		if (validTicket == false) {
			errorString = "Invalid ticket number, you will be returned to the CONFIRMATION menu";
		} else if (validName == false) {
			errorString = "Invalid name, you will be returned to the CONFIRMATION menu";
		} //// name and ticket do not match 
		else if (validName== false) {
			errorString = "Details don’t match, you will be returned to the CONFIRMATION menu";
		}
		return errorString;
	}
	
	//////////// validate passenger name
	public boolean validatePassengerName(String passengerName) {
		boolean valid = true;
		return valid;
	}
	//////////// validate ticket number
	public boolean validateTicketNumber(String ticketNumber) {
		boolean valid = true;
		return valid;
	}
	
	public ArrayList<Double> calcNetPrice(ArrayList<foodItem> items, ArrayList<Integer> quantity) {
		ArrayList<Double> netPrices = new ArrayList<Double>();
		double netPrice = 0;
		for (int i = 0; i < 12; i++) {
			netPrice = (items.get(i)).getPrice();
			netPrices.add(netPrice);
		}
		return netPrices;
	}
	
	public double calcTotalCost(double[] netPrices) {
		double total = 0;
		for (int i = 0; i<netPrices.length; i++) {
			total += netPrices[i];
		}
		return total;
	}
	
	
	/////////// check for restock
	
	public void restock(foodItem item) {
		LocalTime currentTime = java.time.LocalTime.now();
		LocalTime restockTime = item.getTimePrompt();
		if (currentTime.compareTo(restockTime) >= 0) {
			item.setStockLevel(100);
			item.markInStock();
		}
	}
	
}
