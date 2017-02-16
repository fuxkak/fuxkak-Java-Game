/**
 * Created by Administrator on 2017-02-10.
 * Game的公共方法
 */
public class GameUtil {

    //返回任意两个数之间的随机整数
    public static int random(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }

    //判断是否躲避成功
    public static boolean isHide(int agile, int hideRate) {
        //1.生成一个成功躲避几率(和敏捷相关)
        int successRate = agile * hideRate / 100;

        //2.生成一个随机数来判断猎人是否躲避成功
        int ran = random(1, 101);

        //3.判断是否躲避成功(如果随机数小于成功躲避几率,则躲避成功)
        if (ran < successRate) {
            return true;
        } else {
            return false;
        }
    }

    //计算减少的血量
    static int lostBasicLife = 7;

    public static int lostLife(int attack, int defend) {
        int curLife;
        int lostLife = attack - defend;

        if (lostLife <= 0) {
            curLife = lostBasicLife;
        } else {
            curLife = (lostBasicLife + lostLife);
        }
        return curLife;
    }
}
