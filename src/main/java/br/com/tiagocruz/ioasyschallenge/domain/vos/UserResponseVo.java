package br.com.tiagocruz.ioasyschallenge.domain.vos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("UserResponse")
public class UserResponseVo {

	@ApiModelProperty("The userName chosen by user")
	private String userName;

	@ApiModelProperty("Indicate if user is an administrator")
	private Boolean isAdmin;

	public String getUserName() {

		return userName;
	}

	public void setUserName(final String userName) {

		this.userName = userName;
	}

	public Boolean getIsAdmin() {

		return isAdmin;
	}

	public void setIsAdmin(final Boolean isAdmin) {

		this.isAdmin = isAdmin;
	}
}
