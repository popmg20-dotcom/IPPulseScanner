package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e15 extends pe5 {
    public Long A0;
    public Long B0;
    public String Z;
    public HashSet y0;
    public ie z0;

    /* JADX WARN: Can't wrap try/catch for region: R(11:(1:69)(9:19|520|20|489|21|(16:23|(9:24|498|25|496|26|27|(1:29)(3:30|(3:32|518|33)(1:38)|39)|46|(1:535)(1:49))|48|70|530|71|472|72|(2:74|75)(4:83|84|(8:85|476|86|500|87|88|99|(1:606)(1:102))|101)|471|119|(1:121)(6:123|(14:125|512|126|127|522|128|478|129|(1:(4:131|(1:133)|134|139))(1:142)|141|156|(3:159|(3:162|(6:593|166|185|183|597|595)(2:167|(11:594|169|(4:172|(2:174|599)(1:600)|175|170)|598|176|(4:179|(3:602|181|605)(1:604)|603|177)|601|182|183|597|595)(4:591|184|596|595))|160)|590)|158|186)(1:190)|191|(12:194|(3:199|(4:202|(5:573|204|(1:206)(1:207)|208|576)(1:575)|574|200)|572)|198|209|(3:214|(4:217|(1:582)(3:579|221|583)|580|215)|577)|213|(3:223|(6:226|(3:228|(2:230|586)|233)(1:231)|232|585|233|224)|584)|234|(3:244|(8:247|(1:249)|250|(1:252)|253|(2:255|588)(1:589)|256|245)|587)|243|257|192)|571|258)|122|259|(3:262|(4:265|(3:537|267|(6:538|269|(7:271|528|272|506|273|(3:275|(11:276|516|277|502|278|279|280|(3:282|526|283)(1:288)|289|296|(1:543)(1:299))|298)(3:300|301|302)|316)(1:322)|323|(4:326|(3:545|328|548)(6:544|329|(2:330|(5:332|(1:334)(1:336)|335|337|(1:339)(2:549|340))(2:550|341))|(1:343)|344|547)|546|324)|542)(1:541))(1:540)|539|263)|536)|(6:346|(3:349|(6:352|(7:354|524|355|487|356|(3:358|(11:359|504|360|492|361|362|363|(3:365|494|366)(1:371)|372|379|(1:554)(1:382))|381)(3:385|386|387)|401)(1:406)|407|(2:408|(2:410|(3:555|412|552)(4:414|(2:415|(4:417|(4:419|(1:421)(1:423)|422|424)(1:425)|426|(1:560)(4:431|(1:433)(1:434)|435|(1:437)(2:561|438)))(2:558|444))|(2:446|556)(1:557)|447))(0))|413|350)|551)|448|(10:451|483|452|453|481|454|564|(3:563|456|567)(1:566)|565|449)|562|463)(2:464|465))(1:50)|52|(1:67)|68)|472|72|(0)(0)|471|119|(0)(0)|122|259|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:0|2|(2:3|(2:5|(2:533|7)(1:534))(2:532|8))|9|(3:11|469|12)|16|(1:69)(9:19|520|20|489|21|(16:23|(9:24|498|25|496|26|27|(1:29)(3:30|(3:32|518|33)(1:38)|39)|46|(1:535)(1:49))|48|70|530|71|472|72|(2:74|75)(4:83|84|(8:85|476|86|500|87|88|99|(1:606)(1:102))|101)|471|119|(1:121)(6:123|(14:125|512|126|127|522|128|478|129|(1:(4:131|(1:133)|134|139))(1:142)|141|156|(3:159|(3:162|(6:593|166|185|183|597|595)(2:167|(11:594|169|(4:172|(2:174|599)(1:600)|175|170)|598|176|(4:179|(3:602|181|605)(1:604)|603|177)|601|182|183|597|595)(4:591|184|596|595))|160)|590)|158|186)(1:190)|191|(12:194|(3:199|(4:202|(5:573|204|(1:206)(1:207)|208|576)(1:575)|574|200)|572)|198|209|(3:214|(4:217|(1:582)(3:579|221|583)|580|215)|577)|213|(3:223|(6:226|(3:228|(2:230|586)|233)(1:231)|232|585|233|224)|584)|234|(3:244|(8:247|(1:249)|250|(1:252)|253|(2:255|588)(1:589)|256|245)|587)|243|257|192)|571|258)|122|259|(3:262|(4:265|(3:537|267|(6:538|269|(7:271|528|272|506|273|(3:275|(11:276|516|277|502|278|279|280|(3:282|526|283)(1:288)|289|296|(1:543)(1:299))|298)(3:300|301|302)|316)(1:322)|323|(4:326|(3:545|328|548)(6:544|329|(2:330|(5:332|(1:334)(1:336)|335|337|(1:339)(2:549|340))(2:550|341))|(1:343)|344|547)|546|324)|542)(1:541))(1:540)|539|263)|536)|(6:346|(3:349|(6:352|(7:354|524|355|487|356|(3:358|(11:359|504|360|492|361|362|363|(3:365|494|366)(1:371)|372|379|(1:554)(1:382))|381)(3:385|386|387)|401)(1:406)|407|(2:408|(2:410|(3:555|412|552)(4:414|(2:415|(4:417|(4:419|(1:421)(1:423)|422|424)(1:425)|426|(1:560)(4:431|(1:433)(1:434)|435|(1:437)(2:561|438)))(2:558|444))|(2:446|556)(1:557)|447))(0))|413|350)|551)|448|(10:451|483|452|453|481|454|564|(3:563|456|567)(1:566)|565|449)|562|463)(2:464|465))(1:50)|52|(1:67)|68)|51|70|530|71|472|72|(0)(0)|471|119|(0)(0)|122|259|(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0247, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0249, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x024a, code lost:
    
        r17 = r2;
        r19 = "Failed to merge filter. appId";
        r20 = "Database error querying filters. appId";
        r21 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0253, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0256, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x09e0, code lost:
    
        r0 = r9.n().C0;
        r2 = defpackage.t65.Z0(r36.Z);
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x09f0, code lost:
    
        if (r12.n() == false) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x09f2, code lost:
    
        r7 = java.lang.Integer.valueOf(r12.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x09fb, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x09fc, code lost:
    
        r0.c("Invalid property filter ID. appId, id", r2, java.lang.String.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01da, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01db, code lost:
    
        r17 = r2;
        r5 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x08dc  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x08e6  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x0ab5  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0abd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cb A[Catch: all -> 0x01d7, SQLiteException -> 0x01da, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x01da, blocks: (B:72:0x01c5, B:74:0x01cb, B:83:0x01e5), top: B:472:0x01c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e5 A[Catch: all -> 0x01d7, SQLiteException -> 0x01da, TRY_ENTER, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x01da, blocks: (B:72:0x01c5, B:74:0x01cb, B:83:0x01e5), top: B:472:0x01c5 }] */
    /* JADX WARN: Type inference failed for: r0v204 */
    /* JADX WARN: Type inference failed for: r0v205 */
    /* JADX WARN: Type inference failed for: r0v31, types: [xw3] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v53, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v19, types: [xw3] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2, types: [k85] */
    /* JADX WARN: Type inference failed for: r17v21 */
    /* JADX WARN: Type inference failed for: r17v22 */
    /* JADX WARN: Type inference failed for: r17v23 */
    /* JADX WARN: Type inference failed for: r17v24, types: [k85] */
    /* JADX WARN: Type inference failed for: r17v30 */
    /* JADX WARN: Type inference failed for: r17v31 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v20, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v29 */
    /* JADX WARN: Type inference failed for: r18v30 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v31 */
    /* JADX WARN: Type inference failed for: r21v32 */
    /* JADX WARN: Type inference failed for: r21v33 */
    /* JADX WARN: Type inference failed for: r21v34 */
    /* JADX WARN: Type inference failed for: r21v35 */
    /* JADX WARN: Type inference failed for: r21v37 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r38v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r38v10 */
    /* JADX WARN: Type inference failed for: r38v11, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r38v12 */
    /* JADX WARN: Type inference failed for: r38v13 */
    /* JADX WARN: Type inference failed for: r38v14 */
    /* JADX WARN: Type inference failed for: r38v15 */
    /* JADX WARN: Type inference failed for: r38v16, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r38v17 */
    /* JADX WARN: Type inference failed for: r38v18 */
    /* JADX WARN: Type inference failed for: r38v19 */
    /* JADX WARN: Type inference failed for: r38v2 */
    /* JADX WARN: Type inference failed for: r38v20 */
    /* JADX WARN: Type inference failed for: r38v21 */
    /* JADX WARN: Type inference failed for: r38v22 */
    /* JADX WARN: Type inference failed for: r38v23 */
    /* JADX WARN: Type inference failed for: r38v24 */
    /* JADX WARN: Type inference failed for: r38v25 */
    /* JADX WARN: Type inference failed for: r38v26 */
    /* JADX WARN: Type inference failed for: r38v27 */
    /* JADX WARN: Type inference failed for: r38v28 */
    /* JADX WARN: Type inference failed for: r38v29 */
    /* JADX WARN: Type inference failed for: r38v3 */
    /* JADX WARN: Type inference failed for: r38v30 */
    /* JADX WARN: Type inference failed for: r38v31 */
    /* JADX WARN: Type inference failed for: r38v32 */
    /* JADX WARN: Type inference failed for: r38v33 */
    /* JADX WARN: Type inference failed for: r38v4 */
    /* JADX WARN: Type inference failed for: r38v5 */
    /* JADX WARN: Type inference failed for: r38v6 */
    /* JADX WARN: Type inference failed for: r38v7 */
    /* JADX WARN: Type inference failed for: r38v8 */
    /* JADX WARN: Type inference failed for: r38v9 */
    /* JADX WARN: Type inference failed for: r3v56, types: [q65] */
    /* JADX WARN: Type inference failed for: r3v70, types: [q65] */
    /* JADX WARN: Type inference failed for: r4v31, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v61 */
    /* JADX WARN: Type inference failed for: r7v62, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v63 */
    /* JADX WARN: Type inference failed for: r7v64 */
    /* JADX WARN: Type inference failed for: r7v67 */
    /* JADX WARN: Type inference failed for: r7v68 */
    /* JADX WARN: Type inference failed for: r7v69, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v70, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v71, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v72 */
    /* JADX WARN: Type inference failed for: r7v73 */
    /* JADX WARN: Type inference failed for: r7v74 */
    /* JADX WARN: Type inference failed for: r7v75 */
    /* JADX WARN: Type inference failed for: r7v76, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v78 */
    /* JADX WARN: Type inference failed for: r7v83 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList Z0(String str, List list, List list2, Long l, Long l2, boolean z) throws Throwable {
        boolean z2;
        boolean z3;
        String str2;
        Map map;
        Cursor cursorQuery;
        String str3;
        Object obj;
        ?? r21;
        Map map2;
        HashSet<Integer> hashSet;
        String str4;
        boolean z4;
        Map map3;
        ?? r10;
        ff5 ff5Var;
        String str5;
        List<f55> list3;
        boolean z5;
        ?? r7;
        Cursor cursorRawQuery;
        ?? r0;
        ?? r17;
        Iterator it;
        String str6;
        boolean z6;
        Iterator it2;
        String str7;
        Iterator it3;
        xw3 xw3Var;
        Map map4;
        xw3 xw3Var2;
        Cursor cursor;
        k85 k85Var;
        List arrayList;
        w25 w25Var;
        long j;
        Map map5;
        oe3 oe3Var;
        Integer num;
        ?? r72;
        String str8;
        ?? r2;
        ?? r38;
        ?? r382;
        ?? r383;
        ?? r384;
        ?? r385;
        List arrayList2;
        ?? r5;
        Object obj2;
        ?? r73;
        ?? Query;
        ?? r18;
        ?? r182;
        ?? r183;
        List arrayList3;
        k85 k85Var2 = (k85) this.f;
        tj4.f(str);
        tj4.i(list);
        tj4.i(list2);
        this.Z = str;
        this.y0 = new HashSet();
        this.z0 = new ie();
        this.A0 = l;
        this.B0 = l2;
        Iterator it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((w75) it4.next()).q())) {
                z2 = true;
                break;
            }
        }
        uf5.a();
        boolean zF1 = k85Var2.A.f1(this.Z, r55.G0);
        uf5.a();
        boolean zF12 = k85Var2.A.f1(this.Z, r55.F0);
        ff5 ff5Var2 = this.X;
        if (z2) {
            m25 m25VarE0 = ff5Var2.e0();
            String str9 = this.Z;
            m25VarE0.W0();
            m25VarE0.V0();
            tj4.f(str9);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                m25VarE0.K1().update("events", contentValues, "app_id = ?", new String[]{str9});
            } catch (SQLiteException e) {
                ((k85) m25VarE0.f).n().z0.c("Error resetting session-scoped event counts. appId", t65.Z0(str9), e);
            }
        }
        Map map6 = Collections.EMPTY_MAP;
        String str10 = "Failed to merge filter. appId";
        Object objZ0 = "Database error querying filters. appId";
        String str11 = "audience_id";
        try {
            if (zF12 && zF1) {
                m25 m25VarE02 = ff5Var2.e0();
                k85 k85Var3 = (k85) m25VarE02.f;
                String str12 = this.Z;
                tj4.f(str12);
                z3 = z2;
                ie ieVar = new ie();
                try {
                    Query = m25VarE02.K1().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str12}, null, null, null);
                    try {
                        try {
                        } catch (SQLiteException e2) {
                            e = e2;
                            str2 = "data";
                        }
                    } catch (Throwable th) {
                        th = th;
                        r18 = Query;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    str2 = "data";
                    r73 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r73 = 0;
                }
                if (Query.moveToFirst()) {
                    str2 = "data";
                    Query = Query;
                    ?? r184 = "event_filters";
                    while (true) {
                        try {
                            try {
                                f55 f55Var = (f55) ((e55) z65.I1(f55.z(), Query.getBlob(1))).e();
                                if (f55Var.t()) {
                                    Integer numValueOf = Integer.valueOf(Query.getInt(0));
                                    List list4 = (List) ieVar.get(numValueOf);
                                    if (list4 == null) {
                                        r184 = Query;
                                        try {
                                            arrayList3 = new ArrayList();
                                            ieVar.put(numValueOf, arrayList3);
                                            r183 = r184;
                                        } catch (SQLiteException e4) {
                                            e = e4;
                                            r182 = r184;
                                            r73 = r182;
                                            try {
                                                k85Var3.n().z0.c("Database error querying filters. appId", t65.Z0(str12), e);
                                                map6 = Collections.EMPTY_MAP;
                                                if (r73 != 0) {
                                                }
                                                map = map6;
                                            } catch (Throwable th3) {
                                                th = th3;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            r18 = r184;
                                        }
                                    } else {
                                        r183 = Query;
                                        arrayList3 = list4;
                                    }
                                    arrayList3.add(f55Var);
                                    r184 = r183;
                                } else {
                                    r184 = Query;
                                }
                            } catch (IOException e5) {
                                r184 = Query;
                                k85Var3.n().z0.c("Failed to merge filter. appId", t65.Z0(str12), e5);
                            }
                            if (!r184.moveToNext()) {
                                break;
                            }
                            Query = r184;
                            r184 = r184;
                        } catch (SQLiteException e6) {
                            e = e6;
                            r182 = Query;
                            r73 = r182;
                            k85Var3.n().z0.c("Database error querying filters. appId", t65.Z0(str12), e);
                            map6 = Collections.EMPTY_MAP;
                            if (r73 != 0) {
                                r73.close();
                            }
                            map = map6;
                            m25 m25VarE03 = ff5Var2.e0();
                            Object obj3 = (k85) m25VarE03.f;
                            ?? r52 = this.Z;
                            m25VarE03.W0();
                            m25VarE03.V0();
                            tj4.f(r52);
                            cursorQuery = m25VarE03.K1().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{r52}, null, null, null);
                            if (cursorQuery.moveToFirst()) {
                            }
                            if (map2.isEmpty()) {
                            }
                            String str13 = str2;
                            String str14 = str3;
                            if (!list.isEmpty()) {
                            }
                            if (z) {
                            }
                        }
                    }
                    r184.close();
                    map = ieVar;
                    m25 m25VarE032 = ff5Var2.e0();
                    Object obj32 = (k85) m25VarE032.f;
                    ?? r522 = this.Z;
                    m25VarE032.W0();
                    m25VarE032.V0();
                    tj4.f(r522);
                    cursorQuery = m25VarE032.K1().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{r522}, null, null, null);
                    if (cursorQuery.moveToFirst()) {
                        ie ieVar2 = new ie();
                        ?? r172 = obj32;
                        ?? r53 = r522;
                        while (true) {
                            try {
                                int i = cursorQuery.getInt(0);
                                try {
                                    t85 t85Var = (t85) ((s85) z65.I1(t85.v(), cursorQuery.getBlob(1))).e();
                                    Object objValueOf = Integer.valueOf(i);
                                    ieVar2.put(objValueOf, t85Var);
                                    str3 = str10;
                                    obj = objZ0;
                                    r21 = r53;
                                    obj2 = objValueOf;
                                    r5 = r53;
                                } catch (IOException e7) {
                                    q65 q65Var = r172.n().z0;
                                    str3 = str10;
                                    str10 = "Failed to merge filter results. appId, audienceId, error";
                                    obj = objZ0;
                                    try {
                                        objZ0 = t65.Z0(r53);
                                        r21 = r53;
                                        try {
                                            Integer numValueOf2 = Integer.valueOf(i);
                                            q65Var.d("Failed to merge filter results. appId, audienceId, error", objZ0, numValueOf2, e7);
                                            obj2 = q65Var;
                                            r5 = numValueOf2;
                                            r21 = r21;
                                        } catch (SQLiteException e8) {
                                            e = e8;
                                            r172.n().z0.c("Database error querying filter results. appId", t65.Z0(r21), e);
                                            Map map7 = Collections.EMPTY_MAP;
                                            if (cursorQuery != null) {
                                            }
                                            map2 = map7;
                                        }
                                    } catch (SQLiteException e9) {
                                        e = e9;
                                        r21 = r53;
                                        r172.n().z0.c("Database error querying filter results. appId", t65.Z0(r21), e);
                                        Map map72 = Collections.EMPTY_MAP;
                                        if (cursorQuery != null) {
                                        }
                                        map2 = map72;
                                    }
                                }
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                }
                                str10 = str3;
                                objZ0 = obj;
                                r53 = r21;
                            } catch (SQLiteException e10) {
                                e = e10;
                                r53 = r53;
                                r172 = r172;
                                str3 = str10;
                                obj = objZ0;
                                r21 = r53;
                                r172.n().z0.c("Database error querying filter results. appId", t65.Z0(r21), e);
                                Map map722 = Collections.EMPTY_MAP;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = map722;
                                if (map2.isEmpty()) {
                                }
                                String str132 = str2;
                                String str142 = str3;
                                if (!list.isEmpty()) {
                                }
                                if (z) {
                                }
                            }
                        }
                        cursorQuery.close();
                        obj32 = obj2;
                        r522 = r5;
                        map2 = ieVar2;
                    } else {
                        Map map8 = Collections.EMPTY_MAP;
                        cursorQuery.close();
                        map2 = map8;
                        str3 = "Failed to merge filter. appId";
                        obj = "Database error querying filters. appId";
                        obj32 = obj32;
                        r522 = r522;
                    }
                    if (map2.isEmpty()) {
                        HashSet hashSet2 = new HashSet(map2.keySet());
                        if (z3) {
                            String str15 = this.Z;
                            m25 m25VarE04 = ff5Var2.e0();
                            String str16 = this.Z;
                            m25VarE04.W0();
                            m25VarE04.V0();
                            tj4.f(str16);
                            ?? ieVar3 = new ie();
                            hashSet = hashSet2;
                            try {
                            } catch (Throwable th5) {
                                th = th5;
                                r7 = hashSet2;
                            }
                            try {
                                cursorRawQuery = m25VarE04.K1().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str16, str16});
                                try {
                                    if (cursorRawQuery.moveToFirst()) {
                                        do {
                                            Integer numValueOf3 = Integer.valueOf(cursorRawQuery.getInt(0));
                                            List arrayList4 = (List) ieVar3.get(numValueOf3);
                                            if (arrayList4 == null) {
                                                arrayList4 = new ArrayList();
                                                ieVar3.put(numValueOf3, arrayList4);
                                            }
                                            arrayList4.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                        } while (cursorRawQuery.moveToNext());
                                    } else {
                                        ieVar3 = Collections.EMPTY_MAP;
                                    }
                                } catch (SQLiteException e11) {
                                    e = e11;
                                    ((k85) m25VarE04.f).n().z0.c("Database error querying scoped filters. appId", t65.Z0(str16), e);
                                    ieVar3 = Collections.EMPTY_MAP;
                                    r0 = ieVar3;
                                    if (cursorRawQuery != null) {
                                    }
                                    tj4.f(str15);
                                    ie ieVar4 = new ie();
                                    if (!map2.isEmpty()) {
                                    }
                                    str4 = str11;
                                    z4 = zF1;
                                    map3 = ieVar4;
                                    Map map9 = map2;
                                    Map map10 = map3;
                                    while (r17.hasNext()) {
                                    }
                                    r10 = obj;
                                    ff5Var = ff5Var2;
                                    str5 = str4;
                                    String str1322 = str2;
                                    String str1422 = str3;
                                    if (!list.isEmpty()) {
                                    }
                                    if (z) {
                                    }
                                }
                            } catch (SQLiteException e12) {
                                e = e12;
                                cursorRawQuery = null;
                            } catch (Throwable th6) {
                                th = th6;
                                r7 = 0;
                                if (r7 != 0) {
                                    r7.close();
                                }
                                throw th;
                            }
                            cursorRawQuery.close();
                            r0 = ieVar3;
                            tj4.f(str15);
                            ie ieVar42 = new ie();
                            if (!map2.isEmpty()) {
                                Iterator it5 = map2.keySet().iterator();
                                while (it5.hasNext()) {
                                    Integer num2 = (Integer) it5.next();
                                    num2.getClass();
                                    t85 t85Var2 = (t85) map2.get(num2);
                                    List list5 = (List) r0.get(num2);
                                    if (list5 == null || list5.isEmpty()) {
                                        r17 = r0;
                                        it = it5;
                                        str6 = str11;
                                        z6 = zF1;
                                        ieVar42.put(num2, t85Var2);
                                        r0 = r17;
                                        str11 = str6;
                                        it5 = it;
                                        zF1 = z6;
                                    } else {
                                        ?? r173 = r0;
                                        it = it5;
                                        List listE1 = ff5Var2.h0().E1((lc5) t85Var2.p(), list5);
                                        if (listE1.isEmpty()) {
                                            r0 = r173;
                                            it5 = it;
                                        } else {
                                            s85 s85Var = (s85) t85Var2.g();
                                            s85Var.i();
                                            s85Var.c();
                                            str6 = str11;
                                            ((t85) s85Var.f).z(listE1);
                                            List listE12 = ff5Var2.h0().E1((lc5) t85Var2.n(), list5);
                                            s85Var.h();
                                            s85Var.c();
                                            ((t85) s85Var.f).x(listE12);
                                            ArrayList arrayList5 = new ArrayList();
                                            Iterator it6 = t85Var2.r().iterator();
                                            while (it6.hasNext()) {
                                                Iterator it7 = it6;
                                                u75 u75Var = (u75) it6.next();
                                                boolean z7 = zF1;
                                                if (!list5.contains(Integer.valueOf(u75Var.o()))) {
                                                    arrayList5.add(u75Var);
                                                }
                                                it6 = it7;
                                                zF1 = z7;
                                            }
                                            z6 = zF1;
                                            s85Var.j();
                                            s85Var.c();
                                            ((t85) s85Var.f).B(arrayList5);
                                            ArrayList arrayList6 = new ArrayList();
                                            for (w85 w85Var : t85Var2.t()) {
                                                if (!list5.contains(Integer.valueOf(w85Var.o()))) {
                                                    arrayList6.add(w85Var);
                                                }
                                            }
                                            s85Var.k();
                                            s85Var.c();
                                            ((t85) s85Var.f).D(arrayList6);
                                            ieVar42.put(num2, (t85) s85Var.e());
                                            r17 = r173;
                                            r0 = r17;
                                            str11 = str6;
                                            it5 = it;
                                            zF1 = z6;
                                        }
                                    }
                                }
                            }
                            str4 = str11;
                            z4 = zF1;
                            map3 = ieVar42;
                        } else {
                            hashSet = hashSet2;
                            str4 = "audience_id";
                            z4 = zF1;
                            map3 = map2;
                        }
                        Map map92 = map2;
                        Map map102 = map3;
                        for (Integer num3 : hashSet) {
                            num3.getClass();
                            t85 t85Var3 = (t85) map102.get(num3);
                            BitSet bitSet = new BitSet();
                            BitSet bitSet2 = new BitSet();
                            ie ieVar5 = new ie();
                            if (t85Var3 != null && t85Var3.s() != 0) {
                                for (u75 u75Var2 : t85Var3.r()) {
                                    if (u75Var2.n()) {
                                        t85 t85Var4 = t85Var3;
                                        ieVar5.put(Integer.valueOf(u75Var2.o()), u75Var2.p() ? Long.valueOf(u75Var2.q()) : null);
                                        t85Var3 = t85Var4;
                                    }
                                }
                            }
                            t85 t85Var5 = t85Var3;
                            ie ieVar6 = new ie();
                            if (t85Var5 != null && t85Var5.u() != 0) {
                                Iterator it8 = t85Var5.t().iterator();
                                while (it8.hasNext()) {
                                    w85 w85Var2 = (w85) it8.next();
                                    if (w85Var2.n() && w85Var2.q() > 0) {
                                        ieVar6.put(Integer.valueOf(w85Var2.o()), Long.valueOf(w85Var2.r(w85Var2.q() - 1)));
                                        it8 = it8;
                                        map102 = map102;
                                    }
                                }
                            }
                            Map map11 = map102;
                            if (t85Var5 != null) {
                                int i2 = 0;
                                while (i2 < t85Var5.o() * 64) {
                                    if (z65.C1((lc5) t85Var5.n(), i2)) {
                                        z5 = zF12;
                                        k85Var2.n().H0.c("Filter already evaluated. audience ID, filter ID", num3, Integer.valueOf(i2));
                                        bitSet2.set(i2);
                                        if (z65.C1((lc5) t85Var5.p(), i2)) {
                                            bitSet.set(i2);
                                        }
                                        i2++;
                                        zF12 = z5;
                                    } else {
                                        z5 = zF12;
                                    }
                                    ieVar5.remove(Integer.valueOf(i2));
                                    i2++;
                                    zF12 = z5;
                                }
                            }
                            boolean z8 = zF12;
                            t85 t85Var6 = (t85) map92.get(num3);
                            if (z8 && z4 && (list3 = (List) map.get(num3)) != null && this.B0 != null && this.A0 != null) {
                                for (f55 f55Var2 : list3) {
                                    int iO = f55Var2.o();
                                    Integer num4 = num3;
                                    long jLongValue = this.B0.longValue() / 1000;
                                    if (f55Var2.w()) {
                                        jLongValue = this.A0.longValue() / 1000;
                                    }
                                    Integer numValueOf4 = Integer.valueOf(iO);
                                    if (ieVar5.containsKey(numValueOf4)) {
                                        ieVar5.put(numValueOf4, Long.valueOf(jLongValue));
                                    }
                                    if (ieVar6.containsKey(numValueOf4)) {
                                        ieVar6.put(numValueOf4, Long.valueOf(jLongValue));
                                    }
                                    num3 = num4;
                                }
                            }
                            this.z0.put(num3, new mh5(this, this.Z, t85Var6, bitSet, bitSet2, ieVar5, ieVar6));
                            ff5Var2 = ff5Var2;
                            zF12 = z8;
                            map92 = map92;
                            obj = obj;
                            map = map;
                            str3 = str3;
                            map102 = map11;
                        }
                        r10 = obj;
                        ff5Var = ff5Var2;
                        str5 = str4;
                    } else {
                        r10 = obj;
                        ff5Var = ff5Var2;
                        str5 = "audience_id";
                    }
                    String str13222 = str2;
                    String str14222 = str3;
                    if (!list.isEmpty()) {
                        oe3 oe3Var2 = new oe3(this);
                        ?? ieVar7 = new ie();
                        for (w75 w75Var : list) {
                            w75 w75VarC = oe3Var2.c(this.Z, w75Var);
                            if (w75VarC != null) {
                                w25 w25VarB1 = ff5Var.e0().B1(this.Z, w75Var, w75VarC.q());
                                ff5Var.e0().u1("events", w25VarB1);
                                if (z) {
                                    continue;
                                } else {
                                    long j2 = w25VarB1.c;
                                    String strQ = w75VarC.q();
                                    Map map12 = (Map) ieVar7.get(strQ);
                                    if (map12 == null) {
                                        m25 m25VarE05 = ff5Var.e0();
                                        w25Var = w25VarB1;
                                        k85 k85Var4 = (k85) m25VarE05.f;
                                        String str17 = this.Z;
                                        m25VarE05.W0();
                                        m25VarE05.V0();
                                        tj4.f(str17);
                                        tj4.f(strQ);
                                        j = j2;
                                        ie ieVar8 = new ie();
                                        try {
                                            ?? Query2 = m25VarE05.K1().query("event_filters", new String[]{str5, str13222}, "app_id=? AND event_name=?", new String[]{str17, strQ}, null, null, null);
                                            try {
                                                try {
                                                    if (Query2.moveToFirst()) {
                                                        str8 = str17;
                                                        Query2 = Query2;
                                                        ?? r386 = list;
                                                        while (true) {
                                                            try {
                                                                try {
                                                                    f55 f55Var3 = (f55) ((e55) z65.I1(f55.z(), Query2.getBlob(1))).e();
                                                                    Integer numValueOf5 = Integer.valueOf(Query2.getInt(0));
                                                                    List list6 = (List) ieVar8.get(numValueOf5);
                                                                    if (list6 == null) {
                                                                        r386 = Query2;
                                                                        try {
                                                                            arrayList2 = new ArrayList();
                                                                            ieVar8.put(numValueOf5, arrayList2);
                                                                            r385 = r386;
                                                                        } catch (SQLiteException e13) {
                                                                            e = e13;
                                                                            r384 = r386;
                                                                            r2 = r384;
                                                                            r38 = r384;
                                                                            try {
                                                                                k85Var4.n().z0.c(r10, t65.Z0(str8), e);
                                                                                map12 = Collections.EMPTY_MAP;
                                                                                r382 = r38;
                                                                                if (r2 != 0) {
                                                                                }
                                                                            } catch (Throwable th7) {
                                                                                th = th7;
                                                                                r72 = r2;
                                                                                if (r72 != 0) {
                                                                                    r72.close();
                                                                                }
                                                                                throw th;
                                                                            }
                                                                        } catch (Throwable th8) {
                                                                            th = th8;
                                                                            r383 = r386;
                                                                            r72 = r383;
                                                                            if (r72 != 0) {
                                                                            }
                                                                            throw th;
                                                                        }
                                                                    } else {
                                                                        r385 = Query2;
                                                                        arrayList2 = list6;
                                                                    }
                                                                    arrayList2.add(f55Var3);
                                                                    r386 = r385;
                                                                } catch (IOException e14) {
                                                                    r386 = Query2;
                                                                    k85Var4.n().z0.c(str14222, t65.Z0(str8), e14);
                                                                }
                                                                if (!r386.moveToNext()) {
                                                                    break;
                                                                }
                                                                Query2 = r386;
                                                                r386 = r386;
                                                            } catch (SQLiteException e15) {
                                                                e = e15;
                                                                r384 = Query2;
                                                                r2 = r384;
                                                                r38 = r384;
                                                                k85Var4.n().z0.c(r10, t65.Z0(str8), e);
                                                                map12 = Collections.EMPTY_MAP;
                                                                r382 = r38;
                                                                if (r2 != 0) {
                                                                    r2.close();
                                                                    r382 = r38;
                                                                }
                                                                ieVar7.put(strQ, map12);
                                                                list = r382;
                                                                while (r19.hasNext()) {
                                                                }
                                                            }
                                                        }
                                                        r386.close();
                                                        map12 = ieVar8;
                                                        r382 = r386;
                                                    } else {
                                                        ?? r387 = Query2;
                                                        map12 = Collections.EMPTY_MAP;
                                                        r387.close();
                                                        r382 = r387;
                                                    }
                                                } catch (SQLiteException e16) {
                                                    e = e16;
                                                    str8 = str17;
                                                }
                                            } catch (Throwable th9) {
                                                th = th9;
                                                r383 = Query2;
                                            }
                                        } catch (SQLiteException e17) {
                                            e = e17;
                                            str8 = str17;
                                            r2 = 0;
                                            r38 = list;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            r72 = 0;
                                        }
                                        ieVar7.put(strQ, map12);
                                        list = r382;
                                    } else {
                                        w25Var = w25VarB1;
                                        j = j2;
                                        list = list;
                                    }
                                    for (Integer num5 : map12.keySet()) {
                                        int iIntValue = num5.intValue();
                                        if (this.y0.contains(num5)) {
                                            k85Var2.n().H0.b(num5, "Skipping failed audience ID");
                                        } else {
                                            Iterator it9 = ((List) map12.get(num5)).iterator();
                                            boolean zA = true;
                                            while (true) {
                                                if (!it9.hasNext()) {
                                                    map5 = map12;
                                                    oe3Var = oe3Var2;
                                                    num = num5;
                                                    break;
                                                }
                                                f55 f55Var4 = (f55) it9.next();
                                                map5 = map12;
                                                oe3Var = oe3Var2;
                                                num = num5;
                                                z05 z05Var = new z05(this, this.Z, iIntValue, f55Var4, 0);
                                                Long l3 = this.A0;
                                                Long l4 = this.B0;
                                                int iO2 = f55Var4.o();
                                                mh5 mh5Var = (mh5) this.z0.get(num);
                                                zA = z05Var.a(l3, l4, w75VarC, j, w25Var, mh5Var == null ? false : mh5Var.d.get(iO2));
                                                if (!zA) {
                                                    this.y0.add(num);
                                                    break;
                                                }
                                                a1(num).a(z05Var);
                                                num5 = num;
                                                map12 = map5;
                                                oe3Var2 = oe3Var;
                                            }
                                            if (!zA) {
                                                this.y0.add(num);
                                            }
                                            oe3Var2 = oe3Var;
                                            map12 = map5;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (z) {
                        return new ArrayList();
                    }
                    if (!list2.isEmpty()) {
                        ie ieVar9 = new ie();
                        Iterator it10 = list2.iterator();
                        xw3 xw3Var3 = ieVar9;
                        while (it10.hasNext()) {
                            a95 a95Var = (a95) it10.next();
                            String strP = a95Var.p();
                            Map map13 = (Map) xw3Var3.get(strP);
                            if (map13 == null) {
                                m25 m25VarE06 = ff5Var.e0();
                                k85 k85Var5 = (k85) m25VarE06.f;
                                String str18 = this.Z;
                                m25VarE06.W0();
                                m25VarE06.V0();
                                tj4.f(str18);
                                tj4.f(strP);
                                ie ieVar10 = new ie();
                                try {
                                    Cursor cursorQuery2 = m25VarE06.K1().query("property_filters", new String[]{str5, str13222}, "app_id=? AND property_name=?", new String[]{str18, strP}, null, null, null);
                                    try {
                                        try {
                                            if (cursorQuery2.moveToFirst()) {
                                                it2 = it10;
                                                while (true) {
                                                    try {
                                                        try {
                                                            m55 m55Var = (m55) ((l55) z65.I1(m55.v(), cursorQuery2.getBlob(1))).e();
                                                            Integer numValueOf6 = Integer.valueOf(cursorQuery2.getInt(0));
                                                            List list7 = (List) ieVar10.get(numValueOf6);
                                                            if (list7 == null) {
                                                                k85Var = k85Var5;
                                                                try {
                                                                    arrayList = new ArrayList();
                                                                    ieVar10.put(numValueOf6, arrayList);
                                                                } catch (SQLiteException e18) {
                                                                    e = e18;
                                                                    str7 = str13222;
                                                                    cursor = cursorQuery2;
                                                                    try {
                                                                        k85Var.n().z0.c(r10, t65.Z0(str18), e);
                                                                        map13 = Collections.EMPTY_MAP;
                                                                        if (cursor != null) {
                                                                        }
                                                                    } catch (Throwable th11) {
                                                                        th = th11;
                                                                        if (cursor != null) {
                                                                            cursor.close();
                                                                        }
                                                                        throw th;
                                                                    }
                                                                }
                                                            } else {
                                                                k85Var = k85Var5;
                                                                arrayList = list7;
                                                            }
                                                            arrayList.add(m55Var);
                                                            str7 = str13222;
                                                        } catch (IOException e19) {
                                                            k85Var = k85Var5;
                                                            str7 = str13222;
                                                            try {
                                                                k85Var.n().z0.c("Failed to merge filter", t65.Z0(str18), e19);
                                                            } catch (SQLiteException e20) {
                                                                e = e20;
                                                                cursor = cursorQuery2;
                                                                k85Var.n().z0.c(r10, t65.Z0(str18), e);
                                                                map13 = Collections.EMPTY_MAP;
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                            }
                                                        }
                                                        if (!cursorQuery2.moveToNext()) {
                                                            break;
                                                        }
                                                        k85Var5 = k85Var;
                                                        str13222 = str7;
                                                    } catch (SQLiteException e21) {
                                                        e = e21;
                                                        k85Var = k85Var5;
                                                        str7 = str13222;
                                                        cursor = cursorQuery2;
                                                        k85Var.n().z0.c(r10, t65.Z0(str18), e);
                                                        map13 = Collections.EMPTY_MAP;
                                                        if (cursor != null) {
                                                        }
                                                        xw3Var3.put(strP, map13);
                                                        it3 = map13.keySet().iterator();
                                                        xw3Var = xw3Var3;
                                                        while (true) {
                                                            if (!it3.hasNext()) {
                                                                break;
                                                            }
                                                            map13 = map4;
                                                            xw3Var = xw3Var2;
                                                        }
                                                        str13222 = str7;
                                                        it10 = it2;
                                                        xw3Var3 = xw3Var;
                                                    }
                                                }
                                                cursorQuery2.close();
                                                map13 = ieVar10;
                                            } else {
                                                it2 = it10;
                                                str7 = str13222;
                                                map13 = Collections.EMPTY_MAP;
                                                cursorQuery2.close();
                                            }
                                        } catch (Throwable th12) {
                                            th = th12;
                                            cursor = cursorQuery2;
                                            if (cursor != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e22) {
                                        e = e22;
                                        it2 = it10;
                                    }
                                } catch (SQLiteException e23) {
                                    e = e23;
                                    it2 = it10;
                                    k85Var = k85Var5;
                                    str7 = str13222;
                                    cursor = null;
                                } catch (Throwable th13) {
                                    th = th13;
                                    cursor = null;
                                }
                                xw3Var3.put(strP, map13);
                            } else {
                                it2 = it10;
                                str7 = str13222;
                            }
                            it3 = map13.keySet().iterator();
                            xw3Var = xw3Var3;
                            while (true) {
                                if (!it3.hasNext()) {
                                    Integer num6 = (Integer) it3.next();
                                    int iIntValue2 = num6.intValue();
                                    if (this.y0.contains(num6)) {
                                        k85Var2.n().H0.b(num6, "Skipping failed audience ID");
                                        break;
                                    }
                                    Iterator it11 = ((List) map13.get(num6)).iterator();
                                    boolean zB = true;
                                    xw3 xw3Var4 = xw3Var;
                                    while (true) {
                                        if (!it11.hasNext()) {
                                            map4 = map13;
                                            xw3Var2 = xw3Var4;
                                            break;
                                        }
                                        m55 m55Var2 = (m55) it11.next();
                                        if (Log.isLoggable(k85Var2.n().b1(), 2)) {
                                            map4 = map13;
                                            xw3Var2 = xw3Var4;
                                            k85Var2.n().H0.d("Evaluating filter. audience, filter, property", num6, m55Var2.n() ? Integer.valueOf(m55Var2.o()) : null, k85Var2.A0.c(m55Var2.p()));
                                            k85Var2.n().H0.b(ff5Var.h0().z1(m55Var2), "Filter definition");
                                        } else {
                                            map4 = map13;
                                            xw3Var2 = xw3Var4;
                                        }
                                        if (!m55Var2.n() || m55Var2.o() > 256) {
                                            break;
                                        }
                                        int i3 = iIntValue2;
                                        z05 z05Var2 = new z05(this, this.Z, i3, m55Var2, 1);
                                        Long l5 = this.A0;
                                        Long l6 = this.B0;
                                        int iO3 = m55Var2.o();
                                        mh5 mh5Var2 = (mh5) this.z0.get(num6);
                                        zB = z05Var2.b(l5, l6, a95Var, mh5Var2 == null ? false : mh5Var2.d.get(iO3));
                                        if (!zB) {
                                            this.y0.add(num6);
                                            xw3Var2 = xw3Var2;
                                            break;
                                        }
                                        a1(num6).a(z05Var2);
                                        iIntValue2 = i3;
                                        map13 = map4;
                                        xw3Var4 = xw3Var2;
                                    }
                                    if (!zB) {
                                        this.y0.add(num6);
                                    }
                                    map13 = map4;
                                    xw3Var = xw3Var2;
                                }
                            }
                            str13222 = str7;
                            it10 = it2;
                            xw3Var3 = xw3Var;
                        }
                    }
                    ArrayList arrayList7 = new ArrayList();
                    fe<Integer> feVar = (fe) this.z0.keySet();
                    feVar.removeAll(this.y0);
                    for (Integer num7 : feVar) {
                        int iIntValue3 = num7.intValue();
                        mh5 mh5Var3 = (mh5) this.z0.get(num7);
                        tj4.i(mh5Var3);
                        k75 k75VarB = mh5Var3.b(iIntValue3);
                        arrayList7.add(k75VarB);
                        m25 m25VarE07 = ff5Var.e0();
                        k85 k85Var6 = (k85) m25VarE07.f;
                        String str19 = this.Z;
                        t85 t85VarP = k75VarB.p();
                        m25VarE07.W0();
                        m25VarE07.V0();
                        tj4.f(str19);
                        tj4.i(t85VarP);
                        byte[] bArrA = t85VarP.a();
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str19);
                        contentValues2.put(str5, num7);
                        contentValues2.put("current_results", bArrA);
                        try {
                            try {
                                if (m25VarE07.K1().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                    k85Var6.n().z0.b(t65.Z0(str19), "Failed to insert filter results (got -1). appId");
                                }
                            } catch (SQLiteException e24) {
                                e = e24;
                                k85Var6.n().z0.c("Error storing filter results. appId", t65.Z0(str19), e);
                            }
                        } catch (SQLiteException e25) {
                            e = e25;
                        }
                    }
                    return arrayList7;
                }
                str2 = "data";
                Query.close();
                r73 = r18;
                if (r73 != 0) {
                    r73.close();
                }
                throw th;
            }
            z3 = z2;
            str2 = "data";
            if (cursorQuery.moveToFirst()) {
            }
            if (map2.isEmpty()) {
            }
            String str132222 = str2;
            String str142222 = str3;
            if (!list.isEmpty()) {
            }
            if (z) {
            }
        } catch (Throwable th14) {
            th = th14;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        map = map6;
        m25 m25VarE0322 = ff5Var2.e0();
        Object obj322 = (k85) m25VarE0322.f;
        ?? r5222 = this.Z;
        m25VarE0322.W0();
        m25VarE0322.V0();
        tj4.f(r5222);
        cursorQuery = m25VarE0322.K1().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{r5222}, null, null, null);
    }

    public final mh5 a1(Integer num) {
        if (this.z0.containsKey(num)) {
            return (mh5) this.z0.get(num);
        }
        mh5 mh5Var = new mh5(this, this.Z);
        this.z0.put(num, mh5Var);
        return mh5Var;
    }

    @Override // defpackage.pe5
    public final void Y0() {
    }
}
