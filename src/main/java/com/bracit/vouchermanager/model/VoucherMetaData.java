package com.bracit.vouchermanager.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.http.HttpHeaders;


@Data
@Builder
public class VoucherMetaData {

    @NotNull
    private String rootUrl;

    @NotNull
    private String apiEndPoint;

    @NotNull
    private String finKey;

    @NotNull
    private String apiToken;

    @NotNull
    private HttpHeaders httpHeaders;
}
