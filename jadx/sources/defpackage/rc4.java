package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rc4 {
    public boolean a;
    public float b;
    public float c;
    public boolean d;
    public pc4 e;
    public nc4 f;

    public final void a() {
        if (this.a) {
            return;
        }
        if (!this.f.a(this.b, this.c)) {
            this.e.c = 0.0f;
        }
        this.a = true;
        this.d = false;
    }

    public final void b(float f, float f2) {
        boolean z = this.a;
        boolean z2 = this.d;
        if (z) {
            if (!z2 || Math.abs(f - 0.0f) > 1.0E-6f) {
                this.b = f;
            } else {
                this.b = 0.0f;
            }
            this.c = f2;
            this.a = false;
            this.d = false;
            return;
        }
        if (!z2 && Math.abs(f - this.c) <= 1.0E-6f) {
            this.c = f2;
            return;
        }
        if (this.d && Math.abs(f - 0.0f) <= 1.0E-6f) {
            this.c = f2;
            this.d = false;
        } else {
            a();
            this.a = false;
            this.b = f;
            this.c = f2;
        }
    }
}
