package com.makers.princemaker.entity

import com.makers.princemaker.code.StatusCode
import com.makers.princemaker.type.PrinceLevel
import com.makers.princemaker.type.SkillType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "prince")
class Prince(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Enumerated(EnumType.STRING)
    var princeLevel: PrinceLevel,

    @Enumerated(EnumType.STRING)
    var skillType: SkillType,

    @Enumerated(EnumType.STRING)
    var status: StatusCode? = null,
    var experienceYears: Int? = null,
    val princeId: String,
    var name: String,
    var age: Int,

    @CreatedDate
    val createdAt: LocalDateTime? = null,

    @LastModifiedDate
    val updatedAt: LocalDateTime? = null,
)