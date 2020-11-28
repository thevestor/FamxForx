拿硬币
题目：桌上有n堆力扣币，每堆得数量保存在数组coin中。
我们每次可以选择任意一堆，拿走其中得一枚或者两枚，
求拿完所有力扣币得最少次数。
输入：[4,2,1]
输出：4
解释：第一堆力扣币最少需要拿2次，第二堆最少需要拿1次，第三堆最少需要
拿1次，总共4次即可拿完。
Code:
class Solution{
    public int minCount(int[] coins){
        int c = 0;
        for( int i : coins) c += i%2==0?i / 2:i / 2  + 1;
        return c;
    }
}