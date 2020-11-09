#include<stdlib.h>
#include "linkList.h"


void test01(){
  
  struct LinkNode * pHeader = init_LinkList();

  
  
  printf("\n");
  foreach_LinkList(pHeader);

}


int  main(void){
  
  test01();
    
  system("pause");
  return EXIT_SUCCESS;

}
