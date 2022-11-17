package lk.carrental.carrental.advisor;


import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST )
    @ExceptionHandler({Exception.class})
    public ResponseUtil exceptionHandler(Exception e) {
        return new ResponseUtil(500, e.getMessage(), null);
    }

}
