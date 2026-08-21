package defpackage;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ml0 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ nl0 b;

    public /* synthetic */ ml0(nl0 nl0Var, int i) {
        this.a = i;
        this.b = nl0Var;
    }

    private final Object a() {
        String string;
        nl0 nl0Var = this.b;
        synchronized (nl0Var) {
            try {
                tr1 tr1Var = (tr1) nl0Var.a.get();
                ArrayList arrayListC = tr1Var.c();
                tr1Var.b();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayListC.size(); i++) {
                    ug ugVar = (ug) arrayListC.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", ugVar.a);
                    jSONObject.put("dates", new JSONArray((Collection) ugVar.b));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.a) {
            case 0:
                return a();
            default:
                nl0 nl0Var = this.b;
                synchronized (nl0Var) {
                    tr1 tr1Var = (tr1) nl0Var.a.get();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    an0 an0Var = (an0) nl0Var.c.get();
                    cp1 cp1Var = an0Var.b;
                    boolean zIsEmpty = cp1Var.Y().isEmpty();
                    String str = an0Var.a;
                    if (!zIsEmpty) {
                        str = str + ' ' + an0.a(cp1Var.Y());
                    }
                    tr1Var.g(jCurrentTimeMillis, str);
                    break;
                }
                return null;
        }
    }
}
