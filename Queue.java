
public class Queue {
	private int rear,front;
	private Object []elements;
	
	public Queue(int capacity) {
		elements=new Object[capacity];
		rear=-1;
		front=0;
	}
	boolean isEmpty() {
		return elements[front]==null;
	}
	boolean isFull() {
		return(front==(rear+1)%elements.length&&elements[front]!=null&&elements[rear]!=null);
	}
	void enqueue(Object data) {
		if(isFull())
			System.out.println("Queue is overflow");
		else {
			rear=(rear+1)%elements.length;
			elements[rear]=data;
		}
	}
	Object dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is overflow");
			return null;
		}
		else {
			Object retData=elements[front];
			elements[front]=null;
			front=(front+1)%elements.length;
			return retData;
		}
	}
	Object peek() {
		if(isEmpty()) {
			System.out.println("Queue is overflow");
			return null;
		}
		else
			return elements[front];
	}
	int size() {
		if(elements[front]==null) 
			return 0;
		else {
			if(rear>=front)
				return rear-front+1;
			else
				return elements.length-(front-rear)+1;
		}
	}
}
