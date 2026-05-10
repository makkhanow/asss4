import java.util.*;

class Edge {

    String target;
    int weight;

    public Edge(String target, int weight) {

        this.target = target;
        this.weight = weight;
    }
}

public class Mainn {

    private Map<String, List<Edge>> graph = new HashMap<>();

    public Mainn() {

        graph.put("Edinburgh", Arrays.asList(
                new Edge("Perth", 45),
                new Edge("Glasgow", 70)
        ));

        graph.put("Perth", Arrays.asList(
                new Edge("Dundee", 50)
        ));

        graph.put("Glasgow", new ArrayList<>());

        graph.put("Dundee", new ArrayList<>());
    }

    public void dijkstra(String start) {

        Map<String, Integer> distance = new HashMap<>();

        for (String city : graph.keySet()) {

            distance.put(city, Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        PriorityQueue<String> pq =
                new PriorityQueue<>(Comparator.comparingInt(distance::get));

        pq.add(start);

        while (!pq.isEmpty()) {

            String current = pq.poll();

            for (Edge edge : graph.get(current)) {

                int newDistance =
                        distance.get(current) + edge.weight;

                if (newDistance < distance.get(edge.target)) {

                    distance.put(edge.target, newDistance);

                    pq.add(edge.target);
                }
            }
        }

        System.out.println("Shortest distance from Edinburgh to Dundee: "
                + distance.get("Dundee") + " km");
    }

    public static void main(String[] args) {

        Mainn graph = new Mainn();

        graph.dijkstra("Edinburgh");
    }
}