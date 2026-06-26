SUMMARY = "Simple Python app fetched from GitHub"
DESCRIPTION = "Downloads a Python script from GitHub and installs it"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
HOMEPAGE = "https://github.com/mrybczyn/hello-world"

# GitHub fetch link
SRC_URI = "git://github.com/mrybczyn/hello-world.git;branch=main;protocol=https"

# Pin exact revision for reproductibility and security
SRCREV = "c006de955f5d05a2979e7ad32709795b707e12e3"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core"
