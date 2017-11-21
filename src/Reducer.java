public class Reducer {

    Kattio io = new Kattio(System.in, System.out);
    private int v, e, c;
    private Edge[] edges;

    public static void main(String[] args) {
        Reducer reducer = new Reducer();
        reducer.read();

    }


    public Reducer(){

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

}
