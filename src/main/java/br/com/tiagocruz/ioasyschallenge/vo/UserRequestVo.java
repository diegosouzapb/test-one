package br.com.tiagocruz.ioasyschallenge.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("UserRequest")
public class UserRequestVo implements Serializable {

	private static final long serialVersionUID = 4881022215393231658L;

	@NotBlank
	@ApiModelProperty(value = "The userName chosen by user", required = true)
	private final String userName;

	@NotNull
	@ApiModelProperty("Indicate if user is an administrator")
	private final Boolean isAdmin;

	@JsonCreator
	public UserRequestVo(@JsonProperty("userName") final String userName, @JsonProperty("isAdmin") final Boolean isAdmin) {

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
