package com.example.ourdiary.admin.configuration;

import com.example.ourdiary.admin.api.user.dto.UserAutocompleteResponse;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Class for handling data binding such as RequestBody, PathVariable, RequestParam
 * RequestBody, PathVariable, RequestParam 등의 데이터 바인딩을 처리하는 클래스
 */
@ControllerAdvice
public class GlobalDataBindingConfiguration {

    /**
     * convert empty string to null or trim string
     * 빈 문자열을 null로 변환하거나 문자열을 trim
     * @param dataBinder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}