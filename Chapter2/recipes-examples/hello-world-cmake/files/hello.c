#include <stdio.h>

#ifndef HELLO_MESSAGE
#define HELLO_MESSAGE "Our default message"
#endif

int main(void)
{
    puts(HELLO_MESSAGE);
    return 0;
}
