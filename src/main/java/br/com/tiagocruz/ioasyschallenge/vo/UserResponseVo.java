package br.com.tiagocruz.ioasyschallenge.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("UserResponse")
public class UserResponseVo {

	@ApiModelProperty("The userName chosen by user")
	private final String userName;

	@ApiModelProperty("Indicate if user is an administrator")
	private final Boolean isAdmin;

	public UserResponseVo(final String userName, final Boolean isAdmin) {

		this.userName = userName;
		this.isAdmin = isAdmin;
	}

	public String getUserName() {

		return userName;
	}

	public Boolean getIsAdmin() {

		return isAdmin;
	}
}
