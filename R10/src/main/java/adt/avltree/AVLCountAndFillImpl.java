package adt.avltree;

import adt.bst.BSTNode;
import java.util.Arrays;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance(BSTNode<T> node) {

		int balance = this.calculateBalance(node);

		if (balance < -1) {

			int balanceLeft = this.calculateBalance((BSTNode<T>) node.getLeft());

			if (balanceLeft > 0) {

				this.leftRotation((BSTNode<T>) node.getLeft());
				this.rightRotation(node);
				this.LRcounter++;

			} else if (balanceLeft < 0) {

				this.rightRotation(node);
				this.LLcounter++;

			}

		} else if (balance > 1) {

			int balanceRight = this.calculateBalance((BSTNode<T>) node.getRight());

			if (balanceRight < 0) {

				this.rightRotation((BSTNode<T>) node.getRight());
				this.leftRotation(node);
				this.RLcounter++;

			} else if (balanceRight > 0) {

				this.leftRotation(node);
				this.RRcounter++;

			}

		}

	}

	@Override
	protected void clear() {
		super.clear();
		this.LLcounter = 0;
		this.LRcounter = 0;
		this.RRcounter = 0;
		this.RLcounter = 0;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {

		this.clear();

		Arrays.sort(array);
		int maxPot = (int) Math.floor(Math.log10(array.length)/Math.log10(2));

		int[] visited = new int[array.length];

		for (int i = 1; i <= maxPot; i++) {

			double pot2 = Math.pow(2, i);
			int cont = 1, pos = (int) Math.floor(cont * array.length / pot2);

			do {

				cont++;

				if (visited[pos] == 0) {
					this.insert(array[pos]);
					visited[pos] = 1;
				}

				pos = (int) Math.floor(cont * array.length / pot2);

			} while (pos < array.length);

		}

		for (int i = 0; i < array.length; i++) {

			if (visited[i] == 0) {
				this.insert(array[i]);
				visited[i] = 1;
			}

		}

	}

	/*
	 * ALTERNATIVE APPROACH FOR fillWithoutRebalance
	 *
	 * Create a empty queue (Q for this example), or a data structure able to simulate its behavior.
	 * This queue should store the data as a Pair(a, b).
	 *
	 * Insert in the queue the first pair [0, array.length - 1]. The extremes of the array interval.
	 * Now, do the following routine:
	 *
	 * while Q is not empty:
	 * 		mid := (Q.front().val1 + Q.front().val2)/2
	 *  	AVL.insert(array[mid])
	 *  	Q.add([Q.front().val1, mid - 1])
	 *  	Q.add([mid + 1, Q.front().val2])
	 *  	Q.removeFront()
	 *
	 * Some additional conditions must be added to the routine, checking the bounds of the array.
	 * This approach as the implemented one is based in the fact that for avoid rotations, we need to fill
	 * the tree level by level. For this, we need to add always the mid of subintervals.
	 */

}
