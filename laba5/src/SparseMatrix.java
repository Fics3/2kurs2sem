import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix extends SquareMatirx implements IMatrix{

    private LinkedList<MatrixElement> ListMat;
    int X;
    int Y;

    public SparseMatrix(int size){
        super(size);
        ListMat = new LinkedList<MatrixElement>();
        X=size;
        Y=size;
    }
    @Override
    public void setElement(int row, int column, int value) {
        if (value==0){ return; }
        MatrixElement point = new MatrixElement(row,column,value);
        Iterator<MatrixElement> it = ListMat.listIterator();
        while (it.hasNext()){
            MatrixElement i = it.next();
            if(i.getX()==point.getX() && i.getY()==point.getY()){
                it.remove();
            }
        }
        ListMat.add(point);
    }

    @Override
    public int getElement(int row, int column) {
    for(MatrixElement i : ListMat){
        if(i.getX()==row && i.getY()==column) {
            return i.getValue();
        }
        }
    return 0;
    }

    @Override
    public int getRow() {
        return X;
    }

    @Override
    public int getColumn() {
        return Y;
    }
    public IMatrix product(IMatrix a) {
        IMatrix res = new SparseMatrix(getColumn());
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
}
