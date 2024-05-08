import java.util.Random;

public class MagicalArena {
    private Player playerA;
    private Player playerB;
    private Random random;

    public MagicalArena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.random = new Random();
    }

    public void fight() {
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            int attackRoll = rollDice();
            int defendRoll = rollDice();

            int attackDamage = attacker.getAttack() * attackRoll;
            int defendDamage = defender.getStrength() * defendRoll;

            int damageTaken = Math.max(0, attackDamage - defendDamage);
            defender.reduceHealth(damageTaken);

            System.out.println(attacker == playerA ? "Player A" : "Player B" + " attacks with roll " + attackRoll + ", damage: " + attackDamage);
            System.out.println(defender == playerA ? "Player A" : "Player B" + " defends with roll " + defendRoll + ", damage defended: " + defendDamage);
            System.out.println((defender == playerA ? "Player A" : "Player B") + "'s health reduced by " + damageTaken + " to " + defender.getHealth());
            System.out.println();

            // Swap attacker and defender
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println(playerA.getHealth() == 0 ? "Player B wins!" : "Player A wins!");
    }

    int rollDice() {
        return random.nextInt(6) + 1;
    }
}
