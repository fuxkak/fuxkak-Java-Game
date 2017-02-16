class Enemy {
    int curLife;
    int maxLife;
    boolean isLive;
    String type;
    int attack;
    int defend;
    int minJie;
    int hideRate;

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
        /*
        因为Hunter.java里没有injured(Enemy)的类
        因此本段注释最后一句的this是错误的,暂时注释
        if (!isLive) {
            return;
        }
        if (!hunter.isLive) {
            return;
        }
        System.out.println(type + "杀向" + hunter.name);
        hunter.injured(this);*/
    }

    public void dead(Hunter hunter) {
        System.out.println(type + "已死亡");
        isLive = false;
    }

    public void info() {
        System.out.println("类别:" + type + ",当前血量:" + curLife + ",最大生命值:" + maxLife + ",攻击力:"
                + attack + ",防御:" + defend + ",是否存活:" + isLive);
    }
}