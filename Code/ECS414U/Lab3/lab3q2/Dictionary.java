package ECS414U.Lab3.lab3q2;

class Dictionary {

  private static final int MAX_ENTRIES = 10000;
  private DictionaryEntry[] entries;
  private int size;

  public Dictionary() {

    this.entries = new DictionaryEntry[MAX_ENTRIES];
    this.size = 0;
  }

  public void addEntry(String word, String definition) {

    if (size < MAX_ENTRIES) {

      DictionaryEntry entry = new DictionaryEntry(word, definition);
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