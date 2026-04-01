class Slot{
    int booked = 0;
    int totalSlots;
    public Slot(int totalSlots){

        this.totalSlots = totalSlots;
    }
    public boolean isAvailable(){
        if(booked < totalSlots){
            return true;
        }else{
            return false;
        }
    }

}