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
        monster.injured();
    }

    public void injured() {
        life -= 20;
        if (life <= 0) {
            dead();
            return;
        }

        System.out.println(name + "受到了伤害,当前生命值为" + life);
        show();
    }

    public void dead() {
        System.out.println("猎人死了");
        isLive = false;
    }

    public void show() {
        System.out.println("猎人姓名:" + name + ",猎人武器:" + weapon + ",猎人生命值:" + life + ",状态:" + isLive);
    }
}