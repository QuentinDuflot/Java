package ueb20;

import java.util.Collection;
import java.util.Iterator;

public class MinHeap<E extends Comparable<E>> implements java.util.Queue<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private E[] heap;
	private int length;

	/**
	 * Default Constructor
	 * default capacity of 9 (0 index is not used)
	 */
	public MinHeap() {
		heap = (E[]) new Comparable[DEFAULT_CAPACITY];
		length = 0;
	}

	/**
	 * Constructor - takes an array of type T and a boolean for min/max
	 * @param array E[] array
	 */
	public MinHeap(E[] array) {
		heap = (E[]) new Comparable[DEFAULT_CAPACITY];
		length = 0;

		// add each element to the heap
		for (E each : array) {
			add(each);
		}
	}

	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode addAll");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode clear");
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode contains");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode containsAll");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode isEmpty");
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode iterator");
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode remove");
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode removeAll");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode retainAll");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode size");
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode toArray");
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode toArray");
	}

	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode add");
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException("Methode element");
	}
	
	public int getLength() {
		return DEFAULT_CAPACITY;
	}

	/**
	 * if child has a parent
	 * @param i integer - index
	 * @return true if index > 1
	 */
	private boolean hasParent(int i) {
		return i > 1;
	}

	/**
	 * get index of parent from child node
	 * @param i index
	 * @return index of parent
	 */
	private int parentIndex(int i) {
		return i / 2;
	}

	/**
	 * get parent value
	 * @param i index
	 * @return value of type T
	 */
	private E parent(int i) {
		return heap[parentIndex(i)];
	}

	/**
	 * Swap two values in heap
	 * @param index1 int first index
	 * @param index2 int second index
	 */
	private void swap(int index1, int index2) {
		E temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	private void bubbleUp() {
		int index = length;

		while (hasParent(index) && ((parent(index)).compareTo(heap[index]) > 0)) {
			swap(index, parentIndex(index));
			index = parentIndex(index);
		}
	}

	/**
	 * Get left index mathematically
	 * @param i index
	 * @return index of left node from index i
	 */
	private int leftIndex(int i) {
		return i * 2;
	}

	/**
	 * Get right index mathematically
	 * @param i index
	 * @return index of right node from index i
	 */
	private int rightIndex(int i) {
		return i * 2 + 1;
	}

	/**
	 * Test to see if node has left child
	 * @param i index
	 * @return true if it does
	 */
	private boolean hasLeftChild(int i) {
		return leftIndex(i) <= length;
	}

	/**
	 * Test to see if node has right child
	 * @param i index
	 * @return true if it does
	 */
	private boolean hasRightChild(int i) {
		return rightIndex(i) <= length;
	}

	private void bubbleDown() {
		int index = 1;

		while (hasLeftChild(index)) {
			// find smaller of child values
			int smaller = leftIndex(index);
			if (hasRightChild(index) && (heap[leftIndex(index)]).compareTo(heap[rightIndex(index)]) > 0) {
				smaller = rightIndex(index);
			}
			if ((heap[index]).compareTo(heap[smaller]) > 0) {
				swap(index, smaller);
			} else
				break;

			index = smaller;
		}
	}
	
	/**
	 * Show heap content
	 * @return
	 */
	public String showContent() {
		System.out.println("Inhalt des MinHeaps: ");
		
		String result = "";
		for(int i = 0; i < getLength(); i++) {
			result += heap[i] +" - ";
		}
		return result;
	}

	@Override
	public boolean offer(E e) {
		if (this.length >= heap.length - 1) {
			return false;
		}

		length++;
		heap[length] = e;
		bubbleUp();
		return true;
	}

	@Override
	public E peek() {
		if (length == 0)
			return null;
		return heap[1];
	}

	@Override
	public E poll() {
		if (length == 0)
			return null;

		E result = peek();

		swap(1, length);
		heap[length] = null;
		length--;

		bubbleDown();

		return result;
	}

	@Override
	public E remove() {
		throw new java.lang.UnsupportedOperationException("Methode remove");
	}
}