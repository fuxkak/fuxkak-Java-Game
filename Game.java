public class Game {
    public static void main(String[] args) {
        Hunter h = new Hunter("寒冰射手", "弓箭");
        Monster m = new Monster(1);
        Monster m1 = new Monster(2);
        Monster m2 = new Monster(3);
        Monster m3 = new Monster(1);
        Monster m4 = new Monster(1);

//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);
//        m.kill(h);


        h.fight(m);
        h.fight(m);
        h.fight(m);
        h.fight(m1);
        h.fight(m1);
        h.fight(m1);
        h.fight(m2);
        h.fight(m2);
        h.fight(m2);
        h.fight(m2);
        h.fight(m2);
        h.fight(m3);
        h.fight(m3);
    }
}