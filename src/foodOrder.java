import java.time.LocalTime;
import java.util.ArrayList;

public class foodOrder {
	Object ticket;
	ArrayList<Integer> quantity;
	ArrayList<foodItem> itemsAvailable;
	ArrayList<Boolean> itemsSelected;
	double totalCost;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} /////////////////////////////////////////////////////////
	

	public void setTicket(String ticketNumber) {
		if (validateTicketNumber(ticketNumber) == true) {
			this.ticket = findTicket(ticketNumber);
		} else {
			this.ticket = null;
		}
	}
	

	public Object getTicket() {
		return this.ticket;
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
	public void selectItems(ArrayList<Object> entryList) {
		ArrayList<String> quantity = new ArrayList<String>();
		ArrayList<Boolean> amended = new ArrayList<Boolean>();
		for (int i = 0; i < entryList.size(); i++) {
			quantity.add(entryList.get(i)); // getvalueinentry
		}
		boolean valid = validateQuantity(quantity);
		if (valid == true) {
			ArrayList<Integer> quantityInt = convertQuantityToInt(quantity);
			for (int i = 0; i < 12; i++) {
				this.itemsSelected.set(i,true);
				int stockLevel = this.itemsAvailable.get(i).getStockLevel();
				if (quantityInt.get(i) > stockLevel) {
					quantityInt.set(i,stockLevel);
					amended.set(i, true);
				}
			}
			setQuantity(quantityInt);
			ArrayList<Double> netPrices = new ArrayList<Double>();
			netPrices = calcNetPrice(this.itemsAvailable,quantityInt);
			double total = calcTotalCost(netPrices);
			//display confirmation screen
		} else {
			//display error pop up
		}
	}
	////////////////// confirm order
	public void confirmOrder(Object ticketEntry, Object nameEntry, ArrayList<Integer> quantityInt, double totalCost) {
		String ticketNumber = ticketEntry.toString(); // getvalueinENTRY
		setTicket(ticketNumber);
		String passengerName = nameEntry.toString();
		String errorString = validateDetails(passengerName);
		if (errorString == "") {
			//display error popup
		} else {
			for (int i = 0; i < 12; i++) {
				int currentStock = this.itemsAvailable.get(i).getStockLevel();
				int newStock = currentStock - quantity.get(i);
				if (newStock == 0) {
					this.itemsAvailable.get(i).markOutOfStock();
				}
			}
			Object ticket = getTicket();
			setTotalCost(totalCost);
			addCostToTicket(ticket, totalCost);
			// display success popup
		}
	}
	
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
	public String validateDetails(String passengerName) {
		String errorString = "";
		Object ticket = getTicket();
		boolean validName = validatePassengerName(passengerName);
		if (ticket == null) {
			errorString = "Invalid ticket number, you will be returned to the CONFIRMATION menu";
		} else if (validName == false) {
			errorString = "Invalid name, you will be returned to the CONFIRMATION menu";
		} else 
			if (passengerName != ticket.getPassengerName()) {
			errorString = "Details don’t match, you will be returned to the CONFIRMATION menu";
		}
		return errorString;
	}
	
	//////////// validate passenger name
	public boolean validatePassengerName(String passengerName) {
		boolean valid;
		if (passengerName.matches("[a-zA-Z][a-zA-Z\s]*")) {
			valid = true;
		} else {
			valid = false;
		}	
		return valid;
	}
	//////////// validate ticket number
	public boolean validateTicketNumber(String ticketNumber) {
		boolean valid = true;
		if (ticketNumber != null && ticketNumber.length() == 8) {
			try {
				Integer.parseInt(ticketNumber);
			} catch (NumberFormatException e) {
				valid = false;
			}
		} else {
			valid = false;
		}
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
	
	public double calcTotalCost(ArrayList<Double> netPrices) {
		double total = 0;
		for (int i = 0; i<netPrices.size(); i++) {
			total += netPrices.get(i);
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
