package se.steven.Models;

    public abstract class Entity {
    String role;
    int health;
    int damage;


    Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }


    // Fetches values & returns
    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }


    void punch(Entity toPunch) {
        toPunch.health -= damage;
    }

    void takeHit(int damage) {
        health -= damage;
    }

    public boolean isConcious() {
        return health <= 0;
    }

   public static void fightLogic(Burglar attacker, Resident defender) {
            attacker.punch(defender);
            System.out.println(defender.role + " has been attacked! ");
            defender.takeHit(attacker.damage);
            System.out.println(defender.role + " has taken " + attacker.damage + " damage! ");
            defender.health -= attacker.damage;
            defender.punch(attacker);
            attacker.health -= attacker.damage;

            if(attacker.isConcious()) {
                System.out.println("The burglar is still concious!" + attacker.health);
            }   else {
                System.out.println("The burglar has been knocked out! Well done. ");
                System.out.println("You can now call the police from your office.");
            }
        }


        public static void startFight(Burglar attacker, Resident defender) {
            fightLogic(attacker, defender);

            if(attacker.health > 0) {
                fightLogic(attacker, defender);
            }
        }








    }



