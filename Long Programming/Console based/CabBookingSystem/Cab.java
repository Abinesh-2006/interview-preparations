public class Cab {
 int price;
 User user;
 int distance;

    Cab(int distance){
        this.distance=distance;
        this.price=distance*20;
    }

    public int getPrice() {
        return price;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    void showDetails(){
        System.out.println("--------------------------------------------------");
        System.out.println("Name: "+user.getName());
        System.out.println("Booked Cab From "+user.getSLocation()+" To "+user.getELocation());
        System.out.println("Charge: "+getPrice());
    }
}
