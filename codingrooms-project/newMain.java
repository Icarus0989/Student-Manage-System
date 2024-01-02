import java. util. Scanner;
import java.util.ArrayList;
public class newMain extends Student {

    private static int id_num = 217770702;
    private static String password = "Hello123";
    static int grades = 5;
    static Boolean access;

    //global initialization for student list
     private static ArrayList <Student> classList = new ArrayList <Student>();

    public static void main(String[] args){



        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please input User ID:");
        int inp1 = sc1.nextInt();

        Boolean access;
        if (inp1 == id_num ) {

            System.out.println("Please enter password");
            String inp2 = sc1.next();
            if (inp2.equals(password)) {
                access = true;
            }
            else {
                access = false;
                while (inp2.equals(password) == false) {
                    System.out.println("Password does not match user Id, please try again.");
                    inp2 = sc1.next();
                }
            }


        }
        else {
            System.out.println("No user exists.");

        }


        while(access = true) {

            System.out.println("----Welcome to the Student Managment System----");
            System.out.println("1 Adding students");
            System.out.println("2 Deleting students");
            System.out.println("3 Editing students");
            System.out.println("4 Checking information");
            System.out.println("5 Quit");
            System.out.println("Please enter the number to continue");

            //Using Scanner to import information
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //Using stitch to complete the operation
            //using global classList so it persists while running the main method
            switch (line) {
                case "1":
                    addStudent(classList);
                    break;
                case "2":
                    deleteStudent(classList);
                    break;
                case "3":
                    editStudent(classList);
                    break;
                case "4":
                    findAllStudent(classList);
                    break;
                case "5":
                    System.out.println("Thank you for using");
                    System.exit(0);//Quit JVM
            }
        }
    }

    //Adding student information
    public static void addStudent(ArrayList<Student> array) {
        //Type in the data information for students, remind which type we need to enter
        Scanner sc = new Scanner(System.in);

        String id;
        while(true) {
            System.out.println("Please enter the student's id: ");
            id = sc.nextLine();

            boolean flag = isUsed(array, id);
            if (flag) {
                System.out.println("The id is already been used, please choose another one.");
            }else{
                break;
            }
        }
        System.out.println("Please enter the student's name: ");
        String name = sc.nextLine();
        System.out.println("Please enter the student's grade: ");
        String grades = sc.nextLine();

        //Create students
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setGrades(grades);

        //Add students in the array
        array.add(s);



        //Gives an indication of successful addition
        System.out.println("Adding student successfully");
    }

    public static boolean isUsed(ArrayList<Student> array, String id){
        //if id is the same in the arraylist, return ture,if not, return false.
        boolean flag = false;
        for(int i=0; i<array.size(); i++){
            Student s = array.get(i);
            if(s.getId().equals(id)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static void findAllStudent(ArrayList<Student> array){

        if (array.size() == 0) {
            System.out.println("No information, please add information first.");
            return;
        }

        System.out.println("ID\t\t\tName\t\tGrade");
        for (int i = 0; i < array.size(); i++){
            Student s = array.get(i);
            System.out.println(s.getId()+"\t" + s.getName() + "\t\t" + s.getGrades());

        }
    }
    public static void deleteStudent(ArrayList<Student> classList){
        //Once students are added, they will show up as a list and then can be chosen to be deleted
        if (classList.size() == 0) {
            System.out.println("No students found. Please add students to proceed");
            return;
        }
        else {
        System.out.println("Please choose number alongside student to delete");
        for (int x = 0; x< classList.size(); x++) {
            Student s = classList.get(x);

            System.out.println(x + " " + s.getName());
        }
        }

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        classList.remove(x);
        System.out.println("Student deleted successfully");
        }


    public static void editStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the student id to edit: ");

        String id = sc.nextLine();

        System.out.println("Please enter the student's new name: ");
        String name = sc.nextLine();
        System.out.println("Please enter the student's new grades: ");
        String grades = sc.nextLine();

        //Create new Students
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setGrades(grades);

        for(int i=0; i<array.size(); i++){
            Student student = array.get(i);
            if(student.getId().equals(id)){
                array.set(i,s);
                break;
            }
        }

        System.out.println("Editing successfully !");

    }
}
