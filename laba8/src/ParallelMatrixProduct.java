import java.lang.Thread;
import java.lang.Runnable;
import java.util.concurrent.CountDownLatch;

public class ParallelMatrixProduct {
    private Thread[] threads;

    public ParallelMatrixProduct(int threadCount) {
        threads = new Thread[threadCount];
    }

    public UsualMatrix product(UsualMatrix a, UsualMatrix b) throws InterruptedException {
        if (a.getRow() < b.getColumn()) throw new RuntimeException("Rows of 1 < columns of 2");

        UsualMatrix res = new UsualMatrix(a.getRow(), b.getColumn());
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            int fromMatrixRow = i * a.getRow() / threads.length;
            int toMatrixRow = (i + 1) * b.getRow() / threads.length;
            threads[i] = new Thread(new tmp(a, b, res, fromMatrixRow, toMatrixRow, latch));
            threads[i].start();
        }
        latch.await();
        return res;
    }

    public class tmp implements Runnable {
        private UsualMatrix a;
        private UsualMatrix b;
        private UsualMatrix res;
        private int fromMatrixRow;
        private int toMatrixRow;

        private CountDownLatch latch;
        public tmp(UsualMatrix a,UsualMatrix b,UsualMatrix res,int fromMatrixRow, int toMatrixRow, CountDownLatch latch){
            this.a=a;
            this.b=b;
            this.res=res;
            this.fromMatrixRow=fromMatrixRow;
            this.toMatrixRow=toMatrixRow;
            this.latch = latch;
        }
        @Override
        public void run() {
            for (int i = fromMatrixRow; i < toMatrixRow; i++) {
                for (int j = 0; j < b.getColumn(); j++) {
                    int temp = 0;
                    for (int n = 0; n < a.getColumn(); n++) {
                        temp += a.getElement(i, n) * b.getElement(n, j);
                    }
                    res.setElement(i, j, temp);
//                    System.out.println(res.getElement(1,1));
                }
            }
            latch.countDown();
        }
    }
}
