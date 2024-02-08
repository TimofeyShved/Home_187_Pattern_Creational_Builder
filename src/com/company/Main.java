package com.company;

public class Main {

    public static void main(String[] args) {
        SportCar sportCar = new SportCar.Builder("VAZ").setColor("red").setSpeed(160).build();
        System.out.println(sportCar.getName());
        System.out.println(sportCar.getColor());
        System.out.println(sportCar.getSpeed());
    }
}

class SportCar{
    private  String name;
    private  String color;
    private  int speed;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    // принимем параметры для сборщика
    private SportCar(Builder builder){
        this.name = builder.name;
        this.color = builder.color;
        this.speed = builder.speed;
    }

    //Что бы не плодить кучу сетеров, создаём патерн сборщик
    static class Builder{
        private  String name;
        private  String color;
        private  int speed;

        public Builder(String name){
            this.name = name;
        }

        public Builder setColor(String color){
            this.color = color;
            return this;
        }

        public Builder setSpeed(int speed){
            this.speed = speed;
            return this;
        }
        // до этого момента он получал данные, а теперь передаст выше, уже собранным классом
        public SportCar build(){
            return new SportCar(this);
        }
    }
}