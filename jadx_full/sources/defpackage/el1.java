package defpackage;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import android.os.Process;
import android.util.Log;
import android.view.View;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import com.tencent.mars.xlog.Xlog;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class el1 implements fm1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ el1(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.fm1
    public final Object i(Object obj, Object obj2, Object obj3, Object obj4) {
        int i = this.b;
        Object obj5 = this.f;
        switch (i) {
            case 0:
                SQLiteCursorDriver sQLiteCursorDriver = (SQLiteCursorDriver) obj2;
                String str = (String) obj3;
                SQLiteQuery sQLiteQuery = (SQLiteQuery) obj4;
                sQLiteQuery.getClass();
                ml1 ml1Var = new ml1(sQLiteQuery);
                j64 j64Var = (j64) ((oj1) obj5).f;
                int length = j64Var.A.length;
                for (int i2 = 1; i2 < length; i2++) {
                    int i3 = j64Var.A[i2];
                    if (i3 == 1) {
                        ml1Var.j(i2, j64Var.X[i2]);
                    } else if (i3 == 2) {
                        ml1Var.z(i2, j64Var.Y[i2]);
                    } else if (i3 == 3) {
                        String str2 = j64Var.Z[i2];
                        str2.getClass();
                        ml1Var.r(i2, str2);
                    } else if (i3 == 4) {
                        byte[] bArr = j64Var.y0[i2];
                        bArr.getClass();
                        ml1Var.k(i2, bArr);
                    } else if (i3 == 5) {
                        ml1Var.l(i2);
                    }
                }
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            case 1:
                String str3 = (String) obj5;
                String str4 = (String) obj;
                String str5 = (String) obj2;
                str4.getClass();
                str5.getClass();
                String str6 = "manual speedometer finished with: best = " + ((String) obj3);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("Jni", str6, null);
                }
                b04.a(str4, str5, str3);
                return xl4.a;
            default:
                final OverrideDoHActivity overrideDoHActivity = (OverrideDoHActivity) obj5;
                View view = (View) obj;
                View view2 = (View) obj2;
                final int iIntValue = ((Integer) obj3).intValue();
                final String str7 = (String) obj4;
                int i4 = OverrideDoHActivity.X0;
                view.getClass();
                view2.getClass();
                str7.getClass();
                overrideDoHActivity.U0 = view2;
                n02 n02Var = new n02(overrideDoHActivity, view);
                nk2 nk2Var = (nk2) n02Var.f;
                nk2Var.add(0, 0, 0, R.string.edit);
                nk2Var.add(0, 1, 1, R.string.delete);
                n02Var.A = new f23() { // from class: sx2
                    @Override // defpackage.f23
                    public final boolean a(sk2 sk2Var) {
                        int i5 = OverrideDoHActivity.X0;
                        int i6 = sk2Var.a;
                        OverrideDoHActivity overrideDoHActivity2 = overrideDoHActivity;
                        int i7 = iIntValue;
                        if (i6 == 0) {
                            overrideDoHActivity2.y(i7, str7);
                            return true;
                        }
                        if (i6 != 1) {
                            return true;
                        }
                        overrideDoHActivity2.x(i7);
                        return true;
                    }
                };
                al2 al2Var = (al2) n02Var.z;
                if (!al2Var.b()) {
                    if (al2Var.e == null) {
                        xe.q("MenuPopupHelper cannot be used without an anchor");
                        return null;
                    }
                    al2Var.d(0, 0, false, false);
                }
                return xl4.a;
        }
    }
}
