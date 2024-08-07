package com.app.test.src.dependency

import com.app.test.src.data.repository.IUserRepository
import com.app.test.src.data.repository.UserRepository
import com.app.test.src.domain.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(): IUserRepository {
        return UserRepository()
    }

    @Provides
    @Singleton
    fun provideUsersUseCase(userRepository: IUserRepository): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }


}