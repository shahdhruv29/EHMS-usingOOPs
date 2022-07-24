import java.util.*;

//The DoctorInfo class contains the information of various doctors(Hard-coded)
//This information is used to allot doctors to the patient according to their symptoms.
public class DoctorInfo {
	String DoctorID;
	String DoctorName;
	String Specilization;

	DoctorInfo(String DoctorId, String DoctorName, String Specilization) {
		this.DoctorID = DoctorId;
		this.DoctorName = DoctorName;
		this.Specilization = Specilization;
	}


	public static void DisplayDoctorDetails() {
		cardioDoctor.DisplayDoctorDetails();
		skinDoctor.DisplayDoctorDetails();
		neuroDoctor.DisplayDoctorDetails();
		generalDoctor.DisplayDoctorDetails();
		radioDoctor.DisplayDoctorDetails();
	}

	

	public static String DoctorAllotment(String symptoms) {
		int x; // x is taking random number which is an index for doctors Arraylist
		Random r = new Random();
		if (symptoms.equalsIgnoreCase("tremor") || symptoms.equalsIgnoreCase("Acute-Spinal-Cord-Injury") || symptoms.equalsIgnoreCase("Severe-Headache") ) {
			// neuro
			x = r.nextInt(neuroDoctor.l3.size());
			return (neuroDoctor.l3.get(x).DoctorName);
		}
		if (symptoms.equalsIgnoreCase("hair-loss"  ) || symptoms.equalsIgnoreCase("Pimples")|| symptoms.equalsIgnoreCase("Skin-rashes")  ) {
			// Dermatologist.
			x = r.nextInt(skinDoctor.l2.size());
			return (skinDoctor.l2.get(x).DoctorName);
		}
		if (symptoms.equalsIgnoreCase("breath-shortness")||symptoms.equalsIgnoreCase("Low-Blood-Pressure") || symptoms.equalsIgnoreCase("High-Blood-Pressure")) {
			// Cardiologist
			x = r.nextInt(cardioDoctor.l1.size());
			return (cardioDoctor.l1.get(x).DoctorName);
		}
		if (symptoms.equalsIgnoreCase("X-Ray")) {
			// Radiologist
			x = r.nextInt(radioDoctor.l5.size());
			return (radioDoctor.l5.get(x).DoctorName);
		}
			// generalDoctor
			x = r.nextInt(generalDoctor.l4.size());
			return (generalDoctor.l4.get(x).DoctorName);


	}
}

class cardioDoctor extends DoctorInfo {

	cardioDoctor(String DoctorId, String DoctorName, String Specilization) {
		super(DoctorId, DoctorName, Specilization);
	}

	public static ArrayList<DoctorInfo> l1 = new ArrayList<DoctorInfo>();

	public static void DisplayDoctorDetails() {
	    for (int i=0; i < l1.size(); i++) {
	        DoctorInfo tempDoctor = l1.get(i);
			
			String temp = "Doctor ID : " + tempDoctor.DoctorID;
            for (int j=0; j < (8 - tempDoctor.DoctorID.length()); j++) {
                temp += " ";
            }
            temp += "   Doctor Name : " + tempDoctor.DoctorName;
            for (int j=0; j < (30 - tempDoctor.DoctorName.length()); j++) {
                temp += " ";
            }
            System.out.println(temp + "   Specialization : " + tempDoctor.Specilization);
	    }
	}

	static {
		l1.add(new DoctorInfo("0001", "Dr. Kamal Sharma", "Cardiologist"));
		l1.add(new DoctorInfo("0002", "Dr. Vibhav Gupta", "Cardiologist"));

	}
}

class skinDoctor extends DoctorInfo {

	skinDoctor(String DoctorId, String DoctorName, String Specilization) {
		super(DoctorId, DoctorName, Specilization);
	}

	public static ArrayList<DoctorInfo> l2 = new ArrayList<DoctorInfo>();

