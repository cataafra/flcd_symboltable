public class Main {
    public static void main(String[] args) {
        SymbolTable st = new SymbolTable(10);

        st.insert("x", "identifier", "int");
        st.insert("x", "identifier", "string");
        st.insert("x", "identifier", "int");
        st.insert("y", "identifier", "int");

        st.insert("x1", "constant", "string");
        st.insert("5", "constant", "int");

        st.lookup("x", "identifier");
        st.lookup("x1", "constant");
        st.lookup("5", "constant");

        st.delete("x", "identifier");
        st.lookup("x", "identifier");
    }
}
