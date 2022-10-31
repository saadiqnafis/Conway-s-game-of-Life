
import java.util.ArrayList;


public class LifeSimulation {

    

    public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(200, 200, 0.5);


        LandscapeDisplay display = new LandscapeDisplay(scape, 8);
        ArrayList<Landscape> list = new ArrayList<Landscape>();
        
        list.add(scape);
        
        while (true) {
            scape.advance();
            display.repaint();
            Thread.sleep(250);
            list.add(scape);
        
            for (int r= 0; r < list.size(); r++) {
                if (list.get(r) == scape) {
                    break;
                    
                }
            }
            
        }    
        
    }
    
}
