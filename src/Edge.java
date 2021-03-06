public class Edge {

    int a, b;

    public Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }


    @Override
    public boolean equals(Object o) {
        Edge e = (Edge) o;
        return ((e.getA() == a && e.getB() == b) || (e.getA() == b && e.getB() == a));
    }

    @Override
    public int hashCode() {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int hash = ((max + min) * (max + min + 1) / 2) + min;
        return hash;
    }

}
