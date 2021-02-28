package br.com.tiagocruz.ioasyschallenge.domain.vos;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("UserRequest")
public class UserRequestVo implements Serializable {

	private static final long serialVersionUID = 4881022215393231658L;

	@NotBlank
	@ApiModelProperty(value = "The userName chosen by user", required = true)
	private String userName;

	@NotNull
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

	public void setIsAdmin(final Boolean admin) {

		isAdmin = admin;
	}

	@Override
	public boolean equals(final Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final UserRequestVo that = (UserRequestVo) o;
		return userName.equals(that.userName) && isAdmin.equals(that.isAdmin);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userName, isAdmin);
	}
}
