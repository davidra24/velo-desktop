package persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Ramírez
 */
//Patrón de diseño Active record para bases de datos y programación orientada a objetos Gracias Otálora :v 
public class RecordCategories {
    private int id;
    private String name;
    private int sub_cat;
    private DataBaseConnect dataBaseConnect;

    public RecordCategories(int id, String name, int sub_cat) {
        this.id = id;
        this.name = name;
        this.sub_cat = sub_cat;
        dataBaseConnect = new DataBaseConnect();
    }

    public RecordCategories(int id, String name) {
        this.id = id;
        this.name = name;
        this.sub_cat = new Integer(null);
        dataBaseConnect = new DataBaseConnect();
    }
    
    public void insert(){
        dataBaseConnect.sendSentence("insert into categories values ("+id+", '"+name+"' ,"+sub_cat+")");
        dataBaseConnect.commit();
    }
    
    public boolean delete(int id){
        ResultSet rs = dataBaseConnect.sendSentence("delete from categories where id="+id+"");
        return true;
    }
    
    public void update(int id, String name, int sub_cat){
        ResultSet rs = dataBaseConnect.sendSentence("update categories set name="+name+"set sub_category="+sub_cat+""
                + "where id="+id);
    }
    
    public RecordCategories select(int id){
        try {
            ResultSet rs = dataBaseConnect.sendSentence("select * from categories where id="+id+"");
            return new RecordCategories(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch (SQLException ex) {
            System.err.println("Error en consulta: "+ex.getMessage());
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSub_cat() {
        return sub_cat;
    }

    public void setSub_cat(int sub_cat) {
        this.sub_cat = sub_cat;
    }
    
    
}