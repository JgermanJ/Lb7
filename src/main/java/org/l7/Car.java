package org.l7;


import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private int id;
    private String model;
    private LocalDate createYear;
    private double price;
    private String winCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getCreateYear() {
        return createYear;
    }

    public void setCreateYear(LocalDate createYear) {
        this.createYear = createYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWinCode() {
        return winCode;
    }

    public void setWinCode(String winCode) {
        this.winCode = winCode;
    }

    public Car(int id, String model, LocalDate createYear, double price, String winCode) {
        this.id = id;
        this.model = model;
        this.createYear = createYear;
        this.price = price;
        this.winCode = winCode;
    }

    public Car() {
        this.id = 0;
        this.model = null;
        this.createYear = null;
        this.price = 0;
        this.winCode = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Double.compare(car.price, price) == 0 && Objects.equals(model, car.model) && Objects.equals(createYear, car.createYear) && Objects.equals(winCode, car.winCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, createYear, price, winCode);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", model='" + model + '\'' + ", createYear=" + createYear.getYear() + ", price=" + price + ", winCode='" + winCode + '\'' + "}\n";
    }
}
