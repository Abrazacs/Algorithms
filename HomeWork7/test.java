package HomeWork7;


public class test {

    public static void main(String[] args) {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Moscow");
        graph.addVertex("Tula");
        graph.addVertex("Ryazan");
        graph.addVertex("Kaluga");
        graph.addVertex("Lipeck");
        graph.addVertex("Tambov");
        graph.addVertex("Orel");
        graph.addVertex("Saratov");
        graph.addVertex("Kursk");
        graph.addVertex("Voronezh");

        graph.addEdge("Moscow", "Tula", 182.00);
        graph.addEdge("Moscow", "Ryazan", 199.00);
        graph.addEdge("Moscow", "Kaluga", 189.00);
        graph.addEdge("Tula", "Lipeck", 272.00);
        graph.addEdge("Ryazan", "Tambov", 291.00);
        graph.addEdge("Kaluga", "Orel", 210.00);
        graph.addEdge("Lipeck", "Voronezh", 151.00);
        graph.addEdge("Tambov", "Saratov", 384.00);
        graph.addEdge("Orel", "Kursk", 161.00);
        graph.addEdge("Saratov", "Voronezh", 516.00);
        graph.addEdge("Kursk", "Voronezh", 223.00);



        System.out.println(graph.findAllRoutes("Moscow", "Voronezh"));

    }


}
