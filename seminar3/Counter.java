package seminar3;

import java.io.IOException;

public class Counter implements AutoCloseable {

    private int count;
    private boolean isClosed;

    public boolean isClosed() {
        return isClosed;
    }

    public int getCount() {
        return count;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void add() throws IOException {
        if (isClosed()) {
            throw new IOException();
        }
        count++;
    }

    @Override
    public void close() {
        setClosed(true);
    }

}