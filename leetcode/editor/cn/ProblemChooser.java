package editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ProblemChooser {


    //List<Integer> stars5 = new LinkedList<>();
    static HashSet<Integer> set = new HashSet<>();
    static List<Integer> stars5 = new ArrayList<>();

    static {
        //模拟
        stars5.add(1);
        stars5.add(2);
        stars5.add(5);
        stars5.add(382);
        stars5.add(383);
        stars5.add(495);
        stars5.add(541);
        stars5.add(747);
        stars5.add(859);
        stars5.add(1436);
        stars5.add(1446);
        stars5.add(1576);
        stars5.add(1614);
        stars5.add(1629);
        stars5.add(1688);

        //双指针
        stars5.add(3);
        stars5.add(11);
        stars5.add(15);
        stars5.add(19);
        stars5.add(1446);

        //滑动窗口
        stars5.add(3);
        stars5.add(643);

        //二分
        stars5.add(33);
        stars5.add(34);
        stars5.add(35);
        stars5.add(162);
        stars5.add(367);
        stars5.add(373);
        stars5.add(704);
        stars5.add(852);
        stars5.add(911);
        stars5.add(1818);

        //树的搜索

        //回溯算法
        stars5.add(1219);

        //贪心算法
        stars5.add(11);
        stars5.add(1218);
        stars5.add(1705);
        stars5.add(1713);
        stars5.add(1736);
        stars5.add(1833);
        stars5.add(1846);
        stars5.add(1877);
        stars5.add(1996);

        //bfs
        stars5.add(1609);
        stars5.add(127);
        stars5.add(403);
        stars5.add(847);
        stars5.add(1345);
        stars5.add(2059);

        //dfs
        stars5.add(211);
        stars5.add(987);
        stars5.add(1609);

        //拓扑排序

        //最短路
        stars5.add(743);
        stars5.add(787);

        //最小生成树

        //并查集

        //启发式搜索
        stars5.add(127);
        stars5.add(847);
        stars5.add(1239);

        //dp
        stars5.add(375);
        stars5.add(678);
        stars5.add(416);
        stars5.add(474);
        stars5.add(879);
        stars5.add(629);
        stars5.add(740);
        stars5.add(1218);
        stars5.add(1713);
        stars5.add(375);
        stars5.add(664);
        stars5.add(526);
        stars5.add(847);
        stars5.add(1218);
        stars5.add(600);

        //二叉树
        stars5.add(297);
        stars5.add(987);

        //哈希表
        stars5.add(1);
        stars5.add(3);
        stars5.add(146);
        stars5.add(460);
        stars5.add(884);
        stars5.add(1218);
        stars5.add(1436);
        stars5.add(2013);

        //红黑树

        //链表
        stars5.add(19);
        stars5.add(21);
        stars5.add(82);
        stars5.add(83);
        stars5.add(146);
        stars5.add(160);
        stars5.add(382);
        stars5.add(460);
        stars5.add(430);
        stars5.add(725);

        //栈
        stars5.add(20);
        stars5.add(155);
        stars5.add(232);
        stars5.add(1190);

        //单调栈

        //队列
        stars5.add(1190);

        //单调队列

        //堆
        stars5.add(373);
        stars5.add(987);
        stars5.add(1705);

        //前缀和
        stars5.add(303);
        stars5.add(304);
        stars5.add(629);
        stars5.add(724);
        stars5.add(1480);
        stars5.add(1588);
        stars5.add(1744);

        //差分
        stars5.add(1109);

        //树状数组

        stars5.add(307);

        //线段树
        stars5.add(1109);

        //排序
        stars5.add(987);
        stars5.add(1833);

        //分治

        //数学
        stars5.add(372);
        stars5.add(446);
        stars5.add(879);

        //多路归并
        stars5.add(21);
        stars5.add(373);

        //子串匹配
        stars5.add(28);

        //位运算

        //字典树
        stars5.add(208);
        stars5.add(211);

        //字符串哈希

        //后缀数组

        //博弈论

        //三分
        stars5.add(852);

        //洗牌算法
        stars5.add(384);

        //二进制枚举

        //快速幂
        stars5.add(372);

        //矩阵快速幂
        stars5.add(1137);
        stars5.add(1220);

        //找规律

        //打表
        stars5.add(401);

        //约瑟夫环

        //高精度

        //蓄水池抽样
        stars5.add(382);

        //n 数之和
        stars5.add(15);

        //组合总和

        //括号问题
        stars5.add(20);
        stars5.add(678);

        //数独问题

        //回文串问题
        stars5.add(5);

        //表达式计算

        //扫描线










    }
    static {
        set.addAll(stars5);
        stars5.clear();
        stars5.addAll(set);

    }
    static {
        stars5.remove(Integer.valueOf(82));
        stars5.remove(Integer.valueOf(367));
        stars5.remove(Integer.valueOf(162));
        stars5.remove(Integer.valueOf(1705));
        stars5.remove(Integer.valueOf(1614));
        stars5.remove(Integer.valueOf(28));
        stars5.remove(Integer.valueOf(146));
        stars5.remove(Integer.valueOf(15));
        stars5.remove(Integer.valueOf(373));
        stars5.remove(Integer.valueOf(416));
        stars5.remove(Integer.valueOf(1239));
        stars5.remove(Integer.valueOf(1345));
        stars5.remove(Integer.valueOf(1736));
        stars5.remove(Integer.valueOf(19));
        stars5.remove(Integer.valueOf(20));
        stars5.remove(Integer.valueOf(307));
        stars5.remove(Integer.valueOf(704));
        stars5.remove(Integer.valueOf(1877));
        stars5.remove(Integer.valueOf(725));
        stars5.remove(Integer.valueOf(382));
        stars5.remove(Integer.valueOf(1436));
        stars5.remove(Integer.valueOf(33));
        stars5.remove(Integer.valueOf(372));
        stars5.remove(Integer.valueOf(11));
        stars5.remove(Integer.valueOf(384));
        stars5.remove(Integer.valueOf(1219));
        stars5.remove(Integer.valueOf(1846));
        stars5.remove(Integer.valueOf(1588));
        stars5.remove(Integer.valueOf(884));
        stars5.remove(Integer.valueOf(35));
        stars5.remove(Integer.valueOf(747));
        stars5.remove(Integer.valueOf(1));
        stars5.remove(Integer.valueOf(1576));
        stars5.remove(Integer.valueOf(1220));
        stars5.remove(Integer.valueOf(495));
        stars5.remove(Integer.valueOf(232));
        stars5.remove(Integer.valueOf(643));
        stars5.remove(Integer.valueOf(2059));
        stars5.remove(Integer.valueOf(3));
        stars5.remove(Integer.valueOf(304));
        stars5.remove(Integer.valueOf(859));
        stars5.remove(Integer.valueOf(787));
        stars5.remove(Integer.valueOf(383));


    }
    public static void main(String[] args) {
        Random r = new Random();
        int index = r.nextInt(stars5.size());
        System.out.println(stars5.size());

    }





}
