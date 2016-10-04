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

public class GetUserList extends UseCase {

    final UserRepository userRepository;

    @Inject
    public GetUserList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                       UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userRepository.users();
    }
}
