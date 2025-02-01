import java.io.*;

// Class definition
class MyClass implements Cloneable, Serializable {
    int x;
    int y;

    // Default Constructor
    MyClass() {
        x = 10; // Default value
    }

    // Parameterized Constructor
    MyClass(int val) {
        x = val;
    }

    // Another Parameterized Constructor
    MyClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Instance Initializer Block
    {
        y = 20; // Initialized in instance initializer block
    }

    // Static Initializer Block
    static int z;
    static {
        z = 30; // Initialized in static initializer block
    }

    // Factory Method
    static MyClass createInstance(int val) {
        return new MyClass(val);
    }

    // Clone Method
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // toString method for printing
    @Override
    public String toString() {
        return "MyClass{x=" + x + ", y=" + y + ", z=" + z + "}";
    }

    // Builder Pattern
    public static class Builder {
        private int x;
        private int y;

        public Builder setX(int x) {
            this.x = x;
            return this;
        }

        public Builder setY(int y) {
            this.y = y;
            return this;
        }

        public MyClass build() {
            return new MyClass(x, y);
        }
    }
}

public class initializeObject {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // Using Default Constructor
        MyClass obj1 = new MyClass();
        System.out.println("Default Constructor: " + obj1);

        // Using Parameterized Constructor
        MyClass obj2 = new MyClass(40);
        System.out.println("Parameterized Constructor: " + obj2);

        // Using Instance Initializer Block
        MyClass obj3 = new MyClass();
        System.out.println("Instance Initializer Block: " + obj3);

        // Using Static Initializer Block
        MyClass obj4 = new MyClass();
        System.out.println("Static Initializer Block: " + obj4);

        // Using Factory Method
        MyClass obj5 = MyClass.createInstance(50);
        System.out.println("Factory Method: " + obj5);

        // Using Builder Pattern
        MyClass obj6 = new MyClass.Builder().setX(60).setY(70).build();
        System.out.println("Builder Pattern: " + obj6);

        // Using Cloning
        MyClass obj7 = (MyClass) obj6.clone();
        System.out.println("Cloning: " + obj7);

        // Using Object Initializer Syntax (Anonymous Inner Class)
        MyClass obj8 = new MyClass() {
            {
                x = 80;
                y = 90;
            }
        };
        System.out.println("Object Initializer Syntax: " + obj8);

        // Using Deserialization
        // Serialization
        MyClass obj9 = new MyClass(100, 110);
        FileOutputStream fileOut = new FileOutputStream("object.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj9);
        out.close();
        fileOut.close();

        // Deserialization
        FileInputStream fileIn = new FileInputStream("object.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        MyClass obj10 = (MyClass) in.readObject();
        in.close();
        fileIn.close();
        System.out.println("Deserialization: " + obj10);
    }
}

