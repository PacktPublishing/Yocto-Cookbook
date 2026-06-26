SUMMARY = "Hello world with configurable message via CMake"
DESCRIPTION = "Demonstrates passing configuration from a Yocto Project recipe to CMake"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello.c \
           file://CMakeLists.txt"

S = "${UNPACKDIR}"

inherit cmake

# Recipe-level configuration variable
HELLO_MESSAGE ?= "Hello from YP recipe!"

# Pass variable to CMake
EXTRA_OECMAKE += "-DHELLO_MESSAGE='${HELLO_MESSAGE}'"
