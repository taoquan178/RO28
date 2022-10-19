public class TypeQuestion {
    int id;
    TypeName  typeName;

    public enum TypeName {
        ESSAY, MULTIPLE_CHOICE
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "id=" + id +
                ", typeName=" + typeName +
                '}';
    }
}
