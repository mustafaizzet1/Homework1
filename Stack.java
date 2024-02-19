
public class Stack {
	private int top;
	private Object []elements;
	
	
	public Stack(int capacity) {
		elements=new Object[capacity];
		top=-1;
		
	}
	public boolean isFull() {
		return top+1==elements.length;
	}
	public void push(Object data) {
		if(isFull())
			System.out.println("Stack overflow");
		else {
			top++;
			elements[top]=data;
		}
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public Object pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			Object retdata=elements[top];
			elements[top]=null;
			top--;
			return retdata;
			
		}
	}
	public Object peek(){
		
		if(isEmpty()) {
			return null;
		}
		else {
			return elements[top];
			
		}
	}
	public int size() {
		return top+1;
		
	}
	
	
	
	

}
