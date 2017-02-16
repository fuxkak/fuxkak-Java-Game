class Vampire {
    int curLife;
    int maxLife;
    boolean isLive;
    String type;
    int attack;
    int defend;
    int minJie;
    int hideRate;

    // 增加吸血比例的属性
    int getLifeRate;

    public Vampire(int v) {
        isLive = true;
        hideRate = 60;
        if (v == 1) {
            type = "吸血蝙蝠";
            maxLife = 40;
            attack = 25;
            defend = 8;
            minJie = 30;
            getLifeRate = 40;

        } else if (v == 2) {
            type = "吸血鬼";
            maxLife = 20;
            attack = 30;
            defend = 4;
            minJie = 40;
            getLifeRate = 66;
        } else if (v == 3) {
            type = "吸血鬼王";
            maxLife = 60;
            attack = 20;
            defend = 20;
            minJie = 50;
            getLifeRate = 80;
        }
        curLife = maxLife;
    }

    //增加吸血方法(从vampire的受伤方法用参数传入hunter受到的伤害)
    public void bloodSuck(int damage) {
        //吸血鬼应该增加的血量
        int suck = damage * getLifeRate / 100;
        System.out.println("吸血成功!,吸取到了" + suck + "点血量");
        if (suck + curLife > maxLife) {
            curLife = maxLife;
        } else {
            curLife += suck;
        }
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