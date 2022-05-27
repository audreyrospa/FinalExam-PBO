

package finalexam;
import modeldatabase.Connector;
import View.MovieView;
/**
 *
 * @author audrey
 */
public class FinalExam {

    public static void main(String[] args) {
        //TODO code application logic here
        Connector DB = new Connector();
        
        MovieView movieview = new MovieView(DB);
        movieview.setVisible(true);
    }
}
