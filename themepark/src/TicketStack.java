import java.util.LinkedList;
import java.util.Stack;

public class TicketStack {
	private Stack<Ticket> stack;
	private int ticketCounter;

	public TicketStack() {
		this.stack = new Stack<>();
		this.ticketCounter = 1;
	}

	public void sellTicket(String customerName) {
		String ticketID = "TICKET" + ticketCounter++;
		Ticket newTicket = new Ticket(ticketID, customerName);
		stack.push(newTicket);
		System.out.println("Sold ticket: " + newTicket);
	}

	public void returnTicket() {
		if (!stack.isEmpty()) {
			Ticket returnedTicket = stack.pop();
			System.out.println("Returned ticket: " + returnedTicket);
		} else {
			System.out.println("No tickets to return.");
		}
	}

	public void displayTickets() {
		if (stack.isEmpty()) {
			System.out.println("No tickets currently available.");
		} else {
			System.out.println("Current tickets in stack:");
			for (Ticket ticket : stack) {
				System.out.println(ticket);
			}
		}
	}

	public boolean isValidTicket(String ticketID) {
		for (Ticket ticket : stack) {
			if (ticket.getTicketID().equals(ticketID)) {
				return true;
			}
		}
		return false;
	}

	public Ticket getTicketByID(String ticketID) {
		for (Ticket ticket : stack) {
			if (ticket.getTicketID().equals(ticketID)) {
				return ticket;
			}
		}
		return null;
	}
}


