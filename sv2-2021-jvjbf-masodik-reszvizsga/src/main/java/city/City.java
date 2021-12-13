package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings= new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
    public void addBuilding(Building building){
        long sumArea=0L;
        for (Building b:buildings) {
            sumArea+=b.getArea();
        }
        if(sumArea+building.getArea()<=fullArea){
            buildings.add(building);
        }
        else{
            throw new IllegalArgumentException("City can't be larger than 500");
        }
    }

    public Building findHighestBuilding(){
        int maxLevel=0;
        Building highestBuilding=null;
        for (int i=0; i<buildings.size()||highestBuilding==null;i++) {
            if(buildings.get(i).getLevels()>maxLevel){
                maxLevel=buildings.get(i).getLevels();
                highestBuilding=buildings.get(i);
            }
        }
        return highestBuilding;
    }

    public List<Building> findBuildingsByStreet(String street){
        List<Building> result= new ArrayList<>();
        for (Building b :buildings) {
            if(b.getAddress().getStreet().equals(street)){
                result.add(b);
            }
        }
        return result;
    }
    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        for (Building b:buildings) {
            if(b.calculateNumberOfPeopleCanFit()>numberOfPeople){
                return true;
            }
        }
        return false;
    }
}
