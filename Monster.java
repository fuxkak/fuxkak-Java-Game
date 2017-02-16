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
            agile = 30;
        } else if (num == 2) {
            type = "魔法僵尸";
            curLife = 30;
            attack = 35;
            defend = 2;
            agile = 50;
        } else if (num == 3) {
            type = "钢盔僵尸";
            curLife = 60;
            attack = 20;
            defend = 10;
            agile = 80;
        }
        maxLife = curLife;
    }

    public int randomInt(int start, int end) {
        return (int) (Math.random() * (end - start) + start);//
    }

    public boolean hidden() {
        //1.生成一个成功躲避几率(和敏捷相关)
        int successRate = agile * hideRate / 100;
        //2.生成一个随机数来判断猎人是否躲避成功
        int ran = randomInt(1, 101);
        //3.判断是否躲避成功(如果随机数小于成功躲避几率,则躲避成功)
        if (ran < successRate) {
            System.out.println("随机数为"+ran+",闪避几率为:"+successRate);
            return true;
        } else {
            System.out.println("随机数为"+ran+",闪避几率为:"+successRate);
            return false;
        }

    }

    public void injured(Hunter hunter) {
        if (hidden()) {
            System.out.println("怪物躲避了攻击!!!!!!!!!!!!!!!!");
        } else {//和Hunter不太一样的是：不管怪物是否躲避成功，最后都要显示info()并作出反击,所以需要用到else{}
            int p = curLife;
            int lostLife = hunter.attack - defend;
            int lostBasicLife = 7;

            if (lostLife <= 0) {
                curLife -= lostBasicLife;
            } else {
                curLife -= lostBasicLife + lostLife;
            }
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