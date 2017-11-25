import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Reducer {

    Kattio io;
    private int v, e, c, nORoles, nOScenes, nOactors;
    private HashSet<Integer> nonSoloVerticies;
    private StringBuilder boi;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        Reducer reducer = new Reducer(io);
    }


    public Reducer(Kattio io) {
        this.io = io;
        bigBOI();

    }

    private void printbaseGOOD() {
        io.println(3 + "\n" + 2 + "\n" + 3);
        printDivaRoles();
        printDivaScenes();
        io.flush();
    }

    private void bigBOI() {
        v = io.getInt();
        e = io.getInt();
        c = io.getInt();
        boi = new StringBuilder();
        if (c >= v || c > e) {
            printbaseGOOD();
        } else {
            nonSoloVerticies = new HashSet<>();
            LinkedList<Integer> edgesList = new LinkedList<>();

            for (int i = 0; i < e * 2; i++) {
                int a = io.getInt();
                nonSoloVerticies.add(a);
                edgesList.add(a);
            }

            ArrayList<Integer> typHash = new ArrayList<>();
            typHash.add(0);
            int sub = 0;
            for (int i = 1; i <= v; i++) {
                if (!nonSoloVerticies.contains(i)) {
                    sub++;
                }
                typHash.add(i - sub);
            }

            HashSet<Edge> uniqueEdges = new HashSet<>();

            //Skapa unika Edges från vår input
            while (!edgesList.isEmpty()){
                uniqueEdges.add(new Edge(typHash.get(edgesList.pollFirst()), typHash.get(edgesList.pollFirst())));
            }

            v = nonSoloVerticies.size();
            nORoles = v + 3;
            nOScenes = uniqueEdges.size() + 2;
            nOactors = c + 3;

            printFirstThree();
            printDivaRoles();
            printRoles();
            printDivaScenes();
            for (Edge edge : uniqueEdges) {
                printScene(edge.getA(), edge.getB());
            }

            io.flush();
        }
    }

    private void printDivaRoles() {
        boi.setLength(0);
        boi.append(1);
        boi.append(" ");
        boi.append(1);
        boi.append("\n");
        boi.append(1);
        boi.append(" ");
        boi.append(2);
        boi.append("\n");
        boi.append(1);
        boi.append(" ");
        boi.append(3);
        io.println(boi);
    }

    private void printScene(int a, int b) {
        boi.setLength(0);
        boi.append(2);
        boi.append(" ");
        boi.append(a + 3);
        boi.append(" ");
        boi.append(b + 3);
        io.println(boi);
    }

    private void printDivaScenes() {
        io.println(2 + " " + 1 + " " + 3);
        io.println(2 + " " + 2 + " " + 3);
    }

    private void printFirstThree() {
        io.println(nORoles);
        io.println(nOScenes);
        io.println(nOactors);
    }

    private void printRoles() {
        boi.setLength(0);
        boi.append(c);
        for (int i = 4; i <= nOactors; i++) {
            boi.append(" ");
            boi.append(i);
        }
        for (int i = 0; i < v; i++) {
            io.println(boi);
        }
    }
}
