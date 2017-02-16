/**
 * Created by Administrator on 2017-02-10.
 * 控制游戏的动态过程
 */
public class GameControl {
    Hunter hunter;
    Monster m1, m2, m3, m4, m5;

    public GameControl(Hunter hunter) {
        this.hunter=hunter;
        m1 = new Monster(1);
        m2 = new Monster(1);
        m3 = new Monster(2);
        m4 = new Monster(2);
        m5 = new Monster(3);
    }

    public void start() {
        //1.一直进行判断,直到所有monster死亡
        while (true) {
            //2.判断如果hunter dead,执行end()然后break跳出循环
            if (!hunter.isLive) {
                //end();
                break;
            }

            //3.判断如果monster全部死亡,执行end()然后break跳出循环
            if (!m1.isLive && !m2.isLive && !m3.isLive && !m4.isLive && !m5.isLive) {
                //end();
                break;
            }

            //4.如果双方都没死,则随机选一个monster战斗
            //4.1生成一个随机数(1-5),如果是1表示与m1战斗
            int ran = GameUtil.random(1, 6);

            switch (ran) {
                case 1:
                    hunter.fight(m1);
                    break;
                case 2:
                    hunter.fight(m2);
                    break;
                case 3:
                    hunter.fight(m3);
                    break;
                case 4:
                    hunter.fight(m4);
                    break;
                case 5:
                    hunter.fight(m5);
                    break;
                default:
                    System.out.println("随机数生成失败!");
                    break;
            }
            //暂时不用管,意思是让程序休息三秒钟.以免打得太快我们看不过来
            try {
                System.out.println("==================寻找对手中=================");
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        end();
    }

    public void end() {
        //判断hunter是否死亡,如果死亡,输出:"name已死亡";否则则意味着所有monster死亡,就输出恭喜通关
        if (hunter.isLive) {
            System.out.println("恭喜通关!");
        } else {
            System.out.println(hunter.name + "已死亡");
        }

    }
}
