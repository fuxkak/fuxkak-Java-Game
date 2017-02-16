public class Game {
    public static void main(String[] args) {
        Hunter h = new Hunter();
        h.name="寒冰射手";
        h.weapon="弓箭";
        h.life=100;
        h.isLive=true;

        Monster m = new Monster();
        m.isLive=true;
        m.life=100;
        m.type="普通僵尸";
        h.fight(m);
        m.kill(h);
        m.kill(h);
    }
}