#include<stdio.h>
#include<stdlib.h>
/*struct Person{
    char name[64];
    int  age;
};
typedef struct Person myPerson;*/

//主要用途 给类型起别名
//语法 typedef 原名 别名
typedef struct Person
{
    char name[64];
    int age;
}myPerson;

void test02()
{
    //char *p1,p2;
    typedef char * PCHAR;
    PCHAR p1,p2;
}

void test01()
{
    struct Person p1 = {"张三",19};
    myPerson p2 = {"李四",20};
}


int main1(){

    system("pause");
    return EXIT_SUCCESS;
}