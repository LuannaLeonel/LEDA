package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> right = ((BSTNode<T>) node.getRight());
		BSTNode<T> parent = ((BSTNode<T>) node.getParent());

		if (parent != null) {
			if (parent.getLeft().equals(node)) {
				parent.setLeft(right);
			} else {
				parent.setRight(right);
			}
		}
		right.setParent(parent);
		node.setParent(right);

		BTNode<T> left = right.getLeft();
		node.setRight(left);
		right.setLeft(node);

		if (left != null){
			left.setParent(node);
		}

		return right;
	}
	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();
		BSTNode<T> right = ((BSTNode<T>) pivot.getRight());
		BSTNode<T> parent = ((BSTNode<T>) node.getParent());

		if (parent != null) {
			if (parent.getLeft().equals(node)) {
				parent.setLeft(pivot);
			} else {
				parent.setRight(pivot);
			}
		}

		pivot.setParent(parent);
		node.setParent(pivot);
		node.setLeft(right);
		pivot.setRight(node);

		if (right != null) {
			right.setParent(node);
		}

		return pivot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
