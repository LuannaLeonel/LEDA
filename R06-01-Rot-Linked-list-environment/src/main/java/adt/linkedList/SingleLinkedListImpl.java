package adt.linkedList;

import java.util.Arrays;
import java.util.Collection;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int counts = 0;
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()){
			counts++;
			aux = aux.getNext();
		}
		return counts;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.head;
		T res = null;
		while(!aux.isNIL()){
			if(aux.getData().equals(element)) {
				res = aux.getData();
			}
			aux = aux.getNext();
		}
		return res;

	}

	@Override
	public void insert(T element) {
		if (element != null){
			SingleLinkedListNode<T> aux = this.head;
			if(this.head.isNIL()){
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>();
				newHead.setData(element);
				newHead.setNext(new SingleLinkedListNode<>());
				this.setHead(newHead);
			}
			while(!aux.isNIL()){
				aux = aux.getNext();
			}
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<>());

		}
	}

	@Override
	public void remove(T element) {
		if(element != null){
			if(this.head.getData().equals(element)){
				this.head = this.head.getNext();
			} else {
				SingleLinkedListNode<T> aux = this.head;
				while(!aux.isNIL() && !aux.getData().equals(element)){
					aux =aux.getNext();
				}
			if(!aux.isNIL()) {
				aux.setData(aux.next.getData());
				aux.setNext(aux.getNext().getNext());
			}
		}

		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = this.head;
		int cont = 0;
		while(!aux.isNIL() && cont < this.size()){
			array[cont] = aux.getData();
			aux = aux.getNext();
			cont++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
