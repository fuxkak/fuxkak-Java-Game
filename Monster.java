public class Monster {
    String type;
    boolean isLive;
    int life;

    public void injured() {
        life -= 20;
        if (life <= 0) {
            dead();
            return;
        }

        System.out.println(type + "惨叫了一声");
        show();
    }

    public void kill(Hunter hunter) {
        if (!isLive) {
            return;
        }
        if (!hunter.isLive) {
            return;
        }

        System.out.println(type + "杀向" + hunter.name);
        hunter.injured();
    }


    public void dead() {
        System.out.println(type + "已死亡");
        //monster死的时候增加hunter经验值
        isLive = false;
    }

    public void show() {
        System.out.println(type+"当前生命值"+life+",怪物状态:"+isLive );
    }
}
