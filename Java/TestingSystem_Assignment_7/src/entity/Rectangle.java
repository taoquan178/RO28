package entity;

public class Rectangle extends Geometry{
    public Rectangle(Float a, Float b) throws Exception {
        super(a, b);
    }

    @Override
    public Float perimeterCalculation(Float a, Float b) {
        float c = (2 * (a + b));
        return c;
    }

    @Override
    public Float theArea(Float a, Float b) {
        float c =(a*b);
        return c;
    }
}
