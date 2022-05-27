/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javax.swing.JOptionPane;
import model.ModelMovie;
/**
 *
 * @author Win7
 */
public class controller {
    ModelMovie modelmovie;
   Object[][] modelmovies = new Object[150][4];
   
    private Object[][] movie;
    public controller(ModelMovie modelmovie){
       this.modelmovie = modelmovie;
    }
    
    public Object[][] index(){
       movie = modelmovie.getMovie();
       return movie;
   } 
    
    public void simpan(String title, double plot, double character, double acting){
        boolean found = false;
        for (int i = 0; movie[i][0] != null; i++) {
            if (movie[i][0].toString().equals(title)){
                found = true;
                break;
            }
        }
        if (found){
            JOptionPane.showMessageDialog(null, "Movie is in the Database");
        } else {
            if (plot > 5.0 || character > 5.0 || acting > 5.0){
               JOptionPane.showMessageDialog(null, "Maximal input is 5"); 
            } else if(plot < 0 || character < 0 || acting < 0){
                JOptionPane.showMessageDialog(null, "Minimal input is 0");
            } else {
                modelmovie.insert(title, plot, character, acting);
                JOptionPane.showMessageDialog(null, "Data Movie Succesfully Add");
            }
        }
    }
    
    public void update(String title, double plot, double character, double acting){
        boolean found = false;
        int num = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(title)){
                num = i;
                found = true;
                break;
            }
        }
        
        if (found){
            if(plot > 5.0 || character > 5.0 || acting > 5.0){
               JOptionPane.showMessageDialog(null,"Maximal input is 5"); 
            } else if(plot < 0 || character < 0 || acting < 0){
                JOptionPane.showMessageDialog(null,"Minimal input is 0");
            } else{
                modelmovie.update(movie[num][0].toString(), plot, character, acting);
                JOptionPane.showMessageDialog(null,"Data Movie Updated Succesfully");
            }
        } else {
           JOptionPane.showMessageDialog(null,"Movie Unavailable"); 
        }
    }
    
    public void delete(String title){
        boolean found = false;
        int num = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(title)){
                num = i;
                found = true;
                break;
            }
        }
        
        if (found){
            modelmovie.delete(movie[num][0].toString());
            JOptionPane.showMessageDialog(null,"Data Movie Deleted Succesfully");
        }else{
           JOptionPane.showMessageDialog(null,"Movie Unavailable"); 
        }
    }
}
