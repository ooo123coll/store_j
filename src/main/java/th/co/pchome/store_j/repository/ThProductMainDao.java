package th.co.pchome.store_j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.co.pchome.store_j.entity.ThProductMain;

@Repository
public interface ThProductMainDao extends JpaRepository<ThProductMain, Long> {

	@Query(value = "select count(*) from TH_PRODUCT_MAIN WHERE SM_ID =:smId ", nativeQuery = true)
	public Integer countBySmId(@Param("smId") String smId);

}
