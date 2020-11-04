package carparkmanager;

public abstract class Vehicle implements Comparable<Vehicle>{
    ////////////////////////////// Defining Variables //////////////////////////////
    protected String idPlate;
    protected String vehicleBrand;
    protected DateTime dateTime;
    
    ////////////////////////////// Setting super class variables //////////////////////////////
    public Vehicle(String idPlate, String vehicleBrand, DateTime dateTime) {
        this.idPlate = idPlate;
        this.vehicleBrand = vehicleBrand;
        this.dateTime = dateTime;
    }
    
    ////////////////////////////// Returning vehicle type //////////////////////////////
    public abstract String getVehicleType();
    
    ////////////////////////////// Sorting array by time //////////////////////////////
    public int compareTo(Vehicle vdt){
        int returnVal = 0;
        
        if(this.dateTime.getHour()>vdt.dateTime.getHour())
            returnVal = 1;
        else
            returnVal = -1;
        if(this.dateTime.getHour()==vdt.dateTime.getHour())
            returnVal = 0;
        
        
        if(this.dateTime.getHour()==vdt.dateTime.getHour()){
            if(this.dateTime.getMinute()>vdt.dateTime.getMinute())
                returnVal = 1;
            else
                returnVal = -1;
            }
            return returnVal;
    }
        
    ////////////////////////////// Returning all data from variables //////////////////////////////
    public String vehicleSpec(){
        return " | ID Plate: "+idPlate+" | Vehicle Brand: "+vehicleBrand+" | Date & Time: "+dateTime.getDateTime()+" | ";
    }
   
    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    public String getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
}