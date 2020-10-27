/*********************************************************************************************************
*  Copyright (c) 2020 FamxForx. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <s1074862962@gmail.com> or <s1074862962@163.com>                                                 
*                                                                                                        
*  FileName:  IString                                                                         
*  Author:  FamxForx                                                                                     
*  Version:  2.2                                                                                         
*  Date:  2020                                                                                     
*  Title:  ���ĳ�����������ʹ��java�ӿ�����                                                            
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package String;

/**
 * Title: ���ĳ�����������ʹ��java�ӿ�����
 * @author FamxForx 
 * @create 2020-10 
 */
public interface IString {
	public void clear();
	public boolean isEmpty();
	public int length();
	public char charAt(int index);   //ȡ�ַ�����
	public IString substring(int begin,int end);   //��ȡ�ַ�����
	public IString insert(int offset,IString str);  //�������
	public IString delete(int begin,int end);   //ɾ������
	public IString concat(IString str);   //���Ӳ���
	public int  compareTo(IString str);
	public void myprint();  //�������


}

