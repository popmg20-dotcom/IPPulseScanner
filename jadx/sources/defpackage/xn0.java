package defpackage;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.impl.WorkDatabase;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xn0 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ xn0(int i, Object obj, Object obj2, Object obj3) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        t53 t53Var;
        Object next;
        switch (this.a) {
            case 0:
                return ((yn0) this.b).b.submit(new s7(28, (Callable) this.c, (cp1) this.d));
            case 1:
                n53 n53Var = (n53) this.b;
                ArrayList arrayList = (ArrayList) this.c;
                String str = (String) this.d;
                WorkDatabase workDatabase = n53Var.e;
                lx4 lx4VarY = workDatabase.y();
                lx4VarY.getClass();
                str.getClass();
                arrayList.addAll((List) ke0.r(lx4VarY.a, true, false, new ko0(str, 24)));
                return workDatabase.x().c(str);
            default:
                File file = (File) this.b;
                bh3 bh3Var = (bh3) this.c;
                List list = (List) this.d;
                xl4 xl4Var = xl4.a;
                gj gjVar = new gj(14, file, list);
                file.getClass();
                String name = file.getName();
                name.getClass();
                String strS0 = p44.S0(name, ".");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    String strT = l72.T(new BufferedReader(new InputStreamReader(fileInputStream, y30.a), 8192));
                    fileInputStream.close();
                    List list2 = (List) d73.b.d();
                    if (list2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : list2) {
                            if (obj instanceof t53) {
                                arrayList2.add(obj);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next = it.next();
                                if (n12.c(((t53) next).b, strS0)) {
                                }
                            } else {
                                next = null;
                            }
                        }
                        t53Var = (t53) next;
                    } else {
                        t53Var = null;
                    }
                    if (t53Var == null || t53Var.f != strT.hashCode()) {
                        if (t53Var != null) {
                            String strConcat = strS0.concat(": content changed, start decode the new one");
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("ProfileManager", strConcat, null);
                            }
                        }
                        t53 t53Var2 = (t53) bh3Var.b;
                        if (t53Var2 == null || !n12.c(t53Var2.b, strS0)) {
                            SystemClock.elapsedRealtime();
                            byte[] bytes = strT.getBytes(y30.a);
                            bytes.getClass();
                            Serializable serializableJ = c63.j(strS0, new ByteArrayInputStream(bytes), k01.A, t60.Y, vd3.A, null);
                            Throwable thA = uk3.a(serializableJ);
                            if (thA == null) {
                                gjVar.g(((e03) serializableJ).b);
                            } else {
                                String strU = fw.u("onFailure: ", strS0, " ", thA.getMessage());
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 4, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    a1.e("ProfileManager", strU, null);
                                }
                                list.add(new p12(strS0, file.lastModified(), strT.hashCode(), xb5.h((String) d70.e0(p44.B0(strT))), thA.getMessage()));
                            }
                        } else {
                            String strConcat2 = "use decoded selected profile directly: ".concat(strS0);
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat2);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("ProfileManager", strConcat2, null);
                            }
                            gjVar.g(t53Var2);
                        }
                    } else {
                        String strConcat3 = strS0.concat(": content not changed, reuse the old one");
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat3);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("ProfileManager", strConcat3, null);
                        }
                        gjVar.g(t53Var);
                    }
                    return xl4Var;
                } finally {
                }
        }
    }
}
