package ro.pub.cs.aipi.lab02.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import ro.pub.cs.aipi.lab02.dataaccess.DataBaseWrapper;
import ro.pub.cs.aipi.lab02.dataaccess.DataBaseWrapperImplementation;
import ro.pub.cs.aipi.lab02.general.Constants;

public class Exercise04Test {

    @BeforeClass
    public static void executeExercise04() {
        BookStore bookstore = new BookStore();
        int result = bookstore.exercise04();
        if (result != 1) {
            fail("The record was not inserted!");
        }
    }

    @Test
    public void checkNumberOfRecords() {
        DataBaseWrapper dbWrapper = DataBaseWrapperImplementation.getInstance();
        try {
            assertEquals("user table should have 101 records", 101, dbWrapper.getTableNumberOfRows("user"));
        } catch (SQLException exception) {
            System.out.println("An exception has occured: " + exception.getMessage());
            if (Constants.DEBUG) {
                exception.printStackTrace();
            }
        } finally {
            dbWrapper.releaseResources();
        }
    }

}
