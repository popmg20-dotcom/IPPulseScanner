package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kn implements gd1 {
    public final /* synthetic */ int a;
    public final rw2 b;
    public final Object c;

    public /* synthetic */ kn(Object obj, rw2 rw2Var, int i) {
        this.a = i;
        this.c = obj;
        this.b = rw2Var;
    }

    @Override // defpackage.gd1
    public final Object a(ge0 ge0Var) {
        int i = this.a;
        pi0 pi0Var = pi0.f;
        Object obj = this.c;
        rw2 rw2Var = this.b;
        switch (i) {
            case 0:
                return new ox0(new BitmapDrawable(rw2Var.a.getResources(), (Bitmap) obj), false, pi0Var);
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                try {
                    hp hpVar = new hp();
                    hpVar.write(byteBuffer);
                    byteBuffer.position(0);
                    Context context = rw2Var.a;
                    return new pz3(new nz3(hpVar, null), null, pi0Var);
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    throw th;
                }
            default:
                Drawable bitmapDrawable = (Drawable) obj;
                Bitmap.Config config = j.a;
                boolean z = (bitmapDrawable instanceof VectorDrawable) || (bitmapDrawable instanceof qo4);
                if (z) {
                    bitmapDrawable = new BitmapDrawable(rw2Var.a.getResources(), ji0.h(bitmapDrawable, rw2Var.b, rw2Var.d, rw2Var.e, rw2Var.f));
                }
                return new ox0(bitmapDrawable, z, pi0Var);
        }
    }
}
