import java.util.ArrayList;


public class LifeSimulationExtension {
    public static void main(String[] args) throws InterruptedException {
        // for(String arg : args){
        //     System.out.println(arg);
        // }
        if(args.length < 3){
            System.out.println("Please input 3 arguments: 2 integers for row, and a double for chance.");
            return;
        }
        Landscape scape = new Landscape(200, 200, .25);


        LandscapeDisplay display = new LandscapeDisplay(scape, 8);
        ArrayList<Landscape> list = new ArrayList<Landscape>();
        
        list.add(scape);
        while (true) {
        
            scape.modifiedAdvance();
            display.repaint();
            Thread.sleep(250);
            list.add(scape);
            for (int i= 0; i< list.size(); i++) {
                if (list.get(i)==scape) {
                    break;
                    
                }
            }
        
        }    
        public void addLast(T item) {
            if (this.head == null && this.tail == null) {
                Node newNode = new Node(item);
                this.head = newNode;
                this.tail = newNode;
    
            }
            else {
                Node newNode = new Node(item);
                this.tail.setNext(newNode);
                //this.head.next.next = newNode;
                this.tail = newNode;
            }
            this.size++;
    
        }
        
    }
    
}
