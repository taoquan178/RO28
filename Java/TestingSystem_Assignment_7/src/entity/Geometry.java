package entity;

public abstract class  Geometry {
    private Float a;

    private Float b;

    public static int COUNT = 0;

    public abstract Float perimeterCalculation(Float a, Float b);

    public abstract Float theArea(Float a, Float b);

    public Geometry(Float a, Float b) throws Exception {
        super();
        COUNT++;
        if (COUNT <= Configs.MAXIMUM_NUMBER_OF_GEometry) {
            this.a = a;
            this.b = b;
        } else {
            throw new GeometryException();
        }
    }
}
