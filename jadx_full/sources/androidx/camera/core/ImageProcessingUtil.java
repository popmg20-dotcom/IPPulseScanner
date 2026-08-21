package androidx.camera.core;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Log;
import android.view.Surface;
import defpackage.ez4;
import defpackage.iy1;
import defpackage.ky1;
import defpackage.my1;
import defpackage.oy1;
import defpackage.rx1;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageProcessingUtil {
    public static int a;

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static void a(my1 my1Var) {
        if (!e(my1Var)) {
            ez4.q("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return;
        }
        int iF = my1Var.f();
        int iC = my1Var.c();
        int iA = my1Var.p()[0].a();
        int iA2 = my1Var.p()[1].a();
        int iA3 = my1Var.p()[2].a();
        int iC2 = my1Var.p()[0].c();
        int iC3 = my1Var.p()[1].c();
        if (nativeShiftPixel(my1Var.p()[0].h(), iA, my1Var.p()[1].h(), iA2, my1Var.p()[2].h(), iA3, iC2, iC3, iF, iC, iC2, iC3, iC3) != 0) {
            ez4.q("ImageProcessingUtil", "One pixel shift for YUV failure");
        }
    }

    public static rx1 b(my1 my1Var, oy1 oy1Var, ByteBuffer byteBuffer, int i, boolean z) {
        if (!e(my1Var)) {
            ez4.q("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!d(i)) {
            ez4.q("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        Surface surface = oy1Var.getSurface();
        int iF = my1Var.f();
        int iC = my1Var.c();
        int iA = my1Var.p()[0].a();
        int iA2 = my1Var.p()[1].a();
        int iA3 = my1Var.p()[2].a();
        int iC2 = my1Var.p()[0].c();
        int iC3 = my1Var.p()[1].c();
        if (nativeConvertAndroid420ToABGR(my1Var.p()[0].h(), iA, my1Var.p()[1].h(), iA2, my1Var.p()[2].h(), iA3, iC2, iC3, surface, byteBuffer, iF, iC, z ? iC2 : 0, z ? iC3 : 0, z ? iC3 : 0, i) != 0) {
            ez4.q("ImageProcessingUtil", "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            Locale locale = Locale.US;
            ez4.o("ImageProcessingUtil", "Image processing performance profiling, duration: [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "], image count: " + a);
            a = a + 1;
        }
        my1 my1VarI = oy1Var.i();
        if (my1VarI == null) {
            ez4.q("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
            return null;
        }
        rx1 rx1Var = new rx1(my1VarI);
        rx1Var.g(new iy1(my1VarI, my1Var, 0));
        return rx1Var;
    }

    public static void c(Bitmap bitmap, ByteBuffer byteBuffer, int i) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    public static boolean d(int i) {
        return i == 0 || i == 90 || i == 180 || i == 270;
    }

    public static boolean e(my1 my1Var) {
        return my1Var.getFormat() == 35 && my1Var.p().length == 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static rx1 f(my1 my1Var, oy1 oy1Var, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        rx1 rx1Var;
        if (!e(my1Var)) {
            ez4.q("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return null;
        }
        if (!d(i)) {
            ez4.q("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        if (i > 0) {
            int iF = my1Var.f();
            int iC = my1Var.c();
            int iA = my1Var.p()[0].a();
            int iA2 = my1Var.p()[1].a();
            int iA3 = my1Var.p()[2].a();
            int iC2 = my1Var.p()[1].c();
            Image imageDequeueInputImage = imageWriter.dequeueInputImage();
            if (imageDequeueInputImage == null) {
                rx1Var = null;
            } else {
                rx1Var = null;
                if (nativeRotateYUV(my1Var.p()[0].h(), iA, my1Var.p()[1].h(), iA2, my1Var.p()[2].h(), iA3, iC2, imageDequeueInputImage.getPlanes()[0].getBuffer(), imageDequeueInputImage.getPlanes()[0].getRowStride(), imageDequeueInputImage.getPlanes()[0].getPixelStride(), imageDequeueInputImage.getPlanes()[1].getBuffer(), imageDequeueInputImage.getPlanes()[1].getRowStride(), imageDequeueInputImage.getPlanes()[1].getPixelStride(), imageDequeueInputImage.getPlanes()[2].getBuffer(), imageDequeueInputImage.getPlanes()[2].getRowStride(), imageDequeueInputImage.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, iF, iC, i) == 0) {
                    imageWriter.queueInputImage(imageDequeueInputImage);
                    my1 my1VarI = oy1Var.i();
                    if (my1VarI == null) {
                        ez4.q("ImageProcessingUtil", "YUV rotation acquireLatestImage failure");
                        return null;
                    }
                    rx1 rx1Var2 = new rx1(my1VarI);
                    rx1Var2.g(new iy1(my1VarI, my1Var, 1));
                    return rx1Var2;
                }
            }
        }
        ez4.q("ImageProcessingUtil", "rotate YUV failure");
        return rx1Var;
    }

    public static rx1 g(my1 my1Var, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4, ByteBuffer byteBuffer5, int i) {
        if (!e(my1Var)) {
            ez4.q("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return null;
        }
        if (!d(i)) {
            ez4.q("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        if (i == 0 && my1Var.p().length == 3 && my1Var.p()[1].c() == 2 && nativeGetYUVImageVUOff(my1Var.p()[2].h(), my1Var.p()[1].h()) == -1) {
            return null;
        }
        int i2 = i % 180;
        int iF = i2 == 0 ? my1Var.f() : my1Var.c();
        int iC = i2 == 0 ? my1Var.c() : my1Var.f();
        ByteBuffer byteBufferNativeNewDirectByteBuffer = nativeNewDirectByteBuffer(byteBuffer5, 1, byteBuffer5.capacity());
        if (nativeRotateYUV(my1Var.p()[0].h(), my1Var.p()[0].a(), my1Var.p()[1].h(), my1Var.p()[1].a(), my1Var.p()[2].h(), my1Var.p()[2].a(), my1Var.p()[2].c(), byteBuffer4, iF, 1, byteBufferNativeNewDirectByteBuffer, iF, 2, byteBuffer5, iF, 2, byteBuffer, byteBuffer2, byteBuffer3, my1Var.f(), my1Var.c(), i) == 0) {
            return new rx1(new ky1(my1Var, byteBuffer4, byteBufferNativeNewDirectByteBuffer, byteBuffer5, iF, iC));
        }
        ez4.q("ImageProcessingUtil", "rotate YUV failure");
        return null;
    }

    public static void h(byte[] bArr, Surface surface) {
        surface.getClass();
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            ez4.q("ImageProcessingUtil", "Failed to enqueue JPEG image.");
        }
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, Surface surface, ByteBuffer byteBuffer4, int i6, int i7, int i8, int i9, int i10, int i11);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z);

    public static native int nativeGetYUVImageVUOff(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    public static native ByteBuffer nativeNewDirectByteBuffer(ByteBuffer byteBuffer, int i, int i2);

    private static native int nativeRotateYUV(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, ByteBuffer byteBuffer4, int i5, int i6, ByteBuffer byteBuffer5, int i7, int i8, ByteBuffer byteBuffer6, int i9, int i10, ByteBuffer byteBuffer7, ByteBuffer byteBuffer8, ByteBuffer byteBuffer9, int i11, int i12, int i13);

    private static native int nativeShiftPixel(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);
}
