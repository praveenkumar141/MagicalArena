import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

class MagicalArenaTest {

    @Test
    void testFight() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.fight();
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }

    @Test
    void testPlayerHealthReduction() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        int initialHealthB = playerB.getHealth();
        int attackRoll = 5;
        int defendRoll = 2;

        int attackDamage = playerA.getAttack() * attackRoll;
        int defendDamage = playerB.getStrength() * defendRoll;

        int damageTaken = Math.max(0, attackDamage - defendDamage);
        playerB.reduceHealth(damageTaken);

        assertTrue(playerB.getHealth() == initialHealthB - damageTaken);
    }

    @Test
    void testRollDice() {
        MagicalArena arena = new MagicalArena(new Player(50, 5, 10), new Player(100, 10, 5));
        for (int i = 0; i < 1000; i++) {
            int roll = arena.rollDice();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}
