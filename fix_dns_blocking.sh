#!/usr/bin/env bash
set -e
cd "$HOME/IPPulseScanner" || { echo "not found"; exit 1; }
F="app/src/main/java/com/ippulse/scanner/GamingVpnService.java"
cp "$F" "$F.bak"
python3 - << 'PYEOF'
path = "app/src/main/java/com/ippulse/scanner/GamingVpnService.java"
c = open(path, encoding="utf-8").read()
old = "                dnsResponse = forwardDns(dnsQuery);"
new = "                udpExecutor.execute(() -> { byte[] r = forwardDns(dnsQuery); if (r != null) { try { out.write(buildUdpPacket(VPN_ADDRESS, 53, srcAddr, srcPort, r)); out.flush(); } catch (Exception ex) {} } }); return;"
n = c.count(old)
if n != 1:
    print(f"MISMATCH: found {n}, expected 1. Nothing written.")
else:
    open(path, "w", encoding="utf-8").write(c.replace(old, new))
    print("Patched OK.")
PYEOF
echo "---"
grep -n "udpExecutor.execute" "$F"
