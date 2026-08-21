package defpackage;

import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.SeekBarPreference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class or3 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ SeekBarPreference a;

    public or3(SeekBarPreference seekBarPreference) {
        this.a = seekBarPreference;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        SeekBarPreference seekBarPreference = this.a;
        if (z && (seekBarPreference.n1 || !seekBarPreference.i1)) {
            seekBarPreference.B(seekBar);
            return;
        }
        int i2 = i + seekBarPreference.f1;
        TextView textView = seekBarPreference.k1;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.a.i1 = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        SeekBarPreference seekBarPreference = this.a;
        seekBarPreference.i1 = false;
        if (seekBar.getProgress() + seekBarPreference.f1 != seekBarPreference.e1) {
            seekBarPreference.B(seekBar);
        }
    }
}
