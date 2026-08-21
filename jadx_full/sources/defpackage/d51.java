package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d51 extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public Object B0;
    public Object C0;
    public final /* synthetic */ Object D0;
    public final /* synthetic */ int X = 0;
    public int Y;
    public Object Z;
    public final /* synthetic */ Object y0;
    public Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(g51 g51Var, ry1 ry1Var, Object obj, rw2 rw2Var, z51 z51Var, tj2 tj2Var, e10 e10Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = g51Var;
        this.y0 = ry1Var;
        this.z0 = obj;
        this.B0 = rw2Var;
        this.A0 = z51Var;
        this.C0 = tj2Var;
        this.D0 = e10Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((d51) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.A0;
        Object obj3 = this.y0;
        Object obj4 = this.D0;
        switch (i) {
            case 0:
                return new d51((g51) this.Z, (bh3) this.B0, (bh3) this.C0, (ry1) obj3, this.z0, (bh3) obj4, (z51) obj2, ge0Var);
            case 1:
                return new d51((g51) this.Z, (ry1) obj3, this.z0, (rw2) this.B0, (z51) obj2, (tj2) this.C0, (e10) obj4, ge0Var);
            default:
                return new d51((lz1) obj4, (String) obj3, (String) obj2, ge0Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
    
        if (defpackage.d73.j(r4, r5) == r13) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f8 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:9:0x0029, B:28:0x008d, B:30:0x00b3, B:32:0x00d5, B:34:0x00e3, B:36:0x00e7, B:37:0x00ea, B:39:0x00f8, B:42:0x0100, B:44:0x0120, B:46:0x0142, B:48:0x0150, B:50:0x0154, B:14:0x0037, B:23:0x0063, B:25:0x0071, B:17:0x0045), top: B:128:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0224  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws Throwable {
        Object objB;
        we3 we3Var;
        Bitmap bitmap;
        boolean z;
        Object objV;
        Object obj2;
        lz1 lz1Var;
        String str;
        e03 e03Var;
        Throwable thA;
        String str2;
        String str3;
        String str4;
        String str5;
        d51 d51Var = this;
        switch (d51Var.X) {
            case 0:
                mf0 mf0Var = mf0.b;
                int i = d51Var.Y;
                if (i != 0) {
                    if (i == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                g51 g51Var = (g51) d51Var.Z;
                pz3 pz3Var = (pz3) ((bh3) d51Var.B0).b;
                o90 o90Var = (o90) ((bh3) d51Var.C0).b;
                ry1 ry1Var = (ry1) d51Var.y0;
                Object obj3 = d51Var.z0;
                rw2 rw2Var = (rw2) ((bh3) d51Var.D0).b;
                z51 z51Var = (z51) d51Var.A0;
                d51Var.Y = 1;
                Object objA = g51Var.a(pz3Var, o90Var, ry1Var, obj3, rw2Var, z51Var, d51Var);
                return objA == mf0Var ? mf0Var : objA;
            case 1:
                mf0 mf0Var2 = mf0.b;
                int i2 = d51Var.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    g51 g51Var2 = (g51) d51Var.Z;
                    ry1 ry1Var2 = (ry1) d51Var.y0;
                    Object obj4 = d51Var.z0;
                    rw2 rw2Var2 = (rw2) d51Var.B0;
                    z51 z51Var2 = (z51) d51Var.A0;
                    d51Var.Y = 1;
                    objB = g51Var2.b(ry1Var2, obj4, rw2Var2, z51Var2, d51Var);
                    if (objB == mf0Var2) {
                        return mf0Var2;
                    }
                } else {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objB = obj;
                }
                a51 a51Var = (a51) objB;
                x84 x84Var = ((g51) d51Var.Z).b;
                synchronized (x84Var) {
                    try {
                        te3 te3Var = (te3) x84Var.b.get();
                        if (te3Var == null) {
                            x84Var.b();
                        } else if (x84Var.f == null) {
                            Context context = te3Var.a;
                            x84Var.f = context;
                            context.registerComponentCallbacks(x84Var);
                        }
                    } finally {
                    }
                }
                oj1 oj1Var = ((g51) d51Var.Z).d;
                tj2 tj2Var = (tj2) d51Var.C0;
                if (((ry1) d51Var.y0).k.f && (we3Var = (we3) ((te3) oj1Var.f).c.getValue()) != null && tj2Var != null) {
                    Drawable drawable = a51Var.a;
                    BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                    if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
                        z = false;
                    } else {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("coil#is_sampled", Boolean.valueOf(a51Var.b));
                        String str6 = a51Var.d;
                        if (str6 != null) {
                            linkedHashMap.put("coil#disk_cache_key", str6);
                        }
                        we3Var.a.d(new tj2(tj2Var.b, ke0.I(tj2Var.f)), bitmap, ke0.I(linkedHashMap));
                        z = true;
                    }
                }
                Drawable drawable2 = a51Var.a;
                ry1 ry1Var3 = (ry1) d51Var.y0;
                pi0 pi0Var = a51Var.c;
                tj2 tj2Var2 = z ? (tj2) d51Var.C0 : null;
                String str7 = a51Var.d;
                boolean z2 = a51Var.b;
                e10 e10Var = (e10) d51Var.D0;
                Bitmap.Config config = j.a;
                return new l54(drawable2, ry1Var3, pi0Var, tj2Var2, str7, z2, e10Var != null && e10Var.f);
            default:
                kz1 kz1Var = kz1.A;
                mf0 mf0Var3 = mf0.b;
                int i3 = d51Var.Y;
                try {
                } catch (Exception e) {
                    e = e;
                }
                if (i3 == 0) {
                    n12.S(obj);
                    ((lz1) d51Var.D0).b = kz1.f;
                    vd3 vd3Var = vd3.Z;
                    String str8 = (String) d51Var.y0;
                    d51Var.Y = 1;
                    try {
                        objV = vd3Var.v(str8, null, false, 30000L, this);
                        d51Var = this;
                        if (objV != mf0Var3) {
                        }
                        return mf0Var3;
                    } catch (Exception e2) {
                        e = e2;
                        d51Var = this;
                        lz1 lz1Var2 = (lz1) d51Var.D0;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Internal error";
                        }
                        lz1Var2.d = message;
                        ((lz1) d51Var.D0).b = kz1Var;
                        String strU = fw.u("Import URL task ", (String) d51Var.A0, " failed: ", e.getMessage());
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("ExplorerServer", strU, null);
                        }
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        e03Var = (e03) d51Var.C0;
                        str = (String) d51Var.B0;
                        lz1Var = (lz1) d51Var.Z;
                        obj2 = d51Var.z0;
                        n12.S(obj);
                        lz1Var.c = e03Var;
                        lz1Var.b = kz1.z;
                        String str9 = "Import URL task " + str + " completed: " + ((t53) e03Var.b).b;
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str9);
                            str4 = "ExplorerServer";
                            str5 = str9;
                        } else {
                            str4 = "ExplorerServer";
                            str5 = str9;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d(str4, str5, null);
                        }
                        lz1 lz1Var3 = (lz1) d51Var.D0;
                        String str10 = (String) d51Var.A0;
                        thA = uk3.a(obj2);
                        if (thA != null) {
                            String message2 = thA.getMessage();
                            if (message2 == null) {
                                message2 = "Import failed";
                            }
                            lz1Var3.d = message2;
                            lz1Var3.b = kz1Var;
                            String str11 = "Import URL task " + str10 + " failed: " + thA.getMessage();
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str11);
                                str2 = "ExplorerServer";
                                str3 = str11;
                            } else {
                                str2 = "ExplorerServer";
                                str3 = str11;
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d(str2, str3, null);
                            }
                            break;
                        }
                        return xl4.a;
                    }
                    n12.S(obj);
                    objV = ((uk3) obj).b;
                }
                obj2 = objV;
                lz1Var = (lz1) d51Var.D0;
                str = (String) d51Var.A0;
                if (!(obj2 instanceof tk3)) {
                    e03Var = (e03) obj2;
                    e1 e1Var = d73.a;
                    e03[] e03VarArr = {e03Var};
                    d51Var.z0 = obj2;
                    d51Var.Z = lz1Var;
                    d51Var.B0 = str;
                    d51Var.C0 = e03Var;
                    d51Var.Y = 2;
                    break;
                }
                lz1 lz1Var32 = (lz1) d51Var.D0;
                String str102 = (String) d51Var.A0;
                thA = uk3.a(obj2);
                if (thA != null) {
                }
                return xl4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(g51 g51Var, bh3 bh3Var, bh3 bh3Var2, ry1 ry1Var, Object obj, bh3 bh3Var3, z51 z51Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = g51Var;
        this.B0 = bh3Var;
        this.C0 = bh3Var2;
        this.y0 = ry1Var;
        this.z0 = obj;
        this.D0 = bh3Var3;
        this.A0 = z51Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(lz1 lz1Var, String str, String str2, ge0 ge0Var) {
        super(2, ge0Var);
        this.D0 = lz1Var;
        this.y0 = str;
        this.A0 = str2;
    }
}
