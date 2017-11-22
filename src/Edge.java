public class Edge {

    int a, b;

    public Edge(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public void setA(int a){
        this.a = a;
    }
    public void setB(int b){
        this.b = b;
    }

    public boolean checkEquality(int a, int b){
        if((this.a == a && this.b == b) || (this.a == b && this.b == a)){
            return true;
        }else{
            return false;
        }
    }
}
