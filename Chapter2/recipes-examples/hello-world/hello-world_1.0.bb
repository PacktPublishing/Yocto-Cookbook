SUMMARY = "Simple Python hello world application"
DESCRIPTION = "A minimal Python application example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RECIPE_MAINTAINER:pn-hello-world = "Marta Rybczynska <rybczynska@gmail.com>"

SRC_URI = "file://hello-world.py"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/hello-world.py ${D}${bindir}/hello-world
}

RDEPENDS:${PN} += "python3-core"
