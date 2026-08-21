package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.hardware.camera2.CaptureResult;
import android.os.SystemClock;
import android.text.TextUtils;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fv0 implements fy {
    public long b;
    public final Object f;
    public final Object z;

    public fv0(m25 m25Var, String str, long j) {
        this.z = m25Var;
        tj4.f(str);
        this.f = str;
        this.b = m25Var.G1("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }

    public static String g(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public static int o(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public static int p(InputStream inputStream) {
        return (o(inputStream) << 24) | o(inputStream) | (o(inputStream) << 8) | (o(inputStream) << 16);
    }

    public static long q(InputStream inputStream) {
        return (((long) o(inputStream)) & 255) | ((((long) o(inputStream)) & 255) << 8) | ((((long) o(inputStream)) & 255) << 16) | ((((long) o(inputStream)) & 255) << 24) | ((((long) o(inputStream)) & 255) << 32) | ((((long) o(inputStream)) & 255) << 40) | ((((long) o(inputStream)) & 255) << 48) | ((255 & ((long) o(inputStream))) << 56);
    }

    public static String r(ev0 ev0Var) {
        return new String(t(ev0Var, q(ev0Var)), "UTF-8");
    }

    public static byte[] t(ev0 ev0Var, long j) throws IOException {
        long j2 = ev0Var.b - ev0Var.f;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(ev0Var).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sbC = fw.C("streamToBytes length=", ", maxLength=", j);
        sbC.append(j2);
        throw new IOException(sbC.toString());
    }

    public static void u(BufferedOutputStream bufferedOutputStream, int i) throws IOException {
        bufferedOutputStream.write(i & DnsRecord.CLASS_ANY);
        bufferedOutputStream.write((i >> 8) & DnsRecord.CLASS_ANY);
        bufferedOutputStream.write((i >> 16) & DnsRecord.CLASS_ANY);
        bufferedOutputStream.write((i >> 24) & DnsRecord.CLASS_ANY);
    }

    public static void v(BufferedOutputStream bufferedOutputStream, long j) throws IOException {
        bufferedOutputStream.write((byte) j);
        bufferedOutputStream.write((byte) (j >>> 8));
        bufferedOutputStream.write((byte) (j >>> 16));
        bufferedOutputStream.write((byte) (j >>> 24));
        bufferedOutputStream.write((byte) (j >>> 32));
        bufferedOutputStream.write((byte) (j >>> 40));
        bufferedOutputStream.write((byte) (j >>> 48));
        bufferedOutputStream.write((byte) (j >>> 56));
    }

    public static void w(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        v(bufferedOutputStream, bytes.length);
        bufferedOutputStream.write(bytes, 0, bytes.length);
    }

    @Override // defpackage.fy
    public pa4 a() {
        return (pa4) this.z;
    }

    @Override // defpackage.fy
    public int b() {
        fy fyVar = (fy) this.f;
        if (fyVar != null) {
            return fyVar.b();
        }
        return 1;
    }

    @Override // defpackage.fy
    public long c() {
        fy fyVar = (fy) this.f;
        if (fyVar != null) {
            return fyVar.c();
        }
        long j = this.b;
        if (j != -1) {
            return j;
        }
        xe.q("No timestamp is available.");
        return 0L;
    }

    public synchronized ju d(String str) {
        dv0 dv0Var = (dv0) ((LinkedHashMap) this.f).get(str);
        if (dv0Var == null) {
            return null;
        }
        File fileE = e(str);
        try {
            ev0 ev0Var = new ev0(new BufferedInputStream(new FileInputStream(fileE)), fileE.length());
            try {
                dv0 dv0VarA = dv0.a(ev0Var);
                if (TextUtils.equals(str, dv0VarA.b)) {
                    return dv0Var.b(t(ev0Var, ev0Var.b - ev0Var.f));
                }
                qs4.b("%s: key=%s, found=%s", fileE.getAbsolutePath(), str, dv0VarA.b);
                dv0 dv0Var2 = (dv0) ((LinkedHashMap) this.f).remove(str);
                if (dv0Var2 != null) {
                    this.b -= dv0Var2.a;
                }
                return null;
            } finally {
                ev0Var.close();
            }
        } catch (IOException e) {
            qs4.b("%s: %s", fileE.getAbsolutePath(), e.toString());
            s(str);
            return null;
        }
    }

    public File e(String str) {
        return new File(((e24) this.z).l(), g(str));
    }

    @Override // defpackage.fy
    public ey f() {
        fy fyVar = (fy) this.f;
        return fyVar != null ? fyVar.f() : ey.b;
    }

    @Override // defpackage.fy
    public cy h() {
        fy fyVar = (fy) this.f;
        return fyVar != null ? fyVar.h() : cy.b;
    }

    public synchronized void i() {
        File fileL = ((e24) this.z).l();
        if (!fileL.exists()) {
            if (!fileL.mkdirs()) {
                qs4.c("Unable to create cache dir %s", fileL.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = fileL.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                long length = file.length();
                ev0 ev0Var = new ev0(new BufferedInputStream(new FileInputStream(file)), length);
                try {
                    dv0 dv0VarA = dv0.a(ev0Var);
                    dv0VarA.a = length;
                    n(dv0VarA.b, dv0VarA);
                    ev0Var.close();
                } catch (Throwable th) {
                    ev0Var.close();
                    throw th;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    @Override // defpackage.fy
    public CaptureResult j() {
        return null;
    }

    @Override // defpackage.fy
    public dy k() {
        fy fyVar = (fy) this.f;
        return fyVar != null ? fyVar.k() : dy.b;
    }

    public void l() {
        if (this.b < 5242880) {
            return;
        }
        if (qs4.a) {
            qs4.d("Pruning old cache entries.", new Object[0]);
        }
        long j = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = ((LinkedHashMap) this.f).entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            dv0 dv0Var = (dv0) ((Map.Entry) it.next()).getValue();
            if (e(dv0Var.b).delete()) {
                this.b -= dv0Var.a;
            } else {
                String str = dv0Var.b;
                qs4.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
            }
            it.remove();
            i++;
            if (this.b < 4718592.0f) {
                break;
            }
        }
        if (qs4.a) {
            qs4.d("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    public synchronized void m(String str, ju juVar) {
        BufferedOutputStream bufferedOutputStream;
        dv0 dv0Var;
        if (this.b + ((long) juVar.a.length) <= 5242880 || r2.length <= 4718592.0f) {
            File fileE = e(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileE));
                dv0Var = new dv0(str, juVar);
            } catch (IOException unused) {
                if (!fileE.delete()) {
                    qs4.b("Could not clean up file %s", fileE.getAbsolutePath());
                }
                if (!((e24) this.z).l().exists()) {
                    qs4.b("Re-initializing cache after external clearing.", new Object[0]);
                    ((LinkedHashMap) this.f).clear();
                    this.b = 0L;
                    i();
                }
            }
            if (!dv0Var.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                qs4.b("Failed to write header for %s", fileE.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(juVar.a);
            bufferedOutputStream.close();
            dv0Var.a = fileE.length();
            n(str, dv0Var);
            l();
        }
    }

    public void n(String str, dv0 dv0Var) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f;
        if (linkedHashMap.containsKey(str)) {
            this.b = (dv0Var.a - ((dv0) linkedHashMap.get(str)).a) + this.b;
        } else {
            this.b += dv0Var.a;
        }
        linkedHashMap.put(str, dv0Var);
    }

    public synchronized void s(String str) {
        boolean zDelete = e(str).delete();
        dv0 dv0Var = (dv0) ((LinkedHashMap) this.f).remove(str);
        if (dv0Var != null) {
            this.b -= dv0Var.a;
        }
        if (!zDelete) {
            qs4.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
        }
    }

    public List x() {
        List list;
        m25 m25Var = (m25) this.z;
        k85 k85Var = (k85) m25Var.f;
        ArrayList arrayList = new ArrayList();
        String str = (String) this.f;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m25Var.K1().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{str, String.valueOf(this.b)}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j = cursorQuery.getLong(0);
                        long j2 = cursorQuery.getLong(3);
                        boolean z = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j > this.b) {
                            this.b = j;
                        }
                        try {
                            v75 v75Var = (v75) z65.I1(w75.x(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            v75Var.c();
                            ((w75) v75Var.f).D(string);
                            long j3 = cursorQuery.getLong(2);
                            v75Var.c();
                            ((w75) v75Var.f).E(j3);
                            arrayList.add(new h25(j, j2, z, (w75) v75Var.e()));
                        } catch (IOException e) {
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            t65Var.z0.c("Data loss. Failed to merge raw event. appId", t65.Z0(str), e);
                        }
                    } while (cursorQuery.moveToNext());
                } else {
                    list = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e2) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.c("Data loss. Error querying raw events batch. appId", t65.Z0(str), e2);
                list = arrayList;
            }
            return list;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public fv0(m25 m25Var, String str) {
        this.z = m25Var;
        tj4.f(str);
        this.f = str;
        this.b = -1L;
    }

    public fv0(fy fyVar, pa4 pa4Var, long j) {
        this.f = fyVar;
        this.z = pa4Var;
        this.b = j;
    }

    public fv0(e24 e24Var) {
        this.f = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.z = e24Var;
    }
}
