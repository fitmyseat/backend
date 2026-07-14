package com.fitmyseat.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitmyseat.seat.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}