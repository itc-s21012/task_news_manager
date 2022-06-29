/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2022-06-28T17:09:18.413031417+09:00
 */
package jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record

import jp.ac.it_college.std.s21012.task_news_manager.domain.enum.RoleType

data class Users(
    var id: Long? = null,
    var username: String? = null,
    var password: String? = null,
    var viewName: String? = null,
    var roleType: RoleType? = null
)