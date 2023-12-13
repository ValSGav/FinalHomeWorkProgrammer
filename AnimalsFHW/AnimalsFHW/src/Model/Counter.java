package Model;

public class Counter implements AutoCloseable {
    private int count;
    private boolean isClose;

    public Counter() {
        this.count = 0;
        this.isClose = false;
    }

    public void add() throws Exception {
        if (isClose) {
            throw new Exception("Ресурс закрыт, дальнейший подсчет новых животных невозможен!");
        } else {
            this.count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public void close() {
        isClose = true;
    }

}
