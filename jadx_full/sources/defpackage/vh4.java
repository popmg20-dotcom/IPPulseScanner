package defpackage;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vh4 {
    public static final String[] l = {"INSERT", "UPDATE", "DELETE"};
    public final pl3 a;
    public final LinkedHashMap b;
    public final LinkedHashMap c;
    public final boolean d;
    public final x12 e;
    public final String[] g;
    public final ue1 h;
    public final oj1 i;
    public final AtomicBoolean j = new AtomicBoolean(false);
    public pl1 k = new t4(28);
    public final LinkedHashMap f = new LinkedHashMap();

    public vh4(pl3 pl3Var, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, String[] strArr, boolean z, x12 x12Var) {
        String lowerCase;
        this.a = pl3Var;
        this.b = linkedHashMap;
        this.c = linkedHashMap2;
        this.d = z;
        this.e = x12Var;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.f.put(lowerCase2, Integer.valueOf(i));
            String str2 = (String) this.b.get(strArr[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.g = strArr2;
        for (Map.Entry entry : this.b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.f.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                lowerCase4.getClass();
                LinkedHashMap linkedHashMap3 = this.f;
                linkedHashMap3.put(lowerCase4, fh2.T(linkedHashMap3, lowerCase3));
            }
        }
        int length2 = this.g.length;
        ue1 ue1Var = new ue1();
        ue1Var.b = new ReentrantLock();
        ue1Var.z = new long[length2];
        ue1Var.A = new boolean[length2];
        this.h = ue1Var;
        this.i = new oj1(this.g.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(r13 r13Var, ie0 ie0Var) {
        lh4 lh4Var;
        if (ie0Var instanceof lh4) {
            lh4Var = (lh4) ie0Var;
            int i = lh4Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                lh4Var.Z = i - Integer.MIN_VALUE;
            } else {
                lh4Var = new lh4(this, ie0Var);
            }
        }
        Object objB = lh4Var.X;
        int i2 = lh4Var.Z;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(objB);
            q74 q74Var = new q74(7);
            lh4Var.A = r13Var;
            lh4Var.Z = 1;
            objB = r13Var.b("SELECT * FROM room_table_modification_log WHERE invalidated = 1", q74Var, lh4Var);
            if (objB != mf0Var) {
            }
            return mf0Var;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Set set = (Set) lh4Var.A;
            n12.S(objB);
            return set;
        }
        r13Var = (r13) lh4Var.A;
        n12.S(objB);
        Set set2 = (Set) objB;
        if (!set2.isEmpty()) {
            lh4Var.A = set2;
            lh4Var.Z = 2;
            if (ji0.o(r13Var, "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1", lh4Var) == mf0Var) {
                return mf0Var;
            }
        }
        return set2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(ie0 ie0Var) throws Throwable {
        oh4 oh4Var;
        lb lbVar;
        Throwable th;
        lb lbVar2;
        Object objI;
        int[] iArr;
        if (ie0Var instanceof oh4) {
            oh4Var = (oh4) ie0Var;
            int i = oh4Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                oh4Var.y0 = i - Integer.MIN_VALUE;
            } else {
                oh4Var = new oh4(this, ie0Var);
            }
        }
        Object objR = oh4Var.Y;
        int i2 = oh4Var.y0;
        ge0 ge0Var = null;
        int i3 = 1;
        if (i2 == 0) {
            n12.S(objR);
            pl3 pl3Var = this.a;
            lbVar = pl3Var.f;
            boolean zM = lbVar.m();
            k41 k41Var = k41.b;
            if (!zM) {
                return k41Var;
            }
            try {
                if (!this.j.compareAndSet(true, false)) {
                    lbVar.P();
                    return k41Var;
                }
                if (!((Boolean) this.k.a()).booleanValue()) {
                    lbVar.P();
                    return k41Var;
                }
                ph4 ph4Var = new ph4(this, ge0Var, i3);
                oh4Var.A = this;
                oh4Var.X = lbVar;
                oh4Var.y0 = 1;
                objR = pl3Var.r(false, ph4Var, oh4Var);
                mf0 mf0Var = mf0.b;
                if (objR == mf0Var) {
                    return mf0Var;
                }
            } catch (Throwable th2) {
                th = th2;
                lbVar2 = lbVar;
                lbVar2.P();
                throw th;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lbVar2 = oh4Var.X;
            vh4 vh4Var = oh4Var.A;
            try {
                n12.S(objR);
                lbVar = lbVar2;
                this = vh4Var;
            } catch (Throwable th3) {
                th = th3;
                lbVar2.P();
                throw th;
            }
        }
        Set set = (Set) objR;
        if (!set.isEmpty()) {
            oj1 oj1Var = this.i;
            try {
                if (!set.isEmpty()) {
                    m24 m24Var = (m24) oj1Var.f;
                    do {
                        objI = m24Var.i();
                        int[] iArr2 = (int[]) objI;
                        int length = iArr2.length;
                        iArr = new int[length];
                        for (int i4 = 0; i4 < length; i4++) {
                            iArr[i4] = set.contains(Integer.valueOf(i4)) ? iArr2[i4] + 1 : iArr2[i4];
                        }
                    } while (!m24Var.g(objI, iArr));
                }
                this.e.g(set);
            } catch (Throwable th4) {
                th = th4;
                lbVar2 = lbVar;
                lbVar2.P();
                throw th;
            }
        }
        lbVar.P();
        return set;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(String[] strArr, pl1 pl1Var, pl1 pl1Var2, ie0 ie0Var) {
        qh4 qh4Var;
        int[] iArr;
        if (ie0Var instanceof qh4) {
            qh4Var = (qh4) ie0Var;
            int i = qh4Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                qh4Var.y0 = i - Integer.MIN_VALUE;
            } else {
                qh4Var = new qh4(this, ie0Var);
            }
        }
        Object objB = qh4Var.Y;
        int i2 = qh4Var.y0;
        boolean z = true;
        try {
            if (i2 == 0) {
                n12.S(objB);
                int[] iArr2 = (int[]) h(strArr).f;
                pl1Var.a();
                qh4Var.A = pl1Var2;
                qh4Var.X = iArr2;
                qh4Var.y0 = 1;
                objB = b(qh4Var);
                Object obj = mf0.b;
                if (objB == obj) {
                    return obj;
                }
                iArr = iArr2;
            } else {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                iArr = qh4Var.X;
                pl1Var2 = qh4Var.A;
                n12.S(objB);
            }
            Set set = (Set) objB;
            if (iArr.length != 0) {
                for (int i3 : iArr) {
                    if (set.contains(new Integer(i3))) {
                        break;
                    }
                }
                z = false;
            } else if (set.isEmpty()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } finally {
            pl1Var2.a();
        }
    }

    public final void d(pl1 pl1Var, pl1 pl1Var2) {
        pl1Var.getClass();
        pl1Var2.getClass();
        if (this.j.compareAndSet(false, true)) {
            pl1Var.a();
            ji0.B(this.a.f(), new hf0(hf0.f), null, new w53(this, pl1Var2, null, 11), 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
    
        if (defpackage.ji0.o(r1, r3, r4) == r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00db, code lost:
    
        if (defpackage.ji0.o(r10, r3, r4) == r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00dd, code lost:
    
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00db -> B:28:0x00de). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(jg4 jg4Var, int i, ie0 ie0Var) {
        rh4 rh4Var;
        String[] strArr;
        vh4 vh4Var;
        int i2;
        r13 r13Var;
        int i3;
        String str;
        vh4 vh4Var2 = this;
        r13 r13Var2 = jg4Var;
        int i4 = i;
        if (ie0Var instanceof rh4) {
            rh4Var = (rh4) ie0Var;
            int i5 = rh4Var.D0;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                rh4Var.D0 = i5 - Integer.MIN_VALUE;
            } else {
                rh4Var = new rh4(vh4Var2, ie0Var);
            }
        }
        Object obj = rh4Var.B0;
        int i6 = rh4Var.D0;
        boolean z = true;
        mf0 mf0Var = mf0.b;
        if (i6 == 0) {
            n12.S(obj);
            String str2 = "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i4 + ", 0)";
            rh4Var.A = vh4Var2;
            rh4Var.X = r13Var2;
            rh4Var.y0 = i4;
            rh4Var.D0 = 1;
        } else if (i6 == 1) {
            int i7 = rh4Var.y0;
            r13Var2 = rh4Var.X;
            vh4 vh4Var3 = rh4Var.A;
            n12.S(obj);
            i4 = i7;
            vh4Var2 = vh4Var3;
        } else {
            if (i6 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i2 = rh4Var.A0;
            i3 = rh4Var.z0;
            i4 = rh4Var.y0;
            strArr = rh4Var.Z;
            str = rh4Var.Y;
            r13Var = rh4Var.X;
            vh4Var = rh4Var.A;
            n12.S(obj);
            boolean z2 = true;
            i3++;
            z = z2;
            if (i3 < i2) {
                return xl4.a;
            }
            String str3 = strArr[i3];
            z2 = z;
            StringBuilder sbE = fw.E("CREATE ", vh4Var.d ? "TEMP" : "", " TRIGGER IF NOT EXISTS `", "room_table_modification_trigger_" + str + '_' + str3, "` AFTER ");
            ha0.v(sbE, str3, " ON `", str, "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
            String strW = fw.w(" AND invalidated = 0; END", sbE, i4);
            rh4Var.A = vh4Var;
            rh4Var.X = r13Var;
            rh4Var.Y = str;
            rh4Var.Z = strArr;
            rh4Var.y0 = i4;
            rh4Var.z0 = i3;
            rh4Var.A0 = i2;
            rh4Var.D0 = 2;
        }
        String str4 = vh4Var2.g[i4];
        strArr = l;
        vh4Var = vh4Var2;
        i2 = 3;
        r13Var = r13Var2;
        i3 = 0;
        str = str4;
        if (i3 < i2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0089 -> B:19:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(jg4 jg4Var, int i, ie0 ie0Var) {
        sh4 sh4Var;
        String str;
        int i2;
        r13 r13Var;
        int i3;
        String[] strArr;
        if (ie0Var instanceof sh4) {
            sh4Var = (sh4) ie0Var;
            int i4 = sh4Var.B0;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                sh4Var.B0 = i4 - Integer.MIN_VALUE;
            } else {
                sh4Var = new sh4(this, ie0Var);
            }
        }
        Object obj = sh4Var.z0;
        int i5 = sh4Var.B0;
        if (i5 == 0) {
            n12.S(obj);
            str = this.g[i];
            i2 = 3;
            r13Var = jg4Var;
            i3 = 0;
            strArr = l;
            if (i3 < i2) {
            }
        } else {
            if (i5 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i2 = sh4Var.y0;
            i3 = sh4Var.Z;
            String[] strArr2 = sh4Var.Y;
            str = sh4Var.X;
            r13 r13Var2 = sh4Var.A;
            n12.S(obj);
            strArr = strArr2;
            r13Var = r13Var2;
            i3++;
            if (i3 < i2) {
                String str2 = "DROP TRIGGER IF EXISTS `" + ("room_table_modification_trigger_" + str + '_' + strArr[i3]) + '`';
                sh4Var.A = r13Var;
                sh4Var.X = str;
                sh4Var.Y = strArr;
                sh4Var.Z = i3;
                sh4Var.y0 = i2;
                sh4Var.B0 = 1;
                Object objO = ji0.o(r13Var, str2, sh4Var);
                mf0 mf0Var = mf0.b;
                if (objO == mf0Var) {
                    return mf0Var;
                }
                i3++;
                if (i3 < i2) {
                    return xl4.a;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(ie0 ie0Var) throws Throwable {
        th4 th4Var;
        lb lbVar;
        if (ie0Var instanceof th4) {
            th4Var = (th4) ie0Var;
            int i = th4Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                th4Var.Z = i - Integer.MIN_VALUE;
            } else {
                th4Var = new th4(this, ie0Var);
            }
        }
        Object obj = th4Var.X;
        int i2 = th4Var.Z;
        ge0 ge0Var = null;
        if (i2 == 0) {
            n12.S(obj);
            pl3 pl3Var = this.a;
            lb lbVar2 = pl3Var.f;
            if (lbVar2.m()) {
                try {
                    ph4 ph4Var = new ph4(this, ge0Var, 2);
                    th4Var.A = lbVar2;
                    th4Var.Z = 1;
                    Object objR = pl3Var.r(false, ph4Var, th4Var);
                    mf0 mf0Var = mf0.b;
                    if (objR == mf0Var) {
                        return mf0Var;
                    }
                    lbVar = lbVar2;
                    lbVar.P();
                } catch (Throwable th) {
                    th = th;
                    lbVar = lbVar2;
                    lbVar.P();
                    throw th;
                }
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lbVar = th4Var.A;
            try {
                n12.S(obj);
                lbVar.P();
            } catch (Throwable th2) {
                th = th2;
                lbVar.P();
                throw th;
            }
        }
        return xl4.a;
    }

    public final e03 h(String[] strArr) {
        strArr.getClass();
        cu3 cu3Var = new cu3();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set set = (Set) this.c.get(lowerCase);
            if (set != null) {
                cu3Var.addAll(set);
            } else {
                cu3Var.add(str);
            }
        }
        String[] strArr2 = (String[]) yr2.b(cu3Var).toArray(new String[0]);
        int length = strArr2.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArr2[i];
            String lowerCase2 = str2.toLowerCase(Locale.ROOT);
            lowerCase2.getClass();
            Integer num = (Integer) this.f.get(lowerCase2);
            if (num == null) {
                xe.k("There is no table with name ".concat(str2));
                return null;
            }
            iArr[i] = num.intValue();
        }
        return new e03(strArr2, iArr);
    }
}
