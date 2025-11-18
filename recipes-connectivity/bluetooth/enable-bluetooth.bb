SUMMARY = "Enable Bluetooth"
DESCRIPTION = "Enable Bluetooth"
HOMEPAGE = ""
SECTION = "misc"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
DEPENDS = " bash"
RDEPENDS:${PN} += " bash"
SERVICE_NAME = "enable-bluetooth.service"
SCRIPT_NAME = "enablebluetooth.sh"
CONFIG_DIR = "/scripts"
SRC_URI += " \ 
file://LICENSE \
file://${SERVICE_NAME} \
file://${SCRIPT_NAME} \
"

inherit systemd
SYSTEMD_SERVICE_${PN} = "${SERVICE_NAME}"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "${SERVICE_NAME}"

do_install:append() {
    install -d ${D}${CONFIG_DIR}
    install -d ${D}${systemd_system_unitdir}

    install -m 0777 "${WORKDIR}/${SCRIPT_NAME}" ${D}${CONFIG_DIR}
    install -m 0644 ${WORKDIR}/${SERVICE_NAME} ${D}${systemd_system_unitdir}
}

FILES:${PN} += "${systemd_system_unitdir}/${SERVICE_NAME}"
FILES:${PN} += "${CONFIG_DIR}/${SCRIPT_NAME}"
