package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		BSTNode root = bst.getRoot();
		BSTNode left = (BSTNode) bst.getRoot().getLeft();
		BSTNode right = (BSTNode) bst.getRoot().getRight();

		return isBST(root, left, right);
	}

	private boolean isBST(BSTNode root, BSTNode left, BSTNode right) {
		if (root == null)
			return true;

		if (left != null && ((T) root.getData()).compareTo((T) left.getData()) <= 0)
			return false;

		if (right != null && ((T) root.getData()).compareTo((T) right.getData()) >= 0)
			return false;

		return isBST((BSTNode) root.getLeft(), left, root) && isBST((BSTNode) root.getRight(), root, right);
	}
}
