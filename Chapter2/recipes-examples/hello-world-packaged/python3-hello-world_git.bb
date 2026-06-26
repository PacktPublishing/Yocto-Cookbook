# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Simple packaged Python application"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=029df0189ba1cb1abb1c7032e1ffaaf9"

SRC_URI = "git://github.com/mrybczyn/hello-world.git;protocol=https;branch=main"

# Modify these as desired
PV = "1.0.0+git"
SRCREV = "c006de955f5d05a2979e7ad32709795b707e12e3"

inherit python_setuptools_build_meta

