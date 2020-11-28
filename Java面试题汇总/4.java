猜数字
题目：小A和小B在玩猜数字。小B每次从1，2，3中随机选择一个，小A每次也从1，2，3中选择一个猜。
他们一共进行三次这个游戏，请返回小A才对了几次？
Code:
class Solution{
    public int game(int[] guess,int[] answer){
        int count;
        for(int i = 0;i < guess.length();i++){
            if(guess[i] == answer[i]){
                count++;
            }
        }
        return count;
    }
}