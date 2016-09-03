package pl.homik.calculator.operations;

/**
 * Created by Pawel on 2016-09-02.
 */
public abstract class Operation {
    private double a;
    private double b;
    private String operationName;

    private int stressModifier;

    public int getStressModifier() {
        return stressModifier;
    }

    protected void setStressModifier(int stressModifier) {
        this.stressModifier = stressModifier;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public abstract int stress();

    public Operation(double a, double b) {
        this.a = a;
        this.b = b;
        stressModifier = 50;
    }

    public abstract Double result();
    public abstract String getOperationName();


}
