package backend.Domain;

import java.util.*;
import java.util.concurrent.TimeUnit;
public class Vehicule {

    public String brand;
    public String model;
    public Integer yearOfFabrication;
    public Double dailyCost;
    public Double baseCost;
    public Integer antiquity;
    public Boolean freeKm;
    public Integer rentDays;
    public Double rentCost;
    List<Contract> contracts = new ArrayList<Contract>();

    public Double getBaseCostDouble(){
        return dailyCost * rentDays;
    }
    
    public Boolean hasContract(){
        return contracts.stream().anyMatch(t -> t.brandName.equals(brand));
    }

    public Double contractDiscount(){
        return (hasContract()) ? 0.85 : 1.00;
    }
    
    public Integer getAntiquity(){
        return ((int)TimeUnit.MILLISECONDS.toDays(new Date().getTime()) / 365 ) - antiquity;
    }
}

class Motorbike extends Vehicule{
    Integer cc;

    public Double getRentCostDouble(){
        return ((dailyCost + 500) * rentDays) * contractDiscount();
    }
}

class Car extends Vehicule{
    Boolean hatchback;

    public Double getRentCostDouble(){
        return ((hatchback) ? baseCost + baseCost * 1.1 : baseCost + baseCost * 1.25) * contractDiscount();
    }
}

class Truck extends Vehicule{
    Boolean fourPlusFour;

    public Double possibleSurcharge(){
        return fourPlusFour ? 15000.00 : 10000.00 ;
    }

    public Double getRentCostDouble(){
        return ((rentDays <= 7) ? possibleSurcharge() : possibleSurcharge() + possibleSurcharge() * (rentDays - 7)) * contractDiscount();
    }
}