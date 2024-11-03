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

        toPunch.takeHit(damage);
    }

    void takeHit(int damage) {

        health -= damage;
    }

    public boolean isConcious() {

        return health <= 0;
    }

        public static void fightLogic(Burglar attacker, Resident defender) {

            attacker.punch(defender);
            System.out.println(attacker.getRole() + " has attacked " + defender.getRole() + " and has " + defender.getHealth() + " health");
            defender.punch(attacker);
            System.out.println("You defend against " + attacker.getRole() + " and now has " + attacker.getHealth() + " health");


        }
    }