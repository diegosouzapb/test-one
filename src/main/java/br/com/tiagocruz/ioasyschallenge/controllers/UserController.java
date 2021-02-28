package br.com.tiagocruz.ioasyschallenge.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiagocruz.ioasyschallenge.domain.vos.UserRequestVo;
import br.com.tiagocruz.ioasyschallenge.domain.vos.UserResponseVo;
import br.com.tiagocruz.ioasyschallenge.helpers.constants.ApiConstants;
import br.com.tiagocruz.ioasyschallenge.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api("Users API")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value = "User Creation", notes = "Create an specific User")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = ApiConstants.HTTP_OK),
			@ApiResponse(code = 202, message = ApiConstants.HTTP_ACCEPT_MESSAGE),
			@ApiResponse(code = 400, message = ApiConstants.HTTP_BAD_REQUEST_MESSAGE),
			@ApiResponse(code = 409, message = ApiConstants.HTTP_CONFLICT),
			@ApiResponse(code = 403, message = ApiConstants.HTTP_FORBIDDEN_MESSAGE),
			@ApiResponse(code = 405, message = ApiConstants.HTTP_METHOD_NOT_ALLOWED_MESSAGE),
			@ApiResponse(code = 500, message = ApiConstants.HTTP_INTERNAL_SERVER_ERROR_MESSAGE) })
	@PostMapping
	public ResponseEntity<UserResponseVo> create(@Valid @RequestBody final UserRequestVo userRequestVo) {

		LOGGER.info("PUT /users - UserName: {}", userRequestVo.getUserName());

		final UserResponseVo userResponseVo = userService.createUser(userRequestVo);

		return ResponseEntity.ok(userResponseVo);
	}

	@ApiOperation(value = "User Update", notes = "Update an specific User")
	@ApiResponses(value = { @ApiResponse(code = 202, message = ApiConstants.HTTP_ACCEPT_MESSAGE),
			@ApiResponse(code = 400, message = ApiConstants.HTTP_BAD_REQUEST_MESSAGE),
			@ApiResponse(code = 403, message = ApiConstants.HTTP_FORBIDDEN_MESSAGE),
			@ApiResponse(code = 405, message = ApiConstants.HTTP_METHOD_NOT_ALLOWED_MESSAGE),
			@ApiResponse(code = 500, message = ApiConstants.HTTP_INTERNAL_SERVER_ERROR_MESSAGE) })
	@PutMapping
	public ResponseEntity<UserResponseVo> update() {

		LOGGER.info("PUT /users - UserName: {}", "user-2");

		return ResponseEntity.ok(new UserResponseVo());
	}

	@ApiOperation(value = "User Deletion", notes = "Delete an specific User")
	@ApiResponses(value = { @ApiResponse(code = 202, message = ApiConstants.HTTP_ACCEPT_MESSAGE),
			@ApiResponse(code = 400, message = ApiConstants.HTTP_BAD_REQUEST_MESSAGE),
			@ApiResponse(code = 403, message = ApiConstants.HTTP_FORBIDDEN_MESSAGE),
			@ApiResponse(code = 405, message = ApiConstants.HTTP_METHOD_NOT_ALLOWED_MESSAGE),
			@ApiResponse(code = 500, message = ApiConstants.HTTP_INTERNAL_SERVER_ERROR_MESSAGE) })
	@DeleteMapping("/{userName}")
	public ResponseEntity<Void> delete(@ApiParam(value = "userName", required = true) @PathVariable final String userName) {

		LOGGER.info("DELETE /users/{}", userName);

		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "User List", notes = "Get a list of active Users")
	@ApiResponses(value = { @ApiResponse(code = 204, message = ApiConstants.HTTP_NO_CONTENT),
			@ApiResponse(code = 400, message = ApiConstants.HTTP_BAD_REQUEST_MESSAGE),
			@ApiResponse(code = 403, message = ApiConstants.HTTP_FORBIDDEN_MESSAGE),
			@ApiResponse(code = 405, message = ApiConstants.HTTP_METHOD_NOT_ALLOWED_MESSAGE),
			@ApiResponse(code = 500, message = ApiConstants.HTTP_INTERNAL_SERVER_ERROR_MESSAGE) })
	@GetMapping
	public ResponseEntity<List<UserResponseVo>> get() {

		LOGGER.info("GET /users - UserNames: {}", "2");

		return ResponseEntity.ok(Arrays.asList(new UserResponseVo(), new UserResponseVo()));
	}
}
