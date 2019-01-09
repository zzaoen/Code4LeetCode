package algo.bbase.c5_string;

import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/31 15:28
 * @desc :
 */
public class N1NumSum {

    public static void main(String[] args) {

        N1NumSum numSum = new N1NumSum();
//        String str = "A-1B--2C--D6E";
        String str = "A1CD2E33";
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();

        int res = numSum.calc(str);
//        System.out.println(res);
        return;
    }

    private int calc(String str) {
        int res = 0;
        int num = 0;
        boolean flag = true;
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];

            if(c >= '1' && c <= '9'){
                int curInt = c - '0';
                num = num * 10 + (flag ? curInt : -curInt);
            }else{
                res += num;
                num = 0;

                if(c == '-'){ //遇到了-
//                    flag = !flag;
// 这样是有问题的，比如-2---3
                    if(i - 1 > -1 && chars[i-1] == '-'){
                        flag = !flag;
                    }else{
                        flag = false;
                    }

                }else { //遇到字母了
                    flag = true;
                }
            }
        }
        res += num;
        System.out.println(res);

        return res;
    }
}
