package hello;

public class Result {

    private final long id;
    private final int a;

    public Result(long id, int a) {
        this.id = id;
        this.a = a;
    }

    public long getId() {
        return id;
    }

    public int getA() {
        return a;
    }
}
