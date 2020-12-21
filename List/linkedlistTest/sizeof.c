
#include<stdlib.h>

void calculateArray(int arr[])
{
    prinf("arr的数组长度： %d\n",sizeof(arr));
}

void test03()
{
    int arr[] = {1,2,3,4,5};

    calculateArray(arr);
}

int main(){
    test03();
}