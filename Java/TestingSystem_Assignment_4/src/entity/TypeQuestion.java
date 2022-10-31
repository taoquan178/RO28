package entity;

public class TypeQuestion {
    private int id;
    private TypeName  typeName;

    public enum TypeName {
        ESSAY, MULTIPLE_CHOICE
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "id=" + id +
                ", typeName=" + typeName +
                '}';
    }
}
