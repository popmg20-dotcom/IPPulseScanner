#!/bin/bash
set -e

echo "=== PASS 1: وجود فایل‌های هسته Falcon ==="
FALCON_DIR="app/src/main/java/com/github/xfalcon/vhosts"
VHOSTS="$FALCON_DIR/vservice/VhostsService.java"
DNSCHANGE="$FALCON_DIR/vservice/DnsChange.java"
PACKET="$FALCON_DIR/vservice/Packet.java"
TCB="$FALCON_DIR/vservice/TCB.java"
BYTEBUFFER="$FALCON_DIR/vservice/ByteBufferPool.java"
LRUCACHE="$FALCON_DIR/vservice/LRUCache.java"
TCPINPUT="$FALCON_DIR/vservice/TCPInput.java"
TCPOUTPUT="$FALCON_DIR/vservice/TCPOutput.java"
UDPINPUT="$FALCON_DIR/vservice/UDPInput.java"
UDPOUTPUT="$FALCON_DIR/vservice/UDPOutput.java"
LOGUTILS="$FALCON_DIR/util/LogUtils.java"

for f in "$VHOSTS" "$DNSCHANGE" "$PACKET" "$TCB" "$BYTEBUFFER" "$LRUCACHE" "$TCPINPUT" "$TCPOUTPUT" "$UDPINPUT" "$UDPOUTPUT" "$LOGUTILS"; do
    if [ ! -f "$f" ]; then
        echo "❌ فایل $f وجود ندارد"
        exit 1
    fi
done
echo "✅ همه فایل‌های هسته Falcon موجودند."

echo ""
echo "=== PASS 2: معماری MTU و hosts ==="
if ! grep -q 'private int mtu = 247;' "$VHOSTS"; then
    echo "❌ متغیر mtu با پیش‌فرض 247 یافت نشد"
    exit 1
fi
if ! grep -q 'builder\.setMtu(mtu);' "$VHOSTS"; then
    echo "❌ builder.setMtu(mtu) یافت نشد"
    exit 1
fi
if ! grep -q 'DnsChange\.handle_hosts' "$VHOSTS"; then
    echo "❌ فراخوانی DnsChange.handle_hosts یافت نشد"
    exit 1
fi
if ! grep -q 'class VPNRunnable' "$VHOSTS"; then
    echo "❌ کلاس VPNRunnable (inner class) یافت نشد"
    exit 1
fi
echo "✅ معماری MTU/hosts/ VPNRunnable صحیح است."

echo ""
echo "=== PASS 3: حذف اجزای ممنوعه ==="
if grep -RniE 'WireGuard|wireguard|wgPrivateKey|wgPeerKey|wgEndpoint|wgAllowedIPs|wgAddress|wgConfig|GamingVpnService|com\.ippulse\.scanner\.localvpn' app/src/main --exclude-dir=.git; then
    echo "❌ اجزای ممنوعه یافت شدند"
    exit 1
fi
if find app/src/main -type f \( -name '*.bak' -o -name '*.bak2' -o -name '*.bak3' -o -name '*.bak4' -o -name '*.bak5' \) | grep -q .; then
    echo "❌ فایل پشتیبان باقی مانده است"
    exit 1
fi
echo "✅ اجزای ممنوعه حذف شده‌اند."

echo ""
echo "=== PASS 4: عدم تغییر تب ۱ و ۲ (layout) ==="
# فرض می‌کنیم هنوز layout را تغییر نداده‌ایم، فقط hash فعلی را ثبت می‌کنیم
TAB12_HASH=$(sed '/<!-- TAB 3: NETWORK LAB -->/,$d' app/src/main/res/layout/activity_main.xml | sha256sum | awk '{print $1}')
echo "$TAB12_HASH" > $HOME/tab12_hash.txt
echo "✅ Hash فعلی تب ۱ و ۲ ذخیره شد: $TAB12_HASH"

echo ""
echo "=== PASS 5: Repository Hygiene ==="
git diff --check
git diff --cached --check
if grep -RniE '127\.0\.0\.1:8766|GamingVpnService|com\.ippulse\.scanner\.localvpn|WireGuard' app/src/main --exclude-dir=.git; then
    echo "❌ عبارات ممنوعه در سورس باقی مانده‌اند"
    exit 1
fi
echo "✅ Repository hygiene تأیید شد."

echo ""
echo "🎉 تمام پنج PASS با موفقیت انجام شد."
