package carparkmanager;

public class Van extends Vehicle{
    ////////////////////////////// Defining Variables //////////////////////////////
    protected int cargoVolume;
    
    ////////////////////////////// Setting local and super class variables //////////////////////////////
    Van(String idPlate, String vehicleBrand, int cargoVolume, DateTime dt) {
        super(idPlate, vehicleBrand, dt);
        this.cargoVolume = cargoVolume;
    }
    
    ////////////////////////////// Returning string with local and super class data //////////////////////////////
    public String vehicleSpec(){
        return super.vehicleSpec() + " | Cargo Volume: "+cargoVolume+" | ";
    }
    
    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public String getVehicleType(){
        return "Van";
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

    public int getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
}
