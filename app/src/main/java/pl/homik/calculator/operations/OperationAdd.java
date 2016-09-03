package pl.homik.calculator.operations;

/**
 * Created by Pawel on 2016-09-02.
 */
public class OperationAdd extends Operation{

    @Override
    public int stress() {
        return getStressModifier();
    }

    public OperationAdd(double a, double b ) {
       super(a, b);
       setStressModifier(getStressModifier() + 10);
   }

    @Override
    public Double result() {
        return getA() + getB();
    }

    @Override
    public String getOperationName() {
        return "dodawanie";
    }
}
