package io.github.vinicus1001.Zero20.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@NoArgsConstructor
public class ApiErros {

    private List<String> erros;

    public ApiErros (List<String> erros){
        this.erros = erros;
    }


    public  ApiErros(String s){
        this.erros = Arrays.asList(s);
    }

}
