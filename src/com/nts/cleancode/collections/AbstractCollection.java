package com.nts.cleancode.collections;

public abstract class AbstractCollection{
	protected static int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[10];
	protected int size = 0;
	protected boolean readOnly;

	public abstract void add(Object element);
	
	public void addAll(AbstractCollection c) {
		if (c instanceof Set) {
			Set s = (Set)c;
			for (int i=0; i < s.size(); i++) {
				if (!contains(s.getElementAt(i))) {
					add(s.getElementAt(i));
				}
			}
			
		} else if (c instanceof List) {
			AbstractCollection l = (AbstractCollection)c;
			for (int i=0; i < l.size(); i++) {
				if (!contains(l.get(i))) {
					add(l.get(i));
				}
			}
		} else if (c instanceof Map) {
			Map m = (Map)c;
			for (int i=0; i<m.size(); i++) 
				add(m.keys[i], m.values[i]);			
		}
	}
	
	public void add(Object key, Object value) {
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean contains(Object element) {
		for (int i=0; i<size; i++) 
			if (elements[i].equals(element))
				return true;
		return false;
	}
	public int size() {
		return size;
	}
	public boolean remove(Object element) {
		if (readOnly)
			return false;
		else 	
			for (int i = 0; i < size; i++)
				if (elements[i].equals(element)) {
					elements[i] = null;
					Object[] newElements = new Object[size - 1];
					int k = 0;
					for (int j = 0; j < size; j++) {
						if (elements[j] != null)
							newElements[k++] = elements[j];
					}
					size--;
					elements = newElements;
					return true;
				}
		return false;
	}
	public Object get(int i) {
		return elements[i];
	}
	public int capacity() {
		return elements.length;
	}
	public void set(int i, Object value) {
		if (!readOnly) {
			if (i >= size)
				throw new ArrayIndexOutOfBoundsException();
			elements[i] = value;
		}
	}
	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
