package com.domain.executor;

import rx.Scheduler;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
