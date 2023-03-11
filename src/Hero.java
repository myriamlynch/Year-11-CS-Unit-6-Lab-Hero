import java.util.Random;

public class Hero {

    String name;
    int hitPoints;
    Random random = new Random();


    public Hero(String nm)
    {
        name = nm;
        hitPoints = 100;
    }

    public String getName()
    {
        return name;
    }


    public int getHitPoints()
    {
        return hitPoints;
    }

    public String toString()
    {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponnent)
    {
        double num = 0 + (random.nextDouble() * (0.99-0.00));
        if(num < 0.5)
        {
            int n = opponnent.getHitPoints();
            opponnent.hitPoints = n - 10;
        }
        else if(num >= 0.5)
        {
            int n = this.getHitPoints();
            this.hitPoints = n - 10;
        }
    }

    public void senzuBean()
    {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent)
    {
        while(this.hitPoints > 0 && opponent.getHitPoints() > 0)
            attack(opponent);
    }

    public String fightUntilTheDeath(Hero opponent)
    {
        this.senzuBean();
        opponent.senzuBean();
        this.fightUntilTheDeathHelper(opponent);
        return this.getName() + ": " + this.getHitPoints() + "\t" + opponent.getName() + ": " + opponent.getHitPoints();
    }

    public int[] nFightsToTheDeathHelper(Hero opponent, int n)
    {
        int[] fights = new int[2];
        fights[0] = 0;
        fights[1] = 0;
        for(int i = 0; i < n; i++)
        {
            fightUntilTheDeath(opponent);
            if(this.getHitPoints() == 0) {
                fights[1] = fights[1] + 1;
            }
            else {
                fights[0] = fights[0] + 1;
            }
            senzuBean();
            opponent.senzuBean();
        }
        return fights;
    }

    public String nFightsToTheDeath(Hero opponent, int n)
    {
        int[] fights = nFightsToTheDeathHelper(opponent, n);
        String result = this.getName() + ": " + fights[0] + " wins" + '\'' +
                opponent.getName() + ": " + fights[1] + " wins" + '\'';
        if(fights[0] > fights[1])
            result += this.getName() + " wins!";
        else if(fights[1] > fights[0])
            result += opponent.getName() + " wins!";
        else
            result += "OMG! It was actually a draw!";
        System.out.println(result);
        return result;
    }

    public void dramaticFightToTheDeath(Hero opponent)
    {

    }

}
