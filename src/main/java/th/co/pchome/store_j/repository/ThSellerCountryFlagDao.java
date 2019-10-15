package th.co.pchome.store_j.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.co.pchome.store_j.entity.ThSellerCountryFlagLog;

@Repository
public interface ThSellerCountryFlagDao extends JpaRepository<ThSellerCountryFlagLog, Long>,JpaSpecificationExecutor<ThSellerCountryFlagLog> {

	@Query(value = "SELECT * FROM TH_SELLER_COUNTRYFLAG_LOG ORDER BY UPDATE_DATE DESC", nativeQuery = true)
	public List<ThSellerCountryFlagLog> findAll();
	
	@Query(value = "SELECT * FROM TH_SELLER_COUNTRYFLAG_LOG WHERE SM_ID=:smId", nativeQuery = true)
	public ThSellerCountryFlagLog findBySmId(@Param(value="smId")String smId);
}
