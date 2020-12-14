package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
												 HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(element != null){
			boolean full = true;
			int i = 0;
			while(i < this.table.length){

				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element,i);

				if (this.table[hash] == null || this.table[hash].equals(deletedElement) || this.table[hash].equals(element)){
					this.table[hash] = element;
					full = false;
					this.elements ++;
					break;
				}

				i++;
			}
			if(full) {
				throw new HashtableOverflowException();
			} else {
				this.COLLISIONS += i;

			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null){
			int i = 0;

			while (i< this.table.length){

				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element,i);

				if(this.table[hash] == null){
					break;
				} else if(this.table[hash].equals(element)){
					this.table[hash] =  this.deletedElement;
					this.elements--;
					break;
				}
				i++;
			}
		}


	}

	@Override
	public T search(T element) {

		T res = null;

		if(element != null){

			int i = 0;

			while(i< this.table.length){

				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element,i);

				if(this.table[hash] == null){
					break;
				} else if (this.table[hash].equals(element)){
					res = element;
					break;
				}
				i++;
			}
		}

		return res;

	}

	@Override
	public int indexOf(T element) {

		int index = -1;

		if (element != null) {

			int iterator = 0;

			while (iterator < this.table.length) {

				int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, iterator);

				if (this.table[hash] == null) {
					break;
				} else if (this.table[hash].equals(element)) {
					index = hash;
					break;
				}

				iterator++;

			}

		}

		return index;

	}

}