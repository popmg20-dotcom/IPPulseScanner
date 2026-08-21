package defpackage;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import io.sentry.android.replay.screenshot.b;
import io.sentry.p5;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m74 implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m74(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                Semaphore semaphore = (Semaphore) obj;
                if (i == 0) {
                    ez4.o("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
                } else {
                    ez4.q("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i);
                }
                semaphore.release();
                break;
            default:
                b bVar = (b) obj;
                if (!bVar.k.get()) {
                    if (i != 0) {
                        bVar.c.getLogger().h(p5.ERROR, dw2.A(i, "Canvas Strategy: PixelCopy failed with code "), new Object[0]);
                        bVar.i.set(false);
                        break;
                    } else {
                        bVar.i.set(true);
                        Bitmap bitmap = bVar.e;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bVar.b.j0(bitmap);
                            break;
                        }
                    }
                } else {
                    bVar.c.getLogger().h(p5.DEBUG, "CanvasStrategy is closed, ignoring capture result", new Object[0]);
                    break;
                }
                break;
        }
    }
}
