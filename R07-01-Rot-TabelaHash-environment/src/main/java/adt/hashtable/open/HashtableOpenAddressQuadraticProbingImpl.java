package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(element != null){
			boolean full = true;
			int i = 0;
			while(i < this.table.length){

				int hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element,i);

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
				int hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, i);

				if(this.table[hash] == null){
					break;
				} else if(this.table[hash].equals(element)){
					this.table[hash] = this.deletedElement;
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

		if (element != null && !(this.isEmpty())){
			int hash = this.indexOf(element);

			if(hash != -1){
				res = (T) this.table[hash];
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

				int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, iterator);

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
