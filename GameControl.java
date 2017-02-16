public class GameControl {
    Hunter hunter;
    Monster m1, m2, m3, m4, m5;
    Vampire v1, v2, v3;

    public GameControl(Hunter hunter) {
        this.hunter = hunter;
        m1 = new Monster(1);
        m2 = new Monster(2);
        m3 = new Monster(2);
        m4 = new Monster(3);
        m5 = new Monster(4);
        v1 = new Vampire(1);
        v2 = new Vampire(2);
        v3 = new Vampire(3);
    }

    public void start() {
        while (true) {
            if (!hunter.isLive) {
                break;
            }
            if (!m1.isLive && !m2.isLive && !m3.isLive && !m4.isLive && !m5.isLive) {
                break;
            }

            int ran = GameUtil.randomRange(1, 9);
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
                case 6:
                    hunter.fight(v1);
                    break;
                case 7:
                    hunter.fight(v2);
                    break;
                case 8:
                    hunter.fight(v3);
                    break;
                default: //即使没有default,也要写出来为空
            }
            //暂时不用管,意思是让程序休息三秒钟.以免打得太快我们看不过来
            try {
                System.out.println("==================寻找对手中=================");
                Thread.sleep(3000);
            } catch (Exception e) {
            }
        }
        end();
    }


    public void end() {
        if (hunter.isLive) {
            System.out.println("恭喜过关");
        } else {
            System.out.println("大侠请重新来过");
        }
    }
}