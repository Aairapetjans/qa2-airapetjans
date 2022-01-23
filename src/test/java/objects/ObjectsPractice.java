package objects;

import org.junit.jupiter.api.Test;

public class ObjectsPractice {
    @Test
    public void workingWithObjects() {
        Student pavel = new Student("Pavel", "Testerovich" );
//        pavel.setFirstName("Pavel");
//        pavel.setLastName("Testerovich");
        pavel.setAge(80);
        pavel.setPhone(3719887785L);


        Student nadja = new Student();
        nadja.setFirstName("Nadezhda");
        nadja.setLastName("Figvam");
        nadja.setAge(69);
        nadja.setPhone("911");

        //25 + 13 -> 38
        // "25" = "13" -> 2513


        System.out.println("First student: " + nadja.getFirstName() + "  " + nadja.getLastName());
        System.out.println("Second student: " + pavel.getFirstName() + "   " + pavel.getLastName());

        System.out.println("First student: " + nadja.getFullName());
        System.out.println("First student: "  + pavel.getFullName());




        
        
        
        
    }
}
