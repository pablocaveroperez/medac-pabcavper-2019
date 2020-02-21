package controlador;

public interface ICrud<T> {

	public T[] getaVector();
	public byte getbContadorArray();
	public boolean add(T oObject);
	public boolean remove(T oObject);
	public int search(T oObject);
}
