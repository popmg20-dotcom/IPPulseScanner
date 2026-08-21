package defpackage;

import android.system.OsConstants;
import android.text.Editable;
import android.text.Selection;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.vpn.Jni;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.net.InetSocketAddress;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dt implements Function2 {
    public final /* synthetic */ int b;

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        a80 a80Var;
        long jM;
        long jM2;
        int i = 0;
        switch (this.b) {
            case 0:
                xs xsVar = (xs) obj2;
                int i2 = BypassConfigActivity.Y0;
                boolean z = ((xs) obj).c;
                if ((!z || !xsVar.c) && (z || xsVar.c)) {
                    i = (z || !xsVar.c) ? -1 : 1;
                }
                return Integer.valueOf(i);
            case 1:
                String str = (String) obj;
                af0 af0Var = (af0) obj2;
                str.getClass();
                af0Var.getClass();
                if (str.length() == 0) {
                    return af0Var.toString();
                }
                return str + ", " + af0Var;
            case 2:
                cf0 cf0Var = (cf0) obj;
                af0 af0Var2 = (af0) obj2;
                cf0Var.getClass();
                af0Var2.getClass();
                cf0 cf0VarN = cf0Var.N(af0Var2.getKey());
                c41 c41Var = c41.b;
                if (cf0VarN == c41Var) {
                    return af0Var2;
                }
                pr1 pr1Var = pr1.f;
                ef0 ef0Var = (ef0) cf0VarN.Z(pr1Var);
                if (ef0Var == null) {
                    a80Var = new a80(af0Var2, cf0VarN);
                } else {
                    cf0 cf0VarN2 = cf0VarN.N(pr1Var);
                    if (cf0VarN2 == c41Var) {
                        return new a80(ef0Var, af0Var2);
                    }
                    a80Var = new a80(ef0Var, new a80(af0Var2, cf0VarN2));
                }
                return a80Var;
            case 3:
                return Boolean.valueOf(((Boolean) obj).booleanValue());
            case 4:
                return ((cf0) obj).X((af0) obj2);
            case 5:
                return ((cf0) obj).X((af0) obj2);
            case 6:
                return Boolean.valueOf(n12.c(obj, obj2));
            case 7:
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) obj2;
                inetSocketAddress.getClass();
                inetSocketAddress2.getClass();
                return Integer.valueOf(Jni.g(inetSocketAddress, inetSocketAddress2, OsConstants.IPPROTO_TCP));
            case 8:
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                as2 as2Var = new as2();
                as2Var.a = iIntValue;
                as2Var.b = jLongValue;
                return as2Var;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 10:
                CodeEditor codeEditor = (CodeEditor) obj;
                q30 q30Var = (q30) obj2;
                codeEditor.getClass();
                q30Var.getClass();
                long jL = codeEditor.D0.L(q30Var.b, q30Var.c);
                return codeEditor.getText().n().m((int) (jL >> 32), (int) (jL & 4294967295L));
            case 11:
                CodeEditor codeEditor2 = (CodeEditor) obj;
                q30 q30Var2 = (q30) obj2;
                codeEditor2.getClass();
                q30Var2.getClass();
                ld0 text = codeEditor2.getText();
                text.getClass();
                q30 q30Var3 = vf2.n(q30Var2, text, true).a;
                return codeEditor2.getText().n().m(q30Var3.b, q30Var3.c);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                CodeEditor codeEditor3 = (CodeEditor) obj;
                q30 q30Var4 = (q30) obj2;
                codeEditor3.getClass();
                q30Var4.getClass();
                ld0 text2 = codeEditor3.getText();
                text2.getClass();
                q30 q30Var5 = vf2.n(q30Var4, text2, false).b;
                return codeEditor3.getText().n().m(q30Var5.b, q30Var5.c);
            case 13:
                CodeEditor codeEditor4 = (CodeEditor) obj;
                q30 q30Var6 = (q30) obj2;
                codeEditor4.getClass();
                q30Var6.getClass();
                v0 v0Var = codeEditor4.D0;
                int iD = v0Var.D(q30Var6.a);
                int iQ = je.q(iD - ((int) Math.ceil(codeEditor4.getHeight() / codeEditor4.getRowHeight())), v0Var.d() - 1);
                int i3 = q30Var6.c - v0Var.N(iD).d;
                im3 im3VarN = v0Var.N(iQ);
                int i4 = im3VarN.a;
                int i5 = im3VarN.d;
                return codeEditor4.getText().n().m(i4, je.q(i3, im3VarN.e - i5) + i5);
            case 14:
                CodeEditor codeEditor5 = (CodeEditor) obj;
                q30 q30Var7 = (q30) obj2;
                codeEditor5.getClass();
                q30Var7.getClass();
                v0 v0Var2 = codeEditor5.D0;
                int iD2 = v0Var2.D(q30Var7.a);
                int iQ2 = je.q(((int) Math.ceil(codeEditor5.getHeight() / codeEditor5.getRowHeight())) + iD2, v0Var2.d() - 1);
                int i6 = q30Var7.c - v0Var2.N(iD2).d;
                im3 im3VarN2 = v0Var2.N(iQ2);
                int i7 = im3VarN2.a;
                int i8 = im3VarN2.d;
                return codeEditor5.getText().n().m(i7, je.q(i6, im3VarN2.e - i8) + i8);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                CodeEditor codeEditor6 = (CodeEditor) obj;
                q30 q30Var8 = (q30) obj2;
                codeEditor6.getClass();
                q30Var8.getClass();
                v0 v0Var3 = codeEditor6.D0;
                int i9 = q30Var8.c - v0Var3.N(v0Var3.D(q30Var8.a)).d;
                im3 im3VarN3 = v0Var3.N(codeEditor6.getFirstVisibleRow());
                int i10 = im3VarN3.a;
                int i11 = im3VarN3.d;
                return codeEditor6.getText().n().m(i10, je.q(i9, im3VarN3.e - i11) + i11);
            case 16:
                CodeEditor codeEditor7 = (CodeEditor) obj;
                q30 q30Var9 = (q30) obj2;
                codeEditor7.getClass();
                q30Var9.getClass();
                v0 v0Var4 = codeEditor7.D0;
                int i12 = q30Var9.c - v0Var4.N(v0Var4.D(q30Var9.a)).d;
                im3 im3VarN4 = v0Var4.N(codeEditor7.getLastVisibleRow());
                int i13 = im3VarN4.a;
                int i14 = im3VarN4.d;
                return codeEditor7.getText().n().m(i13, je.q(i12, im3VarN4.e - i14) + i14);
            case 17:
                CodeEditor codeEditor8 = (CodeEditor) obj;
                q30 q30Var10 = (q30) obj2;
                codeEditor8.getClass();
                q30Var10.getClass();
                codeEditor8.getProps().getClass();
                ud0 ud0VarO = codeEditor8.getText().o(q30Var10.b);
                int iB = (int) (yr2.B(ud0VarO, 0, ud0VarO.f) >> 32);
                return (q30Var10.c == iB || iB == codeEditor8.getText().o(q30Var10.b).f) ? codeEditor8.getText().n().m(q30Var10.b, 0) : codeEditor8.getText().n().m(q30Var10.b, iB);
            case 18:
                CodeEditor codeEditor9 = (CodeEditor) obj;
                q30 q30Var11 = (q30) obj2;
                codeEditor9.getClass();
                q30Var11.getClass();
                int i15 = codeEditor9.getText().o(q30Var11.b).f;
                codeEditor9.getProps().getClass();
                ud0 ud0VarO2 = codeEditor9.getText().o(q30Var11.b);
                int iB2 = (int) (yr2.B(ud0VarO2, 0, ud0VarO2.f) & 4294967295L);
                return q30Var11.c != iB2 ? codeEditor9.getText().n().m(q30Var11.b, iB2) : codeEditor9.getText().n().m(q30Var11.b, i15);
            case 19:
                ((CodeEditor) obj).getClass();
                ((q30) obj2).getClass();
                q30 q30Var12 = new q30();
                q30Var12.c = 0;
                q30Var12.b = 0;
                q30Var12.a = 0;
                return q30Var12;
            case 20:
                CodeEditor codeEditor10 = (CodeEditor) obj;
                codeEditor10.getClass();
                ((q30) obj2).getClass();
                return codeEditor10.getText().n().j(codeEditor10.getText().A);
            case 21:
                CodeEditor codeEditor11 = (CodeEditor) obj;
                q30 q30Var13 = (q30) obj2;
                codeEditor11.getClass();
                q30Var13.getClass();
                v0 v0Var5 = codeEditor11.D0;
                int iD3 = v0Var5.D(q30Var13.a);
                im3 im3VarN5 = v0Var5.N(iD3);
                int i16 = iD3 + 1;
                int i17 = (i16 == v0Var5.d() || v0Var5.N(i16).a != im3VarN5.a) ? im3VarN5.e : im3VarN5.e - 1;
                codeEditor11.getProps().getClass();
                int iB3 = (int) (yr2.B(codeEditor11.getText().o(q30Var13.b), im3VarN5.d, i17) >> 32);
                return (q30Var13.c == iB3 || iB3 == i17) ? codeEditor11.getText().n().m(q30Var13.b, im3VarN5.d) : codeEditor11.getText().n().m(q30Var13.b, iB3);
            case 22:
                CodeEditor codeEditor12 = (CodeEditor) obj;
                q30 q30Var14 = (q30) obj2;
                codeEditor12.getClass();
                q30Var14.getClass();
                v0 v0Var6 = codeEditor12.D0;
                int iD4 = v0Var6.D(q30Var14.a);
                im3 im3VarN6 = v0Var6.N(iD4);
                int i18 = iD4 + 1;
                int i19 = (i18 == v0Var6.d() || v0Var6.N(i18).a != im3VarN6.a) ? im3VarN6.e : im3VarN6.e - 1;
                codeEditor12.getProps().getClass();
                int iB4 = (int) (yr2.B(codeEditor12.getText().o(q30Var14.b), im3VarN6.d, i19) & 4294967295L);
                return q30Var14.c != iB4 ? codeEditor12.getText().n().m(q30Var14.b, iB4) : codeEditor12.getText().n().m(q30Var14.b, i19);
            case 23:
                CodeEditor codeEditor13 = (CodeEditor) obj;
                q30 q30Var15 = (q30) obj2;
                codeEditor13.getClass();
                q30Var15.getClass();
                long jT = codeEditor13.D0.t(q30Var15.b, q30Var15.c);
                return codeEditor13.getText().n().m((int) (jT >> 32), (int) (jT & 4294967295L));
            case 24:
                CodeEditor codeEditor14 = (CodeEditor) obj;
                q30 q30Var16 = (q30) obj2;
                codeEditor14.getClass();
                q30Var16.getClass();
                lg0 cursor = codeEditor14.getCursor();
                long jM3 = ez4.M(q30Var16.b, q30Var16.c);
                cursor.getClass();
                int i20 = (int) (jM3 >> 32);
                int i21 = (int) (jM3 & 4294967295L);
                ac4 ac4VarA = ac4.a();
                ld0 ld0Var = cursor.a;
                int iB5 = ac4VarA.b(i21, ld0Var.o(i20));
                if (iB5 != i21 || i21 != 0) {
                    jM = ez4.M(i20, iB5);
                } else if (i20 == 0) {
                    jM = 0;
                } else {
                    int i22 = i20 - 1;
                    jM = ez4.M(i22, ld0Var.o(i22).f);
                }
                return codeEditor14.getText().n().m((int) (jM >> 32), (int) (jM & 4294967295L));
            case 25:
                CodeEditor codeEditor15 = (CodeEditor) obj;
                q30 q30Var17 = (q30) obj2;
                codeEditor15.getClass();
                q30Var17.getClass();
                lg0 cursor2 = codeEditor15.getCursor();
                long jM4 = ez4.M(q30Var17.b, q30Var17.c);
                int i23 = (int) (jM4 >> 32);
                int i24 = (int) (jM4 & 4294967295L);
                ld0 ld0Var2 = cursor2.a;
                int i25 = ld0Var2.o(i23).f;
                ac4 ac4VarA2 = ac4.a();
                ud0 ud0VarO3 = ld0Var2.o(i23);
                int iMax = Math.max(0, i24 - 64);
                Editable editable = ac4VarA2.a;
                editable.append((CharSequence) ud0VarO3, iMax, Math.min(ud0VarO3.f, i24 + 65));
                Selection.setSelection(editable, Math.min(i24 - iMax, editable.length()));
                Selection.moveRight(editable, ac4VarA2.b);
                int selectionStart = Selection.getSelectionStart(editable);
                editable.clear();
                Selection.removeSelection(editable);
                int i26 = selectionStart + iMax;
                if (i26 == i25 && i24 == i26) {
                    int i27 = i23 + 1;
                    jM2 = i27 == ld0Var2.b.size() ? ez4.M(i23, i25) : ez4.M(i27, 0);
                } else {
                    jM2 = ez4.M(i23, i26);
                }
                return codeEditor15.getText().n().m((int) (jM2 >> 32), (int) (jM2 & 4294967295L));
            case 26:
                af0 af0Var3 = (af0) obj2;
                if (!(af0Var3 instanceof pd4)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue2 = num != null ? num.intValue() : 1;
                return iIntValue2 == 0 ? af0Var3 : Integer.valueOf(iIntValue2 + 1);
            case 27:
                pd4 pd4Var = (pd4) obj;
                af0 af0Var4 = (af0) obj2;
                if (pd4Var != null) {
                    return pd4Var;
                }
                if (af0Var4 instanceof pd4) {
                    return (pd4) af0Var4;
                }
                return null;
            default:
                ud4 ud4Var = (ud4) obj;
                af0 af0Var5 = (af0) obj2;
                if (af0Var5 instanceof pd4) {
                    pd4 pd4Var2 = (pd4) af0Var5;
                    cf0 cf0Var2 = ud4Var.a;
                    ThreadLocal threadLocal = pd4Var2.f;
                    Object obj3 = threadLocal.get();
                    threadLocal.set(pd4Var2.b);
                    Object[] objArr = ud4Var.b;
                    int i28 = ud4Var.d;
                    objArr[i28] = obj3;
                    pd4[] pd4VarArr = ud4Var.c;
                    ud4Var.d = i28 + 1;
                    pd4VarArr[i28] = pd4Var2;
                }
                return ud4Var;
        }
    }

    public /* synthetic */ dt(int i) {
        this.b = i;
    }
}
