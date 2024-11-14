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
            toPunch.health = Math.max(0, toPunch.health);
        }

        public void takeHit(int damage) {

            health -= damage;
        }

        public boolean isConcious(){

            return this.health > 0;
        }
    }