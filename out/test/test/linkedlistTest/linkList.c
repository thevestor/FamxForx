#include "linkList.h"
#include<stdlib.h>
//?????????
struct LinkNode * init_LinkList()
{
    struct LinkNode *pHeader = malloc(sizeof(struct LinkNode));
    
    if(pHeader == NULL)
        return NULL;
    //pHeader -> num = -1;//?????????????
    pHeader -> next = NULL;//?????????????? 

    //????��???
    struct LinkNode * pTail = pHeader;

    int val = -1;
    while(1){
        printf("????????? -1?????????????\n");
        scanf("%d",&val);
        if(val == -1)
            break;
        //????????
        struct LinkNode * newNode = malloc(sizeof(struct LinkNode));
        newNode -> num = val;
        newNode -> next = NULL;

        //???????
        pTail -> next = newNode;
        
        //???????��???
        pTail = newNode;
    }

    return pHeader;
}

//
void foreach_LinkList(struct LinkNode * pHeader)
{
    if(pHeader == NULL)
    {
        return;
    }

    //pCurrent 
    struct LinkNode * pCurrent = pCurrent -> next;

    while (pCurrent != NULL)
    {
        printf("%d\n",pCurrent -> num);
        pCurrent = pCurrent -> next;
    }
    
}