/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import modeldatabase.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Win7
 */
public class ModelMovie {
    public Connector DB;
    public ModelMovie(Connector DB){
        this.DB = DB;
    }
    
    public Object[][] getMovie(){
        Object[][] movie = new Object[100][5];
        try{
            DB.statement = DB.koneksi.createStatement();
            ResultSet result = DB.statement.executeQuery("SELECT * FROM `movie`");
            
            int i = 0;
            while(result.next()){
                movie[i][0] = result.getString("title");
                movie[i][1] = result.getString("plot");
                movie[i][2] = result.getString("character");
                movie[i][3] = result.getString("acting");
                movie[i][4] = result.getString("score");
                i++;
            }
            DB.statement.close();
        } catch(SQLException err){
            System.out.println(err);
        }
        return movie;
    }
    
    public void insert(String title, double plot, double character, double acting){
        try {
            double rating = (plot+character+acting)/3.0;
            DB.statement = DB.koneksi.createStatement(); 
            String query = "INSERT INTO `movie` (`title`, `plot`, `character`, `acting`, `score`) VALUES ('"+title+"', '"+plot+"', '"+character+"', '"+acting+"', '"+rating+"')";
            DB.statement.execute(query);
        } catch(SQLException err){
            System.out.println(err);
        }
    }
    
    public void update(String title, double plot, double character, double acting){
        try {
            double rating = (plot+character+acting)/3.0;
            DB.statement = DB.koneksi.createStatement(); 
            String query = "UPDATE `movie` SET `plot` = '"+plot+"', `character` = '"+character+"', `acting` = '"+acting+"', `score` = '" +rating+ "' WHERE `movie`.`title` = '" +title+ "'";
            DB.statement.execute(query);
            
        }  catch(SQLException err){
            System.out.println(err);
        }
    }
    
    public void delete(String title){
        try {
            DB.statement = DB.koneksi.createStatement(); 
            String query = "DELETE FROM `movie` WHERE `movie`.`title` = '"+title+"'";
            DB.statement.execute(query);
            
        } catch(SQLException err){
            System.out.println(err);
        }
    }
}

