package bobby.irawan.domain.factory.movies

import bobby.irawan.domain.factory.DataFactory

object MoviesFactory {

    fun generateDummyMovieList(size: Int): List<Movie> {
        val movieList = mutableListOf<Movie>()
        repeat(size) {
            movieList.add(generateMovie())
        }
        return movieList
    }

    fun generateMovie(): Movie {
        return Movie(
            adult = DataFactory.getRandomBoolean(),
            isBookMarked = DataFactory.getRandomBoolean(),
            id = DataFactory.getRandomLong(),
            name = DataFactory.getRandomString(),
            title = DataFactory.getRandomString(),
            voteAverage = DataFactory.getRandomDouble(),
            profilePath = DataFactory.getRandomString(),
            posterPath = DataFactory.getRandomString(),
            popularity = DataFactory.getRandomDouble(),
            backdropPath = DataFactory.getRandomString(),
            firstAirDate = DataFactory.getRandomString(),
            genreIds = listOf(
                DataFactory.getRandomInt(),
                DataFactory.getRandomInt()
            ),
            knownForDepartment = DataFactory.getRandomString(),
            originalLanguage = DataFactory.getRandomString(),
            originalTitle = DataFactory.getRandomString(),
            overview = DataFactory.getRandomString(),
            releaseDate = DataFactory.getRandomString(),
            video = DataFactory.getRandomBoolean(),
            voteCount = DataFactory.getRandomInt()
        )
    }
}
