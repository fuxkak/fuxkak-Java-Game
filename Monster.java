class Monster {
    int curLife;
    int maxLife;
    boolean isLive;
    String type;
    int attack;
    int defend;
    int minJie;
    int hideRate;

    public Monster(int n) {
        isLive = true;
        hideRate = 60;
        if (n == 1) {
            type = "普通僵尸";
            maxLife = 40;
            attack = 25;
            defend = 8;
            minJie = 30;
        } else if (n == 2) {
            type = "魔法僵尸";
            maxLife = 20;
            attack = 30;
            defend = 4;
            minJie = 40;
        } else if (n == 3) {
            type = "钢盔僵尸";
            maxLife = 60;
            attack = 20;
            defend = 20;
            minJie = 50;
        }
        curLife = maxLife;
    }


    public boolean hidden() {
        return GameUtil.isHide(minJie, hideRate);
    }

    public void injured(Hunter hunter) {
        if (hidden()) {
            System.out.println(type + "躲避了攻击!!!!!!!!");
        } else {
            int p = curLife;
            curLife -= GameUtil.calLostLife(hunter.attack, defend);
            System.out.println(type + "受到了" + (p - curLife) + "点攻击");
            if (curLife <= 0) {
                dead(hunter);
            }
        }
        kill(hunter);
        info();
    }

    public void kill(Hunter hunter) {
        if (!isLive) {
            return;
        }
        if (!hunter.isLive) {
            return;
        }
        System.out.println(type + "杀向" + hunter.name);
        hunter.injured(this);
    }

    public void dead(Hunter hunter) {
        System.out.println(type + "已死亡");
        isLive = false;
        //让hunter增加经验值
        hunter.addExp(this);
    }

    public void info() {
        System.out.println("类别:" + type + ",当前血量:" + curLife + ",最大生命值:" + maxLife + ",攻击力:"
                + attack + ",防御:" + defend + ",是否存活:" + isLive);
    }
}