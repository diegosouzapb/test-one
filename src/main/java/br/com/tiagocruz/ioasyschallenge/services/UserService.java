package br.com.tiagocruz.ioasyschallenge.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiagocruz.ioasyschallenge.domain.entities.UserEntity;
import br.com.tiagocruz.ioasyschallenge.domain.vos.UserRequestVo;
import br.com.tiagocruz.ioasyschallenge.domain.vos.UserResponseVo;
import br.com.tiagocruz.ioasyschallenge.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ModelMapper mapper;

	@Autowired
	public UserService(final UserRepository userRepository, final ModelMapper mapper) {

		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	public UserResponseVo createUser(final UserRequestVo userRequestVo) {

		final UserEntity userEntity = mapper.map(userRequestVo, UserEntity.class);

		final UserEntity savedUserEntity = userRepository.save(userEntity);

		return mapper.map(savedUserEntity, UserResponseVo.class);
	}
}
