package cz.muni.fi.pb162.parking;

import cz.muni.fi.pb162.parking.factory.CarFactory;
import cz.muni.fi.pb162.parking.impl.Car;
import cz.muni.fi.pb162.parking.impl.ParkingLotImpl;
import cz.muni.fi.pb162.parking.impl.PlaceOccupiedException;

import java.util.Scanner;

/**
 * Class represent command line tool to partially test implemented functionality.
 * @author msabo.
 */
public class Main {

    /**
     * Main program loop.
     * @param args will be ignored
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        System.out.println("Welcome to parking lot!");
        System.out.println("How many places does it have? ");

        Scanner scanner = new Scanner(System.in, "utf-8");
        String line = scanner.nextLine();
        ParkingLot lot = new ParkingLotImpl(Integer.parseInt(line));

        while (true) {
            printLot(lot);
            line = scanner.nextLine();
            try {
                parseCommand(lot, line);
            } catch (IndexOutOfBoundsException | NullPointerException | IllegalArgumentException e) {
                e.printStackTrace();
                System.err.flush();
            }
        }
    }

    /**
     * Prints parking lot in human-friendly way.
     * @param lot lot to be printed
     */
    private static void printLot(ParkingLot lot) {
        for (int i = 0; i < lot.getCapacity(); i++) {
            System.out.printf("%6s", i );
        }
        System.out.println("");

        for (int i = 0; i < lot.getCapacity(); i++) {
            if (lot.isSpaceOccupied(i)) {
                System.out.printf("%6s", "|  X");
            } else {
                System.out.printf("%6s", " |   ");
            }
        }
        System.out.println("  |");
        System.out.println();
    }

    /**
     * Parses entered command.
     * @param lot parking lot
     * @param command entered by student
     */
    public static void parseCommand(ParkingLot lot, String command) {
        if (command.contains("leave")) {
            String[] s = command.split(" ", 2);
            int parkingNumber = Integer.parseInt(s[1]);
            if (lot.isSpaceOccupied(parkingNumber)) {
                Car car = Main.findCar(lot, parkingNumber);
                lot.leaveParking(car);
                System.out.println("Car left");
            } else {
                System.out.println("Place " + parkingNumber + " is not occupied");
            }
            return;
        } else if (command.contains("occupied")) {
            int parkingNumber = Integer.parseInt(command.split(" ", 2)[1]);
            System.out.println("Parking place number " + parkingNumber + " is occupied: "
                    + lot.isSpaceOccupied(parkingNumber));
            return;
        } else if (command.contains("park")) {
            String[] s = command.split(" ", 2);
            if (s.length == 2) {
                int parkingNumber = Integer.parseInt(s[1]);
                Car car = CarFactory.generateCar();
                try {
                    lot.parkInPlace(car, parkingNumber);
                    System.out.println(car);
                } catch (PlaceOccupiedException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }

        switch (command) {
            case "park":
                Car car = CarFactory.generateCar();
                try {
                    int vacantPlace = lot.getFreeParkingPlace();
                    lot.parkInPlace(car, vacantPlace);
                    System.out.println(car);
                } catch (PlaceOccupiedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "full":
                System.out.println("Is lot full: " + lot.isFull());
                break;
            case "cars":
                System.out.println("Parked cars:");
                lot.getParkedCars().forEach(System.out::println);
                break;
            case "free":
                System.out.println(lot.getFreePlaces());
                break;
            case "help":
                System.out.println("Available commands are:\n");
                System.out.println("park <number> - parks car to <number> location ");
                System.out.println("leave <number> - leaves car parked on <number> position");
                System.out.println("occupied <number> - true if <number> position is occupied");
                System.out.println("park - parks car on free parking place");
                System.out.println("full\ncars\nfree\nhelp\nexit");
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }

    /**
     * Finds Car according to number.
     * @param lot lot where car is parked
     * @param number number of parking slot
     * @return found car or null if not found
     */
    private static Car findCar(ParkingLot lot, int number) {
        for (Car car : lot.getParkedCars()) {
            if (lot.findCarNumber(car) == number) {
                return car;
            }
        }
        return null;
    }
}
