package com.makers.princemaker.controller

import com.makers.princemaker.dto.CreatePrince
import com.makers.princemaker.dto.EditPrince
import com.makers.princemaker.dto.PrinceDetailDto
import com.makers.princemaker.dto.PrinceDto
import com.makers.princemaker.service.PrinceMakerService
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/princes")
class PrinceMakerController(
    val princeMakerService: PrinceMakerService,
) {

    @PostMapping("")
    fun createPrince(@Valid @RequestBody request: CreatePrince.Request): CreatePrince.Response {
        return princeMakerService.createPrince(request)
    }

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
