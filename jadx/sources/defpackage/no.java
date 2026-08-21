package defpackage;

import android.view.KeyEvent;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class no extends ko {
    public final /* synthetic */ int a;
    public final /* synthetic */ KeyEvent.Callback b;

    public /* synthetic */ no(KeyEvent.Callback callback, int i) {
        this.a = i;
        this.b = callback;
    }

    @Override // defpackage.ko
    public final void b(View view) {
        int i = this.a;
    }

    @Override // defpackage.ko
    public final void c(View view, int i) {
        int i2 = this.a;
        KeyEvent.Callback callback = this.b;
        switch (i2) {
            case 0:
                if (i == 5) {
                    ((po) callback).cancel();
                }
                break;
            default:
                int i3 = BottomSheetDragHandleView.H0;
                ((BottomSheetDragHandleView) callback).d(i);
                break;
        }
    }

    private final void d(View view) {
    }

    private final void e(View view) {
    }
}
