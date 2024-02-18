package ECS414U.Lab3.lab3q3;

class Dictionary2 {

  private static Dictionary2 instance;
  private static final int MAX_ENTRIES = 10000;
  private DictionaryEntry2[] entries;
  private int size;

  private Dictionary2() {

    this.entries = new DictionaryEntry2[MAX_ENTRIES];
    this.size = 0;
  }

  public static Dictionary2 createDictionary2() {

    if (instance == null) {

      instance = new Dictionary2();
      return instance;

    } else {

      System.out.println("This class is a singleton!");
      return null;
    }
  }

  public void addEntry(String word, String definition) {

    if (size < MAX_ENTRIES) {

      DictionaryEntry2 entry = new DictionaryEntry2(word, definition);
      entries[size++] = entry;

    } else {

      System.out.println("Dictionary is full. Cannot add more entries.");
    }
  }

  public String findDefinition(String wordToFind) {

    for (int i = 0; i < size; i++) {

      if (entries[i].getWord().equals(wordToFind)) {
        
        return entries[i].getDefinition();
      }
    }

    return "Not Found.";
  }

}