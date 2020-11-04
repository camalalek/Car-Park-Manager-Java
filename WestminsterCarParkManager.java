        package carparkmanager;

        ////////////////////////////// Importing all libraries for class //////////////////////////////
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WestminsterCarParkManager implements carparkmanager /* Sharing all abstract methods from the interface class */ {
    private ArrayList <Vehicle>parkingPlot; //Defining array with data type of Vehicle object
    private final int maxInQueue = 20; //Setting a non change-able variable
    private int noStayInQueue = 0; //Creating variable for current parking plots used
    
    ////////////////////////////// Setting default variables and length of array //////////////////////////////
    public WestminsterCarParkManager(int arrayLength){
        this.noStayInQueue = arrayLength;
        parkingPlot = new ArrayList<Vehicle>(maxInQueue); // creating new arraylist with a max limit and a datatype of the vehicle object
    }
    
    ////////////////////////////// Returning the current array indexes that are null //////////////////////////////
    public int spacesLeft(){
        return maxInQueue - parkingPlot.size();
    }
    
    ////////////////////////////// SHOW LIST OF VEHICLES ON A CERTAIN DATE //////////////////////////////
    public void showDatedVehicles(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Date to be compared (DD/MM/YYYY)");
        String date = sc.next();

        //Splitting up the date to create a new DateTime object
        String[] dateArray = date.split("/");
        int d = Integer.parseInt(dateArray[0]);
        int mo = Integer.parseInt(dateArray[1]);
        int y = Integer.parseInt(dateArray[2]);

        DateTime dt = new DateTime(d, mo, y, 0, 0, 0);
        
        boolean vehicleOnDate = false;
        for(int i=0; i < parkingPlot.size(); i++){
            if(dt.getDate() == parkingPlot.get(i).getDateTime().getDate() && dt.getMonth() == parkingPlot.get(i).getDateTime().getMonth() && dt.getYear() == parkingPlot.get(i).getDateTime().getYear()){
                System.out.println(parkingPlot.get(i).vehicleSpec());
                vehicleOnDate = true;
            }   
        }
        //If no vehicles found... Print this message
        if(vehicleOnDate == false){
            System.out.println("[!] No results found for "+dt.getDateTime());
        }
    }
    
    ////////////////////////////// ADDING AND VALIDATING OBJECTS WITHIN THE ARRAY //////////////////////////////
    public void addVehicle(Vehicle v){
        //Checking for available spaces for next step
        if (this.spacesLeft() > 0){
            //Adding new object to the parkingPlot array
            parkingPlot.add(v);
            System.out.println("[+] Vehicle added succesfully\nSpaces Available: "+spacesLeft());
        }else{
            System.out.println("[!] No spaces are available");
        }
        
    }
    
    ////////////////////////////// PRINTING EACH VEHICLE WITHIN ARRAY //////////////////////////////    
    public void showAllVehicle(){
        //Simple check if array is empty to return and print message
        if(parkingPlot.isEmpty()){ System.out.println("[!] Car park is empty"); return;}
        //Sorting the array by time with the Collections library
        Collections.sort(parkingPlot);
            //Printing each vehicle within the array
            for(int i = 0; i < parkingPlot.size(); i++){
                System.out.println(parkingPlot.get(i).vehicleSpec());
        }
    }
    
    ////////////////////////////// CALCULATING STATS FOR VEHICLES PARKED //////////////////////////////
    public void showStats(){
        //Creating variables to old stats to be calculated
        double car = 0;
        double van = 0;
        double motorbike = 0;

        double carPerc = 0;
        double vanPerc = 0;
        double motorbikePerc = 0;


       for(int i=0; i<parkingPlot.size(); i++){
           if("Car".equals(parkingPlot.get(i).getVehicleType())){
               //If vehicle type is car add 1 to the varible car
               car++;
           }
            if("Van".equals(parkingPlot.get(i).getVehicleType())){
               //If vehicle type is van add 1 to the varible van
                van++;
           }
             if("Motorbike".equals(parkingPlot.get(i).getVehicleType())){
                //If vehicle type is motorbike add 1 to the varible motorbike
                motorbike++;
           }
       }
       
       // PERCENTAGE CALCULATIONS AND DISPLAYING //
       van = van/2;
       double curNo = car + van + motorbike;
        carPerc = car/curNo*100;
        vanPerc = van/curNo*100;
        motorbikePerc = motorbike/curNo*100;
        System.out.println("Cars Percentage: " + carPerc + "%");
        System.out.println("Vans Percentage: "+vanPerc+"%");
        System.out.println("Motorbikes Percentage: " + motorbikePerc + "%");
       // PERCENTAGE CALCULATIONS AND DISPLAYING //
        
        Collections.sort(parkingPlot);
            for(int i = 0; i < parkingPlot.size(); i++){
                System.out.println(parkingPlot.get(i).vehicleSpec());
        }
            
        //Finding the longest and last vehicle to enter the garage
        System.out.println("\nLongest vehicle to stay: ( "+parkingPlot.get(0).vehicleSpec()+" )");
        System.out.println("last vehicle to arrive: ( "+parkingPlot.get(parkingPlot.size()-1).vehicleSpec()+" )");
    }
    
    ////////////////////////////// DELETING VEHICLE FROM ARRAY //////////////////////////////
    public void deleteVehicle(String id){
        Scanner sc = new Scanner(System.in);
        // Creating variables "h" = hour and "m" = minute
        int h = 0, m = 0;
        
        //Gaining the time of removal for the vehicle
        System.out.print("Whats the current time? (HH:MM)");
        String time = sc.next();

        //Splitting the hour and minute for the variable
        String[] timeArray = time.split(":");
        h = Integer.parseInt(timeArray[0]);
        m = Integer.parseInt(timeArray[1]);
        
        //Creating 3 variables to calulate the difference between hours and minutes and money that is accumulated
        int hDiff = 0, mDiff = 0;
        double moneyAcc = 0;
        
        //Scroll through array to find chosen vehicle ID Plate
        for(int i = 0; i<parkingPlot.size(); i++){
            if(id.equals(parkingPlot.get(i).getIdPlate())){
                System.out.print("[-] " + parkingPlot.get(i).getIdPlate() + " has been removed\n");
                
                //Adding data with the 2 new variables
                hDiff = h - parkingPlot.get(i).dateTime.getHour();
                mDiff = m - parkingPlot.get(i).dateTime.getHour();
                
                //If hour is more than the parking hour. Add 24 to hDiff
                if(h < parkingPlot.get(i).dateTime.getHour()){
                    hDiff += 24;
                }
                
                //If minute is more than the parking minute. Add -1 to hDiff
                if(m < parkingPlot.get(i).dateTime.getMinute()){
                    hDiff -= 1;
                }
                
                //If hour is more than or equal too 3. Add 24 to hDiff
                if(hDiff <= 3){
                    moneyAcc = hDiff * 3.00;
                }
                
                //If hour is less than 3 and hDiff is more than 24. hDiff - 3.00 and add 9
                if(hDiff > 3 && hDiff < 24){
                    moneyAcc = 9 + (hDiff - 3.00);
                }
                
                //If hDiff is less than or equal too 24. moneyAcc is set to 24
                if(hDiff >= 24){
                    moneyAcc = 30.00;
                }
                
                //Printing the calculated value
                System.out.println("Money Accumulated: £"+moneyAcc);
                
                //If the vehicle type is van then delete 2 spaces else 1 space
                if(parkingPlot.get(i).getVehicleType() == "Van"){
                    parkingPlot.remove(i);
                    parkingPlot.remove(i);
                }else{
                    parkingPlot.remove(i);
                }
            }
        }
        System.out.println("There are " + spacesLeft() + " spaces avaliable.\n\n");
    }
    
    ////////////////////////////// MENU SYSTEM FOR APPLICATION //////////////////////////////
    public boolean menuRunning(){
        Scanner sc = new Scanner(System.in);
        //Boolean created to control if menu is still in loop
        boolean notRunning = false;
        
        //Printing out the options for menu
        System.out.println("A) Add a new vehicle");
        System.out.println("D) Delete a new vehicle");
        System.out.println("S) Show ALL parked vehicle");
        System.out.println("Z) Show all statistics");
        System.out.println("V) Show vehicles on selected DATE");
        
        System.out.println("\nX) End Program");
        
        //Getting menu option
        System.out.print("\nOpt #> ");
        String opt = sc.next();

        //Switch Case for menu handling
        switch(opt.toUpperCase()){
            ////////////////// ADDING VEHICLE //////////////////
            case "A":
                System.out.println("1) Car");
                System.out.println("2) Motorbike");
                System.out.println("3) Van");
                
                System.out.print("> ");
                int opt2 = sc.nextInt();
                
                System.out.print("What's the vehicle plate ID? ");
                String idPlate = sc.next();

                System.out.print("What's the Vehicle Brand? ");
                String vehicleBrand = sc.next();

                System.out.println("[*] Follow Date and Time Format exactly!");
                System.out.print("Date to be inserted (DD/MM/YYYY)");
                String date = sc.next();
                System.out.print("Time to be inserted (HH:MM:SS)");
                String time = sc.next();

                String[] dateArray = date.split("/");
                int d = Integer.parseInt(dateArray[0]);
                int mo = Integer.parseInt(dateArray[1]);
                int y = Integer.parseInt(dateArray[2]);

                String[] timeArray = time.split(":");
                int h = Integer.parseInt(timeArray[0]);
                int m = Integer.parseInt(timeArray[1]);
                int s = Integer.parseInt(timeArray[2]);

                //Creating new object for DateTime
                DateTime dt = new DateTime(d, mo, y, h, m, s);
                //Switch Case for adding a certain vehicle
                switch(opt2){
                    case 1:
                        System.out.print("How many doors on vehicle? ");
                        int noOfDoors = sc.nextInt();
                        
                        System.out.print("What's the Cars colour? ");
                        String colour = sc.next();

                        Car c = new Car(idPlate, vehicleBrand, noOfDoors, colour, dt);
                        this.addVehicle(c); 
                    break;
                    case 2:
                        System.out.print("What is the engine size? ");
                        int engineSize = sc.nextInt();

                        Motorbike mb = new Motorbike(idPlate, vehicleBrand, engineSize, dt);
                        this.addVehicle(mb); 
                    break;
                    case 3:
                        System.out.print("How much cargo can be held? ");
                        int cargoVolume = sc.nextInt();

                        Van v = new Van(idPlate, vehicleBrand, cargoVolume, dt);
                        this.addVehicle(v);
                        this.addVehicle(v);
                    break;
                }
            break;
            ////////////////// DELETING VEHICLE //////////////////
            case "D":
                System.out.print("What vehicle shall be deleted? \nID Plate:");
                String id = sc.next();
                this.deleteVehicle(id);
            break;
            ////////////////// SHOWING ALL VEHICLES
            case "S":
                this.showAllVehicle();
            break;
            ////////////////// SHOWING STATS //////////////////
            case "Z":
                showStats();
            break;
            ////////////////// PRINT CERTAIN DATED VEHICLES //////////////////
            case "V":
                this.showDatedVehicles();
            break;
            ////////////////// ENDING APPLICATION //////////////////
            case "X":
                System.out.println("Application has been ended...");
                notRunning = true;
            break;
            ////////////////// HANDLING INCORRECT OPTIONS //////////////////
            default:
                System.out.println("Invalid option");
            break;
        }
        
        return notRunning;
    }
    
    public static void main(String[] args) {
        //Creating new instance of an interface
        carparkmanager inter = new WestminsterCarParkManager(20);
        //Boolean created to control if menu is still in loop
        boolean notRunning = false;
        
        //Welcome message
        System.out.println("Welcome to Car Park Manager...\n");
        
        //WHILE LOOP TO RUN MENU FROM INTERFACE
        while (!notRunning){
            notRunning = inter.menuRunning();
        }
    }
    ////////////////////////////// END OF MENU SYSTEM FOR APPLICATION //////////////////////////////
}
////////////////////////////// END OF CLASS //////////////////////////////