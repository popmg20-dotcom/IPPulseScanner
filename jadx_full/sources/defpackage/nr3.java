package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.DesugarCollections;
import j$.util.Map;
import j$.util.Objects;
import j$.util.Optional;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import javax.crypto.Cipher;
import javax.crypto.spec.DHParameterSpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class nr3 {
    public static final List a = DesugarCollections.unmodifiableList(Arrays.asList("org.apache.sshd.common.util.security.SunJCESecurityProviderRegistrar", "org.apache.sshd.common.util.security.bouncycastle.BouncyCastleSecurityProviderRegistrar", "org.apache.sshd.common.util.security.eddsa.EdDSASecurityProviderRegistrar"));
    public static final AtomicInteger b = new AtomicInteger(0);
    public static final AtomicInteger c = new AtomicInteger(0);
    public static final LinkedHashMap d = new LinkedHashMap();
    public static final TreeSet e;
    public static final AtomicBoolean f;
    public static final HashMap g;
    public static final AtomicReference h;
    public static final AtomicReference i;
    public static Boolean j;

    static {
        new AtomicReference();
        e = new TreeSet();
        f = new AtomicBoolean(false);
        g = new HashMap();
        h = new AtomicReference();
        i = new AtomicReference();
    }

    public static mr3 a() {
        mr3 lr3Var;
        AtomicReference atomicReference = h;
        synchronized (atomicReference) {
            try {
                mr3 mr3Var = (mr3) atomicReference.get();
                if (mr3Var != null) {
                    return mr3Var;
                }
                String property = System.getProperty("org.apache.sshd.security.defaultProvider");
                if (ga5.t(property)) {
                    lr3Var = mr3.P;
                } else {
                    NavigableSet navigableSet = x83.a;
                    if ("none".equalsIgnoreCase(property)) {
                        lr3Var = mr3.P;
                    } else {
                        n12.g(property, "No name provided");
                        lr3Var = new lr3(property);
                    }
                }
                atomicReference.set(lr3Var);
                return lr3Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Optional b() {
        h();
        LinkedHashMap linkedHashMap = d;
        synchronized (linkedHashMap) {
            try {
                z1 z1Var = (z1) linkedHashMap.get("EdDSA");
                if (z1Var != null) {
                    Optional optionalW0 = z1Var.W0();
                    if (optionalW0.isPresent()) {
                        return optionalW0;
                    }
                }
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    Optional optionalW02 = ((z1) ((Map.Entry) it.next()).getValue()).W0();
                    if (optionalW02.isPresent()) {
                        return optionalW02;
                    }
                }
                return Optional.empty();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static z1 c(String str) {
        z1 z1Var;
        n12.g(str, "No provider name specified");
        LinkedHashMap linkedHashMap = d;
        synchronized (linkedHashMap) {
            z1Var = (z1) linkedHashMap.get(str);
        }
        return z1Var;
    }

    public static boolean d() {
        int iJ = j(c, "org.apache.sshd.maxDHGexKeySize", 8192);
        int iJ2 = j(b, "org.apache.sshd.minDHGexKeySize", 2048);
        return iJ2 > 0 && iJ > 0 && iJ2 <= iJ;
    }

    public static boolean e(int i2) {
        return d() && j(c, "org.apache.sshd.maxDHGexKeySize", 8192) >= i2;
    }

    public static boolean f() {
        Boolean boolValueOf = j;
        if (boolValueOf == null) {
            String property = System.getProperty("org.apache.sshd.eccSupport");
            if (ga5.t(property)) {
                try {
                    boolValueOf = Boolean.TRUE;
                    j = boolValueOf;
                } catch (Throwable unused) {
                    boolValueOf = Boolean.FALSE;
                    j = boolValueOf;
                }
            } else {
                xe2.c(nr3.class).info("Override ECC support value: {}", property);
                boolValueOf = Boolean.valueOf(property);
                j = boolValueOf;
            }
        }
        return boolValueOf.booleanValue();
    }

    public static boolean g() {
        AtomicReference atomicReference = i;
        Boolean bool = (Boolean) atomicReference.get();
        if (atomicReference.get() == null) {
            Boolean boolValueOf = Boolean.valueOf(Boolean.getBoolean("org.apache.sshd.security.fipsEnabled"));
            while (true) {
                if (atomicReference.compareAndSet(null, boolValueOf)) {
                    bool = boolValueOf;
                    break;
                }
                if (atomicReference.get() != null) {
                    bool = (Boolean) atomicReference.get();
                    break;
                }
            }
        }
        return bool.booleanValue();
    }

    public static void h() {
        String string;
        AtomicBoolean atomicBoolean = f;
        synchronized (atomicBoolean) {
            try {
                if (atomicBoolean.get()) {
                    return;
                }
                List list = a;
                Iterator it = list == null ? null : list.iterator();
                if (it == null || !it.hasNext()) {
                    string = "";
                } else {
                    StringBuilder sb = new StringBuilder();
                    do {
                        Object next = it.next();
                        if (sb.length() > 0) {
                            sb.append(StringUtil.COMMA);
                        }
                        sb.append(Objects.toString(next));
                    } while (it.hasNext());
                    string = sb.toString();
                }
                String property = System.getProperty("org.apache.sshd.security.registrars", string);
                boolean z = false;
                if ((property == null ? 0 : property.length()) > 0) {
                    NavigableSet navigableSet = x83.a;
                    if (!"none".equalsIgnoreCase(property)) {
                        String[] strArrF = ga5.F(property, StringUtil.COMMA);
                        we2 we2VarC = xe2.c(nr3.class);
                        boolean zIsDebugEnabled = we2VarC.isDebugEnabled();
                        boolean z2 = false;
                        for (String str : strArrF) {
                            try {
                                z1 z1Var = (z1) xd4.a(nr3.class, z1.class, str);
                                z1Var.getClass();
                                if (i(z1Var) == null) {
                                    if (zIsDebugEnabled) {
                                        we2VarC.debug("register({}) not registered - enabled={}, supported={}", null, Boolean.valueOf(z1Var.X0()), Boolean.valueOf(z1Var.g()));
                                    }
                                } else if ("BC".equalsIgnoreCase(null)) {
                                    z2 = true;
                                }
                            } catch (ReflectiveOperationException e2) {
                                Throwable thA = n61.a(e2);
                                we2VarC.error("Failed ({}) to create default {} registrar instance: {}", thA.getClass().getSimpleName(), str, thA.getMessage());
                                if (thA instanceof RuntimeException) {
                                    throw ((RuntimeException) thA);
                                }
                                if (!(thA instanceof Error)) {
                                    throw new IllegalStateException(thA);
                                }
                                throw ((Error) thA);
                            }
                        }
                        z = z2;
                    }
                }
                if (a() == mr3.P && z) {
                    n12.g("BC", "No name provided");
                    h.set(new lr3("BC"));
                }
                f.set(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static z1 i(z1 z1Var) {
        z1 z1VarC = c(null);
        if (z1VarC != null || !z1Var.X0() || !z1Var.g()) {
            return z1VarC;
        }
        try {
            String strX0 = z1Var.x0();
            n12.k(strX0 != null, "No name for registrar=%s", z1Var);
            String strTrim = strX0.trim();
            n12.k((strTrim == null ? 0 : strTrim.length()) > 0, "No name for registrar=%s", z1Var);
            if (Security.getProvider(strTrim) == null) {
                Provider providerI0 = z1Var.i0();
                if (providerI0 == null) {
                    throw new IllegalArgumentException("No provider created for registrar null of " + strTrim);
                }
                if (z1Var.Z()) {
                    Security.addProvider(providerI0);
                }
            }
            LinkedHashMap linkedHashMap = d;
            synchronized (linkedHashMap) {
                linkedHashMap.put(null, z1Var);
            }
            return z1Var;
        } catch (Throwable th) {
            xe2.c(nr3.class).error("Failed {} to register {} as a JCE provider: {}", th.getClass().getSimpleName(), null, th.getMessage());
            st4.l("Failed to register null as a JCE provider", th);
            return null;
        }
    }

    public static int j(AtomicInteger atomicInteger, String str, int i2) {
        synchronized (atomicInteger) {
            try {
                int i3 = atomicInteger.get();
                if (i3 != 0) {
                    return i3;
                }
                String property = System.getProperty(str);
                boolean z = true;
                if (ga5.t(property)) {
                    while (true) {
                        if (i2 < 2048) {
                            i2 = -1;
                            break;
                        }
                        n12.j("Invalid max. key size: %d", i2 > 8, i2);
                        try {
                            BigInteger bit = BigInteger.ZERO.setBit(i2 - 1);
                            ((KeyPairGenerator) k(KeyPairGenerator.class, "DH", new sm("DH", 13)).a("DH")).initialize(new DHParameterSpec(bit, bit));
                            break;
                        } catch (GeneralSecurityException unused) {
                            i2 -= 1024;
                        }
                    }
                } else {
                    xe2.c(nr3.class).info("Override DH group exchange key size via {}: {}", str, property);
                    i2 = Integer.parseInt(property);
                    if (i2 == 0) {
                        z = false;
                    }
                    n12.j("Configured " + str + " value must be non-zero: %d", z, i2);
                }
                atomicInteger.set(i2);
                return i2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static jr3 k(Class cls, String str, Predicate predicate) {
        Map map;
        jr3 jr3Var;
        int iIndexOf;
        HashMap map2 = g;
        synchronized (map2) {
            map = (Map) Map.EL.computeIfAbsent(map2, cls, new hl(15));
        }
        if (!ga5.t(str) && Cipher.class.isAssignableFrom(cls) && (iIndexOf = str.indexOf(47)) > 0) {
            str = str.substring(0, iIndexOf);
        }
        synchronized (map) {
            jr3Var = (jr3) Map.EL.computeIfAbsent(map, str, new bm(1, cls, predicate));
        }
        return jr3Var;
    }
}
