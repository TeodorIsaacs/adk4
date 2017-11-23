import java.util.ArrayList;

public class Reducer {

    Kattio io;
    private int v, e, c, nORoles, nOScenes, nOactors;
    private ArrayList<Integer> nonSoloVerticies;
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
        io.println(3+"\n"+2+"\n"+3);
        printDivaRoles();
        printDivaScenes();
        io.flush();
    }

    private void bigBOI() {
        v = io.getInt();
        e = io.getInt();
        c = io.getInt();
        boi = new StringBuilder();
        if (c >= v) {
            printbaseGOOD();
        } else {
            nonSoloVerticies = new ArrayList<>();
            int[] edgesList = new int[e * 2];

            for (int i = 0; i < e * 2; i += 2) {
                int a = io.getInt();
                int b = io.getInt();
                if (!nonSoloVerticies.contains(a))
                    nonSoloVerticies.add(a);
                if (!nonSoloVerticies.contains(b))
                    nonSoloVerticies.add(b);
                edgesList[i] = a;
                edgesList[i + 1] = b;
            }
            int oldV = v;
            v = nonSoloVerticies.size();
            nORoles = v + 3;
            nOScenes = e + 2;
            nOactors = c + 3;

            ArrayList<Integer> typHash = new ArrayList<>();
            typHash.add(0);
            int sub = 0;
            for (int i = 1; i <= oldV; i++) {
                if (!nonSoloVerticies.contains(i)) {
                    sub++;
                }
                typHash.add(i - sub);
            }

            ArrayList<Edge> uniqueEdges = new ArrayList<>();
            int nonUniqueEdges = 0;
            int a, b;
            for (int i = 0; i < e * 2; i += 2) {
                a = typHash.get(edgesList[i]);
                b = typHash.get(edgesList[i + 1]);
                if (!containsEdge(uniqueEdges, a, b)) {
                    uniqueEdges.add(new Edge(a, b));
                } else {
                    nonUniqueEdges++;
                }
            }
            nOScenes -= nonUniqueEdges;
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

    private boolean containsEdge(ArrayList<Edge> list, int a, int b) {
        for (Edge edge : list) {
            if (edge.getA() == a && edge.getB() == b) {
                return true;
            }
            if (edge.getA() == b && edge.getB() == a) {
                return true;
            }
        }
        return false;
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
        boi.append(a+3);
        boi.append(" ");
        boi.append(b+3);
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
