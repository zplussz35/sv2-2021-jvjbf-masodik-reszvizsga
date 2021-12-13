package city;

public class Office extends Building {
    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address,String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        int areaPerTable=area/numberOfTablesPerLevel;
        if(areaPerTable<2 || areaPerTable>5){
            throw  new IllegalArgumentException("Don't efficient amount of tables!");
        }
        this.company=company;
        this.numberOfTablesPerLevel=numberOfTablesPerLevel;

    }


    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel*(this.getLevels()-1);
    }
}
