package test;

import persistance.DataBaseConnect;
import persistance.RecordCategories;

/**
 *
 * @author David Ramírez
 */
public class TestDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DataBaseConnect dataBaseConnect = new DataBaseConnect();
        RecordCategories recordCategories = new RecordCategories(0, "prueba1");
        recordCategories.insert();
        recordCategories = new RecordCategories(1, "prueba2",0);
        recordCategories.insert();
        
    }
    
}
