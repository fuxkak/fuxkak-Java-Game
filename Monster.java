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

    public void injured(int attack) {//这里是attack是hunter的attack,不是monster的attack
        /* 定义丢失的基本生命为7(造成的最小伤害值是7)
         * 如果hunter.attack=20;monster.defend=30
         * 那么丢失生命值为monsterLostLife = life-hunter.attack - monster.defend + basicLife = 40-20-30+7=-3
         * 也就是说猎人攻击一次,怪物还会增加3的血量,违背逻辑
         * 因此需要增加判断 */

        // 定义丢失的基本生命值
        int lostBasicLife = 7;

        // 定义失去的生命值(不含7的)
        int lostLife = attack - defend;

        //定义满血生命值
        int p = life;

        //增加判断
        if (attack - defend <= 0) {
            life -= lostBasicLife;
        } else {
            life -= lostLife + lostBasicLife;
        }


        if (life <= 0) {
            dead();
            return;
        }
        System.out.println(type + "惨叫了一声,受到了"+(p-life)+"点伤害");
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
        hunter.injured(this.attack);//需要传递僵尸自己的攻击力
    }


    public void dead() {
        System.out.println(type + "已死亡");
        //monster死的时候增加hunter经验值
        isLive = false;
    }

    public void show() {
        System.out.println(type + "当前生命值" + life + ",怪物状态:" + isLive +
                "攻击力:" + attack + ",防御力:" + defend); 
    }
}
