package th.co.pchome.store_j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import th.co.pchome.store_j.entity.ThSellerMain;

@Repository
public interface ThSellerMainDao extends JpaRepository<ThSellerMain,Long>,JpaSpecificationExecutor<ThSellerMain>{

}
