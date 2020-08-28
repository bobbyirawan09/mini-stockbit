package bobby.irawan.domain.interactor.movielist

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import bobby.irawan.domain.factory.movies.MoviesFactory
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMovieListUseCaseTest {

    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var threadExecutor: ThreadExecutor

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    lateinit var getMovieListUseCase: GetMovieListUseCase

    @Before
    fun setUp() {
        getMovieListUseCase =
            GetMovieListUseCase(repository, threadExecutor, postExecutionThread)
    }

    @Test
    fun buildUseCaseObservable_call_repository() {
        // Arrange
        // No Arrangement for this test case

        // Act
        getMovieListUseCase.buildUseCaseObservable(null)

        // Assert
        verify(repository).getPopularMovies()
    }

    @Test
    fun buildUseCaseObservable_completes() {
        // Arrange
        stubMovieRepositoryGetMoviesList(Single.just(MoviesFactory.generateDummyMovieList(3)))

        // Act
        val testObserver = getMovieListUseCase.buildUseCaseObservable(null).test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseObservable_returnsData() {
        // Arrange
        val movieList = MoviesFactory.generateDummyMovieList(4)
        stubMovieRepositoryGetMoviesList(Single.just(movieList))

        // Act
        val testObserver = getMovieListUseCase.buildUseCaseObservable(null).test()

        // Assert
        testObserver.assertValue(movieList)
    }

    private fun stubMovieRepositoryGetMoviesList(single: Single<List<Movie>>) {
        `when`(repository.getPopularMovies())
            .thenReturn(single)
    }
}
