/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2022-06-28T17:09:18.398833737+09:00
 */
package jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object CategoryDynamicSqlSupport {
    val category = Category()

    val id = category.id

    val name = category.name

    class Category : AliasableSqlTable<Category>("category", ::Category) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)
    }

}