package com.domain.interactor;

import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class GetUserDetails extends UseCase {

    final int userId;
    final UserRepository userRepository;

    @Inject
    public GetUserDetails(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                          int userId, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userId = userId;
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userRepository.user(this.userId);
    }
}
