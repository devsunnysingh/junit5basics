package org.example;

import org.example.ComputeCircleArea.ComputeCircleArea;
import org.example.MathUtils.MathUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;

public class MathsUtilTest {
    TestInfo testInfo;
    TestReporter testReporter;
    @BeforeAll
    static void beforeAllInit(){
        System.out.println("This needs to run befor all functions");
    }
    @Test
    public void test(){
        System.out.println("The test ran");
    }
    MathUtils mathUtils;
//    this mathutils object will always be instantiated and remove dupliccy in the functions
    @BeforeEach
    public void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo=testInfo;
        this.testReporter=testReporter;
        testInfo.getDisplayName();
        mathUtils=new MathUtils();
        testReporter.publishEntry("Running "+testInfo.getDisplayName()
                +" with tags "+testInfo.getTags());
    }
    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up.............");
    }
    @Test
    @DisplayName("Testing simple basic add test")
    public void testAdd(){
//        MathUtils mathUtils=new MathUtils();
        int expected=2;
        int result=mathUtils.add(1,1);
        assertEquals(result,expected,"The add method should add two numbers: ");

    }
    @Test
//    This test will only run when the conndition of OS is met
    @EnabledOnOs(OS.LINUX)
    public void testdivideByZero(){

//        MathUtils mathUtils=new MathUtils();
//      This method checks if the exception thrown by method should match the
//      parameter which is given as the first parameter
        assertThrows(ArithmeticException.class,()->mathUtils.divide(1,0),
                "Divide by 0 should throw error");
    }
    @Test
    public void testcomputerCircleArea(){
        ComputeCircleArea object=new ComputeCircleArea();
        double areaResult=object.areaCalculate(2);
        double expectedResult=12.56;
        assertEquals(areaResult,expectedResult);
    }


    @Test
    @Disabled
    @DisplayName("TDD Method. Should not run and it will not run because of above annotation")
    void testDisabled(){
        fail("The test should be disabled");
    }

//    More effective eway to run all teh assert in one go
    @Test
    @Tag("Math")
    @DisplayName("Multiply metho")
    void testMultiply(){

        assertAll(
                ()->assertEquals(4, mathUtils.multiply(2,2)),
                ()->assertEquals(0, mathUtils.multiply(2,0)),
                ()->assertEquals(1, mathUtils.multiply(1,1)),
                ()->assertEquals(-2, mathUtils.multiply(2,-1 ))
        );
    }
//    Nested Test-> Basically nested test inside another test class
    @Nested
    class AddTest{
        @Test
        @DisplayName("Testing for negative number")
        public void addPositive(){
            int expected=-2;
            int result=mathUtils.add(-1,-1);
            assertEquals(result,expected,
// Supplier   ()-> this will only run the part of code if and donly ifsthe test passes.

                    ()->"The add method should do add operation on two -ve numbers: ");

        }
    @Test
    @DisplayName("Testing simple basic add test")
    public void testAdd(){
//        MathUtils mathUtils=new MathUtils();
        int expected=2;
        int result=mathUtils.add(1,1);
        assertEquals(result,expected,"The add method should add two numbers: ");

    }
}


}
