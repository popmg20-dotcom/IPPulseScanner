package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ni0 extends v74 implements am1 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ Object Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ni0(Object obj, ge0 ge0Var, int i) {
        super(1, ge0Var);
        this.X = i;
        this.Z = obj;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.Z;
        ge0 ge0Var = (ge0) obj;
        switch (i) {
            case 0:
                return new ni0((ov3) obj2, ge0Var, 0).p(xl4Var);
            default:
                return new ni0((hj0) obj2, ge0Var, 1).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) throws IOException {
        int i = this.X;
        Object obj2 = this.Z;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                int i2 = this.Y;
                xl4 xl4Var = xl4.a;
                if (i2 != 0) {
                    if (i2 == 1) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                ov3 ov3Var = (ov3) obj2;
                this.Y = 1;
                SharedPreferences.Editor editorEdit = ((SharedPreferences) ov3Var.e.getValue()).edit();
                Set set = ov3Var.f;
                if (set == null) {
                    editorEdit.clear();
                } else {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        editorEdit.remove((String) it.next());
                    }
                }
                if (!editorEdit.commit()) {
                    vp1.i("Unable to delete migrated keys from SharedPreferences.");
                    return null;
                }
                if (((SharedPreferences) ov3Var.e.getValue()).getAll().isEmpty()) {
                    Context context = ov3Var.c;
                    String str = ov3Var.d;
                    if (Build.VERSION.SDK_INT >= 24) {
                        mv3.a(context, str);
                    } else {
                        File file = new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), str.concat(".xml"));
                        File file2 = new File(file.getPath() + ".bak");
                        file.delete();
                        file2.delete();
                    }
                }
                if (set != null) {
                    set.clear();
                }
                if (xl4Var == mf0Var) {
                    return mf0Var;
                }
                return xl4Var;
            default:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    Object objG = ((hj0) obj2).g(this);
                    return objG == mf0Var ? mf0Var : objG;
                }
                if (i3 == 1) {
                    n12.S(obj);
                    return obj;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
