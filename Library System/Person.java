package Library;

// SUPERCLASS - Parent class untuk Member dan Librarian
public class Person {
    protected String id;    // protected agar bisa diakses subclass
    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Method getInfo() akan di-OVERRIDE oleh subclass
    public String getInfo() {
        return "Person[id='" + id + "', name='" + name + "']";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
