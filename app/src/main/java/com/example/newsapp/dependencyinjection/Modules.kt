package com.example.newsapp.dependencyinjection

import com.example.newsapp.database.NewsDatabase
import org.koin.dsl.module

/**
 * A module is a central place where you can tell the framework how to create new instances of a dependency.

 */
class Modules {
    val databaseModule= module(override = true) {
//        single<NewsDatabase> { provideMovieRepository(get()) }
    }
}