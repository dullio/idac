package br.com.va4e.idac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.va4e.idac.entity.MemberPhone;

@Repository
public interface MemberPhoneRepository extends JpaRepository<MemberPhone,Long>{

}