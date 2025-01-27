package com.makers.princemaker.service

import com.makers.princemaker.code.PrinceMakerErrorCode
import com.makers.princemaker.constant.PrinceMakerConstant
import com.makers.princemaker.dto.CreatePrince
import com.makers.princemaker.entity.PrinceMock
import com.makers.princemaker.exception.PrinceMakerException
import com.makers.princemaker.repository.PrinceRepository
import com.makers.princemaker.repository.WoundedPrinceRepository
import com.makers.princemaker.type.PrinceLevel
import com.makers.princemaker.type.SkillType
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*

class PrinceMakerServiceKoTest : BehaviorSpec({

    val princeRepository: PrinceRepository = mockk()
    val woundedPriceRepository: WoundedPrinceRepository = mockk()
    val princeMakerService = PrinceMakerService(princeRepository, woundedPriceRepository)

    Given("프린스 생성을 진행할 때") {
        val request = CreatePrince.Request(
            PrinceLevel.JUNIOR_PRINCE,
            SkillType.INTELLECTUAL,
            3,
            "princeId",
            "name",
            28
        )
        val juniorPrince = PrinceMock.createPrince(
            PrinceLevel.JUNIOR_PRINCE,
            SkillType.INTELLECTUAL,
            PrinceMakerConstant.MAX_JUNIOR_EXPERIENCE_YEARS,
            "princeId"
        )
        every {
            princeRepository.save(any())
        } returns juniorPrince

        When("priceId가 중복되지않고 정상 요청이 오면") {
            every {
                princeRepository.findByPrinceId(any())
            } returns Optional.empty()

            val result = princeMakerService.createPrince(request)

            Then("정상 응답") {
                assertSoftly(result) {
                    princeLevel shouldBe PrinceLevel.JUNIOR_PRINCE
                    skillType shouldBe SkillType.INTELLECTUAL
                    experienceYears shouldBe 3
                }
            }
        }

        When("priceId가 중복되고 정상 요청이 오면") {

            every {
                princeRepository.findByPrinceId(any())
            } returns Optional.of(juniorPrince)

            val exception = shouldThrow<PrinceMakerException> {
                princeMakerService.createPrince(request)
            }

            Then("중복 오류 응답") {
                exception.princeMakerErrorCode shouldBe PrinceMakerErrorCode.DUPLICATED_PRINCE_ID
            }
        }
    }


})
