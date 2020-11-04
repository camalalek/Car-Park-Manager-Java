package carparkmanager;

public class Car extends Vehicle{
    ////////////////////////////// Defining Variables //////////////////////////////
    protected int noOfDoors;
    protected String colour;

    ////////////////////////////// Setting local and super class variables //////////////////////////////
    Car(String idPlate, String vehicleBrand, int noOfDoors, String colour, DateTime dt) {
        super(idPlate, vehicleBrand, dt); // Setting super class variables
        this.noOfDoors = noOfDoors;
        this.colour = colour;
    }
    
    ////////////////////////////// Returning string with local and super class data //////////////////////////////
    public String vehicleSpec(){
        return super.vehicleSpec() + " | Number of Doors: "+noOfDoors+" | Vehicle Colour: "+colour+" | ";
    }
    
    ////////////////////////////// Returning vehicle type //////////////////////////////
    public String getVehicleType(){
        return "Car";
    }

    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
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

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
}
