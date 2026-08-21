package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yd0 implements gd1 {
    public final Uri a;
    public final rw2 b;

    public yd0(Uri uri, rw2 rw2Var) {
        this.a = uri;
        this.b = rw2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    @Override // defpackage.gd1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ge0 ge0Var) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream;
        List<String> pathSegments;
        int size;
        Bundle bundle;
        rw2 rw2Var = this.b;
        ContentResolver contentResolver = rw2Var.a.getContentResolver();
        Uri uri = this.a;
        if (n12.c(uri.getAuthority(), "com.android.contacts") && n12.c(uri.getLastPathSegment(), "display_photo")) {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                ad0.j("Unable to find a contact photo associated with '", uri, "'.");
                return null;
            }
        } else if (Build.VERSION.SDK_INT >= 29 && n12.c(uri.getAuthority(), "media") && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && n12.c(pathSegments.get(size - 3), "audio") && n12.c(pathSegments.get(size - 2), "albums")) {
            wx3 wx3Var = rw2Var.d;
            p95 p95Var = wx3Var.a;
            qu0 qu0Var = p95Var instanceof qu0 ? (qu0) p95Var : null;
            if (qu0Var != null) {
                int i = qu0Var.n;
                p95 p95Var2 = wx3Var.b;
                qu0 qu0Var2 = p95Var2 instanceof qu0 ? (qu0) p95Var2 : null;
                if (qu0Var2 != null) {
                    int i2 = qu0Var2.n;
                    bundle = new Bundle(1);
                    bundle.putParcelable("android.content.extra.SIZE", new Point(i, i2));
                } else {
                    bundle = null;
                }
                AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(uri, "image/*", bundle, null);
                inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
                if (inputStreamOpenInputStream == null) {
                    ad0.j("Unable to find a music thumbnail associated with '", uri, "'.");
                    return null;
                }
            }
        } else {
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                ad0.j("Unable to open '", uri, "'.");
                return null;
            }
        }
        return new pz3(new nz3(new he3(tj4.d0(inputStreamOpenInputStream)), new cf()), contentResolver.getType(uri), pi0.z);
    }
}
