/**
 * @description 结点类(定义数据结点，指针)
 * @author Dername 
 * @param data
*/
class Link{
  //创建一个数据区域
  public int data;
  //指针区域
  public Link next;
  //构造一个数据为data的结点，默认指针为空  
  public Link(int data){
    this.data = data;
    next = null;
  }
  //显示结点的数据
  public void displayLink()
  {
    System.out.println("Data":+ data);
    
  }

}
/**
 * @description 链表类(带头的空链表)
 * @author Dername
 * @param data
 * @param key
 * @return 
*/
class LinkList{
  
  //头结点
  private Link L;
  //构造一个空链表
  public LinkList()
  {
    L = null;
  }
  
  public void insertLink(int data){
    //构造一个内容为data的结点
    Link newLink = new Link(data);
    //将L中的地址赋予新建的结点指针区域中
    newLink.next = L;
    //让L结点的指针指向newLink 
    L = newLink;
  }

  public boolean isEmpty()
  {
    return L == null;
  }

  public Link reverselist(int key)
  {
    Link current  = L;
    while(current.data != key)
    {
      if(current.next == null) return null;
      else return current.next;
      return current;

    }
  }
}