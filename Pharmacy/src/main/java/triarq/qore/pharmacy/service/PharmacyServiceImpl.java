package triarq.qore.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import triarq.qore.pharmacy.model.Pharmacy;
import triarq.qore.pharmacy.repository.PharmacyRepository;

@Service
public class PharmacyServiceImpl implements PharmacyService
{

	@Autowired
	PharmacyRepository repo;
	
	@Override
	public Page<Pharmacy> getAllPharmacyWithSearch(String searchtext, String sortby, Integer pagenumber, Integer size) 
	{
		PageRequest pageable = PageRequest.of(pagenumber, size, Sort.by(sortby).ascending()) ;
		Page<Pharmacy> result=repo.findAllWithSearch(searchtext,pageable);
		return result;
	}

	@Override
	public Page<Pharmacy> getAllPharmacy(String sortby, Integer pagenumber, Integer size) 
	{
		PageRequest pageable = PageRequest.of(pagenumber, size, Sort.by(sortby).ascending()) ;
		Page<Pharmacy> result1 = repo.findAll(pageable);//findAll(pageable);
		return result1;
	}

}
