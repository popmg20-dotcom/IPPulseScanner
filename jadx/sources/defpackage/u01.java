package defpackage;

import android.util.SparseIntArray;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class u01 {
    public static final u01 c = new u01();
    public final SparseIntArray a = new SparseIntArray();
    public final ArrayList b = new ArrayList();

    public u01() {
        a();
    }

    public void a() {
        for (int i = 1; i <= 80; i++) {
            int i2 = this.a.get(i);
            switch (i) {
                case 1:
                case 3:
                    i2 = -286331154;
                    break;
                case 2:
                case 45:
                    i2 = -11513776;
                    break;
                case 4:
                case 19:
                case 20:
                case 63:
                    if (!f()) {
                        i2 = -1;
                    }
                    break;
                case 5:
                case 64:
                    i2 = -13421773;
                    break;
                case 6:
                case 52:
                    i2 = 759124405;
                    break;
                case 7:
                    i2 = -581734914;
                    break;
                case 8:
                    i2 = -11309570;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    i2 = 268435456;
                    break;
                case 10:
                    i2 = -16777216;
                    break;
                case 11:
                    i2 = -2565928;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    i2 = -14210774;
                    break;
                case 13:
                case 18:
                case 30:
                case 39:
                case 40:
                case 57:
                    i2 = 0;
                    break;
                case 14:
                    i2 = -2236963;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                case 38:
                case 70:
                case 71:
                    i2 = -6710887;
                    break;
                case 16:
                    i2 = -587202560;
                    break;
                case 17:
                    i2 = -1;
                    break;
                case 21:
                    i2 = -14575885;
                    break;
                case 22:
                    i2 = -5723992;
                    break;
                case 23:
                    i2 = -16750890;
                    break;
                case 24:
                    i2 = -16744320;
                    break;
                case 25:
                    i2 = -11243910;
                    break;
                case 26:
                case 28:
                case 59:
                case 72:
                    i2 = -16537100;
                    break;
                case 27:
                    i2 = -2080517;
                    break;
                case 29:
                    i2 = -256;
                    break;
                case 31:
                    i2 = -288568116;
                    break;
                case 35:
                    i2 = -1426128896;
                    break;
                case 36:
                    i2 = -1426067200;
                    break;
                case 37:
                    i2 = 1711341329;
                    break;
                case 41:
                    i2 = 486539264;
                    break;
                case 42:
                case 43:
                case 50:
                    if (f()) {
                        i2 = -1;
                    } else {
                        i2 = -16777216;
                    }
                    break;
                case 44:
                    i2 = -1118482;
                    break;
                case 46:
                    i2 = 1725816285;
                    break;
                case 47:
                    i2 = -1428300323;
                    break;
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    i2 = -3355444;
                    break;
                case 49:
                    if (f()) {
                        i2 = 502197998;
                    } else {
                        i2 = 486539264;
                    }
                    break;
                case 51:
                    if (f()) {
                        i2 = 486539264;
                    } else {
                        i2 = -1118482;
                    }
                    break;
                case 53:
                case 60:
                case 65:
                case 69:
                    i2 = f() ? -14606047 : -65794;
                    break;
                case 54:
                    i2 = f() ? -657931 : -12434878;
                    break;
                case 55:
                    if (f()) {
                        i2 = -1118482;
                    } else {
                        i2 = -10395295;
                    }
                    break;
                case 56:
                    i2 = -12409355;
                    break;
                case 58:
                case 68:
                    if (f()) {
                        i2 = -1118482;
                    } else {
                        i2 = -16777216;
                    }
                    break;
                case 62:
                    i2 = -1712394514;
                    break;
                case 66:
                    if (f()) {
                        i2 = -1118482;
                    } else {
                        i2 = -7829368;
                    }
                    break;
                case 67:
                    i2 = -11687172;
                    break;
                case 73:
                    i2 = f() ? -1207940750 : 1074684828;
                    break;
                case 74:
                    i2 = f() ? -1202235561 : 1079465815;
                    break;
                case 75:
                    i2 = -12627531;
                    break;
            }
            g(i, i2);
        }
    }

    public void c(CodeEditor codeEditor) {
        ArrayList arrayList = this.b;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == codeEditor) {
                return;
            }
        }
        arrayList.add(new WeakReference(codeEditor));
        codeEditor.C0.a(new s70(codeEditor));
        codeEditor.h2.a();
        codeEditor.invalidate();
    }

    public void d(CodeEditor codeEditor) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == codeEditor) {
                it.remove();
                return;
            }
        }
    }

    public int e(int i) {
        return this.a.get(i);
    }

    public boolean f() {
        return false;
    }

    public final void g(int i, int i2) {
        if (e(i) == i2) {
            return;
        }
        this.a.put(i, i2);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            CodeEditor codeEditor = (CodeEditor) ((WeakReference) it.next()).get();
            if (codeEditor == null) {
                it.remove();
            } else {
                codeEditor.C0.a(new s70(codeEditor));
                codeEditor.h2.a();
                codeEditor.invalidate();
            }
        }
    }
}
