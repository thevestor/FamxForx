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
int GetTop(SqStack s);
void TraverStack(SqStack s);
int Push(SqStack &s, int e);
int Pop(SqStack &s,int &e);
int StackEmpty(SqStack s);
int StackLength(SqStack s);

/**
 * @brief  实现类main()方法 
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int main(){
    SqStack s;
    int e;
    InitStack(s);
    GetTop(s);
    Push(s,e);
    TraverStack(s);
    Pop(s,e);
    StackEmpty(s);
    StackLength(s);
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
 * @brief  若栈不空，则用e返回s的栈顶元素，并返回true,否则error
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int GetTop(SqStack s){
    
    if(s.top == s.base) return STACK_ERROR;
    int e = *(s.top - 1);
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
 * @brief  若栈部位空，遍历栈的所有元素
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

void TraverStack(SqStack s){
    int *p;
	p = s.base;
	while(p != s.top){
		cout<<*p<<" ";
		p++;
	}
    cout<<endl;
}

/**
 * @brief  若栈不为空，则删除s的栈顶元素，用e返回其值,并返回OK,否则返回error
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int Pop(SqStack &s,int &e){
    
    if(s.top == s.base) return STACK_ERROR;
    e = * -- s.top;
    return STACK_GET_TRUE;
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
 * @brief  若栈已存在，返回栈的长度
 * @author Dername
 * @param  SqStack s
 * @return size
 * 
 */
int StackLength(SqStack s){
    return s.top - s.base;
}