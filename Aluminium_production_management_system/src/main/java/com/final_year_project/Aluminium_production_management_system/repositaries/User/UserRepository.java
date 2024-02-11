package com.final_year_project.Aluminium_production_management_system.repositaries.User;

import com.final_year_project.Aluminium_production_management_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,String> {



}
