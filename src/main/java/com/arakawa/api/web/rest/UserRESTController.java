package com.arakawa.api.web.rest;

import com.arakawa.api.service.UserService;
import com.arakawa.api.web.rest.utils.ResourceNotFoundException;
import com.arakawa.api.web.rest.vm.UserVM;
import com.arakawa.api.web.rest.vm.mapstruct.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for ec user.
 */
@Api(tags = "User",  value = "ユーザー情報の操作")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class UserRESTController {

    @NonNull
    private UserService userService;

    /**
     * ユーザー情報の取得
     *
     * @param userId
     * @return
     * @throws ResourceNotFoundException
     */
    @ApiOperation(
            value = "ユーザー情報を取得します",
            notes = "ユーザー情報を取得します会員情報を返します"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "登録した会員情報", response = UserVM.class),
            @ApiResponse(code = 400, message = "リクエストに必須の項目が不足、または不正な値を指定している"),
            @ApiResponse(code = 401, message = "認証エラー"),
            @ApiResponse(code = 404, message = "リソースが存在しない"),
            @ApiResponse(code = 409, message = "指定した識別子が、既存の識別子と重複している"),
            @ApiResponse(code = 500, message = "予期しないエラー")
    })
    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserVM> findById(@PathVariable("userId") Long userId) throws ResourceNotFoundException {
        return ResponseEntity.ok(
                UserMapper.INSTANCE.toUserVM(
                        userService.findById(userId).orElseThrow(
                                () -> new ResourceNotFoundException()
                        )
                )
        );
    }
}
