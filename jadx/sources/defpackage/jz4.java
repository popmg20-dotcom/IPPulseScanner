package defpackage;

import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.DesugarCollections;
import j$.util.DesugarTimeZone;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jz4 {
    public static final TimeZone a;
    public static final String b;

    static {
        TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT");
        timeZone.getClass();
        a = timeZone;
        b = p44.G0("Client", p44.F0(lu2.class.getName(), "okhttp3."));
    }

    public static final boolean a(ev1 ev1Var, ev1 ev1Var2) {
        ev1Var.getClass();
        return n12.c(ev1Var.d, ev1Var2.d) && ev1Var.e == ev1Var2.e && n12.c(ev1Var.a, ev1Var2.a);
    }

    public static final int b(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j < 0) {
            g.g(RtspHeaders.Values.TIMEOUT.concat(" < 0"));
            return 0;
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            e04.f(RtspHeaders.Values.TIMEOUT.concat(" too large"));
            return 0;
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        e04.f(RtspHeaders.Values.TIMEOUT.concat(" too small"));
        return 0;
    }

    public static final void c(Socket socket) {
        socket.getClass();
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!n12.c(e2.getMessage(), "bio == null")) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final String d(String str, Object... objArr) {
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final long e(kk3 kk3Var) {
        String strA = kk3Var.Y.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        byte[] bArr = hz4.a;
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final Charset f(cq cqVar, Charset charset) {
        cqVar.getClass();
        charset.getClass();
        int iD = cqVar.D(hz4.b);
        if (iD == -1) {
            return charset;
        }
        if (iD == 0) {
            return y30.a;
        }
        if (iD == 1) {
            return y30.b;
        }
        if (iD == 2) {
            Charset charset2 = y30.a;
            Charset charset3 = y30.d;
            if (charset3 != null) {
                return charset3;
            }
            Charset charsetForName = Charset.forName("UTF-32LE");
            charsetForName.getClass();
            y30.d = charsetForName;
            return charsetForName;
        }
        if (iD == 3) {
            return y30.c;
        }
        if (iD != 4) {
            throw new AssertionError();
        }
        Charset charset4 = y30.a;
        Charset charset5 = y30.e;
        if (charset5 != null) {
            return charset5;
        }
        Charset charsetForName2 = Charset.forName("UTF-32BE");
        charsetForName2.getClass();
        y30.e = charsetForName2;
        return charsetForName2;
    }

    public static final boolean g(lz3 lz3Var, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        long jNanoTime = System.nanoTime();
        long jC = lz3Var.i().e() ? lz3Var.i().c() - jNanoTime : Long.MAX_VALUE;
        lz3Var.i().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            hp hpVar = new hp();
            while (lz3Var.t0(hpVar, 8192L) != -1) {
                hpVar.z0(hpVar.f);
            }
            if (jC == Long.MAX_VALUE) {
                lz3Var.i().a();
                return true;
            }
            lz3Var.i().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                lz3Var.i().a();
                return false;
            }
            lz3Var.i().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                lz3Var.i().a();
            } else {
                lz3Var.i().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final lr1 h(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hr1 hr1Var = (hr1) it.next();
            bu buVar = hr1Var.a;
            bu buVar2 = hr1Var.b;
            String strR = buVar.r();
            String strR2 = buVar2.r();
            arrayList.add(strR);
            arrayList.add(p44.U0(strR2).toString());
        }
        return new lr1((String[]) arrayList.toArray(new String[0]));
    }

    public static final String i(ev1 ev1Var, boolean z) {
        ev1Var.getClass();
        int i = ev1Var.e;
        String str = ev1Var.d;
        if (p44.o0(str, ":", false)) {
            str = "[" + str + ']';
        }
        if (!z) {
            String str2 = ev1Var.a;
            str2.getClass();
            if (i == (str2.equals("http") ? 80 : str2.equals("https") ? 443 : -1)) {
                return str;
            }
        }
        return str + ':' + i;
    }

    public static final List j(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return g41.b;
        }
        if (list.size() == 1) {
            List listSingletonList = Collections.singletonList(list.get(0));
            listSingletonList.getClass();
            return listSingletonList;
        }
        Object[] array = list.toArray();
        array.getClass();
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        List listUnmodifiableList = DesugarCollections.unmodifiableList(listAsList);
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final List k(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return g41.b;
        }
        if (objArr.length == 1) {
            List listSingletonList = Collections.singletonList(objArr[0]);
            listSingletonList.getClass();
            return listSingletonList;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        objArr2.getClass();
        List listAsList = Arrays.asList(objArr2);
        listAsList.getClass();
        List listUnmodifiableList = DesugarCollections.unmodifiableList(listAsList);
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }
}
