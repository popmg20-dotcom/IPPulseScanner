package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class me2 extends Writer {
    public final /* synthetic */ int b;
    public final Object f;

    public me2() {
        this.b = 0;
        this.f = new StringBuilder(128);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        switch (this.b) {
            case 1:
                String string = charSequence.subSequence(i, i2).toString();
                ((lb4) this.f).b(0, string.length(), string);
                return this;
            default:
                return super.append(charSequence, i, i2);
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.b) {
            case 0:
                s();
                break;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        switch (this.b) {
            case 0:
                s();
                break;
        }
    }

    public void s() {
        StringBuilder sb = (StringBuilder) this.f;
        if (sb.length() > 0) {
            Log.d("FragmentManager", sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        switch (this.b) {
            case 1:
                lb4 lb4Var = (lb4) this.f;
                char c = (char) i;
                if (lb4Var.b >= 0) {
                    lb4Var.i(16);
                }
                lb4Var.e = null;
                lb4Var.j = null;
                char[] cArr = (char[]) lb4Var.i;
                if (lb4Var.d >= cArr.length) {
                    lb4Var.f();
                    cArr = (char[]) lb4Var.i;
                }
                int i2 = lb4Var.d;
                lb4Var.d = i2 + 1;
                cArr[i2] = c;
                break;
            default:
                super.write(i);
                break;
        }
    }

    public String x() {
        char[] cArr;
        lb4 lb4Var = (lb4) this.f;
        String strE = lb4Var.e();
        lb4Var.b = -1;
        lb4Var.d = 0;
        lb4Var.j = null;
        if (lb4Var.f) {
            lb4Var.f = false;
            ((ArrayList) lb4Var.h).clear();
            lb4Var.c = 0;
            lb4Var.d = 0;
        }
        mp mpVar = (mp) lb4Var.g;
        if (mpVar != null && (cArr = (char[]) lb4Var.i) != null) {
            lb4Var.i = null;
            AtomicReferenceArray atomicReferenceArray = mpVar.b;
            char[] cArr2 = (char[]) atomicReferenceArray.get(2);
            if (cArr2 == null || cArr.length > cArr2.length) {
                atomicReferenceArray.set(2, cArr);
            }
        }
        return strE;
    }

    public me2(mp mpVar) {
        this.b = 1;
        this.f = new lb4(mpVar);
    }

    private final void g() {
    }

    private final void n() {
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) {
        switch (this.b) {
            case 1:
                append(charSequence, i, i2);
                return this;
            default:
                return super.append(charSequence, i, i2);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        switch (this.b) {
            case 1:
                write(c);
                return this;
            default:
                return super.append(c);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(char c) throws IOException {
        switch (this.b) {
            case 1:
                write(c);
                return this;
            default:
                return super.append(c);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        switch (this.b) {
            case 1:
                String string = charSequence.toString();
                ((lb4) this.f).b(0, string.length(), string);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        switch (this.b) {
            case 1:
                append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        int i3 = this.b;
        Object obj = this.f;
        switch (i3) {
            case 0:
                for (int i4 = 0; i4 < i2; i4++) {
                    char c = cArr[i + i4];
                    if (c == '\n') {
                        s();
                    } else {
                        ((StringBuilder) obj).append(c);
                    }
                }
                break;
            default:
                ((lb4) obj).c(cArr, i, i2);
                break;
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        switch (this.b) {
            case 1:
                ((lb4) this.f).c(cArr, 0, cArr.length);
                break;
            default:
                super.write(cArr);
                break;
        }
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        switch (this.b) {
            case 1:
                ((lb4) this.f).b(0, str.length(), str);
                break;
            default:
                super.write(str);
                break;
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        switch (this.b) {
            case 1:
                ((lb4) this.f).b(i, i2, str);
                break;
            default:
                super.write(str, i, i2);
                break;
        }
    }
}
