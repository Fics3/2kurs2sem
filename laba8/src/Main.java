public class Main {
    public static void main(String[] args) throws InterruptedException {
//        UsualMatrix res = new UsualMatrix( 1000,1000);
//        UsualMatrix test= new UsualMatrix(1000,1000);
//        UsualMatrix ress = new UsualMatrix( 1000,1000);
//        UsualMatrix testt= new UsualMatrix(1000,1000);
//        for (int j = 0; j < 1000; j++) {
//            int row = (int) (Math.random() * (1000-1));
//            int column = (int) (Math.random() *  (1000-1));
//            int value = (int)(Math.random() * (1000));
//            res.setElement(row, column, value);
//            test.setElement(row,column,value);
//            ress.setElement(row,column,value);
//            testt.setElement(row,column,value);
//            //           System.out.println(res.getElement(row,column));
//        }
//
//        ParallelMatrixProduct pr = new ParallelMatrixProduct(128);
//
//        long stT=System.currentTimeMillis();
//        res=pr.product(res, test);
//        long finT=System.currentTimeMillis();
//
//        long st=System.currentTimeMillis();
//        ress=ress.product(testt);
//        long fin=System.currentTimeMillis();
//
//        System.out.println("With Treads:"+(finT-stT));
//        System.out.println("No   Treads:"+(fin-st));
//
//        long raz = Math.abs(((finT-stT)-(fin-st)));
//        System.out.println(raz);
//        System.out.println(res.equals(ress));


        for (int i = 1; i < 20; i++) {
            System.out.println("size :"+i);
            UsualMatrix a = new UsualMatrix(i, i);
            long st = System.currentTimeMillis();
            a.NQueen(0);
            long fn = System.currentTimeMillis();
            for (int j = 1; j <= 2; j++) {
                System.out.println("thrads: "+j);
                calcQueenNum b =new calcQueenNum(i,j);
                long stT = System.currentTimeMillis();
                b.NQueen();
                long finT = System.currentTimeMillis();
                    System.out.println("With Treads:" + (finT - stT));
                    System.out.println("No   Treads:" + (fn - st)+" ");
            }
        }
    }
}