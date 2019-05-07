package triarq.qore.pharmacy.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import triarq.qore.pharmacy.model.Pharmacy;

@Service
public interface PharmacyService {

	Page<Pharmacy> getAllPharmacyWithSearch(String searchtext, String sortby, Integer pagenumber, Integer size);

	Page<Pharmacy> getAllPharmacy(String sortby, Integer pagenumber, Integer size);

}
