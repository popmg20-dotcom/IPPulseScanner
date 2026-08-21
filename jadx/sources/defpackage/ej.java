package defpackage;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsOpCode;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.sentry.android.core.a1;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ej extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej(jj jjVar, Uri uri, char[] cArr, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 1;
        this.Y = jjVar;
        this.Z = uri;
        this.y0 = cArr;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Exception {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((ej) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                ((ej) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 5:
                ((ej) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 6:
                ((ej) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            default:
                ((ej) n(ge0Var, lf0Var)).p(xl4Var);
                break;
        }
        return xl4Var;
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.y0;
        Object obj3 = this.Y;
        Object obj4 = this.Z;
        switch (i) {
            case 0:
                return new ej((u6) obj4, (jj) obj3, (BackupSection) obj2, ge0Var, 0);
            case 1:
                return new ej((jj) obj3, (Uri) obj4, (char[]) obj2, ge0Var);
            case 2:
                return new ej((xw0) obj4, (String) obj3, (byte[]) obj2, ge0Var, 2);
            case 3:
                return new ej((String) obj4, (aa1) obj3, (String) obj2, ge0Var, 3);
            case 4:
                return new ej((iv1) obj4, (po1) obj3, (bh3) obj2, ge0Var, 4);
            case 5:
                return new ej((v62) obj4, (byte[]) obj3, (gj) obj2, ge0Var, 5);
            case 6:
                return new ej((NATDetectActivity) obj4, (String) obj3, (zg3) obj2, ge0Var, 6);
            default:
                return new ej((LinearProgressIndicator) obj4, (ah3) obj3, (Long) obj2, ge0Var, 7);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) throws Exception {
        String str;
        long jI;
        byte[] bArrD;
        int i = 0;
        ge0 ge0Var = null;
        int i2 = 1;
        switch (this.X) {
            case 0:
                n12.S(obj);
                TextView textView = (TextView) ((u6) this.Z).findViewById(R.id.stage);
                if (textView != null) {
                    textView.setText(jj.b((BackupSection) this.y0));
                }
                return xl4.a;
            case 1:
                n12.S(obj);
                Context contextRequireContext = ((jj) this.Y).a.requireContext();
                contextRequireContext.getClass();
                Uri uri = (Uri) this.Z;
                char[] cArr = (char[]) this.y0;
                uri.getClass();
                InputStream inputStreamOpenInputStream = contextRequireContext.getContentResolver().openInputStream(uri);
                inputStreamOpenInputStream.getClass();
                try {
                    k03 k03VarB = lj.b(inputStreamOpenInputStream, cArr);
                    inputStreamOpenInputStream.close();
                    return k03VarB;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ez4.l(inputStreamOpenInputStream, th);
                        throw th2;
                    }
                }
            case 2:
                n12.S(obj);
                try {
                    String str2 = "Verifying DoH server: " + ((String) this.Y);
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "DoHResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
                        str = str2;
                    } else {
                        str = str2;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("DoHResolver", str, null);
                    }
                    xw0 xw0Var = (xw0) this.Z;
                    String str3 = (String) this.Y;
                    byte[] bArr = (byte[]) this.y0;
                    pj2 pj2Var = xw0.e;
                    DefaultDnsResponse defaultDnsResponseS = je.S(xw0Var.b("getsurfboard.com", str3, bArr));
                    if (defaultDnsResponseS == null) {
                        return new e03((String) this.Y, new Exception("Parse DNS response failed"));
                    }
                    defaultDnsResponseS.release();
                    return null;
                } catch (Exception e) {
                    return new e03((String) this.Y, e);
                }
            case 3:
                String str4 = (String) this.y0;
                n12.S(obj);
                byte[] bArrM = gb4.M((String) this.Z);
                ea1 ea1Var = ((aa1) this.Y).e;
                if (ea1Var instanceof ix3) {
                    jI = tj4.X(str4, bArrM);
                } else if (ea1Var instanceof gx3) {
                    jI = fx3.E(str4, bArrM);
                } else {
                    if (!(ea1Var instanceof bx3)) {
                        g.d();
                        return null;
                    }
                    jI = vo.I(str4, bArrM);
                }
                return new Long(jI);
            case 4:
                n12.S(obj);
                iv1 iv1Var = (iv1) this.Z;
                ((LoadingIndicator) iv1Var.A).setVisibility(8);
                ((MaterialButton) iv1Var.X).setEnabled(true);
                ((MaterialButton) iv1Var.z).setEnabled(true);
                po1 po1Var = (po1) this.Y;
                bh3 bh3Var = (bh3) this.y0;
                po1Var.J0 = (String) bh3Var.b;
                EditText editText = ((TextInputLayout) iv1Var.f).getEditText();
                if (editText != null) {
                    editText.setText((CharSequence) bh3Var.b);
                }
                return xl4.a;
            case 5:
                n12.S(obj);
                try {
                    v62 v62Var = (v62) this.Z;
                    byte[] bArr2 = (byte[]) this.Y;
                    Network network = (Network) v62Var.z;
                    if (network == null) {
                        bArrD = null;
                    } else {
                        DatagramSocket datagramSocket = new DatagramSocket();
                        try {
                            network.bindSocket(datagramSocket);
                            InetAddress byName = InetAddress.getByName("224.0.0.251");
                            byName.getClass();
                            bArrD = v62.w(v62Var, bArr2, datagramSocket, byName);
                            datagramSocket.close();
                        } finally {
                        }
                    }
                    if (bArrD == null) {
                        v62 v62Var2 = (v62) this.Z;
                        byte[] bArr3 = (byte[]) this.Y;
                        v62Var2.getClass();
                        bArrD = v62.r(bArr3);
                    }
                } catch (Exception e2) {
                    String strN = ha0.n("mdns resolve failed: ", e2.getMessage());
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 4, "MdnsResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        a1.e("MdnsResolver", strN, null);
                    }
                    v62 v62Var3 = (v62) this.Z;
                    byte[] bArr4 = (byte[]) this.Y;
                    v62Var3.getClass();
                    if (bArr4.length < 2) {
                        bArrD = bArr4;
                    } else {
                        DefaultDnsResponse defaultDnsResponse = new DefaultDnsResponse(((bArr4[0] & 255) << 8) | (bArr4[1] & 255), DnsOpCode.QUERY, DnsResponseCode.SERVFAIL);
                        try {
                            bArrD = je.D(defaultDnsResponse);
                            defaultDnsResponse.release();
                        } finally {
                        }
                    }
                }
                ((gj) this.y0).g(bArrD);
                return xl4.a;
            case 6:
                n12.S(obj);
                NATDetectActivity nATDetectActivity = (NATDetectActivity) this.Z;
                int i3 = NATDetectActivity.V0;
                nATDetectActivity.U0 = true;
                ji0.B(uf2.t(nATDetectActivity), null, null, new eo2(nATDetectActivity, ge0Var, i2), 3);
                ji0.B(uf2.t(nATDetectActivity), null, null, new eo2(nATDetectActivity, ge0Var, i), 3);
                try {
                    vo2 vo2VarU = new qt((String) this.Y, ((zg3) this.y0).b, new cd(4, nATDetectActivity)).u();
                    nATDetectActivity.x("");
                    if (vo2VarU != null) {
                        nATDetectActivity.x(vo2VarU.toString());
                    }
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    String stackTraceString = Log.getStackTraceString(e3);
                    stackTraceString.getClass();
                    nATDetectActivity.x(stackTraceString);
                }
                nATDetectActivity.U0 = false;
                ji0.B(uf2.t(nATDetectActivity), null, null, new eo2(nATDetectActivity, ge0Var, i2), 3);
                ji0.B(uf2.t(nATDetectActivity), null, null, new eo2(nATDetectActivity, ge0Var, i), 3);
                return xl4.a;
            default:
                n12.S(obj);
                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) this.Z;
                long j = 100 * ((ah3) this.Y).b;
                Long l = (Long) this.y0;
                l.getClass();
                linearProgressIndicator.setProgress((int) (j / l.longValue()));
                return xl4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ej(Object obj, Object obj2, Object obj3, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.Y = obj2;
        this.y0 = obj3;
    }
}
