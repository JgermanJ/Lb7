package org.l7;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CarLogic {
    List<Car> getThisModelCars(String model);
    List<Car> getCarsExploitedMoreThenThisYear(int year);
    List<Car> getCarsThisYearWhichPriceMoreThen(int year,double price);
    List<Car> sortCarsByPrice();
    Set<String> modelsCarsInProgrammes();
    Map<String,List<Car>> mapModels();
}