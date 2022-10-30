public class CategoryQuestion {
    int    id;
    CategoryName categoryName;

    public enum CategoryName {
        JAVA, NET, SQL, POSTMAN, RUBY;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "id=" + id +
                ", categoryName=" + categoryName +
                '}';
    }
}
