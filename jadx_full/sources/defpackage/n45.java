package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n45 extends v45 {
    public final /* synthetic */ int X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n45(a55 a55Var, Activity activity, q35 q35Var) {
        super((b55) a55Var.f, true);
        this.X = 3;
        this.Z = activity;
        this.y0 = q35Var;
        this.Y = a55Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // defpackage.v45
    public final void a() {
        Boolean boolValueOf;
        Bundle bundle = null;
        t35 t35VarAsInterface = null;
        switch (this.X) {
            case 0:
                try {
                    Context context = (Context) this.Z;
                    tj4.i(context);
                    String strT = ye.T(context);
                    Resources resources = context.getResources();
                    if (TextUtils.isEmpty(strT)) {
                        strT = ye.T(context);
                    }
                    int identifier = resources.getIdentifier("google_analytics_force_disable_updates", "bool", strT);
                    if (identifier == 0) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(resources.getBoolean(identifier));
                        } catch (Resources.NotFoundException unused) {
                            boolValueOf = null;
                        }
                    }
                    b55 b55Var = (b55) this.Y;
                    try {
                        t35VarAsInterface = s35.asInterface(yz0.c(context, (boolValueOf == null || !boolValueOf.booleanValue()) != false ? yz0.c : yz0.b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
                    } catch (vz0 e) {
                        b55Var.b(e, true, false);
                    }
                    b55Var.e = t35VarAsInterface;
                    if (b55Var.e != null) {
                        int iA = yz0.a(context, ModuleDescriptor.MODULE_ID);
                        j45 j45Var = new j45(133005L, Math.max(iA, r2), Boolean.TRUE.equals(boolValueOf) || yz0.d(context, ModuleDescriptor.MODULE_ID, false) < iA, (Bundle) this.y0, ye.T(context));
                        t35 t35Var = b55Var.e;
                        tj4.i(t35Var);
                        t35Var.initialize(new bu2(context), j45Var, this.b);
                    } else {
                        a1.n("FA", "Failed to connect to measurement client.");
                    }
                } catch (Exception e2) {
                    ((b55) this.Y).b(e2, true, false);
                    return;
                }
                break;
            case 1:
                t35 t35Var2 = ((b55) this.Y).e;
                tj4.i(t35Var2);
                t35Var2.getMaxUserProperties((String) this.Z, (q35) this.y0);
                break;
            case 2:
                Bundle bundle2 = (Bundle) this.y0;
                if (bundle2 != null) {
                    bundle = new Bundle();
                    if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                        Object obj = bundle2.get("com.google.app_measurement.screen_service");
                        if (obj instanceof Bundle) {
                            bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                        }
                    }
                }
                t35 t35Var3 = ((b55) ((a55) this.Y).f).e;
                tj4.i(t35Var3);
                t35Var3.onActivityCreatedByScionActivityInfo(k45.a((Activity) this.Z), bundle, this.f);
                break;
            default:
                t35 t35Var4 = ((b55) ((a55) this.Y).f).e;
                tj4.i(t35Var4);
                t35Var4.onActivitySaveInstanceStateByScionActivityInfo(k45.a((Activity) this.Z), (q35) this.y0, this.f);
                break;
        }
    }

    @Override // defpackage.v45
    public void b() {
        switch (this.X) {
            case 1:
                ((q35) this.y0).t(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n45(b55 b55Var, Object obj, Object obj2, int i) {
        super(b55Var, true);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
        this.Y = b55Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n45(a55 a55Var, Bundle bundle, Activity activity) {
        super((b55) a55Var.f, true);
        this.X = 2;
        this.y0 = bundle;
        this.Z = activity;
        this.Y = a55Var;
    }
}
