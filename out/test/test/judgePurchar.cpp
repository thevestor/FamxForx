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
//括号匹配
#define ARRAY_NULL_VALUE '\0'
#define LEFT_SMALL_BRACKET '('
#define RIGHT_SMALL_BRACKET ')'
#define LEFT_CENTRE_BRACKET '['
#define RIGHT_CENTRE_BRACKET ']'
#define LEFT_BIG_BRACKET '{'
#define RIGHT_BIG_BRACKET '}'
//Set ONE
#define WHILE_VALUE_ONE 1
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
    char *base; //栈底指针
    char *top; //栈顶指针
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
char Pop(SqStack &s,int &e);
int StackEmpty(SqStack s);
int StackLength(SqStack s);
int charComparison(char data[]);

/**
 * @brief  实现类main()方法 
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int main(){
    char str[100];
	cout<<"输入匹配判断的符号字符如 {()}[] :";
	cin>>str;
	cout<<str<<endl;
	cout<<"匹配结果:"<<(charComparison(str) ? "输入符号配对":"输入符号不配对")<<endl;
    
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
   
    s.base = (char *)malloc (STACK_INIT_SIZE*sizeof(char));
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
        s.base = (char *)realloc(s.base,(s.stacksize + STACKINCREMENT) * sizeof(char));
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
    char  *p;
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

char Pop(SqStack &s){ 
   if(s.top == s.base){return STACK_ERROR;}
   char var = *(s.top - CHANGE_VALUE);
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
 * @brief  若栈已存在，返回栈的长度
 * @author Dername
 * @param  SqStack s
 * @return size
 * 
 */
int StackLength(SqStack s){
    return s.top - s.base;
}


/**
 * @brief 利用字符栈，从终端接受一行并传送至调用过程的数据区
 * @param s
 * @return 
 */

int charComparison(char data[]){
    SqStack s;
    char *link = data;
    char var;
    int comparisonStats = 1;
    int stats = InitStack(s);
    if(WHILE_VALUE_ZERO != stats){
        while (*link != ARRAY_NULL_VALUE){
            switch (*link){
            case LEFT_SMALL_BRACKET: Push(s, *link ); break;
            case LEFT_CENTRE_BRACKET: Push(s, *link ); break;
            case LEFT_BIG_BRACKET: Push(s, *link ); break;
            case RIGHT_SMALL_BRACKET: 
                var = GetTop(s);
                if(StackEmpty(s) != WHILE_VALUE_ONE && var == LEFT_SMALL_BRACKET){ Pop(s);
                }else{ comparisonStats = 0; break; } 
                break;
            case RIGHT_CENTRE_BRACKET: 
                var = GetTop(s);
                if(StackEmpty(s) != WHILE_VALUE_ONE && var == LEFT_CENTRE_BRACKET){ Pop(s);
                }else{ comparisonStats = 0; break; } 
                break;
            case RIGHT_BIG_BRACKET: 
                var = GetTop(s);
                if(StackEmpty(s) != WHILE_VALUE_ONE && var == LEFT_BIG_BRACKET){ Pop(s);
                }else{ comparisonStats = 0; break; } 
                break;
            default:
                comparisonStats = 0;
                break;
            } 
            link += CHANGE_VALUE;
        }
    }else{ return STACK_ERROR;}
    if(WHILE_VALUE_ONE == comparisonStats && StackEmpty(s)){ return STACK_GET_TRUE; }
    return STACK_ERROR;
}