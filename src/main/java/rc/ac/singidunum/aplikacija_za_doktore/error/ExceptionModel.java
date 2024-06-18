package rc.ac.singidunum.aplikacija_za_doktore.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionModel {

    private String message;
    private String name;
    private String path;
}
