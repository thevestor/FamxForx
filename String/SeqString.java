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

import java.util.Arrays;

/**
 * Title:创建一个字符串数组，实现插入值，以及删除等操作
 * @author FamxForx
 * @create 2020-10-24
 */
public class SeqString implements IString{
	/**
	 * @descrption 自定义数组空间，串的长度
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
				buffer[i]=strValue[i+begin];
			return new SeqString(buffer);
		}
	}
	/**
	 * @descrption 在第offset字符之前插入str
	 */
	public IString insert(int offset,IString str){   
		if(offset<0||offset>curLen)
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
	 * @descrption 将数组的值插入到串中,合并字串
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
	 * @description kmp算法实现字符串匹配
	 * @param pattern
	 * @param next
	 */
	public static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];//创建一个和数组长度一样的部分匹配值表
		int k = -1;
		int j = 0;
		next[0] = -1;
		//检测每一个字符之前的字符串，计算它们前后缀的最大长度，然后把长度记录在当前的next数组位置当中
		while(j < pattern.length() - 1) {
			if(k == -1 || pattern.charAt(k) == pattern.charAt(j) ) {
				++j;
				++k;
				//if主要处理ABCABC这种情况
				if(pattern.charAt(k) == pattern.charAt(j)) {
					next[j] = next[k];
				}else {
					next[j] = k;
				}
			}else {
				k = next[k];//前缀长度需要缩减
			}
			
		}
		return next;
	}
	public static int kmp(String s,String pattern) {
		int i = 0;
		int j = 0;
		int[] next = getNext(pattern);
		System.out.println(Arrays.toString(next));
		while(i < s.length() && j < pattern.length()) {
			//S  ABCER
			//P  CD
			if(j == -1 || s.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}else {
				j = next[j];
			}
			if(j == pattern.length()) {
				return i - j;
			}else {
				return -1;
			}
		}
		return -1;
	}
	//在原始串中，寻找字串pattern，如果找到，返回pattern在str串中首字母的下标值，字串没有找到，返回-1
	private static int find(String s,String pattern) {
		int i = 0;
		int j = 0;
		while(i < s.length() && j < pattern.length()) {
			if(s.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}else {
				i = i - j + 1;
				j = 0;
			}
		}
		if( j == pattern.length()) {
			return i - j;
		}else {
			return -1;
		}
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
		System.out.println("当前串s1与str比较?" + s1.compareTo(s2));
		System.out.println("合并串s2与串s3");
		s3.concat(s2).myprint();
		
		String str = "ABCDABDEYGF";
        String pattern = "ABCDABD";
        //SeqString.kmp(str, pattern);
        System.out.println(SeqString.kmp(str, pattern));

	}


}
