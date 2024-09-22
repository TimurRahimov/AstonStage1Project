package ru.astonstage1project.model;

public class Human implements Comparable<Human> {
    private Sex sex;
    private int age;
    private String surname;

    public enum Sex {
        MALE, FEMALE
    }

    private Human() {
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public static HumanBuilder getBuilder() {
        return new Human().new HumanBuilder();
    }

    @Override
    public int compareTo(Human other) {
        if (this.age != other.age)
            return Integer.compare(this.age, other.age);
        if (!this.surname.equalsIgnoreCase(other.surname))
            return this.surname.compareTo(other.surname);
        return this.sex.compareTo(other.sex);
    }

    public class HumanBuilder {
        private HumanBuilder() {
        }

        public HumanBuilder setSex(Sex sex) {
            Human.this.sex = sex;
            return this;
        }

        public HumanBuilder setAge(int age) {
            Human.this.age = age;
            return this;
        }

        public HumanBuilder setSurname(String surname) {
            Human.this.surname = surname;
            return this;
        }

        public Human build() {
            return Human.this;
        }
    }
}
