package defpackage;

import android.net.Uri;
import com.getsurfboard.base.ContextUtilsKt;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a63 extends v74 implements Function2 {
    public final /* synthetic */ ad1 A0;
    public final /* synthetic */ Object B0;
    public final /* synthetic */ int X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ String Z;
    public final /* synthetic */ ed1 y0;
    public final /* synthetic */ cd1 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a63(String str, Object obj, ed1 ed1Var, cd1 cd1Var, ad1 ad1Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = str;
        this.B0 = obj;
        this.y0 = ed1Var;
        this.z0 = cd1Var;
        this.A0 = ad1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((a63) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        switch (this.X) {
            case 0:
                a63 a63Var = new a63(this.Z, (Uri) this.B0, this.y0, this.z0, this.A0, ge0Var, 0);
                a63Var.Y = obj;
                return a63Var;
            default:
                a63 a63Var2 = new a63(this.Z, (InputStream) this.B0, this.y0, this.z0, this.A0, ge0Var, 1);
                a63Var2.Y = obj;
                return a63Var2;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) throws FileNotFoundException {
        int i = this.X;
        Object obj2 = this.B0;
        switch (i) {
            case 0:
                lf0 lf0Var = (lf0) this.Y;
                n12.S(obj);
                InputStream inputStreamOpenInputStream = ContextUtilsKt.getContext().getContentResolver().openInputStream((Uri) obj2);
                inputStreamOpenInputStream.getClass();
                return new uk3(c63.j(this.Z, inputStreamOpenInputStream, this.y0, this.z0, this.A0, new z53(lf0Var, 0)));
            default:
                lf0 lf0Var2 = (lf0) this.Y;
                n12.S(obj);
                z53 z53Var = new z53(lf0Var2, 1);
                return new uk3(c63.j(this.Z, (InputStream) obj2, this.y0, this.z0, this.A0, z53Var));
        }
    }
}
