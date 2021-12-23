package HomeWork7;


import java.security.interfaces.EdECKey;
import java.util.*;


public class GraphImpl implements Graph{

    private final List<Vertex> vertexList;
    private final List<Edge> edgeList;


    public GraphImpl(int size) {
        this.vertexList = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String firstLabel, String secondLabel, double weight) {
        if (isVertexExist(firstLabel) && isVertexExist(secondLabel)) {
            edgeList.add(new Edge(firstLabel, secondLabel, weight));
            return true;
        }
        return false;
    }

    private boolean isVertexExist(String label) {
        for (Vertex vertex: vertexList) {
            if(vertex.getLabel().equals(label)) return true;
        }
        return false;
    }

    private Vertex getVertex(String label){
        for (Vertex vertex: vertexList) {
            if(vertex.getLabel().equals(label)) return vertex;
        }
        return null;
    }



    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void dfs(String firstLabel) {
        if(!isVertexExist(firstLabel)){
            throw new IllegalArgumentException("Неверная вершина: "+firstLabel);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = getVertex(firstLabel);
        resetVertexVisits();
        visitVertex(stack, vertex);
        while (!stack.isEmpty()){
            vertex = getNearestUnvisitedVertex(stack.peek());
            if (vertex != null){
                visitVertex(stack, vertex);
            }else {
                stack.pop();
            }
        }
    }


    private Vertex getNearestUnvisitedVertex(Vertex vertex) {
        for (Vertex secondVertex: vertexList) {
            String secondLabel = secondVertex.getLabel();
            Edge edge = getEdge(vertex.getLabel(), secondVertex.getLabel());
            if(edgeList.contains(edge) && !secondVertex.isVisited && !edge.isBlocked()){
                return secondVertex;
            }
        }
        return null;
    }



    private void resetVertexVisits() {
        for (Vertex vertex: vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel()+ " ");
        stack.add(vertex);
        vertex.setVisited(true);

    }
    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel()+ " ");
        stack.add(vertex);
        vertex.setVisited(true);

    }

    @Override
    public void bfs(String firstLabel) {
        if(!isVertexExist(firstLabel)){
            throw new IllegalArgumentException("Неверная вершина: "+firstLabel);
        }
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = getVertex(firstLabel);
        resetVertexVisits();
        visitVertex(queue, vertex);
        while (!queue.isEmpty()){
            vertex = getNearestUnvisitedVertex(queue.peek());
            if (vertex != null){
                visitVertex(queue, vertex);
            }else {
                queue.remove();
            }
        }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Vertex firstVertex: vertexList) {
            sb.append(firstVertex);
            for (Vertex secondVertex: vertexList) {
                Edge tempEdge = new Edge(firstVertex.getLabel(), secondVertex.getLabel());
                if(edgeList.contains(tempEdge)){
                    sb.append("-> ").append(secondVertex);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Edge getEdge (String firstLabel, String secondLabel){
        Edge tempEdge = new Edge(firstLabel,secondLabel);
        for (Edge edge: edgeList) {
            if(edge.equals(tempEdge)) return edge;
        }
        return null;
    }

    @Override
    public Map<String, Double> findAllRoutes (String startLabel, String finishLabel){
        if(!isVertexExist(startLabel) || !isVertexExist(finishLabel)){
            throw new IllegalArgumentException("Wrong labels");
        }
        Map<String, Double> routes = new HashMap<>();
        Stack<Vertex> stack = new Stack<>();
        Stack<Double> routeDistance = new Stack<>();
        Double distance = 0d;
        routeDistance.add(distance);
        Vertex fromVertex = null;
        Vertex toVertex = getVertex(startLabel);
        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(toVertex);

        resetVertexVisits();
        visitVertex(stack, toVertex);

        while (!stack.isEmpty()){
            fromVertex = toVertex;
            toVertex = getNearestUnvisitedVertex(stack.peek());
            if (toVertex!=null){
                if (getEdge(fromVertex.getLabel(), toVertex.getLabel()) != null) {
                    Edge edge = getEdge(fromVertex.getLabel(), toVertex.getLabel());
                    if (toVertex.getLabel().equals(finishLabel)) {
                        edge.setBlock(true);
                        distance = routeDistance.peek() + edge.getWeight();
                        routeDistance.add(distance);
                        vertexList.add(toVertex);
                        routes.put(getStringFromVertexList(vertexList), distance);
                        vertexList.remove(toVertex);
                        toVertex =vertexList.get(vertexList.size()-1);
                    } else if (!edge.isBlocked()) {
                        visitVertex(stack, toVertex);
                        if(routeDistance.isEmpty()){
                            routeDistance.add(0d);
                        }
                        distance = routeDistance.peek() + edge.getWeight();
                        routeDistance.add(distance);
                        vertexList.add(toVertex);
                    }
                }
            }
                else {
                    vertexList.remove(stack.peek());
                    stack.pop();
                    if(!stack.isEmpty()){
                        toVertex = stack.peek();
                    }
                    if(!routeDistance.isEmpty()) {
                        routeDistance.pop();
                    }
                }
        }
        return routes;
    }

    private String getStringFromVertexList (List<Vertex> vertexList){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertexList.size(); i++) {
           if(i>0){
               sb.append(" -> ");
           }
           sb.append(vertexList.get(i).toString());
        }
        return sb.toString();
    }

}
