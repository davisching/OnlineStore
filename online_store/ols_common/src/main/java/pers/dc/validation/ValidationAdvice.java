package pers.dc.validation;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.dc.util.JsonResult;

@RestControllerAdvice
public class ValidationAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult validExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder msg = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(
                error -> msg.append(error.getDefaultMessage()).append("; "));
        return JsonResult.errorMsg(msg.toString());
    }
}
