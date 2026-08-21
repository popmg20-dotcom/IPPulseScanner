package defpackage;

import android.app.ApplicationExitInfo;
import androidx.appcompat.widget.Toolbar;
import com.getsurfboard.R;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textview.MaterialTextView;
import java.text.SimpleDateFormat;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u71 extends v74 implements Function2 {
    public int X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ v71 Z;
    public final /* synthetic */ long y0;
    public final /* synthetic */ int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u71(v71 v71Var, long j, int i, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = v71Var;
        this.y0 = j;
        this.z0 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((u71) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        u71 u71Var = new u71(this.Z, this.y0, this.z0, ge0Var);
        u71Var.Y = obj;
        return u71Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0200 A[RETURN] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        CharSequence charSequenceSubSequence;
        lf0 lf0Var = (lf0) this.Y;
        int i = this.X;
        xl4 xl4Var = xl4.a;
        v71 v71Var = this.Z;
        mf0 mf0Var = mf0.b;
        if (i == 0) {
            n12.S(obj);
            v32 v32Var = v71Var.f;
            if (v32Var != null) {
                v32Var.g(null);
            }
            v71Var.f = (v32) lf0Var.I().Z(pr1.X);
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            t71 t71Var = new t71(this.y0, this.z0, null);
            this.Y = null;
            this.X = 1;
            obj = ji0.b0(pl0Var, t71Var, this);
            if (obj != mf0Var) {
            }
            return mf0Var;
        }
        if (i != 1) {
            if (i == 2) {
                n12.S(obj);
                return xl4Var;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        n12.S(obj);
        ApplicationExitInfo applicationExitInfoA = a71.a(obj);
        h4 h4Var = v71Var.b;
        if (applicationExitInfoA == null) {
            h4Var.getClass();
            ((MaterialTextView) h4Var.c).setText(v71Var.getString(R.string.exit_record_unavailable));
            h4 h4Var2 = v71Var.b;
            h4Var2.getClass();
            ((MaterialDivider) h4Var2.j).setVisibility(8);
            h4 h4Var3 = v71Var.b;
            h4Var3.getClass();
            ((MaterialTextView) h4Var3.f).setVisibility(8);
            h4 h4Var4 = v71Var.b;
            h4Var4.getClass();
            ((CircularProgressIndicator) h4Var4.h).setVisibility(8);
            h4 h4Var5 = v71Var.b;
            h4Var5.getClass();
            ((MaterialTextView) h4Var5.e).setVisibility(8);
            h4 h4Var6 = v71Var.b;
            h4Var6.getClass();
            ((Toolbar) h4Var6.i).setTitle(v71Var.getString(R.string.exit_history));
            return xl4Var;
        }
        h4Var.getClass();
        MaterialTextView materialTextView = (MaterialTextView) h4Var.c;
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat simpleDateFormat = g81.a;
        sb.append(v71Var.getString(R.string.exit_detail_time, g81.b(applicationExitInfoA.getTimestamp())));
        sb.append('\n');
        sb.append(v71Var.getString(R.string.exit_detail_reason, g81.e(applicationExitInfoA.getReason())));
        sb.append('\n');
        sb.append(v71Var.getString(R.string.exit_detail_process, applicationExitInfoA.getProcessName(), Integer.valueOf(applicationExitInfoA.getPid())));
        sb.append('\n');
        sb.append(v71Var.getString(R.string.exit_detail_status, Integer.valueOf(applicationExitInfoA.getStatus())));
        sb.append('\n');
        int importance = applicationExitInfoA.getImportance();
        sb.append(v71Var.getString(R.string.exit_detail_importance, importance != 100 ? importance != 125 ? importance != 200 ? importance != 230 ? importance != 300 ? importance != 325 ? importance != 350 ? importance != 400 ? importance != 500 ? importance != 1000 ? ha0.k("UNKNOWN(", importance, ")") : "GONE" : "EMPTY" : "BACKGROUND" : "CANT_SAVE_STATE" : "TOP_SLEEPING" : "SERVICE" : "PERCEPTIBLE" : "VISIBLE" : "FOREGROUND_SERVICE" : "FOREGROUND"));
        sb.append('\n');
        String description = applicationExitInfoA.getDescription();
        if (description != null && description.length() != 0) {
            sb.append(v71Var.getString(R.string.exit_detail_description, applicationExitInfoA.getDescription()));
            sb.append('\n');
        }
        String string = sb.toString();
        int length = string.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!yr2.O(string.charAt(length))) {
                    charSequenceSubSequence = string.subSequence(0, length + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
            charSequenceSubSequence = "";
            materialTextView.setText(charSequenceSubSequence.toString());
            h4 h4Var7 = v71Var.b;
            h4Var7.getClass();
            Toolbar toolbar = (Toolbar) h4Var7.i;
            SimpleDateFormat simpleDateFormat2 = g81.a;
            toolbar.setTitle(g81.e(applicationExitInfoA.getReason()));
            this.Y = null;
            this.X = 2;
            if (v71Var.j(applicationExitInfoA, this) == mf0Var) {
                return xl4Var;
            }
        } else {
            charSequenceSubSequence = "";
            materialTextView.setText(charSequenceSubSequence.toString());
            h4 h4Var72 = v71Var.b;
            h4Var72.getClass();
            Toolbar toolbar2 = (Toolbar) h4Var72.i;
            SimpleDateFormat simpleDateFormat22 = g81.a;
            toolbar2.setTitle(g81.e(applicationExitInfoA.getReason()));
            this.Y = null;
            this.X = 2;
            if (v71Var.j(applicationExitInfoA, this) == mf0Var) {
            }
        }
        return mf0Var;
    }
}
