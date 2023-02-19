package myfirst.javaspringbootdemo.repository;

import myfirst.javaspringbootdemo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//we need interface in order to use data-jpa
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
