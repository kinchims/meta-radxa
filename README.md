A simple yocto layer that provides the AIC8800 driver, and firmware. Tested on linux kernel version 6.14 with a Radxa Zero 3W.

How to use.

1. Run the devcontainer provided (install the Dev Containers extension in vscode), then run the open in container command.
2. Run oe-init-build-env as usual
3. Add aic8800 and linux-firmware-aic880 to your image install.
