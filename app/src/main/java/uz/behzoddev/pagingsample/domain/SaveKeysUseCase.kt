package uz.behzoddev.pagingsample.domain

import uz.behzoddev.pagingsample.data.models.RedditKeys
import uz.behzoddev.pagingsample.data.repositories.RedditRepo
import uz.behzoddev.pagingsample.di.BindModules.RepositoryBinds
import javax.inject.Inject

class SaveKeysUseCase @Inject constructor(
    @RepositoryBinds private val redditRepo: RedditRepo
) {
    suspend operator fun invoke(redditKeys: RedditKeys): Long {
        return redditRepo.saveKeys(redditKeys)
    }
}