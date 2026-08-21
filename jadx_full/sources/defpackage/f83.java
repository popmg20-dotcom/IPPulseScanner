package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.getsurfboard.ui.provider.ProfilesProvider;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f83 extends MatrixCursor {
    public final File b;
    public final /* synthetic */ ProfilesProvider f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f83(ProfilesProvider profilesProvider, String[] strArr, String str, File file) {
        super(strArr);
        this.f = profilesProvider;
        int i = ProfilesProvider.z;
        Uri uriBuildChildDocumentsUri = DocumentsContract.buildChildDocumentsUri("com.getsurfboard.profiles_document", str);
        uriBuildChildDocumentsUri.getClass();
        Context context = profilesProvider.getContext();
        context.getClass();
        setNotificationUri(context.getContentResolver(), uriBuildChildDocumentsUri);
        this.b = file;
        synchronized (profilesProvider.f) {
            try {
                g83 g83Var = (g83) profilesProvider.f.get(file);
                if (g83Var == null) {
                    Context context2 = profilesProvider.getContext();
                    context2.getClass();
                    ContentResolver contentResolver = context2.getContentResolver();
                    contentResolver.getClass();
                    g83Var = new g83(file, contentResolver, uriBuildChildDocumentsUri);
                    g83Var.startWatching();
                    profilesProvider.f.put(file, g83Var);
                }
                g83Var.d.add(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        ProfilesProvider profilesProvider = this.f;
        File file = this.b;
        int i = ProfilesProvider.z;
        synchronized (profilesProvider.f) {
            g83 g83Var = (g83) profilesProvider.f.get(file);
            if (g83Var == null) {
                return;
            }
            g83Var.d.remove(this);
            if (g83Var.d.isEmpty()) {
                profilesProvider.f.remove(file);
                g83Var.stopWatching();
            }
        }
    }

    public final void g() {
        onChange(false);
    }
}
