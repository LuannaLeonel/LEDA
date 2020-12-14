package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {

		return isBST() && this.isBalanced(avlTree.getRoot());
	}

	private boolean isBalanced(BSTNode<T> root) {
		int leftH;
		int rightH;

		if(root == null)
			return true;

		leftH = avlTree.height(root.getLeft());
		rightH = avlTree.height(root.getRight());

		if(Math.abs(leftH - rightH) <= 1 && isBalanced((BSTNode<T>) root.getLeft()) && isBalanced((BSTNode<T>) root.getRight()))
			return true;

		return false;
	}
}
