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
    public int evaluate() {

        int result = -1;
        switch 	(operator) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mul":
                result = a * b;
                break;
        }
        return result;
    }

}
