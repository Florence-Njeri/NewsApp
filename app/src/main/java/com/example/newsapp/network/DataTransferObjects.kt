/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.newsapp.network

import com.example.newsapp.data.Article
import com.example.newsapp.data.DatabaseArticle
import com.example.newsapp.data.NetworkArticle
import com.squareup.moshi.JsonClass

/**
 * DataTransferObjects go in this file. These are responsible for parsing responses from the server
 * or formatting objects to send to the server. You should convert these to domain objects before
 * using them.
 */

/**
 * VideoHolder holds a list of Videos.
 *
 * This is to parse first level of our network result which looks like
 *
 * {
 *   "videos": []
 * }
 */
@JsonClass(generateAdapter = true)
data class NetworkArticleContainer(val articles: List<NetworkArticle>)

/**
 * Videos represent a devbyte that can be played.
 */


/**
 * Convert Network results to domain objects
 */
fun NetworkArticleContainer.asDomainModel(): List<Article> {
    return articles.map {
        Article(
            url = it.url,
            title = it.title,
            description = it.description,
            author = it.author,
            publishedAt = it.publishedAt,
            urlToImage = it.urlToImage
        )
    }
}

/**
 * Convert Network results to database objects
 */
fun NetworkArticleContainer.asDatabaseModel(): Array<DatabaseArticle> {
    return articles.map {
        DatabaseArticle(
            title = it.title,
            description = it.description,
            url = it.url,
            author = it.author,
            publishedAt = it.publishedAt,
            urlToImage = it.urlToImage
        )
    }.toTypedArray()
}
