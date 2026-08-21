package com.getsurfboard.database;

import com.getsurfboard.database.AppDatabase_Impl;
import defpackage.dh3;
import defpackage.g41;
import defpackage.gm2;
import defpackage.h31;
import defpackage.ij3;
import defpackage.j50;
import defpackage.n84;
import defpackage.os1;
import defpackage.pl1;
import defpackage.ua3;
import defpackage.wc;
import defpackage.y12;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {
    public final n84 k;
    public final n84 l;
    public final n84 m;

    public AppDatabase_Impl() {
        final int i = 0;
        this.k = new n84(new pl1(this) { // from class: vc
            public final /* synthetic */ AppDatabase_Impl f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i2 = i;
                AppDatabase_Impl appDatabase_Impl = this.f;
                switch (i2) {
                    case 0:
                        return new ua3(appDatabase_Impl);
                    case 1:
                        return new ij3(appDatabase_Impl);
                    default:
                        return new os1(appDatabase_Impl);
                }
            }
        });
        final int i2 = 1;
        this.l = new n84(new pl1(this) { // from class: vc
            public final /* synthetic */ AppDatabase_Impl f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i22 = i2;
                AppDatabase_Impl appDatabase_Impl = this.f;
                switch (i22) {
                    case 0:
                        return new ua3(appDatabase_Impl);
                    case 1:
                        return new ij3(appDatabase_Impl);
                    default:
                        return new os1(appDatabase_Impl);
                }
            }
        });
        final int i3 = 2;
        this.m = new n84(new pl1(this) { // from class: vc
            public final /* synthetic */ AppDatabase_Impl f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i22 = i3;
                AppDatabase_Impl appDatabase_Impl = this.f;
                switch (i22) {
                    case 0:
                        return new ua3(appDatabase_Impl);
                    case 1:
                        return new ij3(appDatabase_Impl);
                    default:
                        return new os1(appDatabase_Impl);
                }
            }
        });
    }

    @Override // defpackage.pl3
    public final List c(LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new gm2(1, 2, 10));
        arrayList.add(new gm2(2, 3, 11));
        arrayList.add(new gm2(4, 5, 12));
        return arrayList;
    }

    @Override // defpackage.pl3
    public final y12 d() {
        return new y12(this, new LinkedHashMap(), new LinkedHashMap(), "proxy_group_selection", "requests", "hosts");
    }

    @Override // defpackage.pl3
    public final h31 e() {
        return new wc(this);
    }

    @Override // defpackage.pl3
    public final Set i() {
        return new LinkedHashSet();
    }

    @Override // defpackage.pl3
    public final LinkedHashMap j() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        j50 j50VarA = dh3.a(ua3.class);
        g41 g41Var = g41.b;
        linkedHashMap.put(j50VarA, g41Var);
        linkedHashMap.put(dh3.a(ij3.class), g41Var);
        linkedHashMap.put(dh3.a(os1.class), g41Var);
        return linkedHashMap;
    }

    @Override // com.getsurfboard.database.AppDatabase
    public final os1 s() {
        return (os1) this.m.getValue();
    }

    @Override // com.getsurfboard.database.AppDatabase
    public final ua3 t() {
        return (ua3) this.k.getValue();
    }

    @Override // com.getsurfboard.database.AppDatabase
    public final ij3 u() {
        return (ij3) this.l.getValue();
    }
}
