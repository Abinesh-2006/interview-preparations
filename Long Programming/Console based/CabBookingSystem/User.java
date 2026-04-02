public class User {
    String name;
    String SLocation;
    String ELocation;
    String number;

    Cab cab;

    public User(String name,String Slocation, String ELocation, String number) {
        this.name = name;
        this.SLocation = Slocation;
        this.ELocation = ELocation;
        this.number = number;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSLocation() {
        return SLocation;
    }

    public void setSLocation(String location) {
        SLocation = location;
    }

    public String getELocation() {
        return ELocation;
    }

    public void setELocation(String ELocation) {
        this.ELocation = ELocation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }
}
