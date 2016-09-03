package pl.homik.calculator.operations;

/**
 * Created by Pawel on 2016-09-03.
 */
public class OperationDivision extends Operation {
    @Override
    public int stress() {
        return 50;
    }

    public OperationDivision(double a, double b ) {
        super(a, b);
        setStressModifier(getStressModifier() + 10);
    }

    @Override
    public Double result() {
        if (getB() == 0)
            throw new IllegalArgumentException("division by 0!!");
        else
            return (getA() / getB());
    }

    @Override
    public String getOperationName() {
        return "dzielenie";
    }
}

