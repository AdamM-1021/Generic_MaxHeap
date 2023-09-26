import java.lang.reflect.Array;
import java.util.Arrays;


public class MaxHeap <K extends Comparable<K>, E extends HeapElementInterface<E, K>>{
    
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MaxHeap(Class<E> classType) {
        array = (E[]) Array.newInstance(classType, 1);
        size = 0;
    }

    public MaxHeap(E[] array) {
        this.array = array;
        size = array.length;
        buildMaxHeap();
    }


    private void heapify(E[] array, int i) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int largest;

        if (l < size && array[l].compareTo(array[i]) >= 0) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < size && array[r].compareTo(array[largest]) >= 0) {
            largest = r;
        }

        if (largest != i) {
            E temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, largest);
        }


    }

    private void buildMaxHeap() {
        int n = size;
        for(int i = (n/2)-1; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public E max() {
        if (size > 0) return array[0];
        else return null;
    }

    public E extractMax() {
        E max = array[0];
        array[0] = array[--size];
        heapify(array, 0);
        return max;
    }

    public void increaseKey(int i, K key) {
        if (key.compareTo(array[i].getKey()) <= 0 ) {
            return;
        }
        array[i].setKey(key);
        while (i >= 1 && array[(i-1)>>1].compareTo(array[i]) < 0) {
            E temp = array[i];
            array[i] = array[(i-1)>>1];
            array[(i-1)>>1] = temp;
            i = (i-1)>>1;
        } 
    }

    public void insert(E task) {
        if (size == array.length) {           
            array = Arrays.copyOf(array, size * 2);
        }
        size++;
        K key = task.getKey();
        task.setMin();;
        array[size-1] = task;
        increaseKey(size-1, key);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public E[] getHeap() {
        return array;
    }

    public int getSize() {
        return size;
    }
}
