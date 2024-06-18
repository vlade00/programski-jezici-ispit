package rc.ac.singidunum.aplikacija_za_doktore.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    //Sa ovim sakrivamo sve podatke u tabeli
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleDataIntegrity(DataIntegrityViolationException e, HttpServletRequest request){
        ExceptionModel model = new ExceptionModel();
        model.setName(e.getClass().getSimpleName());
        model.setMessage("Data intregrity was breached");
        model.setPath(request.getServletPath());
        return model;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleException(Exception e, HttpServletRequest request){
        ExceptionModel model = new ExceptionModel();
        model.setName(e.getClass().getSimpleName());
        model.setMessage(e.getMessage());
        model.setPath(request.getServletPath());
        return model;
    }
}
