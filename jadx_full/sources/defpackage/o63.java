package defpackage;

import androidx.appcompat.widget.Toolbar;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o63 extends v74 implements Function2 {
    public int A0;
    public int B0;
    public final /* synthetic */ String C0;
    public final /* synthetic */ String D0;
    public final /* synthetic */ p53 E0;
    public final /* synthetic */ ProfileEditorActivity F0;
    public final /* synthetic */ boolean G0;
    public Object X;
    public String Y;
    public p53 Z;
    public String y0;
    public boolean z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o63(String str, String str2, p53 p53Var, ProfileEditorActivity profileEditorActivity, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.C0 = str;
        this.D0 = str2;
        this.E0 = p53Var;
        this.F0 = profileEditorActivity;
        this.G0 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((o63) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new o63(this.C0, this.D0, this.E0, this.F0, this.G0, ge0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0136, code lost:
    
        if (defpackage.ji0.V(r3, r8, r14, r9, r6, r16) == r12) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad A[Catch: all -> 0x0108, TRY_ENTER, TryCatch #1 {all -> 0x0108, blocks: (B:30:0x00a5, B:33:0x00ad, B:35:0x00b8, B:37:0x00d4, B:39:0x00da, B:41:0x00e0, B:43:0x00e4, B:45:0x00ef, B:47:0x0100, B:50:0x010b, B:51:0x010e, B:52:0x010f, B:53:0x0112, B:54:0x0113, B:55:0x0118, B:56:0x0119, B:59:0x0139, B:60:0x013c, B:61:0x013d, B:62:0x0140, B:26:0x0088), top: B:69:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013d A[Catch: all -> 0x0108, TryCatch #1 {all -> 0x0108, blocks: (B:30:0x00a5, B:33:0x00ad, B:35:0x00b8, B:37:0x00d4, B:39:0x00da, B:41:0x00e0, B:43:0x00e4, B:45:0x00ef, B:47:0x0100, B:50:0x010b, B:51:0x010e, B:52:0x010f, B:53:0x0112, B:54:0x0113, B:55:0x0118, B:56:0x0119, B:59:0x0139, B:60:0x013c, B:61:0x013d, B:62:0x0140, B:26:0x0088), top: B:69:0x0088 }] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        Object objI;
        ProfileEditorActivity profileEditorActivity;
        String str;
        boolean z;
        p53 p53Var;
        am1 am1Var;
        int i;
        cm2 cm2Var;
        int i2 = this.B0;
        String str2 = this.D0;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(obj);
            byte[] bytes = str2.getBytes(y30.a);
            bytes.getClass();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            k01 k01Var = k01.A;
            t60 t60Var = t60.Y;
            vd3 vd3Var = vd3.A;
            this.B0 = 1;
            objI = c63.i(this.C0, byteArrayInputStream, k01Var, t60Var, vd3Var, this);
            if (objI != mf0Var) {
            }
            return mf0Var;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                am1Var = (am1) this.X;
                try {
                    n12.S(obj);
                } catch (Throwable th) {
                    th = th;
                    am1Var.g(th);
                }
                return xl4.a;
            }
            i = this.A0;
            z = this.z0;
            str = this.y0;
            p53 p53Var2 = this.Z;
            str2 = this.Y;
            profileEditorActivity = (ProfileEditorActivity) this.X;
            try {
                n12.S(obj);
                p53Var = p53Var2;
                profileEditorActivity.U0 = str2;
                cm2Var = profileEditorActivity.S0;
            } catch (Throwable th2) {
                th = th2;
                am1Var = p53Var2;
                am1Var.g(th);
            }
            if (cm2Var != null) {
                n12.T("binding");
                throw null;
            }
            ((CodeEditor) cm2Var.z).setUndoEnabled(false);
            cm2 cm2Var2 = profileEditorActivity.S0;
            if (cm2Var2 == null) {
                n12.T("binding");
                throw null;
            }
            ((CodeEditor) cm2Var2.z).setUndoEnabled(true);
            fa2 fa2Var = profileEditorActivity.b;
            q92 q92Var = q92.X;
            gm0 gm0Var = qv0.a;
            tq1 tq1Var = qf2.a.X;
            cf0 cf0Var = this.f;
            cf0Var.getClass();
            boolean zQ0 = tq1Var.q0(cf0Var);
            if (!zQ0) {
                q92 q92Var2 = fa2Var.c;
                if (q92Var2 == q92.b) {
                    throw new x92(null);
                }
                if (q92Var2.compareTo(q92Var) >= 0) {
                    cm2 cm2Var3 = profileEditorActivity.S0;
                    if (cm2Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((Toolbar) cm2Var3.Z).setTitle(str);
                    cm2 cm2Var4 = profileEditorActivity.S0;
                    if (cm2Var4 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((LinearProgressIndicator) cm2Var4.A).b();
                    p95.C(R.string.profile_saved, new Object[0]);
                    if (z) {
                        profileEditorActivity.b().d();
                    }
                }
                return xl4.a;
            }
            n63 n63Var = new n63(0, profileEditorActivity, str, z);
            this.X = p53Var;
            this.Y = null;
            this.Z = null;
            this.y0 = null;
            this.A0 = i;
            this.z0 = zQ0;
            this.B0 = 3;
            am1Var.g(th);
            return xl4.a;
        }
        n12.S(obj);
        objI = ((uk3) obj).b;
        profileEditorActivity = this.F0;
        str = this.C0;
        z = this.G0;
        Throwable thA = uk3.a(objI);
        p53Var = this.E0;
        if (thA != null) {
            p53Var.g(thA);
            return xl4.a;
        }
        e03 e03Var = (e03) objI;
        try {
            e1 e1Var = d73.a;
            e03[] e03VarArr = {e03Var};
            this.X = profileEditorActivity;
            this.Y = str2;
            this.Z = p53Var;
            this.y0 = str;
            this.z0 = z;
            this.A0 = 0;
            this.B0 = 2;
            if (d73.j(e03VarArr, this) == mf0Var) {
                return mf0Var;
            }
            i = 0;
            profileEditorActivity.U0 = str2;
            cm2Var = profileEditorActivity.S0;
            if (cm2Var != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            am1Var = p53Var;
            am1Var.g(th);
        }
    }
}
