package br.com.tiagocruz.ioasyschallenge.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.tiagocruz.ioasyschallenge.vo.UserRequestVo;
import br.com.tiagocruz.ioasyschallenge.vo.UserResponseVo;

@Service
public class UserService {

	public Optional<UserResponseVo> createUser(final UserRequestVo userRequestVo) {

		return Optional.of(new UserResponseVo(userRequestVo.getUserName(), userRequestVo.getIsAdmin()));
	}
}
