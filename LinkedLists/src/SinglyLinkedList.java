
public class SinglyLinkedList <E>{
	private Node<E> head, tail;
	private int size;
	
	private static class Node<E>{
		private E value;
		private Node<E> next;
		
		Node(E value){
			this.value = value;
		}
		
		public E getValue() {
			return this.value;
		}
		
		public Node<E> getNext(){
			return this.next;
		}
		
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	public SinglyLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public void addFirst(E element) {
		Node <E> newNode = new Node<>(element);
		newNode.setNext(head);
		head = newNode;
		if(size == 0) {
			tail = head;
		}
		size++;
	}
	
	public void addLast(E element) {
		Node <E> newNode = new Node<>(element);
		newNode.setNext(null);
		if(size == 0) {
			head = newNode;
		}
		else {
			tail.setNext(newNode);
		}
		
		tail = newNode;
		size++;
	}
	
	public E removeHead() {
		if(size == 0) {
			return null;
		}
		E result = head.getValue();
		head = head.getNext();
		size--;
		if(size == 0) { //case where there was previously only 1 node (head = tail)
			tail = null;
		}
		return result;
	}
	
	public E removeLast() {	//removing last does not run in constant time it runs in O(n)
		if(size == 0) {
			return null;
		}
		E result = tail.getValue();
		//head = head.next;
		if(size == 1) {
			tail = null;
		}
		else {
			Node<E> current = head;
			while(current.getNext() != tail) {
				current = current.getNext();
			}
			current.setNext(null) ;
			tail = current;
		}
		size--;
		if(size == 0) { //case where there was previously only 1 node (head = tail)
			head = null;
		}
		return result;
	}
	
	@Override
	public String toString() {
		if (this.size == 0)
			return "[]";
		StringBuffer sb = new StringBuffer();
		sb.append('[');
		
		Node<E> current = head;
		for(int i = 0; i < size - 1; i++) {
			sb.append(current.getValue());
			sb.append(", ");
			current = current.getNext();
		}
		
		sb.append(current.getValue());
		sb.append(']');
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addFirst(1);
		list.addFirst(3);
		list.addLast(4);
		list.addLast(5);
		System.out.println(list);
		System.out.println(list.removeHead());
		System.out.println(list);
		
		System.out.println(list.removeLast());
		System.out.println(list);
		System.out.println(list.removeLast());
		System.out.println(list);
		list.addFirst(0);
		list.addLast(2);
		System.out.println(list);
		System.out.println(list.removeLast());
		System.out.println(list);
		System.out.println(list.removeLast());
		System.out.println(list);
		
		list.addFirst(10);
		list.addLast(1100);
		System.out.println(list);


	}
	
}
