package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element) {

		if (element != null) {
			DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
			if (this.isEmpty()) {
				auxNode.setData(element);
				auxNode.setNext(new DoubleLinkedListNode<>());
				auxNode.setPrevious(new DoubleLinkedListNode<>());
				this.setLast(auxNode);
				this.setHead(auxNode);
			} else {
				if (this.getHead() instanceof DoubleLinkedListNode<?>) {
					auxNode = (DoubleLinkedListNode<T>) this.getHead();
				}
				while (!auxNode.getNext().isNIL()) {
					if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {
						auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
					}
				}
				auxNode.setNext(new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), auxNode));
				if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {
					this.setLast((DoubleLinkedListNode<T>) auxNode.getNext());
				}
			}
		}
	}
	@Override
	public void remove(T element) {

		if (element != null) {

			if (!this.isEmpty()) {

				if (this.size() == 1) {

					this.last = new DoubleLinkedListNode<T>();
					this.setHead(this.last);

				} else {

					if (this.getHead().getData().equals(element)) {

						this.setHead(this.getHead().getNext());

					} else {

						DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();

						if (this.getHead() instanceof DoubleLinkedListNode<?>) {

							auxNode = (DoubleLinkedListNode<T>) this.getHead();

						}

						while(!auxNode.isNIL()) {

							if (auxNode.getData().equals(element)) {

								auxNode.getPrevious().setNext(auxNode.getNext());
								( (DoubleLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());

							}

							if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {

								auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();

							}

						}

					}

				}

			}

		}

	}

	@Override
	public void insertFirst(T element) {

		if (element != null) {

			if (this.isEmpty()) {

				this.last = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
				this.setHead(this.last);

			} else {

				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
				auxNode.setData(this.getHead().getData());
				auxNode.setNext(this.getHead().getNext());

				this.setHead(new DoubleLinkedListNode<T>(element, auxNode, new DoubleLinkedListNode<T>()));

				if (this.getHead() instanceof DoubleLinkedListNode<?>) {

					auxNode.setPrevious((DoubleLinkedListNode<T>) this.getHead());

				}
			}

		}

	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()){
			this.setHead(this.getHead().getNext());
		}
		if (this.head.isNIL()){
			this.last = new DoubleLinkedListNode<>();
		}
		if (this.getHead() instanceof DoubleLinkedList<?>){
			((DoubleLinkedListNode<T>) this.head).setPrevious((DoubleLinkedListNode<T>) this.getHead());
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			this.last = this.last.getPrevious();

			if (this.last.isNIL()) {
				this.head = this.last;
			}

			this.last.setNext(new DoubleLinkedListNode<T>());

		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
