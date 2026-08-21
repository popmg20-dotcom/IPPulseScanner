package defpackage;

import android.content.ContentValues;
import android.net.Network;
import android.net.Uri;
import android.os.Environment;
import android.os.Process;
import android.provider.MediaStore;
import android.util.Log;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tencent.mars.xlog.Xlog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y74 extends v74 implements Function2 {
    public LinearProgressIndicator A0;
    public InputStream B0;
    public Closeable C0;
    public OutputStream D0;
    public byte[] E0;
    public ah3 F0;
    public int G0;
    public int H0;
    public int I0;
    public final /* synthetic */ b84 J0;
    public final /* synthetic */ boolean K0;
    public final /* synthetic */ String L0;
    public final /* synthetic */ Network M0;
    public final /* synthetic */ LinearProgressIndicator N0;
    public ContentValues X;
    public Uri Y;
    public HttpURLConnection Z;
    public Long y0;
    public Closeable z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y74(b84 b84Var, boolean z, String str, Network network, LinearProgressIndicator linearProgressIndicator, ge0 ge0Var) {
        super(2, ge0Var);
        this.J0 = b84Var;
        this.K0 = z;
        this.L0 = str;
        this.M0 = network;
        this.N0 = linearProgressIndicator;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((y74) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new y74(this.J0, this.K0, this.L0, this.M0, this.N0, ge0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f7  */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.String, java.lang.String[], java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01da -> B:96:0x01dd). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws IOException {
        Throwable th;
        ?? r14;
        Throwable th2;
        ?? inputStream;
        Closeable closeable;
        ContentValues contentValues;
        Uri uriInsert;
        HttpURLConnection httpURLConnection;
        Long lN0;
        b84 b84Var;
        LinearProgressIndicator linearProgressIndicator;
        String str;
        Uri uri;
        ContentValues contentValues2;
        Long l;
        Closeable closeable2;
        ?? r29;
        int i;
        ah3 ah3Var;
        int i2;
        ?? r142;
        LinearProgressIndicator linearProgressIndicator2;
        byte[] bArr;
        int i3;
        ?? r143;
        ?? r13;
        ?? r132;
        mf0 mf0Var = mf0.b;
        int i4 = this.I0;
        String str2 = "is_pending";
        ?? r12 = 0;
        Throwable th3 = null;
        try {
            try {
                if (i4 == 0) {
                    n12.S(obj);
                    contentValues = new ContentValues();
                    String str3 = this.L0;
                    boolean z = this.K0;
                    contentValues.put("_display_name", str3);
                    contentValues.put("mime_type", z ? "image/jpeg" : "video/mp4");
                    contentValues.put("relative_path", (z ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES) + "/Nintendo Switch");
                    contentValues.put("is_pending", new Integer(1));
                    uriInsert = this.J0.requireContext().getContentResolver().insert(this.K0 ? MediaStore.Images.Media.getContentUri("external_primary") : MediaStore.Video.Media.getContentUri("external_primary"), contentValues);
                    if (uriInsert == null) {
                        xe.q("get media uri return null");
                        return null;
                    }
                    URL url = new URL(ha0.n("http://192.168.0.1/img/", this.L0));
                    String str4 = "saveMediaFile from " + url + " to " + uriInsert;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "SwitchMediaImportDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str4);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("SwitchMediaImportDialogFragment", str4, null);
                    }
                    URLConnection uRLConnectionOpenConnection = this.M0.openConnection(url);
                    uRLConnectionOpenConnection.getClass();
                    httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() / 100 != 2) {
                        throw new IllegalStateException((httpURLConnection.getURL() + " return response code " + httpURLConnection.getResponseCode()).toString());
                    }
                    String headerField = httpURLConnection.getHeaderField("Content-Length");
                    lN0 = headerField != null ? w44.n0(headerField) : null;
                    gm0 gm0Var = qv0.a;
                    tq1 tq1Var = qf2.a;
                    gd gdVar = new gd(this.N0, lN0, null, 18);
                    this.X = contentValues;
                    this.Y = uriInsert;
                    this.Z = httpURLConnection;
                    this.y0 = lN0;
                    this.I0 = 1;
                    if (ji0.b0(tq1Var, gdVar, this) == mf0Var) {
                        return mf0Var;
                    }
                } else if (i4 == 1) {
                    lN0 = this.y0;
                    httpURLConnection = this.Z;
                    uriInsert = this.Y;
                    contentValues = this.X;
                    n12.S(obj);
                } else {
                    if (i4 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i = this.H0;
                    i3 = this.G0;
                    ah3 ah3Var2 = this.F0;
                    byte[] bArr2 = this.E0;
                    OutputStream outputStream = this.D0;
                    Closeable closeable3 = this.C0;
                    InputStream inputStream2 = this.B0;
                    LinearProgressIndicator linearProgressIndicator3 = this.A0;
                    Closeable closeable4 = this.z0;
                    Long l2 = this.y0;
                    uri = this.Y;
                    contentValues2 = this.X;
                    n12.S(obj);
                    String str5 = "is_pending";
                    ?? r292 = closeable4;
                    ?? r144 = outputStream;
                    linearProgressIndicator2 = linearProgressIndicator3;
                    ?? r133 = inputStream2;
                    l = l2;
                    closeable2 = closeable3;
                    ah3Var = ah3Var2;
                    bArr = bArr2;
                    mf0 mf0Var2 = mf0Var;
                    try {
                        mf0 mf0Var3 = mf0Var2;
                        i2 = r133.read(bArr);
                        mf0Var = mf0Var3;
                        str2 = str5;
                        th3 = null;
                        r13 = r133;
                        r142 = r144;
                        r29 = r292;
                        if (i2 >= 0) {
                            try {
                                try {
                                    r142.write(bArr, 0, i2);
                                    Long l3 = l;
                                    ah3Var.b += (long) i2;
                                    gm0 gm0Var2 = qv0.a;
                                    tq1 tq1Var2 = qf2.a;
                                    ?? r11 = r13;
                                    mf0 mf0Var4 = mf0Var;
                                    str5 = str2;
                                    linearProgressIndicator2 = linearProgressIndicator2;
                                    l = l3;
                                    ej ejVar = new ej(linearProgressIndicator2, ah3Var, l, null, 7);
                                    this.X = contentValues2;
                                    this.Y = uri;
                                    this.Z = null;
                                    this.y0 = l;
                                    this.z0 = r132;
                                    this.A0 = linearProgressIndicator2;
                                    this.B0 = r11;
                                    this.C0 = closeable2;
                                    this.D0 = r142;
                                    this.E0 = bArr;
                                    this.F0 = ah3Var;
                                    this.G0 = i3;
                                    this.H0 = i;
                                    this.I0 = 2;
                                    Object objB0 = ji0.b0(tq1Var2, ejVar, this);
                                    mf0Var2 = mf0Var4;
                                    if (objB0 == mf0Var2) {
                                        return mf0Var2;
                                    }
                                    r292 = r132;
                                    r133 = r11;
                                    r144 = r142;
                                    mf0 mf0Var32 = mf0Var2;
                                    i2 = r133.read(bArr);
                                    mf0Var = mf0Var32;
                                    str2 = str5;
                                    th3 = null;
                                    r13 = r133;
                                    r142 = r144;
                                    r29 = r292;
                                    if (i2 >= 0) {
                                        str = str2;
                                        ?? r134 = r29;
                                        try {
                                            Uri uri2 = uri;
                                            contentValues = contentValues2;
                                            uriInsert = uri2;
                                            r143 = r134;
                                            r12 = 0;
                                            ez4.l(r143, r12);
                                            contentValues.clear();
                                            contentValues.put(str, new Integer(0));
                                            this.J0.requireContext().getContentResolver().update(uriInsert, contentValues, r12, r12);
                                            return uriInsert;
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            r14 = r134;
                                            try {
                                                throw th2;
                                            } finally {
                                                ez4.l(r14, th2);
                                            }
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    r132 = r29;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                th = th;
                                inputStream = r132;
                                closeable = closeable2;
                                try {
                                    throw th;
                                } catch (Throwable th7) {
                                    ez4.l(closeable, th);
                                    throw th7;
                                }
                            }
                            r132 = r29;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        closeable = closeable2;
                        inputStream = r292;
                        throw th;
                    }
                }
                OutputStream outputStreamOpenOutputStream = b84Var.requireContext().getContentResolver().openOutputStream(uriInsert);
                if (outputStreamOpenOutputStream == null) {
                    str = "is_pending";
                    r143 = inputStream;
                    ez4.l(r143, r12);
                    contentValues.clear();
                    contentValues.put(str, new Integer(0));
                    this.J0.requireContext().getContentResolver().update(uriInsert, contentValues, r12, r12);
                    return uriInsert;
                }
                byte[] bArr3 = new byte[16384];
                ContentValues contentValues3 = contentValues;
                uri = uriInsert;
                contentValues2 = contentValues3;
                l = lN0;
                closeable2 = outputStreamOpenOutputStream;
                ?? r135 = inputStream;
                r29 = r135;
                i = 0;
                ah3Var = new ah3();
                i2 = inputStream.read(bArr3);
                r142 = closeable2;
                linearProgressIndicator2 = linearProgressIndicator;
                bArr = bArr3;
                i3 = 0;
                r13 = r135;
                if (i2 >= 0) {
                }
            } catch (Throwable th9) {
                th2 = th9;
                r14 = inputStream;
                throw th2;
            }
            inputStream = httpURLConnection.getInputStream();
            b84Var = this.J0;
            linearProgressIndicator = this.N0;
        } catch (Throwable th10) {
            th = th10;
        }
    }
}
