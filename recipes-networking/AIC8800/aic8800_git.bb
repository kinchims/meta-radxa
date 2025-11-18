SUMMARY = "AIC8800 WiFi Driver"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " \
git://github.com/kinchims/aic8800.git;branch=main;protocol=https \
"
SRCREV = "0eedf32387f0e567406da67efd2511cf1ba87d4f"
DEPENDS += " virtual/libc"
inherit module 

S = "${WORKDIR}/git"

EXTRA_OEMAKE:append = " \
KVER='${KERNEL_VERSION}' \
MODDESTDIR='${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/net/wireless' \
"

RPROVIDES:${PN} += "kernel-module-aic8800"