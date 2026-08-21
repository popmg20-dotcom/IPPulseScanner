#!/data/data/com.termux/files/usr/bin/bash
set -Eeuo pipefail

ROOT="$HOME/surfboard_engine_export"
SO="$ROOT/apk/lib/arm64-v8a/libsurfboard.so"

fail() {
    echo
    echo "[ERROR] $1"
    exit 1
}

ok() {
    echo "[OK] $1"
}

echo "===== SURFBOARD ENGINE FINAL CHECK ====="

[ -d "$ROOT" ] || fail "Export directory missing"
[ -f "$SO" ] || fail "libsurfboard.so missing"

ok "Export directory exists"
ok "libsurfboard.so exists"

echo
echo "===== ELF ====="
file "$SO" || fail "file failed"

SYMS="$(mktemp)"
trap 'rm -f "$SYMS"' EXIT

readelf -Ws "$SO" > "$SYMS" 2>/dev/null ||
    fail "readelf failed"

has_symbol() {
    local sym="$1"

    grep -Eq "[[:space:]]${sym}[[:space:]]*$" "$SYMS"
}

echo
echo "===== REQUIRED SYMBOLS ====="

REQUIRED_SYMBOLS=(
    "Java_com_getsurfboard_vpn_Jni_startVPN"
    "Java_com_getsurfboard_vpn_Jni_stopVPN"
    "Java_com_getsurfboard_vpn_JniKt_getTunAddress"
    "Java_com_getsurfboard_vpn_JniKt_getTun6Address"
    "on_tun_recv"
    "write_tun"
    "tcp_input"
    "udp_input"
    "connect_remote"
    "open_udp_socket"
    "bridge_tcp_stream"
    "write_tcp_data"
    "on_tcp_read"
    "on_tcp_remote_connect"
    "on_tcp_new_connection"
)

for sym in "${REQUIRED_SYMBOLS[@]}"; do
    if has_symbol "$sym"; then
        ok "$sym"
    else
        fail "Missing symbol: $sym"
    fi
done

echo
echo "===== EXACT VERIFIED SYMBOL LINES ====="

for sym in "${REQUIRED_SYMBOLS[@]}"; do
    grep -E "[[:space:]]${sym}[[:space:]]*$" "$SYMS"
done

echo
echo "===== CALLBACK STRINGS ====="

strings "$SO" 2>/dev/null | grep -Fx "on_start_vpn_finished" >/dev/null ||
    fail "Missing on_start_vpn_finished"

strings "$SO" 2>/dev/null | grep -Fx "on_stop_vpn_finished" >/dev/null ||
    fail "Missing on_stop_vpn_finished"

ok "on_start_vpn_finished"
ok "on_stop_vpn_finished"

echo
echo "===== JNI SOURCE ====="

JNI="$ROOT/jadx/sources/com/getsurfboard/vpn/Jni.java"

[ -f "$JNI" ] || fail "Jni.java missing"

grep -Fq \
'private final native void startVPN(int i, int i2, int i3, boolean z, boolean z2, boolean z3);' \
"$JNI" ||
    fail "startVPN Java declaration not found"

grep -Fq \
'private final native void stopVPN();' \
"$JNI" ||
    fail "stopVPN Java declaration not found"

ok "startVPN declaration"
ok "stopVPN declaration"

echo
echo "===== NATIVE NETWORK PATH ====="

llvm-objdump -d "$SO" 2>/dev/null > "$ROOT/_final_disasm.txt" ||
    fail "llvm-objdump failed"

for needle in \
    "uv_tcp_connect@plt" \
    "protect@plt" \
    "uv_udp_init_ex@plt" \
    "uv_udp_recv_start@plt" \
    "uv_read_start@plt" \
    "uv_write@plt"
do
    grep -Fq "$needle" "$ROOT/_final_disasm.txt" ||
        fail "Missing native call: $needle"
    ok "$needle"
done

echo
echo "===== VERIFIED ENGINE FUNCTIONS ====="

for sym in \
    "on_tun_recv" \
    "write_tun" \
    "tcp_input" \
    "udp_input" \
    "connect_remote" \
    "open_udp_socket" \
    "write_tcp_data" \
    "bridge_tcp_stream" \
    "on_tcp_read"
do
    grep -E "[[:space:]]${sym}[[:space:]]*$" "$SYMS"
done

echo
echo "===== JNI NATIVE SYMBOLS ====="

grep -E \
'Java_com_getsurfboard_vpn_Jni_(startVPN|stopVPN)$|Java_com_getsurfboard_vpn_JniKt_getTun(Address|6Address)$' \
"$SYMS"

echo
echo "===== SHA256 ====="

sha256sum "$SO"

echo
echo "===== FINAL STATUS ====="
echo "SUCCESS"
