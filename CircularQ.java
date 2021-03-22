import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class is used to implement circular Queue
 * @author yash.porwal_metacube
 *
 */
public class CircularQ {
	
	private int size, front, rear;   
	private ArrayList<Integer> queue = new ArrayList<Integer>(); 
	  
	// Constructor 
	CircularQ(int size) { 
	    this.size = size; 
	    this.front = this.rear = -1; 
	} 
	
	/**
	 * Method to add data item into queue 
	 * if queue is not full otherwise displays a message
	 * @param data: the data item to add
	 */
	public void Enqueue(int data) {
		  
	    if((front == 0 && rear == size - 1) || 
	      (rear == (front - 1) % (size - 1))) { 
	        System.out.print("Queue is Full"); 
	    } 
	  
	    // condition for empty queue. 
	    else if(front == -1) { 
	        front = 0; 
	        rear = 0; 
	        queue.add(rear, data); 
	    }
	    
	  /**
	   * Circular Q condition lies here. 
	   */
	    else if(rear == size - 1 && front != 0) { 
	        rear = 0; 
	        queue.set(rear, data); 
	    } 
	  
	    else { 
	        rear = (rear + 1);  
	        if(front <= rear) { 
	            queue.add(rear, data); 
	        } 
	       
	        else { 
	            queue.set(rear, data); 
	        } 
	    } 
		
	}
	
	/**
	 * Method to delete an element from front of queue
	 */
	 
	public int deQueue() {
		int temp; 
		  
	    if(!isEmpty()) {
			temp = queue.get(front);

			// Condition for only one element
			if (front == rear) {
				front = -1;
				rear = -1;
			}

			else if (front == size - 1) {
				front = 0;
			}
			
			else {
				front = front + 1;
			}

			return temp;
		}
	    else {
	    	System.out.print("Queue is Empty,so deletion is not possible "); 
	    	return -1; 
	    }
	}
	/**
	 * Method to check if queue is fully empty or not
	 * @return boolean value
	 */
	 
	public boolean isEmpty() {
		if(front == -1) {    
	        return true;  
	    } 
		return false;
	}

	/**
	 * Method to check if queue is full or not
	 * @return boolean value
	 */
	 
	public boolean isFull() {
		if((front == 0 && rear == size - 1) || 
				(rear == (front - 1) % (size - 1)))  { 
					return true;
			    }
			return false;
		}

	/**
	 * Method to display all the elements of queue
	 */
	 
	public void displayQueue() {
		
	    if(front == -1) { 
	        System.out.print("Queue is Empty"); 
	        return; 
	    } 
	  
	    System.out.print("Elements in the circular queue are: "); 
	    
	    // If rear has not crossed the max size or rear is still greater then front 
	    if(rear >= front)  { 
	        for(int i = front; i <= rear; i++) { 
	            System.out.print(queue.get(i)); 
	            System.out.print(" "); 
	        } 
	        System.out.println(); 
	    } 
	  
	    else { 
	          
	        // Loop for printing elements from  front to max size or last index 
	        for(int i = front; i < size; i++)  { 
	            System.out.print(queue.get(i)); 
	            System.out.print(" "); 
	        } 
	  
	        // Loop for printing elements from 0th index till rear position 
	        for(int i = 0; i <= rear; i++)  { 
	            System.out.print(queue.get(i)); 
	            System.out.print(" "); 
	        } 
	        System.out.println(); 
	    } 
		
	}

	//main method
	public static void main(String[] args) { 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of queue");
	    CircularQ q = new CircularQ(sc.nextInt()); 
	    boolean flag=true;
	    while(flag) {
	    	System.out.println("\nEnter your choice\n"+"1: Enqueue\n"+"2: Dequeue\n"+"3: IsEmpty\n"+"4: IsFull\n"+ "5: displayQueue\n"+"6: Exit");  
	    	int choice=sc.nextInt();
	    
	    	switch(choice) {
		    	case 1:
		    		if(q.isFull()) {
		    			System.out.println("More items can't be inserted");
		    		}
		    		else {
		    			System.out.println("Enter data to insert:");
		    			q.Enqueue(sc.nextInt());
		    		}
		    		break;
		
		    	case 2:
					int x = q.deQueue(); 
				    // Checking for empty queue. 
				    if(x != -1) { 
				        System.out.print("Deleted value = "); 
				        System.out.println(x); 
				    }
					break;
			
				case 3:
					if(q.isEmpty()) {
						System.out.println("queue is empty");
					}
					else
						System.out.println("Queue is not empty");
					break;
			
				case 4:
					if(q.isFull()) {
						System.out.println("queue is full");
					}
					else
						System.out.println("Queue is not full");
					break;
				case 5:
					q.displayQueue();
					break;
					
				case 6:
					flag=false;
					break;
					
				default:
					System.out.println("Invalid input! Try again");
		    }
	    }
	} 
}