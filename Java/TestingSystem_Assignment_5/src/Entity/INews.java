package Entity;

public interface INews {
    void Display();
    void  floatCalculate();

    void InsertNews( String title, String publishDate, String author, String content,float[] rates);

    void AverageRate();

}
