package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for(Integer number : array) {
			super.insert(number);
		}
		return floor(super.getRoot(), numero);
	}
	private Integer floor(BTNode<Integer> node, double numero ){
		if(isNull(node)) return null;
		if(igualNode(node,numero)) return node.getData();
		if (isLeaf(node) && menorQueNode(numero, node)) return null;
		if (isLeaf(node)) return node.getData();
		if (menorQueNode(numero, node)) return floor(node.getLeft(), numero);
		return  max(node, floor(node.getRight(),numero));
	}


	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer e : array){
			super.insert(e);
		}
		return ceil(super.getRoot(), numero);
	}
	private Integer ceil(BTNode<Integer> node, double num){
		if (isNull(node)) return null;
		if(isLeaf(node) && maiorQueNode(num,node)) return  null;
		if(igualNode(node,num)) return node.getData();
		if(isLeaf(node)) return node.getData();
		if(maiorQueNode(num,node)) return ceil(node.getRight(), num);
		return min(node,ceil(node.getLeft(), num));
	}
	private boolean igualNode(BTNode<Integer> node, Double numero) {
		return numero.compareTo(Double.valueOf(node.getData())) == 0;
	}

	private boolean maiorQueNode(Double numero, BTNode<Integer> node) {
		return numero.compareTo(Double.valueOf(node.getData())) > 0;
	}

	private boolean isNull(Object obj) {
		return obj == null;
	}

	private boolean isLeaf(BTNode<Integer> node) {
		return isNull(node.getLeft()) && isNull(node.getRight());
	}


	private Integer max(BTNode<Integer> node1, Integer num) {
		if (isNull(node1)) return num;
		if (isNull(num)) return node1.getData();
		if (node1.getData().compareTo(num) > 0) return node1.getData();
		return num;
	}

	private Integer min(BTNode<Integer> node1, Integer num) {
		if (isNull(node1)) return num;
		if (isNull(num)) return node1.getData();
		if (node1.getData().compareTo(num) < 0) return node1.getData();
		return num;
	}

	private boolean menorQueNode(Double numero, BTNode<Integer> node) {
		return numero.compareTo(Double.valueOf(node.getData())) < 0;
	}

}
