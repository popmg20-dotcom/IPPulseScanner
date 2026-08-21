package net.i2p.crypto.eddsa;

import defpackage.fw;
import defpackage.g01;
import defpackage.s53;
import defpackage.vp1;
import defpackage.zo2;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.p6;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import net.i2p.crypto.eddsa.math.Curve;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.FieldElement;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.math.ed25519.Ed25519LittleEndianEncoding;
import net.i2p.crypto.eddsa.math.ed25519.Ed25519ScalarOps;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import sun.security.x509.X509Key;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class EdDSAEngine extends Signature {
    public static final g01 g = new g01();
    public MessageDigest a;
    public EdDSAKey b;
    public boolean c;
    public byte[] d;
    public int e;
    public int f;

    public final void a(EdDSAPrivateKey edDSAPrivateKey) {
        Field field = edDSAPrivateKey.Y.b.b;
        this.a.update(edDSAPrivateKey.f, 32, 32);
    }

    public final void b() {
        MessageDigest messageDigest = this.a;
        if (messageDigest != null) {
            messageDigest.reset();
        }
        throw null;
    }

    public final byte[] c() throws SignatureException {
        Curve curve = this.b.getParams().b;
        Ed25519ScalarOps ed25519ScalarOps = this.b.getParams().z;
        byte[] bArr = ((EdDSAPrivateKey) this.b).z;
        if (!this.c) {
            throw null;
        }
        byte[] bArr2 = this.d;
        if (bArr2 == null) {
            throw new SignatureException("update() not called first");
        }
        int i = this.e;
        int i2 = this.f;
        this.a.update(bArr2, i, i2);
        byte[] bArrA = ed25519ScalarOps.a(this.a.digest());
        byte[] bArrL = this.b.getParams().A.i(bArrA).l();
        this.a.update(bArrL);
        this.a.update(((EdDSAPrivateKey) this.b).X);
        this.a.update(bArr2, i, i2);
        byte[] bArrA2 = ed25519ScalarOps.a(this.a.digest());
        long jD = Ed25519LittleEndianEncoding.d(0, bArrA2) & 2097151;
        long jE = (Ed25519LittleEndianEncoding.e(2, bArrA2) >> 5) & 2097151;
        long jD2 = (Ed25519LittleEndianEncoding.d(5, bArrA2) >> 2) & 2097151;
        long jE2 = (Ed25519LittleEndianEncoding.e(7, bArrA2) >> 7) & 2097151;
        long jE3 = (Ed25519LittleEndianEncoding.e(10, bArrA2) >> 4) & 2097151;
        long jD3 = (Ed25519LittleEndianEncoding.d(13, bArrA2) >> 1) & 2097151;
        long jE4 = (Ed25519LittleEndianEncoding.e(15, bArrA2) >> 6) & 2097151;
        long jD4 = (Ed25519LittleEndianEncoding.d(18, bArrA2) >> 3) & 2097151;
        long jD5 = Ed25519LittleEndianEncoding.d(21, bArrA2) & 2097151;
        long jE5 = (Ed25519LittleEndianEncoding.e(23, bArrA2) >> 5) & 2097151;
        long jD6 = (Ed25519LittleEndianEncoding.d(26, bArrA2) >> 2) & 2097151;
        long jE6 = Ed25519LittleEndianEncoding.e(28, bArrA2) >> 7;
        long jD7 = Ed25519LittleEndianEncoding.d(0, bArr) & 2097151;
        long jE7 = (Ed25519LittleEndianEncoding.e(2, bArr) >> 5) & 2097151;
        long jD8 = (Ed25519LittleEndianEncoding.d(5, bArr) >> 2) & 2097151;
        long jE8 = (Ed25519LittleEndianEncoding.e(7, bArr) >> 7) & 2097151;
        long jE9 = (Ed25519LittleEndianEncoding.e(10, bArr) >> 4) & 2097151;
        long jD9 = (Ed25519LittleEndianEncoding.d(13, bArr) >> 1) & 2097151;
        long jE10 = (Ed25519LittleEndianEncoding.e(15, bArr) >> 6) & 2097151;
        long jD10 = (Ed25519LittleEndianEncoding.d(18, bArr) >> 3) & 2097151;
        long jD11 = Ed25519LittleEndianEncoding.d(21, bArr) & 2097151;
        long jE11 = (Ed25519LittleEndianEncoding.e(23, bArr) >> 5) & 2097151;
        long jD12 = (Ed25519LittleEndianEncoding.d(26, bArr) >> 2) & 2097151;
        long jE12 = Ed25519LittleEndianEncoding.e(28, bArr) >> 7;
        long jD13 = Ed25519LittleEndianEncoding.d(0, bArrA) & 2097151;
        long jE13 = (Ed25519LittleEndianEncoding.e(2, bArrA) >> 5) & 2097151;
        long jD14 = (Ed25519LittleEndianEncoding.d(5, bArrA) >> 2) & 2097151;
        long jE14 = (Ed25519LittleEndianEncoding.e(7, bArrA) >> 7) & 2097151;
        long jE15 = (Ed25519LittleEndianEncoding.e(10, bArrA) >> 4) & 2097151;
        long jD15 = (Ed25519LittleEndianEncoding.d(13, bArrA) >> 1) & 2097151;
        long jE16 = (Ed25519LittleEndianEncoding.e(15, bArrA) >> 6) & 2097151;
        long jD16 = (Ed25519LittleEndianEncoding.d(18, bArrA) >> 3) & 2097151;
        long j = (jD * jD7) + jD13;
        long j2 = (jE * jD7) + (jD * jE7) + jE13;
        long j3 = (jD2 * jD7) + (jE * jE7) + (jD * jD8) + jD14;
        long j4 = (jE2 * jD7) + (jD2 * jE7) + (jE * jD8) + (jD * jE8) + jE14;
        long j5 = (jE3 * jD7) + (jE2 * jE7) + (jD2 * jD8) + (jE * jE8) + (jD * jE9) + jE15;
        long j6 = (jD3 * jD7) + (jE3 * jE7) + (jE2 * jD8) + (jD2 * jE8) + (jE * jE9) + (jD * jD9) + jD15;
        long j7 = (jE4 * jD7) + (jD3 * jE7) + (jE3 * jD8) + (jE2 * jE8) + (jD2 * jE9) + (jE * jD9) + (jD * jE10) + jE16;
        long j8 = (jD4 * jD7) + (jE4 * jE7) + (jD3 * jD8) + (jE3 * jE8) + (jE2 * jE9) + (jD2 * jD9) + (jE * jE10) + (jD * jD10) + jD16;
        long jD17 = (jD5 * jD7) + (jD4 * jE7) + (jE4 * jD8) + (jD3 * jE8) + (jE3 * jE9) + (jE2 * jD9) + (jD2 * jE10) + (jE * jD10) + (jD * jD11) + (Ed25519LittleEndianEncoding.d(21, bArrA) & 2097151);
        long jE17 = (jE5 * jD7) + (jD5 * jE7) + (jD4 * jD8) + (jE4 * jE8) + (jD3 * jE9) + (jE3 * jD9) + (jE2 * jE10) + (jD2 * jD10) + (jE * jD11) + (jD * jE11) + ((Ed25519LittleEndianEncoding.e(23, bArrA) >> 5) & 2097151);
        long jD18 = (jD6 * jD7) + (jE5 * jE7) + (jD5 * jD8) + (jD4 * jE8) + (jE4 * jE9) + (jD3 * jD9) + (jE3 * jE10) + (jE2 * jD10) + (jD2 * jD11) + (jE * jE11) + (jD * jD12) + ((long) ((Ed25519LittleEndianEncoding.d(26, bArrA) >> 2) & 2097151));
        long jE18 = (jE6 * jD7) + (jD6 * jE7) + (jE5 * jD8) + (jD5 * jE8) + (jD4 * jE9) + (jE4 * jD9) + (jD3 * jE10) + (jE3 * jD10) + (jE2 * jD11) + (jD2 * jE11) + (jE * jD12) + (jD * jE12) + (Ed25519LittleEndianEncoding.e(28, bArrA) >> 7);
        long j9 = (jE7 * jE6) + (jD6 * jD8) + (jE5 * jE8) + (jD5 * jE9) + (jD4 * jD9) + (jE4 * jE10) + (jD3 * jD10) + (jE3 * jD11) + (jE2 * jE11) + (jD2 * jD12) + (jE * jE12);
        long j10 = (jE6 * jD8) + (jD6 * jE8) + (jE5 * jE9) + (jD5 * jD9) + (jD4 * jE10) + (jE4 * jD10) + (jD3 * jD11) + (jE3 * jE11) + (jE2 * jD12) + (jD2 * jE12);
        long j11 = (jE8 * jE6) + (jD6 * jE9) + (jE5 * jD9) + (jD5 * jE10) + (jD4 * jD10) + (jE4 * jD11) + (jD3 * jE11) + (jE3 * jD12) + (jE2 * jE12);
        long j12 = (jE9 * jE6) + (jD6 * jD9) + (jE5 * jE10) + (jD5 * jD10) + (jD4 * jD11) + (jE4 * jE11) + (jD3 * jD12) + (jE3 * jE12);
        long j13 = (jE6 * jD9) + (jD6 * jE10) + (jE5 * jD10) + (jD5 * jD11) + (jD4 * jE11) + (jE4 * jD12) + (jD3 * jE12);
        long j14 = (jE10 * jE6) + (jD6 * jD10) + (jE5 * jD11) + (jD5 * jE11) + (jD4 * jD12) + (jE4 * jE12);
        long j15 = (jE6 * jD10) + (jD6 * jD11) + (jE5 * jE11) + (jD5 * jD12) + (jD4 * jE12);
        long j16 = (jE6 * jD11) + (jD6 * jE11) + (jE5 * jD12) + (jD5 * jE12);
        long j17 = (jE11 * jE6) + (jD6 * jD12) + (jE5 * jE12);
        long j18 = (jE6 * jD12) + (jD6 * jE12);
        long j19 = jE6 * jE12;
        long j20 = (j + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j21 = j2 + j20;
        long j22 = j - (j20 << 21);
        long j23 = (j3 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j24 = j4 + j23;
        long j25 = j3 - (j23 << 21);
        long j26 = (j5 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j27 = j6 + j26;
        long j28 = j5 - (j26 << 21);
        long j29 = (j7 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j30 = j8 + j29;
        long j31 = j7 - (j29 << 21);
        long j32 = (jD17 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j33 = jE17 + j32;
        long j34 = jD17 - (j32 << 21);
        long j35 = (jD18 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j36 = jE18 + j35;
        long j37 = jD18 - (j35 << 21);
        long j38 = (j9 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j39 = j10 + j38;
        long j40 = j9 - (j38 << 21);
        long j41 = (j11 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j42 = j12 + j41;
        long j43 = j11 - (j41 << 21);
        long j44 = (j13 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j45 = j14 + j44;
        long j46 = j13 - (j44 << 21);
        long j47 = (j15 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j48 = j16 + j47;
        long j49 = j15 - (j47 << 21);
        long j50 = (j17 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j51 = j18 + j50;
        long j52 = j17 - (j50 << 21);
        long j53 = (j19 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j54 = (j21 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j55 = j25 + j54;
        long j56 = j21 - (j54 << 21);
        long j57 = (j24 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j58 = j28 + j57;
        long j59 = j24 - (j57 << 21);
        long j60 = (j27 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j61 = j31 + j60;
        long j62 = j27 - (j60 << 21);
        long j63 = (j30 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j64 = j34 + j63;
        long j65 = j30 - (j63 << 21);
        long j66 = (j33 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j67 = j37 + j66;
        long j68 = j33 - (j66 << 21);
        long j69 = (j36 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j70 = j40 + j69;
        long j71 = j36 - (j69 << 21);
        long j72 = (j39 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j73 = j43 + j72;
        long j74 = j39 - (j72 << 21);
        long j75 = (j42 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j76 = j46 + j75;
        long j77 = j42 - (j75 << 21);
        long j78 = (j45 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j79 = j49 + j78;
        long j80 = j45 - (j78 << 21);
        long j81 = (j48 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j82 = j52 + j81;
        long j83 = j48 - (j81 << 21);
        long j84 = (j51 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j85 = (j19 - (j53 << 21)) + j84;
        long j86 = j51 - (j84 << 21);
        long j87 = (j53 * 666643) + j71;
        long j88 = (j53 * 470296) + j70;
        long j89 = (j53 * 654183) + j74;
        long j90 = j73 - (j53 * 997805);
        long j91 = (j53 * 136657) + j77;
        long j92 = j76 - (j53 * 683901);
        long j93 = (j85 * 666643) + j67;
        long j94 = (j85 * 470296) + j87;
        long j95 = (j85 * 654183) + j88;
        long j96 = j89 - (j85 * 997805);
        long j97 = (j85 * 136657) + j90;
        long j98 = j91 - (j85 * 683901);
        long j99 = (j86 * 666643) + j68;
        long j100 = (j86 * 470296) + j93;
        long j101 = (j86 * 654183) + j94;
        long j102 = (j86 * 136657) + j96;
        long j103 = j97 - (j86 * 683901);
        long j104 = (j82 * 470296) + j99;
        long j105 = (j82 * 654183) + j100;
        long j106 = (j82 * 136657) + (j95 - (j86 * 997805));
        long j107 = (j83 * 666643) + j65;
        long j108 = (j83 * 470296) + (j82 * 666643) + j64;
        long j109 = (j83 * 654183) + j104;
        long j110 = j105 - (j83 * 997805);
        long j111 = (j83 * 136657) + (j101 - (j82 * 997805));
        long j112 = j106 - (j83 * 683901);
        long j113 = (j79 * 666643) + j61;
        long j114 = (j79 * 470296) + j107;
        long j115 = (j79 * 654183) + j108;
        long j116 = j109 - (j79 * 997805);
        long j117 = (j79 * 136657) + j110;
        long j118 = j111 - (j79 * 683901);
        long j119 = (j113 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j120 = j114 + j119;
        long j121 = j113 - (j119 << 21);
        long j122 = (j115 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j123 = j116 + j122;
        long j124 = j115 - (j122 << 21);
        long j125 = (j117 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j126 = j118 + j125;
        long j127 = j117 - (j125 << 21);
        long j128 = (j112 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j129 = (j102 - (j82 * 683901)) + j128;
        long j130 = j112 - (j128 << 21);
        long j131 = (j103 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j132 = j98 + j131;
        long j133 = j103 - (j131 << 21);
        long j134 = (j92 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j135 = j80 + j134;
        long j136 = j92 - (j134 << 21);
        long j137 = (j120 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j138 = j124 + j137;
        long j139 = j120 - (j137 << 21);
        long j140 = (j123 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j141 = j127 + j140;
        long j142 = j123 - (j140 << 21);
        long j143 = (j126 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j144 = j130 + j143;
        long j145 = j126 - (j143 << 21);
        long j146 = (j129 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j147 = j133 + j146;
        long j148 = j129 - (j146 << 21);
        long j149 = (j132 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j150 = j136 + j149;
        long j151 = j132 - (j149 << 21);
        long j152 = (j135 * 470296) + j121;
        long j153 = (j135 * 654183) + j139;
        long j154 = j141 - (j135 * 683901);
        long j155 = (j150 * 654183) + j152;
        long j156 = (j150 * 136657) + (j138 - (j135 * 997805));
        long j157 = ((j135 * 136657) + j142) - (j150 * 683901);
        long j158 = (j151 * 470296) + (j150 * 666643) + j58;
        long j159 = (j151 * 654183) + (j150 * 470296) + (j135 * 666643) + j62;
        long j160 = j155 - (j151 * 997805);
        long j161 = (j151 * 136657) + (j153 - (j150 * 997805));
        long j162 = j156 - (j151 * 683901);
        long j163 = (j147 * 470296) + (j151 * 666643) + j59;
        long j164 = (j147 * 654183) + j158;
        long j165 = j159 - (j147 * 997805);
        long j166 = (j147 * 136657) + j160;
        long j167 = j161 - (j147 * 683901);
        long j168 = (j148 * 654183) + j163;
        long j169 = (j148 * 136657) + j165;
        long j170 = j166 - (j148 * 683901);
        long j171 = (j144 * 666643) + j22;
        long j172 = (j144 * 654183) + (j148 * 470296) + (j147 * 666643) + j55;
        long j173 = (j144 * 136657) + (j164 - (j148 * 997805));
        long j174 = (j171 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j175 = (j144 * 470296) + (j148 * 666643) + j56 + j174;
        long j176 = j171 - (j174 << 21);
        long j177 = (j172 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j178 = (j168 - (j144 * 997805)) + j177;
        long j179 = j172 - (j177 << 21);
        long j180 = (j173 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j181 = (j169 - (j144 * 683901)) + j180;
        long j182 = j173 - (j180 << 21);
        long j183 = (j170 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j184 = j167 + j183;
        long j185 = j170 - (j183 << 21);
        long j186 = (j162 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j187 = j157 + j186;
        long j188 = j162 - (j186 << 21);
        long j189 = (j154 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j190 = j145 + j189;
        long j191 = j154 - (j189 << 21);
        long j192 = (j175 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j193 = j179 + j192;
        long j194 = j175 - (j192 << 21);
        long j195 = (j178 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j196 = j182 + j195;
        long j197 = j178 - (j195 << 21);
        long j198 = (j181 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j199 = j185 + j198;
        long j200 = j181 - (j198 << 21);
        long j201 = (j184 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j202 = j188 + j201;
        long j203 = j184 - (j201 << 21);
        long j204 = (j187 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j205 = j191 + j204;
        long j206 = j187 - (j204 << 21);
        long j207 = (j190 + p6.MAX_EVENT_SIZE_BYTES) >> 21;
        long j208 = j190 - (j207 << 21);
        long j209 = (j207 * 666643) + j176;
        long j210 = (j207 * 470296) + j194;
        long j211 = (j207 * 654183) + j193;
        long j212 = j197 - (j207 * 997805);
        long j213 = (j207 * 136657) + j196;
        long j214 = j200 - (j207 * 683901);
        long j215 = j209 >> 21;
        long j216 = j210 + j215;
        long j217 = j209 - (j215 << 21);
        long j218 = j216 >> 21;
        long j219 = j211 + j218;
        long j220 = j216 - (j218 << 21);
        long j221 = j219 >> 21;
        long j222 = j212 + j221;
        long j223 = j219 - (j221 << 21);
        long j224 = j222 >> 21;
        long j225 = j213 + j224;
        long j226 = j222 - (j224 << 21);
        long j227 = j225 >> 21;
        long j228 = j214 + j227;
        long j229 = j225 - (j227 << 21);
        long j230 = j228 >> 21;
        long j231 = j199 + j230;
        long j232 = j228 - (j230 << 21);
        long j233 = j231 >> 21;
        long j234 = j203 + j233;
        long j235 = j231 - (j233 << 21);
        long j236 = j234 >> 21;
        long j237 = j202 + j236;
        long j238 = j234 - (j236 << 21);
        long j239 = j237 >> 21;
        long j240 = j206 + j239;
        long j241 = j237 - (j239 << 21);
        long j242 = j240 >> 21;
        long j243 = j205 + j242;
        long j244 = j240 - (j242 << 21);
        long j245 = j243 >> 21;
        long j246 = j208 + j245;
        long j247 = j243 - (j245 << 21);
        long j248 = j246 >> 21;
        long j249 = j246 - (j248 << 21);
        long j250 = (666643 * j248) + j217;
        long j251 = (654183 * j248) + j223;
        long j252 = j226 - (997805 * j248);
        long j253 = (136657 * j248) + j229;
        long j254 = j232 - (j248 * 683901);
        long j255 = j250 >> 21;
        long j256 = (470296 * j248) + j220 + j255;
        long j257 = j256 >> 21;
        long j258 = j251 + j257;
        long j259 = j256 - (j257 << 21);
        long j260 = j258 >> 21;
        long j261 = j252 + j260;
        long j262 = j258 - (j260 << 21);
        long j263 = j261 >> 21;
        long j264 = j253 + j263;
        long j265 = j261 - (j263 << 21);
        long j266 = j264 >> 21;
        long j267 = j254 + j266;
        long j268 = j264 - (j266 << 21);
        long j269 = j267 >> 21;
        long j270 = j235 + j269;
        long j271 = j267 - (j269 << 21);
        long j272 = j270 >> 21;
        long j273 = j238 + j272;
        long j274 = j270 - (j272 << 21);
        long j275 = j273 >> 21;
        long j276 = j241 + j275;
        long j277 = j273 - (j275 << 21);
        long j278 = j276 >> 21;
        long j279 = j244 + j278;
        long j280 = j279 >> 21;
        long j281 = j247 + j280;
        long j282 = j279 - (j280 << 21);
        long j283 = j281 >> 21;
        long j284 = j249 + j283;
        long j285 = j281 - (j283 << 21);
        Field field = curve.b;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(64);
        byteBufferAllocate.put(bArrL).put(new byte[]{(byte) (j250 - (j255 << 21)), (byte) (r4 >> 8), (byte) ((r4 >> 16) | (j259 << 5)), (byte) (j259 >> 3), (byte) (j259 >> 11), (byte) ((j259 >> 19) | (j262 << 2)), (byte) (j262 >> 6), (byte) ((j262 >> 14) | (j265 << 7)), (byte) (j265 >> 1), (byte) (j265 >> 9), (byte) ((j265 >> 17) | (j268 << 4)), (byte) (j268 >> 4), (byte) (j268 >> 12), (byte) ((j268 >> 20) | (j271 << 1)), (byte) (j271 >> 7), (byte) ((j271 >> 15) | (j274 << 6)), (byte) (j274 >> 2), (byte) (j274 >> 10), (byte) ((j274 >> 18) | (j277 << 3)), (byte) (j277 >> 5), (byte) (j277 >> 13), (byte) (j276 - (j278 << 21)), (byte) (r6 >> 8), (byte) ((r6 >> 16) | (j282 << 5)), (byte) (j282 >> 3), (byte) (j282 >> 11), (byte) ((j282 >> 19) | (j285 << 2)), (byte) (j285 >> 6), (byte) ((j285 >> 14) | (j284 << 7)), (byte) (j284 >> 1), (byte) (j284 >> 9), (byte) (j284 >> 17)});
        return byteBufferAllocate.array();
    }

    public final boolean d(byte[] bArr) throws SignatureException {
        Field field = this.b.getParams().b.b;
        if (bArr.length != 64) {
            throw new SignatureException("signature length is wrong");
        }
        this.a.update(bArr, 0, 32);
        this.a.update(((EdDSAPublicKey) this.b).z);
        if (!this.c) {
            throw null;
        }
        byte[] bArr2 = this.d;
        if (bArr2 == null) {
            throw new SignatureException("update() not called first");
        }
        this.a.update(bArr2, this.e, this.f);
        byte[] bArrA = this.b.getParams().z.a(this.a.digest());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 32, 64);
        GroupElement groupElement = this.b.getParams().A;
        EdDSAPublicKey edDSAPublicKey = (EdDSAPublicKey) this.b;
        GroupElement groupElementM = edDSAPublicKey.f;
        GroupElement.Representation representation = GroupElement.Representation.f;
        if (groupElementM == null) {
            GroupElement groupElement2 = edDSAPublicKey.b;
            if (groupElement2.f != representation) {
                vp1.q();
                return false;
            }
            GroupElement groupElementA = groupElement2.b.a(representation);
            GroupElement.Representation representation2 = GroupElement.Representation.Y;
            GroupElement groupElementM2 = groupElement2.m(representation2);
            FieldElement fieldElement = groupElementA.z;
            FieldElement fieldElement2 = groupElementA.A;
            if (groupElementA.f != representation) {
                vp1.q();
                return false;
            }
            if (groupElementM2.f != representation2) {
                s53.d();
                return false;
            }
            FieldElement fieldElementA = fieldElement2.a(fieldElement);
            FieldElement fieldElementL = fieldElement2.l(fieldElement);
            FieldElement fieldElementG = fieldElementA.g(groupElementM2.A);
            FieldElement fieldElementG2 = fieldElementL.g(groupElementM2.z);
            FieldElement fieldElementG3 = groupElementM2.Y.g(groupElementA.Y);
            FieldElement fieldElementG4 = groupElementA.X.g(groupElementM2.X);
            FieldElement fieldElementA2 = fieldElementG4.a(fieldElementG4);
            groupElementM = GroupElement.f(groupElementA.b, fieldElementG.l(fieldElementG2), fieldElementG.a(fieldElementG2), fieldElementA2.l(fieldElementG3), fieldElementA2.a(fieldElementG3)).m(GroupElement.Representation.z);
            edDSAPublicKey.f = groupElementM;
        }
        GroupElement[] groupElementArr = groupElementM.y0;
        GroupElement[] groupElementArr2 = groupElement.y0;
        byte[] bArrK = GroupElement.k(bArrA);
        byte[] bArrK2 = GroupElement.k(bArrCopyOfRange);
        Curve curve = groupElement.b;
        GroupElement.Representation representation3 = GroupElement.Representation.b;
        GroupElement groupElementA2 = curve.a(representation3);
        int i = DnsRecord.CLASS_ANY;
        while (i >= 0 && bArrK[i] == 0 && bArrK2[i] == 0) {
            i--;
        }
        while (i >= 0) {
            GroupElement groupElementC = groupElementA2.c();
            byte b = bArrK[i];
            if (b > 0) {
                groupElementC = groupElementC.m(representation).d(groupElementArr[bArrK[i] / 2]);
            } else if (b < 0) {
                groupElementC = groupElementC.m(representation).e(groupElementArr[(-bArrK[i]) / 2]);
            }
            byte b2 = bArrK2[i];
            if (b2 > 0) {
                groupElementC = groupElementC.m(representation).d(groupElementArr2[bArrK2[i] / 2]);
            } else if (b2 < 0) {
                groupElementC = groupElementC.m(representation).e(groupElementArr2[(-bArrK2[i]) / 2]);
            }
            groupElementA2 = groupElementC.m(representation3);
            i--;
        }
        byte[] bArrL = groupElementA2.l();
        for (int i2 = 0; i2 < bArrL.length; i2++) {
            if (bArrL[i2] != bArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.security.SignatureSpi
    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public final void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        b();
        if (!(privateKey instanceof EdDSAPrivateKey)) {
            throw new InvalidKeyException("cannot identify EdDSA private key: " + privateKey.getClass());
        }
        EdDSAPrivateKey edDSAPrivateKey = (EdDSAPrivateKey) privateKey;
        this.b = edDSAPrivateKey;
        MessageDigest messageDigest = this.a;
        EdDSAParameterSpec edDSAParameterSpec = edDSAPrivateKey.Y;
        if (messageDigest == null) {
            try {
                this.a = MessageDigest.getInstance(edDSAParameterSpec.f);
            } catch (NoSuchAlgorithmException unused) {
                throw new InvalidKeyException(fw.y(new StringBuilder("cannot get required digest "), this.b.getParams().f, " for private key."));
            }
        } else if (!edDSAParameterSpec.f.equals(messageDigest.getAlgorithm())) {
            zo2.u("Key hash algorithm does not match chosen digest");
            return;
        }
        a(edDSAPrivateKey);
    }

    @Override // java.security.SignatureSpi
    public final void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        b();
        if (!(publicKey instanceof EdDSAPublicKey)) {
            if (!(publicKey instanceof X509Key)) {
                throw new InvalidKeyException("cannot identify EdDSA public key: " + publicKey.getClass());
            }
            try {
                engineInitVerify(new EdDSAPublicKey(new X509EncodedKeySpec(publicKey.getEncoded())));
                return;
            } catch (InvalidKeySpecException unused) {
                throw new InvalidKeyException("cannot handle X.509 EdDSA public key: " + publicKey.getAlgorithm());
            }
        }
        EdDSAPublicKey edDSAPublicKey = (EdDSAPublicKey) publicKey;
        this.b = edDSAPublicKey;
        MessageDigest messageDigest = this.a;
        EdDSAParameterSpec edDSAParameterSpec = edDSAPublicKey.A;
        if (messageDigest == null) {
            try {
                this.a = MessageDigest.getInstance(edDSAParameterSpec.f);
            } catch (NoSuchAlgorithmException unused2) {
                throw new InvalidKeyException(fw.y(new StringBuilder("cannot get required digest "), this.b.getParams().f, " for private key."));
            }
        } else {
            if (edDSAParameterSpec.f.equals(messageDigest.getAlgorithm())) {
                return;
            }
            zo2.u("Key hash algorithm does not match chosen digest");
        }
    }

    @Override // java.security.SignatureSpi
    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec.equals(g)) {
            this.d.getClass();
            throw new InvalidAlgorithmParameterException("update() already called");
        }
        super.engineSetParameter(algorithmParameterSpec);
    }

    @Override // java.security.SignatureSpi
    public final byte[] engineSign() {
        try {
            return c();
        } finally {
            b();
            a((EdDSAPrivateKey) this.b);
        }
    }

    @Override // java.security.SignatureSpi
    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        if (!this.c) {
            throw null;
        }
        if (this.d != null) {
            throw new SignatureException("update() already called");
        }
        this.d = bArr;
        this.e = i;
        this.f = i2;
    }

    @Override // java.security.SignatureSpi
    public final boolean engineVerify(byte[] bArr) {
        try {
            return d(bArr);
        } finally {
            b();
        }
    }

    @Override // java.security.SignatureSpi
    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public final void engineUpdate(byte b) throws SignatureException {
        if (!this.c) {
            throw null;
        }
        throw new SignatureException("unsupported in one-shot mode");
    }
}
