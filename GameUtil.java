/**
 * 2017-02-09
 * game的公共代码
 */
public class GameUtil {
    //最少丢失的基本生命值 固定值
    static int lostBasicLife = 7;

    //返回所丢失的生命值
    public static int calLostLife(int attack, int defend) {
        int lostLife = attack - defend;
        int rel;//初始化丢失的生命值
        if (lostLife <= 0) {
            rel = lostBasicLife;
        } else {
            rel = (lostBasicLife + lostLife);
        }
        return rel;
    }

    //生成任意2个数之间的随机整数
    public static int randomRange(int start, int end) {
        return ((int) (Math.random() * (end - start) + start));
    }

    //是否躲避成功
    public static boolean isHide(int minJie, int hideRate) {
        //1.生成一个成功躲避几率(和敏捷相关)
        int successRate = minJie * hideRate / 100;

        //2.生成一个随机数来判断猎人是否躲避成功
        int ran = GameUtil.randomRange(1, 101);

        //3.判断是否躲避成功(如果随机数小于成功躲避几率,则躲避成功)
        if (ran < successRate) {
            return true;
        } else {
            return false;
        }
    }


}
