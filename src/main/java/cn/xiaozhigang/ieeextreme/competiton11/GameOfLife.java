package cn.xiaozhigang.ieeextreme.competiton11;
import java.util.*;
import java.lang.*;

public class GameOfLife {
    public static int neighbour(char[][] lifemap,int i,int j){
        int count = 0;
        int row = 0,col = 0;
        for (int r = i - 1; r <= i + 1; r++) {
            for(int l = j - 1; l <= j+1; l++) {
                if(r == i && l == j) continue;
                row = r; col = l;
                if(row < 0) row = lifemap.length - 1;
                else if(row >= lifemap.length) row = 0;
                if(col < 0) col = lifemap[0].length - 1;
                else if(col >= lifemap[0].length) col = 0;
                if(lifemap[row][col] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void printMap(char[][] lifemap) {
        for (int index = 0; index < lifemap.length ; index++) {
            for (int j = 0; j < lifemap[0].length; j++)
                System.out.print(lifemap[index][j]);
            if(index != lifemap.length - 1)
                System.out.println();
        }
    }

    public static String chararrToString(char[][] lifemap) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < lifemap.length; i++)
            builder.append(lifemap[i]);
        return builder.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
//        System.out.println("n = " + n + ",m = " + m);
        char[][] lifemap = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.next();
            lifemap[i] = line.toCharArray();
        }
//        System.out.println("(0,5):"+neighbour(lifemap,0,5));
        //开始转换
        boolean flag = false;
        LinkedHashSet<String> lifeMapStringSet = new LinkedHashSet<String>();
        int times = 0;
        for (int i = 0; i < c; i++) {
            times++;
            char[][] newMap = new char[n][m];
            boolean changed = false;
            for(int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    switch (neighbour(lifemap,row,col)) {
                        case 0:
                        case 1:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            if(lifemap[row][col] == '*')
                                changed = true;
                            newMap[row][col] = '-';
                            break;
                        case 2:
                            newMap[row][col] = lifemap[row][col];
                            break;
                        case 3:
                            if(lifemap[row][col] == '-')
                                changed = true;
                            newMap[row][col] = '*';
                            break;
                    }
                }
            }
            lifemap = newMap;
            if(changed == false) {
                break;
            }
            if(lifeMapStringSet.add(chararrToString(lifemap)) == false) {
                String loopStr = chararrToString(lifemap);
                int index = 0;
                for (String s : lifeMapStringSet) {
                    if(loopStr.equals(s))
                        break;
                    index++;
                }
                int pos = (c - index) % (i - index);
                String s = "";
                index += pos;
                for(String str : lifeMapStringSet) {
                    index--;
                    if(index == 0) {
                        s = str;
                        break;
                    }
                }
                for(int start = 0; start < n; start++) {
                    System.out.print(s.substring(start * m,(start + 1) * m));
                    if(start != n-1)
                        System.out.println();
                }
//                System.out.println("最后结果：" + s);
                return;
            }
        }
//        int g = 0;
//        for (String s : lifeMapStringSet) {
//            System.out.println(g + ": " + s);
//            g++;
//        }
//        System.out.println("迭代次数："+times);

            printMap(lifemap);
//        System.out.println("\n-------------------");
//        System.out.println(chararrToString(lifemap));
    }
}
