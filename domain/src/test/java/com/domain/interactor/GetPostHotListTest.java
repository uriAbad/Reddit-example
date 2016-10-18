package com.domain.interactor;

import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.PostRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Uri Abad on 18/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class GetPostHotListTest {

    public GetPostHotList getPostHotList;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private PostRepository mockPostRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        getPostHotList = new GetPostHotList(mockThreadExecutor,mockPostExecutionThread,
                mockPostRepository);
    }

    @Test
    public void testGetPostListUseCaseObservableHappyCase(){
        getPostHotList.buildUseCaseObservable();

        verify(mockPostRepository).postsHot();
        verifyNoMoreInteractions(mockPostRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }

}
