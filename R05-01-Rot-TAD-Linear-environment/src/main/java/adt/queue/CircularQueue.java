package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if(isEmpty()){
			this.head++;
		}
		tail = (this.tail +1) % array.length;
		this.array[tail] = element;
		elements++;

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		T element = this.array[head];
		head = (this.head + 1) % array.length;
		elements--;
		return element;
	}

	@Override
	public T head() {
		T head = null;

		if(!isEmpty()){
			head = this.array[this.head];
		}

		return head;
	}

	@Override
	public boolean isEmpty() {
		return (this.head == -1);
	}

	@Override
	public boolean isFull() {
		return (this.tail == array.length -1);
	}

}
