package entity;

public class CategoryQuestion {
    private int    id;
    private CategoryName categoryName;

    public enum CategoryName {
        JAVA, NET, SQL, POSTMAN, RUBY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "id=" + id +
                ", categoryName=" + categoryName +
                '}';
    }
}
