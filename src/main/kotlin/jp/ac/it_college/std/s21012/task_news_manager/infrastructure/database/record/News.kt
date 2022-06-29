/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2022-06-28T17:09:18.412045472+09:00
 */
package jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record

import java.time.LocalDateTime

data class News(
    var id: Long? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDateTime? = null,
    var createAt: LocalDateTime? = null,
    var userId: Long? = null,
    var body: String? = null
)