package com.kbg.game.common.advice;

import com.kbg.game.common.enums.ExceptionCode;
import com.kbg.game.model.CommonResponse;
import com.kbg.game.transfer.telegram.TelegramTransfer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    private HttpServletRequest request;
    private TelegramTransfer telegramTransfer;
    private MessageSource messageSource;

    @Autowired
    public ExceptionAdvice(HttpServletRequest request
            , TelegramTransfer telegramTransfer
            , MessageSource messageSource) {
        this.request = request;
        this.telegramTransfer = telegramTransfer;
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<CommonResponse> exceptionHandler(Exception exception) throws Exception {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);

        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("\n");
        errorMessage.append("Domain: ").append(request.getServerName()).append("\n");
        errorMessage.append("URL   : ").append((String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE)).append("\n");
        errorMessage.append("MSG   : ").append(exception.getMessage().isEmpty() ? exception.toString() : exception.getMessage()).append("\n");
        errorMessage.append("StackTrace   : ").append(sw).append("\n");

        telegramTransfer.sendMessage(errorMessage.toString());


        return ResponseEntity.internalServerError().body(new CommonResponse(ExceptionCode.INTERNAL_SERVER_ERROR.getCode(), this.getMessageSource(ExceptionCode.INTERNAL_SERVER_ERROR.getMessage()), null));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        FieldError fieldError = ex.getBindingResult()
                .getFieldErrors()
                .stream().findFirst().get();

        return new ResponseEntity<>(new CommonResponse(String.valueOf(status.value()), this.getMessageSource(fieldError.getDefaultMessage()), null), new HttpHeaders(), status);
    }

    private String getMessageSource(String message) {
        return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    }

}
