package com.bgl.back_note.dto;

import com.bgl.back_note.enums.RiskState;

public record ProcessResponseDto(
        RiskState riskState
) {}
