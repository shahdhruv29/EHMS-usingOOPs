import java.util.*;
class Main {

    public static void main(String[] args) {
        System.out.println("\n\n\n\t\t\t******************************E-HealthCare-Management-Sytem***********************************\n");
		boolean check = true;
		Scanner sc=new Scanner(System.in);
		while(check==true)
		{   
            System.out.println("\n\n\n");
	        System.out.print("\t\t\t**********************************************************************************************\n");
	        System.out.print("\t\t\t*                  1. ENTER PATIENTS DETAILS                                                 *\n");
	        System.out.print("\t\t\t*                  2. PRINT PATIENT LIST                                                     *\n");
	        System.out.print("\t\t\t*                  3. PRINT DOCTOR LIST                                                      *\n");
	        System.out.print("\t\t\t*                  4. PRINT PATIENT DETAILS                                                  *\n");
	        System.out.print("\t\t\t*                  5. EXIT                                                                   *\n");
	        System.out.print("\t\t\t**********************************************************************************************\n");
            System.out.println("\n\n\n\n");
            
            
            System.out.print("Enter your choice: ");
		    int choice = sc.nextInt();


            System.out.println("\n\n\n\n");


            switch (choice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("ENTERING PATIENTS DETAILS");
                    Patient.newPatient();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("PRINTING PATIENT LIST");
                    Patient.displayPatientDetails();
                    break;
                case 3:
                    //This will clear screen of the command prompt
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("PRINTING DOCTOR DETAILS");
                    DoctorInfo.DisplayDoctorDetails();
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Patient.printDetail();
                    break;
                case 5:
                    check=false;
                    break;
            }
            
            
        }
        sc.close();
}
}