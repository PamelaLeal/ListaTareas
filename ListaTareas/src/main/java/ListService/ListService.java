package ListService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import model.ListBD;
import repository.ListRepository;

@Service
public class ListService {
	
	//Decirle al servicio que esta conectado y esta usando la BD y los objetos
	@Autowired
	private ListRepository listRepository;
	
	//Crear una tarea
	public ListBD create(ListBD list) {
		return listRepository.save(list);
	}
	
	public List<ListBD> getAllList(){
		return listRepository.findAll();
		
	}
	
	//no retorna valor
	public void delete(ListBD list) {
		listRepository.delete(list);
	}
	
	public Optional<ListBD> findById(long id){
		
		return listRepository.findById(id);
		
	}

}
