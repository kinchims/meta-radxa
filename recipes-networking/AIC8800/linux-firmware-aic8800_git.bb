SUMMARY = "AIC8800 WiFi Firmware"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " \
git://github.com/kinchims/aic8800.git;branch=main;protocol=https \
"
SRCREV = "0eedf32387f0e567406da67efd2511cf1ba87d4f"
DEPENDS += " virtual/libc"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
    install -d ${D}/vendor/etc/firmware
    find ${S}/src/SDIO/driver_fw/fw/* -type f -exec install -m 0644 {} ${D}/vendor/etc/firmware/ \;
}

FILES:${PN} += "/vendor/etc/firmware/*"