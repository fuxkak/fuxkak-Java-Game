public class Monster {
    String type;
    boolean isLive;
    int life;
    int attack;
    int defend;

    public Monster(int num) {
        isLive = true;
        if (num == 1) {
            type = "普通僵尸";
            life = 40;
            attack = 15;
            defend = 8;
        } else if (num == 2) {
            type = "魔法僵尸";
            life = 35;
            attack = 27;
            defend = 5;
        } else if (num == 3) {
            type = "钢盔僵尸";
            life = 40;
            attack = 10;
            defend = 15;
        } else if (num == 4) {
            type = "大僵尸";
            life = 150;
            attack = 30;
            defend = 10;
        }
    }

    public void injured() {
        life -= 20;
        if (life <= 0) {
            dead();
            return;
        }

        System.out.println(type + "惨叫了一声");
        show();
    }

    public void kill(Hunter hunter) {
        if (!isLive) {
            return;
        }
        if (!hunter.isLive) {
            return;
        }

        System.out.println(type + "杀向" + hunter.name);
        hunter.injured();
    }


    public void dead() {
        System.out.println(type + "已死亡");
        //monster死的时候增加hunter经验值
        isLive = false;
    }

    public void show() {
        System.out.println(type + "当前生命值" + life + ",怪物状态:" + isLive);
    }
}
