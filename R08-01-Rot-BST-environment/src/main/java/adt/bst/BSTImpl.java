package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}
	private int height(BTNode<T> node){
		int height = -1;
		if(!node.isEmpty()){
			height = 1+ Math.max(height(node.getLeft()), height(node.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = new BSTNode<>();

		if (element != null) {
			if (!isEmpty()) {
				result = search(this.root, element);
			}
		}

		return result;
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> aux = new BSTNode<>();

		if(!node.isEmpty()) {
			if (node.getData().equals(element)) {
					aux = node;
			} else if (node.getData().compareTo(element) > 0) {
					aux = search((BSTNode<T>) node.getLeft(), element);
			} else {
					aux = search((BSTNode<T>) node.getRight(), element);
			}
		}

		return aux;

	}

	@Override
	public void insert(T element) {
		if(element != null) {
			insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
			node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());

		} else {
			if (node.getData().compareTo(element) > 0){
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {

		if(isEmpty()){
			return null;
		} else {
			return maximum(this.root);
		}

	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (!node.getRight().isEmpty()) {
			return maximum((BSTNode<T>) node.getRight());
		}
		return node;
	}

	@Override
	public BSTNode<T> minimum() {
		if (isEmpty()){
			return null;
		} else{
			return minimum(this.root);
		}
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (!node.getLeft().isEmpty()) {
			return minimum((BSTNode<T>) node.getLeft());
		}
		return node;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);

		if (element != null && !this.root.isEmpty() && !node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				node = minimum((BSTNode<T>) node.getRight());
			} else {
				node = sucessor(node);
			}
		} else {
			node = null;
		}

		return node;
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> sucessor = (BSTNode<T>) node.getParent();

		if (node.getParent() != null) {

			if (!sucessor.isEmpty() && sucessor.getRight().equals(node)) {
				sucessor = sucessor((BSTNode<T>) node.getParent());
			}
		}
		return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> res = search(element);

		if (element != null && !this.root.isEmpty() && !res.isEmpty()) {
			if (!res.getLeft().isEmpty()) {
				res = maximum((BSTNode<T>) res.getLeft());
			} else {
				res = predecessor(res);
			}
		} else {
			res = null;
		}

		return res;
	}

	private BSTNode<T> predecessor (BSTNode<T> node) {
		BSTNode<T> predecessor = (BSTNode<T>) node.getParent();

		if (node.getParent() != null) {

			if (!predecessor.isEmpty() && predecessor.getLeft().equals(node)) {
				predecessor = predecessor((BSTNode<T>) node.getParent());
			}
		}

		return predecessor;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);

			} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();

				if (parent != null) {
					if (!parent.getLeft().equals(node)) {
						if (!node.getLeft().isEmpty()) {
							parent.setRight(node.getLeft());
							node.getLeft().setParent(parent);
						} else {
							parent.setRight(node.getRight());
							node.getRight().setParent(parent);
						}

					} else {
						if (!node.getLeft().isEmpty()) {
							parent.setLeft(node.getLeft());
							node.getLeft().setParent(parent);
						} else {
							parent.setLeft(node.getRight());
							node.getRight().setParent(parent);
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getRight();
					} else {
						this.root = (BSTNode<T>) node.getLeft();
					}
					this.root.setParent(null);
				}
			} else {
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[this.size()];
			preOrder(this.root, 0, array);
		return array;
	}

	private void preOrder(BSTNode<T> node, int i, T[] array) {
		if(!node.isEmpty()){
			array[i] = node.getData();
			preOrder((BSTNode<T>) node.getLeft(), i+ 1, array);
			preOrder((BSTNode<T>) node.getRight(), i + 1 + size((BSTNode<T>) node.getLeft()), array);
		}
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()];

		order(this.root, 0, array);

		return array;
	}

	private int order(BSTNode<T> node, int i, T[] array) {
		if (!node.isEmpty()){
			i = order((BSTNode<T>) node.getLeft(), i, array);
			array[i++] = node.getData();
			i = order((BSTNode<T>) node.getRight(), i, array);
		}
		return i;
	}

	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[this.size()];

		postOrder(this.root, 0, array);

		return array;
	}

	private int postOrder(BSTNode<T> node, int i, T[] array) {
		if(!node.isEmpty()){
			i = postOrder((BSTNode<T>) node.getLeft(), i, array);
			i = postOrder((BSTNode<T>) node.getRight(), i, array);
			array[i++] = node.getData();
		}
		return i;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
