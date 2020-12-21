#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include<stdlib.h>
#include<stdio.h>
#include<string.h>


//结点声明
struct LinkNode{
  int num;
  struct LinkNode * next;
};

//初始化链表
struct LinkNode * init_LinkList();

//遍历链表
void foreach_LinkList(struct LinkNode * pHeader);