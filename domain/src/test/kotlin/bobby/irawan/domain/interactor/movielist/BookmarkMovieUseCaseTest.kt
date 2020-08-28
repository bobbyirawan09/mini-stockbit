package bobby.irawan.domain.interactor.movielist

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkMovieUseCaseTest {

    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var threadExecutor: ThreadExecutor

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    lateinit var bookmarkMovieUseCase: BookmarkMovieUseCase

    @Before
    fun setUp() {
        bookmarkMovieUseCase =
            BookmarkMovieUseCase(repository, threadExecutor, postExecutionThread)
    }

    @Test
    fun buildUseCaseObservable_callRepository() {
        // Arrange
        // No Arrangement for this test case

        // Act
        bookmarkMovieUseCase.buildUseCaseObservable(2)

        // Assert
        verify(repository).bookmarkMovie(2)
    }

    @Test
    fun buildUseCaseObservable_completes() {
        // Arrange
        val movieId = 3L
        stubMovieRepositoryBookmarkMovie(movieId, Completable.complete())

        // Act
        val test = repository.bookmarkMovie(movieId).test()

        // Assert
        test.assertComplete()
    }

    private fun stubMovieRepositoryBookmarkMovie(movieId: Long, completable: Completable) {
        `when`(repository.bookmarkMovie(movieId))
            .thenReturn(completable)
    }
}
