package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import io.sentry.android.core.internal.threaddump.a;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sb0 {
    public final ArrayList a;
    public final int b;
    public int c;

    public sb0(Context context, XmlResourceParser xmlResourceParser) {
        this.a = new ArrayList();
        this.c = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), wc3.h);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(index, this.b);
            } else if (index == 1) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.c);
                this.c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new ac0().a(context, resourceId);
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public a a() {
        int i = this.c;
        if (i < 0 || i >= this.b) {
            return null;
        }
        this.c = i + 1;
        return (a) this.a.get(i);
    }

    public sb0(ArrayList arrayList) {
        this.a = arrayList;
        this.b = arrayList.size();
    }
}
