package com.domain.interactor;

import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.PostRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class GetPostNewList extends UseCase {

    final PostRepository postRepository;

    @Inject
    public GetPostNewList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                          PostRepository postRepository) {
        super(threadExecutor, postExecutionThread);
        this.postRepository = postRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return postRepository.posts();
    }
}
