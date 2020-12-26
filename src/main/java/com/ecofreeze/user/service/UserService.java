package com.ecofreeze.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecofreeze.user.entity.User;
import com.ecofreeze.user.repository.UserRepository;

import VO.Department;
import VO.ResponseTemplateVO;

@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside User Service Save User");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside User Service Save User");

		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);

		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}

}