    public static void DisplayDoctorDetails() {
	    for (int i=0; i < l2.size(); i++) {
	        DoctorInfo tempDoctor = l2.get(i);
	        
			String temp = "Doctor ID : " + tempDoctor.DoctorID;
            for (int j=0; j < (8 - tempDoctor.DoctorID.length()); j++) {
                temp += " ";
            }
            temp += "   Doctor Name : " + tempDoctor.DoctorName;
            for (int j=0; j < (30 - tempDoctor.DoctorName.length()); j++) {
                temp += " ";
            }
            System.out.println(temp + "   Specialization : " + tempDoctor.Specilization);
	    }
	}
	
	static {
		l2.add(new DoctorInfo("0003", "Dr. Anil Jain", "Dermatologist"));
		l2.add(new DoctorInfo("0004", "Dr. Harshit Agarwal", "Dermatologist"));
	}
}

class neuroDoctor extends DoctorInfo {

	neuroDoctor(String DoctorId, String DoctorName, String Specilization) {
		super(DoctorId, DoctorName, Specilization);
	}

	public static ArrayList<DoctorInfo> l3 = new ArrayList<DoctorInfo>();

	public static void DisplayDoctorDetails() {
	    for (int i=0; i < l3.size(); i++) {
	        DoctorInfo tempDoctor = l3.get(i);
			
			String temp = "Doctor ID : " + tempDoctor.DoctorID;
            for (int j=0; j < (8 - tempDoctor.DoctorID.length()); j++) {
                temp += " ";
            }
            temp += "   Doctor Name : " + tempDoctor.DoctorName;
            for (int j=0; j < (30 - tempDoctor.DoctorName.length()); j++) {
                temp += " ";
            }
            System.out.println(temp + "   Specialization : " + tempDoctor.Specilization);
	    }
	}
	
	static {
		l3.add(new DoctorInfo("0005", "Dr. Virat Kohli", "Neurologists"));
		l3.add(new DoctorInfo("0006", "Dr. Mahendra Singh Dhoni", "Neurologists"));
	}
}

class generalDoctor extends DoctorInfo {

	generalDoctor(String DoctorId, String DoctorName, String Specilization) {
		super(DoctorId, DoctorName, Specilization);
	}

	public static ArrayList<DoctorInfo> l4 = new ArrayList<DoctorInfo>();

    public static void DisplayDoctorDetails() {
	    for (int i=0; i < l4.size(); i++) {
	        DoctorInfo tempDoctor = l4.get(i);
			
			String temp = "Doctor ID : " + tempDoctor.DoctorID;
            for (int j=0; j < (8 - tempDoctor.DoctorID.length()); j++) {
                temp += " ";
            }
            temp += "   Doctor Name : " + tempDoctor.DoctorName;
            for (int j=0; j < (30 - tempDoctor.DoctorName.length()); j++) {
                temp += " ";
            }
            System.out.println(temp + "   Specialization : " + tempDoctor.Specilization);
	    }
	}
	
	static {
		l4.add(new DoctorInfo("0007", "Dr. Ruskin Jain", "General Physician"));
	}
}

class radioDoctor extends DoctorInfo {

	radioDoctor(String DoctorId, String DoctorName, String Specilization) {
		super(DoctorId, DoctorName, Specilization);
	}

	public static void DisplayDoctorDetails() {
	    for (int i=0; i < l5.size(); i++) {
	        DoctorInfo tempDoctor = l5.get(i);
			
			String temp = "Doctor ID : " + tempDoctor.DoctorID;
            for (int j=0; j < (8 - tempDoctor.DoctorID.length()); j++) {
                temp += " ";
            }
            temp += "   Doctor Name : " + tempDoctor.DoctorName;
            for (int j=0; j < (30 - tempDoctor.DoctorName.length()); j++) {
                temp += " ";
            }
            System.out.println(temp + "   Specialization : " + tempDoctor.Specilization);
	    }
	}
	
	public static ArrayList<DoctorInfo> l5 = new ArrayList<DoctorInfo>();

	static {
		l5.add(new DoctorInfo("0008", "Dr. Parth Maniar", "Radiologist"));
	}
}
