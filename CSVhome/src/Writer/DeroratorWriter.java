package Writer;

import java.io.File;

public abstract class DeroratorWriter<T> extends Writer {
    protected Writer writer;
    protected File file;
   public DeroratorWriter(T ob, Writer writer, String path) {
        super(ob);
        this.writer = writer;
        this.file = new File(path);
    }


}
