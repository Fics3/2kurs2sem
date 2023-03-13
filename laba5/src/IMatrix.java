interface IMatrix {
    void setElement(int row, int column, int value);
    int getElement(int row, int column);
    int getRow();
    int getColumn();
    void printMatrix();
    String  toString();
    IMatrix sum(IMatrix a);
    IMatrix product(IMatrix a);
//    void rMat(IMatrix a);
    Boolean equals(IMatrix a);

}
