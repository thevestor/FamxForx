/**
 * @Title ˳��ջListStack��ʵ�� 
 * @author Dername
 * @version 2020.09
 * 
 */
#include <iostream>
#include <stdlib.h>

/**
 * @brief ��ջ������������������޶�ջ��������� 
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
//����ƥ��
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
 * @brief  ����ṹ�壬ָ�� 
 * @author Dername
 * @param  int base
 * @param  int top
 * @return 
 * 
 */

using namespace std;
typedef struct {
    char *base; //ջ��ָ��
    char *top; //ջ��ָ��
    int  stacksize; //��ǰ�ѷ���Ĵ洢�ռ䣬��Ԫ��Ϊ��λ
}SqStack;

/**
 * @brief  ������������ 
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
 * @brief  ʵ����main()���� 
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int main(){
    char str[100];
	cout<<"����ƥ���жϵķ����ַ��� {()}[] :";
	cin>>str;
	cout<<str<<endl;
	cout<<"ƥ����:"<<(charComparison(str) ? "����������":"������Ų����")<<endl;
    
    return STACK_ERROR;
}

/**
 * @brief  ����һ����ջs
 * @author Dername
 * @param  SqStack s
 * @return STACK_GET_TRUE
 * 
 */

int InitStack(SqStack &s){
   
    s.base = (char *)malloc (STACK_INIT_SIZE*sizeof(char));
    if(!s.base) exit(STACK_OVERFLOW);//�洢����ʧ��
    s.top = s.base;
    s.stacksize = STACK_INIT_SIZE;
    return STACK_GET_TRUE;
}

/**
 * @brief  ��ջ���գ�����e����s��ջ��Ԫ�أ�������true,����error
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
 * @brief  ����Ԫ��eΪ�µ�ջ��Ԫ��
 * @author Dername
 * @param  SqStack s
 * @param  int e
 * @return STACK_GET_TRUE
 * 
 */

int Push(SqStack &s,int e){
    
    if(s.top - s.base >= s.stacksize){//ջ������׷�Ӵ洢�ռ�
        s.base = (char *)realloc(s.base,(s.stacksize + STACKINCREMENT) * sizeof(char));
        if(!s.base) exit(STACK_OVERFLOW);//�洢����ʧ��
        s.top = s.base + s.stacksize;
        s.stacksize  += STACKINCREMENT;   
    }
    *s.top++ =e;
    return STACK_GET_TRUE;
}

/**
 * @brief  ��ջ��λ�գ�����ջ������Ԫ��
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
 * @brief  ��ջ��Ϊ�գ���ɾ��s��ջ��Ԫ�أ���e������ֵ,������OK,���򷵻�error
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
 * @brief  �ж�ջ�Ƿ�Ϊ�գ�Ϊ���򷵻�true,����false
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
 * @brief  ��ջ�Ѵ��ڣ�����ջ�ĳ���
 * @author Dername
 * @param  SqStack s
 * @return size
 * 
 */
int StackLength(SqStack s){
    return s.top - s.base;
}


/**
 * @brief �����ַ�ջ�����ն˽���һ�в����������ù��̵�������
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