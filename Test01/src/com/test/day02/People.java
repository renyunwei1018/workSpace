package com.test.day02;

import java.util.Objects;

public class People {
    private int age;
    private String name;

    private void doSomeThing(){
        System.out.println("doSome");
    }
    @Override
    public String toString() {
        return ""+this.getClass().getSimpleName()+"{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.doSomeThing();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
