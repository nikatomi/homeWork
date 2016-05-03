package Reader;

import java.io.File;

public abstract class DecoratorReader<T> extends Reader{
    protected Reader reader;
    protected File file;
    public DecoratorReader(T ob, Reader reader, String path) {
        super(ob);
        this.reader = reader;
        this.file = new File(path);
    }
}
