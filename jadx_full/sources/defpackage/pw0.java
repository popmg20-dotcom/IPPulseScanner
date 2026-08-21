package defpackage;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pw0 implements nw0 {
    public static final pj2 z;
    public final lu2 b;
    public final ev1 f;

    static {
        uh3 uh3Var = pj2.e;
        z = p95.n("application/dns-message");
    }

    public pw0(lu2 lu2Var, ev1 ev1Var) {
        this.b = lu2Var;
        this.f = ev1Var;
    }

    public static ArrayList b(kk3 kk3Var, String str) {
        ba3 ba3Var;
        if (kk3Var.A0 == null && (ba3Var = kk3Var.f) != ba3.HTTP_2 && ba3Var != ba3.QUIC) {
            k13 k13Var = k13.a;
            k13.a.i(5, "Incorrect protocol: " + kk3Var.f, null);
        }
        try {
            if (!kk3Var.H0) {
                throw new IOException("response: " + kk3Var.A + ' ' + kk3Var.z);
            }
            ok3 ok3Var = kk3Var.Z;
            if (ok3Var.n() <= 65536) {
                ArrayList arrayListA = qw0.a(ok3Var.x().f0(), str);
                kk3Var.close();
                return arrayListA;
            }
            throw new IOException("response size exceeds limit (65536 bytes): " + ok3Var.n() + " bytes");
        } finally {
        }
    }

    public final cm2 a(int i, String str) {
        List<String> listV0;
        v92 v92Var = new v92(15);
        v92Var.l("Accept", z.a);
        int i2 = qw0.a;
        str.getClass();
        hp hpVar = new hp();
        hpVar.N0(0);
        hpVar.N0(256);
        hpVar.N0(1);
        hpVar.N0(0);
        hpVar.N0(0);
        hpVar.N0(0);
        hp hpVar2 = new hp();
        List listK0 = p44.K0(str, new char[]{'.'}, 6);
        if (listK0.isEmpty()) {
            listV0 = g41.b;
        } else {
            ListIterator listIterator = listK0.listIterator(listK0.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listV0 = d70.v0(listIterator.nextIndex() + 1, listK0);
                    break;
                }
            }
            listV0 = g41.b;
        }
        for (String str2 : listV0) {
            long jB = ke0.B(str2);
            if (jB != str2.length()) {
                e04.f("non-ascii hostname: ".concat(str));
                return null;
            }
            hpVar2.J0((int) jB);
            hpVar2.Q0(str2);
        }
        hpVar2.J0(0);
        hpVar2.n(hpVar, 0L, hpVar2.f);
        hpVar.N0(i);
        hpVar.N0(1);
        String strI0 = w44.i0(hpVar.Z(hpVar.f).a(), "=", "");
        dv1 dv1VarG = this.f.g();
        ArrayList arrayList = dv1VarG.g;
        if (arrayList == null) {
            arrayList = new ArrayList();
            dv1VarG.g = arrayList;
        }
        arrayList.add(ez4.j(0, 0, 91, "dns", " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false));
        ArrayList arrayList2 = dv1VarG.g;
        arrayList2.getClass();
        arrayList2.add(ez4.j(0, 0, 91, strI0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false));
        v92Var.b = dv1VarG.a();
        return new cm2(v92Var);
    }

    @Override // defpackage.nw0
    public final List e(String str) throws Exception {
        str.getClass();
        if (sb3.d.a(str) == null) {
            throw new UnknownHostException("private hosts not resolved");
        }
        ub2 ub2VarI = p95.i();
        cm2 cm2VarA = a(1, str);
        lu2 lu2Var = this.b;
        ub2VarI.add(new le3(lu2Var, cm2VarA));
        ub2VarI.add(new le3(lu2Var, a(28, str)));
        ub2 ub2VarC = p95.c(ub2VarI);
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(5);
        CountDownLatch countDownLatch = new CountDownLatch(ub2VarC.a());
        Object it = ub2VarC.iterator();
        while (true) {
            sb2 sb2Var = (sb2) it;
            if (!sb2Var.hasNext()) {
                break;
            }
            ((le3) sb2Var.next()).d(new iv1(arrayList, countDownLatch, this, str, arrayList2));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            arrayList.add(e);
        }
        if (!arrayList2.isEmpty()) {
            return arrayList2;
        }
        if (arrayList.isEmpty()) {
            throw new UnknownHostException(str);
        }
        Exception exc = (Exception) arrayList.get(0);
        if (exc instanceof UnknownHostException) {
            throw exc;
        }
        UnknownHostException unknownHostException = new UnknownHostException(str);
        unknownHostException.initCause(exc);
        int size = arrayList.size();
        for (int i = 1; i < size; i++) {
            ek0.b(unknownHostException, (Throwable) arrayList.get(i));
        }
        throw unknownHostException;
    }
}
