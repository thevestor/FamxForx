左旋转字符串
题目：字符串的左旋转操作是把字符串前面的若干个字符
转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能
。比如：输入字符串“abcdefg”和数字2，该函数将返回左旋转
两位得到的结果"cdefgab"
Code:
class Solution{
    public String reverseLeftWords(String s,int n){
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}

class Solution{
    public String reverseLeftWords(String s,int n){
        StringBuilder res = new StringBuilder();
        for(int i = n;i < s.length;i++){
            res.append(s.charAt(i));
        }
        for(int i = 0;i < n;i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}

class Solution{
    public String reverseLeftWords(String s,int n){
        StringBuilder res = new StringBuilder();
        for(int i = n;i < n + s.length();i++){
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}