
/**
 * this class implement Stack operation
 * push, pop, peek, top, isFull, isEmpty, display stack elements
 * and use this Stack on solving Infix Expression
 * @author yash.porwal_metacube
 *
 */
class StackInfix  {

	private int arr[];
	private int top;
	// total capacity of the stack
	private int capacity;

	/**
	 * constructor which takes size and make an array of that size 
	 * for Stack (FIFO - First In First Out)
	 * @param size as an integer 
	 */
	StackInfix(int size) {
		// initialize the stack variables
		this.arr = new int[size];
		this.capacity = size;
		this.top = -1;
	}

	/**
	 * Method to add element to the top of stack
	 * @param x data to add in stack
	 */
	public void push(int x) {
		if (isFull()) {
			System.out.println("Stack OverFlow");
			// terminates the program
			System.exit(1);
		}
		arr[++top] = x;
	}

	/**
	 * Method to delete element in top of stack
	 * @return top element
	 */
	public char pop() {
		if (isEmpty()) {
			System.out.println("STACK EMPTY");
			System.exit(1);
		}
	return (char) arr[top--];
	}

	/**
	 * Method to get size of the stack
	 * @return size
	 */
	public int getSize() {
		return top + 1;
	}

	/**
	 * Method to check if stack is empty or not
	 * @return boolean value
	 */
	 
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Method to check if queue is full or not
	 * @return boolean value
	 */ 
	public boolean isFull() {
		return top == capacity - 1;
	}

	/**
	 * Method to display elements of stack
	 */
	public void displayStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	/**
	 * to see the top value in the Stack
	 * @return the top value of stack
	 */
	public int peek() {
		if (!isEmpty()) {
			return arr[top];
		}
		else {
			System.out.println("Stack is empty");
			System.exit(1);
		}
	
		return -1;
	}
}