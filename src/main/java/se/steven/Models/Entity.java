package se.steven.Models;
import java.util.Scanner;

    public abstract class Entity {
        String role;
        int health;
        int damage;

        Entity(String role, int health, int damage) {
            this.role = role;
            this.health = health;
            this.damage = damage;
        }

        static Scanner sc = new Scanner(System.in);

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


        public void punch(Entity toPunch) {

            toPunch.takeHit(damage);
        }

        void takeHit(int damage) {

            health -= damage;
        }

        public boolean isConcious() {

            return health <= 0;
        }
    }