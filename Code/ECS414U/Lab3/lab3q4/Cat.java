package ECS414U.Lab3.lab3q4;

class Cat extends Animal {

    private boolean hasClaws;
  
    public Cat(String name, int age, boolean hasClaws) {
        
        super(name, age);
        this.hasClaws = hasClaws;
    }

    public void meow() {
        System.out.println("Meow!");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Has Claws: " + hasClaws);
    }
  }
