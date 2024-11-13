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


        public void punch(Entity toPunch) {

            toPunch.takeHit(damage);

            if(toPunch.health < 0)
                toPunch.health = 0;
        }

        public void takeHit(int damage) {

            health -= damage;
        }

        public boolean isConcious(){

            return this.health > 0;
        }
    }