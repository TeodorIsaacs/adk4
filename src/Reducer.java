public class Reducer {

    Kattio io = new Kattio(System.in, System.out);
    private int v, e, c, nORoles, nOScenes, nOactors;
    private Edge[] edges;

    public static void main(String[] args) {
        Reducer reducer = new Reducer();
        reducer.print();

    }



    public Reducer(){
        read();
    }

    private void read(){
        v = io.getInt();
        e = io.getInt();
        c = io.getInt();

        edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(io.getInt(), io.getInt());
        }
    }

    private void print(){
        nORoles = v + 3;
        nOScenes = e + 2;
        nOactors = c + 3;

        System.out.println(nORoles);
        System.out.println(nOScenes);
        System.out.println(nOactors);

        //Roles

        //Divor
        System.out.println(1 + " " + 1);
        System.out.println(2 + " " + 2);
        System.out.println(3 + " " + 3);

        //Alla Andra
        for (int i = 0; i < v; i++){
            System.out.print(c);
            for (int j = 4; j <= nOactors; j++) {
                System.out.print(" " + j);
            }
            System.out.println();
        }

        //Scenes

        //Divor
        System.out.println(2+ " " + 1+ " " + 3);
        System.out.println(2+ " " + 2+ " " + 3);

        //Alla andra
        for (Edge edge : edges) {
            System.out.println(2 + " " + (edge.getA() + 3) + " " + (edge.getB() + 3));
        }
    }
}
