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
        read();

    }
    private void printbaseGOOD(){
        io.println(3);
        io.println(2);
        io.println(3
        printDivaRoles();
        printDivaScenes();
    }

    private void read() {
        v = io.getInt();
        e = io.getInt();
        c = io.getInt();
        if (c >= v){
            printbaseGOOD();
        }
        else {
            boi = new StringBuilder();
            nonSoloVerticies = new ArrayList<>();
            int[] edgesList = new int[e * 2];

            for (int i = 0; i < e * 2; i++) {
                int a = io.getInt();
                if (!nonSoloVerticies.contains(a))
                    nonSoloVerticies.add(a);
                edgesList[i] = a;
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
            for (Edge edge :
                    uniqueEdges) {
                printScene(edge.getA(), edge.getB());
            }
        }
        io.flush();
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
        io.println(1 + " " + 1);
        io.println(1 + " " + 2);
        io.println(1 + " " + 3);
    }

    private void printScene(int a, int b) {
        io.println(2 + " " + (a + 3) + " " + (b + 3));
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
