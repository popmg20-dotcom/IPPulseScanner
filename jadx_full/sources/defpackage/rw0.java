package defpackage;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rw0 extends aj3 {
    public final Object E0;
    public pr1 F0;

    public rw0(String str, String str2, pr1 pr1Var, pr1 pr1Var2) {
        super(str, pr1Var2);
        this.E0 = new Object();
        this.F0 = pr1Var;
    }

    @Override // defpackage.aj3
    public final void b() {
        super.b();
        synchronized (this.E0) {
            this.F0 = null;
        }
    }

    @Override // defpackage.aj3
    public final void c(Object obj) {
        pr1 pr1Var;
        synchronized (this.E0) {
            pr1Var = this.F0;
        }
        if (pr1Var != null) {
            pr1Var.p(obj);
        }
    }

    @Override // defpackage.aj3
    public final ue1 j(jr2 jr2Var) {
        try {
            return new ue1(new JSONObject(new String((byte[]) jr2Var.c, ji0.H("utf-8", (Map) jr2Var.d))), ji0.G(jr2Var));
        } catch (UnsupportedEncodingException e) {
            return new ue1(new ag(e));
        } catch (JSONException e2) {
            return new ue1(new ag(e2));
        }
    }
}
