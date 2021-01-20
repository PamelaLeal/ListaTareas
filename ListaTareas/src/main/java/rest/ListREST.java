package rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ListService.ListService;
import model.ListBD;

@RestController
//URL para mapear
@RequestMapping ("/api/list")
//Cualquier origen de la aplicación
//@CrossOrigin ("*")
public class ListREST {
	
	@Autowired
	private ListService listService;
	
	//Guardar
	@PostMapping
	//Siempre va a pedir que se aun body
	private ResponseEntity<ListBD> save (@RequestBody ListBD list){
		ListBD temporal = listService.create(list);
		
		
		try {
			//Se retorna el valor de temporal para cuardar la lista
			return ResponseEntity.created(new URI("/api/list"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Retortar cosas
	@GetMapping
	private ResponseEntity<List<ListBD>> all (){
		return ResponseEntity.ok(listService.getAllList());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> delete (@RequestBody ListBD list){
		listService.delete(list);
		return ResponseEntity.ok().build();
	}
	
	//Este get va a recibir un id
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<ListBD>> listarTareasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(listService.findById(id));
	} 

}
