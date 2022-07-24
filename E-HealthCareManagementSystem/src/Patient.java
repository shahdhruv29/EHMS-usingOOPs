import java.text.SimpleDateFormat;
import java.util.*;

public class Patient {

    public static Scanner sc = new Scanner(System.in);
    public String name;
    public String address;
    public String patientID;
    public String contact_no;
    public String type; // types bifurcates between RegularPatient and AddmittedPatient
    // protected String status; // 2 status possible for RegularPatient appointed,
    // examined
    // 3 types possible for AddmittedPatient toAdmit, Addmitted, Released

    protected int age;
    protected String sex;
    public String DoctorAppointed;

    Patient(String patientID, String name) {
        this.name = name;
        this.patientID = patientID;
    }

    Patient() {
        setName();
        setAge();
        setSex();
        setContact_No();
        setAddress();

    }

    void printPatientDetail() {

    }

    // function that will automatically generate id's of patients
    static int seedReg = 1;
    static int seedAdd = 1;

    static String generatePatientID(String patientType) {
        String ID = "";
        if (patientType.equals(RegularPatient.typePatient)) {
            ID = "100" + Integer.toString(seedReg);
            seedReg++;
        }
        if (patientType.equals(AddmittedPatient.typePatient)) {
            ID = "200" + Integer.toString(seedAdd);
            seedAdd++;
        }
        return ID;
    }

    // A function to print detail for the patient

    public static void printDetail() { // this method goes into Main file which prints the details and bill for the
                                       // individual patients
        boolean flag = true;
        int choice = 0;
        while (flag) {
            System.out.println("\n\n\n");
            System.out.println(
                    "\t\t\t**********************************************************************************************\n");
            System.out.println(
                    "\t\t\t*                  1. PRINT PATIENT DETAILS                                                  *\n");
            System.out.println(
                    "\t\t\t*                  2. PRINT BILL OF THE PATIENT                                              *\n");
            System.out.println(
                    "\t\t\t*                  3. CALCULATE BILL OF THE PATIENT                                          *\n");
            System.out.println(
                    "\t\t\t*                  4. EXIT                                                                   *\n");
            System.out.println(
                    "\t\t\t**********************************************************************************************\n");

            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            System.out.println("\n\n\n\n");
            Patient printed;
            String id;

            switch (choice) {
                case 1:
                    System.out.println("ENTER PATIENT ID : ");
                    id = sc.next();
                    printed = findPatient(id);
                    if (printed == null) {
                        System.out.println("Patient ID doesn't exist, try again...");
                        return;
                    }
                    printed.printPatientDetail();
                    break;
                case 2:
                    System.out.print("ENTER PATIENT ID : ");
                    id = sc.next();
                    printed = findPatient(id);
                    Bill.printBill(printed);
                    break;
                case 4:
                    flag = false;
                    break;
                case 3:
                    System.out.print("ENTER PATIENT ID : ");
                    id = sc.next();
                    printed = findPatient(id);
                    if (printed == null) {
                        System.out.println("Patient ID doen't exist, enter correct Patient ID ...");
                        return;
                    }

                    if (printed.type.equals(RegularPatient.typePatient)) {
                        RegularPatient billPatient = (RegularPatient) printed;
                        System.out.println("Hi");
                        Bill.calculateBill(billPatient);
                    }
                    if (printed.type.equals(AddmittedPatient.typePatient)) {
                        AddmittedPatient billPatient = (AddmittedPatient) printed;
                        Bill.calculateBill(billPatient);
                    }
                    break;
                default:
                    System.out.println("Please Enter The Correct Choice");
                    break;
            }

        }
    }
    // This function finds the patient from the ArrayList.

    static Patient findPatient(String id) {
        for (int i = 0; i < RegularPatient.rpList.size(); i++) {
            Patient ret = RegularPatient.rpList.get(i);
            if (id.equals(ret.patientID)) {
                return ret;
            }
        }
        for (int i = 0; i < AddmittedPatient.apList.size(); i++) {
            Patient ret = AddmittedPatient.apList.get(i);
            if (id.equals(ret.patientID)) {
                return ret;
            }
        }
        System.out.println("Patient Not Found Enter correct ID");
        return null;
    }

    public static void displayPatientDetails() {
        RegularPatient.displayRegularDetails();
        AddmittedPatient.displayAddmittedDetails();
    }

