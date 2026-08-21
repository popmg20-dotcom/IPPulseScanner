package defpackage;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m31 implements j31 {
    public final Context a;

    public m31(Context context, int i) {
        switch (i) {
            case 1:
                this.a = context;
                break;
            default:
                this.a = context.getApplicationContext();
                break;
        }
    }

    public static void c(u6 u6Var, Set set) {
        Button button = u6Var.Z.j;
        boolean z = false;
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Editable text = ((EditText) it.next()).getText();
                if (text == null || p44.x0(text)) {
                    z = true;
                    break;
                }
            }
        }
        button.setEnabled(!z);
    }

    @Override // defpackage.j31
    public void a(fx3 fx3Var) {
        ca0 ca0Var = new ca0("EmojiCompatInitializer");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), ca0Var);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new b0(10, this, fx3Var, threadPoolExecutor));
    }

    public void b(String str) {
        vo.F(this.a, str);
        if (str.equals("https://support.box.com/hc/en-us/articles/360043696414-WebDAV-with-Box")) {
            SharedPreferences.Editor editorEdit = t23.l().edit();
            editorEdit.putBoolean("webdav_box_help_showed", true);
            editorEdit.apply();
        } else {
            SharedPreferences.Editor editorEdit2 = t23.l().edit();
            editorEdit2.putBoolean("webdav_jianguoyun_help_showed", true);
            editorEdit2.apply();
        }
    }

    public m31(Service service) {
        Context applicationContext = service.getApplicationContext();
        tj4.i(applicationContext);
        this.a = applicationContext;
    }
}
