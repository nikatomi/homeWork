package Writer;

public abstract class Writer<T>{
    public T ob;

   public Writer(T ob){
        this.ob = ob;
    }
    abstract public void write();
}
