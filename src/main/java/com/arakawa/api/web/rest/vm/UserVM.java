package com.arakawa.api.web.rest.vm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@ApiModel(description = "ユーザー情報")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVM {

    /** ユーザーID. */
    @ApiModelProperty(value="ユーザーID", required = true, position = 1)
    @NotNull
    private Long userId;
}
