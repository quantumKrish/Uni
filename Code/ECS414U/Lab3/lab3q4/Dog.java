package ECS414U.Lab3.lab3q4;

class Dog extends Animal {

    private String breed;
  
    public Dog(String name, int age, String breed) {

        super(name, age);
        this.breed = breed;
    }

    public void bark() {
        System.out.println("Woof!");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Breed: " + breed);
    }
  }
