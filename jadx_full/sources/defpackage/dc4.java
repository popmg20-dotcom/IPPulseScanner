package defpackage;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dc4 extends f41 {
    public static final /* synthetic */ int f = 0;
    public final bc4 b;
    public final LanguageConfiguration c;
    public final gc4[] d;
    public final hc4 e = new hc4(this);

    public dc4(nv1 nv1Var, LanguageConfiguration languageConfiguration, ed4 ed4Var) {
        bc4 bc4Var = this.b;
        if (bc4Var != null) {
            bc4Var.a = null;
            bc4Var.i();
        }
        try {
            this.b = new bc4(this, nv1Var, languageConfiguration, ed4Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c = languageConfiguration;
        this.d = new gc4[]{new gc4(this)};
        if (languageConfiguration != null) {
            this.e.X();
        }
    }

    @Override // defpackage.f41, defpackage.s82
    public final void a(wd0 wd0Var, q30 q30Var, v80 v80Var) {
        List<ax3> list;
        boolean zTryLock;
        boolean z;
        boolean z2;
        int i = q30Var.c;
        int i2 = q30Var.b;
        wd0Var.a();
        String strQ = wd0Var.X.q(i2);
        while (i > 0) {
            if (!ao2.a(ao2.b, strQ.charAt(i - 1))) {
                break;
            } else {
                i--;
            }
        }
        String strSubstring = strQ.substring(i, q30Var.c);
        dm dmVar = this.b.m;
        int length = strSubstring.length();
        boolean z3 = false;
        if (length == 0) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList = new ArrayList();
            strSubstring.toLowerCase(Locale.ROOT);
            if (dmVar != null) {
                ArrayList<String> arrayList2 = new ArrayList();
                ReentrantLock reentrantLock = (ReentrantLock) dmVar.a;
                try {
                    zTryLock = reentrantLock.tryLock(3L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    zTryLock = false;
                }
                if (zTryLock) {
                    try {
                        for (String str : ((HashMap) dmVar.b).keySet()) {
                            Locale locale = Locale.ROOT;
                            vm1 vm1VarB = pe1.b(0, strSubstring, strSubstring.toLowerCase(locale), str, str.toLowerCase(locale));
                            int i3 = vm1VarB == null ? -100 : vm1VarB.a;
                            if (yr2.l0(str, strSubstring, true) || i3 >= -20) {
                                if (strSubstring.length() != str.length() || !yr2.l0(strSubstring, str, false)) {
                                    arrayList2.add(str);
                                }
                            }
                        }
                        reentrantLock.unlock();
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                for (String str2 : arrayList2) {
                    ax3 ax3Var = new ax3();
                    ax3Var.b = str2;
                    ax3Var.a = null;
                    ax3Var.f = str2;
                    ax3Var.d = length;
                    u80 u80Var = u80.A;
                    ax3Var.c = u80Var;
                    u80Var.getClass();
                    ax3Var.a = new x40(u80Var);
                    arrayList.add(ax3Var);
                }
            }
            list = arrayList;
        }
        list.getClass();
        ArrayList arrayList3 = new ArrayList();
        wd0Var.a();
        ud0 ud0VarO = ((ld0) wd0Var.b).o(q30Var.b);
        String string = "";
        String lowerCase = string;
        for (ax3 ax3Var2 : list) {
            wd0Var.a();
            int i4 = ax3Var2.d;
            if (string.length() != i4) {
                if (i4 == 0) {
                    string = "";
                } else {
                    ud0VarO.getClass();
                    int i5 = q30Var.c;
                    string = ud0VarO.subSequence(i5 - i4, i5).toString();
                }
                lowerCase = string.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
            }
            String str3 = string;
            String str4 = lowerCase;
            vm1 vm1Var = vm1.c;
            kz3 kz3Var = new kz3(ax3Var2, vm1Var);
            if (i4 == 0) {
                kz3Var.b = vm1Var;
            } else {
                int i6 = 0;
                while (i6 < i4) {
                    char cCharAt = str3.charAt(i6);
                    if (cCharAt != '\t' && cCharAt != ' ') {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 >= i4) {
                    vm1 vm1Var2 = vm1.c;
                    vm1Var2.getClass();
                    kz3Var.b = vm1Var2;
                } else {
                    String strF = je.f(ax3Var2.b);
                    String lowerCase2 = je.f(ax3Var2.b).toLowerCase(Locale.ROOT);
                    lowerCase2.getClass();
                    strF.getClass();
                    vm1 vm1VarA = ud0VarO.f > 2000 ? pe1.a(str3, str4, i6, strF, lowerCase2, wm1.b) : pe1.b(i6, str3, str4, strF, lowerCase2);
                    if (vm1VarA == null) {
                        string = str3;
                        lowerCase = str4;
                    } else {
                        kz3Var.b = vm1VarA;
                    }
                }
                ax3Var2.e = kz3Var;
            }
            arrayList3.add(ax3Var2);
            string = str3;
            lowerCase = str4;
        }
        if (!arrayList3.isEmpty() && ((ax3) d70.c0(arrayList3)).e != null && ((ax3) d70.c0(arrayList3)).e == null) {
            xe.k("The completionItemList must run through the filterCompletionItems() method first");
            return;
        }
        int i7 = 2;
        i60 i60Var = new i60(2);
        ArrayList arrayList4 = v80Var.b;
        Handler handler = v80Var.d;
        ReentrantLock reentrantLock2 = v80Var.c;
        if (Thread.interrupted() || (z = v80Var.g)) {
            v80Var.g = true;
            throw new s80();
        }
        if (!z) {
            reentrantLock2.lock();
            try {
                arrayList4.addAll(arrayList3);
                reentrantLock2.unlock();
                if (arrayList4.size() >= 5 && !v80Var.g) {
                    handler.post(new cw(i7, v80Var, z3));
                }
            } catch (Throwable th2) {
                reentrantLock2.unlock();
                throw th2;
            }
        }
        if (Thread.interrupted() || (z2 = v80Var.g)) {
            v80Var.g = true;
            throw new s80();
        }
        if (z2) {
            return;
        }
        v80Var.f = i60Var;
        if (v80Var.a.isEmpty()) {
            return;
        }
        handler.post(new s7(17, v80Var, i60Var));
    }

    @Override // defpackage.f41, defpackage.s82
    public final sr2[] b() {
        return this.d;
    }

    @Override // defpackage.f41, defpackage.s82
    public final m0 c() {
        bc4 bc4Var = this.b;
        return bc4Var == null ? e41.c : bc4Var;
    }

    @Override // defpackage.f41, defpackage.s82
    public final n02 d() {
        return this.e;
    }
}
