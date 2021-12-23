package HomeWork7;


import java.util.Objects;

public class Edge {
    private final String from;
    private final String to;
    private final double weight;
    private boolean isBlocked;

    public Edge (String from, String to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
        isBlocked = false;
    }

    public Edge (String from, String to){
        this.from = from;
        this.to = to;
        this.weight = 0d;
        isBlocked = false;
    }

    public void setBlock (boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
