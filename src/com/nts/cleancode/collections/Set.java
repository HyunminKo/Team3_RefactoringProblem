package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (contains(element))
			return;
		if (readOnly)
			return;
			if (shouldGrow()) {
				grow();
			}
			addElement(element);
	}

	private void addElement(Object element) {
		elements[size++] = element;
	}

	private boolean shouldGrow() {
		return (size + 1) > elements.length;
	}

	private void grow() {
		Object[] newElements =
			new Object[elements.length + INITIAL_CAPACITY];
		for (int i = 0; i < size; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	public Object getElementAt(int index) {
		return elements[index];
	}

}
