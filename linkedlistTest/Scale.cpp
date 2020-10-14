/**
 * @Title 顺序栈ListStack的实现 
 * @author Dername
 * @version 2020.09
 * 
 */
#include <iostream>
#include <stdlib.h>

/**
 * @brief 给栈分配基本容量，并不限定栈的最大容量 
 * @author Dername
 * @param
 * @return 
 * 
 */
//Set maxSize
#define STACK_INIT_SIZE 100
//Set sizeLength
#define STACKINCREMENT 10
//Def ERROR 
#define STACK_ERROR 0
//OVERFLOW
#define STACK_OVERFLOW 1
//Def TRUE
#define STACK_GET_TRUE 1
//Def VALUE
#define CHANGE_VALUE 1
//Set ZERO
#define WHILE_VALUE_ZERO 0

/**
 * @brief  定义结构体，指针 
 * @author Dername
 * @param  int base
 * @param  int top
 * @return 
 * 
 */

using namespace std;
typedef struct {
    int *base; //栈底指针
    int *top; //栈顶指针
    int  stacksize; //当前已分配的存储空间，以元素为单位
}SqStack;

/**
 * @brief  声明方法，类 
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int InitStack(SqStack &s);
int Push(SqStack &s, int e);
int Pop(SqStack &s);
int StackEmpty(SqStack s);
int conversion(int data, int N);
/**
 * @brief  实现类main()方法 
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int main(){
    conversion(1348,8);
   
    return STACK_ERROR;
}

/**
 * @brief  构造一个空栈s
 * @author Dername
 * @param  SqStack s
 * @return STACK_GET_TRUE
 * 
 */

int InitStack(SqStack &s){
   
    s.base = (int *)malloc (STACK_INIT_SIZE*sizeof(int));
    if(!s.base) exit(STACK_OVERFLOW);//存储分配失败
    s.top = s.base;
    s.stacksize = STACK_INIT_SIZE;
    return STACK_GET_TRUE;
}



/**
 * @brief  插入元素e为新的栈顶元素
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int Push(SqStack &s,int e){
    
    if(s.top - s.base >= s.stacksize){//栈满，则追加存储空间
        s.base = (int *)realloc(s.base,(s.stacksize + STACKINCREMENT) * sizeof(int));
        if(!s.base) exit(STACK_OVERFLOW);//存储分配失败
        s.top = s.base + s.stacksize;
        s.stacksize  += STACKINCREMENT;   
    }
    *s.top++ =e;
    return STACK_GET_TRUE;
}


/**
 * @brief  若栈不为空，则删除s的栈顶元素，用e返回其值,并返回OK,否则返回error
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int Pop(SqStack &s){
    
   if(s.top == s.base){return STACK_ERROR;}
    int var = *(s.top - CHANGE_VALUE);
    s.top -= CHANGE_VALUE;
    return var;	
}

/**
 * @brief  判断栈是否为空，为空则返回true,否则false
 * @author Dername
 * @param  SqStack s
 * @return STACK_GET_TRUE
 * 
 */

int StackEmpty(SqStack s){
    if(s.base == s.top) return STACK_GET_TRUE;
    else return STACK_ERROR;  
}

/**
 * @brief 进制转换
 * @param data 需要转换的十进制数
 * @param N 需要转换的进制为
 * @return int 1->成功；0->失败
*/

int conversion(int data, int N){
    int var = data;
    SqStack s;
    int stats = InitStack(s);
    if(WHILE_VALUE_ZERO != stats){
        while (var != WHILE_VALUE_ZERO){
            Push(s, var % N);
            var /= N;
        }
    }else{ return STACK_ERROR;}

    while (!StackEmpty(s)){
        cout<<Pop(s);
    }
    cout<<endl;    
}
