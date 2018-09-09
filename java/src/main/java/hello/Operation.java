package hello;

public class Operation {

    private final int a;
    private final int b;
    private final String operator;

    public Operation(long id, int a, int b, String operator) {
        this.a = a;
	this.b = b;
	this.operator = operator;
    }
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public String getOp() {
	return operator;
    }
}
