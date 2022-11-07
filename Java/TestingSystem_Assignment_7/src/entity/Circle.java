package entity;

public class Circle extends Geometry{
    public Circle(Float a, Float b) throws Exception {
        super(a, b);
    }

    @Override
    public Float perimeterCalculation(Float a, Float b) {
        float c = 2*a*(Configs.PI);
        return c;
    }

    @Override
    public Float theArea(Float a, Float b) {
        float c = (float) (Configs.PI*(Math.pow(a,2)));
        return c;
    }
}
