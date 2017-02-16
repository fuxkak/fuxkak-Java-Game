public class Game {
    public static void main(String[] args) {
        Hunter h = new Hunter("寒冰射手", "弓箭");

        Monster m = new Monster(1);
        h.fight(m);
        m.kill(h);
        m.kill(h);
        m.kill(h);
        m.kill(h);
        m.kill(h);
        m.kill(h);
        m.kill(h);
    }
}