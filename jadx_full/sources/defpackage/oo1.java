package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oo1 extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ boolean Z;
    public Object y0;
    public /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo1(String str, boolean z, po1 po1Var, iv1 iv1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 0;
        this.y0 = str;
        this.Z = z;
        this.z0 = po1Var;
        this.A0 = iv1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((oo1) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.A0;
        switch (i) {
            case 0:
                return new oo1((String) this.y0, this.Z, (po1) this.z0, (iv1) obj2, ge0Var);
            case 1:
                return new oo1((ProfileEditorActivity) this.z0, (Uri) obj2, this.Z, ge0Var, 1);
            case 2:
                return new oo1((ProfileEditorActivity) this.z0, (String) this.y0, (String) obj2, this.Z, ge0Var);
            case 3:
                oo1 oo1Var = new oo1((d83) this.z0, (List) obj2, this.Z, ge0Var, 3);
                oo1Var.y0 = obj;
                return oo1Var;
            default:
                oo1 oo1Var2 = new oo1((e24) obj2, this.Z, ge0Var);
                oo1Var2.z0 = obj;
                return oo1Var2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x03f8, code lost:
    
        if (defpackage.ji0.V(r1, r3, r13, r12, r8, r22) != r10) goto L163;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0395 A[Catch: Exception -> 0x0323, OutOfMemoryError -> 0x0326, TryCatch #3 {Exception -> 0x0323, OutOfMemoryError -> 0x0326, blocks: (B:114:0x031e, B:121:0x032e, B:134:0x037e, B:136:0x0395, B:138:0x039b, B:140:0x03a1, B:142:0x03a5, B:144:0x03a9, B:146:0x03b4, B:147:0x03c3, B:148:0x03c6, B:149:0x03c7, B:150:0x03ca, B:151:0x03cb, B:153:0x03cf, B:154:0x03da, B:155:0x03dd, B:156:0x03de, B:157:0x03e3, B:158:0x03e4, B:124:0x0338, B:131:0x0360, B:127:0x0342), top: B:188:0x0310 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0258  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        Object objB0;
        ProfileEditorActivity profileEditorActivity;
        Object objB02;
        boolean zQ0;
        Object tk3Var;
        ArrayList arrayList;
        Object next;
        String str;
        int i = 0;
        int i2 = 1;
        ge0 ge0Var = null;
        switch (this.X) {
            case 0:
                xl4 xl4Var = xl4.a;
                mf0 mf0Var = mf0.b;
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    ko1 ko1Var = ko1.a;
                    String str2 = (String) this.y0;
                    boolean z = this.Z;
                    eg0 eg0Var = new eg0(25, (po1) this.z0, (iv1) this.A0);
                    this.Y = 1;
                    String str3 = "validateAndSaveGeoIPDatabaseUrl: " + z + ", " + str2;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "GeoIPConfig", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("GeoIPConfig", str3, null);
                    }
                    gm0 gm0Var = qv0.a;
                    Object objB03 = ji0.b0(qf2.a, new dh0(z, str2, eg0Var, (ge0) null), this);
                    if (objB03 != mf0Var) {
                        objB03 = xl4Var;
                    }
                    if (objB03 == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var;
            case 1:
                ProfileEditorActivity profileEditorActivity2 = (ProfileEditorActivity) this.z0;
                mf0 mf0Var2 = mf0.b;
                int i4 = this.Y;
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                    String string = profileEditorActivity2.getString(R.string.profile_decode_error_template, e.getMessage());
                    string.getClass();
                    profileEditorActivity2.B(string);
                } catch (OutOfMemoryError e2) {
                    String string2 = profileEditorActivity2.getString(R.string.profile_decode_error_template, e2.getMessage());
                    string2.getClass();
                    profileEditorActivity2.B(string2);
                }
                if (i4 != 0) {
                    if (i4 == 1) {
                        ProfileEditorActivity profileEditorActivity3 = (ProfileEditorActivity) this.y0;
                        n12.S(obj);
                        profileEditorActivity = profileEditorActivity3;
                        objB0 = obj;
                    } else {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                xe.q("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            n12.S(obj);
                            return xl4.a;
                        }
                        n12.S(obj);
                        objB02 = obj;
                        CharSequence charSequence = (CharSequence) objB02;
                        fa2 fa2Var = profileEditorActivity2.b;
                        q92 q92Var = q92.X;
                        gm0 gm0Var2 = qv0.a;
                        tq1 tq1Var = qf2.a.X;
                        cf0 cf0Var = this.f;
                        cf0Var.getClass();
                        zQ0 = tq1Var.q0(cf0Var);
                        if (!zQ0) {
                            q92 q92Var2 = fa2Var.c;
                            if (q92Var2 == q92.b) {
                                throw new x92(null);
                            }
                            if (q92Var2.compareTo(q92Var) >= 0) {
                                if (profileEditorActivity2.T0 != null) {
                                    cm2 cm2Var = profileEditorActivity2.S0;
                                    if (cm2Var == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((CodeEditor) cm2Var.z).setText(charSequence);
                                    cm2 cm2Var2 = profileEditorActivity2.S0;
                                    if (cm2Var2 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((CodeEditor) cm2Var2.z).n0(nd0.class, new j63(profileEditorActivity2));
                                }
                                cm2 cm2Var3 = profileEditorActivity2.S0;
                                if (cm2Var3 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((LinearProgressIndicator) cm2Var3.A).b();
                                profileEditorActivity2.z();
                            }
                            return xl4.a;
                        }
                        kt ktVar = new kt(8, profileEditorActivity2, charSequence);
                        this.y0 = null;
                        this.Y = 3;
                    }
                    break;
                } else {
                    n12.S(obj);
                    Uri uri = (Uri) this.A0;
                    boolean z2 = this.Z;
                    this.y0 = profileEditorActivity2;
                    this.Y = 1;
                    int i5 = ProfileEditorActivity.Y0;
                    gm0 gm0Var3 = qv0.a;
                    objB0 = ji0.b0(pl0.z, new i63(profileEditorActivity2, uri, z2, null), this);
                    if (objB0 == mf0Var2) {
                        return mf0Var2;
                    }
                    profileEditorActivity = profileEditorActivity2;
                }
                profileEditorActivity.U0 = (String) objB0;
                String str4 = profileEditorActivity2.U0;
                str4.getClass();
                this.y0 = null;
                this.Y = 2;
                objB02 = ji0.b0(qv0.a, new gd(str4, ge0Var, 12), this);
                if (objB02 != mf0Var2) {
                    CharSequence charSequence2 = (CharSequence) objB02;
                    fa2 fa2Var2 = profileEditorActivity2.b;
                    q92 q92Var3 = q92.X;
                    gm0 gm0Var22 = qv0.a;
                    tq1 tq1Var2 = qf2.a.X;
                    cf0 cf0Var2 = this.f;
                    cf0Var2.getClass();
                    zQ0 = tq1Var2.q0(cf0Var2);
                    if (!zQ0) {
                    }
                    kt ktVar2 = new kt(8, profileEditorActivity2, charSequence2);
                    this.y0 = null;
                    this.Y = 3;
                    break;
                }
                return mf0Var2;
            case 2:
                mf0 mf0Var3 = mf0.b;
                int i6 = this.Y;
                if (i6 == 0) {
                    n12.S(obj);
                    ProfileEditorActivity profileEditorActivity4 = (ProfileEditorActivity) this.z0;
                    String str5 = (String) this.y0;
                    String str6 = (String) this.A0;
                    boolean z3 = this.Z;
                    fa2 fa2Var3 = profileEditorActivity4.b;
                    q92 q92Var4 = q92.X;
                    gm0 gm0Var4 = qv0.a;
                    tq1 tq1Var3 = qf2.a.X;
                    cf0 cf0Var3 = this.f;
                    cf0Var3.getClass();
                    boolean zQ02 = tq1Var3.q0(cf0Var3);
                    if (zQ02) {
                        p63 p63Var = new p63(str5, profileEditorActivity4, str6, z3);
                        this.Y = 1;
                        if (ji0.V(fa2Var3, q92Var4, zQ02, tq1Var3, p63Var, this) == mf0Var3) {
                            return mf0Var3;
                        }
                    } else {
                        q92 q92Var5 = fa2Var3.c;
                        if (q92Var5 == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (q92Var5.compareTo(q92Var4) >= 0) {
                            if (str5 == null) {
                                new v62((Context) profileEditorActivity4).O(new fa5(profileEditorActivity4, str6, z3));
                            } else {
                                cm2 cm2Var4 = profileEditorActivity4.S0;
                                if (cm2Var4 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((LinearProgressIndicator) cm2Var4.A).e();
                                ji0.B(uf2.t(profileEditorActivity4), null, null, new o63(str5, str6, new p53(i2, profileEditorActivity4), profileEditorActivity4, z3, null), 3);
                            }
                        }
                    }
                } else {
                    if (i6 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            case 3:
                lf0 lf0Var = (lf0) this.y0;
                mf0 mf0Var4 = mf0.b;
                int i7 = this.Y;
                if (i7 == 0) {
                    n12.S(obj);
                    d83 d83Var = (d83) this.z0;
                    List list = (List) this.A0;
                    boolean z4 = this.Z;
                    r92 lifecycle = d83Var.getLifecycle();
                    q92 q92Var6 = q92.z;
                    gm0 gm0Var5 = qv0.a;
                    tq1 tq1Var4 = qf2.a.X;
                    cf0 cf0Var4 = this.f;
                    cf0Var4.getClass();
                    boolean zQ03 = tq1Var4.q0(cf0Var4);
                    if (zQ03) {
                        p63 p63Var2 = new p63(d83Var, lf0Var, list, z4);
                        this.y0 = null;
                        this.Y = 1;
                        if (ji0.V(lifecycle, q92Var6, zQ03, tq1Var4, p63Var2, this) == mf0Var4) {
                            return mf0Var4;
                        }
                    } else {
                        if (lifecycle.b() == q92.b) {
                            vp1.m();
                            return null;
                        }
                        if (lifecycle.b().compareTo(q92Var6) >= 0) {
                            y3 y3Var = d83Var.b;
                            y3Var.getClass();
                            ((LinearProgressIndicator) y3Var.g).e();
                            ji0.B(lf0Var, null, null, new dh0(list, z4, d83Var, (ge0) null), 3);
                            y3 y3Var2 = d83Var.b;
                            y3Var2.getClass();
                            ((LinearProgressIndicator) y3Var2.g).b();
                        }
                    }
                } else {
                    if (i7 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            default:
                mf0 mf0Var5 = mf0.b;
                int i8 = this.Y;
                try {
                    if (i8 == 0) {
                        n12.S(obj);
                        e24 e24Var = (e24) this.A0;
                        boolean z5 = this.Z;
                        lu2 lu2Var = (lu2) e24Var.z;
                        String strConcat = p44.G0("/", (String) e24Var.f).concat("/Surfboard/");
                        e24.g(lu2Var, strConcat, new dt4(lu2Var, strConcat, i));
                        lu2 lu2Var2 = (lu2) e24Var.z;
                        String strConcat2 = p44.G0("/", (String) e24Var.f).concat("/Surfboard/profiles");
                        e24.g(lu2Var2, strConcat2, new dt4(lu2Var2, strConcat2, i));
                        ArrayList arrayList2 = new ArrayList();
                        lu2 lu2Var3 = (lu2) e24Var.z;
                        String strConcat3 = p44.G0("/", (String) e24Var.f).concat("/Surfboard/profiles");
                        cd cdVar = new cd(10, arrayList2);
                        dv1 dv1Var = new dv1();
                        dv1Var.c(null, strConcat3);
                        new ck0(lu2Var3, dv1Var.a()).f(1, new k83[0], new o73(13, cdVar));
                        ArrayList<Callable> arrayList3 = new ArrayList(f70.Q(10, arrayList2));
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(new ft4(0, e24Var, (e03) it.next()));
                        }
                        ArrayList arrayList4 = new ArrayList();
                        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            executorCompletionService.submit((Callable) it2.next());
                        }
                        for (Callable callable : arrayList3) {
                            e03 e03Var = (e03) executorCompletionService.take().get();
                            if (e03Var != null) {
                                arrayList4.add(e03Var);
                            }
                        }
                        t53 t53Var = (t53) d73.c.d();
                        String str7 = t53Var != null ? t53Var.b : null;
                        if (z5) {
                            d73.k(true);
                            File[] fileArrListFiles = d73.f().listFiles(new c73(4));
                            if (fileArrListFiles != null) {
                                for (File file : fileArrListFiles) {
                                    file.delete();
                                }
                            }
                            if (str7 != null) {
                                Iterator it3 = arrayList4.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        next = it3.next();
                                        if (n12.c(((t53) ((e03) next).b).b, str7)) {
                                        }
                                    } else {
                                        next = null;
                                    }
                                }
                                e03 e03Var2 = (e03) next;
                                if (e03Var2 != null) {
                                    arrayList4.remove(e03Var2);
                                    arrayList4.add(0, e03Var2);
                                }
                            }
                        }
                        e1 e1Var = d73.a;
                        e03[] e03VarArr = (e03[]) arrayList4.toArray(new e03[0]);
                        e03[] e03VarArr2 = (e03[]) Arrays.copyOf(e03VarArr, e03VarArr.length);
                        this.z0 = null;
                        this.y0 = arrayList4;
                        this.Y = 1;
                        if (d73.j(e03VarArr2, this) == mf0Var5) {
                            return mf0Var5;
                        }
                        arrayList = arrayList4;
                    } else {
                        if (i8 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        arrayList = (ArrayList) this.y0;
                        n12.S(obj);
                    }
                    String str8 = "download " + arrayList.size() + " remote profile to local finished";
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "WebDAVClient", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str8);
                        str = str8;
                    } else {
                        str = str8;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("WebDAVClient", str, null);
                    }
                    tk3Var = Boolean.TRUE;
                    break;
                } catch (Throwable th) {
                    tk3Var = new tk3(th);
                }
                return new uk3(tk3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo1(ProfileEditorActivity profileEditorActivity, String str, String str2, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 2;
        this.z0 = profileEditorActivity;
        this.y0 = str;
        this.A0 = str2;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ oo1(Object obj, Object obj2, boolean z, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.z0 = obj;
        this.A0 = obj2;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo1(e24 e24Var, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 4;
        this.A0 = e24Var;
        this.Z = z;
    }
}
