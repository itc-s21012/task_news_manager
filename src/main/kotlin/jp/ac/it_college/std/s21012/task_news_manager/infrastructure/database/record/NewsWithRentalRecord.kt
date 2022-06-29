package jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record

import java.sql.Timestamp


data class NewsWithRentalRecord(
    var id: Long? = null,
    var title: String? = null,
    var categoryId: String? = null,
    var createAt: Timestamp? = null,
    var publishAt: Timestamp? = null,
    var userId: Long? = null,
    var body: String? = null,
    var name: String? = null,
)
