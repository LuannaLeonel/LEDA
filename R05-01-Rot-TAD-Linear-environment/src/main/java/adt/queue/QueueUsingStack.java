package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();

		}
		try {
			stack1.push(element);
		} catch (StackOverflowException e) {
			;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){
			throw new QueueUnderflowException();
		}
		T head = null;
		move(stack1,stack2);
		try {
			head = stack2.pop();
		} catch (StackUnderflowException e){

		}
		move(stack2,stack1);
		return head;
	}

	@Override
	public T head() {
		if(stack1.isEmpty()) {
			return null;
		}

		T head = null;

		move(stack1,stack2);
		head = stack2.top();
		move(stack2,stack1);

		return head;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return  stack1.isEmpty();
	}
	private void move(Stack<T> stack1, Stack<T> stack2) {

		try{

			while(!(stack1.isEmpty())) {

				stack2.push(stack1.pop());
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
