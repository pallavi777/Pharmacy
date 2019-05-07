package triarq.qore.pharmacy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import triarq.qore.pharmacy.model.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long>
{

	Pharmacy findBypharmacyid(Long pharmacyid);
	
	@Query(value = "SELECT * FROM pharmacy "
			+ "where LOWER(sname) || LOWER(scity) || LOWER(sstate) || LOWER(szip) || LOWER(saddressline1) "+ "like %?1%",
			countQuery = "SELECT count(pharmacyid) FROM pharmacy WHERE LOWER(sname) || LOWER(scity) || LOWER(sstate) || LOWER(szip) || LOWER(saddressline1) like %?1%",
			nativeQuery = true)
	Page<Pharmacy> findAllWithSearch(String searchtext, PageRequest pageable);
	
	
	@Query(value = "SELECT * FROM pharmacy ",
			countQuery = "SELECT count(pharmacyid) FROM pharmacy",
			nativeQuery = true)
	Page<Pharmacy> findAll(Pageable pageable);

}
