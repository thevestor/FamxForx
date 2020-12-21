public class linkList{
    private Linkedlist first;
    public linkList()
    {
        first = null;
    }
    public void insertFirst(int id,double dd)
    {
        Linkedlist newLink = new Linkedlist(id,dd);
        newLink.next = first;
        first = newLink;
    }
    public Linkedlist find(int key)
    {
        Linkedlist current = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }
    public Linkedlist delete(int key)
    {
        Linkedlist current = first;
        Linkedlist previous = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;
            else
            {
                previous = current;
                current = current.next;
            }

        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }
    public void displayList()
    {
        System.out.println("List (first --> last):");
        Linkedlist current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    public static void main(String[] args){
        linkList theList = new linkList();

        theList.insertFirst(22,2.99);
        theList.insertFirst(44,4.99);
        theList.insertFirst(66,6.99);
        theList.insertFirst(88,8.99);

        theList.displayList();
        Linkedlist f = theList.find(44);
        if(f != null)
            System.out.println("Found link with key" + f.iData);
        else
            System.out.println("Can not find link");
        Linkedlist d = theList.delete(66);
        if(d != null)
            System.out.println("Delete link with key" + d.iData);
        else
            System.out.println("Can not delete link");
        theList.displayList();
    }
}