    // functions to take input from user for Name, Age, Sex, Contact_No, Address,
    // PatientID
    static void newPatient() {
        boolean flag = true;
        int choice = 0;
        while (flag) {
            System.out.print(
                    "\t\t\t**********************************************************************************************\n");
            System.out.println(
                    "\t\t\t*                  1. REGULAR PATIENT                                                      *\n");
            System.out.println(
                    "\t\t\t*                  2. ADMITTED PATIENT                                                     *\n");
            System.out.println(
                    "\t\t\t*                  3. EXIT TO THE MAIN MENU                                                *\n");
            System.out.print(
                    "\t\t\t**********************************************************************************************\n");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            System.out.println("\n\n\n");

            switch (choice) {
                case 1:
                    RegularPatient.newRegularPatient();
                    break;
                case 2:
                    AddmittedPatient.newAddmittedPatient();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter The Correct Option");
                    break;
            }

        }

    }

    void setName() {
        System.out.print("Enter the name of Patient: ");
        name = sc.next();
    }

    void setAge() { // exception handling using do - while to enter age in integer
        boolean checkage;
        age = 0;
        do {
            try {
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Enter the age: ");
                age = sc1.nextInt();
                checkage = false;
            } catch (Exception e) {
                // accept integer only.
                System.out.println("Enter age in integer value only ");
                checkage = true;
            }
        } while (checkage);

    }

    void setSex() {
        boolean checksex = true;

        while (checksex == true) {
            System.out.print("Enter sex: ");
            sex = Patient.sc.next();
            if (sex.equalsIgnoreCase("M")) {
                checksex = false;
                return;
            } else if (sex.equalsIgnoreCase("F")) {
                checksex = false;
                return;
            } else {
                System.out.println("Enter M for Male and F for female ");
            }

        }

    }

    void setContact_No() {
        System.out.print("Enter contact number: ");
        contact_no = sc.next();
    }

    void setAddress() {
        System.out.print("Enter address: ");
        address = sc.next();
    }

    void setPatientID() {

    }

}

// The RegularPatient class extends the Patient class

class RegularPatient extends Patient {
    static String typePatient = "RegularPatient";

    RegularPatient(String patientID, String name) {
        super(patientID, name);
        this.type = RegularPatient.typePatient;

    }

    RegularPatient() {
        super();
        this.type = RegularPatient.typePatient;
        this.setPatientID();
        DoctorName = DoctorInfo.DoctorAllotment("fever"); // Change to be made in DoctorAllotment later

    }

    //We have hard-coded the data of some patients into an ArrayList.
    public static ArrayList<RegularPatient> rpList = new ArrayList<>();
    static {
        rpList.add(new RegularPatient(generatePatientID(RegularPatient.typePatient), "Rahul"));
        rpList.add(new RegularPatient(generatePatientID(RegularPatient.typePatient), "Aakash"));

        rpList.get(0).contact_no = "9876543210";
        rpList.get(1).contact_no = "9876543211";

        rpList.get(0).address = "Pune";
        rpList.get(1).address = "Mumbai";

        rpList.get(0).age = 20;
        rpList.get(1).age = 21;

        rpList.get(0).DoctorAppointed = DoctorInfo.DoctorAllotment("fever");
        rpList.get(1).DoctorAppointed = DoctorInfo.DoctorAllotment("fever");

        rpList.get(0).sex = "M";
        rpList.get(1).sex = "F";

    }

    protected String DoctorName;
    String Symptoms;
    String Dignosis;
    String Medicines;
    int Fees = 1000;
    Bill patientBill;

    /********************************************************************************************************************************************/
    @Override
    void setPatientID() {
        System.out.print("Patient ID : ");
        this.patientID = generatePatientID(this.type);
        System.out.println(this.patientID);
    }

    @Override // It will Override the printPatientDetail method
    void printPatientDetail() { // It will print all the details of the particular patient
        System.out.println("Patient ID : " + patientID);
        System.out.println("Patient name : " + name);
        System.out.println("Patient age : " + age);
        System.out.println("Patient sex : " + sex);
        System.out.println("Patient type : " + type);
        System.out.println("DoctorAppointed : " + DoctorAppointed);
        System.out.println("Patient address : " + address);
        System.out.println("Patient contact_no : " + contact_no);
    }

    public static void displayRegularDetails() {
        for (int i = 0; i < rpList.size(); i++) {
            Patient tempPatient = rpList.get(i);
            String temp = "Patient ID : " + tempPatient.patientID;
            for (int j = 0; j < (6 - tempPatient.patientID.length()); j++) {
                temp += " ";
            }
            temp += "   Patient Name : " + tempPatient.name;
            for (int j = 0; j < (10 - tempPatient.name.length()); j++) {
                temp += " ";
            }
            System.out.println(temp + "   Type : " + tempPatient.type);
        }
    }

