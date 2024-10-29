package se.steven.Models;

abstract class Entity {
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

    boolean isConcious() {
        return health <= 0;
    }

}