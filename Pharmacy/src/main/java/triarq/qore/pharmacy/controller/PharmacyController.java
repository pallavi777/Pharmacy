package triarq.qore.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import triarq.qore.pharmacy.model.Pharmacy;
import triarq.qore.pharmacy.repository.PharmacyRepository;
import triarq.qore.pharmacy.service.PharmacyService;

@Controller
@RequestMapping("/pharmacy")
public class PharmacyController
{
	 @Autowired
	 PharmacyRepository repo;
	 
	 @Autowired
	 PharmacyService service;
	 
	 
		@GetMapping("")
		public ResponseEntity<Page<Pharmacy>> getAll(@RequestParam(name = "searchtext", required = false) String searchtext,
				@RequestParam(name = "sortby",defaultValue = "pharmacyid", required = false) String sortby,
				@RequestParam(name = "pagenumber", defaultValue = "0", required = false) Integer pagenumber,
				@RequestParam(name = "size", defaultValue = "20", required = false) Integer size)
		{
			
			Page<Pharmacy> pharmacy;

			if(searchtext != null && searchtext != "")
			{
				searchtext = searchtext.toLowerCase();
				pharmacy = (Page<Pharmacy>) service.getAllPharmacyWithSearch(searchtext,sortby,pagenumber,size);

			}
			else
			{
				pharmacy = (Page<Pharmacy>) service.getAllPharmacy(sortby,pagenumber,size);
				
//				pharmacy= repo.findAll(pageable);
				
			}
			
			if(pharmacy==null)
			{
				return new ResponseEntity<Page<Pharmacy>>(pharmacy,HttpStatus.NO_CONTENT);
			}
			else
			{
				return new ResponseEntity<Page<Pharmacy>>(pharmacy,HttpStatus.OK);
			}
		
}
		
		
		@GetMapping("/{pharmacyid}")
		public ResponseEntity<Object> getById(@PathVariable("pharmacyid") Long pharmacyid)
		{
			
			Pharmacy phrm=repo.findBypharmacyid(pharmacyid);
			if(phrm==null)
			{
				return new ResponseEntity<Object>(phrm,HttpStatus.NO_CONTENT);			
			}		
		return new ResponseEntity<Object>(phrm,HttpStatus.OK);
		
	}

	
}
