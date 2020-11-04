package carparkmanager;

public class Motorbike extends Vehicle{
    ////////////////////////////// Defining Variables //////////////////////////////
    protected int engineSize;
    
    ////////////////////////////// Setting local and super class variables //////////////////////////////
    Motorbike(String idPlate, String vehicleBrand, int engineSize, DateTime dt) {
        super(idPlate, vehicleBrand, dt);
        this.engineSize = engineSize;
    }
    
    ////////////////////////////// Returning string with local and super class data //////////////////////////////
    public String vehicleSpec(){
        return super.vehicleSpec() + "| Engine Size: "+engineSize+" | ";
    }
    
    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public String getVehicleType(){
        return "Motorbike";
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

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
}
