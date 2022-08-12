import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner((System.in));
    
    public static void main(String[] args) throws NumberFormatException {

        Queue<Integer> floors = new LinkedList<>();

        int totalSeconds = 0;
        int waitMoveSeconds = 5;
        int waitDoorsSeconds = 10;
        int previousFloor = -1;

        while (true) {
            System.out.println("Ожидаю ввода этажа(1-25): (для завершения введите 0)");

            try {
                int input = Integer.parseInt(scanner.nextLine());

                if (0 < input && input <= 25) {

                    if (previousFloor != -1) {
                        floors.offer(input);
                        System.out.println("Предыдущий этаж: " + previousFloor);
                        int currentFloor = input;
                        System.out.println("Текущий этаж: " + currentFloor);

                        totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveSeconds;
                        totalSeconds += waitDoorsSeconds;
                        System.out.println("Потрачено на поездку: " + totalSeconds + " с.");
                        previousFloor = input;

                    } else {
                        floors.offer(input);
                        previousFloor = input;
                    }

                } else if (input == 0) {
                    StringBuilder liftTrip = new StringBuilder();
                    while (!floors.isEmpty()) {
                        liftTrip.append("этаж " + floors.poll().toString() + " -> ");
                    }
                    System.out.println(liftTrip + "выход");
                    System.out.println("Время затраченное лифтом на маршрут =: " + totalSeconds + " с.");
                    break;

                } else {
                    System.out.println("Неверный номер этажа");
                }

            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        }
    }
}
