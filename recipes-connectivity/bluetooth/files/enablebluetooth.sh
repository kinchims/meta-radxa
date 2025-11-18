#!/bin/bash

#fix provided by https://dietpi.com/forum/t/radxa-zero-3w-bluetooth-not-working/20555/8
hciattach -s 1500000 /dev/ttyS1 any 1500000 flow nosleep
hciconfig hci0 up