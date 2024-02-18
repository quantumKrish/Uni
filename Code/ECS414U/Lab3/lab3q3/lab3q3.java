package ECS414U.Lab3.lab3q3;

public class lab3q3 {
  public static void main(String[] args) {
      Dictionary2 englishLanguage = Dictionary2.createDictionary2();
      Dictionary2 welshLanguage = Dictionary2.createDictionary2();
  
      englishLanguage.addEntry("dog", "A loyal mammal, domesticated for companionship, belonging to the Canidae family.");
      englishLanguage.addEntry("cat", "A cat is a domesticated feline mammal, valued for companionship, belonging to the Felidae family.");

      System.out.println(englishLanguage.findDefinition("dog"));
      System.out.println(englishLanguage.findDefinition("cat"));
      System.out.println(englishLanguage.findDefinition("octopus"));
      
      System.out.println(welshLanguage); // null
  }
}

  
