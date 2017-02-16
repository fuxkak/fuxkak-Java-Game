public class Game {
    public static void main(String[] args) {
        Hunter h=new Hunter("阿黄","菜刀");
        Monster m1=new Monster(1);
        Monster m2= new Monster(2);
        Monster m3=new Monster(3);

        h.fight(m1);h.fight(m1);h.fight(m1);h.fight(m1);h.fight(m1);h.fight(m1);
        h.fight(m2);h.fight(m2);h.fight(m2);h.fight(m2);h.fight(m2);h.fight(m2);
        h.fight(m3);h.fight(m3);h.fight(m3);h.fight(m3);h.fight(m3);h.fight(m3);h.fight(m3);h.fight(m3);
    }
}