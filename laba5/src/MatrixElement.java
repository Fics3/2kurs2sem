public class MatrixElement {
    private int x;
    private int y;
    private int value;

    public MatrixElement(int xx,int yy, int val){
        x=xx;
        y=yy;
        value=val;
    }
    public int getValue() {
        return value;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
}
