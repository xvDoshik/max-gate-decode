package androidx.work;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class CoroutineWorker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ CoroutineWorker$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02b6 A[Catch: all -> 0x028e, Exception -> 0x0291, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:103:0x02e3 A[Catch: all -> 0x028e, Exception -> 0x0291, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02fc A[Catch: all -> 0x028e, Exception -> 0x0291, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0325  */
    /* JADX WARN: Code duplicated, block: B:110:0x03d6 A[Catch: all -> 0x028e, Exception -> 0x0291, TRY_LEAVE, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:113:0x03e6 A[Catch: all -> 0x028e, Exception -> 0x0291, LOOP:5: B:113:0x03e6->B:227:?, LOOP_START, TRY_ENTER, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:227:? A[LOOP:5: B:113:0x03e6->B:227:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0289 A[Catch: all -> 0x028e, Exception -> 0x0291, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0294 A[Catch: all -> 0x028e, Exception -> 0x0291, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:95:0x029e  */
    /* JADX WARN: Code duplicated, block: B:96:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:99:0x02ad A[Catch: all -> 0x028e, Exception -> 0x0291, TryCatch #8 {all -> 0x028e, blocks: (B:65:0x013f, B:69:0x01e6, B:71:0x01ed, B:80:0x01fe, B:86:0x020f, B:88:0x0289, B:97:0x02a3, B:99:0x02ad, B:101:0x02bc, B:103:0x02e3, B:104:0x02f6, B:106:0x02fc, B:108:0x0326, B:110:0x03d6, B:113:0x03e6, B:115:0x03f0, B:116:0x03f4, B:118:0x03fc, B:120:0x0402, B:123:0x0409, B:100:0x02b6, B:93:0x0294, B:74:0x01f2, B:128:0x0418), top: B:205:0x013f }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:117:0x03fa
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // java.lang.Runnable
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.CoroutineWorker$$ExternalSyntheticLambda0.run():void");
    }
}
