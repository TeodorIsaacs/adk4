import java.util.ArrayList;

public class Reducer {

    Kattio io;
    private int v, e, c, nORoles, nOScenes, nOactors;
    private Edge[] edges;
    private ArrayList<Integer> nonSoloVerticies;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        Reducer reducer = new Reducer(io);
        reducer.print();
    }


    public Reducer(Kattio io) {
        this.io = io;
        read();

    }

    private void read() {
        v = io.getInt();
        e = io.getInt();
        c = io.getInt();

        edges = new Edge[e];
        nonSoloVerticies = new ArrayList<>();
        int[] edgesList = new int[e*2];
        for (int i = 0; i < e * 2; i++) {
            int a = io.getInt();
            if (!nonSoloVerticies.contains(a))
                nonSoloVerticies.add(a);
            edgesList[i] = a;
        }

        int sub = 0;
        ArrayList<Integer> typHash = new ArrayList<>();
        typHash.add(0);
        for (int i = 1; i <= v; i++) {
            if (!nonSoloVerticies.contains(i)) {
                sub++;
            }
            typHash.add(i - sub);
        }

        for (int i = 0; i < e * 2; i +=2) {
            edges[i/2] = new Edge(typHash.get(edgesList[i]), typHash.get(edgesList[i+1]));
        }

        v = nonSoloVerticies.size();
    }

    private void print() {
        nORoles = v + 3;
        nOScenes = e + 2;
        nOactors = c + 3;

        io.println(nORoles);
        io.println(nOScenes);
        io.println(nOactors);


        //Roles

        //Divor
        io.println(1 + " " + 1);
        io.println(1 + " " + 2);
        io.println(1 + " " + 3);

        //Alla Andra
        for (int i = 0; i < v; i++) {
            io.print(c);
            for (int j = 4; j <= nOactors; j++) {
                io.print(" " + j);
            }
            io.println();
        }

        //Scenes

        //Divor
        io.println(2 + " " + 1 + " " + 3);
        io.println(2 + " " + 2 + " " + 3);

        //Alla andra
        for (Edge edge : edges) {
            io.println(2 + " " + (edge.getA() + 3) + " " + (edge.getB() + 3));
        }
        io.flush();
    }
}
