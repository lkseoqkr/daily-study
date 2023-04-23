package jp.co.study.gsconsumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // any properties not bound in this type should be ignored.
public record Quote(String type, Value value) { }
