#!/data/data/com.termux/files/usr/bin/bash

OUT="/sdcard/Download/IPPulseScanner_vpn_evidence.log"

rm -f "$OUT"

{
    echo "===================================================="
    echo " IPPulseScanner VERSION 247 VPN EVIDENCE"
    echo " BASE=189bd8c151d66d6083aaca9fe57e4717d57ff45a"
    echo " DATE=$(date)"
    echo "===================================================="
    echo

    echo "================ VPN247 ============================"
    logcat -d -v threadtime -s VPN247:* 2>/dev/null || true

    echo
    echo "================ GamingVpn ========================="
    logcat -d -v threadtime -s GamingVpn:* 2>/dev/null || true

    echo
    echo "================ IMPORTANT SYSTEM =================="
    logcat -d -v threadtime 2>/dev/null |
        grep -Ei \
        'VPN247|GamingVpn|FATAL EXCEPTION|Exception|IOException|SocketException|Timeout|timed out|refused|reset|RST|SYN|ACK|TCP|UDP|DNS|TUN|protect|selector' \
        || true

} > "$OUT"

echo
echo "=============================================="
echo " EVIDENCE READY"
echo "=============================================="
echo "$OUT"
echo "=============================================="
