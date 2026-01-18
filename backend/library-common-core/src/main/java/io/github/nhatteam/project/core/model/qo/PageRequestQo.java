package io.github.nhatteam.project.core.model.qo;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public record PageRequestQo(

        @PositiveOrZero(message = "must be a number greater than or equal to 0")
        Integer page,

        @Positive(message = "must be a number greater than 0")
        Integer size,

        List<SortRequestQo> sorts
) {

}
