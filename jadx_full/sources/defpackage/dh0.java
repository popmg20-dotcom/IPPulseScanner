package defpackage;

import android.content.SharedPreferences;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dh0 extends v74 implements Function2 {
    public final /* synthetic */ int X = 0;
    public int Y;
    public final /* synthetic */ boolean Z;
    public /* synthetic */ Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(ge0 ge0Var, am1 am1Var, pl3 pl3Var, boolean z) {
        super(2, ge0Var);
        this.y0 = pl3Var;
        this.Z = z;
        this.z0 = am1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((dh0) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        boolean z = this.Z;
        Object obj2 = this.z0;
        switch (i) {
            case 0:
                return new dh0(ge0Var, (am1) obj2, (pl3) this.y0, z);
            case 1:
                return new dh0(z, (String) this.y0, (eg0) obj2, ge0Var);
            case 2:
                return new dh0((String) this.y0, (String) obj2, z, ge0Var);
            case 3:
                return new dh0((List) this.y0, z, (d83) obj2, ge0Var);
            default:
                dh0 dh0Var = new dh0(ge0Var, (d83) obj2, z);
                dh0Var.y0 = obj;
                return dh0Var;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x02c2, code lost:
    
        if (defpackage.ji0.b0(r1, r2, r18) == r12) goto L117;
     */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        Object objV;
        Object objZ;
        int i = this.X;
        q92 q92Var = q92.b;
        cf0 cf0Var = this.f;
        int i2 = 2;
        xl4 xl4Var = xl4.a;
        boolean z = this.Z;
        int i3 = 3;
        Object obj2 = this.z0;
        mf0 mf0Var = mf0.b;
        int i4 = 1;
        Object obj3 = null;
        switch (i) {
            case 0:
                int i5 = this.Y;
                if (i5 == 0) {
                    n12.S(obj);
                    pl3 pl3Var = (pl3) this.y0;
                    fh0 fh0Var = new fh0(null, (am1) obj2, pl3Var, z);
                    this.Y = 1;
                    Object objR = pl3Var.r(z, fh0Var, this);
                    if (objR == mf0Var) {
                    }
                } else if (i5 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                break;
            case 1:
                eg0 eg0Var = (eg0) obj2;
                String str = (String) this.y0;
                int i6 = this.Y;
                try {
                    if (i6 == 0) {
                        n12.S(obj);
                        ko1 ko1Var = ko1.a;
                        SharedPreferences sharedPreferences = ko1.b;
                        String string = sharedPreferences.getString(RtspHeaders.Values.URL, null);
                        String string2 = sharedPreferences.getString("file_name", null);
                        if (!z && n12.c(string, str) && string2 == null) {
                            eg0Var.Q(false);
                        } else if (str == null || str.length() == 0) {
                            gm0 gm0Var = qv0.a;
                            pl0 pl0Var = pl0.z;
                            lt ltVar = new lt(i2, null, 4);
                            this.Y = 1;
                        } else {
                            gm0 gm0Var2 = qv0.a;
                            pl0 pl0Var2 = pl0.z;
                            p81 p81Var = new p81(str, null, i3);
                            this.Y = 2;
                            if (ji0.b0(pl0Var2, p81Var, this) == mf0Var) {
                            }
                            ko1 ko1Var2 = ko1.a;
                            ko1.c(str);
                            eg0Var.Q(true);
                        }
                    } else if (i6 == 1) {
                        n12.S(obj);
                        eg0Var.Q(true);
                    } else if (i6 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        n12.S(obj);
                        ko1 ko1Var22 = ko1.a;
                        ko1.c(str);
                        eg0Var.Q(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    po1 po1Var = (po1) eg0Var.f;
                    ji0.B(uf2.t(po1Var), null, null, new mo1((iv1) eg0Var.z, e, po1Var, null, 1), 3);
                    return xl4Var;
                }
                break;
            case 2:
                int i7 = this.Y;
                if (i7 != 0) {
                    if (i7 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        n12.S(obj);
                        objV = ((uk3) obj).b;
                    }
                    break;
                } else {
                    n12.S(obj);
                    long jH = t23.h();
                    this.Y = 1;
                    objV = vd3.Z.v((String) this.y0, (String) obj2, this.Z, jH, this);
                    if (objV == mf0Var) {
                    }
                }
                break;
            case 3:
                int i8 = this.Y;
                if (i8 == 0) {
                    n12.S(obj);
                    String strO = t23.o("webdav_server", null);
                    strO.getClass();
                    String strO2 = t23.o("webdav_account", null);
                    strO2.getClass();
                    String strO3 = t23.o("webdav_password", null);
                    strO3.getClass();
                    e24 e24Var = new e24(strO, strO2, strO3);
                    List list = (List) this.y0;
                    this.Y = 1;
                    objZ = e24Var.z(list, z, this);
                    if (objZ != mf0Var) {
                    }
                } else if (i8 == 1) {
                    n12.S(obj);
                    objZ = ((uk3) obj).b;
                } else if (i8 == 2 || i8 == 3 || i8 == 4) {
                    n12.S(obj);
                } else {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                }
                d83 d83Var = (d83) obj2;
                Throwable thA = uk3.a(objZ);
                q92 q92Var2 = q92.z;
                if (thA != null) {
                    thA.printStackTrace();
                    r92 lifecycle = d83Var.getLifecycle();
                    gm0 gm0Var3 = qv0.a;
                    tq1 tq1Var = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ0 = tq1Var.q0(cf0Var);
                    if (!zQ0) {
                        if (lifecycle.b() == q92Var) {
                            vp1.m();
                        } else if (lifecycle.b().compareTo(q92Var2) >= 0) {
                            y3 y3Var = d83Var.b;
                            y3Var.getClass();
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                            coordinatorLayout.getClass();
                            String message = thA.getMessage();
                            if (message == null) {
                                message = d83Var.getString(R.string.webdav_upload_failure);
                                message.getClass();
                            }
                            r25.S(coordinatorLayout, message);
                        }
                    }
                    y73 y73Var = new y73(d83Var, thA, i4);
                    this.Y = 4;
                    if (ji0.V(lifecycle, q92Var2, zQ0, tq1Var, y73Var, this) != mf0Var) {
                    }
                } else if (!((Boolean) objZ).booleanValue()) {
                    r92 lifecycle2 = d83Var.getLifecycle();
                    gm0 gm0Var4 = qv0.a;
                    tq1 tq1Var2 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ02 = tq1Var2.q0(cf0Var);
                    if (!zQ02) {
                        if (lifecycle2.b() == q92Var) {
                            vp1.m();
                        } else if (lifecycle2.b().compareTo(q92Var2) >= 0) {
                            y3 y3Var2 = d83Var.b;
                            y3Var2.getClass();
                            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                            coordinatorLayout2.getClass();
                            r25.R(coordinatorLayout2, R.string.webdav_upload_failure, new Object[0]);
                        }
                    }
                    s73 s73Var = new s73(d83Var, i3);
                    this.Y = 3;
                    if (ji0.V(lifecycle2, q92Var2, zQ02, tq1Var2, s73Var, this) != mf0Var) {
                    }
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SharedPreferences.Editor editorEdit = t23.l().edit();
                    editorEdit.putLong("webdav_last_time_upload", jCurrentTimeMillis);
                    editorEdit.apply();
                    obj3 = null;
                    r92 lifecycle3 = d83Var.getLifecycle();
                    gm0 gm0Var5 = qv0.a;
                    tq1 tq1Var3 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ03 = tq1Var3.q0(cf0Var);
                    if (!zQ03) {
                        if (lifecycle3.b() == q92Var) {
                            vp1.m();
                        } else if (lifecycle3.b().compareTo(q92Var2) >= 0) {
                            y3 y3Var3 = d83Var.b;
                            y3Var3.getClass();
                            CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) y3Var3.a;
                            coordinatorLayout3.getClass();
                            r25.R(coordinatorLayout3, R.string.webdav_upload_success, new Object[0]);
                        }
                    }
                    s73 s73Var2 = new s73(d83Var, i2);
                    this.Y = 2;
                    if (ji0.V(lifecycle3, q92Var2, zQ03, tq1Var3, s73Var2, this) != mf0Var) {
                    }
                }
                break;
            default:
                lf0 lf0Var = (lf0) this.y0;
                int i9 = this.Y;
                if (i9 == 0) {
                    n12.S(obj);
                    d83 d83Var2 = (d83) obj2;
                    r92 lifecycle4 = d83Var2.getLifecycle();
                    gm0 gm0Var6 = qv0.a;
                    tq1 tq1Var4 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ04 = tq1Var4.q0(cf0Var);
                    q92 q92Var3 = q92.z;
                    if (!zQ04) {
                        if (lifecycle4.b() == q92Var) {
                            vp1.m();
                        } else if (lifecycle4.b().compareTo(q92Var3) >= 0) {
                            y3 y3Var4 = d83Var2.b;
                            y3Var4.getClass();
                            ((LinearProgressIndicator) y3Var4.g).e();
                            ji0.B(lf0Var, null, null, new bi0((ge0) null, d83Var2, z), 3);
                            y3 y3Var5 = d83Var2.b;
                            y3Var5.getClass();
                            ((LinearProgressIndicator) y3Var5.g).b();
                        }
                    }
                    n63 n63Var = new n63(i4, d83Var2, lf0Var, z);
                    this.y0 = null;
                    this.Y = 1;
                    if (ji0.V(lifecycle4, q92Var3, zQ04, tq1Var4, n63Var, this) == mf0Var) {
                    }
                    break;
                } else if (i9 == 1) {
                    n12.S(obj);
                } else {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                }
                break;
        }
        return mf0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(ge0 ge0Var, d83 d83Var, boolean z) {
        super(2, ge0Var);
        this.z0 = d83Var;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(String str, String str2, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = str;
        this.z0 = str2;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(List list, boolean z, d83 d83Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = list;
        this.Z = z;
        this.z0 = d83Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(boolean z, String str, eg0 eg0Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = z;
        this.y0 = str;
        this.z0 = eg0Var;
    }
}
