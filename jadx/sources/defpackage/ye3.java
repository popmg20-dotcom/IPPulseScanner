package defpackage;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ye3 {
    public final ab4 a;
    public final oe3 b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final a6 i;
    public final wn1 j;
    public final le3 k;
    public final boolean l;
    public t6 m;
    public e10 n;
    public em3 o;
    public final ae p;

    public ye3(ab4 ab4Var, oe3 oe3Var, int i, int i2, int i3, int i4, boolean z, boolean z2, a6 a6Var, wn1 wn1Var, le3 le3Var, cm2 cm2Var) {
        ab4Var.getClass();
        wn1Var.getClass();
        this.a = ab4Var;
        this.b = oe3Var;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = z;
        this.h = z2;
        this.i = a6Var;
        this.j = wn1Var;
        this.k = le3Var;
        this.l = !n12.c((String) cm2Var.z, "GET");
        this.p = new ae();
    }

    public final boolean a(me3 me3Var) {
        e10 e10Var;
        em3 em3Var;
        if (this.p.isEmpty() && this.o == null) {
            if (me3Var != null) {
                synchronized (me3Var) {
                    em3Var = null;
                    if (me3Var.l == 0 && me3Var.j && jz4.a(me3Var.c.a.i, this.i.i)) {
                        em3Var = me3Var.c;
                    }
                }
                if (em3Var != null) {
                    this.o = em3Var;
                    return true;
                }
            }
            t6 t6Var = this.m;
            if ((t6Var == null || t6Var.f >= ((ArrayList) t6Var.z).size()) && (e10Var = this.n) != null) {
                return e10Var.h();
            }
        }
        return true;
    }

    public final hm3 b() {
        Socket socketJ;
        el3 el3Var;
        me3 me3Var = this.k.y0;
        if (me3Var == null) {
            el3Var = null;
        } else {
            boolean zI = me3Var.i(this.l);
            synchronized (me3Var) {
                boolean z = me3Var.j;
                boolean z2 = true;
                try {
                    if (!zI) {
                        me3Var.j = true;
                        socketJ = this.k.j();
                    } else if (!z) {
                        ev1 ev1Var = me3Var.c.a.i;
                        ev1 ev1Var2 = this.i.i;
                        if (ev1Var.e != ev1Var2.e || !n12.c(ev1Var.d, ev1Var2.d)) {
                            z2 = false;
                        }
                        socketJ = !z2 ? this.k.j() : null;
                    }
                } finally {
                }
            }
            if (this.k.y0 == null) {
                if (socketJ != null) {
                    jz4.c(socketJ);
                }
                el3Var = null;
            } else {
                if (socketJ != null) {
                    xe.q("Check failed.");
                    return null;
                }
                el3Var = new el3(me3Var);
            }
        }
        if (el3Var != null) {
            return el3Var;
        }
        el3 el3VarE = e(null, null);
        if (el3VarE != null) {
            return el3VarE;
        }
        if (!this.p.isEmpty()) {
            return (hm3) this.p.removeFirst();
        }
        ta0 ta0VarC = c();
        el3 el3VarE2 = e(ta0VarC, ta0VarC.k);
        return el3VarE2 != null ? el3VarE2 : ta0VarC;
    }

    public final ta0 c() throws IOException {
        String hostAddress;
        int port;
        List listC;
        boolean zContains;
        List listK;
        em3 em3Var = this.o;
        if (em3Var != null) {
            this.o = null;
            return d(em3Var, null);
        }
        t6 t6Var = this.m;
        if (t6Var != null && t6Var.f < ((ArrayList) t6Var.z).size()) {
            int i = t6Var.f;
            ArrayList arrayList = (ArrayList) t6Var.z;
            if (i >= arrayList.size()) {
                vp1.g();
                return null;
            }
            int i2 = t6Var.f;
            t6Var.f = i2 + 1;
            return d((em3) arrayList.get(i2), null);
        }
        e10 e10Var = this.n;
        if (e10Var == null) {
            a6 a6Var = this.i;
            wn1 wn1Var = this.j;
            boolean z = this.h;
            wn1Var.getClass();
            e10Var = new e10();
            e10Var.z = a6Var;
            e10Var.A = wn1Var;
            e10Var.f = z;
            g41 g41Var = g41.b;
            e10Var.Y = g41Var;
            e10Var.Z = g41Var;
            e10Var.X = new ArrayList();
            ev1 ev1Var = a6Var.i;
            Proxy proxy = a6Var.g;
            if (proxy != null) {
                listK = p95.x(proxy);
            } else {
                URI uriI = ev1Var.i();
                if (uriI.getHost() == null) {
                    listK = jz4.k(new Proxy[]{Proxy.NO_PROXY});
                } else {
                    List<Proxy> listSelect = a6Var.h.select(uriI);
                    listK = (listSelect == null || listSelect.isEmpty()) ? jz4.k(new Proxy[]{Proxy.NO_PROXY}) : jz4.j(listSelect);
                }
            }
            e10Var.Y = listK;
            e10Var.b = 0;
            this.n = e10Var;
        }
        if (!e10Var.h()) {
            vp1.i("exhausted all routes");
            return null;
        }
        if (!e10Var.h()) {
            vp1.g();
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        while (e10Var.b < ((List) e10Var.Y).size()) {
            a6 a6Var2 = (a6) e10Var.z;
            if (e10Var.b >= ((List) e10Var.Y).size()) {
                throw new SocketException("No route to " + a6Var2.i.d + "; exhausted proxy configurations: " + ((List) e10Var.Y));
            }
            List list = (List) e10Var.Y;
            int i3 = e10Var.b;
            e10Var.b = i3 + 1;
            Proxy proxy2 = (Proxy) list.get(i3);
            ArrayList arrayList3 = new ArrayList();
            e10Var.Z = arrayList3;
            if (proxy2.type() == Proxy.Type.DIRECT || proxy2.type() == Proxy.Type.SOCKS) {
                ev1 ev1Var2 = a6Var2.i;
                hostAddress = ev1Var2.d;
                port = ev1Var2.e;
            } else {
                SocketAddress socketAddressAddress = proxy2.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    st4.o(socketAddressAddress.getClass(), "Proxy.address() is not an InetSocketAddress: ");
                    return null;
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address = inetSocketAddress.getAddress();
                if (address == null) {
                    hostAddress = inetSocketAddress.getHostName();
                    hostAddress.getClass();
                } else {
                    hostAddress = address.getHostAddress();
                    hostAddress.getClass();
                }
                port = inetSocketAddress.getPort();
            }
            if (1 > port || port >= 65536) {
                throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
            }
            if (proxy2.type() == Proxy.Type.SOCKS) {
                arrayList3.add(InetSocketAddress.createUnresolved(hostAddress, port));
            } else {
                uh3 uh3Var = fz4.a;
                hostAddress.getClass();
                if (fz4.a.d(hostAddress)) {
                    listC = p95.x(InetAddress.getByName(hostAddress));
                } else {
                    List listE = a6Var2.a.e(hostAddress);
                    if (listE.isEmpty()) {
                        throw new UnknownHostException(a6Var2.a + " returned no addresses for " + hostAddress);
                    }
                    listC = listE;
                }
                if (e10Var.f && listC.size() >= 2) {
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj : listC) {
                        if (((InetAddress) obj) instanceof Inet6Address) {
                            arrayList4.add(obj);
                        } else {
                            arrayList5.add(obj);
                        }
                    }
                    if (!arrayList4.isEmpty() && !arrayList5.isEmpty()) {
                        byte[] bArr = hz4.a;
                        Iterator it = arrayList4.iterator();
                        Iterator it2 = arrayList5.iterator();
                        ub2 ub2VarI = p95.i();
                        while (true) {
                            if (!it.hasNext() && !it2.hasNext()) {
                                break;
                            }
                            if (it.hasNext()) {
                                ub2VarI.add(it.next());
                            }
                            if (it2.hasNext()) {
                                ub2VarI.add(it2.next());
                            }
                        }
                        listC = p95.c(ub2VarI);
                    }
                }
                Iterator it3 = listC.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new InetSocketAddress((InetAddress) it3.next(), port));
                }
            }
            Iterator it4 = ((List) e10Var.Z).iterator();
            while (it4.hasNext()) {
                em3 em3Var2 = new em3((a6) e10Var.z, proxy2, (InetSocketAddress) it4.next());
                wn1 wn1Var2 = (wn1) e10Var.A;
                synchronized (wn1Var2) {
                    zContains = ((LinkedHashSet) wn1Var2.f).contains(em3Var2);
                }
                if (zContains) {
                    ((ArrayList) e10Var.X).add(em3Var2);
                } else {
                    arrayList2.add(em3Var2);
                }
            }
            if (!arrayList2.isEmpty()) {
                break;
            }
        }
        if (arrayList2.isEmpty()) {
            d70.U((ArrayList) e10Var.X, arrayList2);
            ((ArrayList) e10Var.X).clear();
        }
        t6 t6Var2 = new t6(arrayList2, 10);
        this.m = t6Var2;
        if (this.k.G0) {
            vp1.i("Canceled");
            return null;
        }
        if (t6Var2.f >= arrayList2.size()) {
            vp1.g();
            return null;
        }
        int i4 = t6Var2.f;
        t6Var2.f = i4 + 1;
        return d((em3) arrayList2.get(i4), arrayList2);
    }

    public final ta0 d(em3 em3Var, ArrayList arrayList) throws UnknownServiceException {
        ba3 ba3Var = ba3.H2_PRIOR_KNOWLEDGE;
        em3Var.getClass();
        a6 a6Var = em3Var.a;
        if (a6Var.c == null) {
            if (!a6Var.k.contains(db0.f)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String str = em3Var.a.i.d;
            k13 k13Var = k13.a;
            if (!k13.a.h(str)) {
                throw new UnknownServiceException(ha0.o("CLEARTEXT communication to ", str, " not permitted by network security policy"));
            }
        } else if (a6Var.j.contains(ba3Var)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        cm2 cm2Var = null;
        if (em3Var.b.type() == Proxy.Type.HTTP) {
            a6 a6Var2 = em3Var.a;
            if (a6Var2.c != null || a6Var2.j.contains(ba3Var)) {
                v92 v92Var = new v92(15);
                v92Var.b = em3Var.a.i;
                v92Var.m("CONNECT", null);
                a6 a6Var3 = em3Var.a;
                v92Var.l("Host", jz4.i(a6Var3.i, true));
                v92Var.l("Proxy-Connection", "Keep-Alive");
                v92Var.l("User-Agent", "okhttp/5.3.2");
                cm2 cm2Var2 = new cm2(v92Var);
                nk3 nk3Var = ok3.f;
                p84 p84Var = fg4.W;
                m20 m20Var = new m20(1);
                ba3 ba3Var2 = ba3.HTTP_1_1;
                gb4.O("Proxy-Authenticate");
                gb4.P("OkHttp-Preemptive", "Proxy-Authenticate");
                m20Var.a("Proxy-Authenticate");
                gb4.x(m20Var, "Proxy-Authenticate", "OkHttp-Preemptive");
                cm2 cm2VarH = a6Var3.f.h(em3Var, new kk3(cm2Var2, ba3Var2, "Preemptive Authenticate", 407, null, gb4.y(m20Var), nk3Var, null, null, null, null, -1L, -1L, null, p84Var));
                cm2Var = cm2VarH == null ? cm2Var2 : cm2VarH;
            }
        }
        return new ta0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.k, this, em3Var, arrayList, 0, cm2Var, -1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:14:0x0033, B:22:0x0040, B:25:0x0047), top: B:53:0x0033 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.el3 e(defpackage.ta0 r11, java.util.List r12) {
        /*
            r10 = this;
            oe3 r0 = r10.b
            boolean r1 = r10.l
            a6 r2 = r10.i
            le3 r3 = r10.k
            r4 = 0
            r5 = 1
            if (r11 == 0) goto L14
            boolean r6 = r11.isReady()
            if (r6 == 0) goto L14
            r6 = r5
            goto L15
        L14:
            r6 = r4
        L15:
            java.lang.Object r0 = r0.e
            java.util.concurrent.ConcurrentLinkedQueue r0 = (java.util.concurrent.ConcurrentLinkedQueue) r0
            java.util.Iterator r0 = r0.iterator()
            r0.getClass()
        L20:
            boolean r7 = r0.hasNext()
            r8 = 0
            if (r7 == 0) goto L68
            java.lang.Object r7 = r0.next()
            me3 r7 = (defpackage.me3) r7
            r7.getClass()
            monitor-enter(r7)
            if (r6 == 0) goto L40
            fu1 r9 = r7.i     // Catch: java.lang.Throwable -> L3e
            if (r9 == 0) goto L39
            r9 = r5
            goto L3a
        L39:
            r9 = r4
        L3a:
            if (r9 != 0) goto L40
        L3c:
            r9 = r4
            goto L4b
        L3e:
            r10 = move-exception
            goto L66
        L40:
            boolean r9 = r7.h(r2, r12)     // Catch: java.lang.Throwable -> L3e
            if (r9 != 0) goto L47
            goto L3c
        L47:
            r3.a(r7)     // Catch: java.lang.Throwable -> L3e
            r9 = r5
        L4b:
            monitor-exit(r7)
            if (r9 == 0) goto L20
            boolean r9 = r7.i(r1)
            if (r9 == 0) goto L55
            goto L69
        L55:
            monitor-enter(r7)
            r7.j = r5     // Catch: java.lang.Throwable -> L63
            java.net.Socket r8 = r3.j()     // Catch: java.lang.Throwable -> L63
            monitor-exit(r7)
            if (r8 == 0) goto L20
            defpackage.jz4.c(r8)
            goto L20
        L63:
            r10 = move-exception
            monitor-exit(r7)
            throw r10
        L66:
            monitor-exit(r7)
            throw r10
        L68:
            r7 = r8
        L69:
            if (r7 != 0) goto L6c
            return r8
        L6c:
            if (r11 == 0) goto L79
            em3 r12 = r11.j
            r10.o = r12
            java.net.Socket r10 = r11.r
            if (r10 == 0) goto L79
            defpackage.jz4.c(r10)
        L79:
            el3 r10 = new el3
            r10.<init>(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye3.e(ta0, java.util.List):el3");
    }
}
