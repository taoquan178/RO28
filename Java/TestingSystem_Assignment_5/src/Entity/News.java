package Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class News implements INews{
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    private float[] rates;
    private ArrayList<News> newsList;
    public static int COUNT = 0;

public int getId() {
    return id;
}

    public News( String title, String publishDate, String author, String content, float[] rates) {

        COUNT++;
        this.id = COUNT;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
        this.rates = rates;
        this.averageRate = ((rates[0] + rates[1] + rates[2]) / 3);
    }

    public float[] getRates() {
        return rates;
    }

    public void setRates(float[] rates) {
        this.rates = rates;
    }

    public News() {
        this.newsList =new ArrayList<News>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    @Override
    public void Display() {
        //a) Method Display() sẽ in ra Title, PublishDate, Author,
        //Content và AverageRate của tin tức ra console
        for (News news1 : newsList){
            System.out.println(news1.getTitle() +"\n"+ news1.getPublishDate() +"\n" + news1.getAuthor() +"\n"+ news1.getContent() +"\n"+ news1.getAverageRate());
        }
    }


    @Override
    public void floatCalculate() {
        //b) Method có tên Calculate() để thiết đặt thuộc tính
        //Khai báo một array có tên Rates kiểu int gồm 3 phần tử
        //AverageRate là trung bình cộng của 3 phần tử của array
        //Rates
        float AverageRate =0;
        int[] rates = new int[3];
        rates[0] = 3;
        rates[1] = 4;
        rates[2] = 5;
        AverageRate = (rates[0] +rates[1] +rates[2])/3;
        System.out.println(AverageRate);

    }

    @Override
    public void InsertNews(String title, String publishDate, String author, String content, float[] rates) {
        News news = new News(title,publishDate,author,content,rates);
        newsList.add(news);

    }

    @Override
    public void AverageRate() {
        System.out.print("Nhập vào id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (News news1 : newsList){
            if (news1.getId() == id){
                for (int i = 0; i < news1.rates.length;i++){
                    System.out.println(news1.rates[i]);
                }
                System.out.println(news1.averageRate);

            }
        }

    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", averageRate=" + averageRate +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}
