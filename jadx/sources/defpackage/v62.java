package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.MainActivity;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DefaultDnsQuery;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import j$.util.Optional;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class v62 implements om1, wk4, w23, cr3, x44, ac1 {
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public v62(int i) {
        this.b = i;
        switch (i) {
            case 2:
                gm0 gm0Var = qv0.a;
                pl0 pl0Var = pl0.z;
                r54 r54VarD = gb4.d();
                pl0Var.getClass();
                this.f = p95.a(tj4.W(pl0Var, r54VarD));
                break;
            case 21:
                this.f = new mn2();
                this.z = new ArrayList();
                break;
            case 25:
                this.z = new AtomicReference();
                this.f = new o82(Math.min(64, 1000), 4000);
                break;
            default:
                HashMap map = new HashMap();
                this.f = map;
                u62 u62Var = new u62();
                u62Var.a = new HashMap();
                oa4 oa4Var = oa4.h;
                u62Var.a(oa4Var, il.b, null);
                oa4 oa4Var2 = oa4.g;
                u62Var.a(oa4Var2, u62.d, "tf");
                oa4 oa4Var3 = oa4.e;
                u62Var.a(oa4Var3, u62.f, "-0123456789");
                oa4 oa4Var4 = oa4.f;
                u62Var.a(oa4Var4, u62.e, "-0123456789.");
                u62Var.a(oa4Var, u62.g, "n\u0000");
                u62Var.a(oa4.m, il.c, "$");
                this.z = u62Var;
                map.put(oa4Var, new zc0());
                map.put(oa4Var2, new wc0());
                map.put(oa4Var3, new yc0());
                map.put(oa4Var4, new xc0());
                map.put(oa4.d, new vc0());
                map.put(new oa4(UUID.class), new uc0());
                map.put(new oa4(Optional.class), new sc0(u62Var));
                break;
        }
    }

    public static boolean E(byte[] bArr, int i, String str, DnsRecordType dnsRecordType) {
        DefaultDnsResponse defaultDnsResponseS = je.S(bArr);
        boolean z = false;
        if (defaultDnsResponseS == null) {
            return false;
        }
        try {
            if (defaultDnsResponseS.id() == i) {
                int iCount = defaultDnsResponseS.count(DnsSection.ANSWER);
                int i2 = 0;
                while (true) {
                    if (i2 >= iCount) {
                        break;
                    }
                    DnsRecord dnsRecordRecordAt = defaultDnsResponseS.recordAt(DnsSection.ANSWER, i2);
                    if (n12.c(dnsRecordRecordAt.type(), dnsRecordType) && w44.f0(dnsRecordRecordAt.name(), str)) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            defaultDnsResponseS.release();
            return z;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    defaultDnsResponseS.release();
                } catch (Throwable th3) {
                    ek0.b(th, th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] r(byte[] bArr) {
        DefaultDnsQuery defaultDnsQueryR = je.R(bArr);
        if (defaultDnsQueryR == null) {
            return bArr;
        }
        try {
            DnsResponseCode dnsResponseCode = DnsResponseCode.NXDOMAIN;
            dnsResponseCode.getClass();
            DefaultDnsResponse defaultDnsResponseL = je.l(defaultDnsQueryR, dnsResponseCode);
            try {
                byte[] bArrD = je.D(defaultDnsResponseL);
                defaultDnsResponseL.release();
                defaultDnsQueryR.release();
                return bArrD;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    defaultDnsQueryR.release();
                } catch (Throwable th3) {
                    ek0.b(th, th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] w(v62 v62Var, byte[] bArr, DatagramSocket datagramSocket, InetAddress inetAddress) {
        String str;
        String str2;
        byte[] bArrCopyOf;
        int iId;
        Object obj;
        String str3;
        String str4;
        v62Var.getClass();
        DefaultDnsQuery defaultDnsQueryR = je.R(bArr);
        if (defaultDnsQueryR == null) {
            return null;
        }
        try {
            DnsQuestion dnsQuestion = (DnsQuestion) defaultDnsQueryR.recordAt(DnsSection.QUESTION);
            if (dnsQuestion != null) {
                String strName = dnsQuestion.name();
                DnsRecordType dnsRecordTypeType = dnsQuestion.type();
                datagramSocket.setSoTimeout(500);
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, inetAddress, 5353);
                datagramSocket.send(datagramPacket);
                long jNanoTime = System.nanoTime();
                long j = 1000000000 + jNanoTime;
                byte[] bArr2 = new byte[9000];
                while (System.nanoTime() < j) {
                    DatagramPacket datagramPacket2 = new DatagramPacket(bArr2, 9000);
                    try {
                        datagramSocket.receive(datagramPacket2);
                        byte[] data = datagramPacket2.getData();
                        data.getClass();
                        bArrCopyOf = Arrays.copyOf(data, datagramPacket2.getLength());
                        iId = defaultDnsQueryR.id();
                        strName.getClass();
                        dnsRecordTypeType.getClass();
                    } catch (SocketTimeoutException e) {
                        String str5 = "mdns no reply, retransmit query: " + e.getMessage();
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "MdnsResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str5);
                            str = "MdnsResolver";
                            str2 = str5;
                        } else {
                            str = "MdnsResolver";
                            str2 = str5;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d(str, str2, null);
                        }
                        datagramSocket.send(datagramPacket);
                    }
                    if (E(bArrCopyOf, iId, strName, dnsRecordTypeType)) {
                        long jNanoTime2 = (System.nanoTime() - jNanoTime) / 1000000;
                        DefaultDnsResponse defaultDnsResponseS = je.S(bArrCopyOf);
                        if (defaultDnsResponseS != null) {
                            try {
                                ArrayList arrayListE = je.E(defaultDnsResponseS);
                                ArrayList arrayList = new ArrayList();
                                Iterator it = arrayListE.iterator();
                                while (it.hasNext()) {
                                    String hostAddress = ((InetAddress) it.next()).getHostAddress();
                                    if (hostAddress != null) {
                                        arrayList.add(hostAddress);
                                    }
                                }
                                defaultDnsResponseS.release();
                                obj = arrayList;
                            } finally {
                            }
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            obj = g41.b;
                        }
                        String str6 = "mdns resolved " + ke0.J(p44.G0(".", strName)) + " (" + dnsRecordTypeType.name() + ") -> " + obj + ", cost " + jNanoTime2 + "ms";
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "MdnsResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
                            str3 = "MdnsResolver";
                            str4 = str6;
                        } else {
                            str3 = "MdnsResolver";
                            str4 = str6;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d(str3, str4, null);
                        }
                        defaultDnsQueryR.release();
                        return bArrCopyOf;
                    }
                }
            }
            defaultDnsQueryR.release();
            return null;
        } finally {
        }
    }

    public int A() {
        return ((int[]) this.z).length - 1;
    }

    public ArrayList B() {
        ArrayList arrayList = new ArrayList();
        while (this != null) {
            arrayList.add((String) this.z);
            this = (v62) this.f;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public ViewGroup C() {
        return (ViewGroup) ((n84) this.z).getValue();
    }

    public void D(eh ehVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", ehVar.a);
            jSONObject.put("Status", fw.G(ehVar.b));
            jSONObject.put("AuthToken", ehVar.c);
            jSONObject.put("RefreshToken", ehVar.d);
            jSONObject.put("TokenCreationEpochInSecs", ehVar.f);
            jSONObject.put("ExpiresInSecs", ehVar.e);
            jSONObject.put("FisError", ehVar.g);
            ze1 ze1Var = (ze1) this.z;
            ze1Var.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", ze1Var.a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(z())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public boolean F() {
        return ((int[]) this.z)[0] == 0;
    }

    public v62 G(int i) {
        int[] iArr = (int[]) this.z;
        om2 om2Var = (om2) this.f;
        if (i == 0) {
            return om2Var.c;
        }
        if (i == 1) {
            return this;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2] = om2Var.c(iArr[i2], i);
        }
        return new v62(om2Var, iArr2);
    }

    public v62 H(v62 v62Var) {
        om2 om2Var = (om2) this.f;
        if (!om2Var.equals((om2) v62Var.f)) {
            xe.k("ModulusPolys do not have same ModulusGF field");
            return null;
        }
        if (F() || v62Var.F()) {
            return om2Var.c;
        }
        int[] iArr = (int[]) this.z;
        int length = iArr.length;
        int[] iArr2 = (int[]) v62Var.z;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = om2Var.a(iArr3[i4], om2Var.c(i2, iArr2[i3]));
            }
        }
        return new v62(om2Var, iArr3);
    }

    public void I(int i, int i2) {
        int[] iArr = (int[]) this.f;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        u(i3);
        int[] iArr2 = (int[]) this.f;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill((int[]) this.f, i, i3, -1);
        ArrayList arrayList = (ArrayList) this.z;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            w14 w14Var = (w14) ((ArrayList) this.z).get(size);
            int i4 = w14Var.b;
            if (i4 >= i) {
                w14Var.b = i4 + i2;
            }
        }
    }

    public void J(int i, int i2) {
        int[] iArr = (int[]) this.f;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        u(i3);
        int[] iArr2 = (int[]) this.f;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = (int[]) this.f;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.z;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            w14 w14Var = (w14) ((ArrayList) this.z).get(size);
            int i4 = w14Var.b;
            if (i4 >= i) {
                if (i4 < i3) {
                    ((ArrayList) this.z).remove(size);
                } else {
                    w14Var.b = i4 - i2;
                }
            }
        }
    }

    public jj2 K(int i) {
        Object next;
        ArrayList arrayList = (ArrayList) this.z;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((jj2) next).a == i) {
                break;
            }
        }
        jj2 jj2Var = (jj2) next;
        if (jj2Var != null) {
            arrayList.remove(jj2Var);
            arrayList.add(jj2Var);
        }
        return jj2Var;
    }

    public eh L() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(z());
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } finally {
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i2 = eh.h;
        byte b = (byte) (((byte) (0 | 2)) | 1);
        int i3 = fw.L(5)[iOptInt];
        if (i3 == 0) {
            zo2.n("Null registrationStatus");
            return null;
        }
        byte b2 = (byte) (((byte) (b | 2)) | 1);
        if (b2 == 3 && i3 != 0) {
            return new eh(strOptString, i3, strOptString2, strOptString3, jOptLong2, jOptLong, strOptString4);
        }
        StringBuilder sb = new StringBuilder();
        if (i3 == 0) {
            sb.append(" registrationStatus");
        }
        if ((b2 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b2 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        s53.j(sb, "Missing required properties:");
        return null;
    }

    public void M() {
        ViewParent parent = C().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(C());
        }
    }

    public void N(yg2 yg2Var, k23 k23Var, String str) {
        k23 k23Var2 = (k23) this.f;
        if (k23Var2 != null) {
            zo2.p("Conflicting property-based creators: already had %s creator %s, encountered another: %s", new Object[]{str, k23Var2.a, k23Var.a});
        } else {
            k23Var.b(yg2Var);
            this.f = k23Var;
        }
    }

    public void O(h73 h73Var) {
        String str = (String) this.z;
        Context context = (Context) this.f;
        context.getClass();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        layoutInflaterFrom.getClass();
        View viewInflate = layoutInflaterFrom.inflate(R.layout.dialog_naming_profile, (ViewGroup) null, false);
        TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.name);
        if (textInputLayout == null) {
            zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.name)));
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        w7 w7Var = new w7(relativeLayout, textInputLayout);
        wh2 wh2Var = new wh2(context);
        int i = R.string.rename;
        if (str != null) {
            wh2Var.x(R.string.rename);
        } else {
            wh2Var.x(R.string.profile_name);
        }
        wh2Var.y(relativeLayout);
        wh2Var.u(R.string.cancel, new ph0(3));
        if (str == null) {
            i = R.string.save;
        }
        wh2Var.w(i, new li(7, w7Var, h73Var));
        u6 u6VarH = wh2Var.h();
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
            editText.addTextChangedListener(new ri(u6VarH, w7Var));
        }
        Window window = u6VarH.getWindow();
        if (window != null) {
            window.setSoftInputMode(4);
        }
        textInputLayout.requestFocus();
        u6VarH.show();
    }

    public v62 P(v62 v62Var) {
        if (!((om2) this.f).equals((om2) v62Var.f)) {
            xe.k("ModulusPolys do not have same ModulusGF field");
            return null;
        }
        if (v62Var.F()) {
            return this;
        }
        int[] iArr = (int[]) v62Var.z;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i = 0;
        while (true) {
            om2 om2Var = (om2) v62Var.f;
            if (i >= length) {
                return n(new v62(om2Var, iArr2));
            }
            int i2 = iArr[i];
            om2Var.getClass();
            iArr2[i] = (929 - i2) % 929;
            i++;
        }
    }

    public b72 Q(nj4 nj4Var) {
        b72 b72Var;
        synchronized (this) {
            o82 o82Var = (o82) this.f;
            b72Var = (b72) ((i53) o82Var.b).get(new uj4(nj4Var));
        }
        return b72Var;
    }

    public b72 R(Class cls) {
        b72 b72Var;
        synchronized (this) {
            o82 o82Var = (o82) this.f;
            b72Var = (b72) ((i53) o82Var.b).get(new uj4(cls, false));
        }
        return b72Var;
    }

    @Override // defpackage.ac1
    public void a(View view) {
        view.getClass();
        j80 j80Var = ((RecentRequestsActivity) this.z).S0;
        if (j80Var == null) {
            n12.T("binding");
            throw null;
        }
        ((RecyclerView) j80Var.c).setItemAnimator(null);
        ((uk0) this.f).a(view);
    }

    @Override // defpackage.ac1
    public void b(View view, View view2) {
        view.getClass();
        view2.getClass();
        ((uk0) this.f).b(view, view2);
    }

    @Override // defpackage.ac1
    public boolean c() {
        return ((uk0) this.f).f;
    }

    @Override // defpackage.x44
    public void d(tj2 tj2Var, Bitmap bitmap, Map map) {
        int i;
        int iG = v02.g(bitmap);
        bf3 bf3Var = (bf3) this.z;
        synchronized (((d7) bf3Var.g)) {
            i = bf3Var.b;
        }
        bf3 bf3Var2 = (bf3) this.z;
        if (iG <= i) {
            bf3Var2.l(tj2Var, new af3(bitmap, map, iG));
        } else {
            bf3Var2.m(tj2Var);
            ((t6) this.f).p(tj2Var, bitmap, map, iG);
        }
    }

    @Override // defpackage.cr3
    public boolean e(String str) {
        ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) this.z;
        if (str == null || str.length() == 0) {
            cm2 cm2Var = profileEditorActivity.S0;
            if (cm2Var == null) {
                n12.T("binding");
                throw null;
            }
            ((CodeEditor) cm2Var.z).getSearcher().c();
        } else {
            cm2 cm2Var2 = profileEditorActivity.S0;
            if (cm2Var2 == null) {
                n12.T("binding");
                throw null;
            }
            x11 searcher = ((CodeEditor) cm2Var2.z).getSearcher();
            ue2 ue2Var = new ue2(4);
            searcher.getClass();
            if (str.isEmpty()) {
                xe.k("pattern length must be > 0");
                return false;
            }
            searcher.b = str;
            searcher.c = ue2Var;
            searcher.a();
            searcher.a.postInvalidate();
        }
        int i = ProfileEditorActivity.Y0;
        profileEditorActivity.y();
        return true;
    }

    @Override // defpackage.ac1
    public void f(View view) {
        view.getClass();
        j80 j80Var = ((RecentRequestsActivity) this.z).S0;
        if (j80Var == null) {
            n12.T("binding");
            throw null;
        }
        ((RecyclerView) j80Var.c).setItemAnimator(new yl0());
        ((uk0) this.f).f(view);
    }

    @Override // defpackage.x44
    public uj2 h(tj2 tj2Var) {
        af3 af3Var = (af3) ((bf3) this.z).h(tj2Var);
        if (af3Var != null) {
            return new uj2(af3Var.a, af3Var.b);
        }
        return null;
    }

    @Override // defpackage.cr3
    public boolean i(String str) {
        ContextUtilsKt.m().hideSoftInputFromWindow(((SearchView) this.f).getWindowToken(), 0);
        return true;
    }

    @Override // defpackage.x44
    public void j(int i) {
        int i2;
        if (i >= 40) {
            ((bf3) this.z).p(-1);
            return;
        }
        if (10 > i || i >= 20) {
            return;
        }
        bf3 bf3Var = (bf3) this.z;
        synchronized (((d7) bf3Var.g)) {
            i2 = bf3Var.c;
        }
        bf3Var.p(i2 / 2);
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        ((PreferenceGroup) this.f).j1 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        m33 m33Var = (m33) this.z;
        Handler handler = m33Var.h;
        f33 f33Var = m33Var.i;
        handler.removeCallbacks(f33Var);
        handler.post(f33Var);
        return true;
    }

    @Override // defpackage.ac1
    public void l(View view, View view2) {
        view.getClass();
        view2.getClass();
        ((uk0) this.f).l(view, view2);
    }

    @Override // defpackage.om1
    public void m(Object obj) {
        ((Surface) this.f).release();
        ((SurfaceTexture) this.z).release();
    }

    public v62 n(v62 v62Var) {
        om2 om2Var = (om2) this.f;
        if (!om2Var.equals((om2) v62Var.f)) {
            xe.k("ModulusPolys do not have same ModulusGF field");
            return null;
        }
        if (F()) {
            return v62Var;
        }
        if (v62Var.F()) {
            return this;
        }
        int[] iArr = (int[]) this.z;
        int[] iArr2 = (int[]) v62Var.z;
        if (iArr.length <= iArr2.length) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = om2Var.a(iArr2[i - length], iArr[i]);
        }
        return new v62(om2Var, iArr3);
    }

    public void o(Object obj, String str) {
        int length = str.length();
        String strValueOf = String.valueOf(obj);
        ((ArrayList) this.f).add(fw.z(new StringBuilder(length + 1 + strValueOf.length()), str, "=", strValueOf));
    }

    public void p(Class cls, b72 b72Var) {
        synchronized (this) {
            try {
                o82 o82Var = (o82) this.f;
                if (((i53) o82Var.b).f(new uj4(cls, true), b72Var, false) == null) {
                    ((AtomicReference) this.z).set(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.om1
    public void q(Throwable th) {
        throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
    }

    public void s() {
        int[] iArr = (int[]) this.f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.z = null;
    }

    public void t() {
        View rootView = ((ViewGroup) ((MainActivity) this.f).findViewById(android.R.id.content)).getRootView();
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null) {
            viewGroup.addView((ViewGroup) ((n84) this.z).getValue());
        }
    }

    public String toString() {
        int i = 0;
        switch (this.b) {
            case 4:
                StringBuilder sb = new StringBuilder(A() * 8);
                for (int iA = A(); iA >= 0; iA--) {
                    int iY = y(iA);
                    if (iY != 0) {
                        if (iY < 0) {
                            sb.append(" - ");
                            iY = -iY;
                        } else if (sb.length() > 0) {
                            sb.append(" + ");
                        }
                        if (iA == 0 || iY != 1) {
                            sb.append(iY);
                        }
                        if (iA != 0) {
                            if (iA == 1) {
                                sb.append('x');
                            } else {
                                sb.append("x^");
                                sb.append(iA);
                            }
                        }
                    }
                }
                return sb.toString();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                StringBuilder sb2 = new StringBuilder(100);
                sb2.append(this.z.getClass().getSimpleName());
                sb2.append('{');
                ArrayList arrayList = (ArrayList) this.f;
                int size = arrayList.size();
                while (i < size) {
                    sb2.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb2.append(", ");
                    }
                    i++;
                }
                sb2.append('}');
                return sb2.toString();
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                String str = "[ ";
                if (((jz3) this.f) != null) {
                    while (i < 9) {
                        str = str + ((jz3) this.f).y0[i] + " ";
                        i++;
                    }
                }
                StringBuilder sbQ = ha0.q(str, "] ");
                sbQ.append((jz3) this.f);
                return sbQ.toString();
            case 23:
                ArrayList arrayListB = B();
                StringBuilder sb3 = new StringBuilder();
                Iterator it = arrayListB.iterator();
                if (it.hasNext()) {
                    while (true) {
                        sb3.append((CharSequence) it.next());
                        if (it.hasNext()) {
                            sb3.append((CharSequence) " ");
                        }
                    }
                }
                return sb3.toString();
            default:
                return super.toString();
        }
    }

    public void u(int i) {
        int[] iArr = (int[]) this.f;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.f = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public int v(int i) {
        om2 om2Var = (om2) this.f;
        int[] iArr = (int[]) this.z;
        if (i == 0) {
            return y(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : iArr) {
                iA = om2Var.a(iA, i2);
            }
            return iA;
        }
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iA2 = om2Var.a(om2Var.c(i, iA2), iArr[i3]);
        }
        return iA2;
    }

    public w41 x(aj3 aj3Var, Map map) {
        map.getClass();
        int i = aj3Var.A0.a;
        ku2 ku2VarA = ((lu2) this.f).a();
        long j = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        ku2VarA.y = jz4.b(j, timeUnit);
        ku2VarA.z = jz4.b(j, timeUnit);
        ku2VarA.A = jz4.b(j, timeUnit);
        if ((aj3Var instanceof sw0) && !tj4.G()) {
            String str = aj3Var + " will use DoH to resolve domain";
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "OKHttpStack", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("OKHttpStack", str, null);
            }
            ku2VarA.a(new jd(25, this));
        }
        lu2 lu2Var = new lu2(ku2VarA);
        v92 v92Var = new v92(15);
        String str2 = aj3Var.f;
        str2.getClass();
        v92Var.w(str2);
        Map mapE = aj3Var.e();
        mapE.getClass();
        for (Map.Entry entry : mapE.entrySet()) {
            Object key = entry.getKey();
            key.getClass();
            String str3 = (String) key;
            Object value = entry.getValue();
            value.getClass();
            String str4 = (String) value;
            m20 m20Var = (m20) v92Var.z;
            m20Var.getClass();
            gb4.O(str3);
            gb4.P(str4, str3);
            gb4.x(m20Var, str3, str4);
        }
        for (Map.Entry entry2 : map.entrySet()) {
            String str5 = (String) entry2.getKey();
            String str6 = (String) entry2.getValue();
            str5.getClass();
            str6.getClass();
            m20 m20Var2 = (m20) v92Var.z;
            m20Var2.getClass();
            gb4.O(str5);
            gb4.P(str6, str5);
            gb4.x(m20Var2, str5, str6);
        }
        v92Var.m("GET", null);
        kk3 kk3VarE = new le3(lu2Var, new cm2(v92Var)).e();
        int i2 = kk3VarE.A;
        lr1 lr1Var = kk3VarE.Y;
        ArrayList arrayList = new ArrayList(f70.Q(10, lr1Var));
        Iterator it = lr1Var.iterator();
        while (true) {
            w0 w0Var = (w0) it;
            if (!w0Var.hasNext()) {
                return new w41(i2, (int) kk3VarE.Z.n(), arrayList, kk3VarE.Z.x().E0());
            }
            e03 e03Var = (e03) w0Var.next();
            arrayList.add(new ir1((String) e03Var.b, (String) e03Var.f));
        }
    }

    public int y(int i) {
        return ((int[]) this.z)[(r1.length - 1) - i];
    }

    public File z() {
        if (((File) this.f) == null) {
            synchronized (this) {
                try {
                    if (((File) this.f) == null) {
                        String str = "PersistedInstallation." + ((ze1) this.z).c() + ".json";
                        ze1 ze1Var = (ze1) this.z;
                        ze1Var.a();
                        File file = new File(ze1Var.a.getNoBackupFilesDir(), str);
                        this.f = file;
                        if (file.exists()) {
                            return (File) this.f;
                        }
                        ze1 ze1Var2 = (ze1) this.z;
                        ze1Var2.a();
                        File file2 = new File(ze1Var2.a.getFilesDir(), str);
                        if (file2.exists() && !file2.renameTo((File) this.f)) {
                            a1.e("PersistedInstallation", "Unable to move the file from back up to non back up directory", new IOException("Unable to move the file from back up to non back up directory"));
                            return file2;
                        }
                    }
                } finally {
                }
            }
        }
        return (File) this.f;
    }

    @Override // defpackage.ac1
    public void g() {
    }

    public /* synthetic */ v62(int i, Object obj, Object obj2) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public /* synthetic */ v62(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public /* synthetic */ v62(int i, boolean z) {
        this.b = i;
    }

    public /* synthetic */ v62(Object obj) {
        this.b = 9;
        this.z = obj;
        this.f = new ArrayList();
    }

    public v62(Context context) {
        this.b = 17;
        this.f = context;
        this.z = null;
    }

    public v62(om2 om2Var, int[] iArr) {
        this.b = 4;
        if (iArr.length != 0) {
            this.f = om2Var;
            int length = iArr.length;
            int i = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i < length && iArr[i] == 0) {
                    i++;
                }
                if (i == length) {
                    this.z = new int[]{0};
                    return;
                }
                int i2 = length - i;
                int[] iArr2 = new int[i2];
                this.z = iArr2;
                System.arraycopy(iArr, i, iArr2, 0, i2);
                return;
            }
            this.z = iArr;
            return;
        }
        s53.d();
        throw null;
    }

    public v62(lu2 lu2Var) throws UnknownHostException {
        this.b = 8;
        this.f = lu2Var;
        lu2 lu2Var2 = new lu2(new ku2());
        dv1 dv1Var = new dv1();
        dv1Var.c(null, "https://doh.pub/dns-query");
        ev1 ev1VarA = dv1Var.a();
        InetAddress byName = InetAddress.getByName("1.12.12.12");
        byName.getClass();
        InetAddress byName2 = InetAddress.getByName("120.53.53.53");
        byName2.getClass();
        List listS0 = qe.s0(new InetAddress[]{byName, byName2});
        ku2 ku2VarA = lu2Var2.a();
        pj2 pj2Var = pw0.z;
        ku2VarA.a(new lb(ev1VarA.d, listS0));
        this.z = new pw0(new lu2(ku2VarA), ev1VarA);
    }

    public v62(dt dtVar) {
        this.b = 27;
        this.f = dtVar;
        this.z = new ArrayBlockingQueue(16384);
    }

    public /* synthetic */ v62(int i, Object obj) {
        this.b = i;
        this.z = obj;
    }

    public v62(String str) {
        this.b = 10;
        this.f = (ExtraSupportedOutputSizeQuirk) xt0.a.z(ExtraSupportedOutputSizeQuirk.class);
        this.z = new br1(str, 1);
    }

    public v62(int i, t6 t6Var) {
        this.b = 19;
        this.f = t6Var;
        this.z = new bf3(i, this);
    }

    public v62(MainActivity mainActivity) {
        this.b = 28;
        this.f = mainActivity;
        this.z = new n84(new v10(6, this));
    }

    public v62(xp xpVar, op opVar) {
        this.b = 24;
        tp tpVar = tp.y0;
        up upVar = up.y0;
        this.f = xpVar;
        this.z = opVar;
    }

    public v62(oy2 oy2Var, lb lbVar) {
        this.b = 11;
        lbVar.getClass();
        this.z = oy2Var;
        this.f = lbVar;
    }
}
