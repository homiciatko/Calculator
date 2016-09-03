package pl.homik.calculator.operations;

/**
 * Created by Pawel on 2016-09-03.
 */
public class OperationMultiplication extends Operation{
    @Override
    public int stress() {
        return 50;
    }

    public OperationMultiplication(double a, double b ) {
        super(a, b);
        setStressModifier(getStressModifier() + 10);
    }

    @Override
    public Double result() {
        return getA() * getB();
    }

    @Override
    public String getOperationName() {
        return "mnozenie";
    }
}

