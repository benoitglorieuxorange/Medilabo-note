package com.bgl.back_note.services;


import com.bgl.back_note.dto.ProcessRequestDto;
import com.bgl.back_note.dto.ProcessResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProcessClient {

    private final RestClient restClient;

    public ProcessClient(RestClient processRestClient) {
        this.restClient = processRestClient;
    }

    public ProcessResponseDto send(ProcessRequestDto body) {
        return restClient.post()
                .uri("/api/process")
                .body(body)
                .retrieve()
                .body(ProcessResponseDto.class);
    }
}