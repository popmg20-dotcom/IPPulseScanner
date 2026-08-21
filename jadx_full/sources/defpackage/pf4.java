package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import androidx.preference.Preference;
import com.getsurfboard.R;
import com.getsurfboard.ui.fragment.ToolsFragment;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pf4 extends v74 implements Function2 {
    public final /* synthetic */ int X = 1;
    public int Y;
    public final /* synthetic */ Preference Z;
    public final /* synthetic */ ToolsFragment y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf4(Preference preference, ToolsFragment toolsFragment, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = preference;
        this.y0 = toolsFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((pf4) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        ToolsFragment toolsFragment = this.y0;
        Preference preference = this.Z;
        switch (i) {
            case 0:
                return new pf4(toolsFragment, preference, ge0Var);
            default:
                return new pf4(preference, toolsFragment, ge0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7 A[Catch: IOException -> 0x001e, IllegalArgumentException -> 0x0021, ActivityNotFoundException -> 0x0024, TRY_LEAVE, TryCatch #2 {ActivityNotFoundException -> 0x0024, IOException -> 0x001e, IllegalArgumentException -> 0x0021, blocks: (B:8:0x0019, B:17:0x002d, B:23:0x0048, B:25:0x0090, B:27:0x0098, B:29:0x00a2, B:30:0x00b1, B:31:0x00b6, B:32:0x00b7, B:20:0x0035), top: B:49:0x0013 }] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        Object objB0;
        int i = this.X;
        mf0 mf0Var = mf0.b;
        Preference preference = this.Z;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 != 0) {
                    if (i2 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                Context context = preference.b;
                context.getClass();
                this.Y = 1;
                gm0 gm0Var = qv0.a;
                Object objB02 = ji0.b0(pl0.z, new hk2(context, null, 1), this);
                return objB02 == mf0Var ? mf0Var : objB02;
            default:
                int i3 = this.Y;
                ToolsFragment toolsFragment = this.y0;
                try {
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    p95.C(R.string.share_failed, new Object[0]);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    p95.C(R.string.io_error, new Object[0]);
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    p95.C(R.string.unknown_error, new Object[0]);
                }
                if (i3 == 0) {
                    n12.S(obj);
                    gm0 gm0Var2 = qv0.a;
                    pl0 pl0Var = pl0.z;
                    pf4 pf4Var = new pf4(toolsFragment, preference, (ge0) null);
                    this.Y = 1;
                    objB0 = ji0.b0(pl0Var, pf4Var, this);
                    if (objB0 == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            n12.S(obj);
                            return xl4.a;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objB0 = obj;
                }
                Context context2 = preference.b;
                Uri uriC = FileProvider.c(context2, context2.getPackageName() + ".files_provider", (File) objB0);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", uriC);
                intent.setType("application/zip");
                intent.addFlags(1);
                r92 lifecycle = toolsFragment.getLifecycle();
                q92 q92Var = q92.z;
                gm0 gm0Var3 = qv0.a;
                tq1 tq1Var = qf2.a.X;
                cf0 cf0Var = this.f;
                cf0Var.getClass();
                boolean zQ0 = tq1Var.q0(cf0Var);
                if (zQ0) {
                    kt ktVar = new kt(13, toolsFragment, intent);
                    this.Y = 2;
                    if (ji0.V(lifecycle, q92Var, zQ0, tq1Var, ktVar, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (lifecycle.b() == q92.b) {
                        throw new x92(null);
                    }
                    if (lifecycle.b().compareTo(q92Var) >= 0) {
                        toolsFragment.startActivity(Intent.createChooser(intent, toolsFragment.getString(R.string.send_log)));
                    }
                }
                return xl4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf4(ToolsFragment toolsFragment, Preference preference, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = toolsFragment;
        this.Z = preference;
    }
}
