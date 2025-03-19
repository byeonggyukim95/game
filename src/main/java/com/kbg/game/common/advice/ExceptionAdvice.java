package com.kbg.game.common.advice;

import com.kbg.game.model.CommonResponse;
import com.kbg.game.transfer.telegram.TelegramTransfer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    private HttpServletRequest request;
    private TelegramTransfer telegramTransfer;

    @Autowired
    public ExceptionAdvice(HttpServletRequest request
            , TelegramTransfer telegramTransfer) {
        this.request = request;
        this.telegramTransfer = telegramTransfer;
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

        return ResponseEntity.internalServerError().body(new CommonResponse("500", exception.getMessage(), null));
    }

}
