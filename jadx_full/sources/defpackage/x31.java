package defpackage;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x31 extends i31 {
    public final /* synthetic */ int a = 0;
    public final WeakReference b;

    public x31(EditText editText) {
        this.b = new WeakReference(editText);
    }

    @Override // defpackage.i31
    public void a() {
        switch (this.a) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    @Override // defpackage.i31
    public final void b() {
        int i = this.a;
        WeakReference weakReference = this.b;
        switch (i) {
            case 0:
                y31.a((EditText) weakReference.get(), 1);
                break;
            default:
                SwitchCompat switchCompat = (SwitchCompat) weakReference.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    public x31(SwitchCompat switchCompat) {
        this.b = new WeakReference(switchCompat);
    }
}
