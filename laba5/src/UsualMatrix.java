public class UsualMatrix implements IMatrix {
    private int columns;
    private int rows;
    private int[][] mat;
    public UsualMatrix(int rows, int columns){
        this.columns=columns;
        this.rows=rows;
        mat = new int[rows][columns];
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                setElement(i,j,0);
            }
        }
    }
    @Override
    public void setElement(int row, int column, int value) {
        this.mat[row][column] = value;
    }

    @Override
    public int getElement(int row, int column) {
        return mat[row][column];
    }

    @Override
    public int getRow() {
        return rows;
    }

    @Override
    public int getColumn() {
        return columns;
    }

    @Override
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(getElement(i,j)+" ");
            }
            System.out.println();
        }
    }
    public IMatrix sum(IMatrix a) {
        IMatrix res = new UsualMatrix(rows,columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.setElement(i,j,getElement(i,j)+a.getElement(i,j));

            }
        }
        return res;
    }
    public IMatrix product(IMatrix a) {
        IMatrix res = new UsualMatrix(getRow(),getColumn()  );
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < a.getColumn(); j++) {
                int temp=0;
                for(int n = 0; n<getColumn();n++){
                    temp += getElement(i,n)*a.getElement(n,j);
                }
                res.setElement(i,j,temp);
    //            System.out.println(getElement(i,j));
            }
        }
        return res;
    }
//    public void rMat(IMatrix a){
//        for (int j = 0; j < 300; j++) {
//            int row = (int) (Math.random() * 300);
//            int column = (int) (Math.random() *  300);
//            int value = (int)(Math.random() * 1000);
//            setElement(row, column, value);
//            a.setElement(row,column,value);
//        }
//    }
    public Boolean equals(IMatrix a){
        if (this==a){
            return true;
        }
        if(columns==a.getColumn() && rows==a.getRow()){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (getElement(i,j) != a.getElement(i,j)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
