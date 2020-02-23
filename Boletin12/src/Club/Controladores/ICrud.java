package Club.Controladores;

public interface ICrud<T> {
    T[] getaVector();
    byte getbContadorArray();
    boolean add(T oObject);
    boolean remove(T oObject);
    int search(T oObject);
}
