package builder;

public class Builder {
    public static void main(String[] args) {
   CarBuilder carBuilder=new CarBuilder.Car("test")
           .setAge(10)
           .setColorCar(ColorCar.BLACK)
           .builder();
        System.out.println(carBuilder.toString());

   CarBuilder carBuilder1=new CarBuilder();
   carBuilder1.setAge(10);
   carBuilder1.setName("g");
        System.out.println( carBuilder1.toString());
    }
}

class CarBuilder {


    private String name;
    private int Age;
    private ColorCar color=ColorCar.RED;


    public CarBuilder(Car car) {
        this.name = car.name;
        this.Age = car.Age;
        this.color=car.color;
    }

    public CarBuilder() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "CarBuilder{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                ", color=" + color +
                '}';
    }

    static class Car {
        private String name;
        private int Age;
        private ColorCar color;

        public Car(String name) {
            this.name = name;
        }

        public Car setName(String name) {
            this.name = name;
            return this;
        }

        public Car setAge(int age) {
           this.Age = age;
            return this;
        }

        public Car setColorCar(ColorCar color){
            this.color=color;
            return this;
        }

        public CarBuilder builder(){
            return new CarBuilder(this);
        }
    }

}

