class Vampire extends Enemy {
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

    public void kill(Hunter hunter) {
        if (!isLive) {
            return;
        }
        if (!hunter.isLive) {
            return;
        }
        System.out.println(type + "杀向" + hunter.name);
        int lostLife2 = hunter.injured(this);
        //如果不在Hunter的injured()方法控制,希望在vampire中控制吸血,
        // 则需要在这里控制↓
        this.bloodSuck(lostLife2);
        info();
    }
}