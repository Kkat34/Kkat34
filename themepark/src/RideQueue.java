import java.util.Queue;
import java.util.LinkedList;

//	public RideQueue()
public class RideQueue {
	private Queue<Ticket> queue;
	public RideQueue() {
		this.queue = new LinkedList<>();
	}

	//	public void addToQueue(Ticket ticket)
	public void addToQueue(Ticket ticket) {
		if (ticket != null) {
			queue.offer(ticket);
			System.out.println("Added to ride queue: " + ticket);
		}
	}

	//	public void removeFromQueue()
	public void removeFromQueue() {
		if (!queue.isEmpty()) {
			Ticket removedTicket = queue.poll();
			System.out.println("Removed from ride queue: " + removedTicket);
		} else {
			System.out.println("Ride queue is empty.");
		}
	}

	//	public void displayQueue()
	public void displayQueue() {
		if (queue.isEmpty()) {
			System.out.println("Ride queue is currently empty.");
		} else {
			System.out.println("Current ride queue:");
			for (Ticket ticket : queue) {
				System.out.println(ticket);
			}
		}
	}
	//	public String toString()
	@Override
	public String toString() {
		return queue.toString();
	}
}



