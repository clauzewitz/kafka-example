package com.clauzewitz.kafkaexample.prop;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo.cheif")
@RequiredArgsConstructor
@Getter
@Setter
public class CheifProperties {

    private String topic;

}
