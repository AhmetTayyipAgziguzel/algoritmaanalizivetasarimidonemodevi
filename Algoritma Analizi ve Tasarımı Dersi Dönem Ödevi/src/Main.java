import java.util.*;

class DistributionPlan {
    private static final int NUM_LOCATIONS = 10;
    private static final double[][] COORDINATES = {
            {37.069515, 37.383110},
            {37.063894, 37.382560},
            {37.073913, 37.383703},
            {37.058944, 37.377113},
            {37.063993, 37.365932},
            {37.081982, 37.368765},
            {37.067123, 37.373809},
            {37.078832, 37.386614},
            {37.071936, 37.389714},
            {37.065943, 37.398209}
    };

    private static final int[][] PRIORITY_STOCK = {
            {1, 100}, // Sağlık Malzemesi
            {2, 100}, // Temel Gıda
            {3, 70},  // Isınma Gereci
            {4, 70}   // Giyecek
    };

    public static void main(String[] args) {

        System.out.println("Ahmet Tayyip Ağzıgüzel");
        System.out.println("1210505008");
        System.out.println("Sümeyra Sümer");
        System.out.println("5210505067");
        System.out.println("-----------------------------------------------------------------------------");

        int[][] adjacencyMatrix = createAdjacencyMatrix(COORDINATES);

        for (int[] priorityStock : PRIORITY_STOCK) {
            int priority = priorityStock[0];
            int stock = priorityStock[1];

            // İhtiyaçların miktarını belirledim ve ardından en kısa yolu buldum ve dağıttım
            int[] distributionAmounts = determineDistributionAmounts(priority, NUM_LOCATIONS);
            int[] distributionOrder = dijkstra(adjacencyMatrix, 0);

            distributeItems(priority, stock, distributionOrder, distributionAmounts);
        }
    }

    // Koordinatlara göre adjacency matrisi oluşturdum
    private static int[][] createAdjacencyMatrix(double[][] coordinates) {
        int[][] adjacencyMatrix = new int[NUM_LOCATIONS][NUM_LOCATIONS];

        for (int i = 0; i < NUM_LOCATIONS; i++) {
            for (int j = 0; j < NUM_LOCATIONS; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                } else {
                    double distance = euclideanDistance(coordinates[i], coordinates[j]);
                    adjacencyMatrix[i][j] = (int) (distance * 1000); // metre cinsinden mesafeyi sakladım
                }
            }
        }

        return adjacencyMatrix;
    }

    // İki nokta arasındaki Öklidyen mesafeyi hesapladım
    private static double euclideanDistance(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }

    // İhtiyaçların miktarını belirlemek için örnek fonksiyon yazdım
    private static int[] determineDistributionAmounts(int priority, int numLocations) {
        int[] amounts = new int[numLocations];

        // Örnek olarak, her lokasyonun eşit miktarda ihtiyacı olduğunu varsaydım.
        for (int i = 0; i < numLocations; i++) {
            amounts[i] = 10;
        }

        return amounts;
    }

    // Dijkstra algoritması ile en kısa yolu buldum.
    private static int[] dijkstra(int[][] adjacencyMatrix, int startVertex) {
        int numVertices = adjacencyMatrix[0].length;

        int[] shortestDistances = new int[numVertices];
        boolean[] added = new boolean[numVertices];

        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        shortestDistances[startVertex] = 0;

        int[] parents = new int[numVertices];
        parents[startVertex] = -1;

        for (int i = 1; i < numVertices; ++i) {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < numVertices; ++vertexIndex) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0; vertexIndex < numVertices; ++vertexIndex) {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        return parents;
    }

    // Dağıtım sırasını oluşturdum
    private static List<Integer> createDistributionOrder(int[] parents, int startVertex) {
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < parents.length; i++) {
            if (i != startVertex) {
                int j = i;
                List<Integer> path = new ArrayList<>();
                while (j != -1) {
                    path.add(0, j);
                    j = parents[j];
                }
                if (path.size() > 1) {
                    order.addAll(path.subList(1, path.size()));
                }
            }
        }
        return order;
    }

    // Öğeleri dağıttım
    private static void distributeItems(int priority, int stock, int[] parents, int[] distributionAmounts) {
        int remainingStock = stock;
        List<Integer> distributionOrder = createDistributionOrder(parents, 0);

        for (int location : distributionOrder) {
            int amountToDistribute = Math.min(remainingStock, distributionAmounts[location]);
            remainingStock -= amountToDistribute;
            distributionAmounts[location] -= amountToDistribute;

            System.out.printf("Öncelik: %d, Lokasyon: %d, Dağıtılan Miktar: %d%n", priority, location, amountToDistribute);

            if (remainingStock == 0) {
                break;
            }
        }
    }
}

