import java.util.LinkedList;

class Symbol {
    String name;
    String type; // "int" or "string" or null if not specified
    String category; // "identifier" or "constant"

    public Symbol(String name, String category) {
        this(name, null, category);
    }

    public Symbol(String name, String category, String type) {
        this.name = name;
        this.type = type;
        this.category = category;
    }
}

class HashTable {
    private final LinkedList<Symbol>[] table;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return key.hashCode() % size;
    }

    public void insert(Symbol symbol) {
        int index = hash(symbol.name);

        for (Symbol s : table[index]) {
            if (s.name.equals(symbol.name) && s.category.equals(symbol.category)) {
                System.out.println("Symbol already exists.");
                return;
            }
        }

        table[index].add(symbol);
    }

    public Symbol lookup(String name, String category) {
        int index = hash(name);
        for (Symbol symbol : table[index]) {
            if (symbol.name.equals(name) && symbol.category.equals(category)) {
                return symbol;
            }
        }
        return null;
    }

    public void delete(String name, String category) {
        int index = hash(name);
        table[index].removeIf(symbol -> symbol.name.equals(name) && symbol.category.equals(category));
    }
}

public class SymbolTable {
    private final HashTable ht;

    public SymbolTable(int size) {
        ht = new HashTable(size);
    }

    public void insert(String name, String category, String type) {
        ht.insert(new Symbol(name, category, type));
    }

    public Symbol lookup(String name, String category) {
        Symbol symbol = ht.lookup(name, category);
        if (symbol != null) {
            System.out.println("Found symbol:" + category + " = " + symbol.name + ", Type = " + symbol.type);
        } else {
            System.out.println("Symbol not found.");
        }

        return symbol;
    }

    public void delete(String name, String category) {
        ht.delete(name, category);
    }
}
