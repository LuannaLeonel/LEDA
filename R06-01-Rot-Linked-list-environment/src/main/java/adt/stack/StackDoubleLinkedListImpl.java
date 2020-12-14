package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

import java.util.Arrays;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) throw new StackOverflowException();

		if (element != null) {
			this.top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) throw new StackUnderflowException();

		T top = this.top();
		this.top.removeFirst();

		return top;

	}
	@Override
	public T top() {
		T top = null;

		if (!this.isEmpty()) {

			T[] array = this.top.toArray();

			top = array[0] ;

		}
		return top;

	}

	@Override
	public boolean isEmpty() {
		return (this.top.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (this.top.size() == this.size);
	}

}
