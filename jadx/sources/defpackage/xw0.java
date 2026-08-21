package defpackage;

import android.net.Network;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DefaultDnsPtrRecord;
import io.netty.handler.codec.dns.DefaultDnsRawRecord;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xw0 {
    public static final pj2 e;
    public final lu2 a;
    public final ce0 b;
    public Network c;
    public final vw0 d;

    static {
        uh3 uh3Var = pj2.e;
        e = p95.n("application/dns-message");
    }

    public xw0(long j) {
        ku2 ku2Var = new ku2();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        ku2Var.y = jz4.b(j, timeUnit);
        ku2Var.z = jz4.b(j, timeUnit);
        this.a = new lu2(ku2Var);
        gm0 gm0Var = qv0.a;
        pl0 pl0Var = pl0.z;
        r54 r54VarD = gb4.d();
        pl0Var.getClass();
        this.b = p95.a(tj4.W(pl0Var, r54VarD));
        this.d = new vw0(128, 0.75f, true, 0);
    }

    public final void a(DefaultDnsResponse defaultDnsResponse, byte[] bArr) {
        defaultDnsResponse.getClass();
        bArr.getClass();
        DnsQuestion dnsQuestion = (DnsQuestion) defaultDnsResponse.recordAt(DnsSection.QUESTION);
        if (dnsQuestion == null) {
            return;
        }
        String strName = dnsQuestion.name();
        strName.getClass();
        String strG0 = p44.G0(".", strName);
        DnsRecordType dnsRecordTypeType = dnsQuestion.type();
        int iCount = defaultDnsResponse.count(DnsSection.ANSWER);
        long j = Long.MAX_VALUE;
        for (int i = 0; i < iCount; i++) {
            try {
                long jTimeToLive = defaultDnsResponse.recordAt(DnsSection.ANSWER, i).timeToLive();
                if (jTimeToLive < j) {
                    j = jTimeToLive;
                }
            } catch (Exception e2) {
                String strN = ha0.n("Failed to extract TTL from record in ANSWER: ", e2.getMessage());
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "DoHResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.o("DoHResolver", strN, null);
                }
            }
        }
        if (j == Long.MAX_VALUE) {
            j = 0;
        }
        if (j > 0) {
            long jElapsedRealtime = (j * 1000) + SystemClock.elapsedRealtime();
            synchronized (this.d) {
                vw0 vw0Var = this.d;
                dnsRecordTypeType.getClass();
                vw0Var.put(new uw0(strG0, dnsRecordTypeType), new tw0(bArr, jElapsedRealtime));
            }
        }
    }

    public final byte[] b(String str, String str2, byte[] bArr) throws IOException {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Network network = this.c;
        if (network == null) {
            xe.q("DoH query without binding no active network available");
            return null;
        }
        str2.getClass();
        dv1 dv1Var = new dv1();
        dv1Var.c(null, str2);
        ev1 ev1VarA = dv1Var.a();
        v92 v92Var = new v92(15);
        v92Var.b = ev1VarA;
        cj3 cj3Var = ej3.a;
        pj2 pj2Var = e;
        int length = bArr.length;
        hz4.a(bArr.length, 0L, length);
        v92Var.m("POST", new dj3(pj2Var, length, bArr));
        v92Var.l("Accept", "application/dns-message");
        cm2 cm2Var = new cm2(v92Var);
        ku2 ku2VarA = this.a.a();
        SocketFactory socketFactory = network.getSocketFactory();
        socketFactory.getClass();
        ku2VarA.b(socketFactory);
        Proxy proxy = Proxy.NO_PROXY;
        if (!n12.c(proxy, ku2VarA.m)) {
            ku2VarA.D = null;
        }
        ku2VarA.m = proxy;
        ku2VarA.a(new ed(6, network, ev1VarA));
        kk3 kk3VarE = new le3(new lu2(ku2VarA), cm2Var).e();
        try {
            if (kk3VarE.H0) {
                String str9 = "DoH query success: " + ke0.J(str) + " -> " + str2;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "DoHResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str9);
                    str7 = "DoHResolver";
                    str8 = str9;
                } else {
                    str7 = "DoHResolver";
                    str8 = str9;
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d(str7, str8, null);
                }
                byte[] bArrG = kk3VarE.Z.g();
                kk3VarE.close();
                return bArrG;
            }
            String str10 = "DoH request failed with code " + kk3VarE.A + " " + kk3VarE.z + ": " + ke0.J(str) + " -> " + str2;
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "DoHResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str10);
                str3 = "DoHResolver";
                str4 = str10;
            } else {
                str3 = "DoHResolver";
                str4 = str10;
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e(str3, str4, null);
            }
            String str11 = "DoH response: " + kk3VarE.Z.C();
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "DoHResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str11);
                str5 = "DoHResolver";
                str6 = str11;
            } else {
                str5 = "DoHResolver";
                str6 = str11;
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e(str5, str6, null);
            }
            throw new IOException("DoH request failed with code " + kk3VarE.A);
        } finally {
        }
    }

    public final e03 c(String str, DnsRecordType dnsRecordType, int i) {
        long j;
        DnsRecord defaultDnsPtrRecord;
        synchronized (this.d) {
            uw0 uw0Var = new uw0(str, dnsRecordType);
            tw0 tw0Var = (tw0) this.d.get(uw0Var);
            if (tw0Var == null) {
                return null;
            }
            if (SystemClock.elapsedRealtime() > tw0Var.b) {
                this.d.remove(uw0Var);
                return null;
            }
            DefaultDnsResponse defaultDnsResponseS = je.S(tw0Var.a);
            if (defaultDnsResponseS == null) {
                return null;
            }
            long jElapsedRealtime = (tw0Var.b - SystemClock.elapsedRealtime()) / 1000;
            long j2 = jElapsedRealtime < 1 ? 1L : jElapsedRealtime;
            int iCount = defaultDnsResponseS.count(DnsSection.ANSWER);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < iCount) {
                DnsRecord dnsRecordRecordAt = defaultDnsResponseS.recordAt(DnsSection.ANSWER, i2);
                if (dnsRecordRecordAt instanceof DefaultDnsRawRecord) {
                    DefaultDnsRawRecord defaultDnsRawRecord = (DefaultDnsRawRecord) dnsRecordRecordAt;
                    j = j2;
                    defaultDnsPtrRecord = new DefaultDnsRawRecord(defaultDnsRawRecord.name(), defaultDnsRawRecord.type(), defaultDnsRawRecord.dnsClass(), j, defaultDnsRawRecord.content().retain());
                } else {
                    j = j2;
                    if (dnsRecordRecordAt instanceof DefaultDnsPtrRecord) {
                        DefaultDnsPtrRecord defaultDnsPtrRecord2 = (DefaultDnsPtrRecord) dnsRecordRecordAt;
                        defaultDnsPtrRecord = new DefaultDnsPtrRecord(defaultDnsPtrRecord2.name(), defaultDnsPtrRecord2.dnsClass(), j, defaultDnsPtrRecord2.hostname());
                        j = j;
                    } else {
                        dnsRecordRecordAt.getClass();
                        arrayList.add(dnsRecordRecordAt);
                        i2++;
                        j2 = j;
                    }
                }
                dnsRecordRecordAt = defaultDnsPtrRecord;
                dnsRecordRecordAt.getClass();
                arrayList.add(dnsRecordRecordAt);
                i2++;
                j2 = j;
            }
            while (true) {
                DnsSection dnsSection = DnsSection.ANSWER;
                if (defaultDnsResponseS.count(dnsSection) <= 0) {
                    break;
                }
                DnsRecord dnsRecordRemoveRecord = defaultDnsResponseS.removeRecord(dnsSection, 0);
                if (!arrayList.contains(dnsRecordRemoveRecord)) {
                    ReferenceCountUtil.release(dnsRecordRemoveRecord);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                defaultDnsResponseS.addRecord(DnsSection.ANSWER, (DnsRecord) it.next());
            }
            defaultDnsResponseS.setId(i);
            return new e03(defaultDnsResponseS, je.D(defaultDnsResponseS));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.util.List r5, defpackage.ie0 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.ww0
            if (r0 == 0) goto L13
            r0 = r6
            ww0 r0 = (defpackage.ww0) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            ww0 r0 = new ww0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.A
            int r1 = r0.Y
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            defpackage.n12.S(r6)
            goto L40
        L26:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            return r2
        L2c:
            defpackage.n12.S(r6)
            uf r6 = new uf
            r1 = 7
            r6.<init>(r5, r4, r2, r1)
            r0.Y = r3
            java.lang.Object r6 = defpackage.p95.h(r6, r0)
            mf0 r4 = defpackage.mf0.b
            if (r6 != r4) goto L40
            return r4
        L40:
            uk3 r6 = (defpackage.uk3) r6
            java.lang.Object r4 = r6.b
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xw0.d(java.util.List, ie0):java.lang.Object");
    }
}
