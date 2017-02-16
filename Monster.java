class Monster extends Enemy {

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
}