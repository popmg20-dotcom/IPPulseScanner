#!/usr/bin/env bash
set -e
PROJECT_DIR="$HOME/IPPulseScanner"
cd "$PROJECT_DIR" || { echo "ERROR: $PROJECT_DIR not found."; exit 1; }
MAIN="app/src/main/java/com/ippulse/scanner/MainActivity.java"
VPNSVC="app/src/main/java/com/ippulse/scanner/GamingVpnService.java"
for f in "$MAIN" "$VPNSVC"; do
  if [ ! -f "$f" ]; then
    echo "ERROR: $f not found relative to $PROJECT_DIR"
    exit 1
  fi
done
cp "$MAIN" "$MAIN.bak"
cp "$VPNSVC" "$VPNSVC.bak"
echo "Backed up both files (.bak)"
command -v python3 >/dev/null 2>&1 || pkg install -y python
python3 - << 'PYEOF'
import sys
path = "app/src/main/java/com/ippulse/scanner/MainActivity.java"
with open(path, "r", encoding="utf-8") as f:
    content = f.read()
patches = []
old1 = '''    private Button btnStartVpn, btnStopVpn, btnApplyIp;
    private TextView vpnStatus;'''
new1 = '''    private Button btnStartVpn, btnStopVpn, btnApplyIp;
    private TextView vpnStatus;
    private EditText vpnDns, vpnHosts, vpnMasterIp, vpnMtu;'''
patches.append(("field declarations", old1, new1, 1))
old2 = '        vpnMasterIp = findViewById(R.id.vpnMasterIp);'
new2 = '''        vpnMasterIp = findViewById(R.id.vpnMasterIp);
        vpnMtu = findViewById(R.id.vpnMtu);'''
patches.append(("findViewById wiring", old2, new2, 1))
old3 = '''    private void loadVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        vpnDns.setText(prefs.getString("dns", "8.8.8.8"));
        vpnHosts.setText(prefs.getString("hosts", ""));
        if (vpnHosts.getText().toString().trim().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String domain : defaultDomains) {
                sb.append(domain).append("\\n");
            }
            vpnHosts.setText(sb.toString().trim());
        }
    }'''
new3 = '''    private void loadVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        vpnDns.setText(prefs.getString("dns", "8.8.8.8"));
        vpnMtu.setText(prefs.getString("mtu", "1400"));
        vpnMasterIp.setText(prefs.getString("masterIp", "109.61.42.251"));
        vpnHosts.setText(prefs.getString("hosts", ""));
        if (vpnHosts.getText().toString().trim().isEmpty()) {
            String defaultIp = vpnMasterIp.getText().toString().trim();
            StringBuilder sb = new StringBuilder();
            for (String domain : defaultDomains) {
                sb.append(defaultIp).append(" ").append(domain).append("\\n");
            }
            vpnHosts.setText(sb.toString().trim());
        }
    }'''
patches.append(("loadVpnSettings defaults", old3, new3, 1))
old4 = '''    private void saveVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        prefs.edit()
            .putString("dns", vpnDns.getText().toString().trim())
            .putString("hosts", vpnHosts.getText().toString().trim())
            .apply();
    }'''
new4 = '''    private void saveVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        prefs.edit()
            .putString("dns", vpnDns.getText().toString().trim())
            .putString("hosts", vpnHosts.getText().toString().trim())
            .putString("mtu", vpnMtu.getText().toString().trim())
            .putString("masterIp", vpnMasterIp.getText().toString().trim())
            .apply();
    }'''
patches.append(("saveVpnSettings persistence", old4, new4, 1))
old5 = '''            int mtu = 1400;
        GamingVpnService.start(this, dns, mtu, hostsMap);'''
new5 = '''            int mtu = parseIntSafe(vpnMtu.getText().toString().trim(), 1400);
        GamingVpnService.start(this, dns, mtu, hostsMap);'''
patches.append(("hardcoded MTU (both call sites)", old5, new5, 2))
ok = True
for name, old, new, expected in patches:
    count = content.count(old)
    if count != expected:
        print(f"MISMATCH [{name}]: expected {expected}, found {count}")
        ok = False
if not ok:
    print("\nAborting MainActivity.java - NOTHING was written. Paste this output back.")
    sys.exit(1)
for name, old, new, expected in patches:
    content = content.replace(old, new)
with open(path, "w", encoding="utf-8") as f:
    f.write(content)
print("MainActivity.java: all 5 patches applied.")
path2 = "app/src/main/java/com/ippulse/scanner/GamingVpnService.java"
with open(path2, "r", encoding="utf-8") as f:
    content2 = f.read()
count = content2.count("getFilesDir()")
if count == 0:
    print("GamingVpnService.java: no getFilesDir() found (already patched?) - skipping.")
else:
    content2 = content2.replace("getFilesDir()", "getExternalFilesDir(null)")
    with open(path2, "w", encoding="utf-8") as f:
        f.write(content2)
    print(f"GamingVpnService.java: replaced {count} occurrence(s) of getFilesDir().")
PYEOF
STATUS=$?
if [ $STATUS -ne 0 ]; then
  echo ""
  echo "Patch failed - restoring backups."
  cp "$MAIN.bak" "$MAIN"
  cp "$VPNSVC.bak" "$VPNSVC"
  exit 1
fi
echo ""
echo "=== Verification ==="
grep -n "vpnMtu\|parseIntSafe(vpnMtu" "$MAIN"
echo "---"
grep -n "getExternalFilesDir" "$VPNSVC"
echo ""
echo "Done. Review with: git diff $MAIN $VPNSVC"
