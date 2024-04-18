package com.myspringmysql.springsql.util;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorHandler {
   private String message;

}
