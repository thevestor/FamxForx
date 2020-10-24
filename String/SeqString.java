/*********************************************************************************************************
*  Copyright (c) 2020 FamxForx. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <s1074862962@gmail.com> or <s1074862962@163.com>                                                 
*                                                                                                        
*  FileName:  SeqString                                                                         
*  Author:  FamxForx                                                                                     
*  Version:  2.2                                                                                         
*  Date:  2020                                                                                     
*  Title: 创建一个字符串数组，实现插入值，以及删除等操作                                                             
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package String;
/**
 * Title:创建一个字符串数组，实现插入值，以及删除等操作
 * @author FamxForx
 * @create 2020-10-24
 */
public class SeqString implements IString{
	/**
	 * @descrption 自定义数组空间，以及串的长度
	 * @param curLen
	 * 
	 */
	private char[] strValue;   //字符数组存放串值
	private int curLen;         //当前串的长度
	/**
	 * @descrption 构造空串
	 * @param curLen , char[]
	 */
	public SeqString(){         
		strValue=new char[0];
		curLen=0;
	}
	/**
	 * @description 以字符串常量构造串对象
	 * @param str
	 */
	public SeqString(String str){  
		strValue=str.toCharArray();
		curLen=strValue.length;
	}
	/**
	 * @description 以字符数组构造串对象
	 * @param value
	 */
	public SeqString(char[] value){  
		strValue=new char[value.length];
		for(int i=0;i<value.length;i++){
			strValue[i]=value[i];
		}
		curLen=value.length;
	}
	/**
	 * @descrption 将一个已经存在的字符串置成空串
	 */
	public void clear(){ 
		 curLen=0;
	}
	/**
	 * @descrption 判断字符串是否为空
	 */
	public boolean isEmpty(){   
		return curLen==0;
	}
	/**
	 * @descrption 返回字符串长度
	 */
	public int length(){   
		return curLen;
	}
	/**
	 * @descrption 返回字符串中序号为index的字符
	 * 
	 */
	public char charAt(int index){   
		if(index<0||index>=curLen){
			throw new StringIndexOutOfBoundsException(index);
		}
		return strValue[index];
	}
	/**
	 * @descrption 扩充字符串存储空间容量，参数指定容量
	 * @param newcapacity
	 */
	public void allocate(int newcapacity){   
        char[]temp=strValue;
		strValue=new char[newcapacity];
		for(int i=0;i<temp.length;i++)
			strValue[i]=temp[i];
	}
	/**
	 * @descrption 截取从begin到end-1的子串并返回
	 */
	public IString substring(int begin,int end){   
		if(begin<0)
			throw new StringIndexOutOfBoundsException("起始位置不能小于0");
		if(end>curLen)
			throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度");
		if(begin>end)
			throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
		if(begin==0&&end==curLen)
			return this;
		else{
			char[]buffer=new char[end-begin];
			for(int i=0;i<buffer.length;i++)
				buffer[i]=this.strValue[i+begin];
			return new SeqString(buffer);
		}
	}
	/**
	 * @descrption 在第offset字符之前插入str
	 */
	public IString insert(int offset,IString str){   
		if(offset<0||offset>this.curLen)
			throw new StringIndexOutOfBoundsException("插入位置不合法");
		int len=str.length();
		int newcount=len+curLen;
		if(newcount>strValue.length){
			allocate(newcount);
		}
		for(int i=curLen-1;i>=offset;i--){
			strValue[len+i]=strValue[i];
		}
		for(int i=0;i<len;i++)
			strValue[i+offset]=str.charAt(i);
		curLen=newcount;
		return this;
	}
	/**
	 * @descrption 删除从begin从end-1为止的字串
	 */
	public SeqString delete(int begin,int end){   
		for(int i=0;i<curLen-end;i++)
			strValue[begin+i]=strValue[end+i];
		    curLen=curLen-(end-begin);
		return this;
	}
	/**
	 * @descrption 将当前串与str比较
	 */
	public int compareTo(IString str){  
		int len1=curLen;
		int len2=str.length();
		int n=Math.min(len1, len2);
		char[]s1=strValue;
		char[] s2=new char[str.length()];
		for(int i=0;i<str.length();i++)
	    s2[i]=str.charAt(i);
		int k=0;
		while(k<n){
			char ch1=s1[k];
			char ch2=s2[k];
			if(ch1!=ch2){
				return ch1-ch2;
			}
			k++;
		}
		return len1-len2;
	}
	/**
	 * @descrption 将数组的值插入到串中
	 */
	public IString concat(IString str){
		return insert(curLen,str);
	}
	/**
	 * @descrption 打印输出串的值
	 */
	public void myprint(){
		for(int i=0;i<curLen;i++){
			System.out.print(strValue[i]);
		}
		System.out.println();
	}
	/**
	 * @descrption 测试类
	 * @param args
	 */
	public static void main(String[] args){
		//构造空串
		SeqString s1=new SeqString();  
		//构造以字符串常量构造串对象
		SeqString s2=new SeqString("hello");  
		char[] charArray={'w','o','r','l','d'};
		//构造以字符数组构造串对象
		SeqString s3=new SeqString(charArray); 
		System.out.print("串s1=");
		s1.myprint();
		System.out.print("串s2=");
		s2.myprint();
		System.out.print("串s3=");
		s3.myprint();
		System.out.println("串s1在第0个字符前插入s2后s1=");
		s1.insert(0, s2).myprint();
		System.out.println("串s1删除第1到第2个字符后：");
		s1.delete(1, 3).myprint();
		System.out.println("截取s3的第1到第2个字符");
		s3.substring(1, 3).myprint();
		
	}


}
