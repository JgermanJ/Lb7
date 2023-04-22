package org.l7;

import java.time.LocalDate;
import java.util.*;

public class CarLogicImpl implements CarLogic {
    List<Car> cars;

    public CarLogicImpl() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(int id, String model, LocalDate createYear, double price, String winCode) {
        Car car = new Car(id, model, createYear, price, winCode);
        cars.add(car);
    }

    public boolean remove(int id) {
        return cars.removeIf(c -> c.getId() == id);
    }

    public boolean removeAll() {
        cars.clear();
        return true;
    }


    @Override
    public List<Car> getThisModelCars(String model) {
        List<Car> listCars = new ArrayList<>();
        for (Car c : cars) {
            if (model.equals(c.getModel())) {
                listCars.add(c);
            }
        }
        listCars.sort(Comparator.comparing(car -> car.getCreateYear().getYear()));
        return listCars;
    }

    @Override
    public List<Car> getCarsExploitedMoreThenThisYear(int years) {
        List<Car> listCars = new ArrayList<>();
        for (Car car :
                cars) {
            if (LocalDate.now().getYear()-car.getCreateYear().getYear() > years) {
                listCars.add(car);
            }
        }

        return listCars;
    }

    @Override
    public List<Car> getCarsThisYearWhichPriceMoreThen(int year, double price) {
        List<Car> listCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCreateYear().getYear() == year && car.getPrice() > price) {
                listCars.add(car);
            }
        }
        return listCars;
    }

    @Override
    public List<Car> sortCarsByPrice() {
        List<Car> listCars = cars;
        listCars.sort(Comparator.comparingDouble(Car::getPrice).reversed().thenComparing(c -> c.getCreateYear().getYear()));
        return listCars;
    }

    @Override
    public Set<String> modelsCarsInProgrammes() {
        Set<String> models = new HashSet<>();
        for (Car car : cars) {
            models.add(car.getModel());
        }
        return models;
    }

    @Override
    public Map<String, List<Car>> mapModels() {
        Map<String, List<Car>> map = new HashMap<>();
        for (Car car : cars) {
            List<Car> carsList = new ArrayList<>();
            for (Car c : cars) {
                if (car.getModel().equals(c.getModel())) {
                    carsList.add(c);
                }
            }
            map.put(car.getModel(), carsList);
        }
        return map;
    }

    public void showAllCars() {
        for (Car c : cars) {
            System.out.println(c);
        }
    }
}
