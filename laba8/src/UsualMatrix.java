public class UsualMatrix implements IMatrix {
    private int columns;
    public int count;
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
    public UsualMatrix product(IMatrix a) {
        UsualMatrix res = new UsualMatrix(getRow(),getColumn()  );
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

    public void NQueen(int c) {
        if (c == mat.length) {
            count++;
            return;
        }
            for (int i = 0; i < mat.length; ++i) {
                if (isAvalible(i, c)) {
                    mat[i][c] = 1;
                    NQueen(c+1);
                    mat[i][c] = 0;
                }
        }
    }
    public int getCount(){
        return count;
    }
    public boolean isAvalible(int row, int column){
        for (int i = 0; i < this.rows; i++) {
            if(this.mat[row][i]==1)return false;
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i < mat.length && j >=0; i++, j--) {
            if (mat[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        UsualMatrix a = new UsualMatrix(8  ,8);
        long st = System.currentTimeMillis();
        a.NQueen(0);
        long fin = System.currentTimeMillis();
        System.out.println(fin - st);
    }
}
