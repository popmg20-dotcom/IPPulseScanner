package defpackage;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import com.getsurfboard.ui.activity.AppThemeConfigActivity;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ld implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ KeyEvent.Callback b;

    public /* synthetic */ ld(KeyEvent.Callback callback, int i) {
        this.a = i;
        this.b = callback;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int i = this.a;
        KeyEvent.Callback callback = this.b;
        switch (i) {
            case 0:
                AppThemeConfigActivity appThemeConfigActivity = (AppThemeConfigActivity) callback;
                int i2 = AppThemeConfigActivity.T0;
                compoundButton.getClass();
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putBoolean("pure_dark", z);
                editorEdit.commit();
                ji0.B(uf2.t(appThemeConfigActivity), null, null, new od(2, null, 1), 3);
                e4.A(appThemeConfigActivity);
                break;
            default:
                Chip chip = (Chip) callback;
                Rect rect = Chip.R0;
                ni2 ni2Var = chip.D0;
                if (ni2Var != null) {
                    a40 a40Var = (a40) ((zf2) ni2Var).f;
                    if (!z ? a40Var.k(chip, a40Var.f) : a40Var.a(chip)) {
                        a40Var.i();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.C0;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                }
                break;
        }
    }
}
