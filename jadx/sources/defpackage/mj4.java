package defpackage;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class mj4 {
    public static final cj4 A;
    public static final p51 B;
    public static final cj4 a;
    public static final cj4 b;
    public static final gj4 c;
    public static final ej4 d;
    public static final ej4 e;
    public static final ej4 f;
    public static final ej4 g;
    public static final cj4 h;
    public static final cj4 i;
    public static final cj4 j;
    public static final ki4 k;
    public static final ej4 l;
    public static final pi4 m;
    public static final qi4 n;
    public static final ri4 o;
    public static final cj4 p;
    public static final cj4 q;
    public static final cj4 r;
    public static final cj4 s;
    public static final cj4 t;
    public static final cj4 u;
    public static final cj4 v;
    public static final cj4 w;
    public static final ht2 x;
    public static final cj4 y;
    public static final z42 z;

    static {
        int i2 = 0;
        a = new cj4(Class.class, new ti4().a(), i2);
        b = new cj4(BitSet.class, new dj4().a(), i2);
        fj4 fj4Var = new fj4();
        c = new gj4();
        d = new ej4(Boolean.TYPE, Boolean.class, fj4Var);
        e = new ej4(Byte.TYPE, Byte.class, new hj4());
        f = new ej4(Short.TYPE, Short.class, new ij4());
        g = new ej4(Integer.TYPE, Integer.class, new jj4());
        h = new cj4(AtomicInteger.class, new kj4().a(), i2);
        i = new cj4(AtomicBoolean.class, new lj4().a(), i2);
        j = new cj4(AtomicIntegerArray.class, new ji4().a(), i2);
        k = new ki4();
        new li4();
        new mi4();
        l = new ej4(Character.TYPE, Character.class, new ni4());
        oi4 oi4Var = new oi4();
        m = new pi4();
        n = new qi4();
        o = new ri4();
        p = new cj4(String.class, oi4Var, i2);
        q = new cj4(StringBuilder.class, new si4(), i2);
        r = new cj4(StringBuffer.class, new ui4(), i2);
        s = new cj4(URL.class, new vi4(), i2);
        t = new cj4(URI.class, new wi4(), i2);
        int i3 = 1;
        u = new cj4(InetAddress.class, new xi4(), i3);
        v = new cj4(UUID.class, new yi4(), i2);
        w = new cj4(Currency.class, new zi4().a(), i2);
        x = new ht2(new aj4(), i3);
        y = new cj4(Locale.class, new bj4(), i2);
        z42 z42Var = z42.a;
        z = z42Var;
        A = new cj4(y42.class, z42Var, i3);
        B = q51.d;
    }
}
