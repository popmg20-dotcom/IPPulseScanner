package defpackage;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.FileObserver;
import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g83 extends FileObserver {
    public final File a;
    public final ContentResolver b;
    public final Uri c;
    public final CopyOnWriteArrayList d;

    public g83(File file, ContentResolver contentResolver, Uri uri) {
        super(file.getAbsolutePath(), 4044);
        this.a = file;
        this.b = contentResolver;
        this.c = uri;
        this.d = new CopyOnWriteArrayList();
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String str2 = "onEvent() called with: event = " + i + ", path = " + str;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", str2, null);
        }
        Iterator it = this.d.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((f83) it.next()).g();
        }
        int i2 = Build.VERSION.SDK_INT;
        ContentResolver contentResolver = this.b;
        Uri uri = this.c;
        if (i2 >= 24) {
            contentResolver.notifyChange(uri, (ContentObserver) null, 0);
        } else {
            contentResolver.notifyChange(uri, (ContentObserver) null, false);
        }
    }

    public final String toString() {
        return fw.t(this.d.size(), "DirectoryObserver{file=", this.a.getAbsolutePath(), ", ref=", "}");
    }
}
