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
*  Title: ����һ���ַ������飬ʵ�ֲ���ֵ���Լ�ɾ���Ȳ���                                                             
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package String;

import java.util.Arrays;

/**
 * Title:����һ���ַ������飬ʵ�ֲ���ֵ���Լ�ɾ���Ȳ���
 * @author FamxForx
 * @create 2020-10-24
 */
public class SeqString implements IString{
	/**
	 * @descrption �Զ�������ռ䣬���ĳ���
	 * @param curLen
	 * 
	 */
	
	private char[] strValue;   //�ַ������Ŵ�ֵ
	private int curLen;         //��ǰ���ĳ���
	/**
	 * @descrption ����մ�
	 * @param curLen , char[]
	 */
	public SeqString(){         
		strValue=new char[0];
		curLen=0;
	}
	/**
	 * @description ���ַ����������촮����
	 * @param str
	 */
	public SeqString(String str){  
		strValue=str.toCharArray();
		curLen=strValue.length;
	}
	/**
	 * @description ���ַ����鹹�촮����
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
	 * @descrption ��һ���Ѿ����ڵ��ַ����óɿմ�
	 */
	public void clear(){ 
		 curLen=0;
	}
	/**
	 * @descrption �ж��ַ����Ƿ�Ϊ��
	 */
	public boolean isEmpty(){   
		return curLen==0;
	}
	/**
	 * @descrption �����ַ�������
	 */
	public int length(){   
		return curLen;
	}
	/**
	 * @descrption �����ַ��������Ϊindex���ַ�
	 * 
	 */
	public char charAt(int index){   
		if(index<0||index>=curLen){
			throw new StringIndexOutOfBoundsException(index);
		}
		return strValue[index];
	}
	/**
	 * @descrption �����ַ����洢�ռ�����������ָ������
	 * @param newcapacity
	 */
	public void allocate(int newcapacity){   
       char[]temp=strValue;
		strValue=new char[newcapacity];
		for(int i=0;i<temp.length;i++)
			strValue[i]=temp[i];
	}
	/**
	 * @descrption ��ȡ��begin��end-1���Ӵ�������
	 */
	public IString substring(int begin,int end){   
		if(begin<0)
			throw new StringIndexOutOfBoundsException("��ʼλ�ò���С��0");
		if(end>curLen)
			throw new StringIndexOutOfBoundsException("����λ�ò��ܴ��ڴ��ĵ�ǰ����");
		if(begin>end)
			throw new StringIndexOutOfBoundsException("��ʼλ�ò��ܴ��ڽ���λ��");
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
	 * @descrption �ڵ�offset�ַ�֮ǰ����str
	 */
	public IString insert(int offset,IString str){   
		if(offset<0||offset>curLen)
			throw new StringIndexOutOfBoundsException("����λ�ò��Ϸ�");
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
	 * @descrption ɾ����begin��end-1Ϊֹ���ִ�
	 */
	
	public SeqString delete(int begin,int end){   
		for(int i=0;i<curLen-end;i++)
			strValue[begin+i]=strValue[end+i];
		    curLen=curLen-(end-begin);
		return this;
	}
	/**
	 * @descrption ����ǰ����str�Ƚ�
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
	 * @descrption �������ֵ���뵽����,�ϲ��ִ�
	 */
	public IString concat(IString str){
		return insert(curLen,str);
	}
	/**
	 * @descrption ��ӡ�������ֵ
	 */
	public void myprint(){
		for(int i=0;i<curLen;i++){
			System.out.print(strValue[i]);
		}
		System.out.println();
	}
	/**
	 * @description kmp�㷨ʵ���ַ���ƥ��
	 * @param pattern
	 * @param next
	 */
	public static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];//����һ�������鳤��һ���Ĳ���ƥ��ֵ��
		int k = -1;
		int j = 0;
		next[0] = -1;
		//���ÿһ���ַ�֮ǰ���ַ�������������ǰ��׺����󳤶ȣ�Ȼ��ѳ��ȼ�¼�ڵ�ǰ��next����λ�õ���
		while(j < pattern.length() - 1) {
			if(k == -1 || pattern.charAt(k) == pattern.charAt(j) ) {
				++j;
				++k;
				//if��Ҫ����ABCABC�������
				if(pattern.charAt(k) == pattern.charAt(j)) {
					next[j] = next[k];
				}else {
					next[j] = k;
				}
			}else {
				k = next[k];//ǰ׺������Ҫ����
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
	//��ԭʼ���У�Ѱ���ִ�pattern������ҵ�������pattern��str��������ĸ���±�ֵ���ִ�û���ҵ�������-1
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
	 * @descrption ������
	 * @param args
	 */
	public static void main(String[] args){
		//����մ�
		SeqString s1=new SeqString();  
		//�������ַ����������촮����
		SeqString s2=new SeqString("hello");  
		char[] charArray={'w','o','r','l','d'};
		//�������ַ����鹹�촮����
		SeqString s3=new SeqString(charArray); 
		System.out.print("��s1=");
		s1.myprint();
		System.out.print("��s2=");
		s2.myprint();
		System.out.print("��s3=");
		s3.myprint();
		System.out.println("��s1�ڵ�0���ַ�ǰ����s2��s1=");
		s1.insert(0, s2).myprint();
		System.out.println("��s1ɾ����1����2���ַ���");
		s1.delete(1, 3).myprint();
		System.out.println("��ȡs3�ĵ�1����2���ַ�");
		s3.substring(1, 3).myprint();
		System.out.println("��ǰ��s1��str�Ƚ�?" + s1.compareTo(s2));
		System.out.println("�ϲ���s2�봮s3");
		s3.concat(s2).myprint();
		
		String str = "ABCDABDEYGF";
        String pattern = "ABCDABD";
        //SeqString.kmp(str, pattern);
        System.out.println(SeqString.kmp(str, pattern));

	}


}
