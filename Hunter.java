class Hunter {
    int curLife;
    int maxLife;
    int level;
    int exp;
    boolean isLive;
    String name;
    String weapon;
    int attack;
    int defend;

    public Hunter(String name, String weapon) {
        maxLife = 100;
        curLife = maxLife;
        isLive = true;
        attack = 25;
        defend = 8;
        this.name = name;
        this.weapon = weapon;
        level = 1;
        exp = 0;

    }

    public void fight(Monster monster) {
        if (!isLive) {
            return;
        }

        if (!monster.isLive) {
            return;
        }
        System.out.println(name + "挥舞着" + weapon + "杀向了" + monster.type);
        monster.injured(this);
    }

    public void injured(Monster monster) {
        int p = curLife;
        int lostLife = monster.attack - defend;
        int basicLostLife = 7;
        if (lostLife <= 0) {
            curLife -= basicLostLife;
        } else {
            curLife -= basicLostLife + lostLife;
        }
        System.out.println(name + "受到了" + (p - curLife) + "点伤害");
        if (curLife <= 0) {
            dead();
        }
        info();
    }

    public void dead() {
        System.out.println(name + "已死亡");
        isLive = false;
    }

    public void info() {
        System.out.println("姓名:" + name + ",当前生命值:" + curLife +
                ",武器:" + weapon + ",攻击力:" + attack +
                ",防御力:" + defend + ",当前等级:" + level + ",当前经验值:" + exp + ",是否存活:" + isLive);
    }

    //增加经验值
    public void expAdd(Monster monster) {
        exp += monster.maxLife;
        System.out.println(name + "当前经验值为:" + exp);
    }
}