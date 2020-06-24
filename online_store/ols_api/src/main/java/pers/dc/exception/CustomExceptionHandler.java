package pers.dc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import pers.dc.util.JsonResult;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public JsonResult handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        return JsonResult.errorMsg("文件大小需要小于：1MB");
    }
}
