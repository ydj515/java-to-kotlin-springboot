package com.makers.princemaker.controller

import com.makers.princemaker.dto.EditPrince
import com.makers.princemaker.dto.PrinceDetailDto
import com.makers.princemaker.dto.PrinceDto
import com.makers.princemaker.service.PrinceMakerService
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/princes")
class PrinceMakerController(
    val princeMakerService: PrinceMakerService,
) {


    @GetMapping("")
    fun getPrices(): List<PrinceDto> {
        return princeMakerService.getPrinces()
    }

    @GetMapping("/{princeId}")
    fun getPrince(@PathVariable princeId: String?): PrinceDetailDto {
        return princeMakerService.getPrince(princeId)
    }

    @PutMapping("/{princeId}")
    fun updatePrince(
        @PathVariable princeId: String?,
        @Valid @RequestBody request: EditPrince.Request
    ): PrinceDetailDto {
        return princeMakerService.editPrince(princeId, request)
    }

    @DeleteMapping("/{princeId}")
    fun deletePrince(@PathVariable princeId: String?): PrinceDetailDto {
        return princeMakerService.woundPrince(princeId)
    }
}
