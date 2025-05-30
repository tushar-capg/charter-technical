package com.reward.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reward.application.entity.PurchaseDetailsEntity;
import com.reward.application.model.PurchaseDAO;
/**
 * Repository for Purchase Details entity.
 * Provides CRUD operations and custom queries.
 */
@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseDetailsEntity, Long>{
	/**
     * Retrieves a list of all Purchase details by joining customer and purchase details tables.
     *
     * @return List of Purchase details object.
     */
	@Query(value = "select cd.customer_id as custId, "
			+ "cd.customer_name as customerName, "
			+ "pd.PURCHASE_ID as purchaseId, "
			+ "pd.PRODUCT_NAME as productName, "
			+ "pd.PRODUCT_AMOUNT as productAmount, " 
			+ "pd.CREATED_DATE as createdDt "
			+ "from CUSTOMER_DETAILS cd inner join PURCHASE_DETAILS pd on cd.CUSTOMER_ID = pd.CUSTOMER_ID "
			+ "where cd.CUSTOMER_ID = :customerId AND pd.CREATED_DATE >= DATEADD('MONTH', -3, CURRENT_DATE);", nativeQuery = true)
	Optional<List<PurchaseDAO>> findAllRewardDetailsByCustId(@Param("customerId") Long customerId);
	
	@Query(value = "select cd.customer_id as custId, "
			+ "cd.customer_name as customerName, "
			+ "pd.PURCHASE_ID as purchaseId, "
			+ "pd.PRODUCT_NAME as productName, "
			+ "pd.PRODUCT_AMOUNT as productAmount, " 
			+ "pd.CREATED_DATE as createdDt "
			+ "from CUSTOMER_DETAILS cd inner join PURCHASE_DETAILS pd on cd.CUSTOMER_ID = pd.CUSTOMER_ID "
			+ "where pd.CREATED_DATE >= DATEADD('MONTH', -3, CURRENT_DATE);", nativeQuery = true)
	Optional<List<PurchaseDAO>> findAllRewardDetails();
}
