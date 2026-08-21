package defpackage;

import j$.util.DesugarCollections;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xq implements yr {
    public static final rq A0;
    public static final sq B0;
    public static final tq C0;
    public static final uq D0;
    public static final vq E0;
    public static final wq F0;
    public static final mq G0;
    public static final Set H0;
    public static final /* synthetic */ xq[] I0;
    public static final pq y0;
    public static final qq z0;
    public final int A;
    public final String X;
    public final String Y;
    public final AtomicReference Z = new AtomicReference();
    public final String b;
    public final int f;
    public final int z;

    /* JADX INFO: Fake field, exist only in values array */
    xq EF0;

    static {
        oq oqVar = new oq("none", 0, "none", 0, 0, "None", 0, "None", 8);
        pq pqVar = new pq("aes128cbc", 1, "aes128-cbc", 16, 0, "AES", 128, "AES/CBC/NoPadding", 16);
        y0 = pqVar;
        qq qqVar = new qq("aes128ctr", 2, "aes128-ctr", 16, 0, "AES", 128, "AES/CTR/NoPadding", 16);
        z0 = qqVar;
        rq rqVar = new rq("aes128gcm", 3, "aes128-gcm@openssh.com", 12, 16, "AES", 128, "AES/GCM/NoPadding", 16);
        A0 = rqVar;
        sq sqVar = new sq("aes256gcm", 4, "aes256-gcm@openssh.com", 12, 16, "AES", 256, "AES/GCM/NoPadding", 16);
        B0 = sqVar;
        tq tqVar = new tq("aes192cbc", 5, "aes192-cbc", 16, 0, "AES", 192, "AES/CBC/NoPadding", 16);
        C0 = tqVar;
        uq uqVar = new uq("aes192ctr", 6, "aes192-ctr", 16, 0, "AES", 192, "AES/CTR/NoPadding", 16);
        D0 = uqVar;
        vq vqVar = new vq("aes256cbc", 7, "aes256-cbc", 16, 0, "AES", 256, "AES/CBC/NoPadding", 16);
        E0 = vqVar;
        wq wqVar = new wq("aes256ctr", 8, "aes256-ctr", 16, 0, "AES", 256, "AES/CTR/NoPadding", 16);
        F0 = wqVar;
        jq jqVar = new jq("arcfour128", 9, "arcfour128", 8, 0, "ARCFOUR", 128, "RC4", 8);
        kq kqVar = new kq("arcfour256", 10, "arcfour256", 8, 0, "ARCFOUR", 256, "RC4", 8);
        lq lqVar = new lq("blowfishcbc", 11, "blowfish-cbc", 8, 0, "Blowfish", 128, "Blowfish/CBC/NoPadding", 8);
        mq mqVar = new mq("cc20p1305_openssh", 12, "chacha20-poly1305@openssh.com", 8, 16, "ChaCha", 512, "ChaCha", 8);
        G0 = mqVar;
        I0 = new xq[]{oqVar, pqVar, qqVar, rqVar, sqVar, tqVar, uqVar, vqVar, wqVar, jqVar, kqVar, lqVar, mqVar, new nq("tripledescbc", 13, "3des-cbc", 8, 0, "DESede", 192, "DESede/CBC/NoPadding", 8)};
        H0 = DesugarCollections.unmodifiableSet(EnumSet.allOf(xq.class));
        new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public xq(String str, int i, String str2, int i2, int i3, String str3, int i4, String str4, int i5) {
        this.b = str2;
        this.f = i2;
        this.z = i4;
        this.X = str3;
        this.Y = str4;
        this.A = i5;
    }

    public static xq valueOf(String str) {
        return (xq) Enum.valueOf(xq.class, str);
    }

    public static xq[] values() {
        return (xq[]) I0.clone();
    }

    public final int b() {
        return this.z / 8;
    }

    public boolean g() {
        AtomicReference atomicReference = this.Z;
        Boolean boolValueOf = (Boolean) atomicReference.get();
        if (boolValueOf == null) {
            String str = this.Y;
            n12.g(str, "No transformation");
            int i = this.z;
            if (i <= 0) {
                throw new IllegalArgumentException("Bad key length (" + i + ") for cipher=" + str);
            }
            boolean z = false;
            try {
                if (Cipher.getMaxAllowedKeyLength(str) >= i) {
                    z = true;
                }
            } catch (Exception unused) {
            }
            boolValueOf = Boolean.valueOf(z);
            while (true) {
                if (atomicReference.compareAndSet(null, boolValueOf)) {
                    break;
                }
                if (atomicReference.get() != null) {
                    boolValueOf = (Boolean) atomicReference.get();
                    break;
                }
            }
        }
        return boolValueOf.booleanValue();
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return a();
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
