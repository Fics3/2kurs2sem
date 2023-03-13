import java.sql.SQLOutput;

public class main {
    public static void main(String args[]) {
        IMatrix res = new SquareMatirx( 1000);
        IMatrix test= new SparseMatrix(1000);
        for (int j = 0; j < 10; j++) {
            int row = (int) (Math.random() * (1000-1));
            int column = (int) (Math.random() *  (1000-1));
            int value = (int)(Math.random() * (1000));
            res.setElement(row, column, value);
            test.setElement(row,column,value);
 //           System.out.println(res.getElement(row,column));
        }
//        res.setElement(1,1,1);
//        res.setElement(1,4,1);
//       res.rMat(test);
//       test.rMat(test);
//       test.setElement(20,20,2);
         test = test.product(test);
         res= res.product(res);
         System.out.println(res.equals(test));
//        test.setElement(1,1,1);
//        res=res.sum(test);
//        res.printMatrix();
//        test.printMatrix();
    }
}
