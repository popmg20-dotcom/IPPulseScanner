package com.getsurfboard.ui.provider;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.provider.DocumentsProvider;
import android.util.Log;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.provider.ProfilesProvider;
import com.tencent.mars.xlog.Xlog;
import defpackage.a60;
import defpackage.c73;
import defpackage.d73;
import defpackage.f83;
import defpackage.fw;
import defpackage.fy4;
import defpackage.i60;
import defpackage.ie;
import defpackage.l72;
import defpackage.le2;
import defpackage.n12;
import defpackage.nd1;
import defpackage.p44;
import defpackage.w44;
import io.sentry.android.core.performance.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfilesProvider extends DocumentsProvider {
    public static final /* synthetic */ int z = 0;
    public File b;
    public final ie f = new ie(0);

    public final String a(File file) {
        String strSubstring;
        String absolutePath = file.getAbsolutePath();
        File file2 = this.b;
        if (file2 == null) {
            n12.T("profileDir");
            throw null;
        }
        String path = file2.getPath();
        if (n12.c(path, absolutePath)) {
            strSubstring = "";
        } else {
            path.getClass();
            if (w44.d0(path, "/", false)) {
                absolutePath.getClass();
                strSubstring = absolutePath.substring(path.length());
            } else {
                absolutePath.getClass();
                strSubstring = absolutePath.substring(path.length() + 1);
            }
        }
        return "profile:".concat(strSubstring);
    }

    public final File b(String str) throws FileNotFoundException {
        File file = this.b;
        if (file == null) {
            n12.T("profileDir");
            throw null;
        }
        if (n12.c(str, "root")) {
            return file;
        }
        int iU0 = p44.u0(str, ':', 1, 4);
        if (iU0 < 0) {
            throw new FileNotFoundException("Missing root for ".concat(str));
        }
        File file2 = new File(file, str.substring(iU0 + 1));
        if (file2.exists()) {
            return file2;
        }
        throw new FileNotFoundException("Missing file for " + str + " at " + file2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(MatrixCursor matrixCursor, String str, File file) throws FileNotFoundException {
        String strA;
        int i;
        if (str == null) {
            file.getClass();
            strA = a(file);
        } else {
            strA = str;
        }
        if (file == null) {
            str.getClass();
            file = b(str);
        }
        if (file.isDirectory()) {
            i = (file.isDirectory() && file.canWrite()) ? 8 : 0;
        } else if (file.canWrite()) {
            i = 6;
        }
        String name = file.getName();
        String strE = l72.E(file);
        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
        rowBuilderNewRow.add("document_id", strA);
        rowBuilderNewRow.add("_display_name", name);
        rowBuilderNewRow.add("_size", Long.valueOf(file.length()));
        rowBuilderNewRow.add("mime_type", strE);
        rowBuilderNewRow.add("last_modified", Long.valueOf(file.lastModified()));
        rowBuilderNewRow.add("flags", Integer.valueOf(i));
        rowBuilderNewRow.add("icon", Integer.valueOf(R.mipmap.ic_launcher));
    }

    @Override // android.provider.DocumentsProvider
    public final String copyDocument(String str, String str2) throws IOException {
        str.getClass();
        str2.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "copyDocument");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "copyDocument", null);
        }
        File fileB = b(str);
        File fileB2 = b(str2);
        if (!fileB.exists()) {
            throw new nd1(fileB, null, "The source file doesn't exist.");
        }
        if (fileB2.exists()) {
            throw new nd1(fileB, fileB2, "The destination file already exists.");
        }
        if (!fileB.isDirectory()) {
            File parentFile = fileB2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(fileB);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileB2);
                try {
                    l72.h(fileInputStream, fileOutputStream);
                    fileOutputStream.close();
                    fileInputStream.close();
                } finally {
                }
            } finally {
            }
        } else if (!fileB2.mkdirs()) {
            throw new a60(fileB, fileB2, "Failed to create target directory.");
        }
        return a(fileB2);
    }

    @Override // android.provider.DocumentsProvider
    public final String createDocument(String str, String str2, String str3) throws FileNotFoundException {
        str.getClass();
        str2.getClass();
        str3.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "createDocument");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "createDocument", null);
        }
        File file = new File(b(str).getPath(), str3);
        try {
            file.createNewFile();
            file.setWritable(true);
            file.setReadable(true);
            return a(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotFoundException(fw.u("Failed to create document with name ", str3, " and documentId ", str));
        }
    }

    @Override // android.provider.DocumentsProvider
    public final void deleteDocument(String str) throws FileNotFoundException {
        str.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "deleteDocument");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "deleteDocument", null);
        }
        if (!b(str).delete()) {
            throw new FileNotFoundException("Failed to delete document with id ".concat(str));
        }
        String strConcat = "Deleted file with id ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("ProfilesProvider", strConcat, null);
    }

    @Override // android.provider.DocumentsProvider
    public final String getDocumentType(String str) {
        str.getClass();
        return l72.E(b(str));
    }

    @Override // android.provider.DocumentsProvider
    public final boolean isChildDocument(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return w44.j0(str2, str, false);
    }

    @Override // android.provider.DocumentsProvider
    public final String moveDocument(String str, String str2, String str3) throws FileNotFoundException {
        str.getClass();
        str2.getClass();
        str3.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "moveDocument");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "moveDocument", null);
        }
        File fileB = b(str);
        File file = new File(b(str3), fileB.getName());
        if (fileB.renameTo(file)) {
            return a(file);
        }
        throw new FileNotFoundException("Failed to move document with id ".concat(str));
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        g.f(this);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onCreate");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "onCreate", null);
        }
        this.b = d73.f();
        g.g(this);
        return true;
    }

    @Override // android.provider.DocumentsProvider
    public final ParcelFileDescriptor openDocument(final String str, String str2, CancellationSignal cancellationSignal) throws FileNotFoundException {
        str.getClass();
        str2.getClass();
        String strConcat = "openDocument, mode: ".concat(str2);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", strConcat, null);
        }
        File fileB = b(str);
        int mode = ParcelFileDescriptor.parseMode(str2);
        if (p44.u0(str2, 'w', 0, 6) == -1) {
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(fileB, mode);
            parcelFileDescriptorOpen.getClass();
            return parcelFileDescriptorOpen;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpen2 = ParcelFileDescriptor.open(fileB, mode, new Handler(Looper.getMainLooper()), new ParcelFileDescriptor.OnCloseListener() { // from class: e83
                @Override // android.os.ParcelFileDescriptor.OnCloseListener
                public final void onClose(IOException iOException) throws InterruptedException, IOException {
                    String str3 = str;
                    int i = ProfilesProvider.z;
                    String strO = ha0.o("A file with id ", str3, " has been closed!  Time to update the server.");
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strO);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfilesProvider", strO, null);
                    }
                    d73.h(0, null);
                }
            });
            parcelFileDescriptorOpen2.getClass();
            return parcelFileDescriptorOpen2;
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotFoundException(fw.u("Failed to open document with id ", str, " and mode ", str2));
        }
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryChildDocuments(String str, String[] strArr, String str2) throws FileNotFoundException {
        str.getClass();
        String str3 = "queryChildDocuments, parentDocumentId: " + str + " sortOrder: " + str2;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", str3, null);
        }
        File fileB = b(str);
        f83 f83Var = new f83(this, strArr == null ? l72.d : strArr, str, fileB);
        File[] fileArrListFiles = fileB.listFiles(new c73(2));
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                c(f83Var, null, file);
            }
        }
        return f83Var;
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryDocument(String str, String[] strArr) throws FileNotFoundException {
        str.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "queryDocument");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "queryDocument", null);
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr == null ? l72.d : strArr);
        c(matrixCursor, str, null);
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryRecentDocuments(String str, String[] strArr) throws FileNotFoundException {
        str.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "queryRecentDocuments");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "queryRecentDocuments", null);
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr == null ? l72.d : strArr);
        File fileB = b(str);
        PriorityQueue priorityQueue = new PriorityQueue(5, new i60(9));
        LinkedList linkedList = new LinkedList();
        linkedList.add(fileB);
        while (!linkedList.isEmpty()) {
            Object objRemoveFirst = linkedList.removeFirst();
            objRemoveFirst.getClass();
            File file = (File) objRemoveFirst;
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles(new c73(3));
                if (fileArrListFiles != null) {
                    List listAsList = Arrays.asList(fileArrListFiles);
                    listAsList.getClass();
                    linkedList.addAll(listAsList);
                }
            } else {
                priorityQueue.add(file);
            }
        }
        for (int i = 0; i < 6 && !priorityQueue.isEmpty(); i++) {
            c(matrixCursor, null, (File) priorityQueue.remove());
        }
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryRoots(String[] strArr) {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "queryRoots");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "queryRoots", null);
        }
        if (strArr == null) {
            strArr = l72.c;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
        rowBuilderNewRow.add("root_id", "root");
        rowBuilderNewRow.add("summary", ContextUtilsKt.k(R.string.root_summary));
        rowBuilderNewRow.add("flags", 31);
        rowBuilderNewRow.add("title", ContextUtilsKt.k(R.string.app_name));
        File file = this.b;
        if (file == null) {
            n12.T("profileDir");
            throw null;
        }
        rowBuilderNewRow.add("document_id", a(file));
        rowBuilderNewRow.add("mime_types", "vnd.android.document/directory");
        File file2 = this.b;
        if (file2 == null) {
            n12.T("profileDir");
            throw null;
        }
        rowBuilderNewRow.add("available_bytes", Long.valueOf(file2.getFreeSpace()));
        rowBuilderNewRow.add("icon", Integer.valueOf(R.mipmap.ic_launcher));
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor querySearchDocuments(String str, String str2, String[] strArr) throws FileNotFoundException {
        str.getClass();
        str2.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "querySearchDocuments");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "querySearchDocuments", null);
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr == null ? l72.d : strArr);
        File fileB = b(str);
        LinkedList linkedList = new LinkedList();
        linkedList.add(fileB);
        while (!linkedList.isEmpty() && matrixCursor.getCount() < 20) {
            Object objRemoveFirst = linkedList.removeFirst();
            objRemoveFirst.getClass();
            File file = (File) objRemoveFirst;
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles(new c73(1));
                if (fileArrListFiles != null) {
                    List listAsList = Arrays.asList(fileArrListFiles);
                    listAsList.getClass();
                    linkedList.addAll(listAsList);
                }
            } else {
                String name = file.getName();
                name.getClass();
                String lowerCase = name.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                if (p44.o0(lowerCase, str2, false)) {
                    c(matrixCursor, null, file);
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final void removeDocument(String str, String str2) throws FileNotFoundException {
        str.getClass();
        str2.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "removeDocument");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "removeDocument", null);
        }
        if (!b(str).delete()) {
            throw new FileNotFoundException("Failed to removeDocument document with id ".concat(str));
        }
        String strConcat = "Removed file with id ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("ProfilesProvider", strConcat, null);
    }

    @Override // android.provider.DocumentsProvider
    public final String renameDocument(String str, String str2) throws FileNotFoundException {
        str.getClass();
        str2.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "renameDocument");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", "renameDocument", null);
        }
        File fileB = b(str);
        File file = new File(fileB.getParentFile(), str2);
        if (!fileB.renameTo(file)) {
            throw new FileNotFoundException("Failed to rename document with id ".concat(str));
        }
        String str3 = fileB + " rename to " + file + " with id " + str;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfilesProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfilesProvider", str3, null);
        }
        return a(file);
    }
}
