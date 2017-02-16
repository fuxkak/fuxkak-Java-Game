class Monster {
    int curLife;
    int maxLife;
    String type;
    boolean isLive;
    int attack;
    int defend;
    int agile;
    int hideRate;

    public Monster(int num) {
        isLive = true;
        hideRate = 67;
        if (num == 1) {
            type = "普通僵尸";
            curLife = 40;
            attack = 25;
            defend = 7;
            agile = 15;
        } else if (num == 2) {
            type = "魔法僵尸";
            curLife = 30;
            attack = 35;
            defend = 2;
            agile = 20;
        } else if (num == 3) {
            type = "钢盔僵尸";
            curLife = 60;
            attack = 20;
            defend = 10;
            agile = 25;
        }
        maxLife = curLife;
    }

    public boolean hidden() {
       return GameUtil.isHide(agile,hideRate);

    }

    public void injured(Hunter hunter) {
        if (hidden()) {
            System.out.println("怪物躲避了攻击!!!!!!!!!!!!!!!!");
        } else {//和Hunter不太一样的是：不管怪物是否躲避成功，最后都要显示info()并作出反击,所以需要用到else{}
            int p=curLife;
            curLife-= GameUtil.lostLife(hunter.attack,defend);
            System.out.println(type + "受到了" + (p - curLife) + "点伤害");
            if (curLife <= 0) {
                dead(hunter);
            }
        }
        info();
        kill(hunter);
    }

    public void dead(Hunter hunter) {
        System.out.println(type + "已死亡");
        isLive = false;
        hunter.addExp(this);
    }

    public void kill(Hunter hunter) {
        if (!isLive) {
            return;
        }
        if (!hunter.isLive) {
            return;
        }
        System.out.println(type + "杀向了" + hunter.name);
        hunter.injured(this);
    }

    public void info() {
        System.out.println("类别:" + type + ",当前血量:" + curLife + ",最大生命值:" + maxLife + ",攻击力:"
                + attack + ",防御:" + defend + ",是否存活:" + isLive);
    }
}