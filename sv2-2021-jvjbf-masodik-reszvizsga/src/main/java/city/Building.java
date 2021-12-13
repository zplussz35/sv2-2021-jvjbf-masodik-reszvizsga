package city;

public abstract class Building {
    private int area;
    private int levels=1;
    private Address address;

    public Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(int area, Address address) {
        this.area = area;
        this.address = address;
    }

    public int getLevels() {
        return levels;
    }

    public int getArea() {
        return area;
    }

    public Address getAddress() {
        return address;
    }

    public int getFullArea(){
        return area*levels;
    }

    public abstract int calculateNumberOfPeopleCanFit();
}
