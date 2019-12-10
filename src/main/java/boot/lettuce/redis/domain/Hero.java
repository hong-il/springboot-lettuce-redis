package boot.lettuce.redis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class Hero implements Serializable {

    /**How to create a serialVersionUID
     * 1. setting > Editor > code Style > Inspections > Serialization issues >
     *    Serializable class without 'serialVersionUID'[check]
     * 2. class Hero > alt + enter > add 'serialVersionUID'
     * */
    private static final long serialVersionUID = -2978210945555843891L;
    private String id;
    private String name;

    @Builder
    public Hero(String id, String name) {
        this.id = id;
        this.name = name;
    }
}