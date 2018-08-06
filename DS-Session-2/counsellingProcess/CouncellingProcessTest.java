package counsellingProcess;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class CouncellingProcessTest
{
	/**
     * test case for allocating programs to students
     */
    @Test
    public void allotProgramToStudentsTest1() {
       
        Map<String, String> expectedMap = new HashMap<String, String>()
                                          {{
                                              put("Prakalpa Rathore", "Program1");
                                              put("Deekshika Sharma", "Program1");
                                              put("Arjita", "Program4");
                                              put("Rahul", "Program2");
                                              put("Chirag", "Program3");
                                              put("Bhavika", "Program5");
                                              put("Rachna", "Program5");
                                              put("Tanu", null);                                              
                                          }};
                                          
        Map<String, String> allocationMap = CounsellingProcess.allotProgramToStudents("C:\\Users\\User6\\Documents\\listOfStudents.xls", "C:\\Users\\User6\\Documents\\listOfPrograms.xls", 8, 5);
        assertEquals(expectedMap, allocationMap);
    }
    
    
    /**
     * test case when one of the input is null
     */
    @Test(expected = AssertionError.class)
    public void allotProgramToStudentsTest2() {
       
        CounsellingProcess.allotProgramToStudents(null , "C:\\Users\\User5\\Documents\\listOfPrograms.xls", 8, 5);
    }
}
