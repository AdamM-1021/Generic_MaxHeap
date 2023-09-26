public interface HeapElementInterface<E, K> {
    

    public int compareTo(E other);

    public K getKey();

    public void setKey(K key);

    public void setMin();
}
