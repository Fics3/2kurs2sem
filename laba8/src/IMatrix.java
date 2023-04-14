interface IMatrix {

    int getElement(int row, int column);
    int getRow();
    int getColumn();
    void printMatrix();
    String  toString();
    void setElement(int row, int column, int value);
    IMatrix sum(IMatrix a);
    IMatrix product(IMatrix a);
    Boolean equals(IMatrix a);

}
