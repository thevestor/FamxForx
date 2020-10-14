/**
 * @description �����(�������ݽ�㣬ָ��)
 * @author Dername 
 * @param data
*/
class Link{
  //����һ����������
  public int data;
  //ָ������
  public Link next;
  //����һ������Ϊdata�Ľ�㣬Ĭ��ָ��Ϊ��  
  public Link(int data){
    this.data = data;
    next = null;
  }
  //��ʾ��������
  public void displayLink()
  {
    System.out.println("Data":+ data);
    
  }

}
/**
 * @description ������(��ͷ�Ŀ�����)
 * @author Dername
 * @param data
 * @param key
 * @return 
*/
class LinkList{
  
  //ͷ���
  private Link L;
  //����һ��������
  public LinkList()
  {
    L = null;
  }
  
  public void insertLink(int data){
    //����һ������Ϊdata�Ľ��
    Link newLink = new Link(data);
    //��L�еĵ�ַ�����½��Ľ��ָ��������
    newLink.next = L;
    //��L����ָ��ָ��newLink 
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