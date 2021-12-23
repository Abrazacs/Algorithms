package HomeWork7;


import java.util.List;
import java.util.Map;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String firstLabel, String secondLabel, double weight);

    int getSize();

    void display();

    void dfs (String firstLabel);

    void bfs (String firstLabel);

    Map<String, Double> findAllRoutes (String startLabel, String finishLabel);



}
