package io.sentry.android.replay.util;

import androidx.compose.ui.text.TextLayoutResult;
import defpackage.vf2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements n {
    public final TextLayoutResult b;

    static {
        int i = TextLayoutResult.$stable;
    }

    public b(TextLayoutResult textLayoutResult) {
        this.b = textLayoutResult;
    }

    public final boolean a() {
        return this.b.getMultiParagraph().getWidth() > ((float) ((int) (this.b.getSize-YbymL2g() >> 32)));
    }

    @Override // io.sentry.android.replay.util.n
    public final int b(int i) {
        return vf2.B(this.b.getLineTop(i));
    }

    @Override // io.sentry.android.replay.util.n
    public final int e(int i) {
        return vf2.B(this.b.getLineBottom(i));
    }

    @Override // io.sentry.android.replay.util.n
    public final int g() {
        return this.b.getLineCount();
    }

    @Override // io.sentry.android.replay.util.n
    public final float h(int i) {
        boolean zA = a();
        TextLayoutResult textLayoutResult = this.b;
        return zA ? textLayoutResult.getMultiParagraph().getLineWidth(i) : textLayoutResult.getLineRight(i);
    }

    @Override // io.sentry.android.replay.util.n
    public final Integer i() {
        return null;
    }

    @Override // io.sentry.android.replay.util.n
    public final float j(int i) {
        if (a()) {
            return 0.0f;
        }
        return this.b.getLineLeft(i);
    }
}
