package cr.ac.tec.DataStructures.LinkedList.List;

public interface List<T> {
    /**
     *
     * @param NewInfo
     */
    public abstract void AddHead(T NewInfo);

    /**
     *
     * @param Newinfo
     */
    public abstract void AddTail(T Newinfo);

    /**
     *
     * @return
     */
    public abstract T DeleteFromHead();

    /**
     *
     * @return
     */
    public abstract T DeleteFromTail();

    /**
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     *
     * @param info
     * @return
     */
    public abstract boolean inList(T info);

    /**
     *
     * @param position
     * @param content
     */
    public abstract void ChangeContent(int position, T content);

    /**
     *
     * @param position
     * @return
     */
    public abstract T get(int position);

    /**
     *
     * @param position
     */
    public abstract void delete(int position);

    /**
     *
     * @return
     */
    public abstract int getLength();
}
