package Reader;

public abstract class Reader<T> {
    public T ob;

    public Reader(T ob){
        this.ob = ob;
    }
    abstract public void read();
}
