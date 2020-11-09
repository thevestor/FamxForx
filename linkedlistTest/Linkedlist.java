import sun.awt.image.ImageWatched;

public class Linkedlist {
    public int iData;
    public double dData;
    public Linkedlist next;
    public Linkedlist(int id,double dd){
        iData = id;
        dData = dd;
    }
    public void displayLink(){
        System.out.print("{" + iData + "," + dData + "}");
    }
}

