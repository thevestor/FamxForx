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
*  Title:  串的抽象数据类型使用java接口描述                                                            
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package String;

/**
 * Title: 串的抽象数据类型使用java接口描述
 * @author FamxForx 
 * @create 2020-10 
 */
public interface IString {
	public void clear();
	public boolean isEmpty();
	public int length();
	public char charAt(int index);   //取字符操作
	public IString substring(int begin,int end);   //截取字符操作
	public IString insert(int offset,IString str);  //插入操作
	public IString delete(int begin,int end);   //删除操作
	public IString concat(IString str);   //连接操作
	public int  compareTo(IString str);
	public void myprint();  //输出操作


}

