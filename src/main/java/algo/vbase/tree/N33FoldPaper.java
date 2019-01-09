package algo.vbase.tree;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 20:22
 * @desc :
 */
public class N33FoldPaper {

    public static void main(String[] args) {
        int N = 3;
        printAllFold(N);
        return;
    }

    private static void printAllFold(int n) {
        printProcess(1, n, true);
    }

    private static void printProcess(int i, int n, boolean b) {
        if(i > n){
            return;
        }
        printProcess(i + 1, n, true);
        System.out.print(b ? "down " : "up ");
        printProcess(i + 1, n, false);
    }
}
