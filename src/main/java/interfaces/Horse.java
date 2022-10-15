package interfaces;

public interface Horse {
    default String speak() {
        return "neigh";
    }
}
