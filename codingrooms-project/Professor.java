import java.util.Scanner;

public class Professor {
    private static int id_num = 217770702;
    private static String password = "Hello123";
    static int grades = 5;
    static Boolean access;

    void grade_checker(int id_num, String password) {
        if (this.id_num == id_num && this.password == password) {
            System.out.println(grades);
        }
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Please input User ID:");
        int inp1 = sc1.nextInt();

        System.out.println("Please input Password:");
        String inp2 = sc1.next();

        if (inp1==id_num && inp2.equals(password)) {
            System.out.println("Welcome, professor.");
            access = true;
        }
        else {
            while (inp1 != id_num && inp2 != password) {
                System.out.println("Error! No user exists in the database. Please try again.");
                inp1 = sc1.nextInt();
                 inp2 = sc1.next();
                 System.out.println("Welcome, professor.");
                 access = true;
            }
        }
        if (access = true) {
        System.out.println(grades);
        }



    }
}