    public static void newRegularPatient() {
        rpList.add(new RegularPatient());
    }

    /********************************************************************************************************************************************/

}

class AddmittedPatient extends Patient {
    static String typePatient = "AddmittedPatient";
    //We have hard-coded some data of Patients in an Array List.
    public static ArrayList<AddmittedPatient> apList = new ArrayList<>();
    static {
        apList.add(new AddmittedPatient(generatePatientID(AddmittedPatient.typePatient), "Jay", "breath-shortness"));
        apList.add(new AddmittedPatient(generatePatientID(AddmittedPatient.typePatient), "Jaya", "hair-loss"));

        apList.get(0).contact_no = "9876543212";
        apList.get(1).contact_no = "9876543213";

        apList.get(0).address = "Pune";
        apList.get(1).address = "Mumbai";

        apList.get(0).age = 22;
        apList.get(1).age = 23;

        apList.get(0).DoctorAppointed = DoctorInfo.DoctorAllotment("breath-shortness"); // It will call the function to
                                                                                        // appoint the doctor to the
                                                                                        // patient.
        apList.get(1).DoctorAppointed = DoctorInfo.DoctorAllotment("hair-loss"); // It will call the function to appoint
                                                                                 // the doctor to the patient.

        apList.get(0).sex = "M";
        apList.get(1).sex = "F";

    }

    AddmittedPatient(String patientID, String name, String Symptoms) {
        super(patientID, name);
        this.type = AddmittedPatient.typePatient;
        this.Symptoms = Symptoms;
        this.Status = "Addmitted";

    }

    AddmittedPatient() {
        super();
        this.type = AddmittedPatient.typePatient;
        this.Status = "Addmitted";
        setPatientID();
        this.billPatient = new Bill();
        this.appointDoctor();

    }

    // Attributes
    String DoctorAppointed;
    Date dateOfAdmission;
    String Symptoms;
    String Status;
    int DocFees = 500; // intitially it it decided same for all doctor
    int RoomCharge = 3500; // per-day charge
    Bill billPatient;
    int no_of_days;

    /********************************************************************************************************************************************/
    @Override //This will override the setPatientID method of the Patient class.
    void setPatientID() {
        System.out.print("Patient ID : ");
        this.patientID = generatePatientID(this.type);
        System.out.println(this.patientID);
    }

    // @Override // It will Override the abstract printPatientDetail method
    void printPatientDetail() { // It will print all the details of the particular patient

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Patient ID : " + patientID);
        System.out.println("Patient name : " + name);
        System.out.println("Patient age : " + age);
        System.out.println("Patient sex : " + sex);
        System.out.println("Patient type : " + type);
        // System.out.println("Date of Addmissioin : " +
        // formatter.format(dateOfAdmission));
        System.out.println("DoctorAppointed : " + DoctorAppointed);
        // System.out.println("Status : " + this.Status);
        System.out.println("Symptoms : " + this.Symptoms);
        System.out.println("Patient status : " + this.Status);
        if (this.Status == "Released") {
            System.out.println("Bill :" + billPatient.totalAmount);
        }
        System.out.println("Patient address : " + address);
        System.out.println("Patient contact_no : " + contact_no);

    }

    void setDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dateOfAdmission = new Date();
    }

    // appointDoctor function will appointDoctor to the patient
    void appointDoctor() {
        this.giveSymptoms();
        DoctorAppointed = DoctorInfo.DoctorAllotment(this.Symptoms);
        System.out.println("Doctor Appointed : " + this.DoctorAppointed);
    }

    // Fuction that print the basic details of all patient
    public static void displayAddmittedDetails() {
        for (int i = 0; i < apList.size(); i++) {
            Patient tempPatient = apList.get(i);

            String temp = "Patient ID : " + tempPatient.patientID;
            for (int j = 0; j < (6 - tempPatient.patientID.length()); j++) {
                temp += " ";
            }
            temp += "   Patient Name : " + tempPatient.name;
            for (int j = 0; j < (10 - tempPatient.name.length()); j++) {
                temp += " ";
            }
            System.out.println(temp + "   Type : " + tempPatient.type);
        }
    }

    public static void newAddmittedPatient() {
        apList.add(new AddmittedPatient());
    }

    // Make functions of Symptoms
    void giveSymptoms() {
        System.out.print("Symptoms : ");
        this.Symptoms = Patient.sc.next();
    }

}
