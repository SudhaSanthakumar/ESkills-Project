package com.example.wsec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wsec.model.Message;
import com.example.wsec.model.User;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	

}
