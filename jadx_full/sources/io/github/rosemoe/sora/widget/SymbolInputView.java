package io.github.rosemoe.sora.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SymbolInputView extends LinearLayout {
    public static final /* synthetic */ int z = 0;
    public int b;
    public CodeEditor f;

    public SymbolInputView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setBackgroundColor(getContext().getResources().getColor(R.color.defaultSymbolInputBackgroundColor));
        setOrientation(0);
        setTextColor(getContext().getResources().getColor(R.color.defaultSymbolInputTextColor));
    }

    public int getTextColor() {
        return this.b;
    }

    public void setTextColor(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((Button) getChildAt(i2)).setTextColor(i);
        }
        this.b = i;
    }

    public SymbolInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
