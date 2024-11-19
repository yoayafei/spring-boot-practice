package top.yyf.springboot.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = -2083020053831676155L;



    private String id ;
    private String name ;
    private Address address ;
}
