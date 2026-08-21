package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ta0 implements hm3, q61 {
    public final ab4 a;
    public final oe3 b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final le3 h;
    public final ye3 i;
    public final em3 j;
    public final List k;
    public final int l;
    public final cm2 m;
    public final int n;
    public final boolean o;
    public volatile boolean p;
    public Socket q;
    public Socket r;
    public zq1 s;
    public ba3 t;
    public ed4 u;
    public me3 v;

    public ta0(ab4 ab4Var, oe3 oe3Var, int i, int i2, int i3, int i4, boolean z, le3 le3Var, ye3 ye3Var, em3 em3Var, List list, int i5, cm2 cm2Var, int i6, boolean z2) {
        ab4Var.getClass();
        em3Var.getClass();
        this.a = ab4Var;
        this.b = oe3Var;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = z;
        this.h = le3Var;
        this.i = ye3Var;
        this.j = em3Var;
        this.k = list;
        this.l = i5;
        this.m = cm2Var;
        this.n = i6;
        this.o = z2;
    }

    public static ta0 k(ta0 ta0Var, int i, cm2 cm2Var, int i2, boolean z, int i3) {
        return new ta0(ta0Var.a, ta0Var.b, ta0Var.c, ta0Var.d, ta0Var.e, ta0Var.f, ta0Var.g, ta0Var.h, ta0Var.i, ta0Var.j, ta0Var.k, (i3 & 1) != 0 ? ta0Var.l : i, (i3 & 2) != 0 ? ta0Var.m : cm2Var, (i3 & 4) != 0 ? ta0Var.n : i2, (i3 & 8) != 0 ? ta0Var.o : z);
    }

    @Override // defpackage.hm3
    public final hm3 a() {
        return new ta0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    @Override // defpackage.hm3
    public final me3 b() {
        this.h.b.C.z(this.j);
        me3 me3Var = this.v;
        me3Var.getClass();
        this.j.getClass();
        el3 el3VarE = this.i.e(this, this.k);
        if (el3VarE != null) {
            return el3VarE.a;
        }
        synchronized (me3Var) {
            oe3 oe3Var = this.b;
            TimeZone timeZone = jz4.a;
            ((ConcurrentLinkedQueue) oe3Var.e).add(me3Var);
            ((za4) oe3Var.c).d((ne3) oe3Var.d, 0L);
            this.h.a(me3Var);
        }
        return me3Var;
    }

    @Override // defpackage.hm3
    public final gm3 c() {
        Socket socket;
        Socket socket2;
        em3 em3Var = this.j;
        CopyOnWriteArrayList copyOnWriteArrayList = this.h.I0;
        if (this.q != null) {
            xe.q("TCP already connected");
            return null;
        }
        copyOnWriteArrayList.add(this);
        boolean z = false;
        try {
            try {
                em3Var.c.getClass();
                h();
                z = true;
                gm3 gm3Var = new gm3(this, null, null, 6);
                copyOnWriteArrayList.remove(this);
                return gm3Var;
            } catch (IOException e) {
                if (em3Var.a.g == null && em3Var.b.type() != Proxy.Type.DIRECT) {
                    a6 a6Var = em3Var.a;
                    a6Var.h.connectFailed(a6Var.i.i(), em3Var.b.address(), e);
                }
                em3Var.c.getClass();
                gm3 gm3Var2 = new gm3(this, null, e, 2);
                copyOnWriteArrayList.remove(this);
                if (!z && (socket = this.q) != null) {
                    jz4.c(socket);
                }
                return gm3Var2;
            }
        } catch (Throwable th) {
            copyOnWriteArrayList.remove(this);
            if (!z && (socket2 = this.q) != null) {
                jz4.c(socket2);
            }
            throw th;
        }
    }

    @Override // defpackage.hm3
    public final void cancel() {
        this.p = true;
        Socket socket = this.q;
        if (socket != null) {
            jz4.c(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x012a  */
    @Override // defpackage.hm3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final gm3 f() throws Throwable {
        ta0 ta0VarL;
        ta0 ta0Var;
        CopyOnWriteArrayList copyOnWriteArrayList = this.h.I0;
        Socket socket = this.q;
        ta0 ta0Var2 = null;
        if (socket == null) {
            xe.k("TCP not connected");
            return null;
        }
        if (isReady()) {
            xe.q("already connected");
            return null;
        }
        em3 em3Var = this.j;
        a6 a6Var = em3Var.a;
        InetSocketAddress inetSocketAddress = em3Var.c;
        a6 a6Var2 = em3Var.a;
        List list = a6Var.k;
        copyOnWriteArrayList.add(this);
        boolean z = false;
        try {
            try {
                if (this.m != null) {
                    gm3 gm3VarJ = j();
                    if (gm3VarJ.b != null || gm3VarJ.c != null) {
                        copyOnWriteArrayList.remove(this);
                        Socket socket2 = this.r;
                        if (socket2 != null) {
                            jz4.c(socket2);
                        }
                        jz4.c(socket);
                        return gm3VarJ;
                    }
                }
                if (a6Var2.c != null) {
                    ed4 ed4Var = this.u;
                    if (ed4Var == null) {
                        n12.T("socket");
                        throw null;
                    }
                    if (((he3) ed4Var.z).f.x()) {
                        ed4 ed4Var2 = this.u;
                        if (ed4Var2 == null) {
                            n12.T("socket");
                            throw null;
                        }
                        if (((ge3) ed4Var2.A).f.x()) {
                            SSLSocketFactory sSLSocketFactory = a6Var2.c;
                            ev1 ev1Var = a6Var2.i;
                            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, ev1Var.d, ev1Var.e, true);
                            socketCreateSocket.getClass();
                            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
                            ta0 ta0VarM = m(sSLSocket, list);
                            db0 db0Var = (db0) list.get(ta0VarM.n);
                            ta0VarL = ta0VarM.l(sSLSocket, list);
                            try {
                                db0Var.a(sSLSocket, ta0VarM.o);
                                i(sSLSocket, db0Var);
                                ta0Var = ta0VarL;
                            } catch (IOException e) {
                                e = e;
                                inetSocketAddress.getClass();
                                if (this.g && !(e instanceof ProtocolException) && !(e instanceof InterruptedIOException) && ((!(e instanceof SSLHandshakeException) || !(e.getCause() instanceof CertificateException)) && !(e instanceof SSLPeerUnverifiedException) && (e instanceof SSLException))) {
                                    ta0Var2 = ta0VarL;
                                }
                                gm3 gm3Var = new gm3(this, ta0Var2, e);
                                copyOnWriteArrayList.remove(this);
                                if (!z) {
                                    Socket socket3 = this.r;
                                    if (socket3 != null) {
                                        jz4.c(socket3);
                                    }
                                    jz4.c(socket);
                                }
                                return gm3Var;
                            }
                        }
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                this.r = socket;
                List list2 = a6Var2.j;
                ba3 ba3Var = ba3.H2_PRIOR_KNOWLEDGE;
                if (!list2.contains(ba3Var)) {
                    ba3Var = ba3.HTTP_1_1;
                }
                this.t = ba3Var;
                ta0Var = null;
                try {
                    ab4 ab4Var = this.a;
                    oe3 oe3Var = this.b;
                    em3 em3Var2 = this.j;
                    Socket socket4 = this.r;
                    socket4.getClass();
                    zq1 zq1Var = this.s;
                    ba3 ba3Var2 = this.t;
                    ba3Var2.getClass();
                    ed4 ed4Var3 = this.u;
                    if (ed4Var3 == null) {
                        n12.T("socket");
                        throw null;
                    }
                    me3 me3Var = new me3(ab4Var, oe3Var, em3Var2, socket, socket4, zq1Var, ba3Var2, ed4Var3);
                    this.v = me3Var;
                    me3Var.j();
                    inetSocketAddress.getClass();
                    try {
                        gm3 gm3Var2 = new gm3(this, null, null, 6);
                        copyOnWriteArrayList.remove(this);
                        return gm3Var2;
                    } catch (IOException e2) {
                        e = e2;
                        z = true;
                        ta0VarL = ta0Var;
                        inetSocketAddress.getClass();
                        if (this.g) {
                            ta0Var2 = ta0VarL;
                        }
                        gm3 gm3Var3 = new gm3(this, ta0Var2, e);
                        copyOnWriteArrayList.remove(this);
                        if (!z) {
                        }
                        return gm3Var3;
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        copyOnWriteArrayList.remove(this);
                        if (!z) {
                            Socket socket5 = this.r;
                            if (socket5 != null) {
                                jz4.c(socket5);
                            }
                            jz4.c(socket);
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
            ta0VarL = null;
        }
    }

    @Override // defpackage.q61
    public final em3 g() {
        return this.j;
    }

    public final void h() throws IOException {
        Socket socketCreateSocket;
        Proxy.Type type = this.j.b.type();
        int i = type == null ? -1 : sa0.a[type.ordinal()];
        if (i == 1 || i == 2) {
            socketCreateSocket = this.j.a.b.createSocket();
            socketCreateSocket.getClass();
        } else {
            socketCreateSocket = new Socket(this.j.b);
        }
        this.q = socketCreateSocket;
        if (this.p) {
            vp1.i("canceled");
            return;
        }
        socketCreateSocket.setSoTimeout(this.f);
        try {
            k13 k13Var = k13.a;
            k13.a.e(socketCreateSocket, this.j.c, this.e);
            try {
                this.u = new ed4(new iv1(socketCreateSocket));
            } catch (NullPointerException e) {
                if (n12.c(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.j.c);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void i(SSLSocket sSLSocket, db0 db0Var) {
        ba3 ba3VarK;
        a6 a6Var = this.j.a;
        try {
            if (db0Var.b) {
                k13 k13Var = k13.a;
                k13.a.d(sSLSocket, a6Var.i.d, a6Var.j);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            session.getClass();
            zq1 zq1VarQ = co4.q(session);
            HostnameVerifier hostnameVerifier = a6Var.d;
            hostnameVerifier.getClass();
            if (hostnameVerifier.verify(a6Var.i.d, session)) {
                n20 n20Var = a6Var.e;
                n20Var.getClass();
                this.s = new zq1(zq1VarQ.a, zq1VarQ.b, zq1VarQ.c, new b4(1, n20Var, zq1VarQ, a6Var));
                a6Var.i.d.getClass();
                Iterator it = n20Var.a.iterator();
                String strF = null;
                if (it.hasNext()) {
                    dw2.I(it.next());
                    throw null;
                }
                if (db0Var.b) {
                    k13 k13Var2 = k13.a;
                    strF = k13.a.f(sSLSocket);
                }
                this.r = sSLSocket;
                this.u = new ed4(new iv1(sSLSocket));
                if (strF != null) {
                    ba3.f.getClass();
                    ba3VarK = d7.k(strF);
                } else {
                    ba3VarK = ba3.HTTP_1_1;
                }
                this.t = ba3VarK;
                k13 k13Var3 = k13.a;
                k13.a.getClass();
                return;
            }
            List listA = zq1VarQ.a();
            if (listA.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + a6Var.i.d + " not verified (no certificates)");
            }
            Object obj = listA.get(0);
            obj.getClass();
            X509Certificate x509Certificate = (X509Certificate) obj;
            StringBuilder sb = new StringBuilder("\n            |Hostname ");
            sb.append(a6Var.i.d);
            sb.append(" not verified:\n            |    certificate: ");
            n20 n20Var2 = n20.c;
            bu buVar = bu.A;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            encoded.getClass();
            sb.append("sha256/".concat(a.a(t60.p(encoded).c("SHA-256").b, a.a)));
            sb.append("\n            |    DN: ");
            sb.append(x509Certificate.getSubjectDN().getName());
            sb.append("\n            |    subjectAltNames: ");
            sb.append(d70.m0(ju2.a(x509Certificate, 7), ju2.a(x509Certificate, 2)));
            sb.append("\n            ");
            throw new SSLPeerUnverifiedException(q44.c0(sb.toString()));
        } catch (Throwable th) {
            k13 k13Var4 = k13.a;
            k13.a.getClass();
            jz4.c(sSLSocket);
            throw th;
        }
    }

    @Override // defpackage.hm3
    public final boolean isReady() {
        return this.t != null;
    }

    public final gm3 j() throws IOException {
        cm2 cm2Var;
        cm2 cm2Var2 = this.m;
        cm2Var2.getClass();
        em3 em3Var = this.j;
        a6 a6Var = em3Var.a;
        InetSocketAddress inetSocketAddress = em3Var.c;
        String str = "CONNECT " + jz4.i(a6Var.i, true) + " HTTP/1.1";
        while (true) {
            ed4 ed4Var = this.u;
            if (ed4Var == null) {
                n12.T("socket");
                throw null;
            }
            wt1 wt1Var = new wt1(null, this, ed4Var);
            ed4 ed4Var2 = this.u;
            if (ed4Var2 == null) {
                n12.T("socket");
                throw null;
            }
            ((he3) ed4Var2.z).b.i().g(this.c);
            ed4 ed4Var3 = this.u;
            if (ed4Var3 == null) {
                n12.T("socket");
                throw null;
            }
            ((ge3) ed4Var3.A).b.i().g(this.d);
            wt1Var.l((lr1) cm2Var2.A, str);
            wt1Var.a();
            jk3 jk3VarD = wt1Var.d(false);
            jk3VarD.getClass();
            jk3VarD.a = cm2Var2;
            kk3 kk3VarA = jk3VarD.a();
            int i = kk3VarA.A;
            long jE = jz4.e(kk3VarA);
            if (jE != -1) {
                tt1 tt1VarK = wt1Var.k((ev1) kk3VarA.b.f, jE);
                jz4.g(tt1VarK, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
                tt1VarK.close();
            }
            if (i == 200) {
                cm2Var = null;
                break;
            }
            if (i != 407) {
                vp1.i(dw2.A(i, "Unexpected response code for CONNECT: "));
                return null;
            }
            cm2 cm2VarH = em3Var.a.f.h(em3Var, kk3VarA);
            if (cm2VarH == null) {
                vp1.i("Failed to authenticate with proxy");
                return null;
            }
            if ("close".equalsIgnoreCase(kk3.g(kk3VarA, "Connection"))) {
                cm2Var = cm2VarH;
                break;
            }
            cm2Var2 = cm2VarH;
        }
        if (cm2Var == null) {
            return new gm3(this, null, null, 6);
        }
        Socket socket = this.q;
        if (socket != null) {
            jz4.c(socket);
        }
        int i2 = this.l + 1;
        if (i2 < 21) {
            inetSocketAddress.getClass();
            return new gm3(this, k(this, i2, cm2Var, 0, false, 12), null, 4);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        inetSocketAddress.getClass();
        return new gm3(this, null, protocolException, 2);
    }

    public final ta0 l(SSLSocket sSLSocket, List list) {
        String[] strArr;
        String[] strArr2;
        int i = this.n;
        int size = list.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            db0 db0Var = (db0) list.get(i2);
            db0Var.getClass();
            if (db0Var.a && (((strArr = db0Var.d) == null || hz4.e(strArr, sSLSocket.getEnabledProtocols(), ep2.f)) && ((strArr2 = db0Var.c) == null || hz4.e(strArr2, sSLSocket.getEnabledCipherSuites(), w40.c)))) {
                return k(this, 0, null, i2, i != -1, 3);
            }
        }
        return null;
    }

    public final ta0 m(SSLSocket sSLSocket, List list) throws UnknownServiceException {
        if (this.n != -1) {
            return this;
        }
        ta0 ta0VarL = l(sSLSocket, list);
        if (ta0VarL != null) {
            return ta0VarL;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.o);
        sb.append(", modes=");
        sb.append(list);
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        enabledProtocols.getClass();
        String string = Arrays.toString(enabledProtocols);
        string.getClass();
        sb.append(", supported protocols=");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // defpackage.q61
    public final void d() {
    }

    @Override // defpackage.q61
    public final void e(le3 le3Var, IOException iOException) {
    }
}
