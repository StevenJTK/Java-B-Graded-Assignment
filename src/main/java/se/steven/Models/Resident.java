package se.steven.Models;

public class Resident extends Entity {

    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    // Frying pan damage
    public void setDamage(int damage) {
        this.damage = damage;
    }



}