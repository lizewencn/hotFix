package com.lizewen.hotfix;

import android.app.Application;

import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

/**
 * Created by lizewen on 2017/8/25.
 * company:SDJ
 * email:lizewencn@126.com
 */

public class FixApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationLike tinkerPatchApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();

        TinkerPatch.init(tinkerPatchApplicationLike)
                .setPatchRestartOnSrceenOff(true)
                .setFetchPatchIntervalByHours(3)
                .setPatchRollbackOnScreenOff(true);
        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();


    }
}
