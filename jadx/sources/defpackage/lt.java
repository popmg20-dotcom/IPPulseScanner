package defpackage;

import android.os.Process;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lt extends v74 implements Function2 {
    public final /* synthetic */ int X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lt(int i, ge0 ge0Var, int i2) {
        super(i, ge0Var);
        this.X = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws JSONException {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                break;
            case 1:
                ((lt) n((ge0) obj2, (ag1) obj)).p(xl4Var);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                ((lt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                ((lt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                break;
            case 8:
                ((lt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                break;
            default:
                ((lt) n((ge0) obj2, (ag1) obj)).p(xl4Var);
                break;
        }
        return xl4Var;
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        switch (this.X) {
            case 0:
                return new lt(2, ge0Var, 0);
            case 1:
                return new lt(2, ge0Var, 1);
            case 2:
                return new lt(2, ge0Var, 2);
            case 3:
                return new lt(2, ge0Var, 3);
            case 4:
                return new lt(2, ge0Var, 4);
            case 5:
                return new lt(2, ge0Var, 5);
            case 6:
                return new lt(2, ge0Var, 6);
            case 7:
                return new lt(2, ge0Var, 7);
            case 8:
                return new lt(2, ge0Var, 8);
            default:
                return new lt(2, ge0Var, 9);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) throws JSONException {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                n12.S(obj);
                JSONObject jSONObject = new JSONObject(String.valueOf(co4.O()));
                String string = jSONObject.getString(RtspHeaders.Values.MODE);
                if (!n12.c(string, "allowed") && !n12.c(string, "disallowed")) {
                    throw new JSONException(ha0.n("unknown mode: ", string));
                }
                boolean zC = n12.c(string, "allowed");
                JSONArray jSONArray = jSONObject.getJSONArray("package_name");
                Boolean boolValueOf = Boolean.valueOf(zC);
                HashSet hashSet = new HashSet();
                int length = jSONArray.length();
                while (i < length) {
                    hashSet.add(jSONArray.getString(i));
                    i++;
                }
                return new e03(boolValueOf, hashSet);
            case 1:
                n12.S(obj);
                return xl4Var;
            case 2:
                n12.S(obj);
                SimpleDateFormat simpleDateFormat = g81.a;
                return g81.c(ContextUtilsKt.a());
            case 3:
                n12.S(obj);
                String[] list = new File(ha0.k("/proc/", Process.myPid(), "/fd")).list();
                return new Integer(list != null ? list.length : 0);
            case 4:
                n12.S(obj);
                ko1.e.delete();
                ko1 ko1Var = ko1.a;
                ko1.c(null);
                ko1.b(null);
                return xl4Var;
            case 5:
                n12.S(obj);
                SimpleDateFormat simpleDateFormat2 = g81.a;
                return d70.e0(g81.c(ContextUtilsKt.a()));
            case 6:
                n12.S(obj);
                t53 t53Var = (t53) d73.c.d();
                if (t53Var != null) {
                    return t53Var;
                }
                String strA = i73.a();
                if (strA == null || !d73.g(strA).exists()) {
                    return null;
                }
                Serializable serializableJ = c63.j(strA, new FileInputStream(d73.g(strA)), k01.A, t60.Y, vd3.A, null);
                if (serializableJ instanceof tk3) {
                    serializableJ = null;
                }
                e03 e03Var = (e03) serializableJ;
                if (e03Var != null) {
                    return (t53) e03Var.b;
                }
                return null;
            case 7:
                n12.S(obj);
                p95.C(R.string.decode_image_failed, new Object[0]);
                return xl4Var;
            case 8:
                n12.S(obj);
                p95.C(R.string.qrcode_not_found, new Object[0]);
                return xl4Var;
            default:
                n12.S(obj);
                return xl4Var;
        }
    }
}
