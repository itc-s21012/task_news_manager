package jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.category
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.id
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.userId
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record.News
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record.NewsWithRentalRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
//import org.mybatis.dynamic.sql.SqlBuilder.equalTo
//import org.mybatis.dynamic.sql.SqlBuilder.on
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.model.select
//import java.util.Date.from

@Mapper
interface NewsWithCategoryMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "NewsWithRentalRecordResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "body", property = "body", jdbcType = JdbcType.LONGVARCHAR),
            Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.BIGINT),
            Result(column = "publish_at", property = "publishAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<NewsWithRentalRecord>
}
private val columnList = listOf(id, title, body, categoryId, publishAt,createAt,userId)

fun NewsWithCategoryMapper.select(completer: SelectCompleter): List<NewsWithRentalRecord> =
    select(columnList) {
        from(news, "n")
        leftJoin(category){
            on(news.id) equalTo category.id
        }
        completer()
    }.run(this::selectMany)

fun NewsWithCategoryMapper.selectByPrimaryKey(id_: Long): NewsWithRentalRecord? = select(columnList) {
    from(news, "n")
    leftJoin(category, "c") {
        on(news.id) equalTo category.id
    }
    where {
        id isEqualTo id_
    }
}.run ( this::selectOne)