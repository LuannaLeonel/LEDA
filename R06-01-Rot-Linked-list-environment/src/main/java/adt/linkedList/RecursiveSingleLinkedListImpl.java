package adt.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {

		int cont = 0;
		if (!this.isEmpty()) {
			if (this.next == null) {
				cont = 1;
			} else {
				cont = 1 + this.next.size();
			}
		}
		return cont;
	}

	@Override
	public T search(T element) {
		T res = null;
		if(!this.isEmpty() && (element != null)){
			if(this.getData().equals(element)){
				res = this.getData();
			} else {
				res = this.getNext().search(element);
			}
		}
		return res;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
                this.setNext(new RecursiveSingleLinkedListImpl<T>());

            } else {
                this.getNext().insert(element);

				}
			}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.getData().equals(element)) {
				if (this.getNext().isEmpty()) {
					this.data = null;
                    this.setNext(this.getNext().getNext());
				} else {
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
				}
			} else {
				this.getNext().remove(element);
			}

		}

	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		auxToArray(array);

		return (T[]) array.toArray();
	}

	private void auxToArray(List<T> array){
		if (!this.isEmpty()) {
			array.add(this.getData());
			this.getNext().auxToArray(array);
		}
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
