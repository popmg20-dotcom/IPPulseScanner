package defpackage;

import android.content.SharedPreferences;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bi0 extends v74 implements Function2 {
    public final /* synthetic */ int X = 1;
    public int Y;
    public final /* synthetic */ boolean Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi0(p10 p10Var, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = p10Var;
        this.Z = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((bi0) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.y0;
        boolean z = this.Z;
        switch (i) {
            case 0:
                return new bi0((p10) obj2, z, ge0Var);
            default:
                return new bi0(ge0Var, (d83) obj2, z);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        Object objY;
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.y0;
        boolean z = this.Z;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    hv3 hv3Var = pe4.a;
                    e03 e03Var = new e03((p10) obj2, Boolean.valueOf(z));
                    this.Y = 1;
                    if (hv3Var.h(e03Var, this) == mf0Var) {
                    }
                } else if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                break;
            default:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    String strO = t23.o("webdav_server", null);
                    strO.getClass();
                    String strO2 = t23.o("webdav_account", null);
                    strO2.getClass();
                    String strO3 = t23.o("webdav_password", null);
                    strO3.getClass();
                    e24 e24Var = new e24(strO, strO2, strO3);
                    this.Y = 1;
                    objY = e24Var.y(z, this);
                    if (objY != mf0Var) {
                    }
                } else if (i3 == 1) {
                    n12.S(obj);
                    objY = ((uk3) obj).b;
                } else if (i3 == 2 || i3 == 3 || i3 == 4) {
                    n12.S(obj);
                } else {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                }
                d83 d83Var = (d83) obj2;
                Throwable thA = uk3.a(objY);
                q92 q92Var = q92.b;
                q92 q92Var2 = q92.z;
                cf0 cf0Var = this.f;
                if (thA != null) {
                    thA.printStackTrace();
                    r92 lifecycle = d83Var.getLifecycle();
                    gm0 gm0Var = qv0.a;
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
                                message = d83Var.getString(R.string.webdav_download_failure);
                                message.getClass();
                            }
                            r25.S(coordinatorLayout, message);
                        }
                    }
                    y73 y73Var = new y73(d83Var, thA, 2);
                    this.Y = 4;
                    if (ji0.V(lifecycle, q92Var2, zQ0, tq1Var, y73Var, this) != mf0Var) {
                    }
                } else if (!((Boolean) objY).booleanValue()) {
                    r92 lifecycle2 = d83Var.getLifecycle();
                    gm0 gm0Var2 = qv0.a;
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
                            r25.R(coordinatorLayout2, R.string.webdav_download_failure, new Object[0]);
                        }
                    }
                    s73 s73Var = new s73(d83Var, 5);
                    this.Y = 3;
                    if (ji0.V(lifecycle2, q92Var2, zQ02, tq1Var2, s73Var, this) != mf0Var) {
                    }
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SharedPreferences.Editor editorEdit = t23.l().edit();
                    editorEdit.putLong("webdav_last_time_download", jCurrentTimeMillis);
                    editorEdit.apply();
                    r92 lifecycle3 = d83Var.getLifecycle();
                    gm0 gm0Var3 = qv0.a;
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
                            r25.R(coordinatorLayout3, R.string.webdav_download_success, new Object[0]);
                        }
                    }
                    s73 s73Var2 = new s73(d83Var, 4);
                    this.Y = 2;
                    if (ji0.V(lifecycle3, q92Var2, zQ03, tq1Var3, s73Var2, this) != mf0Var) {
                    }
                }
                break;
        }
        return mf0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi0(ge0 ge0Var, d83 d83Var, boolean z) {
        super(2, ge0Var);
        this.Z = z;
        this.y0 = d83Var;
    }
}
