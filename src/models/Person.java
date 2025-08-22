// File: base/Person.java
package base;

public abstract class Person {
    protected String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    // Abstract method for future use
    public abstract void displaySummary();
}
