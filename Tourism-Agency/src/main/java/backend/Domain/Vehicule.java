package backend.Domain;

import java.util.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Vehicule {

    String brand;
    String model;
    Integer yearOfFabrication;
    Double dailyCost;
    Double baseCost;
    Boolean convenio;
    Integer antiquity;

    
    public Boolean getConvenio(){
        return (brand == "Honda");
    }

    public Integer getAntiquity(){
        return ((int)TimeUnit.MILLISECONDS.toDays((new Date().getTime())) / 365 ) - antiquity;
    }
}