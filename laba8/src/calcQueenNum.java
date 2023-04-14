import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class calcQueenNum {
    private static Thread[] threads;
    private static int N;
    public static int count;

    public int getCount() {
        return count;
    }

    public calcQueenNum(int N, int threadNum){
        threads=new Thread[threadNum];
        this.N=N;
    }

    public long NQueen() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(threads.length);
        long st=System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            int fromMatrixRow = i * N / threads.length;
            int toMatrixRow = (i + 1) * N/ threads.length;
            threads[i]=new Thread(new trd(fromMatrixRow,toMatrixRow,latch));
            threads[i].start();
        }
        latch.await();
        long fin = System.currentTimeMillis();
        return (fin-st);
    }
    public boolean isAvalible(UsualMatrix a,int row, int column){
        for (int i = 0; i < a.getRow(); i++) {
            if(a.getElement(row,i)==1)return false;
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (a.getElement(i,j) == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j < a.getColumn(); i--, j++) {
            if (a.getElement(i,j) == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i < a.getRow() && j >=0; i++, j--) {
            if (a.getElement(i,j) == 1) {
                return false;
            }
        }
        return true;
    }
//    public boolean isAvaliblee(int row, int column,int start,int end){
//        for (int i = start; i < a.getRow(); i++) {
//            if(a.getElement(i,column)==1)return false;
//        }
//        for (int i = row; i < a.getRow(); i++) {
//            if(a.getElement(row,i)==1)return false;
//        }
//        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
//            if (a.getElement(i,j) == 1) {
//                return false;
//            }
//        }
//        for (int i = row, j = column; i >= 0 && j < a.getRow(); i--, j++) {
//            if (a.getElement(i,j) == 1) {
//                return false;
//            }
//        }
//        for (int c = start; c < row ; c++) {
//            for (int i = c, j = c; i >= start && j < a.getRow(); i++, j++) {
//                if (a.getElement(i, j) == 1) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
public class trd extends Thread{
    CountDownLatch latch;
    private int start;
    private int end;

    public trd(int start,int end,CountDownLatch latch){
        this.start=start;
        this.end=end;
        this.latch=latch;
    }
    @Override
    public void run()   {
        UsualMatrix a = new UsualMatrix(N,N);
        try {
            tmp(a, start, end, 0,0);
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown();
    }
        public void tmp(UsualMatrix a,int start,int end,int c,int rec) throws BrokenBarrierException, InterruptedException {

        if (c == N) {
            calcQueenNum.count++;
            return;
        }
            if((rec==0)) {
                for (int i = start; i < end; i++) {
                    if (isAvalible(a, i, c)) {
                        a.setElement(i, c, 1);
                        tmp(a, start, end, c+1, rec + 1);
                        a.setElement(i, c, 0);
                    }
                }
            }
            else{
                for (int i = 0; i < a.getRow(); i++) {
                    if (isAvalible(a, i, c)) {
                        a.setElement(i, c, 1);
                        tmp(a, start, end, c+1, rec + 1);
                        a.setElement(i, c, 0);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        calcQueenNum b=new calcQueenNum(12,2);
        System.out.println(b.NQueen());
        calcQueenNum a = new calcQueenNum(12,1);
        System.out.println(a.NQueen());
    }
}
