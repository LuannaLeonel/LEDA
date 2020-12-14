package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 *
 * Performs consistency validations within a AVL Tree instance
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	@Override
	public void insert(T element) {
		this.insert(this.root, element);
	}

	protected void insert(BSTNode<T> node, T element) {

		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);

			rebalanceUp(node);

		} else if (element.compareTo(node.getData()) > 0) {

			this.insert((BSTNode<T>) node.getRight(), element);

		} else if (element.compareTo(node.getData()) < 0) {

			this.insert((BSTNode<T>) node.getLeft(), element);

		}

	}

	@Override
	public void remove(T element) {

		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				rebalanceUp(node);
			} else if ((node.getRight().isEmpty() && !node.getLeft().isEmpty()
					|| node.getLeft().isEmpty() && !node.getRight().isEmpty())) {

				if (node.getParent() != null) {
					if (!node.getParent().getLeft().equals(node)) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}

					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
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

				rebalanceUp(node);
			} else {
				T sucessorNode = sucessor(node.getData()).getData();
				remove(sucessorNode);
				node.setData(sucessorNode);
			}
		}
	}


	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {

		if (node == null || node.isEmpty()) {
			return 0;
		}

		return this.height((BSTNode<T>) node.getRight()) - this.height((BSTNode<T>) node.getLeft());

	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {

		int balance = this.calculateBalance(node);

		if (balance < -1) {

			int balanceLeft = this.calculateBalance((BSTNode<T>) node.getLeft());

			if (balanceLeft > 0) {

				this.leftRotation((BSTNode<T>) node.getLeft());

			}

			this.rightRotation(node);

		} else if (balance > 1) {

			int balanceRight = this.calculateBalance((BSTNode<T>) node.getRight());

			if (balanceRight < 0) {

				this.rightRotation((BSTNode<T>) node.getRight());

			}

			this.leftRotation(node);

		}

	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			rebalance(node);
			rebalanceUp((BSTNode<T>) node.getParent());
		}
	}

	//AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.leftRotation(node);
		if (newNode.getParent() == null) {
			this.root = newNode;
		}
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.rightRotation(node);
		if (newNode.getParent() == null) {
			this.root = newNode;
		}
	}
}
