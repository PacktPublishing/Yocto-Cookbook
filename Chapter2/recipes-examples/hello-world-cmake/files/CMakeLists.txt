cmake_minimum_required(VERSION 3.5)
project(hello-world-cmake C)

# Option passed from build
set(HELLO_MESSAGE "Default message" CACHE STRING "Message to print")

add_compile_definitions(HELLO_MESSAGE="${HELLO_MESSAGE}")

add_executable(hello-world-cmake hello.c)

install(TARGETS hello-world-cmake DESTINATION bin)
