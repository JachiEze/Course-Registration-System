public class Person {
    protected String name;

    // constructors
    public Person(String initialName){
        name = initialName;
    }

    public Person(){

    }

    public void setName( String fullName) {
        name = fullName;
    }

    public String getName() {
        return name;
    }

    // this method is necessary because in TestApp.java, Student object is assigned to Parent object
    // and then these methods are called
    public void registerFor(Course course) {
        
    }

    // same reason as previous one
    public boolean isRegisteredInCourse(Course course) {
        return false;
    }

    public String toString() {
        return "Person class; Name: " + name;
    }
}