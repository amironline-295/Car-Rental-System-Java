import com.project.carrentalsystem.Car;
import com.project.carrentalsystem.CarRentalSystem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        Car car1 = new Car("C001","Cults","Toyota",80.00);
        Car car2 = new Car("C002","Corolla","Toyota",100.00);
        Car car3 = new Car("C003","Civic","Honda",120.00);
        Car car4 = new Car("C004","HR-V","Honda",150.00);
        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);
        carRentalSystem.addCar(car4);

        carRentalSystem.menu();
    }
}