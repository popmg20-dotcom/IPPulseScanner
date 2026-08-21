package defpackage;

import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.preference.SeekBarPreference;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pr3 implements View.OnKeyListener {
    public final /* synthetic */ SeekBarPreference b;

    public pr3(SeekBarPreference seekBarPreference) {
        this.b = seekBarPreference;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            SeekBarPreference seekBarPreference = this.b;
            if ((seekBarPreference.l1 || (i != 21 && i != 22)) && i != 23 && i != 66) {
                SeekBar seekBar = seekBarPreference.j1;
                if (seekBar != null) {
                    return seekBar.onKeyDown(i, keyEvent);
                }
                a1.d("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        }
        return false;
    }
}
