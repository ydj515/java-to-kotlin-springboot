package com.makers.princemaker.dto

import com.makers.princemaker.entity.Prince
import com.makers.princemaker.type.PrinceLevel
import com.makers.princemaker.type.SkillType
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class CreatePrince {

    data class Request(
        // @@Valid에 어노테이션 적용 타겟(Annotation use-site target) 사용 필요
        @field:NotNull
        val princeLevel: PrinceLevel? = null,
        @field:NotNull
        val skillType: SkillType? = null,
        @field:NotNull @field:Min(0)
        val experienceYears: Int? = null,
        @field:NotNull @field:Size(min = 3, max = 50, message = "invalid princeId")
        val princeId: String? = null,
        @field:NotNull @field:Size(min = 2, max = 50, message = "invalid name")
        val name: String? = null,
        @field:NotNull @field:Min(18)
        val age: Int? = null,
    )

    class Response(
        val princeLevel: PrinceLevel? = null,
        val skillType: SkillType? = null,
        val experienceYears: Int? = null,
        val princeId: String? = null,
        val name: String? = null,
        val age: Int? = null,
    ) {

        companion object {
            @JvmStatic
            fun fromEntity(prince: Prince): Response {
                return Response(
                    princeLevel = prince.princeLevel,
                    skillType = prince.skillType,
                    experienceYears = prince.experienceYears,
                    princeId = prince.princeId,
                    name = prince.name,
                    age = prince.age,
                )
            }
        }
    }
}
