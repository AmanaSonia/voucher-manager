package com.bracit.vouchermanager.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestMetaData {

    @NotNull
    private String rootUrl;

    @NotNull
    private String apiEndPoint;

    private String finKey;

    private String apiToken;


}
