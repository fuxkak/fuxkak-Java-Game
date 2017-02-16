public class Hunter {
    String name;
    int life;
    String weapon;
    boolean isLive;

    int attack;
    int defend;

    public Hunter(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        life = 100;
        isLive = true;
        attack = 25;
        defend = 8;
    }

    public void fight(Monster monster) {
        if (!isLive) {
            return;
        }
        if (!monster.isLive) {
            return;
        }
        System.out.println(name + "挥舞着" + weapon + "杀向了" + monster.type);
        monster.injured(this.attack);//monster.injured()是指调用monster的injured()方法
        // (this.attack)是指将hunter的attack属性传到monster的injured()方法
    }

    public void injured(int attack) {
        // 定义丢失的基本生命值
        int lostBasicLife = 7;

        // 定义失去的生命值(不含7的)
        int lostLife = attack - defend;

        //增加判断
        if (attack - defend <= 0) {
            life -= lostBasicLife;
        } else {
            life -= lostLife + lostBasicLife;
        }
        System.out.println(name + "受到了伤害");
        show();
        if (life <= 0) {
            dead();
            return;
        }


    }

    public void dead() {
        System.out.println("猎人死了");
        isLive = false;
    }

    public void show() {
        System.out.println("猎人姓名:" + name + ",猎人武器:" + weapon + ",猎人生命值:" +
                life + ",攻击力:" + attack + ",防御力:" + defend + ",状态:" + isLive);
    }
}