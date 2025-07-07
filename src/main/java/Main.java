import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race leader = new Race();
        System.out.println("Необходимо заполнить информацию о 3-х автомобилях\n");
        for(int i=1; i<=3; i++){
            System.out.print(i+" автомобиль\nназвание: ");
            String carName = scanner.next();
            System.out.print("скорость(<=250): ");
            int carSpeed = 0;
            while(true){
                try{
                    carSpeed = scanner.nextInt();
                    if(carSpeed>0 && carSpeed<=250) break;
                    else if(carSpeed<0) System.out.print("Скорость не может быть отрицательной. Введите число больше 0: ");
                    else System.out.print("Скорость должна быть <=250. овторите ввод: ");
                }
                catch (InputMismatchException e){
                    System.out.print("Ошибка: введите целое число: ");
                    scanner.next();
                }
            }
            Car newCar = new Car(carName, carSpeed);
            leader = leader.findLeader(newCar.name, newCar.speed);
        }
        System.out.println("Самая быстрая машина: " + leader.leaderName);
    }
}

class Car {
    String name;
    int speed;
    Car(String name, int speed){
        this.name = name;
        this.speed = speed;
    }
}

class Race{
    String leaderName;
    int leaderSpacing;
    Race(String leaderName, int spacing){
        this.leaderName = leaderName;
        this.leaderSpacing = spacing;
    }
    Race(){
        leaderName = "";
        leaderSpacing = 0;
    }
    public Race findLeader(String carName, int carSpeed){
        int carSpacing = carSpeed*24;
        if(leaderSpacing<carSpacing){
            return new Race(carName, carSpacing);
        }
        return new Race(leaderName, leaderSpacing);
    }
}
