

public class DoublyLinkedList<E> {
	
	private static class Node<E>{
		private E value;
		private Node<E> next;
		private Node<E> prev;
		
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
		
		public Node<E> getPrev(){
			return this.prev;
		}
		
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
	}
	
	private int size;
	private Node<E> header, tailer;
	
	public DoublyLinkedList() {
		size = 0;
		header = new Node<>(null);
		tailer = new Node<>(null);
		header.setNext(tailer);
		header.setPrev(null);
		tailer.setPrev(header);
		tailer.setNext(null);
	}
	
	public void addFirst(E element) {
		Node<E> newNode = new Node<>(element);
		Node<E> oldHead = header.getNext();
		newNode.setNext(oldHead);
		oldHead.setPrev(newNode);
		newNode.setPrev(header);
		header.setNext(newNode);
		size++;
	}
	
	public void addLast(E element) {
		Node<E> newNode = new Node<>(element);
		Node<E> oldTail = tailer.getPrev();
		newNode.setNext(tailer);
		newNode.setPrev(oldTail);
		oldTail.setNext(newNode);
		tailer.setPrev(newNode);
		size++;
	}
	
	public E removeHead() {
		if(size == 0) {
			return null;
		}
		Node<E> oldHead = header.getNext();
		Node<E> newHead = oldHead.getNext();
		header.setNext(newHead);
		newHead.setPrev(header);
		size--;
		return oldHead.getValue();
	}
	
	public E removeTail() {
		if(size == 0) {
			return null;
		}
		
		Node<E> oldTail = tailer.getPrev();
		Node<E> newTail = oldTail.getPrev();
		
		tailer.setPrev(newTail);
		newTail.setNext(tailer);
		size--;
		return oldTail.getValue();
	}
	
	@Override
	public String toString() {
		if (this.size == 0)
			return "[]";
		StringBuffer sb = new StringBuffer();
		sb.append("Forward: ");
		sb.append('[');
		
		Node<E> current = header.getNext();
		for(int i = 0; i < size - 1; i++) {
			//System.out.println(i);
			sb.append(current.getValue());
			sb.append(", ");
			current = current.getNext();
		}
		
		sb.append(current.getValue());
		sb.append(']');
		sb.append('\n');
		
		sb.append("Backward: ");
		sb.append('[');
		
		current = tailer.getPrev();
		for(int i = 0; i < size - 1; i++) {
			//System.out.println(i);
			sb.append(current.getValue());
			sb.append(", ");
			current = current.getPrev();
		}
		
		sb.append(current.getValue());
		sb.append(']');
		
		
		
		return sb.toString();
	}
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
	
		list.addFirst(4);
		list.addFirst(3);
		System.out.println(list);
		System.out.println(list.removeTail());
		System.out.println(list);
		System.out.println(list.removeTail());
		System.out.println(list);
		System.out.println(list.removeTail());
		System.out.println(list);
		list.addFirst(1);
		System.out.println(list);
		list.addLast(2);
		System.out.println(list);
	}
}
