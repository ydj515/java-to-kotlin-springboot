package com.makers.princemaker.controller;

import com.makers.princemaker.dto.CreatePrince;
import com.makers.princemaker.dto.EditPrince;
import com.makers.princemaker.dto.PrinceDetailDto;
import com.makers.princemaker.dto.PrinceDto;
import com.makers.princemaker.service.PrinceMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/princes")
public class PrinceMakerController {
    private final PrinceMakerService princeMakerService;

    @PostMapping("")
    public CreatePrince.Response createPrince(@Valid @RequestBody CreatePrince.Request request) {
        return princeMakerService.createPrince(request);
    }

    @GetMapping("")
    public List<PrinceDto> getPrinces() {
        return princeMakerService.getAllPrince();
    }

    @GetMapping("/{princeId}")
    public PrinceDetailDto getPrince(@PathVariable String princeId) {
        return princeMakerService.getPrince(princeId);
    }

    @PutMapping("/{princeId}")
    public PrinceDetailDto updatePrince(@PathVariable String princeId, @Valid @RequestBody EditPrince.Request request) {
        return princeMakerService.editPrince(princeId, request);
    }

    @DeleteMapping("/{princeId}")
    public PrinceDetailDto deletePrince(@PathVariable String princeId) {
        return princeMakerService.woundPrince(princeId);
    }
}
