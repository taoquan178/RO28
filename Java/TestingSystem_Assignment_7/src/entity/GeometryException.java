package entity;

public class GeometryException extends Exception {
    public GeometryException(){
        super("Số lượng hình học cho phép vượt quá" + Configs.MAXIMUM_NUMBER_OF_GEometry);
    }
}
