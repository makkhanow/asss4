import java.util.*;

// ======================
// TASK 3
// DFS and BFS
// ======================

class Main {

    private Map<String, List<String>> graph = new HashMap<>();

    public Main() {

        graph.put("A", Arrays.asList("C", "B", "D"));
        graph.put("B", Arrays.asList("A", "C", "E", "G"));
        graph.put("C", Arrays.asList("A", "B", "D"));
        graph.put("D", Arrays.asList("C", "A"));
        graph.put("E", Arrays.asList("G", "F", "B"));
        graph.put("F", Arrays.asList("G", "E"));
        graph.put("G", Arrays.asList("F", "B"));
    }

    // DFS
    public void dfs(String start) {

        Set<String> visited = new HashSet<>();

        System.out.println("DFS Traversal:");

        dfsHelper(start, visited);
    }

    private void dfsHelper(String node, Set<String> visited) {

        visited.add(node);

        System.out.print(node + " ");

        for (String neighbor : graph.get(node)) {

            if (!visited.contains(neighbor)) {

                dfsHelper(neighbor, visited);
            }
        }
    }

    // BFS
    public void bfs(String start) {

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        visited.add(start);

        queue.add(start);

        System.out.println("\nBFS Traversal:");

        while (!queue.isEmpty()) {

            String node = queue.poll();

            System.out.print(node + " ");

            for (String neighbor : graph.get(node)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        Main g = new Main();

        g.dfs("A");

        g.bfs("A");
    }
}